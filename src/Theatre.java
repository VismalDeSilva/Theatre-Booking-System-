import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;

public class Theatre {
    // Initialize seating arrays
    static int[] row1 = new int[12];  //
    static int[] row2 = new int[16];
    static int[] row3 = new int[20];

    static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    public static int row;  //

    public static int seat;

    public static void main(String[] args) {
        System.out.println("Welcome to the New Theatre!");
        System.out.println("-------------------------------------------");
        while (true) {

            Scanner input = new Scanner(System.in);  //

            while (true) {  //
                // Print menu
                try {
                    System.out.println("\nPlease select an option:");
                    System.out.println("1) Buy a ticket");
                    System.out.println("2) Print seating area");
                    System.out.println("3) Cancel ticket");
                    System.out.println("4) List available seats");
                    System.out.println("5) Save to file");
                    System.out.println("6) Load from file");
                    System.out.println("7) Print ticket information and total price");
                    System.out.println("8) Sort tickets by price");
                    System.out.println("0) Quit");
                    System.out.println("-------------------------------------------");
                    System.out.println("\nEnter an option:");
                    // Get user input
                    int option = input.nextInt();  //

                    // Call appropriate method based on user input
                    switch (option) {    //
                        case 0:
                            System.out.println("Exiting program...");
                            System.exit(0);
                            break;
                        case 1:
                            buyTicket();  //
                            break;
                        case 2:
                            printSeatingArea();
                            break;
                        case 3:
                            cancelTicket();
                            break;
                        case 4:
                            listAvailableSeats();
                            break;
                        case 5:
                            saveToFile();
                            break;
                        case 6:
                            loadFromFile();
                            break;
                        case 7:
                            printTicketInfo();
                            break;
                        case 8:
                            sortTickets();
                            break;
                        default:
                            System.out.println("Invalid input. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("please enter 0-8");
                    break;
                }
            }
        }
    }
    public static void buyTicket() {
        Scanner input = new Scanner(System.in);
        int row = 0;
        int seat = 0;

        while (true) {
            try {
                System.out.println("Enter row number (1-3):");
                row = input.nextInt();
                if (row < 1 || row > 3) {
                    System.out.println("Row number out of range (1-3)");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("not str get num");
                input.next();
            }
        }

        while (true) {
            try{
            System.out.println("Enter seat number:");
            seat = input.nextInt();
            if ((row == 1 && (seat < 1 || seat > 11)) ||
                    (row == 2 && (seat < 1 || seat > 15)) ||
                    (row == 3 && (seat < 1 || seat > 21))) {
                System.out.println("Out of range");
            }  else {
                break;
            }
        }catch (InputMismatchException e){
                System.out.println("not str valid num");
                input.next();
            }
        }
        switch (row) {
            case 1:
                if (row1[seat - 1] == 1) {
                    System.out.println("Seat already occupied. Please select a different seat.");
                    return;
                } else {
                    row1[seat - 1] = 1;
                    break;
                }
            case 2:
                if (row2[seat - 1] == 1) {
                    System.out.println("Seat already occupied. Please select a different seat.");
                    return;
                } else {
                    row2[seat - 1] = 1;
                    break;
                }
            case 3:
                if (row3[seat - 1] == 1) {
                    System.out.println("Seat already occupied. Please select a different seat.");
                    return;
                } else {
                    row3[seat - 1] = 1;
                    break;
                }
        }
        double price = 0;
        while (true) {
            try {
                System.out.println("Enter price: ");
                if (input.hasNextDouble()) {
                    price = input.nextDouble();
                    break;
                } else {
                    System.out.println("Please enter a valid number");
                    input.next();
                }
            } catch(InputMismatchException e) {
                System.out.println("Valid price");
                input.next();
            }
        }
                System.out.println("Enter your name:");
                String name = input.next();
                System.out.println("Enter your surname:");
                String surname = input.next();
        String email;
        System.out.println("Enter your email: ");
        email = input.nextLine();
        while (true) {
            email = input.nextLine();

            if (email.contains("@") && email.contains(".")) {
                break;
            } else {
                System.out.println("Email missing '@' or '.' or both\nTry again");
            }
        }

                Person person = new Person(name, surname, email);
                Ticket ticket = new Ticket(row, seat, price, person);

                tickets.add(ticket);

                System.out.println("Ticket purchased successfully!");
            }


    public static void cancelTicket() {
        Scanner input = new Scanner(System.in);

        int row = 0;
        int seat = 0;

        while (true) {
            System.out.println("Enter row number (1-3):");
            row = input.nextInt();
            if (row < 1 || row > 3) {
                System.out.println("Out of range");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Enter seat number:");
            seat = input.nextInt();
            if ((row == 1 && (seat < 1 || seat > 11)) ||
                    (row == 2 && (seat < 1 || seat > 15)) ||
                    (row == 3 && (seat < 1 || seat > 19))) {
                System.out.println("Out of range");
            }  else {
                break;
            }
        }
        switch (row) {
            case 1:
                if (row1[seat - 1] == 0) {
                    System.out.println("Seat is not occupied. Please select a different seat.");
                    return;
                } else {
                    row1[seat - 1] = 0;
                    break;
                }
            case 2:
                if (row2[seat - 1] == 0) {
                    System.out.println("Seat is not occupied. Please select a different seat.");
                    return;
                } else {
                    row2[seat - 1] = 0;
                    break;
                }
            case 3:
                if (row3[seat - 1] == 0) {
                    System.out.println("Seat is not occupied. Please select a different seat.");
                    return;
                } else {
                    row3[seat - 1] = 0;
                    break;
                }
            default:
                System.out.println("Invalid row number. Please select a number between 1 and 3.");
                return;
        }

        // Find the ticket associated with the cancelled seat and remove it from the tickets list
        for (Ticket ticket : tickets) {
            if (ticket.getRow() == row && ticket.getSeat() == seat) {
                tickets.remove(ticket);
                System.out.println("Ticket cancelled successfully!");
                return;
            }
        }

        System.out.println("Ticket not found.");
    }

    public static void printSeatingArea() {

        System.out.println("    ***********");
        System.out.println("    *  Stage  *");
        System.out.println("    ***********");

        for (int i = 0; i < row1.length; i++) {
            if (i == 0) {
                System.out.print("    ");
            }
            if (i == 6) {
                System.out.print(" ");
            }
            if (row1[i] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }
        System.out.println();

        for (int i = 0; i < row2.length; i++) {
            if (i == 0) {
                System.out.print("  ");
            }
            if (i == 8) {
                System.out.print(" ");
            }
            if (row2[i] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }
        System.out.println();

        for (int i = 0; i < row3.length; i++) {
            if (i == 10) {
                System.out.print(" ");
            }
            if (row3[i] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }
        System.out.println();
    }

    private static void listAvailableSeats() {
        {
            System.out.print("Seats available in row 1: ");
            for (int i = 0; i < row1.length; i++) {
                if (row1[i] == 0)
                    System.out.print((i + 1) + ",");

            }
            System.out.println(".");
            System.out.print("Seats available in row 2: ");
            for (int i = 0; i < row2.length; i++) {
                if (row2[i] == 0)
                    System.out.print((i + 1) + ",");
            }
            System.out.println(".");
            System.out.print("Seats available in row 3: ");
            for (int i = 0; i < row3.length; i++) {
                if (row3[i] == 0)
                    System.out.print((i + 1) + ",");
            }
            System.out.println(".");
        }
    }

    private static void saveToFile() {
        try {
            FileWriter writer = new FileWriter("seats.txt");
            //writer.write("Seats available in row 1: ");
            for (int i = 0; i < row1.length; i++) {
                //if (row1[i] == 0)
                    writer.write(row1[i] + " ");
            }
            writer.write("\n");
           // writer.write("Seats available in row 2: ");
            for (int i = 0; i < row2.length; i++) {
               // if (row2[i] == 0)
                    writer.write(row2[i] + " ");
            }
            writer.write("\n");
            //writer.write("Seats available in row 3: ");
            for (int i = 0; i < row3.length; i++) {
                //if (row3[i] == 0)
                    writer.write(row3[i] + " ");
            }
            writer.write("\n");

            writer.close();
            System.out.println("Seats saved to seats.txt.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving seats.");
            e.printStackTrace();
        }
    }
    private static void loadFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("seats.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                int row = Integer.parseInt(parts[0].substring(parts[0].length() - 1)) - 1;
                String[] seatNumbers = parts[1].trim().split(" ");
                for (String seatNumber : seatNumbers) {
                    try {
                        int seat = Integer.parseInt(seatNumber.trim());
                        switch (row) {
                            case 0:
                                row1[seat] = 1;
                                break;
                            case 1:
                                row2[seat] = 1;
                                break;
                            case 2:
                                row3[seat] = 1;
                                break;
                        }
                    } catch (NumberFormatException e) {
                        // Handle invalid input string
                        System.out.println("Invalid input: " + seatNumber);
                    }
                }
            }
            reader.close();
            System.out.println("Seats loaded.");
        } catch (IOException e) {
            System.out.println("An error occurred while loading seats.");
            e.printStackTrace();
        }
    }
    private static void printTicketInfo() {
        double tot = 0;
        for (int i = 0; i < tickets.size(); i++) {
            Ticket out = tickets.get(i);
            System.out.println("------------------------------------");
            out.print();
            tot += out.getPrice();
        }
        System.out.println("------------------------------------");
        System.out.println("Total Price:"+tot);
    }
    private static ArrayList<Ticket> sortTickets() { //selection sort algorithm
        ArrayList<Ticket> abc = new ArrayList<>(tickets);
        int minIndex;
        for (int start = 0; start < abc.size() - 1; start++) {
            minIndex = start;
            for (int i = start + 1; i < abc.size(); i++) {
                if (abc.get(i).getPrice() < abc.get(minIndex).getPrice()) {
                    minIndex = i;
                }
            }
            Ticket temp = abc.get(start);
            abc.set(start, abc.get(minIndex));
            abc.set(minIndex, temp);
        }
        for (int i = 0; i < abc.size(); i++) {
            Ticket out = abc.get(i);
            System.out.println("------------------------------------");
            out.print();
        }
        return abc;
    }
}