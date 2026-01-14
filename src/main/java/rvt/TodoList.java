package rvt;

import java.util.ArrayList;

public class TodoList {
    ArrayList<String> list = new ArrayList<>();
    
    public TodoList() {

    }

    public void add(String task) {
        list.add(task);

    }

    public void print() {
        int i = 1;
        for (String tasks: list) {

            System.out.println(i+ ": " + tasks);
            i++;

        }

    }

    public void remove(int number) {
        list.remove(--number);

    }

}
