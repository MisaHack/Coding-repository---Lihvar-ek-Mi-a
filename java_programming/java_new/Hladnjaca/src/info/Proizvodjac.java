package info;

public class Proizvodjac {
	String ime;
	String prezime;
	int jmbg;
	String telefon;
	String poreska_izjava;
	String ugovor;
	int povrsina_parcele;
	String tekuci_racun;
	String otkupno_mesto;

	public Proizvodjac(String ime, String prezime, int jmbg, String telefon, String poreska_izjava, String ugovor,
			           int povrsina_parcele, String tekuci_racun, String otkupno_mesto) {
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.telefon = telefon;
		this.poreska_izjava = poreska_izjava;
		this.ugovor = ugovor;
		this.povrsina_parcele = povrsina_parcele;
		this.tekuci_racun = tekuci_racun;
		this.otkupno_mesto = otkupno_mesto;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getJmbg() {
		return jmbg;
	}

	public void setJmbg(int jmbg) {
		this.jmbg = jmbg;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getPoreska_izjava() {
		return poreska_izjava;
	}

	public void setPoreska_izjava(String poreska_izjava) {
		this.poreska_izjava = poreska_izjava;
	}

	public String getUgovor() {
		return ugovor;
	}

	public void setUgovor(String ugovor) {
		this.ugovor = ugovor;
	}

	public int getPovrsina_parcele() {
		return povrsina_parcele;
	}

	public void setPovrsina_parcele(int povrsina_parcele) {
		this.povrsina_parcele = povrsina_parcele;
	}

	public String getTekuci_racun() {
		return tekuci_racun;
	}

	public void setTekuci_racun(String tekuci_racun) {
		this.tekuci_racun = tekuci_racun;
	}

}
