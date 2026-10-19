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

    public static final String commandName = getCommandName();
    public static final String IP = getIp();
    public static final int Port = getPort();

    public static void LoadConfig() {
        try {
            Files.createDirectories(FILE.getParent());

            if (Files.exists(FILE)) {
                try (InputStream in = Files.newInputStream(FILE)) {
                    PROPERTIES.load(in);
                }
            }

            PROPERTIES.putIfAbsent("CommandName","transfer");
            PROPERTIES.putIfAbsent("IP","");
            PROPERTIES.putIfAbsent("Port","25565");

            try (OutputStream out = Files.newOutputStream(FILE)) {
                PROPERTIES.store(out, "Transfer Configs");
            }

        } catch (IOException e) {
            Transfer.LOGGER.error("Error by Loding the Config:", e);
        }
    }

    public static String getCommandName() {
        return PROPERTIES.getProperty("CommandName");
    }

    public static String getIp() {
        return PROPERTIES.getProperty("IP");
    }

    public static int getPort() {
        return Integer.parseInt(PROPERTIES.getProperty("Port"));
    }
}