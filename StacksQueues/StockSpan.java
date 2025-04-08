import java.util.Scanner;
import java.util.Stack;
public class StockSpan{
	public static int[] calculateSpan(int prices[])
	{
		int n=prices.length;
		int span[]=new int[n];
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<n;i++)
		{
			while(!stack.isEmpty()&&prices[stack.peek()]<=prices[i])
				stack.pop();
			span[i]=(stack.isEmpty())?(i+1):(i-stack.peek());
			stack.push(i);
		}
		return span;
	}
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter number of days:");
		int n=scanner.nextInt();
		int prices[]=new int[n];
		System.out.print("Enter stock prices for "+n+" days:");
		for(int i=0;i<n;i++)
			prices[i]=scanner.nextInt();
		int span[]=calculateSpan(prices);
		System.out.println("\nStock Spans:");
		for(int i=0;i<n;i++)
			System.out.println("Day "+(i+1)+" (Price:"+prices[i]+") ->Span:"+span[i]);
		scanner.close();
	}
}
