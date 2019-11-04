package com.collections;

import java.io.*;
import java.util.*;

//10258
public class ContestScoreboard {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception{
		
		int n = Integer.parseInt(reader.readLine());
		Map<Integer, Contestant> map;
		String input, data[];

		reader.readLine();

		while(n-- != 0) {
			map = new HashMap<>();

			while((input = reader.readLine()) != null && !input.trim().equals("")) {
				data = input.split(" ");
				int id = Integer.parseInt(data[0]), prob = Integer.parseInt(data[1]);
				String result = data[3];
				
				Contestant c = map.getOrDefault(id, new Contestant());
				c.id = id;
				if(result.equals("C") && c.incorrect[prob] != -1) {
					c.solved++;
					c.penality += Integer.parseInt(data[2]) + 20*c.incorrect[prob];
					c.incorrect[prob] = -1;
				} else if(result.equals("I") && c.incorrect[prob] != -1) {
					c.incorrect[prob]++;
				}
				map.put(id, c);
				
			}

			List<Contestant> list = new ArrayList<>();
			for(Contestant c: map.values()) {
				list.add(c);
			}

			Collections.sort(list, (a, b) -> {
				if(a.solved == b.solved) {
					if(a.penality == b.penality) {
						return a.id - b.id;
					} else {
						return a.penality - b.penality;
					}
				} else {
					return b.solved - a.solved;
				}
			});

			for(Contestant c: list) {
				writer.write(String.format("%d %d %d\n", c.id, c.solved, c.penality));
			}
			if(n != 0) {
				writer.newLine();
			}
		}

		writer.close();
	}

	static class Contestant {
		int id;
		int solved;
		int penality;
		int[] incorrect = new int[10];
	}
}

/**

1 2 10 I
3 1 11 C
1 2 19 R
1 2 21 C
1 1 25 C

 */