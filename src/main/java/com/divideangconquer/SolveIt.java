package com.divideangconquer;

import java.io.*;
import java.util.*;

//Uva 10341
public class SolveIt {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int p, q, r, s, t, u;
	static double EFS = 10e-15;
	
	public static void main(String[] args) throws Exception{
//		writer = new BufferedWriter(new FileWriter("output.txt"));
		String input, data[];
		while((input = reader.readLine()) != null) {
			data = input.split(" ");
			p = Integer.parseInt(data[0]); q = Integer.parseInt(data[1]); r = Integer.parseInt(data[2]); s = Integer.parseInt(data[3]);
			t = Integer.parseInt(data[4]); u = Integer.parseInt(data[5]);
			process();
//			writer.flush();
		}
		writer.close();
		reader.close();
	}
	
	static void process() throws Exception{
		double start = 0, end = 1, m; 
		if(calEquation(start)*calEquation(end) > 0) {
			writer.write("No solution\n");
			return;
		}
		while(start + EFS < end) {
			m = (start + end)/2;
			if(calEquation(start)*calEquation(m) <= 0) {
				end = m;
			} else {
				start = m;
			}
		}
		writer.write(String.format("%.4f\n", (start + end)/2));
	}
	
	static double calEquation(double x) {
		return p*(1/Math.pow(Math.E, x)) + q*Math.sin(x) + r*Math.cos(x) + s*Math.tan(x) + t*Math.pow(x, 2) + u;
	}
}
