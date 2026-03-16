package rvt.Studentu_registracijas_sistema;

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Paths;

public class Edit {

    private final String filePath;
    private String personas_kods;
    private String record;
    private String e_mail;

    public Edit() {
        filePath = "src/main/java/rvt/Studentu_registracijas_sistema/dati.csv";

    }

    public boolean isNotAcceptableTo(String personas_kods) {

        try (Scanner reader = new Scanner(Paths.get(filePath))) {
            if (reader.hasNextLine()) {
                if (!(personas_kods.matches("^\\d{6}-\\d{5}$"))){

                System.out.println("(!) Jusu noraditais personas kods ir nederigs, vai ari Jus nepareizi ievadijat \"back\" komandu.");
                System.out.println("(#) Ja Jus centaties ievadit \"back\" komandu, vai ari centaties ievadit personas kodu, parliecinieties, ka Jus neievadijat atstarpes!\n");

                return true;

                }

                while (reader.hasNextLine()) {
                    String record = reader.nextLine();
                    String[] splitedRecord = record.split(",");

                    if (splitedRecord[3].equals(personas_kods)) {
                        this.personas_kods = personas_kods;
                        this.record = record;
                        this.e_mail = splitedRecord[2];

                        return false;

                    }

                }

                System.out.println("(!) Nav neviena lietotaja ar noradito personas kodu.\n");
                return true;

            } else {
                System.out.println("(!) Pagaidam nav neviena lietotaja, kuru varetu rediget.");
                System.out.println("(#) Pievienojiet lietotaju, lai redigetu ta datus!\n");

                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;

        }

    }

    public String findInfo() {
        return this.record;

    }

    public boolean isNotAcceptableToDoEdit(String record) {

        try {
            
            String[] splitedText = record.split(",");

            String name = splitedText[0];
            String surname = splitedText[1];
            String e_mail = splitedText[2];
            String personal_code = splitedText[3];

            if (!(name.matches("^[A-Za-z]+$"))) {

                System.out.println("(!) Ievaditais vards ir nederigs.");
                System.out.println("(#) Parliecinieties, ka Jusu ievaditais vards satur tikai burtus un ta garums ir vismaz viens simbols!\n");
                return true;
            }

            if (!(surname.matches("^[A-Za-z]+$"))) {

                System.out.println("(!) Ievaditais uzvards ir nederigs.");
                System.out.println("(#) Parliecinieties, ka Jusu ievaditais uzvards satur tikai burtus un ta garums ir vismaz viens simbols!\n");
                return true;
            }

            if (!(e_mail.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"))) {

                System.out.println("(!) Ievaditais e-pasts ir nederigs.\n");
                return true;
            }

            if (!(personal_code.matches("^\\d{6}-\\d{5}$"))) {

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

                    if (e_mail.equals(existEmail)) {

                        if (e_mail.equals(this.e_mail)) continue;

                        System.out.println("(!) Noraditais e-pasts ir aiznemts.");
                        System.out.println("(#) Ievadiet citu e-pastu!\n");
                        return true;

                    }

                    if (personal_code.equals(existPersonal_code)) {

                        if (personal_code.equals(this.personas_kods)) continue;

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
            System.out.println("(#) Redigejot lietotaja datus, Jusu ierakstam ir jaatbilst formatam: vards,uzvards,e-pasts,personas_kods,registracijas_datums_un_laiks");
            System.out.println("    Piemeram: (pirms): vards,uzvards,e-pasts,personas_kods,registracijas_datums_un_laiks");
            System.out.println("              (pec):   vards,jauns_uzvards,e-pasts,jauns_personas_kods,registracijas_datums_un_laiks\n");

            System.out.println("(#) Ja jus centaties iziet ara no sis sadalas, vai ari centaties ievadit datus par lietotaju, parliecinieties, ka Jus neievadijat atstarpes!\n");

            return true;
        }

    }

    public void doEdit(String record) {
        ArrayList<String> listOfData = new ArrayList<>();
        String[] arrayOfListOfData = null;

        try (Scanner reader = new Scanner(Paths.get(filePath))) {
            while (reader.hasNextLine()) {
                listOfData.add(reader.nextLine());

            }

            arrayOfListOfData = new String[listOfData.size()];

            for (int i = 0; i < listOfData.size(); i++) {
                arrayOfListOfData[i] = listOfData.get(i);

                if (arrayOfListOfData[i].equals(this.record)) {
                    arrayOfListOfData[i] = record;

                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < arrayOfListOfData.length; i++) {
                bw.write(arrayOfListOfData[i]);
                bw.newLine();

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

}