package com.dnyanshree.PatternCounter.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class InputData {	
	
	public boolean validateChoice(int choice){		
			if(choice>=1 && choice <=3){
				return true;
			}		
		return false;		
	}
	
	public List<String> getListOfWords(String inputFile) throws IOException{
		List<String> lines = new ArrayList<String>();
		List<String> words = new ArrayList<String>();
		 InputStream fis = this.getClass().getClassLoader().getResourceAsStream(inputFile+".txt");
		 InputStreamReader isr = new InputStreamReader(fis);
		 BufferedReader reader = new BufferedReader(isr);
	    String line;
	    while ((line = reader.readLine()) != null)
	    {
	    	lines.add(line);
	    }
	    reader.close();
	    for(int k=0; k< lines.size(); k++){
	    	String str = lines.get(k).replaceAll("[^A-Za-z0-9]", " ");//replace all punctuation with single space
	    	str = str.replaceAll("[\\n\\t]", "");//replace all new lines and tables with no space
	    	str = str.replaceAll("( )+", " ");//replace all multiple spaces with single space
	    	str = str.trim();//remove spaces before and after line
	    	String[] split = str.split(" ");
	    	for (String s : split) {					
	    		words.add(s);
	    	}
	    }
	    if(words.size()>0)
	    words.remove(words.size()-1);//remove single space added at the end of list of words
	    return words;
	}
}
