package menu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

public class Menu extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 22112015L;
	private final DefaultListModel<String> model;
	private final JList<String> list;
	
	public Menu(Dimension d, MouseListener listener){
		this.model = new DefaultListModel<String>();
		this.list = new JList<String>(model);
		this.list.setCellRenderer(new MenuRender(10000,160));
		this.add(list);
		this.setSize(d);	
		this.setPreferredSize(d);
		list.setPreferredSize(new Dimension((int)d.getWidth()-100,(int)d.getHeight()-100));
		this.setBackground(new Color(200,200,200,100));
		list.addMouseListener(listener);
	}
	
	public void addEntries(String...entries){
		for(String s: entries){
			if(this.model.indexOf(s)<0){
				this.model.addElement(s);
			}
		}
	}
}
