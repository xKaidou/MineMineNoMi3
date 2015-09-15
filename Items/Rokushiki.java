package MineMineNoMi3.Items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import MineMineNoMi3.MainItem;
import MineMineNoMi3.Entities.Projectile;
import MineMineNoMi3.Utils.AbilityAttribute;

public class Rokushiki extends MainItem
{
	private int ticks, use;
	private String type;
	
	public Rokushiki(String type)
	{
		this.type = type;
		this.setMaxStackSize(1);
	}
		
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) 
	{  
		if(!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());

			itemStack.stackTagCompound.setInteger("ticks", this.ticks);
			itemStack.stackTagCompound.setInteger("ticksfin", this.ticks);
			itemStack.stackTagCompound.setInteger("use", this.use);
		}
		
		boolean flag = !world.isRemote;
		
		if(this.type.equals("soru") && flag)
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 5 , 3));

		if(this.type.equals("tekkai") && flag)
		{
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 5, 10));
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 5, 100));
		}

		if(this.type.equals("kamie") && flag)
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 5, 10));
		
		if(this.type.equals("rankyaku") && itemStack.stackTagCompound.getInteger("use") == 0)
		{
			world.spawnEntityInWorld(new Projectile(world, player, AbilityAttribute.RANKYAKU));
			itemStack.stackTagCompound.setInteger("use", 1);
			itemStack.stackTagCompound.setInteger("ticks", AbilityAttribute.RANKYAKU.getItemTicks());
		}
	
		if(this.type.equals("shigan") && itemStack.stackTagCompound.getInteger("use") == 0)
		{
			world.spawnEntityInWorld(new Projectile(world, player, AbilityAttribute.SHIGAN));
			itemStack.stackTagCompound.setInteger("use", 1);
			itemStack.stackTagCompound.setInteger("ticks", AbilityAttribute.SHIGAN.getItemTicks());
		}
		
		if(this.type.equals("geppo") && itemStack.stackTagCompound.getInteger("use") == 0)
		{
			player.motionY += 1.8;
			itemStack.stackTagCompound.setInteger("use", 1);
			itemStack.stackTagCompound.setInteger("ticks", 22);
		}

		
		return itemStack;
	}
	
	public boolean hasEffect(ItemStack itemStack, int pass)
	{ 
		if (itemStack.stackTagCompound != null) 
		{	
			if(itemStack.stackTagCompound.getInteger("use")==1)
				return true;	
			else
				return false;
		}
		return false;	
	}
	
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) 
	{
		if (par1ItemStack.stackTagCompound != null) 
		{
			int t = par1ItemStack.stackTagCompound.getInteger("ticks");      
			int tf = par1ItemStack.stackTagCompound.getInteger("ticksfin");    
			int u = par1ItemStack.stackTagCompound.getInteger("use");
			tf = t;
			if(u == 1 && t > 0)
			{
				t--;
				par1ItemStack.stackTagCompound.setInteger("ticks", t);	
			}
			else if(t <= 0)
			{
				par1ItemStack.stackTagCompound.setInteger("use", 0);
				par1ItemStack.stackTagCompound.setInteger("ticks", tf);
			}
		}
	}
	
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
	{
		return false;
	}
}
