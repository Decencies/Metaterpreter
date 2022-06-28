# Metaterpreter
An API for interfacing with Bukkit metadata.

## Getting Started

### Accessing the API
You may obtain an instance of the Metaterpreter API by using the following line:
```java
final MetaterpreterAPI metaterpreter = (MetaterpreterAPI) getServer().getPluginManager().getPlugin("Metaterpreter");
```

### Getting & Setting Metadata
```java
@EventHandler
public void onPlayerJoin(PlayerJoinEvent event) {
    final Player player = event.getPlayer();

    final IKeypairMetaRegistry<String> testMeta =
            forPlugin(this)                 // the plugin to get the registry for
            .forKey("TestMeta")             // The metadata key to use
            .forType(String.class);         // the value of the metadata to use

    testMeta.setMetaValue(player, "Some value.");

    getLogger().info(player.getName() + "'s TestMeta is: " + testMeta.getMetaValue(player));
}
```

