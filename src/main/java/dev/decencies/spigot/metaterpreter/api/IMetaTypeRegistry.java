package dev.decencies.spigot.metaterpreter.api;

import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;

public interface IMetaTypeRegistry<V> {

    /**
     * Gets the type associated with this registry.
     * @return the type.
     */
    Class<V> getType();

    /**
     * Gets the value of the {@link MetadataValue}.
     * @param metadatable the metadata holder.
     * @param metadataKey the key.
     * @return the {@link V} value or {@code null}.
     */
    V getMetaValueNullable(Metadatable metadatable, String metadataKey);

    /**
     * Gets the value of the {@link MetadataValue}.
     * @param metadatable the metadata holder.
     * @param metadataKey the key.
     * @return the {@link V} value.
     */
    V getMetaValue(Metadatable metadatable, String metadataKey);

    /**
     * Gets or creates a default value of the {@link MetadataValue}.
     * @param metadatable the metadata holder.
     * @param metadataKey the key.
     * @param defaultValue the default value.
     * @return the {@link V} value.
     */
    V getOrCreateMetaValue(Metadatable metadatable, String metadataKey, V defaultValue);

    /**
     * Sets the value of the {@link MetadataValue}.
     * @param metadatable the metadata holder.
     * @param metadataKey the key.
     * @param value the value.
     */
    void setMetaValue(Metadatable metadatable, String metadataKey, V value);

    /**
     * Creates a new {@link IKeypairMetaRegistry<V>} for the specified key, using this {@link V} type.
     * @param metadataKey the key.
     * @return the registry.
     */
    IKeypairMetaRegistry<V> forKey(String metadataKey);

}
