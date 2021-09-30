package pl.edu.pw.mini.po;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Scanner;
import java.util.TreeSet;

import pl.edu.pw.mini.po.bron.Caliber;
import pl.edu.pw.mini.po.bron.Weapon;

public class Demonstrator implements Operation {

	public static void main(String[] args) {

		Demonstrator demonstrator = new Demonstrator();
		ArrayList<Weapon> bronie;
		bronie = demonstrator.wczytaj("./generated_weapon_bad.txt");

//		Map<Caliber, ArrayList<Weapon>> map = demonstrator.grupuj(bronie);

		TreeSet<Weapon> tmpSet = new TreeSet<>();

		for (Weapon weapon : bronie) {
			tmpSet.add(weapon);
		}
		demonstrator.zapisz(demonstrator.grupuj(tmpSet));

		demonstrator.serializuj(bronie);
		System.out.println(bronie.get(2));
		// dla testu
		System.out.println(demonstrator.deserializuj().get(2));
//		System.out.println(map.toString());

		/*
		 * String siemaString = "asdfad:1231asdfa"; siemaString.split(":"); String[]
		 * resultStrings = siemaString.split(":"); String siema1 = resultStrings[0];
		 * System.out.println(siema1);
		 */

	}

	@Override
	public ArrayList<Weapon> wczytaj(String fileName) {
		ArrayList<Weapon> bronie = new ArrayList<>();
//		int counter = 0;
		try {
			PartC reader = new PartC(new FileReader(new File(fileName)));

			String tmpString = "";
			tmpString = reader.readLine();
			reader.setLineString(tmpString);
			while (tmpString != null) {
//				System.out.println(tmpString);

				if (tmpString.isEmpty()) {
					tmpString = reader.readLine();
					continue;
				}

				reader.setLineString(tmpString);
				bronie.add(reader.getWeapon());
//				System.out.println(counter++);

				tmpString = reader.readLine();
			}

			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bronie;
	}

	@Override
	public Map<Caliber, TreeSet<Weapon>> grupuj(TreeSet<Weapon> lista) {

		Map<Caliber, TreeSet<Weapon>> map = new HashMap<Caliber, TreeSet<Weapon>>();

		for (Weapon weapon : lista) {
			Caliber key = weapon.getCaliber();
			if (!map.containsKey(key)) {
				map.put(key, new TreeSet<Weapon>());
			}
			map.get(key).add(weapon);
		}
		return map;
	}

	@Override
	public void zapisz(Map<Caliber, TreeSet<Weapon>> map) {
		try {
			for (Entry<Caliber, TreeSet<Weapon>> entry : map.entrySet()) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(
						new File("." + File.separator + "statystyka" + File.separator + entry.getKey())));
				for (Weapon weapon : entry.getValue()) {
					writer.write(weapon.getName() + ";" + weapon.getCaliber() + ";serial:" + weapon.getSerialNumber()
							+ ";" + weapon.getUnfit() + ";" + weapon.isHasFingerprints() + ";");
					writer.newLine();
				}

				writer.flush();
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void serializuj(ArrayList<Weapon> bronie) {
		File file = new File("./serialized.txt");
		try (FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos)) {
			for (Weapon weapon : bronie) {
				objectOutputStream.writeObject(weapon);
				objectOutputStream.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Weapon> deserializuj() {
		ArrayList<Weapon> bronie = new ArrayList<>();
		File file = new File("./serialized.txt");

		try (FileInputStream fileInputStream = new FileInputStream(file);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

			for (int i = 0; i < 1000; i++) {
				bronie.add((Weapon) objectInputStream.readObject());
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bronie;
	}

}