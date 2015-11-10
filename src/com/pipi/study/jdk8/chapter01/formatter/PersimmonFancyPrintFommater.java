package com.pipi.study.jdk8.chapter01.formatter;

import com.pipi.study.jdk8.chapter01.model.Persimmon;

public class PersimmonFancyPrintFommater implements PrintFommater{

	@Override
	public String getFormat(Persimmon p) {
		String weight = "fancy";
		if(p.getWeight() > 200) {
			weight = "heavy";
		}
		
		return "Persimmon weight is "+weight;
	}
	
}
