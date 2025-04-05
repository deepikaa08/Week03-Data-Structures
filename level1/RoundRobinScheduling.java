import java.util.Scanner;

class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int timeQuantum;

    RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head;
            tail = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
        System.out.println("Process " + pid + " added.");
    }

    void removeProcess(int pid) {
        if (head == null) return;

        Process current = head;
        Process prev = tail;

        do {
            if (current.pid == pid) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }

                if (head == current && head.next == head) {
                    head = tail = null;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }
        Process temp = head;
        System.out.println("\nProcesses in the queue:");
        do {
            System.out.println("PID: " + temp.pid + ", Remaining Time: " + temp.remainingTime);
            temp = temp.next;
        } while (temp != head);
    }

    void simulate() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0;
        Process current = head;

        while (head != null) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(current.remainingTime, timeQuantum);
                current.remainingTime -= execTime;
                time += execTime;
                Process temp = head;
                do {
                    if (temp != current && temp.remainingTime > 0) {
                        temp.waitingTime += execTime;
                    }
                    temp = temp.next;
                } while (temp != head);

                if (current.remainingTime == 0) {
                    current.turnaroundTime = time;
                    System.out.println("Process " + current.pid + " finished at time " + time);
                    removeProcess(current.pid);
                    if (current == head) head = head.next;
                }
            }

            displayProcesses();

            if (head != null)
                current = current.next;
        }

        displayFinalTimes(time);
    }

    void displayFinalTimes(int totalTime) {
        System.out.println("\n--- Final Process Info ---");
        int count = 0;
        int totalWT = 0, totalTAT = 0;

        Process temp = head;
        if (temp == null) return;

        do {
            System.out.println("PID: " + temp.pid + ", Waiting Time: " + temp.waitingTime + ", Turnaround Time: " + temp.turnaroundTime);
            totalWT += temp.waitingTime;
            totalTAT += temp.turnaroundTime;
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("\nAverage Waiting Time: " + (float) totalWT / count);
        System.out.println("Average Turnaround Time: " + (float) totalTAT / count);
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Time Quantum: ");
        int tq = sc.nextInt();

        RoundRobinScheduler scheduler = new RoundRobinScheduler(tq);

        int choice;
        do {
            System.out.println("\n--- Round Robin CPU Scheduler ---");
            System.out.println("1. Add Process");
            System.out.println("2. Display Processes");
            System.out.println("3. Run Scheduler");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    int pid = sc.nextInt();
                    System.out.print("Enter Burst Time: ");
                    int bt = sc.nextInt();
                    System.out.print("Enter Priority: ");
                    int pr = sc.nextInt();
                    scheduler.addProcess(pid, bt, pr);
                    break;
                case 2:
                    scheduler.displayProcesses();
                    break;
                case 3:
                    scheduler.simulate();
                    break;
                case 4:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
