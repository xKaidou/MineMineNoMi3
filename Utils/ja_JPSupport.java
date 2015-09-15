package MineMineNoMi3.Utils;

import net.minecraft.util.EnumChatFormatting;

public class ja_JPSupport 
{

	public static String fromKanjiToHiragana(String name)
	{	
		return EnumChatFormatting.GOLD + name.replace("å®Ÿ", "ã?¿").replace("ç?«æ‹³", "ã?²ã?‘ã‚“").replace("ç?«éŠƒ", "ã?²ã?Œã‚“").replace("å¤§ç‚Žæˆ’ ç‚Žå¸?", "ã? ã?„ã?ˆã‚“ã?‹ã?„ ã?ˆã‚“ã?¦ã?„").replace("ç?«é?”ç£¨", "ã?²ã? ã‚‹ã?¾")
				.replace("é™½ç‚Ž", "ã?‹ã?’ã‚?ã?†").replace("ç‚Žä¸Šç¶²", "ã?ˆã‚“ã?˜ã‚‡ã?†ã‚‚ã?†");
	}
	
}
