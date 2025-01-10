package empsmanagement.driver;

import java.util.Scanner;
import com.empmanagement.service.Empservice;

public class Empdriver {
    public static void main(String[] args) {
        Empservice empService = new Empservice();
        Scanner s = new Scanner(System.in);

        while (true) {
            showMenu();
            int choice = s.nextInt();
            handleChoice(choice, empService, s);
        }
    }

    private static void showMenu() {
        System.out.println("\nWELCOME TO EMPMANAGEMENT APPLICATION");
        System.out.println("Menu:");
        System.out.println("Enter 1 to Add employee");
        System.out.println("Enter 2 to Fetch all employees");
        System.out.println("Enter 3 to Update employee");
        System.out.println("Enter 4 to Delete employee");
        System.out.println("Enter 5 to Exit EMPMANAGEMENT APPLICATION");
        System.out.println("Enter your choice:");
    }

    private static void handleChoice(int choice, Empservice empService, Scanner s) {
        switch (choice) {
            case 1:
                empService.save();
                break;
            case 2:
                empService.fetchAll();
                break;
            case 3:
                empService.update();
                break;
            case 4:
                empService.delete();
                break;
            case 5:
                System.out.println("Exiting application. Goodbye!");
                s.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice! Please select a valid option.");
        }
    }
}
