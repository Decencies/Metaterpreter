package dev.decencies.spigot.metaterpreter.meta;

import dev.decencies.spigot.metaterpreter.api.IMetaKeyRegistry;
import dev.decencies.spigot.metaterpreter.api.IMetaPluginRegistry;
import dev.decencies.spigot.metaterpreter.api.IMetaTypeRegistry;

import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginMetaRegistry<P extends JavaPlugin> implements IMetaPluginRegistry<P> {

    private final P plugin;

    PluginMetaRegistry(P plugin) {
        this.plugin = plugin;
    }

    PluginMetaRegistry(Class<P> pluginClass) {
        this.plugin = JavaPlugin.getPlugin(pluginClass);
    }

    @Override
    public P getPlugin() {
        return plugin;
    }

    @Override
    public <V> V getMetaValueNullable(Metadatable metadatable, String metadataKey, Class<V> metadataClass) {
        return MetaterpreterBase.getMetaValueNullable(metadatable, metadataKey, plugin.getClass(), metadataClass);
    }

    @Override
    public <V> V getMetaValue(Metadatable metadatable, String metadataKey, Class<V> metadataClass) {
        return MetaterpreterBase.getMetaValue(metadatable, metadataKey, plugin.getClass(), metadataClass);
    }

    @Override
    public <V> V getOrCreateMetaValue(Metadatable metadatable, String metadataKey, Class<V> metadataClass, V defaultValue) {
        return MetaterpreterBase.getOrCreateMetaValue(metadatable, metadataKey, plugin.getClass(), metadataClass, defaultValue);
    }

    @Override
    public <V> void setMetaValue(Metadatable metadatable, String metadataKey, V value) {
        MetaterpreterBase.setMetaValue(metadatable, metadataKey, plugin.getClass(), value);
    }

    @Override
    public IMetaKeyRegistry forKey(String metadataKey) {
        return new MetaKeyRegistry(plugin, metadataKey);
    }

    @Override
    public <V> IMetaTypeRegistry<V> forType(Class<V> metadataClass) {
        return new MetaTypeProvider<>(plugin, metadataClass);
    }
}
