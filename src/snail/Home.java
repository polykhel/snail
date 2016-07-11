package snail;

import javax.swing.JOptionPane;
import java.io.*;

public class Home {

    public static void main(String[] args) throws IOException {
        Simulate call = new Simulate();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] options = {"Diamond", "Spiral", "Flag", "Collage", "Random", "Exit"};
        JOptionPane.showMessageDialog(null, "Welcome to Group 2's Snail Sandbox Simulator!", "Team F4", JOptionPane.INFORMATION_MESSAGE);

        do {
            try {
                String clicked = (String) JOptionPane.showInputDialog(null, "Choose an option", "Snail Sandbox Simulator",
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (clicked == null) {
                    JOptionPane.showMessageDialog(null, "Sorry, try again next time.");
                    break;
                }
                switch (clicked) {
                    case "Diamond":
                        JOptionPane.showMessageDialog(null, "Diamond trail selected.");
                        call.setDiamond();
                        break;
                    case "Spiral":
                        JOptionPane.showMessageDialog(null, "Spiral trail selected.");
                        call.setSpiral();
                        break;
                    case "Flag":
                        JOptionPane.showMessageDialog(null, "Flag trail selected.");
                        call.setFlag();
                        break;
                    case "Collage":
                        JOptionPane.showMessageDialog(null, "Collage trail selected.");
                        call.setCollage();
                        break;
                    case "Random":
                        JOptionPane.showMessageDialog(null, "Random trail selected.");
                        call.setRandom();
                        break;
                    case "Exit":
                        if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
                                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Thank you!");
                            System.exit(0);
                        }
                        break;
                    default:
                        break;
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Something's wrong!", "WARNING", JOptionPane.WARNING_MESSAGE);
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Snail moved out of the sandbox!", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
            
            System.out.println("\nPress enter to continue...");
            reader.readLine();
            if (JOptionPane.showConfirmDialog(null, "Try again?", "WARNING", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Thank you!");
                break;
            }

        } while (true);
    }
}
