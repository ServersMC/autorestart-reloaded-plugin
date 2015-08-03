package org.serversmc.autorestart.commands.autore;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.serversmc.autorestart.core.TimerThread;
import org.serversmc.autorestart.types.AutoCommand;
import org.serversmc.autorestart.utils.Config;
import org.serversmc.autorestart.utils.Messenger;

public class CmdPause extends AutoCommand {

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!new Config().isMainMulticraft()) {
			if (TimerThread.isRunning()) {
				Messenger.popupStatusPause();
				Messenger.broadcastStatusPause();
			}
			else {
				sender.sendMessage(ChatColor.RED + "Timer is already paused!");
			}
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