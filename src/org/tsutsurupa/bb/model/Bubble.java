package org.tsutsurupa.bb.model;

import javax.swing.ImageIcon;

public class Bubble implements Markable {

	private boolean _marked;
	private Color _color;
	private ImageIcon _view;
	
	public Bubble(Color ñolor) {
		_color = ñolor;
		java.net.URL url = Bubble.class.getResource("/images/" + _color.toString().toLowerCase() + "Bubble.png");
		_view = new ImageIcon(url);
	}
	
	public Color getStatus() {
		return _color;
	}

	public ImageIcon getView() {
		return _view;
	}

	@Override
	public boolean marked() {
		return _marked;
	}

	@Override
	public void mark() {
		_marked = true;
	}
	
}
