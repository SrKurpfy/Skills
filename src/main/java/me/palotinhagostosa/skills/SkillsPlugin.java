package me.palotinhagostosa.skills;

import me.palotinhagostosa.skills.storage.SkillManager;
import me.palotinhagostosa.skills.storage.UserController;
import me.palotinhagostosa.skills.storage.UserManager;
import me.palotinhagostosa.skills.view.SkillsView;
import me.saiintbrisson.minecraft.ViewFrame;
import org.bukkit.plugin.java.JavaPlugin;

public class SkillsPlugin extends JavaPlugin {

    private ViewFrame viewFrame;

    private UserManager userManager;
    private UserController userController;

    private SkillManager skillManager;

    @Override
    public void onLoad() {
        this.viewFrame = new ViewFrame(this);

        this.userManager = new UserManager();
        this.userController = new UserController(this);

        this.skillManager = new SkillManager();
    }

    @Override
    public void onEnable() {
        viewFrame.register();
        viewFrame.addView(new SkillsView(this));

        skillManager.registerSkills(getClass().getPackage() + ".model.skill");
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public UserController getUserController() {
        return userController;
    }

    public SkillManager getSkillManager() {
        return skillManager;
    }

    public ViewFrame getViewFrame() {
        return viewFrame;
    }
}
