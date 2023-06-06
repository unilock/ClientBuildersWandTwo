package cc.unilock.clientbuilderswandtwo.events;

import cc.unilock.clientbuilderswandtwo.Constants;
import cc.unilock.clientbuilderswandtwo.config.ModConfig;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.InteractionEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;

@Environment(EnvType.CLIENT)
public class RightClickBlock {
    public static void init() {
        InteractionEvent.RIGHT_CLICK_BLOCK.register((player, hand, pos, face) -> {
            if (Constants.wandEnabled && player instanceof ClientPlayerEntity && !Constants.delay) {
                MutableText message = MutableText.of(new LiteralTextContent(face.getName()));
                message.setStyle(Style.EMPTY.withFormatting(Formatting.BOLD));

                ArrayList<Direction> directions = new ArrayList<>();

                for (Direction direction : Direction.values()) {
                    if (direction.getId() != face.getId()
                     && direction.getOpposite() != face
                     && !directions.contains(direction)
                     && !directions.contains(direction.getOpposite())) {
                        directions.add(direction);
                    }
                }

                Vec3d vec3dpos = new Vec3d(pos.getX(), pos.getY(), pos.getZ());

                BlockPos blockPos = pos;
                BlockState blockState = player.world.getBlockState(blockPos);
                BlockHitResult blockHitResult = new BlockHitResult(vec3dpos, face, blockPos, false);

                ActionResult interactionResult = blockState.onUse(
                        player.world,
                        player,
                        Hand.MAIN_HAND,
                        blockHitResult
                );

                Block block = blockState.getBlock();

                // TODO: rename this field to something that makes sense!!
                boolean flag = !(block instanceof BlockWithEntity)
                            && !(block instanceof DoorBlock)
                            && interactionResult == ActionResult.PASS;

                if (
                        blockState.getMaterial() != Material.REPLACEABLE_PLANT
                     && blockState.getMaterial() != Material.NETHER_SHOOTS
                ) {
                    blockPos = blockPos.add(face.getVector());
                }

                if (flag) {
                    int range = ModConfig.buildingRadius;

                    for (int lauf1 = -range; lauf1 <= range; ++lauf1) {
                        for (int lauf2 = -range; lauf2 <= range; ++lauf2) {
                            if (lauf1 != 0 || lauf2 != 0) {
                                flag = false;

                                BlockPos placePos = blockPos
                                        .add(directions.get(0).getVector().multiply(lauf1))
                                        .add(directions.get(1).getVector().multiply(lauf2));

                                BlockState placeBlock = player.world.getBlockState(placePos);

                                if (
                                        placeBlock.getMaterial() != Material.AIR
                                     && placeBlock.getMaterial() != Material.STRUCTURE_VOID
                                     && placeBlock.getMaterial() != Material.FIRE
                                     && placeBlock.getMaterial() != Material.SNOW_LAYER
                                ) {
                                    if (
                                            (
                                                    placeBlock.getMaterial() == Material.REPLACEABLE_PLANT
                                                 || placeBlock.getMaterial() == Material.NETHER_SHOOTS
                                            )
                                                    && ModConfig.ignorePlants
                                    ) {
                                        flag = true;
                                    } else if (
                                            (
                                                    placeBlock.getMaterial() == Material.WATER
                                                 || placeBlock.getMaterial() == Material.BUBBLE_COLUMN
                                                 || placeBlock.getMaterial() == Material.LAVA
                                            )
                                                    && ModConfig.ignoreFluid
                                    ) {
                                        flag = true;
                                    }
                                } else {
                                    flag = true;
                                }

                                BlockState compareBlock = player.world.getBlockState(placePos.add(face.getOpposite().getVector()));

                                if (compareBlock.getBlock() != block && !ModConfig.fuzzyMode) {
                                    flag = false;
                                }

                                if (compareBlock.getMaterial().isReplaceable() && !ModConfig.placeinAir) {
                                    flag = false;
                                }

                                if (flag && !player.getStackInHand(Hand.MAIN_HAND).isEmpty()) {
                                    vec3dpos = vec3dpos.subtract(Math.floor(vec3dpos.x), Math.floor(vec3dpos.y), Math.floor(vec3dpos.z));
                                    vec3dpos = new Vec3d(placePos.getX(), placePos.getY(), placePos.getZ()).add(vec3dpos);
                                    Constants.targetPos.add(new BlockHitResult(vec3dpos, face, placePos, false));
                                }
                            }
                        }
                    }
                }
            }

            return EventResult.pass();
        });
    }
}
