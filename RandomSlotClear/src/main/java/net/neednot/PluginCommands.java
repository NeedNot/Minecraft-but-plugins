package net.neednot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.neednot.RandomSlotClear;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PluginCommands implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args[0].equals("start")) {
            RandomSlotClear.active = true;
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage("§cA random slot from your inventory will be removed every 60s!");
            }
        }
        else {
            if (args[0].equals("stop")) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage("§aA random slot from your inventory will no longer be removed every 60s");
                }
                RandomSlotClear.active = false;
            }
            else {
                sender.sendMessage("§cPlease use /rsc <start/stop>");
            }
        }
        return true;
    }
    @Override
    public List<String> onTabComplete(final CommandSender sender, final Command command, final String alias, final String[] args) {
        if (args.length<=1) {
            return Arrays.asList("start", "stop");
        }
        return null;
    }
}