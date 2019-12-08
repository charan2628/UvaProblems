package priorityqueue;

import java.io.*;
import java.util.*;

//uva 11995
public class ICanGuessTheDataStructure {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static Deque<Integer> stack = new ArrayDeque<>();
	static Deque<Integer> queue = new ArrayDeque<>();
	static PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
	
	public static void main(String[] args) throws Exception{
		String data, input[];
		
		while((data = reader.readLine()) != null) {
			int n,  _stack = 0, _queue = 0, _pq = 0, type2_count = 0;
			boolean impossible = false;
			stack.clear();
			queue.clear();
			pq.clear();

			n = Integer.parseInt(data);
			for(int i = 0; i < n; i++) {
				input = reader.readLine().split(" ");
				Integer elm = Integer.valueOf(input[1]);
				if(input[0].equals("1")) {
					stack.push(elm);
					queue.offer(elm);
					pq.add(elm);
				} else {
					type2_count++;
					if(!stack.isEmpty() && stack.pop() == elm) {
						_stack++;
					}
					if(!queue.isEmpty() && queue.poll() == elm) {
						_queue++;
					}
					if(!pq.isEmpty() && pq.poll() == elm) {
						_pq++;
					}
				}
			}
			process(_stack, _queue, _pq, n, type2_count);
		}
		writer.close();
		reader.close();
	}
	
	static void process(int stack, int queue, int pq, int n, int type2_count) throws Exception{
		if(stack != type2_count && queue != type2_count && pq != type2_count) {
			writer.write("impossible\n");
			return;
		}
		if(stack > queue && stack > pq) {
			writer.write("stack\n");
			return;
		}
		if(queue > stack && queue > pq) {
			writer.write("queue\n");
			return;
		}
		if(pq > stack && pq > queue) {
			writer.write("priority queue\n");
			return;
		}
		writer.write("not sure\n");
	}
}
