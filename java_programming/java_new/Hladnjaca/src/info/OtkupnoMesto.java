package info;

public class OtkupnoMesto {
	String ime;
	Proizvodjac proizvodjac;

	public OtkupnoMesto(String ime, Proizvodjac proizvodjac) {
		this.ime = ime;
		this.proizvodjac = proizvodjac;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Proizvodjac getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(Proizvodjac proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

}
