package com.dnyanshree.PatternCounter.view;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Display {

	public void printOutput(Map<String, Integer> counts, int selection){		
			switch (selection) {
			case 1: {
				if(counts == null){
				System.out.println("No Words");
				}	
				else
					show(counts);
				break;
			}
			case 2:{
				if(counts == null){
					System.out.println("No Numbers");
					}	
					else
						show(counts);
					break;
			}
			case 3:{	
				if(counts == null){
					System.out.println("No Phrases");
					}	
					else
						show(counts);
					break;
			}
			default:{
				System.out.println("Please enter a valid selection (1, 2 or 3)");
				break;
			}			
		}		
	}
	
	public void show(Map<String, Integer> counts){	
	for (Map.Entry<String,Integer> entry : counts.entrySet()) {
		System.out.println(entry.getKey() + ", " + entry.getValue());					
		}
	}
}
