package com.njdge.fastbuilder.profile.shop.menu;

import com.njdge.fastbuilder.profile.PlayerProfile;
import com.njdge.fastbuilder.utils.CC;
import com.njdge.fastbuilder.utils.ItemBuilder;
import com.njdge.fastbuilder.utils.menu.Button;
import com.njdge.fastbuilder.utils.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ShopMenu extends Menu {
    public static final Button BLOCKS = new ItemBuilder(Material.SANDSTONE)
            .name(CC.YELLOW + CC.BOLD + "Blocks")
            .lore(CC.GRAY + "Unlock new")
            .lore(CC.GRAY + "bridging blocks.")
            .asButton((player, slot, clickType, hotbarSlot) -> {
                // blocks
            });
    public static final Button PICKAXES = new ItemBuilder(Material.WOOD_PICKAXE)
            .name(CC.RED + CC.BOLD + "Pickaxes")
            .lore(CC.GRAY + "Buy better pickaxes")
            .lore(CC.GRAY + "to remove incorrectly")
            .lore(CC.GRAY + "placed blocks.")
            .asButton((player, slot, clickType, hotbarSlot) -> {
                // blocks
            });
    public static final Button ISLAND_THEMES = new ItemBuilder(Material.MAP)
            .name(CC.DARK_AQUA + CC.BOLD + "Island" + CC.GRAY + CC.BOLD + "Themes")
            .lore(CC.GRAY + "Change the theme")
            .lore(CC.GRAY + "of your start and end")
            .lore(CC.GRAY + "island to a different season.")
            .lore(CC.GRAY + "")
            .lore(CC.AQUA + CC.MAGIC + CC.BOLD + "| " + CC.DARK_BLUE + CC.BOLD + " VIP" + CC.GREEN + CC.BOLD + "+ " + CC.GOLD + "exclusive " + CC.AQUA + CC.MAGIC + CC.BOLD + "|")
            .asButton((player, slot, clickType, hotbarSlot) -> {
                // blocks
            });
    public static final Button DEATH_SHRIEK = new ItemBuilder(Material.NOTE_BLOCK)
            .name(CC.RED + CC.BOLD + "Death Shriek")
            .lore(CC.GRAY + "Buy a sound to")
            .lore(CC.GRAY + "shriek when you")
            .lore(CC.GRAY + "fall into the void.")
            .asButton((player, slot, clickType, hotbarSlot) -> {
                // block
            });
    public static final Button RESET_ANIMATION = new ItemBuilder(Material.REDSTONE)
            .name(CC.YELLOW + CC.BOLD + "Reset" + CC.YELLOW + CC.AQUA + "Animation")
            .lore(CC.GRAY + "Unlock animations")
            .lore(CC.GRAY + "of how spectacularly")
            .lore(CC.GRAY + "you want to have your")
            .lore(CC.GRAY + "blocks disappear.")
            .asButton((player, slot, clickType, hotbarSlot) -> {
                // blocks
            });
    public static final Button BANNER = new ItemBuilder(Material.BANNER)
            .durability(15)
            .name(CC.PINK + CC.BOLD + "Banner")
            .lore(CC.GRAY + "Choose your favorite")
            .lore(CC.GRAY + "personality and join")
            .lore(CC.GRAY + "their clan by showing")
            .lore(CC.GRAY + "their banner above")
            .lore(CC.GRAY + "your head.")
            .asButton((player, slot, clickType, hotbarSlot) -> {
                // blocks
            });
    public static final Button STATS_RESET = new ItemBuilder(Material.BOOK)
            .name(CC.RED + CC.BOLD + "Stats" + CC.GRAY + "-" + CC.DARK_RED + CC.BOLD + "RESET")
            .lore(CC.DARK_RED + "Reset" + CC.GRAY + " your statistics")
            .lore(CC.GRAY + "bridging blocks.")
            .asButton((player, slot, clickType, hotbarSlot) -> {
                // blocks
            });

    @Override
    public String getTitle(Player player) {
        return CC.GREEN + CC.BOLD + "FastBuilder" + CC.GRAY + "-" + CC.GREEN + CC.BOLD + "Shop";
    }



    @Override
    public Map<Integer, Button> getButtons(Player player) {
        HashMap<Integer, Button> buttons = new HashMap<>();
        buttons.put(19, BLOCKS);
        buttons.put(20, PICKAXES);
        buttons.put(21, ISLAND_THEMES);
        buttons.put(22, DEATH_SHRIEK);
        buttons.put(23, RESET_ANIMATION);
        buttons.put(24, BANNER);
        buttons.put(25, STATS_RESET);

        buttons.put(49, new Button() {
            @Override
            public ItemStack getButtonItem(Player player) {
                String ems = "§2E§am§2e§ar§2a§al§2d§as";
                PlayerProfile profile = plugin.getProfileManager().get(player.getUniqueId());

                return new ItemBuilder(Material.EMERALD)
                        .name(ems + CC.GRAY + ":" + CC.GREEN + profile.getEmeralds())
                        .lore(CC.GRAY + "You can purchase " + ems + CC.GRAY + " at the store: ")
                        .lore(CC.YELLOW + "/store")
                        .build();
            }
        });


        return buttons;
    }
}
