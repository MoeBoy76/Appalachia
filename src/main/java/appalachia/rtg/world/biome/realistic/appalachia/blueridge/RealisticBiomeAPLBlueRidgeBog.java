package appalachia.rtg.world.biome.realistic.appalachia.blueridge;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

import appalachia.api.AppalachiaBiomes;
import appalachia.rtg.world.biome.deco.collection.DecoCollectionBlueRidgeBog;
import appalachia.rtg.world.biome.realistic.appalachia.RealisticBiomeAPLBase;

import rtg.config.BiomeConfig;
import rtg.util.CellNoise;
import rtg.util.CliffCalculator;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.surface.SurfaceBase;
import rtg.world.gen.terrain.HeightEffect;
import rtg.world.gen.terrain.HeightVariation;
import rtg.world.gen.terrain.JitterEffect;
import rtg.world.gen.terrain.TerrainBase;

public class RealisticBiomeAPLBlueRidgeBog extends RealisticBiomeAPLBase {

    public static Biome biome = AppalachiaBiomes.blueRidgeBog;
    public static Biome river = AppalachiaBiomes.blueRidgeRiver;

    protected static int treeMaxY = 220;
    protected static int shrubMaxY = 220;

    public RealisticBiomeAPLBlueRidgeBog() {

        super(biome, river);
    }

    @Override
    public void initConfig() {

        this.getConfig().addProperty(this.getConfig().ALLOW_LOGS).set(true);
    }

    @Override
    public TerrainBase initTerrain() {

        return new TerrainAPLBlueRidgeBog();
    }

    @Override
    public SurfaceBase initSurface() {

        return new SurfaceAPLBlueRidgeBog(config, biome.topBlock, biome.fillerBlock);
    }

    public class SurfaceAPLBlueRidgeBog extends SurfaceBase {

        public SurfaceAPLBlueRidgeBog(BiomeConfig config, IBlockState top, IBlockState filler) {

            super(config, top, filler);
        }

        @Override
        public void paintTerrain(ChunkPrimer primer, int i, int j, int x, int y, int depth, World world, Random rand,
                                 OpenSimplexNoise simplex, CellNoise cell, float[] noise, float river, Biome[] base) {

            float c = CliffCalculator.calc(x, y, noise);
            boolean cliff = c > 1.4f ? true : false;

            for (int k = 255; k > -1; k--) {
                Block b = primer.getBlockState(x, k, y).getBlock();
                if (b == Blocks.AIR) {
                    depth = -1;
                }
                else if (b == Blocks.STONE) {
                    depth++;

                    if (cliff) {
                        if (depth > -1 && depth < 2) {
                            if (rand.nextInt(3) == 0) {

                                primer.setBlockState(x, k, y, hcCobble(world, i, j, x, y, k));
                            }
                            else {

                                primer.setBlockState(x, k, y, hcStone(world, i, j, x, y, k));
                            }
                        }
                        else if (depth < 10) {
                            primer.setBlockState(x, k, y, hcStone(world, i, j, x, y, k));
                        }
                    }
                    else {
                        if (depth == 0 && k > 61) {
                            primer.setBlockState(x, k, y, topBlock);
                        }
                        else if (depth < 4) {
                            primer.setBlockState(x, k, y, fillerBlock);
                        }
                    }
                }
            }
        }
    }

    public class TerrainAPLBlueRidgeBog extends TerrainBase {

        private HeightEffect height;

        public TerrainAPLBlueRidgeBog() {

            HeightVariation waterLand = new HeightVariation();
            waterLand.height = 1f;
            waterLand.wavelength = 40f;
            waterLand.octave = 0;

            height = new JitterEffect(5f, 10f, waterLand);

        }

        @Override
        public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {

            return 62f + height.added(simplex, cell, x, y);
        }
    }

    @Override
    public void initDecos() {

        this.addDecoCollection(new DecoCollectionBlueRidgeBog(this.getConfig().ALLOW_LOGS.get()));
    }

    @Override
    public Biome beachBiome() {
        return this.beachBiome(AppalachiaBiomes.blueRidgeBeach);
    }
}
