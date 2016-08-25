package com.dnyanshree.PatternCounter.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class CountServiceImplTest {
	
	@InjectMocks
	private CountService cs = new CountServiceImpl();	
	
	@Mock
	private List<String> words;
	
	@Mock
	private Map<String, Integer> counts;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);	
	}

	@Test
	public void testGetUniqueWordCount() {	
		List<String> wordList = Arrays.asList("1000","a","big");//making words non empty
		Map<String, Integer> expected = new HashMap<String, Integer>();
		expected.put("a", 1);
		expected.put("big", 1);
		Map<String, Integer> actual = cs.getUniqueWordCount(wordList);
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testGetUniqueWordCountNull() {
		words=null;		
		Map<String, Integer> actual = cs.getUniqueWordCount(words);
		assertEquals(null, actual);
	}
	
	
	@Test
	public void testGetUniqueNumberCount(){
		List<String> wordList = Arrays.asList("1000","a","big");//making words non empty
		Map<String, Integer> expected = new HashMap<String, Integer>();
		expected.put("1000", 1);		
		Map<String, Integer> actual = cs.getUniqueNumberCount(wordList);
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testGetUniqueNumberCountNull(){
		words=null;		
		Map<String, Integer> actual = cs.getUniqueNumberCount(words);
		assertEquals(null, actual);
	}
	
	@Test
	public void testGetUniqueConsecutive3WordsCount(){
		List<String> wordList = Arrays.asList("1000","a","big");//making words non empty
		Map<String, Integer> expected = new HashMap<String, Integer>();
		expected.put("1000 a big", 1);		
		Map<String, Integer> actual = cs.getUniqueConsecutive3WordsCount(wordList);
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testGetUniqueConsecutive3WordsCountNull(){
		words=null;		
		Map<String, Integer> actual = cs.getUniqueConsecutive3WordsCount(words);
		assertEquals(null, actual);
	}
}
