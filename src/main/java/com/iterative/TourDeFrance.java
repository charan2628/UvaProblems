package com.iterative;

import java.util.*;
import java.io.*;

//Uva 11242
public class TourDeFrance {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	static int rear[], front[], r, f;

	public static void main(String[] args) throws Exception{
		String input, data[];
		while(!(input = reader.readLine()).equals("0")) {
			data = input.trim().split("\\s+");
			f = Integer.parseInt(data[0]); r =  Integer.parseInt(data[1]);
			front = new int[f]; rear = new int[r];
			data = reader.readLine().trim().split("\\s+");
			for(int i = 0; i < f; i++) {
				front[i] = Integer.parseInt(data[i]);
			}
			data = reader.readLine().trim().split("\\s+");
			for(int i = 0; i < r; i++) {
				rear[i] = Integer.parseInt(data[i]);
			}
			process();
		}
		writer.close();
		reader.close();
	}

	private static void process() throws Exception{
		double driveRatios[] = new double[r*f], maximumSpread = Double.MIN_VALUE; int counter = 0;
		for(int i = 0; i < f; i++) {
			for(int j = 0; j < r; j++) {
				double driveRatio = ((double)rear[j])/front[i];
				driveRatios[counter++] = driveRatio;
			}
		}
		Arrays.sort(driveRatios);

		for(int j = 0; j < counter-1; j++) {
			double spread = driveRatios[j+1]/driveRatios[j];
			if(spread > maximumSpread) {
				maximumSpread = spread;
			}
		}
		writer.write(String.format("%.2f\n", maximumSpread));
	}
}
