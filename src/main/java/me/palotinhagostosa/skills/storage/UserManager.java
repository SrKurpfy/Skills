package me.palotinhagostosa.skills.storage;

import me.palotinhagostosa.skills.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {

    private final Map<UUID, User> userMap;

    public UserManager() {
        this.userMap = new ConcurrentHashMap<>();
    }

    public UserManager(Map<UUID, User> userMap) {
        this.userMap = userMap;
    }

    public void insertUser(UUID id, User user) {
        userMap.put(id, user);
    }

    public User deleteUser(UUID id) {
        return userMap.remove(id);
    }

    public User getById(UUID id) {
        return userMap.get(id);
    }

    public Collection<User> getAllUsers() {
        return userMap.values();
    }

}
