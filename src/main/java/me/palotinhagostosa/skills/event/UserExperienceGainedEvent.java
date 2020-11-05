package me.palotinhagostosa.skills.event;

import lombok.Getter;
import lombok.Setter;
import me.palotinhagostosa.skills.model.Skill;
import me.palotinhagostosa.skills.model.User;

@Getter
public class UserExperienceGainedEvent extends UserEvent {

    private final Skill skill;

    @Setter
    private double experience;

    public UserExperienceGainedEvent(User user, Skill skill, double experience) {
        super(user);

        this.skill = skill;
        this.experience = experience;
    }

}
