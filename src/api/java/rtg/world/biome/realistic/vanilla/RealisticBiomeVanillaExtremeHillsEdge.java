package rtg.world.biome.realistic.vanilla;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

import rtg.api.config.BiomeConfig;
import rtg.api.util.BlockUtil;
import rtg.api.util.CliffCalculator;
import rtg.api.util.noise.OpenSimplexNoise;
import rtg.api.world.RTGWorld;
import rtg.world.biome.deco.*;
import rtg.world.gen.feature.tree.rtg.TreeRTG;
import rtg.world.gen.feature.tree.rtg.TreeRTGPinusNigra;
import rtg.world.gen.surface.SurfaceBase;
import rtg.world.gen.terrain.TerrainBase;
import static rtg.world.biome.deco.DecoFallenTree.LogCondition.NOISE_GREATER_AND_RANDOM_CHANCE;

public class RealisticBiomeVanillaExtremeHillsEdge extends RealisticBiomeVanillaBase {

    public static Biome biome = Biomes.EXTREME_HILLS_EDGE;
    public static Biome river = Biomes.RIVER;

    public RealisticBiomeVanillaExtremeHillsEdge() {

        super(biome, river);

        this.generatesEmeralds = true;
        this.generatesSilverfish = true;
        this.noLakes = true;
        this.noWaterFeatures = true;
    }

    @Override
    public void initConfig() {

        this.getConfig().addProperty(this.getConfig().ALLOW_LOGS).set(true);

        this.getConfig().addProperty(this.getConfig().SURFACE_MIX_BLOCK).set("");
        this.getConfig().addProperty(this.getConfig().SURFACE_MIX_BLOCK_META).set(0);
        this.getConfig().addProperty(this.getConfig().SURFACE_MIX_FILLER_BLOCK).set("");
        this.getConfig().addProperty(this.getConfig().SURFACE_MIX_FILLER_BLOCK_META).set(0);
    }

    @Override
    public TerrainBase initTerrain() {

        return new TerrainVanillaExtremeHillsEdge(10f, 60f, 68f, 200f);
    }

    public class TerrainVanillaExtremeHillsEdge extends TerrainBase {

        private float start;
        private float height;
        private float base;
        private float width;

        public TerrainVanillaExtremeHillsEdge(float hillStart, float landHeight, float baseHeight, float hillWidth) {

            start = hillStart;
            height = landHeight;
            base = baseHeight;
            width = hillWidth;
        }

        @Override
        public float generateNoise(RTGWorld rtgWorld, int x, int y, float border, float river) {

            return terrainHighland(x, y, rtgWorld.simplex, rtgWorld.cell, river, start, width, height, 10f);
        }
    }

    @Override
    public SurfaceBase initSurface() {

        return new SurfaceVanillaExtremeHillsEdge(config, biome.topBlock, biome.fillerBlock, Blocks.GRASS.getDefaultState(), Blocks.DIRT.getDefaultState(), 60f, -0.14f, 14f, 0.25f);
    }

    public class SurfaceVanillaExtremeHillsEdge extends SurfaceBase {

        private IBlockState mixBlockTop;
        private IBlockState mixBlockFill;
        private float width;
        private float height;
        private float smallW;
        private float smallS;

        public SurfaceVanillaExtremeHillsEdge(BiomeConfig config, IBlockState top, IBlockState filler, IBlockState mixTop, IBlockState mixFill, float mixWidth,
                                              float mixHeight, float smallWidth, float smallStrength) {

            super(config, top, filler);

            mixBlockTop = this.getConfigBlock(config.SURFACE_MIX_BLOCK.get(), config.SURFACE_MIX_BLOCK_META.get(), mixTop);
            mixBlockFill = this.getConfigBlock(config.SURFACE_MIX_FILLER_BLOCK.get(), config.SURFACE_MIX_FILLER_BLOCK_META.get(), mixFill);

            width = mixWidth;
            height = mixHeight;
            smallW = smallWidth;
            smallS = smallStrength;
        }

