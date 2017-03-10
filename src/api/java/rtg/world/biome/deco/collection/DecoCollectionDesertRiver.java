package rtg.world.biome.deco.collection;

import net.minecraft.init.Blocks;

import rtg.world.biome.deco.*;
import rtg.world.biome.deco.DecoTree.TreeCondition;
import rtg.world.biome.deco.DecoTree.TreeType;
import rtg.world.biome.deco.helper.DecoHelperThisOrThat;
import rtg.world.biome.deco.helper.DecoHelperThisOrThat.ChanceType;
import rtg.world.gen.feature.tree.rtg.TreeRTG;
import rtg.world.gen.feature.tree.rtg.TreeRTGAcaciaBucheri;


/**
 * @author WhichOnesPink
 */
public class DecoCollectionDesertRiver extends DecoCollectionBase {

    public DecoCollectionDesertRiver() {

        super();

        TreeRTG acaciaTree = new TreeRTGAcaciaBucheri();
        acaciaTree.setLogBlock(Blocks.LOG2.getDefaultState());
        acaciaTree.setLeavesBlock(Blocks.LEAVES2.getDefaultState());
        acaciaTree.setMinTrunkSize(12);
        acaciaTree.setMaxTrunkSize(16);
        this.addTree(acaciaTree);

        DecoTree acaciaTrees = new DecoTree(acaciaTree);
        acaciaTrees.setCheckRiver(true);
        acaciaTrees.setMinRiver(0.86f);
        acaciaTrees.setLoops(1);
        acaciaTrees.setTreeType(TreeType.RTG_TREE);
        acaciaTrees.setTreeCondition(TreeCondition.ALWAYS_GENERATE);
        acaciaTrees.setMaxY(65);
        this.addDeco(acaciaTrees);

        DecoShrub acaciaShrub = new DecoShrub();
        acaciaShrub.setCheckRiver(true);
        acaciaShrub.setMinRiver(0.86f);
        acaciaShrub.setLogBlock(Blocks.LOG2.getDefaultState());
        acaciaShrub.setLeavesBlock(Blocks.LEAVES2.getDefaultState());
        acaciaShrub.setMaxY(65);
        acaciaShrub.setLoops(1);
        acaciaShrub.setChance(1);
        this.addDeco(acaciaShrub);

        DecoHelperThisOrThat decoHelperThisOrThat = new DecoHelperThisOrThat(4, ChanceType.NOT_EQUALS_ZERO, acaciaShrub, acaciaTrees);
        this.addDeco(decoHelperThisOrThat);

        DecoCactus decoRiverCactus = new DecoCactus();
        decoRiverCactus.setCheckRiver(true);
        decoRiverCactus.setMinRiver(0.7f);
        decoRiverCactus.setMaxY(80);
        decoRiverCactus.setStrengthFactor(12f);
        this.addDeco(decoRiverCactus);

        DecoReed decoReed = new DecoReed();
        decoReed.setCheckRiver(true);
        decoReed.setMinRiver(0.7f);
        decoReed.setMaxY(68);
        decoReed.setLoops(3);
        this.addDeco(decoReed);

        DecoGrassDoubleTallgrass decoGrassDoubleTallgrass = new DecoGrassDoubleTallgrass();
        decoGrassDoubleTallgrass.setCheckRiver(true);
        decoGrassDoubleTallgrass.setMinRiver(0.7f);
        decoGrassDoubleTallgrass.setMaxY(128);
        decoGrassDoubleTallgrass.setLoops(15);
        decoGrassDoubleTallgrass.setDoubleGrassChance(3);
        this.addDeco(decoGrassDoubleTallgrass);
    }
}
