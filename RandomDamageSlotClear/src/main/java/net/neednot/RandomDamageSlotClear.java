package net.neednot;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import net.neednot.listeners.DamageClear;

import net.neednot.PluginCommands;

import java.util.Random;

public final class RandomDamageSlotClear extends JavaPlugin {
    public static RandomDamageSlotClear plugin;
    public static boolean active = false;

    @Override
    public void onEnable() {
        plugin = this;

        this.getCommand("RSC").setExecutor(new PluginCommands());
        getServer().getPluginManager().registerEvents(new DamageClear(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
