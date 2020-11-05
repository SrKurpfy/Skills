package me.palotinhagostosa.skills.model;

import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public interface Skill extends Listener {

    String getName();

    ItemStack getIcon();

    int getSlot();
}
