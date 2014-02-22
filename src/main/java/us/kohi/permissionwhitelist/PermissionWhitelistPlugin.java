package us.kohi.permissionwhitelist;

//~--- non-JDK imports --------------------------------------------------------

import org.bukkit.plugin.java.JavaPlugin;

public class PermissionWhitelistPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(new LoginListener(this), this);
        this.getCommand("wlreload").setExecutor(new ReloadCommand(this));
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
