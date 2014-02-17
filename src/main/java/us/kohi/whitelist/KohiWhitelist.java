
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package us.kohi.whitelist;

//~--- non-JDK imports --------------------------------------------------------

import org.bukkit.plugin.java.JavaPlugin;

import us.kohi.whitelist.commands.KohiWhitelistCommand;
import us.kohi.whitelist.listeners.KohiWhitelistLoginListener;

/**
 *
 * @author Christian
 */
public class KohiWhitelist extends JavaPlugin {
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(new KohiWhitelistLoginListener(this), this);
        this.getCommand("kwhitelist").setExecutor(new KohiWhitelistCommand(this));
    }

    @Override
    public void onDisable() {
        this.saveConfig();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
