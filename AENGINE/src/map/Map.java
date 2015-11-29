package map;

import java.util.ArrayList;

import io.Configuration;
import io.RootInterface;
import io.TileInterface;

public class Map implements RootInterface{

	ArrayList<Tile> tiles = new ArrayList<Tile>();
	Configuration conf = new Configuration();
	
	
	@Override
	public String save() {
		StringBuffer buff = new StringBuffer();
		for(Tile t:tiles){
			buff.append(t.save()+conf.getNodeSplit());
		}
		return buff.toString();
	}

	@Override
	public void load(String msg) {
		tiles.clear();
		String [] nodes = msg.split(conf.getNodeSplit());
		for(String n: nodes){
			String[] atts = n.split(TileInterface.split);
			if(atts.length > 3){
				tiles.add(new Tile(atts));
			}
		}
		
	}

	@Override
	public void setConfiguration(Configuration conf) {
		this.conf = conf;
	}

	public void add(Tile tile){
		tiles.add(tile);
	}
	
}
