package me.nielcho.jdk8.api;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by daniel on 16/8/11.
 */
public class Streams {

    private enum Status {
        OPEN, CLOSED;
    }

    private static final class Task {
        private final Status status;
        private final Integer points;

        public Task(Status status, Integer points) {
            this.status = status;
            this.points = points;
        }

        public Status getStatus() {
            return status;
        }

        public Integer getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return String.format("[%s,%d]", status, points);
        }
    }

    public static void main(String[] args) {
        final Collection<Task> tasks = Arrays.asList(
                new Task(Status.OPEN, 7),
                new Task(Status.CLOSED, 4),
                new Task(Status.OPEN, 5)
        );
        final int totalPoints = tasks.stream().filter(task -> task.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();
        System.out.println("Total points: " + totalPoints);

        final double totalPoints2 = tasks.stream().parallel().mapToInt(Task::getPoints).sum();
        System.out.println("Total points2: " + totalPoints2);

        final Map<Status,List<Task>> map =
        tasks.stream().collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(map);

        // Calculate the weight of each tasks (as percent of total points)
        final Collection< String > result = tasks
                .stream()                                        // Stream< String >
                .mapToInt( Task::getPoints )                    // IntStream
                .mapToDouble(value -> value / totalPoints2)  // DoubleStream
                .mapToObj( percentage -> (percentage*100) + "%" )      // Stream< String>
                .collect( Collectors.toList() );                // List< String >



        System.out.println(result);

    }


}
