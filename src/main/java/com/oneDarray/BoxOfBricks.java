package com.oneDarray;

import java.util.*;
import java.io.*;

//591
public class BoxOfBricks {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		int data[], set = 0;
		while(!(reader.readLine()).equals("0")) {
			data = Arrays.asList(reader.readLine().trim().split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
			writer.write(String.format("Set #%d\n", ++set));
			writer.write(String.format("The minimum number of moves is %d.\n", moves(data)));
			writer.newLine();
		}
		writer.close();
		reader.close();
	}
	
	static int moves(int[] stacks) {
		int total = 0, height, moves = 0, curr;
		for(int i = 0; i < stacks.length; i++) {
			total += stacks[i];
		}
		height = total / stacks.length;
		for(int i = 0; i < stacks.length; i++) {
			curr = stacks[i];
			if(curr > height) 
				moves += (curr - height);
		}
		return moves;
	}
}
