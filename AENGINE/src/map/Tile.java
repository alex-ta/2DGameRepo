package map;

import io.TileInterface;

public class Tile implements TileInterface{

	private String src;
	private int pox;
	private int poy;
	private boolean blockable;
	
	
	public Tile(String...atts){
		this.setSrc(atts[0]);
		this.setbockable(Boolean.parseBoolean(atts[1]));
		this.setPox(Integer.parseInt(atts[2]));
		this.setPoy(Integer.parseInt(atts[3]));
	}
	
	public Tile(String src, boolean blockable, int posx, int posy){
		this.setSrc(src);
		this.setbockable(blockable);
		this.setPox(posx);
		this.setPoy(posy);
	}

	@Override
	public String save() {
		return src+split+blockable+split+pox+split+poy;
	}

	@Override
	public boolean isblockable() {
		return blockable;
	}

	@Override
	public void setbockable(boolean bool) {
		this.blockable = bool;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public int getPox() {
		return pox;
	}

	public void setPox(int pox) {
		this.pox = pox;
	}

	public int getPoy() {
		return poy;
	}

	public void setPoy(int poy) {
		this.poy = poy;
	}
}
