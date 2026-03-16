package rvt.Studentu_registracijas_sistema;

import java.util.*;

public class UserInterFace {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Registration register = new Registration();
        Show show;
        Remove remover;
        Edit editor;

        String command;

        System.out.println();
        while (true) {

            System.out.println("(?) Ko Jus velaties izdarit?\n");

            System.out.println("(*) Registret jauno lietotaju (command: register)");
            System.out.println("(*) Radit visus lietotajus (command: show)");
            System.out.println("(*) Dzest lietotaju (command: remove)");
            System.out.println("(*) Rediget lietotaja datus: (command: edit)");
            System.out.println("(*) Apturet programmu (command: exit)\n");

            System.out.print("Command: ");
            command = scanner.nextLine();

            if (command.equals("register")) {
                System.out.println();

                String line;
                while (true) {

                    System.out.println("+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +\n");
                    System.out.println("(i) Lai registretu jauno lietotaju, ievadiet nepieciesamo informaciju par so lietotaju pec dota formata:");
                    System.out.println("    Format: vards,uzvards,e-pasts,personas_kods");
                    System.out.println("(i) Lai izietu ara no registresanas funkcijas, uzrakstiet komandu: \"back\".\n");
                
                    System.out.print("Write: ");
                    line = scanner.nextLine();

                    if (line.equals("back")) {

                        System.out.println("\n+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +\n");
                        break;
                    }

                    if (register.isNotAcceptableTo(line)) {
                        continue;

                    } else {
                        register.allowToRegister();
                        System.out.println("($) Jus veiksmigi registrejat jaunu lietotaju!\n");

                    }

                }

            }

            if (command.equals("show")) {
                System.out.println();

                show = new Show();
                String commandToExit;

                while (true) {
                    System.out.println("+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +\n");

                    System.out.println("Informacija par visiem lietotajiem:");
                    show.showInfo();

                    System.out.println("\n(i) Ja Jus velaties iziet ara no sis funkcijas, uzrakstiet komandu \"back\".");
                    System.out.print("Command: ");
                    commandToExit = scanner.nextLine();

                    if (commandToExit.equals("back")) {
                        System.out.println("\n+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +\n");
                        break;

                    } else {
                        System.out.println("(!) Jusu komanda \"back\" ne tika pareizi uzrakstita.");
                        System.out.println("(#) Parliecinieties, ka Jus neievadijat atstarpes!\n");
                    }
                    
                }


            }

            if (command.equals("remove")) {
                System.out.println();

                String line;

                while (true) {
                    System.out.println("+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +\n");

                    System.out.println("(i) Lai izdzestu lietotaju, Jums ir janorada ta personas kods (visu informaciju par lietotajiem Jus varat apskatit \"show\" sadala).");
                    System.out.println("(i) Ja Jus velaties iziet ara no sis funkcijas, uzrakstiet komandu \"back\".");
                    System.out.println("(?) Kuru lietotaju Jus velaties izdzest?\n");

                    System.out.print("Write: ");
                    line = scanner.nextLine();

                    if (line.equals("back")) {
                        System.out.println("\n+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +\n");
                        break;

                    }

                    remover = new Remove();
                    remover.remove(line);

                }

            }

            if (command.equals("edit")) {
                System.out.println();

                String line;
                while (true) {
                    editor = new Edit();

                    System.out.println("+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +\n");

                    System.out.println("(i) Lai redigetu lietotaja datus, noradiet ta personas kodu!");
                    System.out.println("(i) Ja Jus velaties iziet ara no sis funkcijas, uzrakstiet komandu \"back\".");
                    System.out.println("(?) Kuru lietotaju Jus velaties rediget?\n");

                    System.out.print("Write: ");
                    line = scanner.nextLine();

                    if (line.equals("back")) {
                        System.out.println("\n+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +\n");
                        break;

                    }

                    if (editor.isNotAcceptableTo(line)) {
                        continue;

                    }

                    System.out.println();

                    while (true) {
                        System.out.println("+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +\n");

                        System.out.println("(i) Lai redigetu datus par so lietotaju, parrakstiet ta datus (kuri ir doti zemak), izmainot tikai tos datus, kururs Jus velaties izmainit.");
                        System.out.println("(#) Lietotaja dati: " + editor.findInfo());

                        System.out.println("\n(i) Ja Jus velaties iziet ara no sis sadalas, uzrakstiet komandu \"back\".\n");
                        System.out.print("Write: ");
                        String secondLine = scanner.nextLine();

                        if (secondLine.equals("back")) {
                            System.out.println();
                            break;

                        }

                        if (editor.isNotAcceptableToDoEdit(secondLine)) {
                            continue;

                        }

                        editor.doEdit(secondLine);
                        System.out.println("($) Jus veiksmigi redigejat datus noraditajam lietotajam!\n");

                    }

                }

            }

            if (command.equals("exit")) {

                System.out.println("($) Jus veiksmigi izgajat ara no programmas!\n");
                break;
            }

            if (!(command.equals("register") || command.equals("show") || command.equals("remove") || command.equals("edit") || command.equals("exit"))) {

                System.out.println("(!) Izskatas, ka Jus ievadijat nepareizo komandu.");
                System.out.println("(#) Pameginiet velreiz!\n");

                System.out.println("+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +\n");

                continue;
            }

        }

    }

}