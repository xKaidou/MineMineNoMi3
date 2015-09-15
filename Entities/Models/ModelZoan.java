package MineMineNoMi3.Entities.Models;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import MineMineNoMi3.MainExtendedPlayer;

public class ModelZoan extends ModelBiped
{

	public ModelRenderer bison_nose;
	public ModelRenderer bison_head;
	public ModelRenderer bison_body;
	public ModelRenderer bison_rightarm;
	public ModelRenderer bison_leftarm;
	public ModelRenderer bison_rightleg;
	public ModelRenderer bison_rightlegd;
	public ModelRenderer bison_leftleg;
	public ModelRenderer bison_leftlegd;
	public ModelRenderer bison_horn01;
	public ModelRenderer bison_horn02;
	public ModelRenderer bison_horn11;
	public ModelRenderer bison_horn12;
	public ModelRenderer bison_rightarmd;
	public ModelRenderer bison_leftarmd;
	public ModelRenderer bison_hair;	
	
	public ModelZoan()
	{
	    this.textureWidth = 64;
	    this.textureHeight = 64;
	    
	    this.bison_nose = new ModelRenderer(this, 33, 4);
	    this.bison_nose.addBox(-1.0F, -4.0F, -5.0F, 2, 2, 1);
	    this.bison_nose.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.bison_nose.setTextureSize(64, 64);
	    setRotation(this.bison_nose, 0.0F, 0.0F, 0.0F);    
	    this.bison_head = new ModelRenderer(this, 0, 0);
	    this.bison_head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
	    this.bison_head.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.bison_head.setTextureSize(64, 64);
	    setRotation(this.bison_head, 0.0F, 0.0F, 0.0F);	    
	    this.bison_body = new ModelRenderer(this, 16, 16);
	    this.bison_body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
	    this.bison_body.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.bison_body.setTextureSize(64, 64);
	    setRotation(this.bison_body, 0.0F, 0.0F, 0.0F);    
	    this.bison_rightarm = new ModelRenderer(this, 40, 16);
	    this.bison_rightarm.addBox(-6.0F, -2.0F, -3.0F, 6, 9, 6);
	    this.bison_rightarm.setRotationPoint(-4.0F, 2.0F, 0.0F);
	    this.bison_rightarm.setTextureSize(64, 64);
	    setRotation(this.bison_rightarm, 0.0F, 0.0F, 0.0F);  
	    this.bison_leftarm = new ModelRenderer(this, 40, 16);
	    this.bison_leftarm.addBox(0.0F, -2.0F, -3.0F, 6, 9, 6);
	    this.bison_leftarm.setRotationPoint(4.0F, 2.0F, 0.0F);
	    this.bison_leftarm.setTextureSize(64, 64);
	    setRotation(this.bison_leftarm, 0.0F, 0.0F, 0.0F);    
	    this.bison_rightleg = new ModelRenderer(this, 0, 16);
	    this.bison_rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4);
	    this.bison_rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
	    this.bison_rightleg.setTextureSize(64, 64);
	    setRotation(this.bison_rightleg, 0.0F, 0.0F, 0.0F);   
	    this.bison_rightlegd = new ModelRenderer(this, 0, 24);
	    this.bison_rightlegd.addBox(-2.0F, 4.0F, -1.0F, 4, 8, 4);
	    this.bison_rightlegd.setRotationPoint(-2.0F, 12.0F, 0.0F);
	    this.bison_rightlegd.setTextureSize(64, 64);
	    setRotation(this.bison_rightlegd, 0.0F, 0.0F, 0.0F);    
	    this.bison_leftleg = new ModelRenderer(this, 0, 16);
	    this.bison_leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4);
	    this.bison_leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
	    this.bison_leftleg.setTextureSize(64, 64);
	    setRotation(this.bison_leftleg, 0.0F, 0.0F, 0.0F);    
	    this.bison_leftlegd = new ModelRenderer(this, 0, 24);
	    this.bison_leftlegd.addBox(-2.0F, 4.0F, -1.0F, 4, 8, 4);
	    this.bison_leftlegd.setRotationPoint(2.0F, 12.0F, 0.0F);
	    this.bison_leftlegd.setTextureSize(64, 64);
	    setRotation(this.bison_leftlegd, 0.0F, 0.0F, 0.0F);    
	    this.bison_horn01 = new ModelRenderer(this, 32, 0);
	    this.bison_horn01.addBox(-7.0F, -6.0F, 0.0F, 3, 2, 1);
	    this.bison_horn01.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.bison_horn01.setTextureSize(64, 64);
	    setRotation(this.bison_horn01, 0.0F, 0.0F, 0.0F);	    
	    this.bison_horn02 = new ModelRenderer(this, 32, 0);
	    this.bison_horn02.addBox(-11.0F, 0.2F, 0.0F, 3, 2, 1);
	    this.bison_horn02.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.bison_horn02.setTextureSize(64, 64);
	    setRotation(this.bison_horn02, 0.0F, 0.0F, 0.7679449F);    
	    this.bison_horn11 = new ModelRenderer(this, 32, 0);
	    this.bison_horn11.addBox(4.0F, -6.0F, 0.0F, 3, 2, 1);
	    this.bison_horn11.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.bison_horn11.setTextureSize(64, 64);
	    setRotation(this.bison_horn11, 0.0F, 0.0F, 0.0F);    
	    this.bison_horn12 = new ModelRenderer(this, 32, 0);
	    this.bison_horn12.addBox(8.0F, 0.0F, 0.0F, 3, 2, 1);
	    this.bison_horn12.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.bison_horn12.setTextureSize(64, 64);
	    setRotation(this.bison_horn12, 0.0F, 0.0F, -0.7807508F);	    
	    this.bison_rightarmd = new ModelRenderer(this, 41, 32);
	    this.bison_rightarmd.addBox(-5.0F, 7.0F, -2.5F, 5, 6, 5);
	    this.bison_rightarmd.setRotationPoint(-4.5F, 2.0F, 0.0F);
	    this.bison_rightarmd.setTextureSize(64, 64);
	    setRotation(this.bison_rightarmd, 0.0F, 0.0F, 0.0F);    
	    this.bison_leftarmd = new ModelRenderer(this, 41, 32);
	    this.bison_leftarmd.addBox(0.5F, 7.0F, -2.5F, 5, 6, 5);
	    this.bison_leftarmd.setRotationPoint(4.0F, 2.0F, 0.0F);
	    this.bison_leftarmd.setTextureSize(64, 64);
	    setRotation(this.bison_leftarmd, 0.0F, 0.0F, 0.0F); 
	    this.bison_hair = new ModelRenderer(this, 41, 0);
	    this.bison_hair.addBox(-2.0F, -6.0F, 6.0F, 4, 2, 4);
	    this.bison_hair.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.bison_hair.setTextureSize(64, 64);
	    setRotation(this.bison_hair, 0.3717861F, 0.0F, 0.0F);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*		if(entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;
			MainExtendedPlayer props = MainExtendedPlayer.get(player);
		}*/
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;		
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		this.bison_head.rotateAngleY = (f3 / 57.295776F);
		this.bison_head.rotateAngleX = (f4 / 57.295776F);
		this.bison_nose.rotateAngleY = (f3 / 57.295776F);
		this.bison_nose.rotateAngleX = (f4 / 57.295776F);
		this.bison_horn01.rotateAngleY = (f3 / 57.295776F);
		this.bison_horn01.rotateAngleX = (f4 / 57.295776F);
		this.bison_horn11.rotateAngleY = (f3 / 57.295776F);
		this.bison_horn11.rotateAngleX = (f4 / 57.295776F);
		this.bison_hair.rotateAngleY = (f3 / 57.295776F);
		this.bison_hair.rotateAngleX = (f4 / 57.295776F);	    
		this.bison_leftleg.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 1.0F * f1);
		this.bison_rightleg.rotateAngleX = (MathHelper.cos(f * 0.6662F + 3.141593F) * 1.0F * f1);
		this.bison_leftlegd.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 1.0F * f1);
		this.bison_rightlegd.rotateAngleX = (MathHelper.cos(f * 0.6662F + 3.141593F) * 1.0F * f1);	    
		this.bison_rightarm.rotateAngleX = (MathHelper.cos(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F);
		this.bison_rightarmd.rotateAngleX = (MathHelper.cos(f * 0.6662F + 3.141593F) * 2.0F * f1 * 0.5F);
		this.bison_leftarm.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F);
		this.bison_leftarmd.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F);	
	}
	
}
