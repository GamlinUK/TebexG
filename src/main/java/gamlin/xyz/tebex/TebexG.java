package gamlin.xyz.tebex;

import gamlin.xyz.tebex.commands.GiveGC;
import gamlin.xyz.tebex.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class TebexG extends JavaPlugin {

    private final PluginDescriptionFile pluginInfo = getDescription();
    private final String pluginVersion = pluginInfo.getVersion();
    private static TebexG plugin;
    Logger logger = this.getLogger();

    @Override
    public void onEnable() {

        // Plugin startup logic
        plugin = this;

        //Server version compatibility check
        if (!(Bukkit.getServer().getVersion().contains("1.13")|| Bukkit.getServer().getVersion().contains("1.14")||
                Bukkit.getServer().getVersion().contains("1.15")||Bukkit.getServer().getVersion().contains("1.16")||
                Bukkit.getServer().getVersion().contains("1.17")||Bukkit.getServer().getVersion().contains("1.18"))){
            logger.warning(ColorUtils.translateColorCodes("&4-------------------------------------------"));
            logger.warning(ColorUtils.translateColorCodes("&6TebexG: &4This plugin is only supported on the Minecraft versions listed below:"));
            logger.warning(ColorUtils.translateColorCodes("&6TebexG: &41.13.x"));
            logger.warning(ColorUtils.translateColorCodes("&6TebexG: &41.14.x"));
            logger.warning(ColorUtils.translateColorCodes("&6TebexG: &41.15.x"));
            logger.warning(ColorUtils.translateColorCodes("&6TebexG: &41.16.x"));
            logger.warning(ColorUtils.translateColorCodes("&6TebexG: &41.17.x"));
            logger.warning(ColorUtils.translateColorCodes("&6TebexG: &41.18.x"));
            logger.warning(ColorUtils.translateColorCodes("&6TebexG: &4Is now disabling!"));
            logger.warning(ColorUtils.translateColorCodes("&4-------------------------------------------"));
            Bukkit.getPluginManager().disablePlugin(this);
        } else {
            logger.info(ColorUtils.translateColorCodes("&a-------------------------------------------"));
            logger.info(ColorUtils.translateColorCodes("&6TebexG: &aA supported Minecraft version has been detected"));
            logger.info(ColorUtils.translateColorCodes("&6TebexG: &6Continuing plugin startup"));
            logger.info(ColorUtils.translateColorCodes("&a-------------------------------------------"));
        }

        //Load the plugin configs
        //getConfig().options().copyDefaults();
        //saveDefaultConfig();

        this.getCommand("givegc").setExecutor(new GiveGC());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static TebexG getPlugin() {
        return plugin;
    }
}
