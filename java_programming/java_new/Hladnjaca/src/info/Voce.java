package info;

public class Voce {
	String ime;
	int cena_1;
	int cena_2;
	int cena_3;

	public Voce(String ime, int cena_1, int cena_2, int cena_3) {
		this.ime = ime;
		this.cena_1 = cena_1;
		this.cena_2 = cena_2;
		this.cena_3 = cena_3;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getCena_1() {
		return cena_1;
	}

	public void setCena_1(int cena_1) {
		this.cena_1 = cena_1;
	}

	public int getCena_2() {
		return cena_2;
	}

	public void setCena_2(int cena_2) {
		this.cena_2 = cena_2;
	}

	public int getCena_3() {
		return cena_3;
	}

	public void setCena_3(int cena_3) {
		this.cena_3 = cena_3;
	}
}
