package com.treemap;

import java.io.*;
import java.util.*;

//uva 10226
public class HardwoodSpecies {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static TreeMap<String, Integer> mapping;
	static int total = 0;
	
	public static void main(String[] args) throws Exception{
		int cases = Integer.parseInt(reader.readLine());
		String data;
		reader.readLine();
		while(cases-- != 0) {
			mapping = new TreeMap<>(); total = 0;
			while((data = reader.readLine()) != null && !data.equals("")) {
				total++;
				mapping.compute(data, (k, v) -> v == null ? 1: ++v);
			}
			process();
			if(cases != 0)
				writer.newLine();
		}
		writer.close();
		reader.close();
	}
	
	static void process() throws Exception{
		for(String species: mapping.navigableKeySet()) {
			writer.write(String.format("%s %.4f\n", species, (double)mapping.get(species)/total * 100));
		}
	}
}
