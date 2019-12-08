package com.bitmanipulation;

import java.util.*;
import java.io.*;

//11926
public class MultiTasking {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static BitSet tasks;
	
	public static void main(String[] args) throws Exception{
		int n, m;
		String input, data[];
		boolean flag = false;
		while(!(input = reader.readLine()).equals("0 0")) {
			flag = false;
			tasks = new BitSet(1000001);
			
			data = input.split(" ");
			n = Integer.parseInt(data[0]); m = Integer.parseInt(data[1]);
			
			for(int i = 0; i < n; i++) {
				data = reader.readLine().split(" ");
				if(!flag) {
					flag = oneTimeTask(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
				}
			}
			
			for(int i = 0; i < m; i++) {
				data = reader.readLine().split(" ");
				if(!flag) {
					flag = repeatedTimeTask(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
				}
			}
			if(!flag) {
				writer.write("NO CONFLICT\n");
			} else {
				writer.write("CONFLICT\n");
			}
		}
		
		writer.close();
		reader.close();
	}
	
	static boolean oneTimeTask(int start, int end) {
		BitSet taskTime = tasks.get(start, end); //start inclusive and end exclusive
		
		if(taskTime.cardinality() != 0) return true;
		tasks.set(start, end);
		return false;
	}
	
	static boolean repeatedTimeTask(int start, int end, int interval) {
		while((start <= 1000000)) {
			BitSet taskTime = tasks.get(start, end);
			if(taskTime.cardinality() != 0) return true;
			tasks.set(start, end);
			start += interval; end += interval;
		}
		return false;
	}
}
