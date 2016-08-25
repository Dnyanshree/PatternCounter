package com.dnyanshree.PatternCounter.model;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class InputDataTest {
	
	@InjectMocks
	private InputData id;	
	
	@Mock
	private List<String> words;	
	
	private String validInputFile;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		validInputFile = "Input";
		words = Arrays.asList("1000","a","big","surprise","2000","hello","is","a","big","surprise");
	}
		
	@Test
	public void testValidateChoiceMethodForValidInputChoice() {
		assertEquals(true, id.validateChoice(1));
		assertEquals(true, id.validateChoice(2));
		assertEquals(true, id.validateChoice(3));	
	}
	
	@Test
	public void testGetListOfWords() throws IOException {
		List<String> actual = id.getListOfWords(validInputFile);
		assertEquals(words, actual);
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetListOfWordsMethodException() throws IOException {
		String inputFile="abc";
		Mockito.when(id.getListOfWords(inputFile)).thenThrow(new FileNotFoundException());
	}
	
	@Test
	public void testValidateChoiceMethodForInvalidInputChoice() {
		assertEquals(false, id.validateChoice(4));
		assertEquals(false, id.validateChoice(5675));
		assertEquals(false, id.validateChoice(-1423));
	}

}
