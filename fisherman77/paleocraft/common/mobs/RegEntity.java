package fisherman77.paleocraft.common.mobs;

import net.minecraft.entity.EntityList;
import fisherman77.paleocraft.common.Paleocraft;
import cpw.mods.fml.common.registry.EntityRegistry;




public class RegEntity {
	
	public static void Paleocraft(){
		registerEntity();
	}

public static void registerEntity(){
	createEntity(EntityBaryonyx.class, "EntityBaryonyx", 0x405135, 0xC4C67D);
	createEntity(EntityCitipati.class, "EntityCitipati", 0xA67822, 0xA14A5C);
	createEntity(EntityCompy.class, "EntityCompy", 0x4B4A31, 0xBDBC8B);
	createEntity(EntityDimorphodon.class, "EntityDimorphodon", 0xC8C968, 0x6064C4);
	createEntity(EntityDromaeosaurus.class, "EntityDromaeosaurus", 0x5C5B5C, 0x551305);
	createEntity(EntitySpino.class, "EntitySpino", 0x0E1640, 0xF78708);
	createEntity(EntityMasso.class, "EntityMasso", 0x515151, 0x1E0F50);
	createEntity(EntityTroodon.class, "EntityTroodon", 0x5A5A5A, 0xE8E1BF);
	createEntity(EntityMegalodon.class, "EntityMegalodon", 0x676767, 0x9c9c9c);
	createEntity(EntityTylo.class, "EntityTylo", 0x45369F, 0xFFFFFF);
	createEntity(EntityQuetzalcoatlus.class, "EntityQuetz", 0xF28F0C, 0x8F0CF2);
//	createEntity(EntityQuetzalcoatlusL.class, "EntityQuetzLand", 0xC8C968, 0x6064C4);
//	createEntity(EntityDimorphodonL.class, "EntityDimorphodonLand", 0xC8C968, 0x6064C4);
	createEntity(EntityCryo.class, "EntityCryo", 0xF20000, 0xFFFF3D);
	createEntity(EntitySpinoSwimming.class, "EntitySpinoSwimming", 0x0E1640, 0xF78708);
}


public static void createEntity(Class entityClass, String entityName, int solidColour, int spotColour){
	int randomId = EntityRegistry.findGlobalUniqueEntityId();
	
	EntityRegistry.registerGlobalEntityID(entityClass,  entityName, randomId);
	EntityRegistry.registerModEntity(entityClass, entityName, randomId, Paleocraft.instance, 64, 1, true); 
	createEgg(randomId, solidColour, spotColour);
	//EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId,  solidColour,  spotColour));
}

private static void createEgg(int randomId, int solidColour, int spotColour) { 
	EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId,  solidColour,  spotColour));

}

}
