package pl.edu.pw.mini.po;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import pl.edu.pw.mini.po.bron.Caliber;
import pl.edu.pw.mini.po.bron.Weapon;

public interface Operation {

	Map<Caliber, TreeSet<Weapon>> grupuj(TreeSet<Weapon> lista);

	ArrayList<Weapon> wczytaj(String fileName);

	void zapisz(Map<Caliber, TreeSet<Weapon>> map);

	void serializuj(ArrayList<Weapon> bronie);

	ArrayList<Weapon> deserializuj();

}