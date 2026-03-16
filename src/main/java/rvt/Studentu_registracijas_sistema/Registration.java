package rvt.Studentu_registracijas_sistema;

import java.util.*;
import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class Registration {
    private final String filePath;
    private String name;
    private String surname;
    private String e_mail;
    private String personal_code;

    public Registration() {
        filePath = "src/main/java/rvt/Studentu_registracijas_sistema/dati.csv";

    }

    public boolean isNotAcceptableTo(String text) {

        try {
            String[] splitedText = text.split(",");

            this.name = splitedText[0];
            this.surname = splitedText[1];
            this.e_mail = splitedText[2];
            this.personal_code = splitedText[3];

            if (!(this.name.matches("^[A-Za-z]+$"))) {

                System.out.println("(!) Ievaditais vards ir nederigs.");
                System.out.println("(#) Parliecinieties, ka Jusu ievaditais vards satur tikai burtus un ta garums ir vismaz viens simbols!\n");
                return true;
            }

            if (!(this.surname.matches("^[A-Za-z]+$"))) {

                System.out.println("(!) Ievaditais uzvards ir nederigs.");
                System.out.println("(#) Parliecinieties, ka Jusu ievaditais uzvards satur tikai burtus un ta garums ir vismaz viens simbols!\n");
                return true;
            }

            if (!(this.e_mail.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"))) {

                System.out.println("(!) Ievaditais e-pasts ir nederigs.\n");
                return true;
            }

            if (!(this.personal_code.matches("^\\d{6}-\\d{5}$"))) {

                System.out.println("(!) Jusu noraditais personas kods ir nederigs.\n");
                return true;
            }

            try (Scanner reader = new Scanner(Paths.get(filePath))) {

                String line;
                String[] splitedLine;
                String existEmail;
                String existPersonal_code;

                while (reader.hasNextLine()) {
                    line = reader.nextLine();

                    splitedLine = line.split(",");

                    existEmail = splitedLine[2];
                    existPersonal_code = splitedLine[3];

                    if (this.e_mail.equals(existEmail)) {

                        System.out.println("(!) Noraditais e-pasts ir aiznemts.");
                        System.out.println("(#) Ievadiet citu e-pastu!\n");
                        return true;
                    }

                    if (this.personal_code.equals(existPersonal_code)) {

                        System.out.println("(!) Noraditais personas kods jau eksiste.\n");
                        return true;
                    }

                }

            } catch (Exception e) {
            System.out.println(e.getMessage());

            }

            return false;

        } catch (Exception e) {
            System.out.println("(!) Jus nenoradijat visus datus par lietotaju vai Jusu komanda \"back\" tika nepareizi uzrakstita.");
            System.out.println("(#) Ja jus centaties iziet ara no registracijas funkcijas, vai ari centaties ievadit datus par lietotaju, parliecinieties, ka Jus neievadijat atstarpes!\n");

            return true;
        }

    }

    public void allowToRegister() {
        LocalDateTime registrationDateAndTime = LocalDateTime.now();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(this.name + ",");
            bw.write(this.surname + ",");
            bw.write(this.e_mail + ",");
            bw.write(this.personal_code + ",");
            bw.write(String.valueOf(registrationDateAndTime));

            bw.newLine();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

}