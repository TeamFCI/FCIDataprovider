package de.teamfci.dataprovider;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FCID implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("FCI-BaukastenID");
				p.sendMessage("andikandi §4ROT");
				p.sendMessage("Lord_Traube §aHELL GRÜN");
				p.sendMessage("KinqNoooah §bHELL BLAU");
				p.sendMessage("Bauteam XY §2DUNKEL GRÜN");
			}
		} else {
			sender.sendMessage("FCI-BaukastenID");
			sender.sendMessage("andikandi ROT");
			sender.sendMessage("TraubiistGeil HELL GRÜN");
			sender.sendMessage("akkilp GELB");
			sender.sendMessage("KinqNoooah HELL BLAU");
		}
		
		return false;
	}
	
	
	
}
