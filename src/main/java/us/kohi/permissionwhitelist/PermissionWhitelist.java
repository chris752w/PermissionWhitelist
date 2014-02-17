package us.kohi.permissionwhitelist;

//~--- non-JDK imports --------------------------------------------------------

import org.bukkit.plugin.java.JavaPlugin;

public class PermissionWhitelist extends JavaPlugin {
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(new PermissionWhitelistLoginListener(this), this);
        this.getCommand("wl").setExecutor(new PermissionWhitelistCommand(this));
    }

    @Override
    public void onDisable() {
        this.saveConfig();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
