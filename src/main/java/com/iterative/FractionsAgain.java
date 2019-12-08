package com.iterative;

import java.util.*;
import java.io.*;

//Uva 0976
public class FractionsAgain {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static Fraction k;
	static List<Pair> results;
	
	public static void main(String[] args) throws Exception{
		String input;
		while((input = reader.readLine()) != null) {
			k = new Fraction(1, Integer.parseInt(input));
			results = new ArrayList<>();
			process();
		}
		writer.close();
		reader.close();
	}
	
	static void process() throws Exception{
		for(int i = k.b+1; i <= k.b*2; i++) {
			Fraction y = new Fraction(1, i);
			Fraction x = getX(y);
			if(x.a == 1) {
				results.add(new Pair(x.b, y.b));
			}
		}
		writer.write(String.format("%d\n", results.size()));
		for(Pair pair: results) {
			writer.write(String.format("1/%d = 1/%d + 1/%d\n", k.b, pair.x, pair.y));
		}
	}
	
	private static Fraction getX(Fraction y) {
		int num = (k.a*y.b) - (y.a*k.b), den = k.b*y.b;
		Fraction x = new Fraction(num, den);
		if(num != 1) {
			int div = den/num;
			if(num*div == den) {
				x.a = 1;
				x.b = div;
			} else {
				x.a = num; x.b = den;
			}
		}
		return x;
	}
	
	static class Fraction {
		int a;
		int b;
		
		Fraction(int a, int b) {
			this.a = a; this.b = b;
		}
	}
	
	static class Pair {
		int x;
		int y;
		
		Pair(int x, int y) {
			this.x = x; this.y = y;
		}
	}
}
