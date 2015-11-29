package gui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import console.GameConsole;

public class ImageReader {

	private final String ending;
	
	public ImageReader(){
		ending = "png jpg jpeg";
	}
	
	public BufferedImage read(String path){
		return read(new File(path));
	}
	
	public BufferedImage[] readFolder(String folder){
		File file = new File(folder);
		File[] files = file.listFiles();
		if(files == null){
			GameConsole.print("Directory "+file.getName()+" not found");
			return null;
		}
		LinkedList<Image> imgs = new LinkedList<Image>();
		for(int i = 0; i < files.length; i++){
			File f = files[i];
			String type = f.getName().substring(f.getName().lastIndexOf("."));
			if(ending.contains(type)){
				BufferedImage img = read(f);
				if(img != null){
					imgs.add(img);
				}
			}
		}
		return (BufferedImage[]) imgs.toArray();
	}
	
	public BufferedImage read(File file){
		BufferedImage img = null;
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			GameConsole.print("Image "+file.getName()+" not found");
		}
		GameConsole.print("Image "+file.getName()+" loaded");
		return img;
	}
	
	public void write(String path){}
	
}
