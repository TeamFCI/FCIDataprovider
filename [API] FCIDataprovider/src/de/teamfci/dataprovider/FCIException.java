package de.teamfci.dataprovider;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class FCIException extends Exception {
	
	private static final long serialVersionUID = 5197124246068158750L;

	public FCIException(String Classname, String Package, String Method, int Line, String Fehler, Player p) {
		System.out.println("Fehler in: " + Package + "." + Classname + "." + Method + "():" + Line);
		System.out.println("Fehler: " + Fehler);
		java.util.Date now = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy 'CUT' HH 'Stunden' mm 'Minuten' ss 'Sekunden'");
		String ausgabe = sdf.format(now);
		String[] dateTime = ausgabe.split(" CUT ");
		try {
			Player Dev1 = Bukkit.getPlayer("FilipZocktan");
			if(Dev1.isOnline()){
				Dev1.sendMessage("Der Spieler " + p.getName() + " hat eine FCIException verursacht: ");
				Dev1.sendMessage("Java-Klasse: " + Classname);
				Dev1.sendMessage("In Package: " + Package);
				Dev1.sendMessage("Fehlerbeschreibung: " + Fehler);
				Dev1.sendMessage("Weitere Infos im Log.");
				Dev1.sendMessage("Datum/Uhrzeit: " + ausgabe.replace(" CUT ", " "));
			}
		} catch (NullPointerException e2) {
		}
		try {
			Player Dev2 = Bukkit.getPlayer("HappyHappyBoy");
			if(Dev2.isOnline()){
				Dev2.sendMessage("Der Spieler " + p.getName() + " hat eine FCIException verursacht: ");
				Dev2.sendMessage("Java-Klasse: " + Classname);
				Dev2.sendMessage("In Package: " + Package);
				Dev2.sendMessage("Fehlerbeschreibung: " + Fehler);
				Dev2.sendMessage("Weitere Infos im Log");
				Dev2.sendMessage("Datum/Uhrzeit: " + ausgabe.replace(" CUT ", " "));
			}
		} catch (NullPointerException e1) {
		}
		File file = new File("plugins//Fortress-Combat-System//Fehlerlogging//Fehler vom " + dateTime[0].replace('/', '.') + ".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set(dateTime[0] + "." + dateTime[1] + ".Java Klasse", Classname);
		cfg.set(dateTime[0] + "." + dateTime[1] + ".Package", Package);
		cfg.set(dateTime[0] + "." + dateTime[1] + ".Method", Method);
		cfg.set(dateTime[0] + "." + dateTime[1] + ".Line", Line);
		cfg.set(dateTime[0] + "." + dateTime[1] + ".Fehler", Fehler);
		try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
