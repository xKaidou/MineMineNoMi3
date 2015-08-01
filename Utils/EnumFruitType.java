package MineMineNoMi3.Utils;

import net.minecraft.util.EnumChatFormatting;

public enum EnumFruitType 
{

	PARAMECIA		(EnumChatFormatting.RED			, "Paramecia"),
	LOGIA			(EnumChatFormatting.YELLOW		, "Logia"),
	MYTHICALZOAN	(EnumChatFormatting.AQUA		, "Mythical Zoan"),
	ANCIENTZOAN		(EnumChatFormatting.GREEN		, "Ancient Zoan"),
	ARTIFICIALZOAN	(EnumChatFormatting.LIGHT_PURPLE, "Artificial Zoan"),
	ZOAN			(EnumChatFormatting.GREEN		, "Zoan");
	
	private EnumChatFormatting color;
	private String name;
	
	private EnumFruitType(EnumChatFormatting color, String name)
	{
		this.color = color;
		this.name = name;
	}
	
	public EnumChatFormatting getColor()
	{
		return color;		
	}
	
	public String getName()
	{
		return name;
	}
}
