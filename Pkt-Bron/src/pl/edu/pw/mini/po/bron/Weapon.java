package pl.edu.pw.mini.po.bron;

import java.io.Serializable;

public class Weapon implements Serializable, Comparable<Weapon> {

	private static final long serialVersionUID = 1L;
	private String name;
	private Caliber caliber;
	private int serialNumber;
	private double unfit;
	private boolean hasFingerprints;

	@Override
	public String toString() {
		return "Weapon [name=" + name + ", caliber=" + caliber + ", serialNumber=" + serialNumber + ", unfit=" + unfit
				+ ", hasFingerprints=" + hasFingerprints + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Caliber getCaliber() {
		return caliber;
	}

	public void setCaliber(Caliber caliber) {
		this.caliber = caliber;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public double getUnfit() {
		return unfit;
	}

	public void setUnfit(double unfit) {
		this.unfit = unfit;
	}

	public boolean isHasFingerprints() {
		return hasFingerprints;
	}

	public void setHasFingerprints(boolean hasFingerprints) {
		this.hasFingerprints = hasFingerprints;
	}

	public Weapon(String name, Caliber caliber, String serialNumberWithSerial, String unfitZPrzecinkiem,
			boolean hasFingerprints) {
		this.name = name;
		this.caliber = caliber;

		if (serialNumberWithSerial == "brak") {
			this.serialNumber = 0;
		} else {
			String[] tmpString = serialNumberWithSerial.split(":");
			this.serialNumber = Integer.parseInt(tmpString[1]);
		}

		String[] tmpStrings = unfitZPrzecinkiem.split(",");

		this.unfit = Double.parseDouble(tmpStrings[0] + "." + tmpStrings[1]);

		this.hasFingerprints = hasFingerprints;
	}

	@Override
	public int compareTo(Weapon o) {
		if (this.serialNumber < o.serialNumber) {
			return -1;
		} else if (this.serialNumber == o.serialNumber) {
			return 0;
		} else
			return 1;
	}

}
