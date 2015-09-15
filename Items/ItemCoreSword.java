package MineMineNoMi3.Items;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import MineMineNoMi3.MainExtendedEntity;
import MineMineNoMi3.MainExtendedPlayer;
import MineMineNoMi3.Entities.Projectile;
import MineMineNoMi3.Lists.ListMisc;
import MineMineNoMi3.Utils.AbilityAttribute;
import MineMineNoMi3.Utils.IOnePieceMob;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCoreSword extends ItemSword
{
	
	public double weaponDamage;
	private int ticks, use;
	
	public ItemCoreSword(int dmg)
	{
		super(EnumHelper.addToolMaterial("BASE", 0, dmg * 100, 0, dmg - 4, 0));
		this.maxStackSize = 1;
		this.weaponDamage = EnumHelper.addToolMaterial("BASE", 0, dmg * 100, 0, dmg - 4, 0).getDamageVsEntity();
		this.setMaxDamage(dmg * 100);
	}  	

	public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase entity)
	{	
		MainExtendedPlayer props = MainExtendedPlayer.get(player);
		if(!player.worldObj.isRemote && player.getCurrentEquippedItem().getItem()==ListMisc.Scissors && props.getUsedFruit().equals("kagekage"))
		{
			MainExtendedEntity propz = MainExtendedEntity.get(entity);
			
			if ((!(entity instanceof IOnePieceMob) && ((IOnePieceMob)entity).hasShadow()) && propz.hasShadow()) 
	    	{
	    		Random rand = new Random();
	    		EntityItem shadow = entity.entityDropItem(new ItemStack(ListMisc.Shadow), 1.0F);
	    		shadow.motionY += rand.nextFloat() * 0.05F;
	    		shadow.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
	    		shadow.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
	    		itemStack.damageItem(100, entity);
	    		propz.setHasShadow(false);			
			}
		}	
    	return false;
	}

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
    	player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
    	MainExtendedPlayer props = MainExtendedPlayer.get(player);  

		if(!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());

			itemStack.stackTagCompound.setInteger("ticks", this.ticks);
			itemStack.stackTagCompound.setInteger("ticksfin", this.ticks);
			itemStack.stackTagCompound.setInteger("use", this.use);
		}
    	
    	if(props.getUsedFruit().equals("opeope") && itemStack.stackTagCompound.getInteger("use") == 0)
    	{
    		world.spawnEntityInWorld(new Projectile(world, player, AbilityAttribute.OPEOPESLASH));	
			itemStack.stackTagCompound.setInteger("use", 1);
			itemStack.stackTagCompound.setInteger("ticks", AbilityAttribute.OPEOPESLASH.getItemTicks());
    	}
    	
    	return itemStack;
    }
    
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		return true;  
	}
    
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) 
    {
		if (itemStack.stackTagCompound != null) 
		{
			int t = itemStack.stackTagCompound.getInteger("ticks");      
			int tf = itemStack.stackTagCompound.getInteger("ticksfin");    
			int u = itemStack.stackTagCompound.getInteger("use");
			tf = t;
			if(u == 1 && t > 0)
			{
				t--;
				itemStack.stackTagCompound.setInteger("ticks", t);	
			}
			else if(t <= 0)
			{
				itemStack.stackTagCompound.setInteger("use", 0);
				itemStack.stackTagCompound.setInteger("ticks", tf);
			}
		}
    }
   
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {}
    
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
    
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
    	return EnumAction.block;
	}
	
	public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", this.weaponDamage, 0)); 
        return multimap;
    }

}
