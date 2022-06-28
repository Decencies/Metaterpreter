package dev.decencies.spigot.metaterpreter.api;

import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;

public interface IMetaKeyRegistry {

    /**
     * Gets the key associated with this registry.
     * @return the key.
     */
    String getKey();

    /**
     * Gets the value of the {@link MetadataValue} associated with this registry's key, may return null.
     * @param metadatable the metadata holder.
     * @param metadataClass the class of the metadata.
     * @param <V> the type of the metadata.
     * @return the value or {@code null}.
     */
    <V> V getMetaValueNullable(Metadatable metadatable, Class<V> metadataClass);

    /**
     * Gets the value of the {@link MetadataValue} associated with this registry's key.
     * @param metadatable the metadata holder.
     * @param metadataClass the class of the metadata.
     * @param <V> the type of the metadata.
     * @return the value.
     */
    <V> V getMetaValue(Metadatable metadatable, Class<V> metadataClass);

    /**
     * Gets or creates a default value of the {@link MetadataValue} associated with this registry's key.
     * @param metadatable the metadata holder.
     * @param defaultValue the default value.
     * @param metadataClass the class of the metadata.
     * @param <V> the type of the metadata.
     * @return the value.
     */
    <V> V getOrCreateMetaValue(Metadatable metadatable, V defaultValue, Class<V> metadataClass);

    /**
     * Sets the value of the {@link MetadataValue} specified by this registry's key.
     * @param metadatable the metadata holder.
     * @param value the value.
     * @param <V> the type of the metadata.
     */
    <V> void setMetaValue(Metadatable metadatable, V value);

    /**
     * Create a {@link IMetaKeyRegistry} using this registry's key.
     * @param metadataClass the class of the metadata.
     * @param <V> the type of the metadata.
     * @return the registry.
     */
    <V> IKeypairMetaRegistry<V> forType(Class<V> metadataClass);

}
