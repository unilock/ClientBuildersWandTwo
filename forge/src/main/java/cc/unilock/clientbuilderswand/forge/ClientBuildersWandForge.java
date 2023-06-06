package cc.unilock.clientbuilderswand.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import cc.unilock.clientbuilderswand.ClientBuildersWand;

@Mod(ClientBuildersWand.MOD_ID)
public class ClientBuildersWandForge {
    public ClientBuildersWandForge() {
        // Submit our event bus to let Architectury register our content on the right time
        EventBuses.registerModEventBus(ClientBuildersWand.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        ClientBuildersWand.init();
    }
}
