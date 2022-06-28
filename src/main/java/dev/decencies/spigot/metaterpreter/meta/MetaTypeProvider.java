package dev.decencies.spigot.metaterpreter.meta;

import dev.decencies.spigot.metaterpreter.api.IKeypairMetaRegistry;
import dev.decencies.spigot.metaterpreter.api.IMetaTypeRegistry;
import org.bukkit.metadata.Metadatable;

import org.bukkit.plugin.java.JavaPlugin;

public class MetaTypeProvider<V> implements IMetaTypeRegistry<V> {

    private final JavaPlugin plugin;
    private final Class<V> metadataClass;

    MetaTypeProvider(JavaPlugin plugin, Class<V> metadataClass) {
        this.plugin = plugin;
        this.metadataClass = metadataClass;
    }

    @Override
    public Class<V> getType() {
        return metadataClass;
    }

    @Override
    public V getMetaValueNullable(Metadatable metadatable, String metadataKey) {
        return MetaterpreterBase.getMetaValue(metadatable, metadataKey, plugin.getClass(), metadataClass);
    }

    @Override
    public V getMetaValue(Metadatable metadatable, String metadataKey) {
        return MetaterpreterBase.getMetaValue(metadatable, metadataKey, plugin.getClass(), metadataClass);
    }

    @Override
    public V getOrCreateMetaValue(Metadatable metadatable, String metadataKey, V defaultValue) {
        return MetaterpreterBase.getOrCreateMetaValue(metadatable, metadataKey, plugin.getClass(), metadataClass, defaultValue);
    }

    @Override
    public void setMetaValue(Metadatable metadatable, String metadataKey, V value) {
        MetaterpreterBase.setMetaValue(metadatable, metadataKey, plugin.getClass(), value);
    }

    @Override
    public IKeypairMetaRegistry<V> forKey(String metadataKey) {
        return new KeypairMetaProvider<>(plugin, metadataKey, metadataClass);
    }

}
