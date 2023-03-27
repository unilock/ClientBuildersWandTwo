package rocks.katiekatiekatie.clientbuilderswandtwo.fabric;

import net.fabricmc.api.ModInitializer;
import rocks.katiekatiekatie.clientbuilderswandtwo.ClientBuildersWandTwo;

public class ClientBuildersWandTwoFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ClientBuildersWandTwo.init();
    }
}
