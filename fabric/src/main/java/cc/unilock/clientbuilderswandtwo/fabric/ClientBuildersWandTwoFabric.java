package cc.unilock.clientbuilderswandtwo.fabric;

import net.fabricmc.api.ClientModInitializer;
import cc.unilock.clientbuilderswandtwo.ClientBuildersWandTwo;

public class ClientBuildersWandTwoFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientBuildersWandTwo.init();
    }
}
