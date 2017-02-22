package appalachia.rtg.world.gen.feature.tree.rtg;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Cornus Florida (Dogwood)
 * <p>
 * This tree was designed by Lentebriesje and released as part of the 'Custom Tree Repository' project
 * on Planet Minecraft (http://www.planetminecraft.com/project/native-trees-of-europe-template-repository-1779952/).
 * It was converted into Java from its original schematic using the 'Schematic To Java Converter [For Modders]' program
 * by ThisIsMika (http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-tools/2193206-schematic-to-java-converter-for-modders).
 * It has been modified slightly by WhichOnesPink to allow for random variation when generating in the world.
 */
public class TreeCornusFlorida extends AppalachiaTree {

    World world;
    Random rand;
    boolean shortVersion = false;

    public TreeCornusFlorida() {
        super();
    }

    public TreeCornusFlorida(boolean shortVersion) {
        this();
        this.shortVersion = shortVersion;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {

        this.crownSize = this.getSizeFromMinMax(rand, this.minCrownSize, this.maxCrownSize);
        this.trunkSize = this.getSizeFromMinMax(rand, this.minTrunkSize, this.maxTrunkSize);

        this.world = world;
        this.rand = rand;
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        ArrayList<BlockPos> groundPos = new ArrayList<BlockPos>(){};

        if (shortVersion) {
            groundPos.add(new BlockPos(x+3, y, z+3));
        }
        else {
            groundPos.add(new BlockPos(x+5, y, z+5));
        }

        for (int i = 0; i < groundPos.size(); i++) {
            if (!isValidGroundBlock(world, rand, groundPos.get(i), 1)) {
                return false;
            }
        }

        IBlockState leaves = this.leavesBlock.withProperty(BlockLeaves.CHECK_DECAY, false);
        //IBlockState leaves = this.leavesBlock.withProperty(BlockLeaves.DECAYABLE, false);

        if (shortVersion) {
            this.spawnShort(world, x, y, z, this.logBlock, leaves);
        }
        else {
            this.spawn(world, x, y, z, this.logBlock, leaves);
        }

        return true;
    }

    protected void spawn(World world, int x, int y, int z, IBlockState log, IBlockState leaves) {

        int currentY = y;

        this.setBlockState(new BlockPos(x+5, y+0, z+5), log);
        this.setBlockState(new BlockPos(x+5, y+1, z+5), log);
        this.setBlockState(new BlockPos(x+5, y+2, z+5), log);
        this.setBlockState(new BlockPos(x+4, y+3, z+2), leaves);
        this.setBlockMetadataWithNotify(x+4, y+3, z+2, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+3, z+2), leaves);
        this.setBlockState(new BlockPos(x+6, y+3, z+2), leaves);
        this.setBlockMetadataWithNotify(x+6, y+3, z+2, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+3, z+3), leaves);
        this.setBlockState(new BlockPos(x+6, y+3, z+3), leaves);
        this.setBlockState(new BlockPos(x+7, y+3, z+3), leaves);
        this.setBlockMetadataWithNotify(x+7, y+3, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+2, y+3, z+4), leaves);
        this.setBlockMetadataWithNotify(x+2, y+3, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+3, z+4), leaves);
        this.setBlockState(new BlockPos(x+5, y+3, z+4), leaves);
        this.setBlockMetadataWithNotify(x+5, y+3, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+3, z+4), leaves);
        this.setBlockState(new BlockPos(x+7, y+3, z+4), leaves);
        this.setBlockMetadataWithNotify(x+7, y+3, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+2, y+3, z+5), leaves);
        this.setBlockMetadataWithNotify(x+2, y+3, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+3, z+5), leaves);
        this.setBlockMetadataWithNotify(x+3, y+3, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+3, z+5), leaves);
        this.setBlockState(new BlockPos(x+5, y+3, z+5), log);
        this.setBlockState(new BlockPos(x+7, y+3, z+5), leaves);
        this.setBlockState(new BlockPos(x+8, y+3, z+5), leaves);
        this.setBlockMetadataWithNotify(x+8, y+3, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+3, z+6), leaves);
        this.setBlockState(new BlockPos(x+5, y+3, z+6), leaves);
        this.setBlockMetadataWithNotify(x+5, y+3, z+6, 12, 12);
        this.setBlockState(new BlockPos(x+6, y+3, z+6), leaves);
        this.setBlockMetadataWithNotify(x+6, y+3, z+6, 4, 4);
        this.setBlockState(new BlockPos(x+7, y+3, z+6), leaves);
        this.setBlockState(new BlockPos(x+3, y+3, z+7), leaves);
        this.setBlockMetadataWithNotify(x+3, y+3, z+7, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+3, z+7), leaves);
        this.setBlockState(new BlockPos(x+5, y+3, z+7), leaves);
        this.setBlockState(new BlockPos(x+7, y+3, z+7), leaves);
        this.setBlockMetadataWithNotify(x+7, y+3, z+7, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+3, z+8), leaves);
        this.setBlockMetadataWithNotify(x+4, y+3, z+8, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+3, z+8), leaves);
        this.setBlockMetadataWithNotify(x+5, y+3, z+8, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+4, z+0), leaves);
        this.setBlockMetadataWithNotify(x+4, y+4, z+0, 4, 4);
        this.setBlockState(new BlockPos(x+2, y+4, z+1), leaves);
        this.setBlockMetadataWithNotify(x+2, y+4, z+1, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+4, z+1), leaves);
        this.setBlockState(new BlockPos(x+5, y+4, z+1), leaves);
        this.setBlockMetadataWithNotify(x+5, y+4, z+1, 12, 12);
        this.setBlockState(new BlockPos(x+6, y+4, z+1), leaves);
        this.setBlockMetadataWithNotify(x+6, y+4, z+1, 12, 12);
        this.setBlockState(new BlockPos(x+7, y+4, z+1), leaves);
        this.setBlockMetadataWithNotify(x+7, y+4, z+1, 12, 12);
        this.setBlockState(new BlockPos(x+8, y+4, z+1), leaves);
        this.setBlockMetadataWithNotify(x+8, y+4, z+1, 12, 12);
        this.setBlockState(new BlockPos(x+2, y+4, z+2), leaves);
        this.setBlockMetadataWithNotify(x+2, y+4, z+2, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+4, z+2), leaves);
        this.setBlockMetadataWithNotify(x+6, y+4, z+2, 12, 12);
        this.setBlockState(new BlockPos(x+2, y+4, z+3), leaves);
        this.setBlockState(new BlockPos(x+3, y+4, z+3), leaves);
        this.setBlockMetadataWithNotify(x+3, y+4, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+4, z+3), leaves);
        this.setBlockState(new BlockPos(x+5, y+4, z+3), leaves);
        this.setBlockMetadataWithNotify(x+5, y+4, z+3, 12, 12);
        this.setBlockState(new BlockPos(x+6, y+4, z+3), leaves);
        this.setBlockMetadataWithNotify(x+6, y+4, z+3, 12, 12);
        this.setBlockState(new BlockPos(x+7, y+4, z+3), leaves);
        this.setBlockState(new BlockPos(x+8, y+4, z+3), leaves);
        this.setBlockState(new BlockPos(x+1, y+4, z+4), leaves);
        this.setBlockState(new BlockPos(x+2, y+4, z+4), leaves);
        this.setBlockMetadataWithNotify(x+2, y+4, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+4, z+4), leaves);
        this.setBlockState(new BlockPos(x+5, y+4, z+4), leaves);
        this.setBlockState(new BlockPos(x+6, y+4, z+4), leaves);
        this.setBlockState(new BlockPos(x+0, y+4, z+5), leaves);
        this.setBlockMetadataWithNotify(x+0, y+4, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+1, y+4, z+5), leaves);
        this.setBlockMetadataWithNotify(x+1, y+4, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+2, y+4, z+5), leaves);
        this.setBlockState(new BlockPos(x+3, y+4, z+5), leaves);
        this.setBlockState(new BlockPos(x+4, y+4, z+5), leaves);
        this.setBlockMetadataWithNotify(x+4, y+4, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+4, z+5), log);
        this.setBlockState(new BlockPos(x+6, y+4, z+5), leaves);
        this.setBlockMetadataWithNotify(x+6, y+4, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+7, y+4, z+5), leaves);
        this.setBlockState(new BlockPos(x+8, y+4, z+5), leaves);
        this.setBlockMetadataWithNotify(x+8, y+4, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+9, y+4, z+5), leaves);
        this.setBlockState(new BlockPos(x+10, y+4, z+5), leaves);
        this.setBlockMetadataWithNotify(x+10, y+4, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+1, y+4, z+6), leaves);
        this.setBlockMetadataWithNotify(x+1, y+4, z+6, 12, 12);
        this.setBlockState(new BlockPos(x+4, y+4, z+6), leaves);
        this.setBlockMetadataWithNotify(x+4, y+4, z+6, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+4, z+6), leaves);
        this.setBlockState(new BlockPos(x+8, y+4, z+6), leaves);
        this.setBlockState(new BlockPos(x+10, y+4, z+6), leaves);
        this.setBlockMetadataWithNotify(x+10, y+4, z+6, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+4, z+7), leaves);
        this.setBlockState(new BlockPos(x+5, y+4, z+7), leaves);
        this.setBlockMetadataWithNotify(x+5, y+4, z+7, 12, 12);
        this.setBlockState(new BlockPos(x+6, y+4, z+7), leaves);
        this.setBlockState(new BlockPos(x+7, y+4, z+7), leaves);
        this.setBlockState(new BlockPos(x+4, y+4, z+8), leaves);
        this.setBlockMetadataWithNotify(x+4, y+4, z+8, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+4, z+8), leaves);
        this.setBlockState(new BlockPos(x+9, y+4, z+8), leaves);
        this.setBlockMetadataWithNotify(x+9, y+4, z+8, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+4, z+9), leaves);
        this.setBlockState(new BlockPos(x+5, y+4, z+9), leaves);
        this.setBlockState(new BlockPos(x+6, y+4, z+9), leaves);
        this.setBlockMetadataWithNotify(x+6, y+4, z+9, 4, 4);
        this.setBlockState(new BlockPos(x+7, y+4, z+9), leaves);
        this.setBlockMetadataWithNotify(x+7, y+4, z+9, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+4, z+10), leaves);
        this.setBlockMetadataWithNotify(x+5, y+4, z+10, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+4, z+10), leaves);
        this.setBlockMetadataWithNotify(x+6, y+4, z+10, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+5, z+0), leaves);
        this.setBlockMetadataWithNotify(x+4, y+5, z+0, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+5, z+0), leaves);
        this.setBlockMetadataWithNotify(x+5, y+5, z+0, 4, 4);
        this.setBlockState(new BlockPos(x+7, y+5, z+0), leaves);
        this.setBlockMetadataWithNotify(x+7, y+5, z+0, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+5, z+1), leaves);
        this.setBlockMetadataWithNotify(x+3, y+5, z+1, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+5, z+1), leaves);
        this.setBlockMetadataWithNotify(x+4, y+5, z+1, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+5, z+1), leaves);
        this.setBlockMetadataWithNotify(x+6, y+5, z+1, 4, 4);
        this.setBlockState(new BlockPos(x+7, y+5, z+1), leaves);
        this.setBlockState(new BlockPos(x+1, y+5, z+2), leaves);
        this.setBlockMetadataWithNotify(x+1, y+5, z+2, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+5, z+2), leaves);
        this.setBlockState(new BlockPos(x+4, y+5, z+2), leaves);
        this.setBlockMetadataWithNotify(x+4, y+5, z+2, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+5, z+2), leaves);
        this.setBlockState(new BlockPos(x+7, y+5, z+2), leaves);
        this.setBlockState(new BlockPos(x+8, y+5, z+2), leaves);
        this.setBlockState(new BlockPos(x+0, y+5, z+3), leaves);
        this.setBlockMetadataWithNotify(x+0, y+5, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+5, z+3), leaves);
        this.setBlockMetadataWithNotify(x+3, y+5, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+5, z+3), leaves);
        this.setBlockMetadataWithNotify(x+5, y+5, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+7, y+5, z+3), leaves);
        this.setBlockMetadataWithNotify(x+7, y+5, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+8, y+5, z+3), leaves);
        this.setBlockState(new BlockPos(x+2, y+5, z+4), leaves);
        this.setBlockState(new BlockPos(x+4, y+5, z+4), leaves);
        this.setBlockState(new BlockPos(x+5, y+5, z+4), leaves);
        this.setBlockState(new BlockPos(x+7, y+5, z+4), leaves);
        this.setBlockMetadataWithNotify(x+7, y+5, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+8, y+5, z+4), leaves);
        this.setBlockMetadataWithNotify(x+8, y+5, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+10, y+5, z+4), leaves);
        this.setBlockMetadataWithNotify(x+10, y+5, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+0, y+5, z+5), leaves);
        this.setBlockMetadataWithNotify(x+0, y+5, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+1, y+5, z+5), leaves);
        this.setBlockState(new BlockPos(x+2, y+5, z+5), leaves);
        this.setBlockMetadataWithNotify(x+2, y+5, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+5, z+5), leaves);
        this.setBlockState(new BlockPos(x+4, y+5, z+5), leaves);
        this.setBlockState(new BlockPos(x+5, y+5, z+5), log);
        this.setBlockState(new BlockPos(x+6, y+5, z+5), leaves);
        this.setBlockMetadataWithNotify(x+6, y+5, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+7, y+5, z+5), leaves);
        this.setBlockState(new BlockPos(x+8, y+5, z+5), leaves);
        this.setBlockState(new BlockPos(x+9, y+5, z+5), leaves);
        this.setBlockState(new BlockPos(x+10, y+5, z+5), leaves);
        this.setBlockMetadataWithNotify(x+10, y+5, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+2, y+5, z+6), leaves);
        this.setBlockState(new BlockPos(x+4, y+5, z+6), leaves);
        this.setBlockMetadataWithNotify(x+4, y+5, z+6, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+5, z+6), leaves);
        this.setBlockMetadataWithNotify(x+5, y+5, z+6, 4, 4);
        this.setBlockState(new BlockPos(x+7, y+5, z+6), leaves);
        this.setBlockState(new BlockPos(x+9, y+5, z+6), leaves);
        this.setBlockState(new BlockPos(x+2, y+5, z+7), leaves);
        this.setBlockState(new BlockPos(x+3, y+5, z+7), leaves);
        this.setBlockState(new BlockPos(x+4, y+5, z+7), leaves);
        this.setBlockState(new BlockPos(x+5, y+5, z+7), leaves);
        this.setBlockState(new BlockPos(x+9, y+5, z+7), leaves);
        this.setBlockMetadataWithNotify(x+9, y+5, z+7, 4, 4);
        this.setBlockState(new BlockPos(x+1, y+5, z+8), leaves);
        this.setBlockMetadataWithNotify(x+1, y+5, z+8, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+5, z+8), leaves);
        this.setBlockMetadataWithNotify(x+5, y+5, z+8, 4, 4);
        this.setBlockState(new BlockPos(x+7, y+5, z+8), leaves);
        this.setBlockState(new BlockPos(x+8, y+5, z+8), leaves);
        this.setBlockMetadataWithNotify(x+8, y+5, z+8, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+5, z+9), leaves);
        this.setBlockMetadataWithNotify(x+5, y+5, z+9, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+5, z+9), leaves);
        this.setBlockState(new BlockPos(x+7, y+5, z+9), leaves);
        this.setBlockState(new BlockPos(x+8, y+5, z+9), leaves);
        this.setBlockMetadataWithNotify(x+8, y+5, z+9, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+5, z+10), leaves);
        this.setBlockMetadataWithNotify(x+6, y+5, z+10, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+6, z+0), leaves);
        this.setBlockMetadataWithNotify(x+3, y+6, z+0, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+6, z+0), leaves);
        this.setBlockMetadataWithNotify(x+5, y+6, z+0, 4, 4);
        this.setBlockState(new BlockPos(x+2, y+6, z+1), leaves);
        this.setBlockMetadataWithNotify(x+2, y+6, z+1, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+6, z+1), leaves);
        this.setBlockMetadataWithNotify(x+5, y+6, z+1, 4, 4);
        this.setBlockState(new BlockPos(x+7, y+6, z+1), leaves);
        this.setBlockMetadataWithNotify(x+7, y+6, z+1, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+6, z+2), leaves);
        this.setBlockMetadataWithNotify(x+3, y+6, z+2, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+6, z+2), leaves);
        this.setBlockMetadataWithNotify(x+4, y+6, z+2, 4, 4);
        this.setBlockState(new BlockPos(x+7, y+6, z+2), leaves);
        this.setBlockMetadataWithNotify(x+7, y+6, z+2, 4, 4);
        this.setBlockState(new BlockPos(x+9, y+6, z+2), leaves);
        this.setBlockMetadataWithNotify(x+9, y+6, z+2, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+6, z+3), leaves);
        this.setBlockMetadataWithNotify(x+3, y+6, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+6, z+3), leaves);
        this.setBlockMetadataWithNotify(x+5, y+6, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+9, y+6, z+3), leaves);
        this.setBlockMetadataWithNotify(x+9, y+6, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+10, y+6, z+3), leaves);
        this.setBlockMetadataWithNotify(x+10, y+6, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+0, y+6, z+4), leaves);
        this.setBlockMetadataWithNotify(x+0, y+6, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+1, y+6, z+4), leaves);
        this.setBlockMetadataWithNotify(x+1, y+6, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+6, z+4), leaves);
        this.setBlockMetadataWithNotify(x+5, y+6, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+6, z+4), leaves);
        this.setBlockMetadataWithNotify(x+6, y+6, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+0, y+6, z+5), leaves);
        this.setBlockMetadataWithNotify(x+0, y+6, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+1, y+6, z+5), leaves);
        this.setBlockMetadataWithNotify(x+1, y+6, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+6, z+5), leaves);
        this.setBlockMetadataWithNotify(x+3, y+6, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+6, z+5), log);
        this.setBlockState(new BlockPos(x+6, y+6, z+5), leaves);
        this.setBlockMetadataWithNotify(x+6, y+6, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+7, y+6, z+5), leaves);
        this.setBlockMetadataWithNotify(x+7, y+6, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+9, y+6, z+5), leaves);
        this.setBlockMetadataWithNotify(x+9, y+6, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+10, y+6, z+5), leaves);
        this.setBlockMetadataWithNotify(x+10, y+6, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+6, z+6), leaves);
        this.setBlockMetadataWithNotify(x+5, y+6, z+6, 4, 4);
        this.setBlockState(new BlockPos(x+10, y+6, z+6), leaves);
        this.setBlockMetadataWithNotify(x+10, y+6, z+6, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+6, z+7), leaves);
        this.setBlockMetadataWithNotify(x+5, y+6, z+7, 4, 4);
        this.setBlockState(new BlockPos(x+7, y+6, z+7), leaves);
        this.setBlockMetadataWithNotify(x+7, y+6, z+7, 4, 4);
        this.setBlockState(new BlockPos(x+1, y+6, z+8), leaves);
        this.setBlockMetadataWithNotify(x+1, y+6, z+8, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+6, z+8), leaves);
        this.setBlockMetadataWithNotify(x+3, y+6, z+8, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+6, z+8), leaves);
        this.setBlockMetadataWithNotify(x+5, y+6, z+8, 4, 4);
        this.setBlockState(new BlockPos(x+9, y+6, z+8), leaves);
        this.setBlockMetadataWithNotify(x+9, y+6, z+8, 4, 4);
        this.setBlockState(new BlockPos(x+2, y+6, z+9), leaves);
        this.setBlockMetadataWithNotify(x+2, y+6, z+9, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+6, z+9), leaves);
        this.setBlockMetadataWithNotify(x+3, y+6, z+9, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+6, z+9), leaves);
        this.setBlockMetadataWithNotify(x+5, y+6, z+9, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+6, z+9), leaves);
        this.setBlockMetadataWithNotify(x+6, y+6, z+9, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+6, z+10), leaves);
        this.setBlockMetadataWithNotify(x+3, y+6, z+10, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+6, z+10), leaves);
        this.setBlockMetadataWithNotify(x+5, y+6, z+10, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+6, z+10), leaves);
        this.setBlockMetadataWithNotify(x+6, y+6, z+10, 4, 4);
        this.setBlockState(new BlockPos(x+7, y+6, z+10), leaves);
        this.setBlockMetadataWithNotify(x+7, y+6, z+10, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+7, z+0), leaves);
        this.setBlockMetadataWithNotify(x+3, y+7, z+0, 12, 12);
        this.setBlockState(new BlockPos(x+6, y+7, z+0), leaves);
        this.setBlockMetadataWithNotify(x+6, y+7, z+0, 12, 12);
        this.setBlockState(new BlockPos(x+7, y+7, z+0), leaves);
        this.setBlockMetadataWithNotify(x+7, y+7, z+0, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+7, z+1), leaves);
        this.setBlockMetadataWithNotify(x+5, y+7, z+1, 12, 12);
        this.setBlockState(new BlockPos(x+4, y+7, z+2), leaves);
        this.setBlockMetadataWithNotify(x+4, y+7, z+2, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+7, z+2), leaves);
        this.setBlockMetadataWithNotify(x+5, y+7, z+2, 12, 12);
        this.setBlockState(new BlockPos(x+6, y+7, z+2), leaves);
        this.setBlockMetadataWithNotify(x+6, y+7, z+2, 12, 12);
        this.setBlockState(new BlockPos(x+1, y+7, z+3), leaves);
        this.setBlockMetadataWithNotify(x+1, y+7, z+3, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+7, z+3), leaves);
        this.setBlockMetadataWithNotify(x+5, y+7, z+3, 12, 12);
        this.setBlockState(new BlockPos(x+7, y+7, z+3), leaves);
        this.setBlockMetadataWithNotify(x+7, y+7, z+3, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+7, z+4), leaves);
        this.setBlockMetadataWithNotify(x+3, y+7, z+4, 12, 12);
        this.setBlockState(new BlockPos(x+4, y+7, z+4), leaves);
        this.setBlockMetadataWithNotify(x+4, y+7, z+4, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+7, z+4), leaves);
        this.setBlockMetadataWithNotify(x+5, y+7, z+4, 12, 12);
        this.setBlockState(new BlockPos(x+7, y+7, z+4), leaves);
        this.setBlockMetadataWithNotify(x+7, y+7, z+4, 12, 12);
        this.setBlockState(new BlockPos(x+2, y+7, z+5), leaves);
        this.setBlockMetadataWithNotify(x+2, y+7, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+7, z+5), leaves);
        this.setBlockMetadataWithNotify(x+3, y+7, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+4, y+7, z+5), leaves);
        this.setBlockMetadataWithNotify(x+4, y+7, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+7, z+5), log);
        this.setBlockState(new BlockPos(x+8, y+7, z+5), leaves);
        this.setBlockMetadataWithNotify(x+8, y+7, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+9, y+7, z+5), leaves);
        this.setBlockMetadataWithNotify(x+9, y+7, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+2, y+7, z+6), leaves);
        this.setBlockMetadataWithNotify(x+2, y+7, z+6, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+7, z+6), leaves);
        this.setBlockMetadataWithNotify(x+5, y+7, z+6, 12, 12);
        this.setBlockState(new BlockPos(x+8, y+7, z+6), leaves);
        this.setBlockMetadataWithNotify(x+8, y+7, z+6, 12, 12);
        this.setBlockState(new BlockPos(x+6, y+7, z+7), leaves);
        this.setBlockMetadataWithNotify(x+6, y+7, z+7, 12, 12);
        this.setBlockState(new BlockPos(x+7, y+7, z+7), leaves);
        this.setBlockMetadataWithNotify(x+7, y+7, z+7, 12, 12);
        this.setBlockState(new BlockPos(x+9, y+7, z+7), leaves);
        this.setBlockMetadataWithNotify(x+9, y+7, z+7, 12, 12);
        this.setBlockState(new BlockPos(x+1, y+7, z+8), leaves);
        this.setBlockMetadataWithNotify(x+1, y+7, z+8, 12, 12);
        this.setBlockState(new BlockPos(x+2, y+7, z+8), leaves);
        this.setBlockMetadataWithNotify(x+2, y+7, z+8, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+7, z+8), leaves);
        this.setBlockMetadataWithNotify(x+3, y+7, z+8, 12, 12);
        this.setBlockState(new BlockPos(x+4, y+7, z+8), leaves);
        this.setBlockMetadataWithNotify(x+4, y+7, z+8, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+7, z+8), leaves);
        this.setBlockMetadataWithNotify(x+5, y+7, z+8, 12, 12);
        this.setBlockState(new BlockPos(x+6, y+7, z+8), leaves);
        this.setBlockMetadataWithNotify(x+6, y+7, z+8, 12, 12);
        this.setBlockState(new BlockPos(x+7, y+7, z+8), leaves);
        this.setBlockMetadataWithNotify(x+7, y+7, z+8, 12, 12);
        this.setBlockState(new BlockPos(x+8, y+7, z+8), leaves);
        this.setBlockMetadataWithNotify(x+8, y+7, z+8, 12, 12);
        this.setBlockState(new BlockPos(x+4, y+7, z+9), leaves);
        this.setBlockMetadataWithNotify(x+4, y+7, z+9, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+7, z+9), leaves);
        this.setBlockMetadataWithNotify(x+5, y+7, z+9, 12, 12);
        this.setBlockState(new BlockPos(x+7, y+7, z+10), leaves);
        this.setBlockMetadataWithNotify(x+7, y+7, z+10, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+8, z+1), leaves);
        this.setBlockMetadataWithNotify(x+3, y+8, z+1, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+8, z+1), leaves);
        this.setBlockMetadataWithNotify(x+4, y+8, z+1, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+8, z+1), leaves);
        this.setBlockMetadataWithNotify(x+6, y+8, z+1, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+8, z+3), leaves);
        this.setBlockMetadataWithNotify(x+3, y+8, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+8, z+3), leaves);
        this.setBlockMetadataWithNotify(x+4, y+8, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+9, y+8, z+3), leaves);
        this.setBlockMetadataWithNotify(x+9, y+8, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+8, z+4), leaves);
        this.setBlockMetadataWithNotify(x+3, y+8, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+8, z+4), leaves);
        this.setBlockMetadataWithNotify(x+5, y+8, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+9, y+8, z+4), leaves);
        this.setBlockMetadataWithNotify(x+9, y+8, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+1, y+8, z+5), leaves);
        this.setBlockMetadataWithNotify(x+1, y+8, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+2, y+8, z+5), leaves);
        this.setBlockMetadataWithNotify(x+2, y+8, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+8, z+5), leaves);
        this.setBlockMetadataWithNotify(x+3, y+8, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+8, z+5), log);
        this.setBlockState(new BlockPos(x+8, y+8, z+5), leaves);
        this.setBlockMetadataWithNotify(x+8, y+8, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+9, y+8, z+5), leaves);
        this.setBlockMetadataWithNotify(x+9, y+8, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+8, z+6), leaves);
        this.setBlockMetadataWithNotify(x+6, y+8, z+6, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+8, z+7), leaves);
        this.setBlockMetadataWithNotify(x+3, y+8, z+7, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+8, z+7), leaves);
        this.setBlockMetadataWithNotify(x+5, y+8, z+7, 4, 4);
        this.setBlockState(new BlockPos(x+7, y+8, z+7), leaves);
        this.setBlockMetadataWithNotify(x+7, y+8, z+7, 4, 4);
        this.setBlockState(new BlockPos(x+8, y+8, z+7), leaves);
        this.setBlockMetadataWithNotify(x+8, y+8, z+7, 4, 4);
        this.setBlockState(new BlockPos(x+2, y+8, z+8), leaves);
        this.setBlockMetadataWithNotify(x+2, y+8, z+8, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+8, z+8), leaves);
        this.setBlockMetadataWithNotify(x+4, y+8, z+8, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+8, z+8), leaves);
        this.setBlockMetadataWithNotify(x+6, y+8, z+8, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+8, z+9), leaves);
        this.setBlockMetadataWithNotify(x+3, y+8, z+9, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+8, z+9), leaves);
        this.setBlockMetadataWithNotify(x+5, y+8, z+9, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+9, z+2), leaves);
        this.setBlockMetadataWithNotify(x+5, y+9, z+2, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+9, z+2), leaves);
        this.setBlockMetadataWithNotify(x+6, y+9, z+2, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+9, z+3), leaves);
        this.setBlockMetadataWithNotify(x+4, y+9, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+9, z+3), leaves);
        this.setBlockMetadataWithNotify(x+5, y+9, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+9, z+3), leaves);
        this.setBlockMetadataWithNotify(x+6, y+9, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+7, y+9, z+3), leaves);
        this.setBlockMetadataWithNotify(x+7, y+9, z+3, 4, 4);
        this.setBlockState(new BlockPos(x+2, y+9, z+4), leaves);
        this.setBlockMetadataWithNotify(x+2, y+9, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+9, z+4), leaves);
        this.setBlockMetadataWithNotify(x+4, y+9, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+9, z+4), leaves);
        this.setBlockMetadataWithNotify(x+5, y+9, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+8, y+9, z+4), leaves);
        this.setBlockMetadataWithNotify(x+8, y+9, z+4, 4, 4);
        this.setBlockState(new BlockPos(x+3, y+9, z+5), leaves);
        this.setBlockMetadataWithNotify(x+3, y+9, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+9, z+5), leaves);
        this.setBlockMetadataWithNotify(x+4, y+9, z+5, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+9, z+5), log);
        this.setBlockState(new BlockPos(x+3, y+9, z+6), leaves);
        this.setBlockMetadataWithNotify(x+3, y+9, z+6, 4, 4);
        this.setBlockState(new BlockPos(x+5, y+9, z+6), leaves);
        this.setBlockMetadataWithNotify(x+5, y+9, z+6, 4, 4);
        this.setBlockState(new BlockPos(x+4, y+9, z+7), leaves);
        this.setBlockMetadataWithNotify(x+4, y+9, z+7, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+9, z+7), leaves);
        this.setBlockMetadataWithNotify(x+6, y+9, z+7, 4, 4);
        this.setBlockState(new BlockPos(x+6, y+9, z+8), leaves);
        this.setBlockMetadataWithNotify(x+6, y+9, z+8, 4, 4);
        currentY++;
    }

    protected void spawnShort(World world, int x, int y, int z, IBlockState log, IBlockState leaves) {

        int currentY = y;

        this.setBlockState(new BlockPos(x+3, y+0, z+3), log);
        this.setBlockState(new BlockPos(x+3, y+1, z+3), log);
        this.setBlockState(new BlockPos(x+1, y+2, z+1), leaves);
        this.setBlockMetadataWithNotify(x+1, y+2, z+1, 12, 12);
        this.setBlockState(new BlockPos(x+2, y+2, z+1), leaves);
        this.setBlockState(new BlockPos(x+3, y+2, z+1), leaves);
        this.setBlockMetadataWithNotify(x+3, y+2, z+1, 12, 12);
        this.setBlockState(new BlockPos(x+4, y+2, z+1), leaves);
        this.setBlockMetadataWithNotify(x+4, y+2, z+1, 12, 12);
        this.setBlockState(new BlockPos(x+0, y+2, z+2), leaves);
        this.setBlockMetadataWithNotify(x+0, y+2, z+2, 12, 12);
        this.setBlockState(new BlockPos(x+1, y+2, z+2), leaves);
        this.setBlockState(new BlockPos(x+2, y+2, z+2), leaves);
        this.setBlockMetadataWithNotify(x+2, y+2, z+2, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+2, z+2), leaves);
        this.setBlockState(new BlockPos(x+4, y+2, z+2), leaves);
        this.setBlockState(new BlockPos(x+1, y+2, z+3), leaves);
        this.setBlockState(new BlockPos(x+2, y+2, z+3), leaves);
        this.setBlockMetadataWithNotify(x+2, y+2, z+3, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+2, z+3), log);
        this.setBlockState(new BlockPos(x+4, y+2, z+3), leaves);
        this.setBlockState(new BlockPos(x+5, y+2, z+3), leaves);
        this.setBlockMetadataWithNotify(x+5, y+2, z+3, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+2, z+4), leaves);
        this.setBlockMetadataWithNotify(x+3, y+2, z+4, 12, 12);
        this.setBlockState(new BlockPos(x+4, y+2, z+4), leaves);
        this.setBlockState(new BlockPos(x+5, y+2, z+4), leaves);
        this.setBlockState(new BlockPos(x+1, y+2, z+5), leaves);
        this.setBlockMetadataWithNotify(x+1, y+2, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+2, y+2, z+5), leaves);
        this.setBlockMetadataWithNotify(x+2, y+2, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+2, z+5), leaves);
        this.setBlockState(new BlockPos(x+4, y+2, z+5), leaves);
        this.setBlockMetadataWithNotify(x+4, y+2, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+2, z+5), leaves);
        this.setBlockMetadataWithNotify(x+5, y+2, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+1, y+2, z+6), leaves);
        this.setBlockMetadataWithNotify(x+1, y+2, z+6, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+2, z+6), leaves);
        this.setBlockMetadataWithNotify(x+3, y+2, z+6, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+2, z+6), leaves);
        this.setBlockMetadataWithNotify(x+5, y+2, z+6, 12, 12);
        this.setBlockState(new BlockPos(x+2, y+3, z+0), leaves);
        this.setBlockMetadataWithNotify(x+2, y+3, z+0, 12, 12);
        this.setBlockState(new BlockPos(x+2, y+3, z+1), leaves);
        this.setBlockMetadataWithNotify(x+2, y+3, z+1, 12, 12);
        this.setBlockState(new BlockPos(x+4, y+3, z+1), leaves);
        this.setBlockMetadataWithNotify(x+4, y+3, z+1, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+3, z+1), leaves);
        this.setBlockMetadataWithNotify(x+5, y+3, z+1, 12, 12);
        this.setBlockState(new BlockPos(x+2, y+3, z+2), leaves);
        this.setBlockMetadataWithNotify(x+2, y+3, z+2, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+3, z+2), leaves);
        this.setBlockMetadataWithNotify(x+3, y+3, z+2, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+3, z+2), leaves);
        this.setBlockMetadataWithNotify(x+5, y+3, z+2, 12, 12);
        this.setBlockState(new BlockPos(x+1, y+3, z+3), leaves);
        this.setBlockMetadataWithNotify(x+1, y+3, z+3, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+3, z+3), log);
        this.setBlockState(new BlockPos(x+4, y+3, z+3), leaves);
        this.setBlockMetadataWithNotify(x+4, y+3, z+3, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+3, z+3), leaves);
        this.setBlockMetadataWithNotify(x+5, y+3, z+3, 12, 12);
        this.setBlockState(new BlockPos(x+6, y+3, z+3), leaves);
        this.setBlockMetadataWithNotify(x+6, y+3, z+3, 12, 12);
        this.setBlockState(new BlockPos(x+0, y+3, z+4), leaves);
        this.setBlockMetadataWithNotify(x+0, y+3, z+4, 12, 12);
        this.setBlockState(new BlockPos(x+2, y+3, z+4), leaves);
        this.setBlockMetadataWithNotify(x+2, y+3, z+4, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+3, z+4), leaves);
        this.setBlockMetadataWithNotify(x+3, y+3, z+4, 12, 12);
        this.setBlockState(new BlockPos(x+4, y+3, z+4), leaves);
        this.setBlockMetadataWithNotify(x+4, y+3, z+4, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+3, z+4), leaves);
        this.setBlockMetadataWithNotify(x+5, y+3, z+4, 12, 12);
        this.setBlockState(new BlockPos(x+1, y+3, z+5), leaves);
        this.setBlockMetadataWithNotify(x+1, y+3, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+2, y+3, z+5), leaves);
        this.setBlockMetadataWithNotify(x+2, y+3, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+3, z+5), leaves);
        this.setBlockMetadataWithNotify(x+3, y+3, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+2, y+3, z+6), leaves);
        this.setBlockMetadataWithNotify(x+2, y+3, z+6, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+3, z+6), leaves);
        this.setBlockMetadataWithNotify(x+3, y+3, z+6, 12, 12);
        this.setBlockState(new BlockPos(x+4, y+3, z+6), leaves);
        this.setBlockMetadataWithNotify(x+4, y+3, z+6, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+4, z+1), leaves);
        this.setBlockMetadataWithNotify(x+3, y+4, z+1, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+4, z+2), leaves);
        this.setBlockMetadataWithNotify(x+5, y+4, z+2, 12, 12);
        this.setBlockState(new BlockPos(x+1, y+4, z+3), leaves);
        this.setBlockMetadataWithNotify(x+1, y+4, z+3, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+4, z+3), leaves);
        this.setBlockMetadataWithNotify(x+3, y+4, z+3, 12, 12);
        this.setBlockState(new BlockPos(x+4, y+4, z+3), leaves);
        this.setBlockMetadataWithNotify(x+4, y+4, z+3, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+4, z+3), leaves);
        this.setBlockMetadataWithNotify(x+5, y+4, z+3, 12, 12);
        this.setBlockState(new BlockPos(x+1, y+4, z+4), leaves);
        this.setBlockMetadataWithNotify(x+1, y+4, z+4, 12, 12);
        this.setBlockState(new BlockPos(x+2, y+4, z+4), leaves);
        this.setBlockMetadataWithNotify(x+2, y+4, z+4, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+4, z+4), leaves);
        this.setBlockMetadataWithNotify(x+3, y+4, z+4, 12, 12);
        this.setBlockState(new BlockPos(x+5, y+4, z+4), leaves);
        this.setBlockMetadataWithNotify(x+5, y+4, z+4, 12, 12);
        this.setBlockState(new BlockPos(x+2, y+4, z+5), leaves);
        this.setBlockMetadataWithNotify(x+2, y+4, z+5, 12, 12);
        this.setBlockState(new BlockPos(x+3, y+4, z+5), leaves);
        this.setBlockMetadataWithNotify(x+3, y+4, z+5, 12, 12);
        currentY++;
    }

    protected void setBlockState(BlockPos pos, IBlockState state) {

        this.setBlockAndNotifyAdequately(this.world, pos, state);
    }

    private void setBlockMetadataWithNotify(int x, int y, int z, int meta1, int meta2) {

    }
}