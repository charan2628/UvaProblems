package com.oneDarray;

import java.io.*;
import java.util.*;

//394
public class MapMaker {
	
	static BufferedReader reader = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static Map<String, Arr> arr;
	
	public static void main(String[] args) throws Exception{
		int n, r, n_b;
		String[] data;
		data = reader.readLine().trim().split(" ");
		n = Integer.parseInt(data[0]);
		r = Integer.parseInt(data[1]);
		arr = new HashMap<>();
		for(int i = 0; i < n; i++) {
			Arr tmp = new Arr();
			data = reader.readLine().trim().split("\\s+");
			tmp.name = data[0];
			tmp.base = Integer.parseInt(data[1]);
			tmp.size = Integer.parseInt(data[2]);
			n_b = Integer.parseInt(data[3]);
			tmp.constans = new int[n_b + 1];
			for(int j = 4; j < data.length; j += 2) {
				tmp.bounds.add(Pair.createPair(Integer.parseInt(data[j]), Integer.parseInt(data[j+1])));
			}
			calcConstants(tmp);
			arr.put(tmp.name, tmp);
		}
		for(int i = 0; i < r; i++) {
			data = reader.readLine().trim().split("\\s+");
			Arr currArr = arr.get(data[0]);
			writer.write(data[0]+"[");
			int constants[] = currArr.constans, result = 0;
			result = constants[0];
			for(int j = 1; j < data.length; j++) {
				if(j != 1) {
					writer.write(", ");
				}
				result += constants[j]*(Integer.parseInt(data[j]));
				writer.write("" + data[j]);
			}
			writer.write(String.format("] = %d\n", result));
		}
		writer.close();
		reader.close();
	}
	
	static void calcConstants(Arr arr) {
		int size = arr.size, n_b = arr.constans.length - 1, constants[] = arr.constans;
		constants[n_b] = size;
		constants[0] = arr.base;
		for(int i = n_b - 1; i > 0; i--) {
			Pair<Integer, Integer> pair = arr.bounds.get(i);
			constants[i] = constants[i+1]*(pair.second - pair.first + 1);
			constants[0] -= constants[i]*(arr.bounds.get(i-1).first);
		}
		constants[0] -= constants[n_b]*(arr.bounds.get(n_b - 1).first);
	}
	
	static class Arr{
		String name;
		int base;
		int size;
		List<Pair<Integer, Integer>> bounds = new ArrayList<>();
		int[] constans;
		
		Arr(String name, int base, int size, int n_b) {
			this.name = name;
			this.base = base;
			this.size = size;
			this.constans = new int[n_b];
		}
		
		Arr() {
			
		}
	}
	
	static class Pair<K, V> {
		K first;
		V second;
		
		Pair(K k, V v) {
			this.first = k;
			this.second = v;
		}
		
		static <K, V> Pair<K, V> createPair(K k, V v) {
			return new Pair<>(k, v);
		}
	}

}
