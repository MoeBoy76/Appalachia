package appalachia.rtg.world.biome.realistic.appalachia.blueridge.autumn;

import net.minecraft.world.biome.Biome;

import appalachia.api.AppalachiaBiomes;
import appalachia.rtg.api.biome.appalachia.config.BiomeConfigAPLBlueRidgeHillsAutumn;
import appalachia.rtg.world.biome.deco.collection.DecoCollectionBlueRidgeForest;
import appalachia.rtg.world.biome.realistic.appalachia.RealisticBiomeAPLBase;
import appalachia.rtg.world.gen.surface.appalachia.SurfaceAPLBlueRidgeHillsAutumn;

import rtg.api.biome.BiomeConfig;
import rtg.util.BlockUtil;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.terrain.TerrainBase;

public class RealisticBiomeAPLBlueRidgeHillsAutumn extends RealisticBiomeAPLBase {

    public static Biome biome = AppalachiaBiomes.blueRidgeHillsAutumn;
    public static Biome river = AppalachiaBiomes.blueRidgeRiver;

    public RealisticBiomeAPLBlueRidgeHillsAutumn(BiomeConfig config) {

        super(config, biome, river,
            new SurfaceAPLBlueRidgeHillsAutumn(config, biome.topBlock, biome.fillerBlock, BlockUtil.getStateDirt(2), 12f, 0.27f)
        );

        this.addDecoCollection(new DecoCollectionBlueRidgeForest(this.config._boolean(BiomeConfigAPLBlueRidgeHillsAutumn.decorationLogsId)));
    }

    @Override
    public TerrainBase initTerrain() {

        return RealisticBiomeBase.getBiome(Biome.getIdForBiome(AppalachiaBiomes.blueRidgeHills)).getTerrain();
    }

    @Override
    public Biome beachBiome() {
        return this.beachBiome(AppalachiaBiomes.blueRidgeBeach);
    }
}
