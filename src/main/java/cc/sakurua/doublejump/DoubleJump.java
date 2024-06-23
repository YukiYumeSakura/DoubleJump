package cc.sakurua.doublejump;

import cc.sakurua.doublejump.listeners.JumpListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class DoubleJump extends JavaPlugin {

    public static int distance;
    public static int height;
    public static String sound;

    private static DoubleJump instance;

    @Override
    public void onEnable() {
        instance = this;
        loadConfig();
        getServer().getPluginManager().registerEvents(new JumpListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadConfig() {
        saveDefaultConfig();
        FileConfiguration config = getConfig();
            distance = config.getInt("distance");
            height = config.getInt("height");
            sound = config.getString("sound");
    }

    public static DoubleJump getInstance() {
        return instance;
    }

}
