package com.stack;

import java.util.*;
import java.io.*;

//Uva 1062
public class Containers {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static int t = 0;

	public static void main(String[] args) throws Exception{
		String input;
		while(!(input = reader.readLine()).equals("end")) {
			t++;
			process(input.split(""));
		}
		writer.close();
		reader.close();
	}

	static void process(String[] order) throws Exception{
		List<Deque<String>> stacks = new ArrayList<>();
		OUTER: for(String c: order) {
			for(Deque<String> stack: stacks) {
				if(stack.peek().compareTo(c) >= 0) {
					stack.push(c);
					continue OUTER;
				}
			}
			Deque<String> newStack = new ArrayDeque<>();
			newStack.push(c);
			stacks.add(newStack);
		}
		writer.write(String.format("Case %d: %d\n", t, stacks.size()));
	}
}
