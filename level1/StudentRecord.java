import java.util.Scanner;
class StudentNode{
	int rollNumber;
	String name;
	int age;
	String grade;
	StudentNode next;
	
	public StudentNode(int rollNumber, String name, int age, String grade){
		this.rollNumber=rollNumber;
		this.name=name;
		this.age=age;
		this.grade=grade;
		this.next=null;
	}
}

class StudentLinkedList{
	private StudentNode head;
	
	public void addAtBeginning(int rollNumber, String name, int age, String grade){
		StudentNode newNode=new StudentNode(rollNumber, name, age, grade);
		newNode.next=head;
		head=newNode;
		System.out.println("Student added at the beginning");
	}
	public void addAtEnd(int rollNumber, String name, int age, String grade){
		StudentNode newNode=new StudentNode(rollNumber, name, age, grade);
		if(head==null){
			head=newNode;
		}
		else{
			StudentNode temp=head;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=newNode;
		}
		System.out.println("Student added to the end");
	}
	public void addAtPosition(int position, int rollNumber, String name, int age, String grade){
		if(position==1){
			addAtBeginning(rollNumber, name, age, grade);
			return;
		}
		StudentNode newNode=new StudentNode(rollNumber, name, age, grade);
		StudentNode temp=head;
		for(int i=1; i<position-1&&temp!=null; i++){
			temp=temp.next;
		}
		if(temp==null){
			System.out.println("Position out of range");
		}
		else{
			newNode.next=temp.next;
			temp.next=newNode;
			System.out.println("Student added at position "+position);
		}
	}
	
	public void deleteRollnumber(int rollNumber){
		if(head==null){
			System.out.println("List is empty");
			return;
		}
		if(head.rollNumber==rollNumber){
			head=head.next;
			System.out.println("Student with roll number "+rollNumber+" is deleted");
			return;
		}
		StudentNode temp=head;
		while(temp.next!=null && temp.next.rollNumber!=rollNumber){
			temp=temp.next;
		}
		if(temp.next==null){
			System.out.println("Student not found");
		}
		else{
			temp.next=temp.next.next;
			System.out.println("Student with roll number "+rollNumber+" is deleted");
		}
	}
	
	public void searchRollNumber(int rollNumber){
		StudentNode temp=head;
		while(temp!=null){
			if(temp.rollNumber==rollNumber){
				System.out.println("Student details: ");
				System.out.println("Roll number: "+temp.rollNumber);
				System.out.println("Name: "+temp.name);
				System.out.println("Age: "+temp.age);
				System.out.println("Grade: "+temp.grade);
				return;
			}
			temp=temp.next;
		}
		System.out.println("Student not found");
	}
	
	public void displayRecords(){
		if(head==null){
			System.out.println("No student record to display");
			return;
		}
		StudentNode temp=head;
		while(temp!=null){
			System.out.println();
			System.out.println("Roll number: "+temp.rollNumber);
			System.out.println("Name: "+temp.name);
			System.out.println("Age: "+temp.age);
			System.out.println("Grade: "+temp.grade);
			temp=temp.next;
		}
	}
	
	public void updateGrade(int rollNumber, String newGrade){
		StudentNode temp=head;
		while(temp!=null){
			if(temp.rollNumber==rollNumber){
				temp.grade=newGrade;
				System.out.println("Grade updated successfully");
				return;
			}
			temp=temp.next;
		}
		System.out.println("Student not found");
	}
}

public class StudentRecord{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		StudentLinkedList studentlist=new StudentLinkedList();
		int choice;
		do{
			System.out.println();
			System.out.println("1. Add Student at beginning");
			System.out.println("2. Add Student at end");
			System.out.println("3. Add Student at specific position");
			System.out.println("4. Delete Student by roll number");
			System.out.println("5. Search Student by roll number");
			System.out.println("6. Display all students");
			System.out.println("7. Update Student grade");
			System.out.println("8. Exit");
			System.out.print("Enter choice: ");
			choice=input.nextInt();
			int rollNumber, age, position;
			String name, grade;
			switch(choice){
				case 1:
					System.out.print("Enter roll number: ");
					rollNumber=input.nextInt();
					input.nextLine();
					System.out.print("Enter name: ");
					name=input.nextLine();
					System.out.print("Enter age: ");
					age=input.nextInt();
					input.nextLine();
					System.out.print("Enter grade: ");
					grade=input.nextLine();
					studentlist.addAtBeginning(rollNumber, name, age, grade);
					break;
				
				case 2:
					System.out.print("Enter roll number: ");
					rollNumber=input.nextInt();
					input.nextLine();
					System.out.print("Enter name: ");
					name=input.nextLine();
					System.out.print("Enter age: ");
					age=input.nextInt();
					input.nextLine();
					System.out.print("Enter grade: ");
					grade=input.nextLine();
					studentlist.addAtEnd(rollNumber, name, age, grade);
					break;
					
				case 3:
					System.out.print("Enter position: ");
					position=input.nextInt();
					System.out.print("Enter roll number: ");
					rollNumber=input.nextInt();
					input.nextLine();
					System.out.print("Enter name: ");
					name=input.nextLine();
					System.out.print("Enter age: ");
					age=input.nextInt();
					input.nextLine();
					System.out.print("Enter grade: ");
					grade=input.nextLine();
					studentlist.addAtEnd(rollNumber, name, age, grade);
					break;
					
				case 4:
					System.out.print("Enter roll number: ");
					rollNumber=input.nextInt();
					studentlist.deleteRollnumber(rollNumber);
					break;
					
				case 5:
					System.out.print("Enter roll number: ");
					rollNumber=input.nextInt();
					studentlist.searchRollNumber(rollNumber);
					break;
					
				case 6: 
					studentlist.displayRecords();
					break;
				
				case 7: 
					System.out.print("Enter roll number: ");
					rollNumber=input.nextInt();
					input.nextLine();
					System.out.print("Enter grade: ");
					grade=input.nextLine();
					studentlist.updateGrade(rollNumber, grade);
					break;
					
				case 8:
					break;
				
				default:
					System.out.println("Invalid choice");
			}
		}
		while(choice!=8);
		input.close();
	}
}
