package de.teamfci.dataprovider;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class FCIDPCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			Plugin[] list = Bukkit.getPluginManager().getPlugins();
			List<String> names = new LinkedList<String>();
			HashMap<String, Boolean> pluginenabled = new HashMap<String, Boolean>();
			for (Plugin pl : list) {
				String name = pl.getName();
				names.add(name);
				boolean enabled = pl.isEnabled();
				pluginenabled.put(name, enabled);
			}

			p.sendMessage("§d§m----------------------------");
			for (String s : names) {
					p.sendMessage("§f[§bFCIProvider§f] §b Plugin " + s + " ist aktiv: " + pluginenabled.get(s));
			}
			p.sendMessage("§d§m----------------------------");
		}
		
		return false;
	}

}
