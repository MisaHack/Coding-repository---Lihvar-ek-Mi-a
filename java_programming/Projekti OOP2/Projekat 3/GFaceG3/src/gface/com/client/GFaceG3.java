package gface.com.client;

import gface.com.client.view.LoginPageG3;
import gface.com.client.view.View;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * 
 * 
 * 
 * Nisam uspeo nista pametno da napravim, odnosno nisam povezao sa serverom.
 *  Imate osnovni izgled i pocetni gui, pa ukoliko neko stigne neka radi.
 *   Potrebno je napraviti Stranicu za logovanje i main stranicu za pocetak, ostalo cemo lako.
 *   Pozdrav,
 *    Nenad.
 */
public class GFaceG3 implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private RootPanel root;
	
	@Override
	public void onModuleLoad() {
		root = RootPanel.get("main");
		showView(new LoginPageG3(this));
	}

	public void showView(View view) {
		root.clear();
		root.add(view);
	}

}
