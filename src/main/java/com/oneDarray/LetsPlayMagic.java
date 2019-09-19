package com.oneDarray;

import java.io.*;
import java.util.*;

//10978
public class LetsPlayMagic {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static String[] arrangments;
	
	public static void main(String[] args) throws Exception{
		int n, i;
		String read, data[];
		while(!(read = reader.readLine()).equals("0")) {
			n = Integer.parseInt(read);
			i = n;
			arrangments = new String[n];
			List<Pair<String, String>> cards = new ArrayList<>();
			while(i-- != 0) {
				data = reader.readLine().split(" ");
				cards.add(Pair.createPair(data[0], data[1]));
			}
			arrangement(cards, n);
		}
		writer.close();
		reader.close();
	}
	
	static void arrangement(List<Pair<String, String>> cards, int n) throws Exception {
		int l = 0, runner = -1;
		for(Pair<String, String> card: cards) {
			l = card.second.length();
			for(int i = 0; i < l; i++) {
				runner = ++runner % n;
				if(arrangments[runner] == null) {
					continue;
				} else {
					while(arrangments[runner] != null)
						runner = ++runner % n;
				}
			}
			arrangments[runner] = card.first;
		}
		writer.write(String.format("%s\n", String.join(" ", Arrays.asList(arrangments))));
	}
	
	static class Pair<K, V> {
		K first;
		V second;
		
		Pair(K k, V v) {
			this.first = k;
			this.second = v;
		}
		
		static<K, V> Pair<K, V> createPair(K k, V v) {
			return new Pair<>(k, v);
		}
	}
}
