package us.kohi.permissionwhitelist;

//~--- non-JDK imports --------------------------------------------------------

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginListener implements Listener {
    private final PermissionWhitelistPlugin plugin;

    public LoginListener(PermissionWhitelistPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPermission("kwhitelist.whitelisted")) {
            event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, plugin.getConfig().getString("notWhitelisted"));
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
