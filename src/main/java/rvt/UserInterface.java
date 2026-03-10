package rvt;

import java.util.*;

public class UserInterface {
    private TodoList toDo_list;
    private Scanner scanner;

    public UserInterface(TodoList toDo_list, Scanner scanner) {
        this.toDo_list = toDo_list;
        this.scanner = scanner;

    }

    public void start() {
        String command;
        String taskToAdd;
        int number;

        while (true){
            System.out.print("Command: " );
            command = this.scanner.nextLine();

            if (command.equals("stop")) break;

            if (command.equals("add")) {
                System.out.print("To add: ");
                taskToAdd = this.scanner.nextLine();

                this.toDo_list.add(taskToAdd);

                System.out.println();
                continue;

            }

            if (command.equals("list")) {
                System.out.println("List of tasks:");
                this.toDo_list.print();

                System.out.println();
                continue;

            }

            if (command.equals("remove")) {
                System.out.print("Which one is removed? : ");
                number = Integer.valueOf(this.scanner.nextLine());

                this.toDo_list.remove(number);

                System.out.println();
                continue;

            }

        }

    }

}