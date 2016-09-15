import java.util.Scanner;
public class Civilization {
    static boolean playing = true;

    public static void main(String[] args) {

      //Establishing variables
        int attacks = 0;
        double gold = 20.5;
        double resources = 30.0;
        int happiness = 10;
        int militaryUnits = 0;
        int techPoints = 0;
        int c = 5;
        String[] cities = new String[c];

        //Prompt the user to input their civilization
        System.out.println("Which civilization do you want to lead?");
        System.out.println("1: American\n2: Zulu\n3: English\n4: Chinese");

        Scanner userCiv = new Scanner(System.in);
        int civilization = userCiv.nextInt();
        System.out.println();
        String leader = "";

        if (civilization == 1) {
            leader = "George Washington";
        } else if (civilization == 2) {
            leader = "Shaka";
        } else if (civilization == 3) {
            leader = "Queen Elizabeth I";
        } else if (civilization == 4) {
            leader = "Wu Zetian";
        } else {
            System.out.println("You entered an invalid civilization");
            playing = false;
        }

        System.out.println("Welcome, " + leader + ".\n");

        System.out.print("Name your first city: ");
        String city1 = userCiv.next();
        String city2 = city1 + userCiv.nextLine();
        cities[0] = city2;
        c--;

        System.out.println();

        //begin game
        while (playing) {
            double tempResources = resources;
            resources++;
            if (happiness >= 20) {
                resources += 5;
            }
            gold += 3 * (cities.length - c);
            if (tempResources % 2 == 0) {
                happiness++;
            } else {
                happiness -= 3;
            }
            System.out.println(" You currently have: ");
            System.out.printf("%20s %-3d\n%20s %-3.2f\n%20s %-3.2f\n%20s "
                              + "%-3d\n%20s %-3d\n%20s %-3d", "Attacks"
                              + ":", attacks, "Gold:", gold, "Resources"
                              + ":", resources, "Happiness:", happiness, "M"
                              + "ilitary Units:", militaryUnits, "Techn"
                              + "ology Points:", techPoints);
            System.out.println("\n");

            System.out.println("You have the following cities:");
            for (int i = 0; i < cities.length - c; i++) {
                System.out.println(cities[i]);
            }
            System.out.println();

            if (attacks == 1) {
                System.out.println("You have attacked 1 cities");
            } else {
                System.out.println("You have attacked " + attacks + " cities"
                                    + ".\n");
            }
            //choose action
            System.out.print("What is your action?\n");
            System.out.println("1: Settle a City (Costs 15.5 Gold)\n2: Demolish"
                + " a City (Gain 1.5 resources)\n3: Build a Militia (Costs 5 "
                + "gold and 3 resources and increases military unit by 1)\n"
                + "4: Research Technology (Costs 50 gold and 2 resources)\n"
                + "5: Attack Enemy City (Costs 6 military units and 3 happiness"
                + " and gains 10 gold)\n6: End Turn");
            Scanner userChoice = new Scanner(System.in);
            int choice = userChoice.nextInt();
            System.out.println();

            //Settle in a city
            if (choice == 1) {
                if (gold >= 15.5) {
                    if  (c == 0) {
                        System.out.println("You reached your limit of 5 "
                                            + "cities.");
                        System.out.println("\nStart new turn.\n");
                    } else if  (c > 0) {
                        System.out.println("Your current list of cities: ");
                        for (int i = 0; i < cities.length - c; i++) {
                            System.out.println(cities[i]);
                        }
                        System.out.println();

                        System.out.print("Please name your new city: ");
                        String city3 = userCiv.next();
                        String city4 = city3 + userCiv.nextLine();
                        cities[cities.length - c] = city4;
                        c--;
                        System.out.println();
                    }
                    gold -= 15.5;
                } else if (gold < 15.5) {
                    System.out.println("You do not have enough gold to settle"
                                        + "in a city.");
                    System.out.println("\nStart new turn.\n");
                }

            //Demolish a city

            } else if (choice == 2) {
                if (cities.length - c > 1) {
                    System.out.println("Which city would you like to "
                                        + "demolish? ");
                    for (int i = 0; i < (cities.length - c); i++) {
                        System.out.println((i + 1) + ": " + cities[i]);
                    }
                    int demChoice = userChoice.nextInt();
                    cities[demChoice - 1] = null;
                    if (demChoice != 5 && cities[demChoice] != null) {
                        for (int i = demChoice - 1; i < cities.length - (c + 1); i++) {
                            cities[i] = cities[i + 1];
                        }
                    }
                    resources -= 1.5;
                    c++;
                } else {
                    System.out.println("You do not have enough cities to demolish city.");
                    System.out.println("\nStart new turn.\n");
                }

            //Build a milita

            } else if (choice == 3) {
                if (gold >= 5 && resources >= 3) {
                    gold -= 5;
                    resources -= 3;
                    militaryUnits++;
                } else {
                    System.out.println("You do not have enough gold or resources, therefore you cannot build a milita and your turn is over");
                    System.out.println("\nStart new turn.\n");
                }

            //Research Technology

            } else if (choice == 4) {
                if (gold >= 50.0 && resources >= 2) {
                    gold -= 50.0;
                    resources -= 2;
                    techPoints++;
                } else {
                    System.out.println("You do not have enough gold or resources, therefore you cannot research technology and your turn is over");
                    System.out.println("\nStart new turn.\n");
                }

            //Attack Enemy City

            } else if (choice == 5) {
                if (militaryUnits >= 6) {
                    militaryUnits -= 6;
                    happiness -= 3;
                    gold += 10;
                    attacks++;
                } else {
                    System.out.println("You do not have enough military units to attack a city.\n");
                    System.out.println("\nStart new turn.\n");
                }

            //End Turn

            } else if (choice == 6) {
                System.out.println("\nStart new turn.\n");
            }

            //You beat the game
            if (techPoints >= 20) {
                System.out.println("Congratulations " + leader + " you have beat the game of civilization!");
                playing = false;
            } else if (attacks >= 10) {
                System.out.println("Congratulations " + leader + " you have beat the game of civilization!");
                playing = false;
            }
        }
    }
}
