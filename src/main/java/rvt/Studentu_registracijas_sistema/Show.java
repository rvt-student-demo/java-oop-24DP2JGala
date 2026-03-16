package rvt.Studentu_registracijas_sistema;

import java.util.*;
import java.nio.file.Paths;

public class Show {
    private final String filePath;
    private String longestName = "Vards";
    private String longestSurname = "Uzvards";
    private String longestE_mail = "E-pasts";
    private String longestRegDateAndTime = "Registracijas datums un laiks";

    public Show() {
        filePath = "src/main/java/rvt/Studentu_registracijas_sistema/dati.csv";
        this.findLongestFields();

    }

    private void findLongestFields() {
        try (Scanner reader = new Scanner(Paths.get(filePath))) {

            String line;
            String[] splitedLine;

            String name;
            String surname;
            String e_mail;
            String regDateAndTime;

            while (reader.hasNextLine()) {
                line = reader.nextLine();

                splitedLine = line.split(",");

                name = splitedLine[0];
                surname = splitedLine[1];
                e_mail = splitedLine[2];
                regDateAndTime = splitedLine[4];

                if (this.longestName.length() < name.length()) {

                    if (name.length() % 2 == 0) {
                        this.longestName = name + " ";

                    } else {
                        this.longestName = name;
                        
                    }

                }

                if (this.longestSurname.length() < surname.length()) {
                    if (surname.length() % 2 == 0) {
                        this.longestSurname = surname + " ";

                    } else {
                        this.longestSurname = surname;

                    }
                    
                }

                if (this.longestE_mail.length() < e_mail.length()) {

                    if (e_mail.length() % 2 == 0) {
                        this.longestE_mail = e_mail + " ";

                    } else {
                        this.longestE_mail = e_mail;

                    }
                    
                }

                if (this.longestRegDateAndTime.length() < regDateAndTime.length()) {

                    if (regDateAndTime.length() % 2 == 0) {
                        this.longestRegDateAndTime = regDateAndTime + " ";

                    } else {
                        this.longestRegDateAndTime = regDateAndTime;

                    }
                    
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    private void writeLine() {

        System.out.print("+ ");
        for (int i = 0; i <= 13 / 2; i++) {
            System.out.print("- ");

        }

        System.out.print("+ ");
        for (int i = 0; i <= this.longestName.length() / 2; i++) {
            System.out.print("- ");

        }

        System.out.print("+ ");
        for (int i = 0; i <= this.longestSurname.length() / 2; i++) {
                System.out.print("- ");

        }

        System.out.print("+ ");
        for (int i = 0; i <= this.longestE_mail.length() / 2; i++) {
                System.out.print("- ");

        }

        System.out.print("+ ");
        for (int i = 0; i <= longestRegDateAndTime.length() / 2; i++) {
                System.out.print("- ");

        }

        System.out.println("+");

    }

    public void showInfo() {
        try (Scanner reader = new Scanner(Paths.get(filePath))) {

            this.writeLine();

            System.out.print("| Personas kods");

            System.out.print(" | Vards");
            for (int i = 0; i < longestName.length() - 5; i++) {
                System.out.print(" ");

            }

            System.out.print(" | Uzvards");
            for (int i = 0; i < longestSurname.length() - 7; i++) {
                System.out.print(" ");

            }

            System.out.print(" | E-pasts");
            for (int i = 0; i < longestE_mail.length() - 7; i++) {
                System.out.print(" ");

            }
            
            System.out.print(" | Registracijas datums un laiks");
            for (int i = 0; i < longestRegDateAndTime.length() - 29; i++) {
                System.out.print(" ");

            }

            System.out.println(" |");

            if (reader.hasNextLine()) {

                this.writeLine();

                String line;
                String[] splitedLine;

                String name;
                String surname;
                String e_mail;
                String personal_code;
                String regDateAndTime;

                while (reader.hasNextLine()) {
                    line = reader.nextLine();
                    splitedLine = line.split(",");

                    name = splitedLine[0];
                    surname = splitedLine[1];
                    e_mail = splitedLine[2];
                    personal_code = splitedLine[3];
                    regDateAndTime = splitedLine[4];

                    System.out.print("| " + personal_code);
                    for (int i = 0; i < 13 - personal_code.length(); i++) {
                        System.out.print(" ");

                    }

                    System.out.print(" | " + name);
                    for (int i = 0; i < longestName.length() - name.length(); i++) {
                        System.out.print(" ");

                    }

                    System.out.print(" | " + surname);
                    for (int i = 0; i < longestSurname.length() - surname.length(); i++) {
                        System.out.print(" ");

                    }

                    System.out.print(" | " + e_mail);
                    for (int i = 0; i < longestE_mail.length() - e_mail.length(); i++) {
                        System.out.print(" ");

                    }

                    System.out.print(" | " + regDateAndTime);
                    for (int i = 0; i < longestRegDateAndTime.length() - regDateAndTime.length(); i++) {
                        System.out.print(" ");

                    }

                    System.out.println(" |");

                    this.writeLine();

                }

            } else {
                System.out.println("+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +");
                System.out.println("|                      Nav ievadita neviena lietotaja                       |");
                System.out.println("+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

}