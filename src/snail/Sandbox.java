package snail;

import java.io.*;
import javax.swing.JOptionPane;

public class Sandbox {

    char[][] board;
    int row, column;
    char direction[];
    int steps[];
    char content[];
    String name;
    boolean firstRun;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Sandbox() {
        this(1, 1);
        this.board = new char[10][10];
    }

    public Sandbox(int row, int column) {                                       // Initialize the Sandbox
        this.board = new char[10][10];
        this.row = --row;
        this.column = --column;
    }

    //starting point
    public void populate(char direction[], int steps[], char content[], char startContent, int length) {
        firstRun(startContent, length);

        for (int i = 0; i < length; i++) {                                      // Iterate over the direction array
            switch (direction[i]) {                                              // Checks what direction the snail will face
                case 'r':
                case 'R':                                           // checks right
                    for (int j = 0; j < steps[i]; j++) {                        // Iterate over the steps array
                        column++;                                               // go 1 step right
                        board[row][column] = content[i];        // Place content on each step carried out
                    }
                    break;
                case 'l':
                case 'L':                                           // checks left
                    for (int j = 0; j < steps[i]; j++) {
                        column--;                                               // go 1 step left
                        board[row][column] = content[i];
                    }
                    break;
                case 'u':
                case 'U':                                           // checks up
                    for (int j = 0; j < steps[i]; j++) {
                        row--;                                                  // go 1 step up
                        board[row][column] = content[i];
                    }
                    break;
                case 'd':
                case 'D':                                           // checks down
                    for (int j = 0; j < steps[i]; j++) {
                        row++;                                                  // go 1 step down
                        board[row][column] = content[i];
                    }
                    break;
            }
            System.out.println("\n");
            System.out.println("**********************************");
            System.out.println("\t   Step " + (i + 1) + " of " + length);
            System.out.println("Direction: " + Character.toUpperCase(direction[i])
                             + " Steps: " + steps[i]
                             + " Content: " + content[i]);
            System.out.println("**********************************");
            print();
        }

        firstRun = false;
    }

    public void firstRun(char startContent, int length) {
        if (firstRun == true) {                                                 // Checks if this is first run of the program
            board[row][column] = startContent;                // If true, place content on starting point
            //System.out.println("\n");
            System.out.println("*******************************");
            System.out.println("Step 0 of " + length);
            System.out.println("Place initial value '" + startContent + "' on starting point");
            System.out.println("*******************************");
            print();
        }
    }

    public void print() {                                                       // Print the board
        System.out.println("    1  2  3  4  5  6  7  8  9  0");
    	System.out.println("  O------------------------------O");
    	
        for(int i = 0; i < 10; i++){
            //System.out.print((i==9?0:i+1)+" |");
            
            for(int j = 0; j < 10; j++){
                if (board[i][j] == '\0') {
                    board[i][j] = ' ';                                          // Initialize the cell
                }
            	System.out.print(" "+board[i][j]+" ");                        // display the content of cell board
            }
            
            System.out.print("|\n");                                            // go to next line
        }
        
        System.out.println("  O------------------------------O\n");
    }

    public boolean checkTutorial() {
        int answer = JOptionPane.showConfirmDialog(null, "Want to know how to use the program?",
                "Tutorial", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return answer == JOptionPane.YES_OPTION;
    }

    public void printTutorial() {
        System.out.println("\n\t\t   HOW TO USE THE PROGRAM\n");
        System.out.println("Generate a snail trail by entering a series of commands.");
        System.out.println("A 'command' is made up of 3 parts: a direction, the number of steps and the content or character to be placed.");
        System.out.println("From your chosen starting point, the snail turns and goes to another position based on the specified direction"
                + " and the number of steps.");
        System.out.println("\nThe snail continues to travel around the sandbox until all the directions are exhausted.");

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
    }

    public void printWelcome() {
        System.out.println("\t\t***************************");
        System.out.println("\t\t*                         *");
        System.out.println("\t\t* SNAIL SANDBOX SIMULATOR *");
        System.out.println("\t\t*                         *");
        System.out.println("\t\t***************************");

        if (checkTutorial()) {
            printTutorial();
        }
        System.out.println("Let's continue then.");
    }

    public int getRow() {
        int rw = 0;
        System.out.print("Enter Start Point Row (1-10 only): ");
        try {
            rw = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input!");
        }
        return rw;
    }

    public int getColumn() {
        int col = 0;
        System.out.print("Enter Start Point Column (1-10 only): ");
        try {
            col = Integer.parseInt(reader.readLine());

        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input!");
        }
        return col;
    }
}
