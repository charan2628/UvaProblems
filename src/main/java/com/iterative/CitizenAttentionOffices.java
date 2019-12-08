package com.iterative;

import java.util.*;
import java.io.*;

//Uva 10660
public class CitizenAttentionOffices {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static Triple[] cities;
	
	public static void main(String[] args) throws Exception{
		String data[]; 
		int t = Integer.parseInt(reader.readLine());
		while(t-- != 0) {
			int n = Integer.parseInt(reader.readLine());
			cities = new Triple[n];
			for(int i = 0; i < n; i++) {
				data = reader.readLine().split(" ");
				cities[i] = new Triple(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
			}
			process();
		}
		writer.close();
		reader.close();
	}
	
	static void process() throws Exception{
		int minTotalDistance = Integer.MAX_VALUE; Pair[] bestOffices = null;
		for(int i = 0; i < 21; i++) {
			for(int j = i+1; j < 22; j++) {
				for(int k = j+1; k < 23; k++) {
					for(int l = k+1; l < 24; l++) {
						for(int m = l+1; m < 25; m++) {
							Pair[] offices = new Pair[5];
							offices[0] = new Pair(i/5, i%5); offices[1] = new Pair(j/5, j%5); offices[2] = new Pair(k/5, k%5);
							offices[3] = new Pair(l/5, l%5); offices[4] = new Pair(m/5, m%5);
							int totalDistance = 0;
							for(Triple city: cities) {
								int minDistance = Integer.MAX_VALUE;
								for(Pair office: offices) {
									int distance = city.ppl * (Math.abs(office.x - city.x) + Math.abs(office.y - city.y));
									if(distance < minDistance) {
										minDistance = distance;
									}
								}
								totalDistance += minDistance;
							}
							if(totalDistance < minTotalDistance) {
								minTotalDistance = totalDistance;
								bestOffices = Arrays.copyOf(offices, 5);
							}
						}
					}
				}
			}
		}
		writer.write(String.format("%d %d %d %d %d\n", 
				bestOffices[0].x * 5 + bestOffices[0].y,
				bestOffices[1].x * 5 + bestOffices[1].y,
				bestOffices[2].x * 5 + bestOffices[2].y,
				bestOffices[3].x * 5 + bestOffices[3].y,
				bestOffices[4].x * 5 + bestOffices[4].y));
	}
	
	static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
	}
	
	static class Triple {
		int x;
		int y;
		int ppl;
		
		public Triple(int x, int y, int ppl) {
			super();
			this.x = x;
			this.y = y;
			this.ppl = ppl;
		}
	}
}
