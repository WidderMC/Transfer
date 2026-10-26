# Download [Here](https://github.com/WidderMC/Transfer)

# Transfer Plus

Allows players to connect to another server using a custom command.

## Commands:

- `/transfer-plus version` <- Show the mod version
- `/transfer-plus reload` <- Reload the config file (may not work)

## Configuration:

Edit the transfer.properties file:


```
x-CommandName=hub-server
x-IP=
x-Port=25565
CommandsCounter=1
```
**X** will be replaced by the command number. **For example**, if you have `CommandsCounter=3`, it will look like this:

```
1-CommandName=1-server
1-IP=
1-Port=25565
2-CommandName=2-server
2-IP=
2-Port=25565
3-CommandName=3-server
3-IP=
3-Port=25565
CommandsCounter=1
```

### **Explain:**

| Property | Description | Default Value |
| -------- | ----------- | ------------- |
| `x-CommandName` | The name of the command players can use to connect to the server. | `x-server` |
| `x-IP` | The IP address of the target server. | Not set |
| `x-Port` | The port of the target server. | `25565` |
| `CommandsCounter` | How many commands should exist | `1` |

## **Usage:**

Players can use the configured command to connect to the specified server.

For example, if 1-CommandName=lobby, players can use the /lobby command to connect to the configured server.

### **Important:**

1. **Edit** the transfer.properties file.
2. **Enable** accepts-transfers in the server.properties file on the server you are connecting to.
3. **Restart** the server for the changes to take effect.

If you find any bugs or have any Datapack/Mod suggestions, please let me know on my [Discord](https://discord.gg/fy4KuxYKVD).

## License

This template is available under the CC0 license. Feel free to learn from it and incorporate it in your own projects.
