public class Ui {
    private String logo = "\t  __   __    ____  ____  ____  ____\n"
            + "\t / _\\ (  )  (  __)(  _ \\(  __)(    \\\n"
            + "\t/    \\/ (_/\\ ) _)  )   / ) _)  ) D (\n"
            + "\t\\_/\\_/\\____/(__)  (__\\_)(____)(____/\n";
    private final String name = "Alfred";
    private static void printMessageWithLines(String content){
        System.out.println("\t____________________________________________________________");
        System.out.println("\t" + content);
        System.out.println("\t____________________________________________________________\n" );
    }
    public void greet(){
        System.out.println(logo);
        String message = "Greetings! I am " + name + "." +"\n\tHow may I be of service to you today?";
        printMessageWithLines(message);
    }
    public static void leave() {
        String message = "Farewell. Wishing for the opportunity to meet you again soon.";
        printMessageWithLines(message);
    }
    public static void informInvalidCommand(){
        String message = "I regret to inform you that I currently lack an understanding of the intended meaning behind"
                + "that statement.";
        printMessageWithLines(message);
    }
    public static void informBadTodoInput(){
        String message = "It is imperative that the description of a to-do is not left empty.";
        printMessageWithLines(message);
    }
    public static void informBadDeadlineInput(){
        String message = "It is imperative that the description and the date of a deadline is not left empty.";
        printMessageWithLines(message);
    }
    public static void informBadEventInput(){
        String message = "It is imperative that the description and from-to information of an event is not left empty.";
        printMessageWithLines(message);
    }
    public static void informListMarked(Task task){
        String message = "It is my pleasure to inform you that I have officially marked this particular task as"
                +" 'completed':" + "\n\t   " + task;
        printMessageWithLines(message);
    }
    public static void informListUnmarked(Task task){
        String message = "I wish to communicate that I have marked this particular task as 'incomplete' at this "
                +"juncture:"+ "\n\t   " + task;
        printMessageWithLines(message);
    }
    public static void informItemAdded(Task task, TaskList taskList){
        String message = "I am pleased to convey that the following task has been added to the outlined list:\n" +
                "\t   "+task + "\n " + taskList;
        printMessageWithLines(message);
    }
    public static void displayFullList(TaskList taskList){
        if (taskList.getSize() > 0) {
            taskList.showList();
        } else {
            String message = "I would like to inform you that the task list is empty.";
            printMessageWithLines(message);
        }
    }
    public static void informItemRemoved(Task task, int size){
        String message = "I acknowledge your update. The specified task has been duly removed:\n" + task + "Currently, " +
                "the list comprises  " + size + " tasks.";
    }

}