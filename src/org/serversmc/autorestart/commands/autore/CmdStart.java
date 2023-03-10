package org.serversmc.autorestart.commands.autore;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.serversmc.autorestart.core.Main;
import org.serversmc.autorestart.core.TimerThread;
import org.serversmc.autorestart.objects.AutoCommand;
import org.serversmc.autorestart.utils.Messenger;

public class CmdStart extends AutoCommand {

    private TimerThread timerThread = Main.timerThread;
    
	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!timerThread.timestamp) {
			if (timerThread.running) {
				sender.sendMessage(ChatColor.RED + "Timer is already running!");
			}
			else {
				Messenger.popupStatusStart();
				Messenger.broadcastStatusStart();
				timerThread.running = true;
			}
		}
		else if (timerThread.timestamp) {
			sender.sendMessage(ChatColor.RED + "This feature is disabled with TimeStamp feature!");
		}
		else {
			sender.sendMessage(ChatColor.RED + "This feature is disabled with MutliCraft support.");
		}
	}

	@Override
	public String getLabel() {
		return "START";
	}

	@Override
	public String getDescription() {
		return "Starts the server AutoRestart timer.";
	}

	@Override
	public String getPermission() {
		return "autorestart.start";
	}

	@Override
	public String getUsage() {
		return "/autore start";
	}

}
