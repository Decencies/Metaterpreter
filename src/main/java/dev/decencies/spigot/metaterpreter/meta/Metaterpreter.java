package dev.decencies.spigot.metaterpreter.meta;

import dev.decencies.spigot.metaterpreter.api.IMetaPluginRegistry;
import dev.decencies.spigot.metaterpreter.api.MetaterpreterAPI;

import org.bukkit.plugin.java.JavaPlugin;

public interface Metaterpreter extends MetaterpreterAPI {

    @Override
    default <P extends JavaPlugin> IMetaPluginRegistry<P> forPlugin(P plugin) {
        return new PluginMetaRegistry<>(plugin);
    }

    @Override
    default <P extends JavaPlugin> IMetaPluginRegistry<P> forPlugin(Class<P> pluginClass) {
        return new PluginMetaRegistry<>(pluginClass);
    }

}
