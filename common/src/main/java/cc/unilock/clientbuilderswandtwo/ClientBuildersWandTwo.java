package cc.unilock.clientbuilderswandtwo;

import cc.unilock.clientbuilderswandtwo.config.MidnightConfig;
import cc.unilock.clientbuilderswandtwo.config.ModConfig;
import cc.unilock.clientbuilderswandtwo.events.ClientKeyPressed;
import cc.unilock.clientbuilderswandtwo.events.ClientTickPost;
import cc.unilock.clientbuilderswandtwo.events.RegisterKeys;
import cc.unilock.clientbuilderswandtwo.events.RightClickBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;

@Environment(EnvType.CLIENT)
public class ClientBuildersWandTwo {
    public static final String MOD_ID = "clientbuilderswandtwo";

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
