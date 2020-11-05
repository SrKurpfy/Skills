package me.palotinhagostosa.skills.model;

import lombok.Data;
import me.palotinhagostosa.skills.event.UserExperienceGainedEvent;
import me.palotinhagostosa.skills.event.UserLevelUpEvent;

import java.util.Map;
import java.util.UUID;

@Data
public class User {

    private final UUID id;
    private final String username;

    private final Map<String, Double> experienceMap;
    private final Map<String, Integer> levelMap;

    public double getExperience(Skill skill) {
        return experienceMap.getOrDefault(skill.getName(), 0D);
    }

    public double getExperienceToLevelUp(Skill skill) {
        return (experienceMap.getOrDefault(skill.getName(), 0D) + 1) * 300;
    }

    public void addExperience(Skill skill, double experience) {
        final UserExperienceGainedEvent gainedEvent = new UserExperienceGainedEvent(this, skill, experience);
        gainedEvent.callEvent();

        if(gainedEvent.isCancelled()) return;

        experienceMap.put(skill.getName(), experienceMap.getOrDefault(skill.getName(), 0D) + experience);
        recalculate(skill);
    }

    private void recalculate(Skill skill) {
        final double experienceToLevelUp = getExperienceToLevelUp(skill);
        final double experience = getExperience(skill);

        if(experience >= experienceToLevelUp) {
            final int newLevel = getSkillLevel(skill) + 1;
            setSkillLevel(skill, newLevel);

            new UserLevelUpEvent(this, skill, newLevel).callEvent();
        }
    }

    public void setSkillLevel(Skill skill, int level) {
        levelMap.put(skill.getName(), level);
    }

    public int getSkillLevel(Skill skill) {
        return levelMap.getOrDefault(skill.getName(), 1);
    }

    public int getTotalSkillLevel() {
        return levelMap.values().stream().mapToInt(value -> value).sum();
    }
}
