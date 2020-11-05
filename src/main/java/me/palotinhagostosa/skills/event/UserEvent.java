package me.palotinhagostosa.skills.event;

import lombok.Data;
import me.palotinhagostosa.skills.model.User;
import me.palotinhagostosa.skills.utils.EventWrapper;

@Data
public class UserEvent extends EventWrapper {

    private final User user;


}
