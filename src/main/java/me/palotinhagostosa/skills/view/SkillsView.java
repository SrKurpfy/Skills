package me.palotinhagostosa.skills.view;

import me.palotinhagostosa.skills.SkillsPlugin;
import me.palotinhagostosa.skills.model.Skill;
import me.palotinhagostosa.skills.model.User;
import me.palotinhagostosa.skills.utils.Formats;
import me.saiintbrisson.minecraft.OpenViewContext;
import me.saiintbrisson.minecraft.View;
import me.saiintbrisson.minecraft.ViewContext;
import me.saiintbrisson.minecraft.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SkillsView extends View {

    private final SkillsPlugin plugin;

    public SkillsView(SkillsPlugin plugin) {
        super(5);

        this.plugin = plugin;
    }

    @Override
    protected void onOpen(OpenViewContext context) {
        context.setInventoryTitle("Habilidades");
    }

    @Override
    protected void onRender(ViewContext context) {
        final User user = context.get("user");

        context.slot(12, profileItem(user))
          .cancelOnClick();

        for (Skill skill : plugin.getSkillManager().getAllSkills()) {
            context.slot(skill.getSlot(), skillItem(user, skill))
              .cancelOnClick();
        }
    }

    private ItemStack profileItem(User user) {
        return new ItemBuilder(Material.SKULL_ITEM, 1, 3)
          .skull(user.getUsername())

          .name("§7" + user.getUsername())
          .lore(
            "§f[⚒] Nível total: §7" + user.getTotalSkillLevel()
          )

          .build();
    }

    private ItemStack skillItem(User user, Skill skill) {
        return new ItemBuilder(skill.getIcon().getType(), 1, skill.getIcon().getDurability())
          .name("§e" + skill.getName())
          .lore(
            "§fNível: §7" + user.getSkillLevel(skill) + "/1000",
            "§fExperiência: §7" + Formats.apply(user.getExperience(skill)) + "/" + Formats.apply(user.getExperienceToLevelUp(skill))
          )
          .build();
    }
}
