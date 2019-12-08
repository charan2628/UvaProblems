package com.queues;

import java.util.*;
import java.io.*;

//uva 11034
public class FerryLoadingIV {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int l, m;
	static Deque<Integer> left, right, ferry;
	
	public static void main(String[] args) throws Exception{
		int cases = Integer.parseInt(reader.readLine());
		String data[];
		while(cases-- != 0) {
			data = reader.readLine().split(" ");
			l = Integer.parseInt(data[0]) * 100; m = Integer.parseInt(data[1]);
			left = new ArrayDeque<>(); right = new ArrayDeque<>(); ferry = new ArrayDeque<>();
			for(int i = 0; i < m; i++) {
				data = reader.readLine().split(" ");
				if(data[1].equals("left")) 
					left.offer(Integer.parseInt(data[0]));
				else
					right.offer(Integer.parseInt(data[0]));
			}
			process();
		}
		writer.close();
		reader.close();
	}
	
	static void process() throws Exception{
		int trips = 0, pos = 0;
		while(!ferry.isEmpty() || !left.isEmpty() || !right.isEmpty()) {
			
			if(pos == 0) {
				loadFerry(left, ferry);
				pos = 1;
				trips++;
			} else {
				loadFerry(right, ferry);
				pos = 0;
				trips++;
			}
			
			while(!ferry.isEmpty()) {
				ferry.poll();
			}
		}
		writer.write(String.format("%d\n", trips));
	}
	
	static void loadFerry(Deque<Integer> cars, Deque<Integer> ferry) {
		int currLen = 0;
		while(cars.peek() != null) {
			currLen += cars.peek();
			if(currLen > l) {
				break;
			}
			ferry.offer(cars.poll());
		}
	}
}
