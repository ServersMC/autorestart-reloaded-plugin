package org.serversmc.autorestart.commands.autore;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.serversmc.autorestart.core.Main;
import org.serversmc.autorestart.core.TimerThread;
import org.serversmc.autorestart.objects.AutoCommand;
import org.serversmc.autorestart.utils.Messenger;

public class CmdPause extends AutoCommand {

    private TimerThread timerThread = Main.timerThread;
    
	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!timerThread.timestamp) {
			if (timerThread.running) {
				Messenger.popupStatusPause();
				Messenger.broadcastStatusPause();
				timerThread.running = false;
			}
			else {
				sender.sendMessage(ChatColor.RED + "Timer is already paused!");
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
		return "PAUSE";
	}

	@Override
	public String getDescription() {
		return "Pauses the server AutoRestart timer.";
	}

	@Override
	public String getPermission() {
		return "autorestart.pause";
	}

	@Override
	public String getUsage() {
		return "/autore pause";
	}

}
