package duke.command;

import duke.util.Parser;
import duke.util.TaskList;
import duke.task.Deadline;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddDeadlineCommand extends Command {
    private String description;
    private LocalDateTime date;
    public AddDeadlineCommand(Parser.Cmd type, String description, LocalDateTime date) {
        super(type);
        this.description = description;
        this.date = date;
    }
    @Override
    public void run(TaskList taskList) {
        Deadline ddl = new Deadline(this.description, this.date);
        String date = this.date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HHmm"));
        String[] data = {this.description, date};
        taskList.addTask(ddl, "deadline", data);
    }
}
