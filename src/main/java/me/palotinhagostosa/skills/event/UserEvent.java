package me.palotinhagostosa.skills.event;

import lombok.Data;
import me.palotinhagostosa.skills.model.User;
import me.palotinhagostosa.skills.utils.EventWrapper;
import org.bukkit.event.Cancellable;

@Data
public class UserEvent extends EventWrapper implements Cancellable {

    private final User user;

    private boolean cancelled;

}
