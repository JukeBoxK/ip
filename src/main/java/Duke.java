import java.util.ArrayList;
import java.util.Scanner;
public class Duke {
    private static String name = "Alfred";
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        greet();
        command();
    }

    static ArrayList<Task> listItems = new ArrayList<>();
    public enum Command{
        list, todo, deadline, event, mark, unmark, delete, bye
    }
    public static void command() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals(Command.bye.toString())) {
            String[] cmds = input.split(" ");
            switch(Command.valueOf(cmds[0])) {
                case list:
                    showList();
                    break;
                case mark:
                    markList(Integer.parseInt(cmds[1]));
                    break;
                case unmark:
                    unmarkList(Integer.parseInt(cmds[1]));
                    break;
                case todo:
                    addTodo(input);
                    break;
                case deadline:
                    addDeadline(input);
                    break;
                case event:
                    addEvent(input);
                    break;
                case delete:
                    deleteList(Integer.parseInt(cmds[1]));
                    break;
                default:
                    erroMsg("I regret to inform you that I currently lack an understanding of the intended meaning behind that statement.");
            }
            input = scanner.nextLine();
        }
        exit();
    }
    public static void greet(){
        System.out.println("\t____________________________________________________________");
        System.out.println("\tGreetings! I am " + name +".");
        System.out.println("\tHow may I be of service to you today?");
        System.out.println("\t____________________________________________________________\n");
    }
    public static void exit() {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tFarewell. Wishing for the opportunity to meet you again soon.");
        System.out.println("\t____________________________________________________________\n");
    }
    public static void addList(Task task){
        listItems.add(task);
        System.out.println("\t____________________________________________________________");
        System.out.println("\tI am pleased to convey that the following task has been added to the outlined list:");
        System.out.println("\t   "+task);
        System.out.println("\tCurrently, the list comprises  " + listItems.size() + " tasks.");
        System.out.println("\t____________________________________________________________\n");
    }
    public static void addTodo(String cmd){
        String[] statement = cmd.split(" ", 2);
        try {
            Todo todo = new Todo(statement[1]);
            addList(todo);
        }catch(ArrayIndexOutOfBoundsException e) {
            erroMsg("It is imperative that the description of a to-do is not left empty.");
        }
    }
    public static void addDeadline(String cmd){
        String[] statement1 = cmd.split(" ", 2);
        try {
            String[] statement2 = statement1[1].split(" /by ", 2);
            Deadline ddl = new Deadline(statement2[0], statement2[1]);
            addList(ddl);
        }catch(ArrayIndexOutOfBoundsException e) {
            erroMsg("It is imperative that the description and the date of a deadline is not left empty.");
        }
    }
    public static void addEvent(String cmd){
        String[] statement1 = cmd.split(" ", 2);
        try {
            String[] statement2 = statement1[1].split(" /from ", 2);
            String[] statement3 = statement2[1].split(" /to ", 2);
            Event event = new Event(statement2[0], statement3[0], statement3[1]);
            addList(event);
        }catch(ArrayIndexOutOfBoundsException e) {
            erroMsg("It is imperative that the description and from-to information of an event is not left empty.");
        }
    }
    public static void showList(){
        System.out.println("\t____________________________________________________________");
        System.out.println("\tPer your request, I am outlining the tasks from your designated list:");
        int index = 1;
        for (Task item : listItems){
            System.out.println("\t" + index + ". " + item);
            index++;
        }
        System.out.println("\t____________________________________________________________\n" );
    }
    public static void markList(int index){
        listItems.get(index-1).mark();
        System.out.println("\t____________________________________________________________");
        System.out.println("\tIt is my pleasure to inform you that I have officially marked this particular task as 'completed':");
        System.out.println("\t   " + listItems.get(index-1));
        System.out.println("\t____________________________________________________________\n" );
    }
    public static void unmarkList(int index){
        listItems.get(index-1).unmark();
        System.out.println("\t____________________________________________________________");
        System.out.println("\tI wish to communicate that I have marked this particular task as 'incomplete' at this juncture:");
        System.out.println("\t   " + listItems.get(index-1));
        System.out.println("\t____________________________________________________________\n" );
    }
    public static void erroMsg(String content){
        System.out.println("\t____________________________________________________________");
        System.out.println("\t" + content);
        System.out.println("\t____________________________________________________________\n" );
    }
    public static void deleteList(int index){
        Task task = listItems.remove(index-1);
        System.out.println("\t____________________________________________________________");
        System.out.println("\tI acknowledge your update. The specified task has been duly removed:");
        System.out.println("\t   "+task);
        System.out.println("\tCurrently, the list comprises  " + listItems.size() + " tasks.");
        System.out.println("\t____________________________________________________________\n");
    }

}
