package MineMineNoMi3.Items;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import MineMineNoMi3.Config;
import MineMineNoMi3.Main;
import MineMineNoMi3.MainItem;
import MineMineNoMi3.Entities.Projectile;
import MineMineNoMi3.Packets.PacketPlayer;
import MineMineNoMi3.Utils.DatabaseEvents;
import MineMineNoMi3.Utils.DatabaseStructures;
import MineMineNoMi3.Utils.AbilityAttribute;
import MineMineNoMi3.Utils.AbilityAttribute;
import MineMineNoMi3.Utils.ja_JPSupport;

import com.google.common.collect.Multimap;

public class Ability extends MainItem
{
	
	private int ticks, use, charging = 0;
	private AbilityAttribute proj;

	public Ability()
	{
		this.setMaxStackSize(1);
	}
	
	public Ability(AbilityAttribute ability)
	{
		this.setMaxStackSize(1);
		this.proj = ability;
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{	
		if(!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());

			itemStack.stackTagCompound.setInteger("ticks", this.ticks);
			itemStack.stackTagCompound.setInteger("ticksfin", this.ticks);
			itemStack.stackTagCompound.setInteger("charging", this.charging);
			itemStack.stackTagCompound.setInteger("use", this.use);
		}
		if(itemStack.stackTagCompound != null)
		{
			if(itemStack.stackTagCompound.getInteger("use") == 0)
			{
				if(!(this.proj.getEntityTicks() <= 0))
					world.spawnEntityInWorld(new Projectile(world, player, this.proj));
				/*if(this.proj.getEntityTicks() < 0)
					player.setItemInUse(itemStack, this.proj.getItemTicks() * 50);*/

				for(int i = 0; i < this.proj.getEntityAttr().length; i++)
				{
					String attr = this.proj.getEntityAttr()[i];
						
					DatabaseEvents.event(attr, player);
					DatabaseStructures.creo(attr, player);
				}									

				if(!Config.allowDebugMode_actual)
					itemStack.stackTagCompound.setInteger("ticks", this.proj.getItemTicks());
				itemStack.stackTagCompound.setInteger("use", 1);
			}
		}
		return itemStack;		
		
	}

	public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int i) 
	{	
		Main.network.sendToServer(new PacketPlayer("projectile_daienkaientei"));
		Main.network.sendToAll(new PacketPlayer("projectile_daienkaientei"));
		itemStack.stackTagCompound.setInteger("use", 1);
	}
	
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
		if(this.proj.getEntityTicks() < 0)	
		{
			int ct = itemStack.stackTagCompound.getInteger("charging");
			if(ct < 10)
			{
				ct++;
				itemStack.stackTagCompound.setInteger("charging", ct);
				System.out.println(itemStack.stackTagCompound.getInteger("charging"));
			}
			return EnumAction.bow;
		}
		return EnumAction.none;
    }
	
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
	{
		return false;
	}
	
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) 
	{
		if (this.proj != null)
		{
			if (itemStack.stackTagCompound != null) 
			{
				int t = itemStack.stackTagCompound.getInteger("ticks");      
				int tf = itemStack.stackTagCompound.getInteger("ticksfin");    
				int u = itemStack.stackTagCompound.getInteger("use");
				tf=this.proj.getItemTicks();
				if((u == 1) && (t > 0))
				{
					t--;
					if(this.proj.getEntityRepeat() && t > (tf/4)*3 + (tf/11))
						world.spawnEntityInWorld(new Projectile(world, (EntityPlayer)entity, this.proj));
					itemStack.stackTagCompound.setInteger("ticks", t);	
				}
				else if(t <= 0)
				{
					itemStack.stackTagCompound.setInteger("use", 0);
					itemStack.stackTagCompound.setInteger("ticks", tf);
				}
			}
		}
	}
	
	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase livingBase, EntityLivingBase livingBase2)
	{
		if(!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());

			itemStack.stackTagCompound.setInteger("ticks", this.ticks);
			itemStack.stackTagCompound.setInteger("ticksfin", this.ticks);
			itemStack.stackTagCompound.setInteger("use", this.use);
		}	
		
		if(this.proj != null && itemStack.stackTagCompound != null && itemStack.stackTagCompound.getInteger("use") == 0)
		{
			for(int i = 0; i < this.proj.getEntityAttr().length; i++)
			{
				String attr = this.proj.getEntityAttr()[i];
				
				DatabaseEvents.event(attr, livingBase);	
						
				itemStack.stackTagCompound.setInteger("use", 1);
				itemStack.stackTagCompound.setInteger("ticks", this.proj.getItemTicks());	

			}		
		}
		return false;		
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
	
	public Multimap getItemAttributeModifiers()
    {
		Multimap multimap = super.getItemAttributeModifiers();
		for(int i = 0; i < this.proj.getEntityAttr().length; i++)
		{
			if(this.proj.getEntityAttr()[i].contains("sword_"))
			{
				double weaponDamage = Integer.parseInt(this.proj.getEntityAttr()[i].substring(6));
				multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", weaponDamage, 0));  
				return multimap;
			}
		}
		return multimap;
    }
	
	public void addInformation(ItemStack par1, EntityPlayer player, List list, boolean par4) 
	{
		if(Minecraft.getMinecraft().gameSettings.language.equals("ja_JP"))
			list.add(ja_JPSupport.fromKanjiToHiragana(this.getItemStackDisplayName(new ItemStack(this))));
		if(this.proj.getEntityDmg() != 0)
			list.add(EnumChatFormatting.RED + "Damage : " + this.proj.getEntityDmg()); 
		if(this.proj.getItemTicks() != 0)
			list.add(EnumChatFormatting.AQUA + "Cooldown : " + this.proj.getItemTicks()); 	
	}	
	
	public boolean onItemUse(ItemStack item, EntityPlayer player, World par3World, int X, int Y, int Z, int side, float xOffset, float yOffset, float zOffSet)
	{
		return false;
	}
	
}
