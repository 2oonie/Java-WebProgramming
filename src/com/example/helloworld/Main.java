package com.example.helloworld;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int numRows = 10;
    static int numCols = 10;
    static String[][] grid = new String[numRows][numCols];

    public static void main(String[] args) {
        System.out.println("**** Welcome to the Ship Simulation  ****");
        System.out.println("Right now, the world is empty\n");

        printMap();

        //Asking number of ships that the player wants
        int numSpaceShips;
        System.out.print("\nEnter number of spaceships (1-9): ");
        Scanner userInput = new Scanner(System.in);
        numSpaceShips = userInput.nextInt();
        userInput.nextLine();
        //Array for # of ships
        ArrayList<SpaceShip> spaceships = new ArrayList<SpaceShip>(numSpaceShips);
        //Input the # of ships until it reaches what the user want
        for (int i = 0; i < numSpaceShips; ++i) {
            //Asks for name, year, and type for the ship
            System.out.print("Enter SpaceShip " + (i + 1) + "'s name: ");
            String spaceshipName = userInput.next();
            userInput.nextLine();
            System.out.print("Enter the year, " + spaceshipName + " was made: ");
            int year = userInput.nextInt();
            userInput.nextLine();
            System.out.print("Enter the type of SpaceShip: (1: Cargo or 2: Pirate): ");
            int type = userInput.nextInt();
            userInput.nextLine();
            if (type == 1) {
//					System.out.println("Cargo Ship Constructor");
                spaceships.add(new CargoShip(spaceshipName, year));
            } else if (type == 2) {
//					System.out.println("Pirate Ship Constructor");
                spaceships.add(new PirateShip(spaceshipName, year));
            } else {
                System.out.print("Invaild Input!!!");
            }

        }

        //display the ships on a 10x10 grid
        deploySpaceShips(spaceships);
        //display the status of the ship
        displayShipStatus(spaceships);
        //string for menu
        String menu = "1. Move Ship.\n" +
                "2. Change Ship Type.\n" +
                "3. Quit\n";
        boolean isRunning = true;
        while (isRunning) {
            for (SpaceShip spaceship : spaceships) {
                deploySpaceShips(spaceships);
                displayShipStatus(spaceships);
                //Print the status
                System.out.print(spaceship.toString());

                //Do an action
                //Print options
                System.out.print(menu);

                int selection = -1;
                selection = userInput.nextInt();
                switch (selection) {
                    case 1:
                        spaceship.moveShip();
                        break;
                    case 2:
                        System.out.println(spaceship.toString());
                        System.out.print("Enter the type of SpaceShip: (1: Cargo or 2: Pirate): ");
                        int type = userInput.nextInt();
                        userInput.nextLine();
                        if (type == 1) {
                            spaceship.setType("C");
                        } else if (type == 2) {
                            spaceship.setType("P");
                        } else {
                            System.out.print("Invaild Input!!!");
                        }
                        break;
                    case 3:
                        System.out.println("Quitting...\nDone.");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid Selection.");
                        break;
                }
            }
        }
    }

    //Create a map
    public static void printMap() {
        //First section of Map
        System.out.print("    ");
        for (int i = 0; i < numCols; i++) {
            if (i < 9) {
                System.out.print("0" + (i + 1) + " ");
            } else {
                System.out.print((i + 1) + " ");
            }
        }

        System.out.println();

        //Middle section of Map
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == null) {
                    grid[i][j] = "   ";
                }
                if (j == 0) {
                    if (i < 9) {
                        System.out.print("0" + (i + 1) + "|");
                    } else {
                        System.out.print((i + 1) + "|");
                    }
                    System.out.print(grid[i][j]);
                }
                else if (j == grid[i].length - 1) {
                    System.out.print(grid[i][j]);
                    if (i < 9) {
                        System.out.print("| 0" + (i + 1));
                    } else {
                        System.out.print("| " + (i + 1));
                    }
                }
                else {
                    System.out.print(grid[i][j]);
                }
            }

            System.out.println();
        }

        //Last section of Map
        System.out.print("    ");
        for (int i = 0; i < numCols; i++) {
            if (i < 9) {
                System.out.print("0" + (i + 1) + " ");
            } else {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();

    }

    //Displays the coordinate of the ships
    public static void deploySpaceShips(ArrayList<SpaceShip> spaceships) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = "   ";
            }
        }
        System.out.println("\nDeploying the ships:");
        int numSpaceShips = spaceships.size();
        //Input # of ships and runs until it reaches the # of ships
        for (int i = 0; i < numSpaceShips; i++) {
            //Random x and y values
            int x = spaceships.get(i).getX();
            int y = spaceships.get(i).getY();

            //displays the location of (x,y) for each ships
            // if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
            // {
            grid[x][y] = " " + spaceships.get(i).getType() + " ";
            System.out.println("Ship " + (i + 1) + " DEPLOYED at coordinate: " + "(" + x + "," + y + ")");
            // }
        }
        //display the location in the printOceanMap
        printMap();
    }

    //Calls the toString for the Cargo and Pirate subclass
    public static void displayShipStatus(ArrayList<SpaceShip> spaceships) {
        int numSpaceShips = spaceships.size();
        System.out.println("\nShip Data:");
        //Displays the # of ships, that was asked
        for (SpaceShip spaceship : spaceships) {
            System.out.println(spaceship.toString());
        }
    }

}


