package com.supereasy;

import java.util.*;
import java.io.*;

//11498
public class DivisionOfNlogonia {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String read;
		int q, data[], ox, oy;
		while(!(read = reader.readLine().trim()).equals("0")) {
			q = Integer.parseInt(read);
			data = Arrays.asList(reader.readLine().trim().split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
			ox = data[0]; oy = data[1];
			while(q != 0) {
				data = Arrays.asList(reader.readLine().trim().split(" ")).stream().mapToInt(s -> Integer.parseInt(s)).toArray();
				if(data[0] == ox || data[1] == oy) {
					writer.write("divisa\n");
				} else if(data[0] > ox && data[1] > oy) {
					writer.write("NE\n");
				} else if(data[0] < ox && data[1] > oy) {
					writer.write("NO\n");
				} else if(data[0] < ox && data[1] < oy) {
					writer.write("SO\n");
				} else if(data[0] > ox && data[1] < oy) {
					writer.write("SE\n");
				}
				--q;
			}
		}
		writer.close();
	}

}
