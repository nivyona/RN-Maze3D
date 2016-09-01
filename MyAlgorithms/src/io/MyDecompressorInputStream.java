package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream { 

	private InputStream in;
	
	public MyDecompressorInputStream(InputStream in) {
		this.in = in;
	}

	@Override
	public int read() throws IOException {
		return in.read();
	}
	@Override
	public int read(byte[] b) throws IOException{
		int count;
		byte status;
		int bcounter = 0;
		while(in.available() > 0)
		{
			count = in.read();
			status = (byte)in.read();
			for(int j = 0; j < count; j++)
			{
				b[bcounter+j] = status;
			}
			bcounter += count;
		}
		
		return 1;
	}
}
