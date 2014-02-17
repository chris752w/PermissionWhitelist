
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package us.kohi.permissionwhitelist.commands;

//~--- non-JDK imports --------------------------------------------------------

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import us.kohi.permissionwhitelist.PermissionWhitelist;

import static org.bukkit.ChatColor.*;

public class PermissionWhitelistCommand implements CommandExecutor {
    private final PermissionWhitelist plugin;

    public PermissionWhitelistCommand(PermissionWhitelist plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!sender.hasPermission("kwhitelist.reload")) {
            sender.sendMessage(RED + "You don't have permission.");

            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(RED + "/wl reload");

            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            plugin.reloadConfig();
            sender.sendMessage(LIGHT_PURPLE + "Configuration reloaded.");
            plugin.getLogger().warning("Configuration file reloaded by: " + sender.getName());

            return true;
        }

        return true;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
