package cz.justdrven.itembuilder;

import org.bukkit.plugin.java.JavaPlugin;

public class ItemBuilder {
    private static JavaPlugin plugin;

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static void setup(JavaPlugin plugin) {
        ItemBuilder.plugin = plugin;
    }
}
