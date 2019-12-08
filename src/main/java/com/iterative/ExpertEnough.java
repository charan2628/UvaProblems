package com.iterative;

import java.io.*;

//Uva 1237
public class ExpertEnough {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static Maker[] makers;
	
	
	public static void main(String[] args) throws Exception{
		int t = Integer.parseInt(reader.readLine()), q = 0;
		String input[];
		
		while(t-- != 0) {
			q = Integer.parseInt(reader.readLine());
			makers = new Maker[q];
			for(int i = 0; i < q; i++) {
				input = reader.readLine().split(" ");
				makers[i] = new Maker(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]));
			}
			q = Integer.parseInt(reader.readLine());
			for(int i = 0; i < q; i++) {
				process(Integer.parseInt(reader.readLine()));
			}
			if(t != 0)
				writer.newLine();
		}
		writer.close();
		reader.close();
	}
	
	static void process(int price) throws Exception{
		int count = 0; Maker result = null;
		for(Maker maker: makers) {
			if(price >= maker.low && price <= maker.high) {
				count++;
				result = maker;
				if(count > 1) {
					writer.write("UNDETERMINED\n");
					return;
				}
			}
		}
		if(count != 0) {
			writer.write(String.format("%s\n", result.name));
		} else {
			writer.write("UNDETERMINED\n");
		}
	}
	
	static class Maker {
		String name;
		int low;
		int high;
		
		public Maker(String name, int low, int high) {
			super();
			this.name = name;
			this.low = low;
			this.high = high;
		}
	}
}
