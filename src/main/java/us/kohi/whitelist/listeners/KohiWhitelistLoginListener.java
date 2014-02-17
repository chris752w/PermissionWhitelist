
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package us.kohi.whitelist.listeners;

//~--- non-JDK imports --------------------------------------------------------

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import us.kohi.whitelist.KohiWhitelist;

/**
 *
 * @author Christian
 */
public class KohiWhitelistLoginListener implements Listener {
    private KohiWhitelist plugin;

    public KohiWhitelistLoginListener(KohiWhitelist plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPermission("kohi.whitelist")) {
            event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, plugin.getConfig().getString("String.Whitelisted"));
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
