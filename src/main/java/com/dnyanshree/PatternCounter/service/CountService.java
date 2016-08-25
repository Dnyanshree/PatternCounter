package com.dnyanshree.PatternCounter.service;

import java.util.List;
import java.util.Map;

public interface CountService {

	public Map<String,Integer> getUniqueWordCount(List<String> list);
	public Map<String,Integer> getUniqueNumberCount(List<String> list);
	public Map<String,Integer> getUniqueConsecutive3WordsCount(List<String> list);
}
