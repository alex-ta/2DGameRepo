package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import console.GameConsole;

public class Reader {
	
	BufferedWriter writer;
	BufferedReader reader;
	
	public Reader(String fileName){
		changeFile(fileName);
	}
	
	public void changeFile(String fileName){
		if(writer != null){
			this.close();
		}
		
		File file = new File(fileName);
		try{
			this.writer = new BufferedWriter(new FileWriter(file));
			this.reader = new BufferedReader(new FileReader(file));
		}catch(FileNotFoundException e){
			GameConsole.print("The file "+fileName+" does not exist");
		} catch (IOException e) {
			GameConsole.print(e.getMessage());
		}
	}
	
	
	public void save(RootInterface save){
		try {
			writer.write(save.save());
			writer.flush();
		} catch (IOException e) {
			GameConsole.print(e.getMessage());
		}
	}
	
	public void load(RootInterface load){
		StringBuffer buff = new StringBuffer();
		try{
			String read = reader.readLine();
			while(read!= null){
				buff.append(read);
				read = reader.readLine();
			}
		} catch(Exception e){
			GameConsole.print(e.getMessage());
		}
		load.load(buff.toString());
	}
	
	public void close(){
		try {
			writer.close();
			reader.close();
		} catch (IOException e) {
			GameConsole.print(e.getMessage());
		}
	}
	
}
