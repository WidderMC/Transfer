package widder.transfer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;

import static widder.transfer.Config.commandName;

public class Command {
    public static void CommandRegister() {
        CommandRegistrationCallback.EVENT.register((dispatcher, buildContext, selection) ->
                Commands.literal(commandName).executes(context -> Transfer.Transfer(context)
                        ));
    }
}