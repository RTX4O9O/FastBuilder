package com.njdge.fastbuilder.utils;

import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

//Credit: https://github.com/diamond-rip/Eden/blob/master/src/main/java/rip/diamond/practice/util/TitleSender.java

public class TitleSender {

    public static void sendTitle(Player player, String text, PacketPlayOutTitle.EnumTitleAction titleAction, int fadeInTime, int showTime, int fadeOutTime) {
        PacketPlayOutTitle title = new PacketPlayOutTitle(titleAction, new ChatComponentText(text), fadeInTime, showTime, fadeOutTime);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
    }
}