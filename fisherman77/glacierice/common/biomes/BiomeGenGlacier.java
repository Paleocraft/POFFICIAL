package fisherman77.glacierice.common.biomes;

import java.util.ArrayList;

import fisherman77.glacierice.common.GlacierIce;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenGlacier extends BiomeGenBase {

		public BiomeGenGlacier(int par1) {
			super(par1);
  			this.topBlock = (byte)GlacierIce.BlueGlacierIce.blockID;
            this.fillerBlock = (byte)Block.stone.blockID;
            this.canSpawnLightningBolt();
            this.setEnableSnow();
            this.setTemperatureRainfall(0.2F, 0.5F);
		}
}