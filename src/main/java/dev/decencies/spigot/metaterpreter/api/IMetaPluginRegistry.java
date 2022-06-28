package dev.decencies.spigot.metaterpreter.api;

import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.Plugin;

import org.bukkit.metadata.MetadataValue;

public interface IMetaPluginRegistry<P extends Plugin> {

    /**
     * Gets the plugin associated with this registry.
     * @return the plugin.
     */
    P getPlugin();

    /**
     * Gets the value of the {@link MetadataValue}, may return null.
     * @param metadatable the metadata holder.
     * @param metadataKey the key.
     * @param metadataClass the class of the metadata.
     * @param <V> the type of the metadata.
     * @return the {@link V} value or {@code null}.
     */
    <V> V getMetaValueNullable(Metadatable metadatable, String metadataKey, Class<V> metadataClass);

    /**
     * Gets the value of the {@link MetadataValue}.
     * @param metadatable the metadata holder.
     * @param metadataKey the key.
     * @param metadataClass the class of the metadata.
     * @param <V> the type of the metadata.
     * @return the {@link V} value.
     */
    <V> V getMetaValue(Metadatable metadatable, String metadataKey, Class<V> metadataClass);

    /**
     * Gets or creates a default value of the {@link MetadataValue}.
     * @param metadatable the metadata holder.
     * @param metadataKey the key.
     * @param defaultValue the default value.
     * @param metadataClass the class of the metadata.
     * @param <V> the type of the metadata.
     * @return the {@link V} value.
     */
    <V> V getOrCreateMetaValue(Metadatable metadatable, String metadataKey, Class<V> metadataClass, V defaultValue);

    /**
     * Sets the value of the {@link MetadataValue}.
     * @param metadatable the metadata holder.
     * @param metadataKey the key.
     * @param value the value.
     * @param <V> the type of the metadata.
     */
    <V> void setMetaValue(Metadatable metadatable, String metadataKey, V value);

    /**
     * Create a {@link IMetaKeyRegistry} for ambiguous types.
     * @param metadataKey the key to use.
     * @return the registry.
     */
    IMetaKeyRegistry forKey(String metadataKey);

    /**
     * Create a {@link IMetaKeyRegistry} for ambiguous names.
     * @param metadataClass the class of the metadata.
     * @param <V> the type of the metadata.
     * @return the registry.
     */
    <V> IMetaTypeRegistry<V> forType(Class<V> metadataClass);

}
