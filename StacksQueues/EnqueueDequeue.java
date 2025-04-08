import java.util.Stack;
public class EnqueueDequeue{
	Stack<Integer> stackEnqueue=new Stack<>();
	Stack<Integer> stackDequeue=new Stack<>();
	public void enqueue(int x){
		stackEnqueue.push(x);
	}
	public int dequeue(){
		if(stackDequeue.isEmpty()){
			while(!stackEnqueue.isEmpty()){
				stackDequeue.push(stackEnqueue.pop());
			}
		}
		if(stackDequeue.isEmpty()){
			throw new RuntimeException("Queue is empty");
		}
		return stackDequeue.pop();
	}
	
	public int peek(){
		if(stackDequeue.isEmpty()){
			while(!stackEnqueue.isEmpty()){
				stackDequeue.push(stackEnqueue.pop());
			}
		}
		if(stackDequeue.isEmpty()){
			throw new RuntimeException("Queue is empty");
		}
		return stackDequeue.peek();
	}
	public boolean isEmpty(){
		return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
	}
	
	public static void main(String[] args){
		EnqueueDequeue queue=new EnqueueDequeue();
		queue.enqueue(1);
		queue.enqueue(2);
		System.out.println(queue.peek());
		System.out.println(queue.dequeue());
		System.out.println(queue.isEmpty());
	}
}
