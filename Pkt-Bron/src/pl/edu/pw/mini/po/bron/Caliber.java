package pl.edu.pw.mini.po.bron;

import java.io.Serializable;

public class Caliber implements Serializable{
	private static final long serialVersionUID = 1L;
	private String value;
	private String additionalValue;

	public Caliber(String combined) {

		boolean czySpacja = false;
		for (int i = 0; i < combined.length(); i++) {
			if (combined.charAt(i) == ' ' && i != combined.length() - 1) {
				czySpacja = true;
				break;
			}
		}
		if (czySpacja) {
			String[] tmp = combined.split(" ");
			this.value = tmp[0];
			this.additionalValue = tmp[1];

		} else {
			this.value = combined;
			this.additionalValue = "";
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getAdditionalValue() {
		return additionalValue;
	}

	public void setAdditionalValue(String additionalValue) {
		this.additionalValue = additionalValue;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionalValue == null) ? 0 : additionalValue.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caliber other = (Caliber) obj;
		if (additionalValue == null) {
			if (other.additionalValue != null)
				return false;
		} else if (!additionalValue.equals(other.additionalValue))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return value+" "+additionalValue;
	}


}
