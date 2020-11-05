package me.palotinhagostosa.skills.event;

import lombok.Getter;
import lombok.Setter;
import me.palotinhagostosa.skills.model.Skill;
import me.palotinhagostosa.skills.model.User;
import org.bukkit.event.Cancellable;

@Getter
public class UserExperienceGainedEvent extends UserEvent implements Cancellable {

    private final Skill skill;

    @Setter
    private double experience;

    @Setter
    private boolean cancelled;

    public UserExperienceGainedEvent(User user, Skill skill, double experience) {
        super(user);

        this.skill = skill;
        this.experience = experience;
    }

}
