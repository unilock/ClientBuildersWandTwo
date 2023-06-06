package cc.unilock.clientbuilderswandtwo.events;

import cc.unilock.clientbuilderswandtwo.Constants;
import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class RegisterKeys {
    public static void init() {
        String categoryString = "clientbuilderswandtwo.key.category";
        String nameString = "clientbuilderswandtwo.key.";

        Constants.toggleWand = new KeyBinding(nameString + "toggleWand", GLFW.GLFW_KEY_V, categoryString);
        Constants.openMenu = new KeyBinding(nameString + "settings", GLFW.GLFW_KEY_I, categoryString);

        KeyMappingRegistry.register(Constants.toggleWand);
        KeyMappingRegistry.register(Constants.openMenu);
    }
}
