package rvt.Studentu_registracijas_sistema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.*;

public class Remove {
    private final String filePath;
    private ArrayList<String> listOfData;

    public Remove() {
        filePath = "src/main/java/rvt/Studentu_registracijas_sistema/dati.csv";
        listOfData = new ArrayList<>();

    }

    private void updateFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line: listOfData) {
                bw.write(line);
                bw.newLine();

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void remove(String toRemove) {
        if (!(toRemove.matches("^\\d{6}-\\d{5}$"))) {
            System.out.println("(!) Jusu noraditais personas kods ir nederigs, vai ari Jus nepareizi ievadijat \"back\" komandu.");
            System.out.println("(#) Ja Jus centaties ievadit \"back\" komandu, parliecinieties, ka Jus neievadijat atstarpes!\n");

        } else {
            try (Scanner reader = new Scanner(Paths.get(filePath))) {

                String field;
                int beforeTheRemove;
                int afterTheRemove;
                String[] splitedRecord;

                while (reader.hasNextLine()) {
                    listOfData.add(reader.nextLine());

                }

                beforeTheRemove = listOfData.size();

                for (String record: listOfData) {
                    splitedRecord = record.split(",");
                    field = splitedRecord[3];

                    if (field.equals(toRemove)) {
                        listOfData.remove(record);

                        break;
                    }

                }

                afterTheRemove = listOfData.size();

                if (afterTheRemove < beforeTheRemove) {
                    this.updateFile();
                    System.out.println("($) Jus veiksmigi izdzesat lietotaju!\n");

                } else {
                    System.out.println("(!) Nav neviena lietotaja ar noradito personas kodu.\n");

                }

            } catch (Exception e) {
                System.out.println(e.getMessage());

            }

        }

    }

}