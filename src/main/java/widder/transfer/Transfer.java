package widder.transfer;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.api.ModInitializer;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.protocol.common.ClientboundTransferPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static widder.transfer.Config.IP;
import static widder.transfer.Config.Port;

public class Transfer implements ModInitializer {
	public static final String MOD_ID = "transfer";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		Config.LoadConfig();
		Command.CommandRegister();

		LOGGER.info("Successful loaded Config");
	}

	public static int Transfer(CommandContext<CommandSourceStack> context) {
		var transferPacket = new ClientboundTransferPacket(IP, Port);
		context.getSource().getPlayer().connection.send(transferPacket);
		return 0;
	}
}