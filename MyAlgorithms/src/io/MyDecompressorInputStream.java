package io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyDecompressorInputStream extends OutputStream { 

	private InputStream in;
	
	public MyDecompressorInputStream(InputStream in) {
	
	}
	
	@Override
	public void write(int b) throws IOException {
		// TODO Auto-generated method stub
	}
}
