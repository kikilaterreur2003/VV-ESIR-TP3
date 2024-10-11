package fr.istic.vv;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TLSSocketFactoryTestMocks {


	@Test
	public void testEmptyEmpty() {
		//prepare stub
		SSLSocket socket = mock(SSLSocket.class);
		
		when(socket.getEnabledProtocols()).thenReturn(new String[] {});
		when(socket.getSupportedProtocols()).thenReturn(new String[] {});

		
		doAnswer(invocation ->{
			assertEquals(invocation.getArgument(0), new String[] {});
			return null;
		}).when(socket).setEnabledProtocols(any());
	}
	
	@Test
	public void testEmptyWeird() {
		//prepare stub
		SSLSocket socket = mock(SSLSocket.class);
		
		when(socket.getEnabledProtocols()).thenReturn(new String[] {});
		when(socket.getSupportedProtocols()).thenReturn(new String[] {"SSLv3", "TLSv1","I'm weird"});
		
		//run the test
		TLSSocketFactory f = new TLSSocketFactory();
		f.prepareSocket(socket);
		for (String item : socket.getEnabledProtocols()) {
			System.out.println(item);
		}
		
		doAnswer(invocation ->{
			assertEquals(invocation.getArgument(0), new String[] {"TLSv1", "SSLv3"});
			return null;
		}).when(socket).setEnabledProtocols(any());
	}
	
	
	@Test
	public void testEmptyNormal() {
		//prepare stub
		SSLSocket socket = mock(SSLSocket.class);
		
		when(socket.getEnabledProtocols()).thenReturn(new String[] {});
		when(socket.getSupportedProtocols()).thenReturn(new String[] {"TLSv1", "SSLv3"});
		
		//run the test
		TLSSocketFactory f = new TLSSocketFactory();
		f.prepareSocket(socket);
		
		doAnswer(invocation ->{
			assertEquals(invocation.getArgument(0), new String[] {"TLSv1", "SSLv3"});
			return null;
		}).when(socket).setEnabledProtocols(any());
	}
	
	@Test
	public void testWeirdEmpty() {
		//prepare stub
		SSLSocket socket = mock(SSLSocket.class);
		
		when(socket.getEnabledProtocols()).thenReturn(new String[] {"TLSv1", "SSLv3","i'm weird"});
		when(socket.getSupportedProtocols()).thenReturn(new String[] {});
		
		//run the test
		TLSSocketFactory f = new TLSSocketFactory();
		f.prepareSocket(socket);

		doAnswer(invocation ->{
			assertEquals(invocation.getArgument(0), new String[] {});
			return null;
		}).when(socket).setEnabledProtocols(any());
	}
	
	@Test
	public void testWeirdWeird() {
		//prepare stub
		SSLSocket socket = mock(SSLSocket.class);
		
		when(socket.getEnabledProtocols()).thenReturn(new String[] {"TLSv1", "SSLv3","i'm weird"});
		when(socket.getSupportedProtocols()).thenReturn(new String[] {"TLSv1.2","TLSv1", "SSLv3","i'm weird"});
		
		//run the test
		TLSSocketFactory f = new TLSSocketFactory();
		f.prepareSocket(socket);
		doAnswer(invocation ->{
			assertEquals(invocation.getArgument(0), new String[] {"TLSv1.2", "TLSv1", "SSLv3"});
			return null;
		}).when(socket).setEnabledProtocols(any());
	}
	
	@Test
	public void testWeirdNormal() {
		//prepare stub
		SSLSocket socket = mock(SSLSocket.class);
		
		when(socket.getEnabledProtocols()).thenReturn(new String[] {"TLSv1", "SSLv3","i'm weird"});
		when(socket.getSupportedProtocols()).thenReturn(new String[] {"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});
		
		//run the test
		TLSSocketFactory f = new TLSSocketFactory();
		f.prepareSocket(socket);

		doAnswer(invocation ->{
			assertEquals(invocation.getArgument(0), new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"});
			return null;
		}).when(socket).setEnabledProtocols(any());
	}
	
	@Test
	public void testNormalEmpty() {
		//prepare stub
		SSLSocket socket = mock(SSLSocket.class);
		
		when(socket.getEnabledProtocols()).thenReturn(new String[] {"TLSv1.2", "TLSv1"});
		when(socket.getSupportedProtocols()).thenReturn(new String[] {});
		
		//run the test
		TLSSocketFactory f = new TLSSocketFactory();
		f.prepareSocket(socket);
		doAnswer(invocation ->{
			assertEquals(invocation.getArgument(0), new String[] {});
			return null;
		}).when(socket).setEnabledProtocols(any());

	}
	
	@Test
	public void testNormalWeird() {
		//prepare stub
		SSLSocket socket = mock(SSLSocket.class);
		
		when(socket.getEnabledProtocols()).thenReturn(new String[] {"TLSv1.2", "TLSv1"});
		when(socket.getSupportedProtocols()).thenReturn(new String[] {"TLSv1.2", "i'm weird"});
		
		//run the test
		TLSSocketFactory f = new TLSSocketFactory();
		f.prepareSocket(socket);
		doAnswer(invocation ->{
			assertEquals(invocation.getArgument(0), new String[] {"TLSv1.2"});
			return null;
		}).when(socket).setEnabledProtocols(any());

	}
	
	@Test
	public void testNormalNormal() {
		//prepare stub
		SSLSocket socket = mock(SSLSocket.class);
		
		when(socket.getEnabledProtocols()).thenReturn(new String[] {"TLSv1.2", "TLSv1"});
		when(socket.getSupportedProtocols()).thenReturn(new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"});
		
		//run the test
		TLSSocketFactory f = new TLSSocketFactory();
		f.prepareSocket(socket);

		doAnswer(invocation ->{
			assertEquals(invocation.getArgument(0), new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"});
			return null;
		}).when(socket).setEnabledProtocols(any());
		
	}
		
}