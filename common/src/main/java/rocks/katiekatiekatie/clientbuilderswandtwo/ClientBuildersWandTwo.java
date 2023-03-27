package rocks.katiekatiekatie.clientbuilderswandtwo;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import rocks.katiekatiekatie.clientbuilderswandtwo.config.MidnightConfig;
import rocks.katiekatiekatie.clientbuilderswandtwo.config.ModConfig;
import rocks.katiekatiekatie.clientbuilderswandtwo.events.ClientKeyPressed;
import rocks.katiekatiekatie.clientbuilderswandtwo.events.ClientTickPost;
import rocks.katiekatiekatie.clientbuilderswandtwo.events.RegisterKeys;
import rocks.katiekatiekatie.clientbuilderswandtwo.events.RightClickBlock;

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
