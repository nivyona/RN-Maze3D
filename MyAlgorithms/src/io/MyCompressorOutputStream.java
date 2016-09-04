package io;

import java.io.IOException;
import java.io.OutputStream;

/**
* The MyCompressorOutputStream class takes stream and compress it to a byte array
*
* @author  Niv Yona @ Raz David
* @version 1.0
* @since   01-08-2016 
*/


public class MyCompressorOutputStream extends OutputStream {

	private OutputStream out;
	
	public MyCompressorOutputStream(OutputStream out) {
		this.out = out;
	}
	
	@Override
	public void write(byte[] input) throws IOException {
		byte last = input[0];
		int count = 0;
		for (byte b : input) // Compressing the data
		{
			if(b == last)
			{
				count++;
			}
			else
			{
				out.write(count);
				out.write((int)last);
				count = 1;
				last = b;
			}
		}
		if(count > 0)
 		{
			out.write(count);
			out.write((int)last);
 		}
	}

	@Override
	public void write(int b) throws IOException {
		out.write(b);
		
	}

}
