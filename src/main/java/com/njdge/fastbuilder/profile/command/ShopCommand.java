package com.njdge.fastbuilder.profile.command;

import com.njdge.fastbuilder.FastBuilder;
import com.njdge.fastbuilder.profile.shop.menu.ShopMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

public class ShopCommand implements CommandExecutor {
    private FastBuilder plugin;

    public ShopCommand(FastBuilder plugin) {
        this.plugin = plugin;
        PluginCommand cmd = plugin.getCommand("shop");
        cmd.setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            new ShopMenu().openMenu(player);
        }
        return false;
    }
}
