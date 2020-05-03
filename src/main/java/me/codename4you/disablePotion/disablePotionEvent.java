package me.codename4you.disablePotion;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.LingeringPotionSplashEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.potion.PotionEffect;

import java.util.List;

public class disablePotionEvent implements Listener{
    private DisablePotionMain pluginMain;
    public disablePotionEvent(DisablePotionMain pluginMain){ this.pluginMain = pluginMain; }
    @EventHandler
    private void detectPotion(PotionSplashEvent event) {
        ThrownPotion thrownPotion = event.getPotion();
        List<String> configWorld = pluginMain.getConfig().getStringList("Options.Worlds");
        List<String> configPotionType = pluginMain.getConfig().getStringList("Options.Potions.PotionType");
        String disableMessage = pluginMain.getConfig().getString("Options.Message");
        boolean booleanMessage = pluginMain.getConfig().getBoolean("Options.MessageEnable");
        for (PotionEffect pTypes : thrownPotion.getEffects()) {
            if (configWorld.contains(thrownPotion.getWorld().getName().toUpperCase())
                    && configPotionType.contains(pTypes.getType().getName().toUpperCase())) {
                event.setCancelled(true);
                if (thrownPotion.getShooter() instanceof Player){
                    Player p = (Player) thrownPotion.getShooter();
                    assert disableMessage != null;
                    assert p != null;
                    if (booleanMessage) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', disableMessage));
                    }
                }
            }
        }
    }
    @EventHandler
    private void detectLingeringPotion(LingeringPotionSplashEvent event){
        ThrownPotion thrownPotion = event.getEntity();
        List<String> configWorld = pluginMain.getConfig().getStringList("Options.Worlds");
        List<String> configPotionType = pluginMain.getConfig().getStringList("Options.Potions.PotionType");
        String disableMessage = pluginMain.getConfig().getString("Options.Message");
        boolean booleanMessage = pluginMain.getConfig().getBoolean("Options.MessageEnable");
        for(PotionEffect pTypes : thrownPotion.getEffects()) {
            if (configWorld.contains(thrownPotion.getWorld().getName().toUpperCase())
                    && configPotionType.contains(pTypes.getType().getName().toUpperCase())){
                event.setCancelled(true);
                if (thrownPotion.getShooter() instanceof Player){
                    Player p = (Player) thrownPotion.getShooter();
                    assert disableMessage != null;
                    assert p != null;
                    if (booleanMessage) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', disableMessage));
                    }
                }
            }
        }
    }
}
