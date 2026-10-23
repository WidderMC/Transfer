package widder.transfer;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Transfer implements ModInitializer {
	public static final String MOD_ID = "transfer";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final boolean debug = false;
	public static final String version = "V3.0.0";

	@Override
	public void onInitialize() {
		Config.LoadConfig();
		Command.CommandRegister();

		if (debug) {
			for (int i = 1; i < Config.getCommandCounter()+1;) {
				LOGGER.info(i+"-CommandName: " + Config.getCommandName(i));
				LOGGER.info(i+"-IP: " + Config.getIp(i));
				LOGGER.info(i+"-Port: " + Config.getPort(i));
				i++;
			}
		}

		LOGGER.info("Successful loaded Config");
	}
}