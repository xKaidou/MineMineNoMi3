package MineMineNoMi3.Entities.Render;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class RenderAbility implements IItemRenderer
{
	
	public RenderAbility()
	{

	}

	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch(type)
		{
			case ENTITY:
			case EQUIPPED_FIRST_PERSON: return false;
			case EQUIPPED: return true;
			case INVENTORY: return false;
			default: return false;
		}
	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		switch(helper)
		{
			case ENTITY_ROTATION:
			case ENTITY_BOBBING: return true;
			default: return false;
		}
	}

	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch(type)
		{
			case ENTITY:
			case INVENTORY:
			case EQUIPPED_FIRST_PERSON:	
			case EQUIPPED: break;
			default:{}
		}
	}
}