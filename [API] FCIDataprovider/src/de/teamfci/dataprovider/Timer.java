	package de.teamfci.dataprovider;
	
	import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Timer implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		final String Timername = args[0];
		final int length = Integer.parseInt(args[1]);
			final Player p = (Player) sender;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("FCIDataprovider"), new Runnable() {
			int is = 0;
			@Override
			public void run() {
				
				if(is == length){
					p.sendMessage("Der Timer " + Timername + " ist abgelaufen.");
					return;
				}
				is++;
				
			}
		}, 20, 20);
		return false;
	}

}
