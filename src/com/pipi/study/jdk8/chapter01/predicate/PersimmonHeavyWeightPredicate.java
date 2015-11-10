package com.pipi.study.jdk8.chapter01.predicate;

import com.pipi.study.jdk8.chapter01.model.Persimmon;

public class PersimmonHeavyWeightPredicate implements PersimmonPredicate{

	@Override
	public boolean test(Persimmon persimmon) {
		return persimmon.getWeight() > 200;
	}
	
}
