package net.neednot;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.neednot.PluginCommands;

import java.util.Random;

public final class RandomSlotClear extends JavaPlugin {
    public static RandomSlotClear plugin;
    public static boolean active = false;

    @Override
    public void onEnable() {
        plugin = this;

        this.getCommand("RSC").setExecutor(new PluginCommands());

        new BukkitRunnable() {
            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()) {
                    if (active) {
                        Random random = new Random();
                        int R = random.nextInt(41);

                        if (player.getInventory().getItem(R) == null) {
                            return;
                        } else {
                            ItemStack air = new ItemStack(Material.AIR);
                            player.getInventory().setItem(R, air);
                            player.sendMessage("§cA random slot has been removed (could already be air)");
                        }
                    }
                }
            }
        }.runTaskTimer(this, 0L, 1200L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
