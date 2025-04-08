import java.util.*;
public class SlidingWindow{
	public static List<Integer> maxSlidingWindow(int nums[],int k)
	{
		List<Integer> result=new ArrayList<>();
		Deque<Integer> deque=new ArrayDeque<>();
		for(int i=0;i<nums.length;i++)
		{
			if(!deque.isEmpty()&&deque.peek()<i-k+1)
				deque.poll();
			while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i])
				deque.pollLast();
			deque.offer(i);
			if(i>=k-1)
				result.add(nums[deque.peek()]);
		}
		return result;
	}
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter size of array:");
		int n=scanner.nextInt();
		scanner.nextLine();
		int nums[]=new int[n];
		System.out.print("Enter array elements:");
		for(int i=0;i<n;i++)
			nums[i]=scanner.nextInt();
		System.out.print("Enter window size(k):");
		int k=scanner.nextInt();
		List<Integer> result=maxSlidingWindow(nums,k);
		System.out.println("Maximum in each sliding window:");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");
		scanner.close();
	}
}
