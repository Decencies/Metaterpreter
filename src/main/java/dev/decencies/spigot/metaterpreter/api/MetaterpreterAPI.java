package dev.decencies.spigot.metaterpreter.api;

import org.bukkit.plugin.java.JavaPlugin;

public interface MetaterpreterAPI {

    /**
     * Creates a {@link IMetaPluginRegistry<P>} for the specified plugin.
     * @param plugin the plugin.
     * @param <P> the type of the plugin.
     * @return the registry.
     */
    <P extends JavaPlugin> IMetaPluginRegistry<P> forPlugin(P plugin);

    /**
     * Creates a {@link IMetaPluginRegistry<P>} for the specified plugin.
     * @param pluginClass the class of the plugin.
     * @param <P> the type of the plugin.
     * @return the registry.
     */
    <P extends JavaPlugin> IMetaPluginRegistry<P> forPlugin(Class<P> pluginClass);

}
