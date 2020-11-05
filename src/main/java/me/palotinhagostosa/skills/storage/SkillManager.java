package me.palotinhagostosa.skills.storage;

import me.palotinhagostosa.skills.model.Skill;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections8.Reflections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SkillManager {

    private final Set<Skill> skills;

    public SkillManager() {
        this.skills = new HashSet<>();
    }

    public SkillManager(Set<Skill> skills) {
        this.skills = skills;
    }

    public void registerSkills(JavaPlugin plugin, String packageName) {
        final Reflections reflections = new Reflections(packageName);
        for (Class<? extends Skill> clazz : reflections.getSubTypesOf(Skill.class)) {
            try {
                final Skill skill = clazz.newInstance();

                plugin.getServer().getPluginManager().registerEvents(skill, plugin);
                skills.add(skill);
                
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    
    public Skill getSkillByName(String name) {
        for (Skill skill : skills) {
            if(skill.getName().equalsIgnoreCase(name)) {
                return skill;
            }
        }

        return null;
    }

    public Collection<Skill> getAllSkills() {
        return skills;
    }
}
