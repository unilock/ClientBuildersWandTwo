package rocks.katiekatiekatie.clientbuilderswandtwo.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import rocks.katiekatiekatie.clientbuilderswandtwo.ClientBuildersWandTwo;

@Mod(ClientBuildersWandTwo.MOD_ID)
public class ClientBuildersWandTwoForge {
    public ClientBuildersWandTwoForge() {
        // Submit our event bus to let Architectury register our content on the right time
        EventBuses.registerModEventBus(ClientBuildersWandTwo.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        ClientBuildersWandTwo.init();
    }
}
