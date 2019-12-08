package com.treeset;

import java.io.*;
import java.util.*;

//uva 978
public class LemmingsBattle {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int battlefields, sgreen, sblue;
	static PriorityQueue<Pair> greenArmy = new PriorityQueue<>((p1, p2) -> p2.powerLevel - p1.powerLevel), 
			blueArmy = new PriorityQueue<>((p1, p2) -> p2.powerLevel - p1.powerLevel);
	
	public static void main(String[] args) throws Exception{
		int cases = Integer.parseInt(reader.readLine());
		String data[];
		while(cases-- != 0) {
			greenArmy.clear(); blueArmy.clear();
			data = reader.readLine().trim().split(" ");
			battlefields = Integer.parseInt(data[0]); sgreen = Integer.parseInt(data[1]); sblue = Integer.parseInt(data[2]);
			for(int i = 0; i < sgreen; i++) {
				greenArmy.add(Pair.createPair(i, Integer.parseInt(reader.readLine())));
			}
			for(int i = 0; i < sblue; i++) {
				blueArmy.add(Pair.createPair(i, Integer.parseInt(reader.readLine())));
			}
			process();
			if(cases != 0)
				writer.newLine();
		}
		writer.close();
		reader.close();
	}
	
	static void process() throws Exception{
		List<Pair> greenWon = new ArrayList<>(), blueWon = new ArrayList<>();
		
		while(!greenArmy.isEmpty() && !blueArmy.isEmpty()) {
			for(int i = 0; i < battlefields; i ++) {
				if(greenArmy.isEmpty() || blueArmy.isEmpty())
					break;
				Pair greenSoldier = greenArmy.poll();
				Pair blueSoldier = blueArmy.poll();
				if(greenSoldier.powerLevel > blueSoldier.powerLevel) {
					greenSoldier.powerLevel -= blueSoldier.powerLevel;
					greenWon.add(greenSoldier);
				} else if (greenSoldier.powerLevel < blueSoldier.powerLevel) {
					blueSoldier.powerLevel -= greenSoldier.powerLevel;
					blueWon.add(blueSoldier);
				}
			}
			for(int i = 0; i < greenWon.size(); i++) {
				greenArmy.add(greenWon.get(i));
			}
			greenWon.clear();
			for(int i = 0; i < blueWon.size(); i++) {
				blueArmy.add(blueWon.get(i));
			}
			blueWon.clear();
		}
		if(greenArmy.isEmpty() && blueArmy.isEmpty()) {
			writer.write("green and blue died\n");
		} else if(greenArmy.isEmpty()) {
			writer.write("blue wins\n");
			while(!blueArmy.isEmpty()) {
				writer.write(String.format("%d\n", blueArmy.poll().powerLevel));
			}
		} else {
			writer.write("green wins\n");
			while(!greenArmy.isEmpty()) {
				writer.write(String.format("%d\n", greenArmy.poll().powerLevel));
			}
		}
	}
	
	static class Pair {
		int id;
		int powerLevel;
		
		Pair(int id, int powerLevel) {
			this.id = id;
			this.powerLevel = powerLevel;
		}
		
		static Pair createPair(int id, int powerLevel) {
			return new Pair(id, powerLevel);
		}
		
		@Override
		public boolean equals(Object o) {
			if(((Pair)o).id == this.id)
				return true;
			return false;
		}
	}
}
