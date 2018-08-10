package gface.com.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Pomocna klasa za prikaz greske u modalnom dijalogu. Da bi ovaj dijalog bio korektno prikazan,
 * potrebno je ukljuciti podrsku za teme, sto se postize dodavanjem sledece linije u fajl *.gwt.xml:
 * 
 * <inherits name="com.google.gwt.user.theme.standard.Standard" />
 *
 * @author <a href="mailto:mitrovic.dejan@gmail.com">Dejan Mitrovic</a>
 */
public class ErrorDlg extends DialogBox {
	public ErrorDlg(String message) {
		// animirani popup
		setAnimationEnabled(true);
		// zatamni prozor ispod dijaloga
		setGlassEnabled(true);
		setText("Error");

		Button ok = new Button("OK");
		ok.setWidth("100px");
		ok.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				ErrorDlg.this.hide();
			}
		});

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(16);
		vp.add(new HTML(message));
		vp.add(ok);
		add(vp);

		center(); // centrirano u web stranici
		show();
	}
}
