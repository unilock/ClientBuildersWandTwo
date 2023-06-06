package cc.unilock.clientbuilderswand;

import cc.unilock.clientbuilderswand.config.MidnightConfig;
import cc.unilock.clientbuilderswand.config.ModConfig;
import cc.unilock.clientbuilderswand.events.ClientKeyPressed;
import cc.unilock.clientbuilderswand.events.ClientTickPost;
import cc.unilock.clientbuilderswand.events.RegisterKeys;
import cc.unilock.clientbuilderswand.events.RightClickBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;

@Environment(EnvType.CLIENT)
public class ClientBuildersWand {
    public static final String MOD_ID = "clientbuilderswand";

    public static Screen configScreen;

    public static void init() {
        MidnightConfig.init(MOD_ID, ModConfig.class);
        configScreen = MidnightConfig.getScreen(null, MOD_ID);

        // TODO: this is a good idea i'm sure
        ClientKeyPressed.init();
        ClientTickPost.init();
        RegisterKeys.init();
        RightClickBlock.init();
    }
}
