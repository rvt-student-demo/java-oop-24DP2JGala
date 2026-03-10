package rvt;

import java.util.*;
import java.io.*;
import java.nio.file.Paths;

public class TodoList {
    private ArrayList<String> tasks;
    private final String filePath = "src/main/java/rvt/todo.csv";

    public TodoList() {
        this.tasks = new ArrayList<>();
        this.loadFromFile();
        
    }

    private void loadFromFile() {
        try(Scanner reader = new Scanner(Paths.get(filePath))) {

            String line;
            String[] splitedLine;

            reader.nextLine();

            while (reader.hasNextLine()) {

                line = reader.nextLine();
                splitedLine = line.split(",");

                tasks.add(splitedLine[1]);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    private int getLastId() {
        String lastLine;
        String[] splitedLastLine;

        try (Scanner reader = new Scanner(Paths.get(filePath))) {

            for (int i = 1; i <= this.tasks.size(); i++) {
                reader.nextLine();

            }

            lastLine = reader.nextLine();
            splitedLastLine = lastLine.split(",");

            return Integer.valueOf(splitedLastLine[0]); // Exception nostrādās te, kad mūsu ArrayList size būs 0, kā dēļ splitedLastLine[0] = id, kā dēļ šo nevarēs konvertēt par integeru

        } catch (Exception e) {
            return 0;

        }

    }

    private void updateFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("id,task");

            int i = 1;
            for (String task: tasks) {
                bw.newLine();
                bw.write(i + "," + task);

                i++;

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void add(String task) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {

            if (checkEventString(task)) {

                bw.newLine();
                bw.write((getLastId() + 1) + "," + task);

                this.tasks.add(task);

            } else {
                System.out.println("(!) This task is invalid.");
                System.out.println("(!) Your task must have only letters, digits, space and at least 3 symbols in it! >(");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void print() {

        if (tasks.size() == 0) {
            System.out.println("(!) There is no task on the list."); // Netika prasīts, pievienoju no sevīm

        } else {
            for(int i = 0; i < this.tasks.size(); i++) {
            System.out.println(i + 1 + ": " + this.tasks.get(i));

            }

        }

    }

    public void remove(int number) {

        try {
            if (tasks.size() == 0) {
            System.out.println("(!) There is nothing to remove."); // Netika prasīts, pievienoju no sevīm

            } else {
                this.tasks.remove(number - 1);
                this.updateFile();

            }

        } catch (Exception e) {
            System.out.println("(!) There is no such id, or this is just an exception :)");

        }
        
    }

    public boolean checkEventString(String value) {
        
        if (value.length() < 3) {
            return false;

        }

        return value.matches("^[A-Za-z0-9 ]+$");

    }

}