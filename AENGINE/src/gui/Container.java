package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DataBufferByte;

import javax.swing.JPanel;

import map.FinalRaster;


public class Container extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 20112015L;
	private int[] pixels;
	private final BufferedImage img;
	private final FinalRaster raster;
	private final int width;
	private final int height;
	
	
	public Container(int panelSize, int width,int height){
		super();
		this.raster = new FinalRaster(panelSize,(int)Math.floor(width/panelSize),(int)Math.floor(height/panelSize));
		this.width = raster.getWidth();
		this.height = raster.getHeight();
		this.setPreferredSize(new Dimension(this.width,this.height));
		this.img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
		this.pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
	}
	
	public Container(int width, int height){
		this(16,width,height);
	}
	

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(img, 0, 0, null);
	}



	public void setColor(int a, int r, int g, int b){
		for(int i=0; i< pixels.length; i++){
			pixels[i] =  (a << 24) + (r << 16) + (g << 8) + b ;
		}
	}
	
	protected void addPicture(BufferedImage image, int x, int y){
		int w = image.getWidth();
		int h = image.getHeight();
		BufferedImage img = image;
		
		if(image.getType() != BufferedImage.TYPE_INT_ARGB){
				img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = img.createGraphics();
				g.drawImage(image, 0, 0, null);
				g.dispose();
		}
		
		int[] pix = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		
		System.out.println(pix.length);
		System.out.println(w);
		System.out.println(h);
		
		System.out.println(pixels.length);
		System.out.println(this.width);
		System.out.println(this.height);
		
		for(int i = 0; i < h && i < this.height-y; i++){
			for(int j = 0; j < w && j < this.width-x; j++){
				pixels[(i+y)*this.width+(j+x)] = pix[i*w+j];
			}
		}
	}
	// checken ob bild größer als raster
	
	public void addTile(BufferedImage img, int pos){
		int [] r= raster.position(pos);
		addPicture(img, r[0], r[1]);
	}
	

	public void addTile(BufferedImage img, int x, int y){
		int [] r= raster.position(x,y);
		addPicture(img, r[0], r[1]);
	}	
}
