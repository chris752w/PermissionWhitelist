
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package us.kohi.whitelist.commands;

//~--- non-JDK imports --------------------------------------------------------

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import us.kohi.whitelist.KohiWhitelist;

/**
 *
 * @author Christian
 */
public class KohiWhitelistCommand implements CommandExecutor {
    private KohiWhitelist plugin;

    public KohiWhitelistCommand(KohiWhitelist plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!sender.hasPermission("kohi.whitelist.reload")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission.");

            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "Configuration reloaded");
            plugin.getLogger().warning("Configuration file reloaded by: " + sender.getName());

            return true;
        }

        return true;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
