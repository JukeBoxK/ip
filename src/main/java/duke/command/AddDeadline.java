package duke.command;

import duke.util.Parser;
import duke.util.TaskList;
import duke.task.Deadline;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents the Command of adding a new deadline to a task list.
 */
public class AddDeadline extends Command{
    private String description;
    private LocalDateTime date;

    /**
     * Initializes a Command to add a deadline using the input description and date.
     *
     * @param type the type of the command which is deadline.
     * @param description the description of the deadline to be added.
     * @param date the date of the deadline to be added.
     */
    public AddDeadline(Parser.Cmd type, String description, LocalDateTime date){
        super(type);
        this.description = description;
        this.date = date;
    }

    /**
     * Adds a new deadline task to give taskList.
     *
     * @param taskList the given taskList to add the task to.
     */
    @Override
    public void run(TaskList taskList){
        Deadline ddl = new Deadline(this.description, this.date);
        String date = this.date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HHmm"));
        String[] data = {this.description, date};
        taskList.addTask(ddl, "deadline", data);
    }
}
