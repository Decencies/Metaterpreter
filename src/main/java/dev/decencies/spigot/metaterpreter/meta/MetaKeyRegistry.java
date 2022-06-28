package dev.decencies.spigot.metaterpreter.meta;

import dev.decencies.spigot.metaterpreter.api.IKeypairMetaRegistry;
import dev.decencies.spigot.metaterpreter.api.IMetaKeyRegistry;
import org.bukkit.metadata.Metadatable;

import org.bukkit.plugin.java.JavaPlugin;

public class MetaKeyRegistry implements IMetaKeyRegistry {

    private final JavaPlugin plugin;
    private final String metadataKey;

    MetaKeyRegistry(JavaPlugin plugin, String metadataKey) {
        this.plugin = plugin;
        this.metadataKey = metadataKey;
    }

    @Override
    public String getKey() {
        return metadataKey;
    }

    @Override
    public <V> V getMetaValueNullable(Metadatable metadatable, Class<V> metadataClass) {
        return MetaterpreterBase.getMetaValueNullable(metadatable, metadataKey, plugin.getClass(), metadataClass);
    }

    @Override
    public <V> V getMetaValue(Metadatable metadatable, Class<V> metadataClass) {
        return MetaterpreterBase.getMetaValue(metadatable, metadataKey, plugin.getClass(), metadataClass);
    }

    @Override
    public <V> V getOrCreateMetaValue(Metadatable metadatable, V defaultValue, Class<V> metadataClass) {
        return MetaterpreterBase.getOrCreateMetaValue(metadatable, metadataKey, plugin.getClass(), metadataClass, defaultValue);
    }

    @Override
    public <V> void setMetaValue(Metadatable metadatable, V value) {
        MetaterpreterBase.setMetaValue(metadatable, metadataKey, plugin.getClass(), value);
    }

    @Override
    public <V> IKeypairMetaRegistry<V> forType(Class<V> metadataClass) {
        return new KeypairMetaProvider<>(plugin, metadataKey, metadataClass);
    }

}
