package dev.decencies.spigot.metaterpreter.meta;

import dev.decencies.spigot.metaterpreter.api.IKeypairMetaRegistry;
import org.bukkit.metadata.Metadatable;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class KeypairMetaProvider<V> implements IKeypairMetaRegistry<V> {

    private final JavaPlugin plugin;
    private final String metadataKey;
    private final Class<V> metadataClass;

    KeypairMetaProvider(JavaPlugin plugin, String metadataKey, Class<V> metadataClass) {
        this.plugin = plugin;
        this.metadataKey = metadataKey;
        this.metadataClass = metadataClass;
    }

    @Override
    public Class<V> getType() {
        return metadataClass;
    }

    @Override
    public String getKey() {
        return metadataKey;
    }

    @Override
    public V getMetaValueNullable(Metadatable metadatable) {
        return MetaterpreterBase.getMetaValueNullable(metadatable, metadataKey, plugin.getClass(), metadataClass);
    }

    @Override
    public V getMetaValue(Metadatable metadatable) {
        return MetaterpreterBase.getMetaValue(metadatable, metadataKey, plugin.getClass(), metadataClass);
    }

    @Override
    public V getOrCreateMetaValue(Metadatable metadatable, V defaultValue) {
        return MetaterpreterBase.getOrCreateMetaValue(metadatable, metadataKey, plugin.getClass(), metadataClass, defaultValue);
    }

    @Override
    public void setMetaValue(Metadatable metadatable, V value) {
        MetaterpreterBase.setMetaValue(metadatable, metadataKey, plugin.getClass(), value);
    }

    @Override
    public <M extends Metadatable> Function<M, V> getter() {
        return this::getMetaValue;
    }

    @Override
    public <M extends Metadatable> Supplier<V> getter(M metadatable) {
        return () -> getMetaValue(metadatable);
    }

    @Override
    public <M extends Metadatable> BiConsumer<M, V> setter() {
        return this::setMetaValue;
    }

    @Override
    public <M extends Metadatable> Consumer<V> setter(M metadatable) {
        return (v) -> setMetaValue(metadatable, v);
    }

}
