package com.medium;

import java.util.*;
import java.io.*;

//10141
public class RequestForProposal {

	static BufferedReader reader = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static Set<String> req;
	static Map<String, Pair<Double, Integer>> list;
	static Map<String, Integer> positions;
	
	public static void main(String[] args) throws Exception{
		int data[], r, p, cR, rfp = 0;
		String companyName, input[];
		double price;
		List<String> compReq;
		while(true) {
			data = Arrays.asList(reader.readLine().split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
			if(data[0] == 0) 
				break;
			req = new HashSet<>();
			list = new HashMap<>();
			positions = new HashMap<>();
			r = data[0]; p = data[1];
			while(data[0]-- != 0) {
				req.add(reader.readLine());
			}
			while(p-- != 0) {
				companyName = reader.readLine();
				input = reader.readLine().split(" ");
				price = Double.parseDouble(input[0]);
				cR = Integer.parseInt(input[1]);
				compReq = new ArrayList<>();
				while(cR-- != 0) {
					compReq.add(reader.readLine());
				}
				positions.put(companyName, r);
				list.put(companyName, process(companyName, price, compReq));
			}
			rfp++;
			result(rfp);
		}
		writer.close();
		reader.close();
	}
	
	static Pair<Double, Integer> process(String name, double price, List<String> reqs) {
		int reqMet = 0;
		for(String eachReq: reqs) {
			if(req.contains(eachReq)) {
				reqMet++;
			}
		}
		return Pair.createPair(price, reqMet);
	}
	
	static void result(int rfp) throws Exception{
		List<String> selectedCompanies = new ArrayList<>();
		Set<String> companies = list.keySet();
		int max = Integer.MIN_VALUE;
		for(String company: companies) {
			Pair<Double, Integer> data = list.get(company);
			if(data.second > max) {
				selectedCompanies.removeIf(s -> true);
				selectedCompanies.add(company);
				max = data.second;
			} else if (data.second == max) {
				selectedCompanies.add(company);
			}
		}
		if(selectedCompanies.size() == 1) {
			writer.write(String.format("RFP #%d\n", rfp));
			writer.write(String.format("%s\n\n", selectedCompanies.get(0)));
			return;
		} else {
			List<String> finalCompanies = new ArrayList<>();
			double minPrice = Integer.MAX_VALUE;
			for(String company: selectedCompanies) {
				Pair<Double, Integer> data = list.get(company);
				if(data.first < minPrice) {
					finalCompanies.removeIf(s -> true);
					finalCompanies.add(company);
					minPrice = data.first;
				} else if(data.first == minPrice) {
					finalCompanies.add(company);
				}
			}
			if(finalCompanies.size() == 1) {
				writer.write(String.format("RFP #%d\n", rfp));
				writer.write(String.format("%s\n\n", finalCompanies.get(0)));
				return;
			} else {
				max = Integer.MIN_VALUE;
				String finalCompany = null;
				for(String company: finalCompanies) {
					int position = positions.get(company);
					if(position > max) {
						max = position;
						finalCompany = company;
					}
				}
				writer.write(String.format("RFP #%d\n", rfp));
				writer.write(String.format("%s\n\n", finalCompany));
				return;
			}
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
