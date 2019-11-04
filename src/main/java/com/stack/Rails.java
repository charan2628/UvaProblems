package com.stack;

import java.util.*;
import java.io.*;

public class Rails {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;

	public static void main(String[] args) throws Exception{
		String input, data[];
		while(!(input = reader.readLine()).equals("0")) {
			n = Integer.parseInt(input);
			while(!(input = reader.readLine()).equals("0")) {
				data = input.split(" ");
				int coaches[] = new int[n];
				for(int i = 0; i < n; i++) {
					coaches[i] = Integer.parseInt(data[i]);
				}
				process(coaches);
			}
			writer.newLine();
		}
		writer.close();
		reader.close();
	}

	static void process(int[] permutation) throws IOException {
		ArrayDeque<Integer> dirA = new ArrayDeque<>();
		ArrayDeque<Integer> station = new ArrayDeque<>();

		for(int i = 1; i <= n; i++) {
			dirA.offer(i);
		}

		NEXT_COACH: for(int num: permutation) {
			if(!dirA.isEmpty()) {
				while(!dirA.isEmpty()) {
					int currCoach = dirA.peekFirst();
					if(currCoach != num) {
						if(!station.isEmpty() && station.peekFirst() == num) {
							station.pop();
							continue NEXT_COACH;
						} else {
							dirA.pop();
							station.push(currCoach);
						}
					} else {
						dirA.pop();
						continue NEXT_COACH;
					}
				}
				writer.write("No\n");
				return;
			} else if(station.pop() == num) {
				continue;
			} else {
				writer.write("No\n");
				return;
			}
		}
		
		writer.write("Yes\n");
	}
}
