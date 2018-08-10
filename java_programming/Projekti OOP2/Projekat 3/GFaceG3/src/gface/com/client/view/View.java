package gface.com.client.view;

import gface.com.client.GFaceG3;

import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Osnovna klasa za sve prikaze.
 *
 * @author <a href="mitrovic.dejan@gmail.com">Dejan Mitrovic</a>
 */
public abstract class View extends VerticalPanel {
	protected GFaceG3 gfaceg3;

	public View(GFaceG3 gfaceg3) {
		this.gfaceg3 = gfaceg3;
		setSpacing(8);
		setHorizontalAlignment(VerticalPanel.ALIGN_LEFT);
	}
}
