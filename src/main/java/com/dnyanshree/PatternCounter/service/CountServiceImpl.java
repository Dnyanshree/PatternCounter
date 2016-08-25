package com.dnyanshree.PatternCounter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CountServiceImpl implements CountService{

	@Override
	public Map<String, Integer> getUniqueWordCount(List<String> words) {
		if(words == null){
		return null;
	}
	else{
		Map<String, Integer> counts = new HashMap<String,Integer>();
		for(int i=0; i<words.size(); i++){
			if(Character.isLetter(words.get(i).charAt(0))){
				String word = words.get(i);
			Integer count = counts.get(word);
			if(count==null){
				counts.put(word, 1);
			} else {
				counts.put(word, count+1);
			}}
		}
		return counts;
	}
	}

	@Override
	public Map<String, Integer> getUniqueNumberCount(List<String> words) {
		if(words == null){
		return null;
	}
	else{
		Map<String, Integer> counts = new HashMap<String,Integer>();	
		for(int i=0; i<words.size(); i++){
			if(Character.isDigit(words.get(i).charAt(0))){
				String word = words.get(i);				
			Integer count = counts.get(word);
			if(count==null){
				counts.put(word, 1);
			} else {
				counts.put(word, count+1);
			}}
		}
		return counts;
	}
	}

	@Override
	public Map<String, Integer> getUniqueConsecutive3WordsCount(List<String> words) {
		if(words == null){
			return null;
		}
		else if(words.size() < 3)
			return null;
		else{

			Map<String, Integer> counts = new HashMap<String,Integer>();
			for(int i=0; i<words.size()-2; i++){
				String phrase = words.get(i) + " " + words.get(i+1) + " " + words.get(i+2);
				Integer count = counts.get(phrase);
				if(count==null){
					counts.put(phrase, 1);
				} else {
					counts.put(phrase, count+1);
				}
			}
			return counts;
		}
	}

}
