package rvt;
import java.util.*;

public class MainProgram {
    public static void main(String[] args) {
    
        TodoList list = new TodoList();
        Scanner scanner = new Scanner(System.in);

        UserInterface interFace = new UserInterface(list, scanner);
        interFace.start();
        
        
    }

}