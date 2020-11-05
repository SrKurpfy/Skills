package me.palotinhagostosa.skills.model;

import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class User {

    private final UUID id;
    private final String username;

    private final Map<String, Double> experienceMap;
    private final Map<String, Integer> levelMap;

    public Double getExperience(Skill skill) {
        return experienceMap.get(skill);
    }

    public Double getExperienceToLevelUp(Skill skill) {
        return (experienceMap.getOrDefault(skill.getName(), 0D) + 1) * 300;
    }

    public void addExperience(Skill skill, double experience) {
        experienceMap.put(skill.getName(), experienceMap.getOrDefault(skill.getName(), 0D) + experience);
    }


    public void setSkillLevel(Skill skill, int level) {
        levelMap.put(skill.getName(), level);
    }

    public Integer getSkillLevel(Skill skill) {
        return levelMap.get(skill.getName());
    }

    public int getTotalSkillLevel() {
        return levelMap.values().stream().mapToInt(value -> value).sum();
    }
}
