package com.greedy;

import java.util.*;
import java.io.*;

//11389
public class TheBusDriverProblem {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n, d, r,  morningRoutes[], eveningRoutes[];
	
	public static void main(String[] args) throws Exception{
//		writer = new BufferedWriter(new FileWriter("output.txt"));
		String input, data[];
		while(!(input = reader.readLine()).equals("0 0 0")) {
			data = input.split(" ");
			n = Integer.parseInt(data[0]); d = Integer.parseInt(data[1]); r = Integer.parseInt(data[2]);
			morningRoutes = Arrays.asList(reader.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
			eveningRoutes = Arrays.asList(reader.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
			Arrays.sort(morningRoutes); Arrays.sort(eveningRoutes);
			process();
		}
		writer.close();
		reader.close();
	}
	
	static void process() throws Exception {
		int extra = 0;
		for(int i = 0, j = n-1; i < n && j >= 0; i++, j--) {
			int total = morningRoutes[i] + eveningRoutes[j];
			if(total > d) {
				extra += total - d;
			}
		}
		writer.write(String.format("%d\n", extra*r));
	}
}
