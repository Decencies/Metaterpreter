package dev.decencies.spigot.metaterpreter.api;

import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface IKeypairMetaRegistry<V> {

    /**
     * Gets the type associated with this registry.
     * @return the type.
     */
    Class<V> getType();

    /**
     * Gets the key associated with this registry.
     * @return the key.
     */
    String getKey();

    /**
     * Gets the value of the {@link MetadataValue}, may return null.
     * @param metadatable the metadata holder.
     * @return the {@link V} value or {@code null}.
     */
    V getMetaValueNullable(Metadatable metadatable);

    /**
     * Gets the value of the {@link MetadataValue}.
     * @param metadatable the metadata holder.
     * @return the {@link V} value.
     */
    V getMetaValue(Metadatable metadatable);

    /**
     * Gets or creates a default value of the {@link MetadataValue}.
     * @param metadatable the metadata holder.
     * @param defaultValue the default value.
     * @return the {@link V} value.
     */
    V getOrCreateMetaValue(Metadatable metadatable, V defaultValue);

    /**
     * Sets the value of the {@link MetadataValue}.
     * @param metadatable the metadata holder.
     * @param value the value.
     */
    void setMetaValue(Metadatable metadatable, V value);

    /**
     * Creates a getter for an unspecified {@link Metadatable} of type {@link M}.
     * @param <M> the ambiguous type of the metadata holder.
     * @return the getter.
     */
    <M extends Metadatable> Function<M, V> getter();

    /**
     * Creates a {@link Supplier<V>} for getting the value for the specified {@link Metadatable}.
     * @param metadatable the metadata holder.
     * @param <M> the type of the holder.
     * @return the getter.
     */
    <M extends Metadatable> Supplier<V> getter(M metadatable);

    /**
     * Creates a setter for an unspecified {@link Metadatable} of type {@link M}.
     * @param <M> the ambiguous type of the metadata holder.
     * @return the setter.
     */
    <M extends Metadatable> BiConsumer<M, V> setter();

    /**
     * Creates a {@link Consumer<V>} for setting the value for the specified {@link Metadatable}.
     * @param metadatable the metadata holder.
     * @param <M> the type of the holder.
     * @return the setter.
     */
    <M extends Metadatable> Consumer<V> setter(M metadatable);

}
