package fisherman77.paleocraft.common;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
//import fisherman77.zeuscraft.common.Zeuscraft;
import fisherman77.paleocraft.common.mobs.EntityBaryonyx;
import fisherman77.paleocraft.common.mobs.EntityCitipati;
import fisherman77.paleocraft.common.mobs.EntityCompy;
import fisherman77.paleocraft.common.mobs.EntityCryo;
import fisherman77.paleocraft.common.mobs.EntityDimorphodon;
import fisherman77.paleocraft.common.mobs.EntityDimorphodonL;
import fisherman77.paleocraft.common.mobs.EntityDromaeosaurus;
import fisherman77.paleocraft.common.mobs.EntityMasso;
import fisherman77.paleocraft.common.mobs.EntityMegalodon;
import fisherman77.paleocraft.common.mobs.EntityQuetzalcoatlus;
import fisherman77.paleocraft.common.mobs.EntityQuetzalcoatlusL;
import fisherman77.paleocraft.common.mobs.EntitySpino;
import fisherman77.paleocraft.common.mobs.EntityTroodon;
import fisherman77.paleocraft.common.mobs.EntityTylo;
import fisherman77.paleocraft.common.mobs.ModelBaryonyx;
import fisherman77.paleocraft.common.mobs.ModelCitipati;
import fisherman77.paleocraft.common.mobs.ModelCryo;
import fisherman77.paleocraft.common.mobs.ModelDimorphLand;
import fisherman77.paleocraft.common.mobs.ModelDimorphodon;
import fisherman77.paleocraft.common.mobs.ModelDromaeosaurus;
import fisherman77.paleocraft.common.mobs.ModelMassospondylus;
import fisherman77.paleocraft.common.mobs.ModelMegalodon;
import fisherman77.paleocraft.common.mobs.ModelQuetzLand;
import fisherman77.paleocraft.common.mobs.ModelQuetzalcoatlus;
import fisherman77.paleocraft.common.mobs.ModelSpino;
import fisherman77.paleocraft.common.mobs.ModelTroodon;
import fisherman77.paleocraft.common.mobs.ModelTylo;
import fisherman77.paleocraft.common.mobs.RenderBaryonyx;
import fisherman77.paleocraft.common.mobs.RenderCitipati;
import fisherman77.paleocraft.common.mobs.RenderCompy;
import fisherman77.paleocraft.common.mobs.RenderCryo;
import fisherman77.paleocraft.common.mobs.RenderDimorphLand;
import fisherman77.paleocraft.common.mobs.RenderDimorphodon;
import fisherman77.paleocraft.common.mobs.RenderDromaeosaurus;
import fisherman77.paleocraft.common.mobs.RenderMasso;
import fisherman77.paleocraft.common.mobs.RenderMegalodon;
import fisherman77.paleocraft.common.mobs.RenderQuetzLand;
import fisherman77.paleocraft.common.mobs.RenderQuetzalcoatlus;
import fisherman77.paleocraft.common.mobs.RenderSpino;
import fisherman77.paleocraft.common.mobs.RenderTroodon;
import fisherman77.paleocraft.common.mobs.RenderTylo;

public class PaleocraftCommonProxy implements IGuiHandler{ //THIS IS IMPORTANT, CANNOT BE A PROXY/GUI HANDLER WITHOUT THIS!!
	
public void registerRenderInformation() //Client side texture registering
{
}
@Override
public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { //For GUI's
return null;
}
@Override
public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { //For GUI's
return null;
}

public void registerTiles(){ //For registering TileEntities
}

public void registerBlocks(){
}

public void registerItems(){
}

public void addRecipes(){ //For adding your Item's recipes
}

public void registerRenderers(){
/*	float shadowSize = 0.5F;
	RenderingRegistry.registerEntityRenderingHandler(EntityQuetzalcoatlus.class, new RenderQuetzalcoatlus(new ModelQuetzalcoatlus(), shadowSize));
	RenderingRegistry.registerEntityRenderingHandler(EntityQuetzalcoatlusL.class, new RenderQuetzLand(new ModelQuetzLand(), shadowSize));
	//RenderingRegistry.registerEntityRenderingHandler(EntityBaryonyx.class, new RenderBaryonyx(new ModelBaryonyx(), 2.5F, shadowSize));
	RenderingRegistry.registerEntityRenderingHandler(EntityBaryonyx.class, new RenderBaryonyx(new ModelBaryonyx(), shadowSize, 2.5F));
	RenderingRegistry.registerEntityRenderingHandler(EntityCitipati.class, new RenderCitipati(new ModelCitipati(), shadowSize));
	RenderingRegistry.registerEntityRenderingHandler(EntityCompy.class, new RenderCompy(new ModelCompsognathus(), shadowSize, 0.5F));
	RenderingRegistry.registerEntityRenderingHandler(EntityDimorphodon.class, new RenderDimorphodon(new ModelDimorphodon(), shadowSize, 0.25F));
	// RenderingRegistry.registerEntityRenderingHandler(EntityQuetzalcoatlus.class, new RenderQuetzalcoatlus(new ModelQuetzalcoatlus(), 0.3F));
	RenderingRegistry.registerEntityRenderingHandler(EntityDromaeosaurus.class, new RenderDromaeosaurus(new ModelDromaeosaurus(), shadowSize));
	RenderingRegistry.registerEntityRenderingHandler(EntityMasso.class, new RenderMasso(new ModelMassospondylus(), shadowSize));
	RenderingRegistry.registerEntityRenderingHandler(EntityMegalodon.class, new RenderMegalodon(new ModelMegalodon(), shadowSize, 3.75F));
	RenderingRegistry.registerEntityRenderingHandler(EntitySpino.class, new RenderSpino(new ModelSpino(), shadowSize, 3.0F));
	RenderingRegistry.registerEntityRenderingHandler(EntityTroodon.class, new RenderTroodon(new ModelTroodon(), shadowSize));
	RenderingRegistry.registerEntityRenderingHandler(EntityTylo.class, new RenderTylo(new ModelTylo(), shadowSize, 2.5F));
	//RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, new RenderGhost(new ModelGhost(), shadowSize));
	RenderingRegistry.registerEntityRenderingHandler(EntityDimorphodonL.class, new RenderDimorphLand(new ModelDimorphLand(), shadowSize, 0.25F));
	RenderingRegistry.registerEntityRenderingHandler(EntityCryo.class, new RenderCryo(new ModelCryo(), shadowSize, 2.2F));	*/
}
public void registerSounds() {
	   
	 }

public void initCapes()
{
}
/*public void registerEntity(Class<? extends Entity> entityClass, String entityName, int bkEggColor, int fgEggColor) {
	int id = EntityRegistry.findGlobalUniqueEntityId();

	EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
	EntityList.entityEggs.put(Integer.valueOf(id), new EntityEggInfo(id, bkEggColor, fgEggColor));
}}*/}

