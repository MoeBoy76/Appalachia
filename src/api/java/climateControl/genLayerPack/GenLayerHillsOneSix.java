
package climateControl.genLayerPack;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerHillsOneSix extends GenLayer
{
    public GenLayerHillsOneSix(long par1, GenLayer par3GenLayer)
    {
        super(par1);
        this.parent = par3GenLayer;
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public int[] getInts(int par1, int par2, int par3, int par4)
    {
        int[] aint = this.parent.getInts(par1 - 1, par2 - 1, par3 + 2, par4 + 2);
        int[] aint1 = IntCache.getIntCache(par3 * par4);

        for (int i1 = 0; i1 < par4; ++i1)
        {
            for (int j1 = 0; j1 < par3; ++j1)
            {
                this.initChunkSeed((long)(j1 + par1), (long)(i1 + par2));
                int k1 = aint[j1 + 1 + (i1 + 1) * (par3 + 2)];

                if (this.nextInt(3) == 0)
                {
                    int l1 = k1;

                    if (k1 == Biome.getIdForBiome(Biomes.DESERT))
                    {
                        l1 =Biome.getIdForBiome(Biomes.DESERT_HILLS);
                    }
                    else if (k1 == Biome.getIdForBiome(Biomes.FOREST))
                    {
                        l1 =Biome.getIdForBiome(Biomes.FOREST_HILLS);
                    }
                    else if (k1 == Biome.getIdForBiome(Biomes.TAIGA))
                    {
                        l1 = Biome.getIdForBiome(Biomes.TAIGA_HILLS);
                    }
                    else if (k1 == Biome.getIdForBiome(Biomes.PLAINS))
                    {
                        l1 = Biome.getIdForBiome(Biomes.FOREST);
                    }
                    else if (k1 == Biome.getIdForBiome(Biomes.ICE_PLAINS))
                    {
                        l1 = Biome.getIdForBiome(Biomes.ICE_MOUNTAINS);
                    }
                    else if (k1 == Biome.getIdForBiome(Biomes.JUNGLE))
                    {
                        l1 = Biome.getIdForBiome(Biomes.JUNGLE_HILLS);
                    }

                    if (l1 == k1)
                    {
                        aint1[j1 + i1 * par3] = k1;
                    }
                    else
                    {
                        int i2 = aint[j1 + 1 + (i1 + 1 - 1) * (par3 + 2)];
                        int j2 = aint[j1 + 1 + 1 + (i1 + 1) * (par3 + 2)];
                        int k2 = aint[j1 + 1 - 1 + (i1 + 1) * (par3 + 2)];
                        int l2 = aint[j1 + 1 + (i1 + 1 + 1) * (par3 + 2)];

                        if (i2 == k1 && j2 == k1 && k2 == k1 && l2 == k1)
                        {
                            aint1[j1 + i1 * par3] = l1;
                        }
                        else
                        {
                            aint1[j1 + i1 * par3] = k1;
                        }
                    }
                }
                else
                {
                    aint1[j1 + i1 * par3] = k1;
                }
            }
        }

        return aint1;
    }
}