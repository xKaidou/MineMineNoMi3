package MineMineNoMi3;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class MainExtendedEntity implements IExtendedEntityProperties
{
	public static final String EXT_PROP_NAME = "ExtendedEntity";
	private EntityLivingBase entity;
	
	private boolean hasHeart = true, hasShadow = true;
	
	public MainExtendedEntity(EntityLivingBase entity)
	{
		this.entity = entity;
	}
	
	public static final void register(EntityLivingBase entity)
	{
		entity.registerExtendedProperties(EXT_PROP_NAME, new MainExtendedEntity(entity));
	}
	
	public static final MainExtendedEntity get(EntityLivingBase entity)
	{
		return (MainExtendedEntity)entity.getExtendedProperties(EXT_PROP_NAME);
	}
	
	public void init(Entity arg0, World arg1) {}

	public void saveNBTData(NBTTagCompound compound) 
	{
        NBTTagCompound nbt = new NBTTagCompound();
        
        nbt.setBoolean("hasHeart", hasHeart);
        nbt.setBoolean("hasShadow", hasShadow);
        
        nbt.setTag(EXT_PROP_NAME, nbt); 
	}
	
	public void loadNBTData(NBTTagCompound compound) 
	{
		NBTTagCompound nbt = new NBTTagCompound();
		
		this.hasHeart = nbt.getBoolean("hasHeart");
		this.hasShadow = nbt.getBoolean("hasShadow");
		
		nbt.getTag(EXT_PROP_NAME);
	}
	
	public boolean hasShadow()
	{return this.hasShadow;}
	public void setHasShadow(boolean i)
	{this.hasShadow = i;}

	public boolean hasHeart()
	{return this.hasHeart;}
	public void setHasHeart(boolean i)
	{this.hasHeart = i;}
	
}
