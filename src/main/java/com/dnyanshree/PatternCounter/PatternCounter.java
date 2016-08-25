package com.dnyanshree.PatternCounter;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.dnyanshree.PatternCounter.controller.CountController;

public class PatternCounter {

	public static void main(String[] args) throws IOException{
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		CountController controller = context.getBean(CountController.class);

		String textFile = args[0];
		int choice = Integer.parseInt(args[1]);	
		List<String> words = controller.getListOfWords(textFile);
		controller.validateChoice(choice);
		
		switch (choice) {
		case 1: {
			controller.getUniqueWordCount(words);
			break;
		}
		case 2:{
			controller.getUniqueNumberCount(words);
			break;
		}
		case 3:{
			controller.getUniqueConsecutive3WordsCount(words);
			break;
		}
		default:{
			System.out.println("Please enter a valid option (1, 2 or 3)! Try again!");
			break;
		}
		}	
		context.close();
	}	
	
}
