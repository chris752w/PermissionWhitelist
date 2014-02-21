package us.kohi.permissionwhitelist;

//~--- non-JDK imports --------------------------------------------------------

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static org.bukkit.ChatColor.*;

//~--- JDK imports ------------------------------------------------------------

import java.util.logging.Level;

public class ReloadCommand implements CommandExecutor {
    private final PermissionWhitelistPlugin plugin;

    public ReloadCommand(PermissionWhitelistPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!sender.hasPermission("kwhitelist.reload")) {
            sender.sendMessage(RED + "Permission denied.");

            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(RED + "/wlreload");

            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            plugin.reloadConfig();
            sender.sendMessage(LIGHT_PURPLE + "Configuration reloaded.");
            plugin.getLogger().log(Level.WARNING, "Configuration file reloaded by: {0}", sender.getName());

            return true;
        }

        return true;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
