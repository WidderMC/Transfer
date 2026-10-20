package widder.transfer;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.protocol.common.ClientboundTransferPacket;

public class Command {
    public static void CommandRegister() {
        CommandRegistrationCallback.EVENT.register((dispatcher, buildContext, selection) ->
                dispatcher.register(
                        Commands.literal(String.valueOf(Config.getCommandName())).executes(context ->
                                Command.Transfer(context)
                )));
    }

    public static int Transfer(CommandContext<CommandSourceStack> context) {
        var transferPacket = new ClientboundTransferPacket(Config.getIp(), Config.getPort());
        context.getSource().getPlayer().connection.send(transferPacket);
        return 0;
    }
}