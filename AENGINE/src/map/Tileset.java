package map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Tileset {
	

	private final FinalRaster raster;
	private ArrayList <BufferedImage> tiles = new ArrayList<BufferedImage>();
	private BufferedImage img;
	
	public Tileset(BufferedImage img, int wsize, int hsize){
		this.img = img;
		this.raster = new FinalRaster(wsize,hsize,img.getWidth()/wsize,img.getHeight()/hsize);
		for(int i = 0; i < raster.getCount(); i++){
			BufferedImage buff = new BufferedImage(wsize,hsize,BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D g = buff.createGraphics();
			g.drawImage(img, i*wsize, i*hsize, wsize, hsize, null);
			tiles.add(buff);
		}
	}
	
	public BufferedImage getTile(int index){
		return tiles.get(index);
	}

	public BufferedImage getTiledImg() {
		return img;
	}

	public void setTiledImg(BufferedImage img) {
		this.img = img;
	}
	
}
