package widder.transfer;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Transfer implements ModInitializer {
	public static final String MOD_ID = "transfer";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final boolean debug = false;

	@Override
	public void onInitialize() {
		Config.LoadConfig();
		Command.CommandRegister();

		if (debug) {
			LOGGER.info("commandName: " + Config.getCommandName());
			LOGGER.info("IP: " + Config.getIp());
			LOGGER.info("Port: " + Config.getPort());
		}

		LOGGER.info("Successful loaded Config");
	}
}