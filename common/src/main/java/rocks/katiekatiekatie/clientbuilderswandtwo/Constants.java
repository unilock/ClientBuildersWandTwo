package rocks.katiekatiekatie.clientbuilderswandtwo;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.util.hit.BlockHitResult;

import java.util.ArrayList;

@Environment(EnvType.CLIENT)
public class Constants {
    // TODO: this probably isn't a good idea
    //       deadlocks, anyone...?

    public static KeyBinding toggleWand;
    public static KeyBinding openMenu;

    public static boolean delay = false;
    public static boolean wandEnabled = false;
    public static final ArrayList<BlockHitResult> targetPos = new ArrayList<>();
}
