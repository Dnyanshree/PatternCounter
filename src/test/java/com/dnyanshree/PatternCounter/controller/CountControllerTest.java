package com.dnyanshree.PatternCounter.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dnyanshree.PatternCounter.TestConfig;
import com.dnyanshree.PatternCounter.exception.InvalidChoiceException;
import com.dnyanshree.PatternCounter.model.InputData;
import com.dnyanshree.PatternCounter.service.CountService;
import com.dnyanshree.PatternCounter.service.CountServiceImpl;
import com.dnyanshree.PatternCounter.view.Display;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class CountControllerTest {
	
	@Mock
	private CountService service = new CountServiceImpl();	
	
	@Mock
	private Display display;
	
	@Mock
	private InputData input;
	
	@Mock
	private Map<String, Integer> counts;
	
	@Mock
	private List<String> list;
	
	@InjectMocks
	private CountController cc= new CountController();;	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
			
	}
	
	@Test
	public void testGetUniqueWordCount(){		
		Mockito.when(service.getUniqueWordCount(list)).thenReturn(counts);		
		cc.getUniqueWordCount(list);
		Mockito.verify(display).printOutput(counts, 1);
	}
	
	@Test
	public void testGetUniqueNumberCount(){
		Mockito.when(service.getUniqueNumberCount(list)).thenReturn(counts);		
		cc.getUniqueNumberCount(list);
		Mockito.verify(display).printOutput(counts, 2);
	}
	
	@Test
	public void testGetUniqueConsecutive3WordsCount(){
		Mockito.when(service.getUniqueConsecutive3WordsCount(list)).thenReturn(counts);		
		cc.getUniqueConsecutive3WordsCount(list);
		Mockito.verify(display).printOutput(counts, 3);
	}
	
	@Test
	public void testValidateChoice(){
		Mockito.when(input.validateChoice(1)).thenReturn(true);
	}
	@Test
	public void testValidateChoiceException(){
		Mockito.when(input.validateChoice(4)).thenThrow(new InvalidChoiceException("Invalid Choice. Choose between 1, 2 and 3."));	
	}
	
	@Test
	public void testGetListOfWords() throws IOException{
		Mockito.when(input.getListOfWords("Input")).thenReturn(list);
	}
	
	@Test
	public void testGetListOfWordsException() throws IOException{
		Mockito.when(input.getListOfWords("abc")).thenThrow(new FileNotFoundException());
	}
}
