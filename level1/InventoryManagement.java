import java.util.*;

class Item {
    String name;
    String id;
    int quantity;
    double price;
    Item next;

    public Item(String name, String id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    Item head = null;

    public void addAtBeginning(String name, String id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
        System.out.println("Item added at beginning.");
    }

    public void addAtEnd(String name, String id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
        System.out.println("Item added at end.");
    }

    public void addAtPosition(int pos, String name, String id, int quantity, double price) {
        if (pos <= 1 || head == null) {
            addAtBeginning(name, id, quantity, price);
            return;
        }
        Item newItem = new Item(name, id, quantity, price);
        Item temp = head;
        int count = 1;
        while (count < pos - 1 && temp.next != null) {
            temp = temp.next;
            count++;
        }
        newItem.next = temp.next;
        temp.next = newItem;
        System.out.println("Item added at position " + pos);
    }

    public void removeById(String id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.id.equals(id)) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }
        Item temp = head;
        while (temp.next != null && !temp.next.id.equals(id)) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item ID not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        }
    }

    public void updateQuantity(String id, int quantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id.equals(id)) {
                temp.quantity = quantity;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item ID not found.");
    }

    public void searchItem(String query) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.id.equalsIgnoreCase(query) || temp.name.equalsIgnoreCase(query)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item not found.");
        }
    }

    public void calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        System.out.println("\n--- Inventory ---");
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    private void displayItem(Item item) {
        System.out.println("-------------------------");
        System.out.println("Item Name : " + item.name);
        System.out.println("Item ID   : " + item.id);
        System.out.println("Quantity  : " + item.quantity);
        System.out.println("Price     : " + item.price);
    }

    public void sortInventory(String key, boolean ascending) {
        head = mergeSort(head, key, ascending);
        System.out.println("Inventory sorted by " + key + " (" + (ascending ? "asc" : "desc") + ")");
    }

    private Item mergeSort(Item head, String key, boolean asc) {
        if (head == null || head.next == null)
            return head;

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;

        middle.next = null;

        Item left = mergeSort(head, key, asc);
        Item right = mergeSort(nextOfMiddle, key, asc);

        return sortedMerge(left, right, key, asc);
    }

    private Item sortedMerge(Item a, Item b, String key, boolean asc) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        Item result;

        int cmp;
        if (key.equalsIgnoreCase("name")) {
            cmp = a.name.compareToIgnoreCase(b.name);
        } else { 
            cmp = Double.compare(a.price, b.price);
        }

        if ((asc && cmp <= 0) || (!asc && cmp > 0)) {
            result = a;
            result.next = sortedMerge(a.next, b, key, asc);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, key, asc);
        }

        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inv = new Inventory();
        int choice;

        do {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search Item by ID or Name");
            System.out.println("7. Display All Items");
            System.out.println("8. Calculate Total Inventory Value");
            System.out.println("9. Sort Inventory");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt(); sc.nextLine();

            String name, id;
            int quantity, position;
            double price;

            switch (choice) {
                case 1:
                    System.out.print("Item Name: "); name = sc.nextLine();
                    System.out.print("Item ID: "); id = sc.nextLine();
                    System.out.print("Quantity: "); quantity = sc.nextInt();
                    System.out.print("Price: "); price = sc.nextDouble(); sc.nextLine();
                    inv.addAtBeginning(name, id, quantity, price);
                    break;
                case 2:
                    System.out.print("Item Name: "); name = sc.nextLine();
                    System.out.print("Item ID: "); id = sc.nextLine();
                    System.out.print("Quantity: "); quantity = sc.nextInt();
                    System.out.print("Price: "); price = sc.nextDouble(); sc.nextLine();
                    inv.addAtEnd(name, id, quantity, price);
                    break;
                case 3:
                    System.out.print("Position: "); position = sc.nextInt(); sc.nextLine();
                    System.out.print("Item Name: "); name = sc.nextLine();
                    System.out.print("Item ID: "); id = sc.nextLine();
                    System.out.print("Quantity: "); quantity = sc.nextInt();
                    System.out.print("Price: "); price = sc.nextDouble(); sc.nextLine();
                    inv.addAtPosition(position, name, id, quantity, price);
                    break;
                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    id = sc.nextLine();
                    inv.removeById(id);
                    break;
                case 5:
                    System.out.print("Enter Item ID to update quantity: ");
                    id = sc.nextLine();
                    System.out.print("New Quantity: ");
                    quantity = sc.nextInt(); sc.nextLine();
                    inv.updateQuantity(id, quantity);
                    break;
                case 6:
                    System.out.print("Enter Item ID or Name to search: ");
                    String query = sc.nextLine();
                    inv.searchItem(query);
                    break;
                case 7:
                    inv.displayInventory();
                    break;
                case 8:
                    inv.calculateTotalValue();
                    break;
                case 9:
                    System.out.print("Sort by (name/price): ");
                    String key = sc.nextLine();
                    System.out.print("Ascending (true/false): ");
                    boolean asc = sc.nextBoolean(); sc.nextLine();
                    inv.sortInventory(key, asc);
                    break;
                case 10:
                    System.out.println("Exiting Inventory System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 10);

        sc.close();
    }
}
