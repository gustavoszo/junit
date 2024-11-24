package br.com.javatests.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TestList {
	
	@Test
	void TestMockingList_WhenSizeIsCalled_ShouldReturn10() {
		List list = mock(List.class);
		when(list.size()).thenReturn(10);
		
		assertEquals(10, list.size());
	}
	
	@Test
	void TestMockingList_WhenSizeIsCalled_ShouldReturnMultiple() {
		List list = mock(List.class);
		when(list.size()).thenReturn(10).thenReturn(20);
		
		assertEquals(10, list.size());
		assertEquals(20, list.size());
	}
	
	@Test
	void TestMockingList_WhenGetIsCalled_ShouldReturnGustavo() {
		List list = mock(List.class);
		when(list.get(0)).thenReturn("Gustavo");
		
		assertEquals("Gustavo", list.get(0));
		assertNull(list.get(1));
	}
	
	@Test
	void TestMockingList_WhenGetIsCalledWithArgumentMatcher_ShouldReturnGustavo() {
		List list = mock(List.class);
		given(list.get(anyInt())).willReturn("Gustavo");
		
		assertThat(list.get(0), is("Gustavo"));
	}
	
	@Test
	void TestMockingList_WhenAnyInt_ShouldReturnRunTimeException() {
		List list = mock(List.class);
		when(list.get(anyInt())).thenThrow(new RuntimeException("Message"));
		
		assertThrows(RuntimeException.class, () -> {
			list.get(5);
		}, () -> "Should have throw an RuntimeException");
	}

}
