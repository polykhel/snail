package snail;

import java.io.*;
import javax.swing.*;

public class Simulate {

    char startContent;
    int numOfElements;

    public void setDiamond() {
        Sandbox dBox = new Sandbox(5, 1);   // starting point row 5, column 1
        dBox.direction = new char[]{'R', 'U', 'R', 'u', 'r', 'u', 'r', 'u', 'r', 'd', 'r', 'd', 'r', 'd', 'r', 'd', 'r', 'd', 'l', 'd', 'l', 'd',
            'l', 'd', 'l', 'd', 'l', 'u', 'l', 'u', 'l', 'u', 'l', 'u', 'l'}; //35 elements
        dBox.steps = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1}; //35
        dBox.content = new char[]{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x',
            'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}; //35
        dBox.firstRun = true;
        startContent = 'x';
        numOfElements = dBox.direction.length;

        dBox.populate(dBox.direction, dBox.steps, dBox.content, startContent, numOfElements);
    }

    public void setSpiral() {
        Sandbox sBox = new Sandbox(5, 6);
        sBox.direction = new char[]{'L', 'D', 'R', 'U', 'L', 'D', 'R', 'U', 'L', 'D'}; // 10 elements
        sBox.steps = new int[]{1, 3, 3, 5, 5, 7, 7, 9, 9, 9};
        sBox.content = new char[]{'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'};
        sBox.firstRun = true;
        startContent = 'o';
        numOfElements = sBox.direction.length;

        sBox.populate(sBox.direction, sBox.steps, sBox.content, startContent, numOfElements);
    }

    public void setFlag() {
        Sandbox fBox = new Sandbox(1, 1);
        fBox.direction = new char[]{'d', 'r', 'd', 'r', 'd', 'r', 'd', 'r', 'r', 'r', 'r', 'r', 'r',
            'd', 'l', 'l', 'l', 'l', 'l', 'l', 'd', 'l', 'd', 'l', 'd', 'l', 'd'}; // 27 elements
        fBox.steps = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1};
        fBox.content = new char[]{' ', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', '#', '#', '#',
            '#', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#'};
        fBox.firstRun = true;
        startContent = '#';
        numOfElements = fBox.direction.length;

        fBox.populate(fBox.direction, fBox.steps, fBox.content, startContent, numOfElements);
    }

    public void setCollage() {
        Sandbox cBox = new Sandbox(1, 1);
        cBox.direction = new char[]{'r', 'd', 'l', 'u', 'r', 'd', 'l', 'u', 'r', 'd', 'l', 'u', 'r', 'd', 'l', 'u', 'r', 'd', 'l'}; // 19 elements
        cBox.steps = new int[]{9, 9, 9, 8, 8, 7, 7, 6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 1, 1};
        cBox.content = new char[]{'x', 'x', 'x', 'x', 'o', 'o', 'o', 'o', 'w', 'w', 'w', 'w', 'c', 'c', 'c', 'c', '*', '*', '*'};
        cBox.firstRun = true;
        startContent = 'x';
        numOfElements = cBox.direction.length;

        cBox.populate(cBox.direction, cBox.steps, cBox.content, startContent, numOfElements);
    }

    public void setRandom() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Sandbox rBox = new Sandbox();
        rBox.printWelcome();
        rBox = new Sandbox(rBox.getRow(), rBox.getColumn());        //initiliaze new starting point based on user input row and column
        rBox.direction = new char[100];
        rBox.steps = new int[100];
        rBox.content = new char[100];
        rBox.firstRun = true;
        int column = rBox.column + 1;
        int row = rBox.row + 1;
        boolean enterMoreCommands = true;
        String command;
        int count = 0;
        char tempDir;
        int tempStep;
        char tempChar;

        System.out.print("Enter Start Point Content: ");
        try {
            startContent = reader.readLine().charAt(0);
        } catch (IOException e) {
            System.out.println("Invalid input!");
        }

        System.out.println("\nO---------------------------------------O");
        System.out.println("| NOTE: A command consists of <D><S><C> |");
        System.out.println("|                                       |");
        System.out.println("| where,                                |");
        System.out.println("|   <D> - direction ('U' up, 'D' down,  |");
        System.out.println("|         'R' right, 'L' left)          |");
        System.out.println("|   <S> - steps (integers '1-9')        |");
        System.out.println("|   <C> - content (characters)          |");
        System.out.println("| EXAMPLE: U5* (5 steps up, place *)    |");
        System.out.println("|                                       |");
        System.out.println("| type \"END\" to stop inputting commands |");
        System.out.println("O---------------------------------------O");

        while (enterMoreCommands == true) {
            try {
                System.out.print("Enter command " + (count + 1) + ": ");
                command = reader.readLine();
                if (command.toLowerCase().equals("end")) {
                    enterMoreCommands = false;
                } else {
                    tempDir = command.toLowerCase().charAt(0);
                    tempStep = Character.getNumericValue(command.charAt(1));
                    tempChar = command.toLowerCase().charAt(2);

                    switch (tempDir) {
                        case 'r':
                        case 'R':
                            if ((tempStep + column) <= 10) {
                                rBox.direction[count] = tempDir;
                                rBox.steps[count] = tempStep;
                                rBox.content[count] = tempChar;
                                count++;
                                column += tempStep;
                                System.out.println("Current row: " + row + " Current column: " + column);
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid input! Snail will move out of bounds.", "Try again", JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                        case 'd':
                        case 'D':
                            if ((tempStep + row) <= 10) {
                                rBox.direction[count] = tempDir;
                                rBox.steps[count] = tempStep;
                                rBox.content[count] = tempChar;
                                count++;
                                row += tempStep;
                                System.out.println("Current row: " + row + " Current column: " + column);
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid input! Snail will move out of bounds.", "Try again", JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                        case 'l':
                        case 'L':
                            if (tempStep < column) {
                                rBox.direction[count] = tempDir;
                                rBox.steps[count] = tempStep;
                                rBox.content[count] = tempChar;
                                count++;
                                column -= tempStep;
                                System.out.println("Current row: " + row + " Current column: " + column);
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid input! Snail will move out of bounds.", "Try again", JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                        case 'u':
                        case 'U':
                            if (tempStep < row) {
                                rBox.direction[count] = tempDir;
                                rBox.steps[count] = tempStep;
                                rBox.content[count] = tempChar;
                                count++;
                                row -= tempStep;
                                System.out.println("Current row: " + row + " Current column: " + column);
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid input! Snail will move out of bounds.", "Try again", JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                    }
                }
            } catch (IOException | StringIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Invalid input!", "WARNING", JOptionPane.WARNING_MESSAGE);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Something's wrong!", "WARNING", JOptionPane.WARNING_MESSAGE);
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Snail moved out of the sandbox!", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        }

        numOfElements = count;

        rBox.populate(rBox.direction, rBox.steps, rBox.content, startContent, numOfElements);

    }
}
