package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {

	private OutputStream out;
	
	public MyCompressorOutputStream(OutputStream out) {
		this.out = out;
	}
	
	@Override
	public void write(int b) throws IOException {
		System.out.println(b);
	}
	
	public void writeByteArray(byte[] input) throws IOException
	{
		byte last = input[0];
		int count = 0;
		for (byte b : input)
		{
			if(b == last)
			{
				count++;
			}
			else
			{
				write(count);
				write((int)last);
				count = 1;
				last = b;
			}
		}
	}

}
