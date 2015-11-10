package com.pipi.study.jdk8.chapter02.executearoundpattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println(readFileProcess(new File("D:/temp/test.txt"), (BufferedReader in) -> in.readLine()));
			
			System.out.println(readFileProcess(new File("D:/temp/test.txt"), (BufferedReader in) -> in.readLine() + in.readLine()));
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static String readFileProcess(File file, BufferedReaderProcessor p) throws IOException{
		String result = "";

		if(file.canRead()) {
			BufferedReader in = new BufferedReader(new FileReader(file));
			result = p.process(in);
		} else {
			throw new FileNotFoundException();
		}
		
		return result;
	}

}
