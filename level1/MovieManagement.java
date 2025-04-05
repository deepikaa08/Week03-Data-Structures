import java.util.Scanner;
class MovieNode{
	String title;
	String director;
	int year;
	double rating;
	MovieNode next, prev;
	
	public MovieNode(String title, String director, int year, double rating){
		this.title=title;
		this.director=director;
		this.year=year;
		this.rating=rating;
		this.next=null;
		this.prev=null;
	}
}

class MovieDoublyLinkedList{
	private MovieNode head, tail;
	
	public void addAtBeginning(String title, String director, int year, double rating){
		MovieNode newNode=new MovieNode(title, director, year, rating);
		if(head==null){
			head= tail= newNode;
		}
		else{
			newNode=head;
			head.prev=newNode;
			head=newNode;
		}
		System.out.println("Movie added at beginning");
	}
	
	public void addAtEnd(String title, String director, int year, double rating){
		MovieNode newNode=new MovieNode(title, director, year, rating);
		if(tail==null){
			head= tail= newNode;
		}
		else{
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
		}
		System.out.println("Movie added at end");
	}
	
	public void addAtPosition(int position, String title, String director, int year, double rating){
		if(position<=1){
			addAtBeginning(title, director, year, rating);
			return;
		}
		MovieNode newNode=new MovieNode(title, director, year, rating);
		MovieNode current=head;
		for(int i=1; i<position-1&&current!=null; i++){
			current=current.next;
		}
		if(current==null || current==tail){
			addAtEnd(title, director, year, rating);
		}
		else{
			newNode.next=current.next;
			newNode.prev=current;
			current.next.prev=newNode;
			current.next=newNode;
			System.out.println("Movie added at position "+position);
		}
	}
	
	public void removeTitle(String title){
		MovieNode current=head;
		while(current != null){
			if(current.title.equalsIgnoreCase(title)){
				if(current==head){
					head=current.next;
					if(head!=null)
						head.prev=null;
					else
						tail=null;
				}
				else if(current==tail){
					tail=current.prev;
					tail.next=null;
				}
				else{
					current.prev.next=current.next;
					current.next.prev=current.prev;
				}
				System.out.println("Movie\""+title+"\"removed");
				return;
			}
			current=current.next;
		}
		System.out.println("Movie not found");
	}
	
	public void searchDirector(String director){
		MovieNode current=head;
		boolean found=false;
		while(current!=null){
			if(current.director.equalsIgnoreCase(director)){
				displayMovie(current);
				found=true;
			}
			current=current.next;
		}
		if(!found)
			System.out.println("No movie found");
	}
	
	public void searchByRating(double rating){
		MovieNode current=head;
		boolean found=false;
		while(current!=null){
			if(current.rating==rating){
				displayMovie(current);
				found=true;
			}
			current=current.next;
		}
		if(!found)
			System.out.println("No movie found");
	}
	
	public void updateRating(String title, double newRating){
		MovieNode current=head;
		while(current!=null){
			if(current.title.equalsIgnoreCase(title)){
				current.rating=newRating;
				System.out.println("Rate updated for "+title);
				return;
			}
			current=current.next;
		}
		System.out.println("Movie not found");
	}
	
	public void displayForward(){
		if(head==null){
			System.out.println("No movie found");
			return;
		}
		MovieNode current=head;
		while(current!=null){
			displayMovie(current);
			current=current.next;
		}
	}
	
	public void displayReverse(){
		if(tail==null){
			System.out.println("No movies to display");
			return;
		}
		MovieNode current=tail;
		while(current!=null){
			displayMovie(current);
			current=current.prev;
		}
	}
	
	public void displayMovie(MovieNode movie){
		System.out.println();
		System.out.println("Title: "+movie.title);
		System.out.println("Director: "+movie.director);
		System.out.println("Year: "+movie.year);
		System.out.println("rating: "+movie.rating);
	}
}

public class MovieManagement{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		MovieDoublyLinkedList movielist=new MovieDoublyLinkedList();
		int choice;
		do{
			System.out.println();
			System.out.println("1. Add movie at beginning");
			System.out.println("2. Add movie at end");
			System.out.println("3. Add movie at specific position");
			System.out.println("4. Remove movie by title");
			System.out.println("5. Search movie by title");
			System.out.println("6. Search movie by rating");
			System.out.println("7. Display movies(forward)");
			System.out.println("8. Display movies(reverse)");
			System.out.println("9. Update movie rating");
			System.out.println("10. exit");
			System.out.print("Enter choice: ");
			choice=input.nextInt();
			input.nextLine();
			String title, director;
			int year, position;
			double rating;
			switch(choice){
				case 1:
					System.out.print("Title: ");
					title=input.nextLine();
					System.out.print("Director: ");
					director=input.nextLine();
					System.out.print("Year: ");
					year=input.nextInt();
					System.out.print("Rating: ");
					rating=input.nextDouble();
					movielist.addAtBeginning(title, director, year, rating);
					break;
					
				case 2:
					System.out.print("Title: ");
					title=input.nextLine();
					System.out.print("Director: ");
					director=input.nextLine();
					System.out.print("Year: ");
					year=input.nextInt();
					System.out.print("Rating: ");
					rating=input.nextDouble();
					movielist.addAtEnd(title, director, year, rating);
					break;
					
				case 3:
					System.out.print("Enter position: ");
					position=input.nextInt();
					input.nextLine();
					System.out.print("Title: ");
					title=input.nextLine();
					System.out.print("Director: ");
					director=input.nextLine();
					System.out.print("Year: ");
					year=input.nextInt();
					System.out.print("Rating: ");
					rating=input.nextDouble();
					movielist.addAtPosition(position, title, director, year, rating);
					break;
					
				case 4:
					System.out.print("Enter title: ");
					title=input.nextLine();
					movielist.removeTitle(title);
					break;
				
				case 5:
					System.out.print("Enter director: ");
					director=input.nextLine();
					movielist.searchDirector(director);
					break;
					
				case 6:
					System.out.print("Enter rating: ");
					rating=input.nextDouble();
					movielist.searchByRating(rating);
					break;
					
				case 7: 
					movielist.displayForward();
					break;
					
				case 8:
					movielist.displayReverse();
					break;
				
				case 9:
					System.out.print("Enter title: ");
					title=input.nextLine();
					System.out.print("Enter new rating: ");
					rating=input.nextDouble();
					movielist.updateRating(title, rating);
					break;
					
				case 10:
					break;
					
				default:
					System.out.println("Invalid choice");
			}
		}
		while(choice!=10);
		input.close();
	}
}
