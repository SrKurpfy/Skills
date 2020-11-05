package me.palotinhagostosa.skills.event;

import lombok.Getter;
import me.palotinhagostosa.skills.model.Skill;
import me.palotinhagostosa.skills.model.User;

@Getter
public class UserLevelUpEvent extends UserEvent {

    private final Skill skill;
    private final int newLevel;

    public UserLevelUpEvent(User user, Skill skill, int newLevel) {
        super(user);

        this.skill = skill;
        this.newLevel = newLevel;
    }
}
