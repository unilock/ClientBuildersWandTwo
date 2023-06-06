package cc.unilock.clientbuilderswandtwo.events;

import cc.unilock.clientbuilderswandtwo.ClientBuildersWandTwo;
import cc.unilock.clientbuilderswandtwo.Constants;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.client.ClientRawInputEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.lwjgl.glfw.GLFW;

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
