package com.dnyanshree.PatternCounter.view;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dnyanshree.PatternCounter.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class DisplayTest {
		
	@InjectMocks
	private Display display =  new Display();
	
	@Mock
	private Map<String, Integer> counts;
	private OutputStream os;
	private PrintStream ps;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		counts = null;
		//Prepare to redirect output
		os = new ByteArrayOutputStream();
		ps = new PrintStream(os);
		System.setOut(ps);
	}
		
	@Test
	public void testPrintOutputMethodForSelection1AndOutputIsNull() {		
		String expected = "No Words";		
		display.printOutput(counts, 1);
		assertEquals(expected+System.getProperty("line.separator"), os.toString());
	}
	
	@Test
	public void testPrintOutputMethodForSelection2AndOutputIsNull() {		
		String expected = "No Numbers";
		display.printOutput(counts, 2);
		assertEquals(expected+System.getProperty("line.separator"), os.toString());		
	}
	
	@Test
	public void testPrintOutputMethodForSelection3AndOutputIsNull() {		
		String expected = "No Phrases";
		display.printOutput(counts, 3);
		assertEquals(expected+System.getProperty("line.separator"), os.toString());		
	}
	
	@Test
	public void testPrintOutputMethodForWrongSelectionAndOutputIsNull() {		
		String expected = "Please enter a valid selection (1, 2 or 3)";
		display.printOutput(counts, 6);
		assertEquals(expected+System.getProperty("line.separator"), os.toString());	
	}	

	@After
	public void clear(){
		//Restore normal output
		PrintStream originalOut = System.out;
		System.setOut(originalOut);
	}
}
