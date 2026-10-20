# Transfer Plus

Allows players to connect to another server using a custom command.

## Configuration:

Edit the transfer.properties file:


```
CommandName=hub-server
IP=
Port=25565
```

### **Explain:**

| Property | Description | Default Value |
| -------- | ----------- | ------------- |
| `CommandName` | The name of the command players can use to connect to the server. | `hub-server` |
| `IP` | The IP address of the target server. | Not set |
| `Port` | The port of the target server. | `25565` |

## **Usage:**

Players can use the configured command to connect to the specified server.

For example, if CommandName=lobby, players can use the /lobby command to connect to the configured server.

### **Important:**

1. **Edit** the transfer.properties file.
2. **Enable** accepts-transfers in the server.properties file on the server you are connecting to.
3. **Restart** the server for the changes to take effect.

If you find any bugs or have any Datapack/Mod suggestions, please let me know on my [Discord](https://discord.gg/fy4KuxYKVD).
## License

This template is available under the CC0 license. Feel free to learn from it and incorporate it in your own projects.
