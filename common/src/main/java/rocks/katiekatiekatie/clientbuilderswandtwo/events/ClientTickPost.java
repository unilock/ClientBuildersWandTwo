package rocks.katiekatiekatie.clientbuilderswandtwo.events;

import dev.architectury.event.events.client.ClientTickEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import rocks.katiekatiekatie.clientbuilderswandtwo.Constants;
import rocks.katiekatiekatie.clientbuilderswandtwo.config.ModConfig;

@Environment(EnvType.CLIENT)
public class ClientTickPost {
    private static int wait = 0;

    public static void init() {
        ClientTickEvent.CLIENT_POST.register(instance -> {
            if (wait > 0) {
                --wait;
            } else {
                int counter = 0;

                int max = ModConfig.blocksPerTick;

                while (!Constants.targetPos.isEmpty() && counter < max) {
                    wait = 1;
                    ++counter;

                    BlockHitResult blockHitResult = Constants.targetPos.get(0);

                    instance.interactionManager.interactBlock(instance.player, Hand.MAIN_HAND, blockHitResult);

                    Constants.targetPos.remove(0);
                }

                if (Constants.targetPos.isEmpty()) {
                    Constants.delay = false;
                }
            }
        });
    }
}
