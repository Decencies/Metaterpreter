package dev.decencies.spigot.metaterpreter.meta;

import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.java.JavaPlugin;

public class MetaterpreterBase {

    @SuppressWarnings("unchecked")
    static <V> V getMetaValueNullable(Metadatable metadatable, String metadataKey, Class<? extends JavaPlugin> pluginClass, Class<V> metadataClass) {
        if (metadatable.hasMetadata(metadataKey)) {
            for (MetadataValue metadataValue : metadatable.getMetadata(metadataKey)) {
                if (metadataValue.getOwningPlugin().getClass() == pluginClass) {
                    final Object value = metadataValue.value();
                    if (value != null && !value.getClass().isAssignableFrom(metadataClass)) {
                        throw new IllegalArgumentException(String.format("Metadata key %s for %s is not assignable from %s.", metadataKey, pluginClass.getName(), metadataClass.getName()));
                    }
                    return (V) value;
                }
            }
        }
        return null;
    }

    static <V> V getMetaValue(Metadatable metadatable, String metadataKey, Class<? extends JavaPlugin> pluginClass, Class<V> metadataClass) {
        V value = getMetaValueNullable(metadatable, metadataKey, pluginClass, metadataClass);
        if (value == null) {
            throw new RuntimeException(String.format("Value is null for %s.", metadataKey));
        }
        return value;
    }

    static <M extends Metadatable, V> V getOrCreateMetaValue(M metadatable, String metadataKey, Class<? extends JavaPlugin> pluginClass, Class<V> metadataClass, V defaultValue) {
        V value = getMetaValueNullable(metadatable, metadataKey, pluginClass, metadataClass);
        if (value == null) {
            value = defaultValue;
            setMetaValue(metadatable, metadataKey, pluginClass, value);
        }
        return value;
    }

    static <V> void setMetaValue(Metadatable metadatable, String metadataKey, Class<? extends JavaPlugin> pluginClass, V value) {
        metadatable.setMetadata(metadataKey, new FixedMetadataValue(JavaPlugin.getPlugin(pluginClass), value));
    }

}
