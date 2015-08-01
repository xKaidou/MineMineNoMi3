package MineMineNoMi3.Entities.Render;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class RenderAbility implements IItemRenderer
{
	public RenderAbility() {}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch(type)
		{
		case ENTITY:
		case EQUIPPED_FIRST_PERSON: return false;
		case EQUIPPED: return false;
		case INVENTORY: return false;
		default: return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		switch(helper)
		{
		case ENTITY_ROTATION:
		case ENTITY_BOBBING: return true;
		default: return false;
		}
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{		
		switch(type)
		{
		case ENTITY: return;
		case INVENTORY: data = new Object[] { data[0], null } ;
		case EQUIPPED_FIRST_PERSON: return;
		case EQUIPPED: break;
		default:{}
		}
	}
}