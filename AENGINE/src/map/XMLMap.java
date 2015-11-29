package map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLMap {

	public void XMLMap(){
		
	}
	
	public void parse(Document doc){
		Element root = doc.getDocumentElement();
		NodeList tileset = root.getElementsByTagName("tileset");
		NodeList layers = root.getElementsByTagName("layer");
		
	}
	
	public void layer(Element element){
		Node data = element.getElementsByTagName("data").item(0);
		NodeList list = data.getChildNodes();
		for(int i = 0; i < list.getLength(); i++){
			list.item(i);
			// TODO
		}
	}
	
	public void tileset(Element element){
		NodeList list = element.getElementsByTagName("image");
		for(int i = 0; i < list.getLength(); i++){
			list.item(i);
			// TODO
		}
	}
	
	
}
