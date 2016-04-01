package de.teamfci.dataprovider;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ThrowCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			try {
				throw new FCIException("ThrowCommand", "de.teamfci.dataprovider", "onCommand", 13, args[0],
						(Player) sender);
			} catch (FCIException e) {
			} 
		
		return false;
	}

	

}
