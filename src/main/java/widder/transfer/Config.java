package widder.transfer;

import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class Config {
    private static final Path FILE = FabricLoader.getInstance().getConfigDir().resolve("transfer.properties");
    private static final Properties PROPERTIES = new Properties();

    public static void LoadConfig() {
        try {
            Files.createDirectories(FILE.getParent());

            if (Files.exists(FILE)) {
                try (InputStream in = Files.newInputStream(FILE)) {
                    PROPERTIES.load(in);
                }
            }

            PROPERTIES.putIfAbsent("CommandsCounter","1");
            for (int i=1; i < getCommandCounter()+1;) {
                PROPERTIES.putIfAbsent(i+"-CommandName",i+"-server");
                PROPERTIES.putIfAbsent(i+"-IP","");
                PROPERTIES.putIfAbsent(i+"-Port","25565");
                if (Transfer.debug) {
                    Transfer.LOGGER.info("CommandCounter: " + i);
                }
                i++;
            }

            try (OutputStream out = Files.newOutputStream(FILE)) {
                PROPERTIES.store(out, "Transfer Configs");
            }

        } catch (IOException e) {
            Transfer.LOGGER.error("Error by Loding the Config:", e);
        }
    }

    public static int getCommandCounter() {
        return Integer.parseInt(PROPERTIES.getProperty("CommandsCounter"));
    }

    public static String getCommandName(int i) {
        return PROPERTIES.getProperty(i+"-CommandName");
    }

    public static String getIp(int i) {
        return PROPERTIES.getProperty(i+"-IP");
    }

    public static int getPort(int i) {
        return Integer.parseInt(PROPERTIES.getProperty(i+"-Port"));
    }
}