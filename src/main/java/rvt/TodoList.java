package rvt;

import java.util.*;
import java.io.*;
import java.nio.file.Paths;

public class TodoList {
    private ArrayList<String> list;
    private final String filePath = "src/main/java/rvt/todo.csv";
    
    public TodoList() {
        this.list = new ArrayList<>();
        loadFromFile();

    }

    // PRIVATE metodes: >

    private void loadFromFile() {
        try (Scanner reader = new Scanner(Paths.get(filePath))) {

            while (reader.hasNextLine()) {
                list.add(reader.nextLine());

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    private int getLastId() {
        int vertiba = 0;
        try  (Scanner reader = new Scanner(Paths.get(filePath))) {

            reader.nextLine();
            while (reader.hasNextLine()) {
                vertiba++;
                reader.nextLine();

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        String x = list.get(vertiba);
        String[] masivsX = x.split(",");

        return Integer.valueOf(masivsX[0]);

    }

    private void updateFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            String x;
            String[] masivsX;

            for (int i = 0; i < list.size(); i++) {
                x = list.get(i);
                if (i == 0) {
                    bw.write(x);
                    bw.newLine();

                } else {
                    masivsX = x.split(",");

                    bw.write(i + "," + masivsX[1]);
                    if (i == list.size() - 1) break;
                    bw.newLine();

                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    // PUBLIC metodes: >

    public void add(String task) {
        this.list.add(task);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath), true))) {
            bw.newLine();
            bw.write(getLastId() +1 + "," + task);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void print() {
        int i = 1;
        for (String tasks: list) {

            System.out.println(i+ ": " + tasks);
            i++;

        }

    }

    public void remove(int number) {
        list.remove(number);
        updateFile();

    }

}
