package net.neednot.listeners;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import net.neednot.RandomDamageSlotClear;

import java.util.Random;

public class DamageClear implements Listener {

    @EventHandler
    public void damage(EntityDamageEvent event) {

        if (event.getEntity().getType().name().equalsIgnoreCase("player")) {
            Player player = (Player) event.getEntity();
            if (RandomDamageSlotClear.active) {
                Random random = new Random();
                int R = random.nextInt(41);

                if (player.getInventory().getItem(R) == null) {
                    return;
                } else {
                    ItemStack air = new ItemStack(Material.AIR);
                    player.getInventory().setItem(R, air);
                }
            }
        }

    }

}