        @Override
        public void paintTerrain(ChunkPrimer primer, int i, int j, int x, int z, int depth, RTGWorld rtgWorld, float[] noise, float river, Biome[] base) {

            Random rand = rtgWorld.rand;
            OpenSimplexNoise simplex = rtgWorld.simplex;
            float c = CliffCalculator.calc(x, z, noise);
            boolean cliff = c > 1.4f ? true : false;
            boolean mix = false;

            for (int k = 255; k > -1; k--) {
                Block b = primer.getBlockState(x, k, z).getBlock();
                if (b == Blocks.AIR) {
                    depth = -1;
                }
                else if (b == Blocks.STONE) {
                    depth++;

                    if (cliff) {
                        if (depth > -1 && depth < 2) {
                            if (rand.nextInt(3) == 0) {

                                primer.setBlockState(x, k, z, hcCobble(rtgWorld, i, j, x, z, k));
                            }
                            else {

                                primer.setBlockState(x, k, z, hcStone(rtgWorld, i, j, x, z, k));
                            }
                        }
                        else if (depth < 10) {
                            primer.setBlockState(x, k, z, hcStone(rtgWorld, i, j, x, z, k));
                        }
                    }
                    else {
                        if (depth == 0 && k > 61) {
                            if (simplex.noise2(i / width, j / width) + simplex.noise2(i / smallW, j / smallW) * smallS > height) {
                                primer.setBlockState(x, k, z, mixBlockTop);
                                mix = true;
                            }
                            else {
                                primer.setBlockState(x, k, z, topBlock);
                            }
                        }
                        else if (depth < 4) {
                            if (mix) {
                                primer.setBlockState(x, k, z, mixBlockFill);
                            }
                            else {
                                primer.setBlockState(x, k, z, fillerBlock);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void initDecos() {

        TreeRTG nigraTree = new TreeRTGPinusNigra();
        nigraTree.setLogBlock(Blocks.LOG.getDefaultState());
        nigraTree.setLeavesBlock(Blocks.LEAVES.getDefaultState());
        nigraTree.setMinTrunkSize(18);
        nigraTree.setMaxTrunkSize(27);
        nigraTree.setMinCrownSize(7);
        nigraTree.setMaxCrownSize(10);
        this.addTree(nigraTree);

        DecoTree decoTrees = new DecoTree(nigraTree);
        decoTrees.setStrengthFactorForLoops(4f);
        decoTrees.setStrengthNoiseFactorXForLoops(true);
        decoTrees.getDistribution().setNoiseDivisor(100f);
        decoTrees.getDistribution().setNoiseFactor(6f);
        decoTrees.getDistribution().setNoiseAddend(0.8f);
        decoTrees.setTreeType(DecoTree.TreeType.RTG_TREE);
        decoTrees.setTreeCondition(DecoTree.TreeCondition.RANDOM_CHANCE);
        decoTrees.setTreeConditionChance(24);
        decoTrees.setMaxY(100);
        this.addDeco(decoTrees);

        DecoFallenTree decoFallenTree = new DecoFallenTree();
        decoFallenTree.getDistribution().setNoiseDivisor(100f);
        decoFallenTree.getDistribution().setNoiseFactor(6f);
        decoFallenTree.getDistribution().setNoiseAddend(0.8f);
        decoFallenTree.setLogCondition(NOISE_GREATER_AND_RANDOM_CHANCE);
        decoFallenTree.setLogConditionNoise(0f);
        decoFallenTree.setLogConditionChance(6);
        decoFallenTree.setLogBlock(BlockUtil.getStateLog(1));
        decoFallenTree.setLeavesBlock(BlockUtil.getStateLeaf(1));
        decoFallenTree.setMinSize(3);
        decoFallenTree.setMaxSize(6);
        this.addDeco(decoFallenTree, this.getConfig().ALLOW_LOGS.get());

        DecoShrub decoShrub = new DecoShrub();
        decoShrub.setMaxY(100);
        decoShrub.setStrengthFactor(2f);
        this.addDeco(decoShrub);

        DecoBoulder decoBoulder = new DecoBoulder();
        decoBoulder.setBoulderBlock(Blocks.MOSSY_COBBLESTONE.getDefaultState());
        decoBoulder.setChance(12);
        decoBoulder.setMaxY(95);
        decoBoulder.setStrengthFactor(2f);
        this.addDeco(decoBoulder);

        DecoMushrooms decoMushrooms = new DecoMushrooms();
        decoMushrooms.setMaxY(90);
        decoMushrooms.setRandomType(rtg.world.biome.deco.DecoMushrooms.RandomType.X_DIVIDED_BY_STRENGTH);
        decoMushrooms.setRandomFloat(3f);
        this.addDeco(decoMushrooms);

        DecoPumpkin decoPumpkin = new DecoPumpkin();
        decoPumpkin.setMaxY(90);
        decoPumpkin.setRandomType(rtg.world.biome.deco.DecoPumpkin.RandomType.X_DIVIDED_BY_STRENGTH);
        decoPumpkin.setRandomFloat(20f);
        this.addDeco(decoPumpkin);

        DecoGrass decoGrass = new DecoGrass();
        decoGrass.setMaxY(128);
        decoGrass.setStrengthFactor(10f);
        this.addDeco(decoGrass);
    }
}
