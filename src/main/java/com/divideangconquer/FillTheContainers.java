package com.divideangconquer;

import java.util.*;
import java.io.*;

//UVa 11413
public class FillTheContainers {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n, m, bottles[];
	
	public static void main(String[] args) throws Exception{
//		writer = new BufferedWriter(new FileWriter("output.txt"));
		String data[], input;
		while((input = reader.readLine()) != null) {
			data = input.split(" ");
			n = Integer.parseInt(data[0]); m = Integer.parseInt(data[1]);
			bottles = Arrays.asList(reader.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
			process();
		}
		writer.close();
		reader.close();
	}
	
	static void process() throws Exception{
		int lo = 1, hi = 0, highest = 0;
		for(int i = 0; i < n; i++) {
			hi += bottles[i];
		}
		while(lo <= hi) {
			int mid = (lo + hi)/2;
			if(tryCapacity(mid)) {
				highest = mid;
				hi = mid-1;
			} else {
				lo = mid+1;
			}
		}
		writer.write(String.format("%d\n", highest));
	}
	
	static boolean tryCapacity(int capacity) {
		int currCapacity = 0, containers = 1;
		for(int bottle: bottles) {
			if(bottle > capacity) return false;
			if(bottle + currCapacity <= capacity) currCapacity += bottle;
			else {
				containers += 1;
				if(containers > m) return false;
				currCapacity = bottle;
			}
			
		}
		return true;
	}
}
