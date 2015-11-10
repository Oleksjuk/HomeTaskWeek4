import com.geekhub.hw4.set.SetOperations;
import com.geekhub.hw4.set.SetOperationsImpl;
import com.geekhub.hw4.taskmanager.Task;
import com.geekhub.hw4.taskmanager.TaskManagerImpl;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("set operation:");
        SetOperations setOperations = new SetOperationsImpl();
        Set<Integer> a = new HashSet<>();
        Collections.addAll(a,1,2,3,4,5);
        System.out.println("set A: " + a);
        Set<Integer> b = new HashSet<>();
        Collections.addAll(b,4,5,6,7,8);
        System.out.println("set B: " + b);
        System.out.println("A equal B: "+setOperations.equals(a,b));
        System.out.println("A union B:" + setOperations.union(a,b));
        System.out.println("A subtract B:" +setOperations.subtract(a,b));
        System.out.println("A intersect B:" + setOperations.intersect(a,b));
        System.out.println("A symmetricSubtract B:" + setOperations.symmetricSubtract(a,b));

        System.out.println("task manager:");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        TaskManagerImpl taskManager = new TaskManagerImpl();
        calendar.set(Calendar.HOUR, 6);
        taskManager.addTask(calendar.getTime(), new Task("important", "read Bible"));
        calendar.add(Calendar.HOUR, 4);
        taskManager.addTask(calendar.getTime(), new Task("important", "work on diploma"));
        calendar.add(Calendar.HOUR, 2);
        taskManager.addTask(calendar.getTime(), new Task("important", "home work"));
        calendar.add(Calendar.HOUR, 1);
        taskManager.addTask(calendar.getTime(), new Task("urgent", "call to home"));
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR, 6);
        taskManager.addTask(calendar.getTime(), new Task("urgent", "call to Oleg"));
        calendar.add(Calendar.HOUR, 1);
        taskManager.addTask(calendar.getTime(), new Task("urgent", "go to home"));
        List<Task> tasks;
        for (String category : taskManager.getCategories()){
            tasks = taskManager.getTasksByCategories().get(category);
            tasks.forEach(System.out::println);
        }
        System.out.println("tasks for today:");

        taskManager.getTasksForToday().forEach(System.out::println);

    }
}
