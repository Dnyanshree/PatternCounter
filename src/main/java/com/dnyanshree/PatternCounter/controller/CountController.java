package com.dnyanshree.PatternCounter.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dnyanshree.PatternCounter.exception.InvalidChoiceException;
import com.dnyanshree.PatternCounter.model.InputData;
import com.dnyanshree.PatternCounter.service.CountService;
import com.dnyanshree.PatternCounter.view.Display;

@Controller
public class CountController {	
	
	@Autowired
	private CountService service;	
	
	@Autowired
	private Display display;
	
	@Autowired
	private InputData input;	

	public void getUniqueWordCount(List<String> list) {		
		Map<String, Integer> counts = service.getUniqueWordCount(list);
		display.printOutput(counts, 1);
	}

	public void getUniqueNumberCount(List<String> list) {
		Map<String, Integer> counts = service.getUniqueNumberCount(list);
		display.printOutput(counts, 2);
	}

	public void getUniqueConsecutive3WordsCount(List<String> list) {	
		Map<String, Integer> counts = service.getUniqueConsecutive3WordsCount(list);
		display.printOutput(counts, 3);
		
	}
	
	public void validateChoice(int choice){
		if(!input.validateChoice(choice)){	
			throw new InvalidChoiceException("Invalid Choice. Choose between 1, 2 and 3.");
		}
	}
	
	public List<String> getListOfWords(String textFile) throws IOException {
		return input.getListOfWords(textFile);		
	}
	
}
