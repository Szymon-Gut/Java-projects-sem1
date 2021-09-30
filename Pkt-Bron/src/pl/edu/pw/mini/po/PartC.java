package pl.edu.pw.mini.po;

import java.io.LineNumberReader;
import java.io.Reader;
import pl.edu.pw.mini.po.bron.Caliber;
import pl.edu.pw.mini.po.bron.Weapon;

public class PartC extends LineNumberReader {

	// da sie inaczej, tzn lepiej
	private String line;

	public PartC(Reader in) {
		super(in);
	}

	public String getLineString() {
		return line;
	}

	public void setLineString(String lineString) {
		this.line = lineString;
	}

	public Weapon getWeapon() {
		/*
		 * tu chyba chodzilo o cos takiego. ew zczytanie calosci w tej klasie
		 */

		Weapon weapon = null;

//		String line = this.readLine();

		if (!line.matches(".*serial:.*")) {
			String[] res = line.split(";");
			weapon = (new Weapon(res[0], new Caliber(res[1]), "brak", res[2], Boolean.getBoolean(res[3])));
		} else {
			String[] res = line.split(";");
			Caliber caliberTmp = new Caliber(res[1]);
			weapon = new Weapon(res[0], caliberTmp, res[2], res[3], Boolean.getBoolean(res[4]));
		}
		if (line.matches(".*Carbine.*")) {
			System.out.println("Karabin!!!");
		} else if (line.matches(".*Rak.*") || line.matches(".*Glauberyt.*") || line.matches(".*P-83.*")) {
			System.out.println("Polski sprzet!");
		}

		return weapon;
	}

}
