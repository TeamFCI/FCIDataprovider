package de.teamfci.dataprovider;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class dataprovider extends JavaPlugin {

	public void onEnable() {
		this.getCommand("ple").setExecutor(new FCIDPCommand());
		this.getCommand("fcid").setExecutor(new FCID());
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.isOp()) {
				p.sendMessage("§eFCIDataprovider §awurde enabled!");
			}
		}
		Plugin[] list = Bukkit.getPluginManager().getPlugins();
		List<String> names = new LinkedList<String>();
		HashMap<String, Boolean> pluginenabled = new HashMap<String, Boolean>();
		for (Plugin pl : list) {
			String name = pl.getName();
			names.add(name);
			boolean enabled = pl.isEnabled();
			pluginenabled.put(name, enabled);
		}
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage("§d§m----------------------------");
			p.sendMessage("§f[§bFCIProvider§f] §b Project-Addons");
			for (String s : names) {
				if (s.contains("FCI")) {
					p.sendMessage("§f[§bFCIProvider§f] §b Plugin " + s + " ist aktiv: " + pluginenabled.get(s));
				}
			}
			p.sendMessage("§f[§bFCIDataprovider§f] §b Plugins by §aTeamFCI");
			p.sendMessage("§f[§bFCICrafting§f] §b /fcicr für weitere Infos");
			p.sendMessage("§f[§bFCIChat§f] §b /fcic für weitere Infos");
			p.sendMessage("§f[§bFCIPvP§f] §b /fcipvp für weitere Infos");
			p.sendMessage("§f[§bFCItems§f] §b /fci für weitere Infos");
			p.sendMessage("§d§m----------------------------");
		}
	}

	public static String getTeam(Player p) {
		String team = "";
		File file = new File(
				"plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//" + p.getName() + "config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//"
					+ p.getName() + "config.yml");
			Bukkit.broadcastMessage("§ckonnte nicht gefunden werden!");
			return null;
		} else {
			team = cfg.getString("Player.FCI.Clan");
		}
		if (team == null) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//"
					+ p.getName() + "config.yml");
			Bukkit.broadcastMessage("§cInfo: §7team = cfg.getString(§b''Player.FCI.Clan''§7);");
			Bukkit.broadcastMessage("§6team §cist §5null§c!");
			return null;
		}
		return team;
	}

	public static Integer getMoney(Player p) {
		int money = 0;
		File file = new File(
				"plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//" + p.getName() + "config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//"
					+ p.getName() + "config.yml");
			Bukkit.broadcastMessage("§ckonnte nicht gefunden werden!");
			return null;
		} else {
			money = cfg.getInt("Player.FCI Eco.Money");
		}
		return money;
	}

	public static String getPlayerClass(Player p) {
		String PlayerClass = "";
		File file = new File(
				"plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//" + p.getName() + "config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//"
					+ p.getName() + "config.yml");
			Bukkit.broadcastMessage("§ckonnte nicht gefunden werden!");
			return null;
		} else {
			PlayerClass = cfg.getString("Player.Class");
		}
		if (PlayerClass == null) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//"
					+ p.getName() + "config.yml");
			Bukkit.broadcastMessage("§cInfo: §7PlayerClass = cfg.getString(§b''Player.Class''§7);");
			Bukkit.broadcastMessage("§6PlayerClass §cist §5null§c!");
			return null;
		}
		return PlayerClass;
	}

	public static Integer getPlayerClassLevel(Player p) {
		int level = 0;
		File file = new File(
				"plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//" + p.getName() + "config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//"
					+ p.getName() + "config.yml");
			Bukkit.broadcastMessage("§ckonnte nicht gefunden werden!");
			return null;
		} else {
			level = cfg.getInt("Player.Class Level");
		}
		return level;
	}

	public static Integer getShopID(String ShopType) {
		int id = 1;
		File file = new File(
				"plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Shops//" + ShopType + "//config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Shops//"
					+ ShopType + "//config.yml");
			Bukkit.broadcastMessage("§ckonnte nicht gefunden werden!");
			return null;
		} else {
			id = cfg.getInt("Shop.ID");
		}
		return id;
	}

	public static String getShopName(String ShopType) {
		String shop = "";
		File file = new File(
				"plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Shops//" + ShopType + "//config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Shops//"
					+ ShopType + "//config.yml");
			Bukkit.broadcastMessage("§ckonnte nicht gefunden werden!");
			return null;
		} else {
			shop = cfg.getString("Shop.Name");
		}
		if (shop == null) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Shops//"
					+ ShopType + "//config.yml");
			Bukkit.broadcastMessage("§cInfo: §7shop = cfg.getString(§b''Shop.Name''§7);");
			Bukkit.broadcastMessage("§6shop §cist §5null§c!");
			return null;
		}
		return shop;
	}

	public static Location getShopLocation(String ShopType) {
		Location loc = null;
		File file = new File(
				"plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Shops//" + ShopType + "//config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Shops//"
					+ ShopType + "//config.yml");
			Bukkit.broadcastMessage("§ckonnte nicht gefunden werden!");
			return null;
		} else {
			String w = cfg.getString("Shop.Location.World");
			double x = (double) cfg.getInt("Shop.Location.X");
			double y = (double) cfg.getInt("Shop.Location.Y");
			double z = (double) cfg.getInt("Shop.Location.Z");
			World world = Bukkit.getWorld(w);
			loc = new Location(world, x, y, z);
		}
		return loc;
	}

	public static String getShopSkinOwner(String ShopType) {
		String shop = "";
		File file = new File(
				"plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Shops//" + ShopType + "//config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			Bukkit.broadcastMessage("§c§lFehler: §f§l557");
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Shops//"
					+ ShopType + "//config.yml");
			Bukkit.broadcastMessage("§ckonnte nicht gefunden werden!");
			return null;
		} else {
			shop = cfg.getString("Shop.SkinOwner");
		}
		if (shop == null) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Shops//"
					+ ShopType + "//config.yml");
			Bukkit.broadcastMessage("§cInfo: §7shop = cfg.getString(§b''Shop.SkinOwner''§7);");
			Bukkit.broadcastMessage("§6shop §cist §5null§c!");
			return null;
		}
		return shop;
	}

	public static String getShopType(String ShopType) {
		String type = "";
		File file = new File(
				"plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Shops//" + ShopType + "//config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Shops//"
					+ ShopType + "//config.yml");
			Bukkit.broadcastMessage("§ckonnte nicht gefunden werden!");
			return null;
		} else {
			type = cfg.getString("Shop.ShopType");
		}
		if (type == null) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Shops//"
					+ ShopType + "//config.yml");
			Bukkit.broadcastMessage("§cInfo: §7type = cfg.getString(§b''Shop.ShopType''§7);");
			Bukkit.broadcastMessage("§6type §cist §5null§c!");
			return null;
		}
		return type;
	}
	
	public static Location getSpawnLocation(String team, Player p) {
		File file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Teams//"+team+"//config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Teams//"+team+"//config.yml");
			Bukkit.broadcastMessage("§ckonnte nicht gefunden werden!");
			return null;
		}
		double x = (double) cfg.getInt("Team.Event Spawn.Location.X");
		double y = (double) cfg.getInt("Team.Event Spawn.Location.Y");
		double z = (double) cfg.getInt("Team.Event Spawn.Location.Z");
		float yaw = (float) cfg.getInt("Team.Event Spawn.Location.Yaw");
		float pitch = (float) cfg.getInt("Team.Event Spawn.Location.Pitch");
		String w = cfg.getString("Team.Event Spawn.Location.World");
		World world = Bukkit.getWorld(w);
		Location loc = new Location(world, x, y, z, yaw, pitch);
		return loc;
	}
	
	public static Location getPlayerLocationFromConfig(String LocType, Player p) {
		File file = new File("plugins//Fortress-Combat-System//Player Configs//"+p.getName()+"//PvP Config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		Location loc = null;
		if (!file.exists()) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Player Configs//"+p.getName()+"//PvP Config.yml");
			Bukkit.broadcastMessage("§ckonnte nicht gefunden werden!");
			return null;
		}
		if(LocType.toLowerCase().equals("pvp")) {
			double x = (double) cfg.getInt("Player.Event.PVP.Lastlocation.Location.X");
			double y = (double) cfg.getInt("Player.Event.PVP.Lastlocation.Location.Y");
			double z = (double) cfg.getInt("Player.Event.PVP.Lastlocation.Location.Z");
			float yaw = (float) cfg.getInt("Player.Event.PVP.Lastlocation.Location.Yaw");
			float pitch = (float) cfg.getInt("Player.Event.PVP.Lastlocation.Location.Pitch");
			String w = cfg.getString("Player.Event.PVP.Lastlocation.Location.World");
			World world = Bukkit.getWorld(w);
			Location l = new Location(world, x, y, z, yaw, pitch);
			loc = l;
		}
		return loc;
	}
	
	public static void setSpawnLocation(String team, Location loc, Player p) {
		File file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Teams//"+team+"//config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("Team.Event Spawn.Location.X", loc.getX());
		cfg.set("Team.Event Spawn.Location.Y", loc.getY());
		cfg.set("Team.Event Spawn.Location.Z", loc.getZ());
		cfg.set("Team.Event Spawn.Location.Yaw", loc.getYaw());
		cfg.set("Team.Event Spawn.Location.Pitch", loc.getPitch());
		cfg.set("Team.Event Spawn.Location.World", loc.getWorld().getName());
		try {
			cfg.save(file);
		} catch (IOException e) {
			p.sendMessage("§cFehler beim Absepichern der Datei!");
			p.sendMessage("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Teams//"+team+"//config.yml");
			e.printStackTrace();
		}
		if (!file.exists()) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Teams//"+team+"//config.yml");
			Bukkit.broadcastMessage("§ckonnte nicht gefunden werden!");
			return;
		}
		p.sendMessage("§aEvent Spawn für Team '§f"+team+"§a' gesetzt!");
	}
	
	public static void set(String SetterType, String InFilePath, Player p, String stringValue, int intValue, boolean boolValue) {
		File file = new File("plugins//Fortress-Combat-System//Player Configs//"+p.getName()+"//PvP Config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(SetterType.toLowerCase().equals("string")) {
			cfg.set(InFilePath, stringValue);
		}
		if(SetterType.toLowerCase().equals("integer")) {
			cfg.set(InFilePath, intValue);
		}
		if(SetterType.toLowerCase().equals("boolean")) {
			cfg.set(InFilePath, boolValue);
		}
		if(SetterType.toLowerCase().equals("location")) {
			Location loc = p.getLocation();
			if(InFilePath.contains(".Location")) {
				cfg.set(InFilePath+".X", loc.getX());
				cfg.set(InFilePath+".Y", loc.getY());
				cfg.set(InFilePath+".Z", loc.getZ());
				cfg.set(InFilePath+".Yaw", loc.getYaw());
				cfg.set(InFilePath+".Pitch", loc.getPitch());
				cfg.set(InFilePath+".World", loc.getWorld().getName());
			} else {
				cfg.set(InFilePath+".Location.X", loc.getX());
				cfg.set(InFilePath+".Location.Y", loc.getY());
				cfg.set(InFilePath+".Location.Z", loc.getZ());
				cfg.set(InFilePath+".Location.Yaw", loc.getYaw());
				cfg.set(InFilePath+".Location.Pitch", loc.getPitch());
				cfg.set(InFilePath+".Location.World", loc.getWorld().getName());
			}
		}
		try {
			cfg.save(file);
		} catch (IOException e) {
			p.sendMessage("§cFehler beim Absepichern der Datei!");
			p.sendMessage("plugins//Fortress-Combat-System//Player Configs//"+p.getName()+"PvP Config.yml");
			e.printStackTrace();
		}
		if (!file.exists()) {
			Bukkit.broadcastMessage("§cDatei: config.yml");
			Bukkit.broadcastMessage("§cPath: §7plugins//Fortress-Combat-System//Player Configs//"+p.getName()+"PvP Config.yml");
			Bukkit.broadcastMessage("§ckonnte nicht gefunden werden!");
			return;
		}
	}

}
