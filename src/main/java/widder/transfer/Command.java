package widder.transfer;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.ClientboundTransferPacket;

import java.util.Objects;

public class Command {
    public static void CommandRegister() {
        for (int i = 1; i < Config.getCommandCounter()+1;) {
            CommandRegistrationCallback.EVENT.register((dispatcher, buildContext, selection) ->
                    dispatcher.register(
                            Commands.literal(String.valueOf(Config.getCommandName(i))).executes(
                                    context -> Transfer(context, i)
                            )));
        }
    }

    public static int Transfer(CommandContext<CommandSourceStack> context, int i) {
        if (context.getSource().getPlayer() == null){
            context.getSource().sendFailure(Component.literal("The Command must be runed by a Player"));
            return 0;
        }else {
            var transferPacket = new ClientboundTransferPacket(Config.getIp(i), Config.getPort(i));
            Objects.requireNonNull(context.getSource().getPlayer()).connection.send(transferPacket);
            return 1;
        }
    }
}