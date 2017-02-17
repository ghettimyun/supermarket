package edu.vt.hokie.main;

import edu.vt.hokie.model.ShoppingCart;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * Main
 *
 * Created by Moses Cho on 2/15/17.
 */
public class App
{
    /**
     * Main
     *
     * @param args Test inputs, if any
     */
    public static void main( String[] args )
    {
        BufferedReader br = null;
        FileReader fr = null;
        ShoppingCart cart = new ShoppingCart();

        if (args.length == 2) {
            setUp(cart, args[1]);
        }
        else {
            setUp(cart);
        }

        try {
            if (args.length > 0) {
                fr = new FileReader(args[0]);
                br = new BufferedReader(fr);
            }
            else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            System.out.println("-----------\nWelcome to the Supermarket\n-----------");
            System.out.println("Enter HELP for a list of commands\n");
            System.out.println("\n-----------");
            System.out.print("Enter a command : ");
            String input = br.readLine();

            while (true) {
                String[] inputs = input.split(" ");
                String command = inputs[0];
                System.out.println("Input : " + input.toUpperCase());
                System.out.println("-----------");

                // Calculate totals and exit
                if (command.equalsIgnoreCase("checkout")) {
                    System.out.println("\nFINAL SALE : ");
                    System.out.println("-----------");
                    cart.printCartAndSubtotal();
                    System.out.println("-----------");
                    System.out.println("\nTHANK YOU!");
                    break;
                }
                // Prints out cart and subtotal
                else if (command.equalsIgnoreCase("cart")) {
                    System.out.println("\nCART : ");
                    System.out.println("-----------");
                    cart.printCartAndSubtotal();
                }
                // Prints out prices of items
                else if (command.equalsIgnoreCase("prices")) {
                    System.out.println("\nINVENTORY AND PRICES : ");
                    System.out.println("-----------");
                    cart.prices();
                }
                // Prints out sales of items
                else if (command.equalsIgnoreCase("sales")) {
                    System.out.println("\nONGOING SALES : ");
                    System.out.println("-----------");
                    cart.sales();
                }
                // Adding items
                else if (command.equalsIgnoreCase("add")) {
                    if (inputs.length > 1 && inputs.length < 4) {
                        String item = inputs[1].toUpperCase();
                        Integer quantity;

                        if (inputs.length == 3 && StringUtils.isNumeric(inputs[2])) {
                            quantity = Integer.parseInt(inputs[2]);
                        }
                        else {
                            quantity = 1;
                        }

                        System.out.println("Adding " + quantity + " " + item + "(S).");
                        cart.addItem(item, quantity);
                    }
                    else {
                        System.out.println("Invalid Parameters.");
                        System.out.println("To add, input: Add [Item] [Quantity]");
                    }
                }
                // Removing items
                else if (command.equalsIgnoreCase("remove")) {
                    if (inputs.length > 1 && inputs.length < 4) {
                        String item = inputs[1].toUpperCase();
                        Integer quantity;

                        if (inputs.length == 3 && StringUtils.isNumeric(inputs[2])) {
                            quantity = Integer.parseInt(inputs[2]);
                        }
                        else {
                            quantity = 1;
                        }

                        System.out.println("Removing " + quantity + " " + item + "(S).");
                        cart.removeItem(item, quantity);
                    }
                    else {
                        System.out.println("Invalid Parameters.");
                        System.out.println("To remove, input: Remove [Item] [Quantity]");
                    }
                }
                // Help
                else if (command.equalsIgnoreCase("help")) {
                    help();
                }
                // Invalid command
                else {
                    System.out.println("Invalid Command");
                    System.out.println("Enter HELP for a list of commands\n");
                }

                System.out.println("\n-----------");
                System.out.print("Enter a command : ");
                input = br.readLine();
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("Invalid File");
            ex.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            closeOut(br, fr);
        }

    }

    /**
     * Sets up a cart with a predetermined setup file
     *
     * @param cart The cart
     */
    private static void setUp(ShoppingCart cart) {
        setUp(cart, "src/main/java/edu/vt/hokie/inputs/setup.txt");
    }

    /**
     * Sets up a cart with a custom setup file
     *
     * @param cart The cart
     * @param fileName The setup file name
     */
    private static void setUp(ShoppingCart cart, String fileName) {
        BufferedReader br = null;
        FileReader fr = null;

        try {
            String currLine;
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            while ((currLine = br.readLine()) != null) {
                String[] inputs = currLine.split(" ");
                String command = inputs[0];

                if (command.equalsIgnoreCase("PRICE")) {
                    cart.initializeItem(inputs[1].toUpperCase(), Double.parseDouble(inputs[2]));
                }
                else if (command.equalsIgnoreCase("SALE")) {
                    cart.applySale(inputs[1].toUpperCase(), inputs[2].toUpperCase());
                }
            }

            closeOut(br, fr);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            closeOut(br, fr);
        }
    }

    /**
     * Prints out available commands
     */
    private static void help() {
        System.out.println("AVAILABLE COMMANDS:\n-----------");
        System.out.println("Adding : Add [Item] [Quantity]");
        System.out.println("Removing : Remove [Item] [Quantity]");
        System.out.println("View Cart : Cart");
        System.out.println("View Prices : Prices");
        System.out.println("View Sales : Sales");
        System.out.println("See Commands : Help");
    }

    /**
     * Closes out io
     *
     * @param br Buffered Reader
     * @param fr File Reader
     */
    private static void closeOut(BufferedReader br, FileReader fr) {
        try {
            if (br != null) {
                br.close();
            }

            if (fr != null) {
                fr.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
