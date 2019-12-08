package com.iterative;

import java.util.*;
import java.io.*;

//Uva 735
public class DartAMania {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int score;

	public static void main(String[] args) throws Exception{
		int input;
		while((input = Integer.parseInt(reader.readLine().trim())) > 0) {
			score = input;
			process();
		}
		writer.write("END OF OUTPUT\n");
		writer.close();
		reader.close();
	}
	
	private static void process() throws Exception{
		Set<Triple> combinations = new HashSet<>();
		int permutations = 0;
		int[] possibleScores = {
				0,
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
				22, 24, 26, 28, 30, 32, 34, 36, 38, 40,
				21, 27, 33, 39, 42, 45, 48, 51, 54, 57, 60,
				50};
		for(int i = 0; i < possibleScores.length; i++) {
			for(int j = 0; j < possibleScores.length; j++) {
				for(int k = 0; k < possibleScores.length; k++) {
					if((possibleScores[i] + possibleScores[j] + possibleScores[k]) == score) {
						combinations.add(new Triple(possibleScores[i], possibleScores[j], possibleScores[k]));
						permutations++;
					}
				}
			}
		}
		if(permutations != 0) {
			writer.write(String.format("NUMBER OF COMBINATIONS THAT SCORES %d IS %d.\n", score, combinations.size()));
			writer.write(String.format("NUMBER OF PERMUTATIONS THAT SCORES %d IS %d.\n", score, permutations));
		} else {
			writer.write(String.format("THE SCORE OF %d CANNOT BE MADE WITH THREE DARTS.\n", score));
		}
		writer.write("**********************************************************************\n");
	}
	
	static class Triple {
		int a;
		int b;
		int c;
		
		public Triple(int a, int b, int c) {
			super();
			int[] order = {a, b, c};
			Arrays.sort(order);
			this.a = order[0];
			this.b = order[1];
			this.c = order[2];
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
			result = prime * result + c;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Triple other = (Triple) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			return true;
		}
	}
}
