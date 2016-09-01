package algorithms.boot;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.demo.*;
import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3D;
import algorithms.mazeGenerators.SimpleMaze3dGenerator;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;


public class Run 
{
	public static void main(String[] args) throws IOException 
	{
		//Demo d = new Demo();
		//d.run();
		//MyCompressorOutputStream mc = new MyCompressorOutputStream(new OutputStream());
		
		Maze3D maze = (new SimpleMaze3dGenerator()).generate(5, 5, 5); //... generate it
		// save it to a file
		OutputStream out=new MyCompressorOutputStream(
		new FileOutputStream("1.maz"));
		byte[] mazeBytes = maze.toByteArray();
		out.write(mazeBytes);
		out.flush();
		out.close();
		InputStream in=new MyDecompressorInputStream(
		new FileInputStream("1.maz"));
		byte b[]=new byte[maze.toByteArray().length];
		in.read(b);
		in.close();
		Maze3D loaded=new Maze3D(b);
		System.out.println(loaded.equals(maze));
		
	}	
}