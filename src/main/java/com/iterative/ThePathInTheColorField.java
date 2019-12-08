package com.iterative;

import java.util.*;
import java.io.*;


//Uva  10102
public class ThePathInTheColorField {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static List<Pair> ones, threes;
	
	public static void main(String[] args) throws Exception{
		String input, data[];
		while((input = reader.readLine()) != null) {
			int m = Integer.parseInt(input);
			ones = new ArrayList<>(); threes = new ArrayList<>();
			for(int i = 0; i < m; i++) {
				data = reader.readLine().trim().split("");
				for(int j = 0; j < m; j++) {
					int k = Integer.parseInt(data[j]);
					if(k == 1) {
						ones.add(new Pair(i, j));
					} else if(k == 3) {
						threes.add(new Pair(i, j));
					}
				}
			}
			process();
		}
		writer.close();
		reader.close();
	}
	
	static void process() throws Exception {
		int minimalPath = Integer.MIN_VALUE;
		for(Pair one: ones) {
			int shortestPath = Integer.MAX_VALUE;
			for(Pair three: threes) {
				int manhattanDistance = Math.abs(one.x - three.x) + Math.abs(one.y - three.y);
				if(manhattanDistance < shortestPath) {
					shortestPath = manhattanDistance;
				}
			}
			if(shortestPath > minimalPath) {
				minimalPath = shortestPath;
			}
		}
		writer.write(String.format("%d\n", minimalPath));
	}
	
	static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
