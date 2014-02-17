package us.kohi.permissionwhitelist;

//~--- non-JDK imports --------------------------------------------------------

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PermissionWhitelistLoginListener implements Listener {
    private final PermissionWhitelist plugin;

    public PermissionWhitelistLoginListener(PermissionWhitelist plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPermission("kwhitelist.whitelist")) {
            event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, plugin.getConfig().getString("Not-Whitelisted"));
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
