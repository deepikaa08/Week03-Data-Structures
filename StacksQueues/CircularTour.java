import java.util.Scanner;
class PetrolPump{
	int petrol;
	int distance;
	public PetrolPump(int petrol,int distance)
	{
		this.petrol=petrol;
		this.distance=distance;
	}
}
public class CircularTour{
	public static int findStartingPoint(PetrolPump pumps[],int n)
	{
		int start=0;
		int surplus=0;
		int deficit=0;
		for(int i=0;i<n;i++)
		{
			surplus+=pumps[i].petrol-pumps[i].distance;
			if(surplus<0)
			{
				start=i+1;
				deficit+=surplus;
				surplus=0;
			}
		}
		return(surplus+deficit>=0)?start:-1;
	}
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter number of petrol pumps:");
		int n=scanner.nextInt();
		PetrolPump pumps[]=new PetrolPump[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter petrol and distance for pump "+(i+1)+":");
			int petrol=scanner.nextInt();
			scanner.nextLine();
			int distance=scanner.nextInt();
			scanner.nextLine();
			pumps[i]=new PetrolPump(petrol,distance);
		}
		int startPoint=findStartingPoint(pumps,n);
		if(startPoint==-1)
			System.out.println("No circular tour possible.");
		else
			System.out.println("Start the tour from petrol pump index:"+startPoint);
		scanner.close();
	}
}