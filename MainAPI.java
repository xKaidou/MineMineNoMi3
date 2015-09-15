package MineMineNoMi3;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.minecraft.client.model.ModelBase;
import net.minecraft.item.Item;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import MineMineNoMi3.Items.Ability;
import MineMineNoMi3.Items.AkumaNoMi;
import MineMineNoMi3.Lists.ListDevilFruits;
import MineMineNoMi3.Utils.AbilityAttribute;
import MineMineNoMi3.Utils.EnumFruitType;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class MainAPI 
{

	public static void init(FMLPreInitializationEvent event)
	{
		File folder = new File(event.getModConfigurationDirectory()+"\\Custom Devil Fruits");
		File[] files = folder.listFiles(new FilenameFilter() 
		{
		    public boolean accept(File dir, String name) 
		    {
		        return name.contains("nomi") && name.endsWith("xml");
		    }
		});
		
		File devilFruitXML = null;
		List<Ability> abilities = new ArrayList();
		Ability ability = null;
		AkumaNoMi akumaNoMi = null;	
		
		String fruitName = null;
		EnumFruitType fruitType = null;
		
		String abilityName = null;
		String abilityType = null;
		int damage = 0;
		int cooldown = 0;
		int explosion = 0;								
		String model = null;
		
		String projType = null;
		int projSize = 0;
		String projColor = null;
		
		String effectType = null;
		int effectDuration = 0;
		int effectPower = 0;	
		
		for(int i = 0; i < files.length; i++)
		{
			devilFruitXML = files[i];		
		
			if(devilFruitXML != null)
			{
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = null;
				Document doc = null;
				try {
					dBuilder = dbFactory.newDocumentBuilder();
					doc = dBuilder.parse(devilFruitXML);
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				}
				
				doc.getDocumentElement().normalize();
				
				NodeList nodeListFruit = doc.getElementsByTagName("devilfruit");				
				for (int j = 0; j < nodeListFruit.getLength(); j++) 
				{
					Node nodeFruit = nodeListFruit.item(j);		
					if (nodeFruit.getNodeType() == Node.ELEMENT_NODE) 
					{
						NodeList nodeListAbility = doc.getElementsByTagName("ability");						
						for (int k = 0; k < nodeListAbility.getLength(); k++) 
						{
							Node nodeAbility = nodeListAbility.item(k);
							if (nodeAbility.getNodeType() == Node.ELEMENT_NODE) 
							{
								Element elementFruit = (Element) nodeFruit;
								Element elementAbility = (Element) nodeAbility;

								fruitName = elementFruit.getElementsByTagName("fruitname").item(0).getTextContent();
								fruitType = fruitType(elementFruit.getElementsByTagName("fruittype").item(0).getTextContent());
									
								abilityName = elementAbility.getElementsByTagName("abilityname").item(0).getTextContent();
								abilityType = elementAbility.getElementsByTagName("abilitytype").item(0).getTextContent();
								damage = Integer.parseInt(elementAbility.getElementsByTagName("damage").item(0).getTextContent());
								cooldown = Integer.parseInt(elementAbility.getElementsByTagName("cooldown").item(0).getTextContent());
								explosion = Integer.parseInt(elementAbility.getElementsByTagName("explosion").item(0).getTextContent());								
								
								if(abilityType.equals("Projectile"))
								{
									projType = elementAbility.getElementsByTagName("projtype").item(0).getTextContent();
									projSize = Integer.parseInt(elementAbility.getElementsByTagName("projsize").item(0).getTextContent());
									projColor = elementAbility.getElementsByTagName("projcolor").item(0).getTextContent();
									model = elementAbility.getElementsByTagName("model").item(0).getTextContent();
								}
								else if(abilityType.equals("Effect"))
								{
									effectType = elementAbility.getElementsByTagName("effecttype").item(0).getTextContent();
									effectDuration = Integer.parseInt(elementAbility.getElementsByTagName("effectduration").item(0).getTextContent());
									effectPower = Integer.parseInt(elementAbility.getElementsByTagName("effectpower").item(0).getTextContent());
								}

								ability = new Ability(new AbilityAttribute(cooldown, damage, 60, projColor, getModel(model), new double[] {projSize, projSize, projSize}, null));		
								ListDevilFruits.addITEM(ability, abilityName);
								abilities.add(ability);		

								akumaNoMi = new AkumaNoMi(fruitType, new Item[] {abilities.get(0), abilities.get(1), abilities.get(2)});
								ListDevilFruits.addITEM(akumaNoMi, fruitName, false);
							}
						}
					}
				}
			}	
		}				
	}
	
	private static Ability check(Ability ability)
	{
		if(ability == null)
			return null;
		else
			return ability;
	}
	
	private static EnumFruitType fruitType(String type)
	{
		if(type.toLowerCase().equals("logia"))
			return EnumFruitType.ARTIFICIALLOGIA;
		else if(type.toLowerCase().equals("paramecia"))
			return EnumFruitType.ARTIFICIALPARAM;
		else if(type.toLowerCase().equals("zoan"))
			return EnumFruitType.ARTIFICIALZOAN;
		else
			return null;
	}

	private static ModelBase getModel(String model)
	{
		return null;	
	}
}
