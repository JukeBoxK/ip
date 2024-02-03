package duke.util;

import duke.task.Task;

import java.util.ArrayList;

/**
 * Represents the list from which the tasks are stored.
 * Handles the operation of modifying the lists.
 */
public class TaskList {
    private ArrayList<Task> listItems;
    private Storage storage = new Storage();

    /**
     * Adds the given task of given type, using given data into the list.
     *
     * @param task the given task.
     * @param type the type of the given task.
     * @param data an array of string of varying size depending on the type of the task being added.
     *             Todos only have o single data for description.
     *             Deadlines have one for description and one for the deadline date and time.
     *             Events have one for description, one for the start date and time and, one for end date and time.
     */
    public void addTask(Task task, String type, String[]data){
        this.listItems.add(task);
        storage.addListStateRecord(type, data);
        Ui.informItemAdded(task, this);
    }

    /**
     * Constructs an instance of TaskList.
     * The listItems field is initialized from the stored data, if any.
     */
    public TaskList(){
        this.listItems = storage.loadTasks();
    }

    /**
     * Displays the details of each task.
     * The process is done using loops to go through all the tasks.
     */
    public void showList(){
        System.out.println("\t____________________________________________________________");
        System.out.println("\tPer your request, I am outlining the tasks from your designated list:");
        int index = 1;
        for (Task item : this.listItems){
            System.out.println("\t" + index + ". " + item);
            index++;
        }
        System.out.println("\t____________________________________________________________\n" );
    }

    /**
     * Marks the task at the given index in the list.
     * @param index the given index of the task to be marked.
     */
    public void markList(int index){
        this.listItems.get(index-1).mark();
        storage.modifyStateRecord(true, index-1);
        Ui.informListMarked(listItems.get(index-1));
    }

    /**
     * Unmarks the task at the given index in the list.
     * @param index the given index of the task to be marked.
     */
    public void unmarkList(int index){
        this.listItems.get(index-1).unmark();
        storage.modifyStateRecord(false, index-1);
        Ui.informListUnmarked(listItems.get(index-1));
    }

    /**
     * Removes the task at the given index in the list.
     * @param index the given index of the task to be marked.
     */
    public void deleteList(int index){
        Task task = listItems.remove(index-1);
        storage.removeListStateRecord( index-1);
        Ui.informItemRemoved(task, listItems.size());
    }

    /**
     * Returns the number of tasks in the list.
     * @return size of the ArrayList storing the list of tasks.
     */
    public int getSize(){
        return this.listItems.size();
    }

    /**
     * Changes the String representation TaskList into showing the number of tasks in the list.
     */
    @Override
    public String toString(){
        return "\tCurrently, the list comprises  " + listItems.size() + " tasks.";
    }

}
