import java.util.*;
class EmptyListException extends Exception {
    public EmptyListException(String msg) {
        super(msg);
    }
}
class NameDemo {
    private List<String> list = new ArrayList<>();
    public void add(String name) {
        list.add(name);
        System.out.println("Added: " + name);
    }
    public void remove(String name) {
        if (list.remove(name)) {
            System.out.println("Removed: " + name);
        } else {
            System.out.println(name + " not found.");
        }
    }
    public void display() throws EmptyListException {
        if (list.isEmpty()) throw new EmptyListException("List is empty!");
        Collections.sort(list);
        System.out.println("Names:");
        for (String n : list) System.out.println(n);
    }
    public void run(Scanner sc) {
        String name;
        while (true) {
            System.out.print("Enter name (or 'done'): ");
            name = sc.nextLine().trim();
            if (name.equalsIgnoreCase("done")) break;
            if (!name.isEmpty()) add(name);
        }
        try {
            display();
        } catch (EmptyListException e) {
            System.out.println("Error: " + e.getMessage());
        }
        if (!list.isEmpty()) {
            System.out.print("Enter name to remove: ");
            remove(sc.nextLine().trim());
        }
        try {
            display();
        } catch (EmptyListException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
class NumDemo {
    public void run(Scanner sc) {
        List<Integer> nums = new ArrayList<>();
        System.out.println("Enter numbers (type 'done' to finish):");
        while (true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("done")) break;
            try {
                nums.add(Integer.parseInt(line));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
        avg(nums);
    }
    private void avg(List<Integer> nums) {
        try {
            if (nums.isEmpty()) throw new ArithmeticException("No numbers entered!");
            long sum = 0;
            for (int n : nums) sum += n;
            System.out.println("Average: " + (double) sum / nums.size());
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Name Demo");
            System.out.println("2. Number Demo");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            try {
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        new NameDemo().run(sc);
                        break;
                    case 2:
                        new NumDemo().run(sc);
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number.");
                sc.nextLine();
                choice = -1;
            }
        } while (choice != 0);
        sc.close();
    }
}
