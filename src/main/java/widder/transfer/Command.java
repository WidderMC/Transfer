package widder.transfer;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.ClientboundTransferPacket;
import net.minecraft.server.level.ServerPlayer;

import java.util.Objects;

public class Command {
    public static void CommandRegister() {
        CommandRegistrationCallback.EVENT.register((dispatcher, buildContext, selection) ->
                dispatcher.register(
                        Commands.literal("transfer-plus")
                                .then(Commands.literal("version").executes(
                                        context -> transferPlus(context,0)
                                ))
                                .then(Commands.literal("reload").executes(
                                        context -> transferPlus(context,1)
                                )
                        )
                ));

        for (int i = 1; i < Config.getCommandCounter()+1;) {
            int temp_i = i;
            CommandRegistrationCallback.EVENT.register((dispatcher, buildContext, selection) ->
                    dispatcher.register(
                            Commands.literal(String.valueOf(Config.getCommandName(temp_i))).executes(
                                    context -> Transfer(context, temp_i)
                            )));
            i++;
        }
    }

    private static int transferPlus(CommandContext<CommandSourceStack> context,int i) {
        if (i == 1) {
            context.getSource().sendSuccess(() -> Component.literal("Start loading Config\n....."),false);
            Config.LoadConfig();
            CommandRegister();
            for (ServerPlayer player : context.getSource().getServer().getPlayerList().getPlayers()) {
                context.getSource().getServer().getCommands().sendCommands(player);
            }
            context.getSource().sendSuccess(() -> Component.literal("Successful loaded Config\nIt may not work unless you restart the server"),false);
            return 1;
        } else {
            context.getSource().sendSuccess(() -> Component.literal("Transfer-Plus version: "+Transfer.version),false);
            return 0;
        }
    }

    private static int Transfer(CommandContext<CommandSourceStack> context, int i) {
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