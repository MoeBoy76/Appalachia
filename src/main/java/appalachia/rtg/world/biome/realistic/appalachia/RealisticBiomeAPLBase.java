package appalachia.rtg.world.biome.realistic.appalachia;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

import net.minecraftforge.fml.common.Loader;

import appalachia.api.AppalachiaBiomes;
import appalachia.rtg.api.biome.appalachia.config.BiomeConfigAPL;
import appalachia.rtg.world.biome.realistic.appalachia.blueridge.*;
import appalachia.rtg.world.biome.realistic.appalachia.blueridge.autumn.RealisticBiomeAPLBlueRidgeForestAutumn;
import appalachia.rtg.world.biome.realistic.appalachia.blueridge.autumn.RealisticBiomeAPLBlueRidgeHillsAutumn;
import appalachia.rtg.world.biome.realistic.appalachia.blueridge.autumn.RealisticBiomeAPLBlueRidgeMountainsAutumn;

import rtg.api.biome.BiomeConfig;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.SurfaceBase;

public abstract class RealisticBiomeAPLBase extends RealisticBiomeBase {

    public static RealisticBiomeBase aplAppalachianMountains;
    public static RealisticBiomeBase aplBlueRidgeForestAutumn;
    public static RealisticBiomeBase aplBlueRidgeHillsAutumn;
    public static RealisticBiomeBase aplBlueRidgeMountainsAutumn;
    public static RealisticBiomeBase aplBlueRidgeForest;
    public static RealisticBiomeBase aplBlueRidgeHills;
    public static RealisticBiomeBase aplBlueRidgeBeach;
    public static RealisticBiomeBase aplBlueRidgeRiver;
    public static RealisticBiomeBase aplBlueRidgeMountains;
    public static RealisticBiomeBase aplPrairie;
    public static RealisticBiomeBase aplSmokyMountains;

    public RealisticBiomeAPLBase(BiomeConfig config, Biome b, Biome riverbiome, SurfaceBase s) {

        super(config, b, riverbiome, s);

        this.waterSurfaceLakeChance = 0;
        this.lavaSurfaceLakeChance = 0;
    }

    public static void addBiomes() {

        if (Loader.isModLoaded("appalachia")) {
            if (AppalachiaBiomes.appalachianMountains != null) {
                aplAppalachianMountains = new RealisticBiomeAPLAppalachianMountains(BiomeConfigAPL.biomeConfigAPLAppalachianMountains);
            }
            if (AppalachiaBiomes.blueRidgeForest != null) {
                aplBlueRidgeForest = new RealisticBiomeAPLBlueRidgeForest(BiomeConfigAPL.biomeConfigAPLBlueRidgeForest);
            }
            if (AppalachiaBiomes.blueRidgeHills != null) {
                aplBlueRidgeHills = new RealisticBiomeAPLBlueRidgeHills(BiomeConfigAPL.biomeConfigAPLBlueRidgeHills);
            }
            if (AppalachiaBiomes.blueRidgeBeach != null) {
                aplBlueRidgeBeach = new RealisticBiomeAPLBlueRidgeBeach(BiomeConfigAPL.biomeConfigAPLBlueRidgeBeach);
            }
            if (AppalachiaBiomes.blueRidgeRiver != null) {
                aplBlueRidgeRiver = new RealisticBiomeAPLBlueRidgeRiver(BiomeConfigAPL.biomeConfigAPLBlueRidgeRiver);
            }
            if (AppalachiaBiomes.blueRidgeMountains != null) {
                aplBlueRidgeMountains = new RealisticBiomeAPLBlueRidgeMountains(BiomeConfigAPL.biomeConfigAPLBlueRidgeMountains);
            }
            if (AppalachiaBiomes.prairie != null) {
                aplPrairie = new RealisticBiomeAPLPrairie(BiomeConfigAPL.biomeConfigAPLPrairie);
            }
            if (AppalachiaBiomes.smokyMountains != null) {
                aplSmokyMountains = new RealisticBiomeAPLSmokyMountains(BiomeConfigAPL.biomeConfigAPLSmokyMountains);
            }

            // Autumnal biomes must be added last.
            if (AppalachiaBiomes.blueRidgeForestAutumn != null) {
                aplBlueRidgeForestAutumn = new RealisticBiomeAPLBlueRidgeForestAutumn(BiomeConfigAPL.biomeConfigAPLBlueRidgeForestAutumn);
            }
            if (AppalachiaBiomes.blueRidgeHillsAutumn != null) {
                aplBlueRidgeHillsAutumn = new RealisticBiomeAPLBlueRidgeHillsAutumn(BiomeConfigAPL.biomeConfigAPLBlueRidgeHillsAutumn);
            }
            if (AppalachiaBiomes.blueRidgeMountainsAutumn != null) {
                aplBlueRidgeMountainsAutumn = new RealisticBiomeAPLBlueRidgeMountainsAutumn(BiomeConfigAPL.biomeConfigAPLBlueRidgeMountainsAutumn);
            }
        }
    }

    @Override
    public Biome beachBiome() {
        return this.beachBiome(Biomes.STONE_BEACH);
    }
}
