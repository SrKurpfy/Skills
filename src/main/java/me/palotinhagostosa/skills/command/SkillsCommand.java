package me.palotinhagostosa.skills.command;

import com.google.common.collect.ImmutableMap;
import me.palotinhagostosa.skills.SkillsPlugin;
import me.palotinhagostosa.skills.view.SkillsView;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import org.bukkit.entity.Player;

public class SkillsCommand {

    private final SkillsPlugin plugin;

    public SkillsCommand(SkillsPlugin plugin) {
        this.plugin = plugin;
    }

    @Command(
      name = "skills",
      aliases = {"habilidades"}
    )
    public void handleSkillsCommand(Context<Player> context) {
        final Player sender = context.getSender();

        plugin.getViewFrame().open(SkillsView.class, sender, ImmutableMap.of(
          "user", plugin.getUserManager().getById(sender.getUniqueId())
        ));
    }
}
