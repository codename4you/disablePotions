package me.codename4you.disablePotion;

import org.bukkit.plugin.java.JavaPlugin;

public class DisablePotionMain extends JavaPlugin {
    Colors c = new Colors();

    @Override
    public void onLoad() {
        this.getServer().getConsoleSender().sendMessage(c.c("&8[&5Disable&dPostion&8] &f- &8is being loaded!"));
    }

    @Override
    public void onEnable(){
        this.getServer().getConsoleSender().sendMessage(c.c("&8[&5Disable&dPostion&8] &f- &ahas been enabled!"));
        this.reloadConfig();
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(new disablePotionEvent(this), this);
    }

    @Override
    public void onDisable(){
        this.getServer().getConsoleSender().sendMessage(c.c("&8[&5Disable&dPostion&8] &f- &chas been disabled!"));
    }
}