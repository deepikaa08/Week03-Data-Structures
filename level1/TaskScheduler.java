import java.util.Scanner;

class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskCircularLinkedList {
    private TaskNode head = null;
    private TaskNode tail = null;
    private TaskNode current = null;

    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            current = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        System.out.println("Task added at beginning.");
    }

    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            current = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        System.out.println("Task added at end.");
    }

    public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position <= 1 || head == null) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail) {
            tail = newNode;
        }

        System.out.println("Task added at position " + position);
    }

    public void removeById(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        TaskNode temp = head, prev = null;
        boolean found = false;

        do {
            if (temp.taskId == taskId) {
                found = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("Task ID not found.");
            return;
        }

        if (head == tail && head.taskId == taskId) {
            head = tail = current = null;
        }
        else if (temp == head) {
            head = head.next;
            tail.next = head;
        }
        else if (temp == tail) {
            tail = prev;
            tail.next = head;
        }
        else {
            prev.next = temp.next;
        }

        if (current == temp) {
            current = current.next;
        }

        System.out.println("Task with ID " + taskId + " removed.");
    }

    public void viewAndMoveNext() {
        if (current == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        System.out.println("\nCurrent Task:");
        displayTask(current);
        current = current.next;
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        TaskNode temp = head;
        System.out.println("\nAll Tasks:");
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in list.");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task with priority " + priority);
        }
    }

    private void displayTask(TaskNode task) {
        System.out.println("-----------------------------");
        System.out.println("Task ID   : " + task.taskId);
        System.out.println("Name      : " + task.taskName);
        System.out.println("Priority  : " + task.priority);
        System.out.println("Due Date  : " + task.dueDate);
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskCircularLinkedList taskList = new TaskCircularLinkedList();
        int choice;

        do {
            System.out.println("\n--- Task Scheduler Menu ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task and Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            int taskId, priority, position;
            String name, dueDate;
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Task ID: ");
                    taskId = sc.nextInt(); sc.nextLine();
                    System.out.print("Task Name: ");
                    name = sc.nextLine();
                    System.out.print("Priority: ");
                    priority = sc.nextInt(); sc.nextLine();
                    System.out.print("Due Date: ");
                    dueDate = sc.nextLine();
                    taskList.addAtBeginning(taskId, name, priority, dueDate);
                    break;

                case 2:
                    System.out.print("Task ID: ");
                    taskId = sc.nextInt(); sc.nextLine();
                    System.out.print("Task Name: ");
                    name = sc.nextLine();
                    System.out.print("Priority: ");
                    priority = sc.nextInt(); sc.nextLine();
                    System.out.print("Due Date: ");
                    dueDate = sc.nextLine();
                    taskList.addAtEnd(taskId, name, priority, dueDate);
                    break;

                case 3:
                    System.out.print("Position: ");
                    position = sc.nextInt(); sc.nextLine();
                    System.out.print("Task ID: ");
                    taskId = sc.nextInt(); sc.nextLine();
                    System.out.print("Task Name: ");
                    name = sc.nextLine();
                    System.out.print("Priority: ");
                    priority = sc.nextInt(); sc.nextLine();
                    System.out.print("Due Date: ");
                    dueDate = sc.nextLine();
                    taskList.addAtPosition(position, taskId, name, priority, dueDate);
                    break;

                case 4:
                    System.out.print("Enter Task ID to Remove: ");
                    taskId = sc.nextInt();
                    taskList.removeById(taskId);
                    break;

                case 5:
                    taskList.viewAndMoveNext();
                    break;

                case 6:
                    taskList.displayTasks();
                    break;

                case 7:
                    System.out.print("Enter Priority to Search: ");
                    priority = sc.nextInt();
                    taskList.searchByPriority(priority);
                    break;

                case 8:
                    System.out.println("Exiting Task Scheduler.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}
