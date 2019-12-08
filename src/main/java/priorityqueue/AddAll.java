package priorityqueue;

import java.io.*;
import java.util.*;

//uva 10954
public class AddAll {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static PriorityQueue<Integer> nums = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception{
		String input[], data;
		while(!(data = reader.readLine()).equals("0")) {
			nums.clear();
			input = reader.readLine().split(" ");
			for(int i = 0; i < input.length; i++) {
				nums.add(Integer.valueOf(input[i]));
			}
			process();
		}
		writer.close();
		reader.close();
	}
	
	static void process() throws Exception{
		long sum = 0;
		while(nums.size() != 1) {
			int a = nums.poll(), b = nums.poll();
			sum += (a+b);
			nums.add(a+b);
		}
		writer.write(String.format("%d\n", sum));
	}
}
