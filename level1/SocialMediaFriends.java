import java.util.*;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head;

    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newUser;
        }
        System.out.println("User added: " + name);
    }

    private User findUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int id1, int id2) {
        User u1 = findUserById(id1);
        User u2 = findUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!u1.friendIds.contains(id2))
            u1.friendIds.add(id2);
        if (!u2.friendIds.contains(id1))
            u2.friendIds.add(id1);

        System.out.println("Friend connection added between " + u1.name + " and " + u2.name);
    }

    public void removeFriend(int id1, int id2) {
        User u1 = findUserById(id1);
        User u2 = findUserById(id2);

        if (u1 != null && u2 != null) {
            u1.friendIds.remove((Integer) id2);
            u2.friendIds.remove((Integer) id1);
            System.out.println("Friend connection removed between " + u1.name + " and " + u2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void displayFriends(int id) {
        User user = findUserById(id);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println(user.name + "'s Friends:");
        for (int friendId : user.friendIds) {
            User friend = findUserById(friendId);
            if (friend != null)
                System.out.println("-> " + friend.name + " (ID: " + friend.userId + ")");
        }
    }


    public void findMutualFriends(int id1, int id2) {
        User u1 = findUserById(id1);
        User u2 = findUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.println("Mutual friends of " + u1.name + " and " + u2.name + ":");
        for (int friendId : u1.friendIds) {
            if (u2.friendIds.contains(friendId)) {
                User mutual = findUserById(friendId);
                if (mutual != null)
					System.out.println("-> " + mutual.name + " (ID: " + mutual.userId + ")");
            }
        }
    }

    public void searchUser(String name, int id) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.userId == id || temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: ID=" + temp.userId + ", Name=" + temp.name + ", Age=" + temp.age);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("User not found.");
    }

    public void countAllFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }
}

public class SocialMediaFriends {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Social Media Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend");
            System.out.println("3. Remove Friend");
            System.out.println("4. Display Friends");
            System.out.println("5. Find Mutual Friends");
            System.out.println("6. Search User");
            System.out.println("7. Count All Friends");
            System.out.println("8. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("User ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sm.addUser(id, name, age);
                    break;

                case 2:
                    System.out.print("Enter two User IDs: ");
                    int id1 = sc.nextInt();
                    int id2 = sc.nextInt();
                    sm.addFriend(id1, id2);
                    break;

                case 3:
                    System.out.print("Enter two User IDs to remove connection: ");
                    int rid1 = sc.nextInt();
                    int rid2 = sc.nextInt();
                    sm.removeFriend(rid1, rid2);
                    break;

                case 4:
                    System.out.print("Enter User ID to view friends: ");
                    int fid = sc.nextInt();
                    sm.displayFriends(fid);
                    break;

                case 5:
                    System.out.print("Enter two User IDs: ");
                    int mid1 = sc.nextInt();
                    int mid2 = sc.nextInt();
                    sm.findMutualFriends(mid1, mid2);
                    break;

                case 6:
                    System.out.print("Enter name or ID: ");
                    sc.nextLine(); 
                    String search = sc.nextLine();
                    int sid = -1;
                    try {
                        sid = Integer.parseInt(search);
                    } catch (NumberFormatException ignored) {}
                    sm.searchUser(search, sid);
                    break;

                case 7:
                    sm.countAllFriends();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);
        sc.close();
    }
}
