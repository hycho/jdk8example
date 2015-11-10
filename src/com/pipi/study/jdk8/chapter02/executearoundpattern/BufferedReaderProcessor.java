package com.pipi.study.jdk8.chapter02.executearoundpattern;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
	public String process(BufferedReader b) throws IOException;
}
