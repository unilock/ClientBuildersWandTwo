package cc.unilock.clientbuilderswand.fabric;

import net.fabricmc.api.ClientModInitializer;
import cc.unilock.clientbuilderswand.ClientBuildersWand;

public class ClientBuildersWandFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientBuildersWand.init();
    }
}
