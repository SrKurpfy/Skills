package me.palotinhagostosa.skills.model.skill;

import me.palotinhagostosa.skills.SkillsPlugin;
import me.palotinhagostosa.skills.model.Skill;
import me.palotinhagostosa.skills.model.Skills;
import me.palotinhagostosa.skills.model.User;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class SwordsSkill implements Skill, Listener {

    private static final SkillsPlugin PLUGIN = SkillsPlugin.getPlugin(SkillsPlugin.class);

    @Override
    public String getName() {
        return "Espadas";
    }

    @Override
    public ItemStack getIcon() {
        return new ItemStack(Material.DIAMOND_SWORD);
    }

    @Override
    public int getSlot() {
        return 20;
    }

    @EventHandler(ignoreCancelled = true)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        final Entity damager = event.getDamager();
        if(!(damager instanceof Player)) return;

        final Player player = (Player) damager;
        final User user = PLUGIN.getUserManager().getById(player.getUniqueId());

        user.addExperience(Skills.SWORDS_SKILL, 10);
    }
}
