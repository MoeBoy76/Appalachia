package climateControl.customGenLayer;

import climateControl.ClimateControl;
import climateControl.genLayerPack.GenLayerPack;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
/**
 *
 * @author Zeno410
 */
public class GenLayerSmoothWithClimates extends GenLayerPack {
    private static int deepOcean;
    private static int mushroomIsland;

    public GenLayerSmoothWithClimates(long par1, GenLayer par3GenLayer){
        super(par1);
        super.parent = par3GenLayer;
        if (super.parent == null) throw new RuntimeException();
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public int[] getInts(int par1, int par2, int par3, int par4){
        deepOcean = Biome.getIdForBiome(Biomes.DEEP_OCEAN);
        mushroomIsland = Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND);
        int i1 = par1 - 1;
        int j1 = par2 - 1;
        int k1 = par3 + 2;
        int l1 = par4 + 2;
        int[] aint = this.parent.getInts(i1, j1, k1, l1);
        int[] aint1 = IntCache.getIntCache(par3 * par4);

        for (int i2 = 0; i2 < par4; ++i2)
        {
            for (int j2 = 0; j2 < par3; ++j2)
            {
                int k2 = aint[j2 + 0 + (i2 + 1) * k1];
                int l2 = aint[j2 + 2 + (i2 + 1) * k1];
                int i3 = aint[j2 + 1 + (i2 + 0) * k1];
                int j3 = aint[j2 + 1 + (i2 + 2) * k1];
                int k3 = aint[j2 + 1 + (i2 + 1) * k1];

                if (k3 == mushroomIsland) {
                    aint1[j2 + i2 * par3] = k3;
                    continue;
                }
                
                if (k2 == l2 && i3 == j3)
                {
                    this.initChunkSeed((long)(j2 + par1), (long)(i2 + par2));

                    if (this.nextInt(2) == 0)
                    {
                        k3 = k2;
                    }
                    else
                    {
                        k3 = i3;
                    }
                }
                else
                {
                    if (k2 == l2){
                        k3 = k2;
                    } else if (i3 == j3){
                        k3 = i3;
                    } else {
                        // special tricks needs for stray lakes
                        if (k3 ==0) {
                            k3 = climateSmoothed(i1,j1,k1,l1,k2,l2,i3,j3,k3,par1,par2,i2,j2);
                        }
                    }
                }

                aint1[j2 + i2 * par3] = k3;
            }
        }

        return aint1;
    }

    private final int climateSmoothed(int i1,int j1,int k1,int l1,int k2,int l2,int i3,int j3,int k3, int par1, int par2, int i2, int j2) {
        if (k2>0&& l2>0&&k2!=deepOcean&&l2!=deepOcean){
            this.initChunkSeed((long)(j2 + par1), (long)(i2 + par2));
            if (i3>0&& j3>0&&i3!=deepOcean&&j3!=deepOcean) {
                int pick = this.nextInt(4);
                if (pick ==0) {k3 = k2;}
                else if (pick ==1) {k3 = l2;}
                else if (pick ==2) {k3 = i3;}
                else if (pick ==3) {k3 = j3;}
            } else {
                if (this.nextInt(2) == 0) {
                    k3 = k2;
                } else {
                    k3 =l2;
                }
            }
        } else {
            if (i3>0&& j3>0&&i3!=deepOcean&&j3!=deepOcean) {
                this.initChunkSeed((long)(j2 + par1), (long)(i2 + par2));
                if (this.nextInt(2) == 0) {
                    k3 = i3;
                } else {
                    k3 =j3;
                }
            }

        }
        return k3;
    }
}