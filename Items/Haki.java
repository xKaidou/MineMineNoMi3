package MineMineNoMi3.Items;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import MineMineNoMi3.Helper;
import MineMineNoMi3.MainExtendedPlayer;
import MineMineNoMi3.MainItem;

public class Haki extends MainItem
{
	private boolean use = false;
	private int ticks;
	public String type;
	
	public Haki(String type)
	{
		this.type = type;
		this.setMaxStackSize(1);
	}
		
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) 
	{  
		if(!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());

			itemStack.stackTagCompound.setBoolean("use", this.use);
			itemStack.stackTagCompound.setInteger("ticksfin", this.ticks);
			itemStack.stackTagCompound.setInteger("ticks", this.ticks);
		}
		
		boolean flag = !world.isRemote;
		MainExtendedPlayer props = MainExtendedPlayer.get(player);
		
		if(this.type.equals("busoshoku") && flag)
		{		
			itemStack.stackTagCompound.setBoolean("use", !itemStack.stackTagCompound.getBoolean("use"));
			if(itemStack.stackTagCompound.getInteger("ticks") >= 495)
			{
				itemStack.stackTagCompound.setInteger("ticks", 500);
				itemStack.stackTagCompound.setInteger("ticksfin", itemStack.stackTagCompound.getInteger("ticks"));
				this.setMaxDamage(itemStack.stackTagCompound.getInteger("ticks"));
			}
		}
		
		if(this.type.equals("kenbunshoku") && flag && !itemStack.stackTagCompound.getBoolean("use"))
		{
			AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox((double)player.posX, (double)player.posY, (double)player.posZ, (double)(player.posX + 1), (double)(player.posY + 1), (double)(player.posZ + 1)).expand(50, 50, 50);
			aabb.maxY = (double)player.worldObj.getHeight();
			List<EntityLivingBase> list = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, aabb);
			list.remove(player);
			Iterator<EntityLivingBase> iterator = list.iterator();	
			EntityLivingBase living;
			while(iterator.hasNext())
			{
				living = (EntityLivingBase)iterator.next();
				if(living instanceof EntityPlayer)
				{
					MainExtendedPlayer livingprops = MainExtendedPlayer.get((EntityPlayer)living);
					Helper.sendText(player, ((EntityPlayer) living).getDisplayName() + " (" + livingprops.getDoriki() + ") [" + (int)((EntityPlayer)living).getPlayerCoordinates().getDistanceSquaredToChunkCoordinates(player.getPlayerCoordinates()) + "]");
				}
			}
			  
			itemStack.stackTagCompound.setBoolean("use", !itemStack.stackTagCompound.getBoolean("use"));
			itemStack.stackTagCompound.setInteger("ticks", 500);
		}
		
		if(this.type.equals("haoshoku") && !itemStack.stackTagCompound.getBoolean("use"))
		{
			AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox((double)player.posX, (double)player.posY, (double)player.posZ, (double)(player.posX + 1), (double)(player.posY + 1), (double)(player.posZ + 1)).expand(30, 30, 30);
			aabb.maxY = (double)player.worldObj.getHeight();
			List<EntityLivingBase> list = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, aabb);
			list.remove(player);
			Iterator<EntityLivingBase> iterator = list.iterator();							 
			EntityLivingBase living;
			
			while(iterator.hasNext())
			{
				living = (EntityLivingBase)iterator.next();
				MainExtendedPlayer livingprops = MainExtendedPlayer.get(player);
				
				if(livingprops.getDoriki() <= props.getDoriki() - props.getDoriki()/3)
				{
					living.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 5));
					living.addPotionEffect(new PotionEffect(Potion.blindness.id, 200));
					living.addPotionEffect(new PotionEffect(Potion.nightVision.id, 200));
					living.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 200, 5));
					
					for(int i=0; i<=1024; i++)
					{
						Random r = new Random();
						int r1 = r.nextInt(29+30)-30;
						int r2 = r.nextInt(29+30)-30;
						double r3 = r.nextDouble();
						double r4 = r.nextDouble();
						player.worldObj.spawnParticle("witchMagic",player.posX+r1+r3, player.posY-1, player.posZ+r2+r4, 0, 0, 0);
					}
				}
			}
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20, 100));			
			
			itemStack.stackTagCompound.setBoolean("use", !itemStack.stackTagCompound.getBoolean("use"));
			itemStack.stackTagCompound.setInteger("ticks", 1000);
		}
		
		return itemStack;
	}
	
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) 
	{
		if (itemStack.stackTagCompound != null) 
		{
			if(entity instanceof EntityPlayer && entity != null)
			{
				EntityPlayer player = (EntityPlayer) entity;
				MainExtendedPlayer props = MainExtendedPlayer.get(player);

				if(this.type.equals("busoshoku") && itemStack.stackTagCompound.getBoolean("use"))
					player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 30 , (int)(Math.sqrt(props.getDoriki())*2)/3));
			}
			
			int t = itemStack.stackTagCompound.getInteger("ticks");      
			int tf = itemStack.stackTagCompound.getInteger("ticksfin");    
			boolean u = itemStack.stackTagCompound.getBoolean("use");

			if(u && t > 0)
			{
				t--;
				itemStack.stackTagCompound.setInteger("ticks", t);	
				this.setDamage(itemStack, t);
			}
			else if(t <= 0)
				itemStack.stackTagCompound.setBoolean("use", false);
			
			if(this.type.equals("busoshoku"))
			{
				if(t < tf && !u)
				{
					t++;
					itemStack.stackTagCompound.setInteger("ticks", t);	
					this.setDamage(itemStack, t);
				}
				else if(t == tf && !u)
					this.setMaxDamage(0);
			}
		}	
	}
	
	public boolean hasEffect(ItemStack itemStack, int pass)
	{ 
		if (itemStack.stackTagCompound != null) 
		{	
			if(itemStack.stackTagCompound.getBoolean("use") == true)
				return true;	
			else
				return false;
		}
		return false;	
	}
	
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
	{
		return false;
	}
}
