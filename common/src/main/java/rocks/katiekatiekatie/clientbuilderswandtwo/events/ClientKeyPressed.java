package rocks.katiekatiekatie.clientbuilderswandtwo.events;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.client.ClientRawInputEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import org.lwjgl.glfw.GLFW;
import rocks.katiekatiekatie.clientbuilderswandtwo.ClientBuildersWandTwo;
import rocks.katiekatiekatie.clientbuilderswandtwo.Constants;

@Environment(EnvType.CLIENT)
public class ClientKeyPressed {
    public static void init() {
        ClientRawInputEvent.KEY_PRESSED.register((client, screen, keyCode, scanCode, modifiers) -> {
            MutableText on = Text.translatable("clientbuilderswandtwo.on")
                                 .setStyle(Style.EMPTY.withFormatting(Formatting.DARK_GREEN));

            MutableText off = Text.translatable("clientbuilderswandtwo.off")
                                  .setStyle(Style.EMPTY.withFormatting(Formatting.DARK_RED));

            if (keyCode != GLFW.GLFW_KEY_ESCAPE) {
                if (Constants.openMenu.isPressed()) {
                    client.setScreen(ClientBuildersWandTwo.configScreen);
                }

                if (Constants.toggleWand.isPressed()) {
                    Constants.wandEnabled = !Constants.wandEnabled;
                    client.player.sendMessage(Text.translatable("clientbuilderswandtwo.wand").append(": ").append(Constants.wandEnabled ? on : off), true);
                }
            }

            return EventResult.pass();
        });
    }
}
