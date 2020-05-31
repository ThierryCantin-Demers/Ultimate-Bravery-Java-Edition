package structure;

import java.util.List;

public enum SummonerSpells
{
	BARRIER("Barrier", new Maps[]
	{ Maps.SUMMONERS_RIFT, Maps.HOWLING_ABYSS, Maps.URF }),
	CLARITY("Clarity", new Maps[]
	{ Maps.HOWLING_ABYSS }),
	CLEANSE("Cleanse", new Maps[]
	{ Maps.SUMMONERS_RIFT, Maps.HOWLING_ABYSS, Maps.URF }),
	EXHAUST("Exhaust", new Maps[]
	{ Maps.SUMMONERS_RIFT, Maps.HOWLING_ABYSS, Maps.URF }),
	FLASH("Flash", new Maps[]
	{ Maps.SUMMONERS_RIFT, Maps.HOWLING_ABYSS, Maps.URF }),
	GHOST("Ghost", new Maps[]
	{ Maps.SUMMONERS_RIFT, Maps.HOWLING_ABYSS, Maps.URF }),
	HEAL("Heal", new Maps[]
	{ Maps.SUMMONERS_RIFT, Maps.HOWLING_ABYSS, Maps.URF }),
	IGNITE("Ignite", new Maps[]
	{ Maps.SUMMONERS_RIFT, Maps.HOWLING_ABYSS, Maps.URF }),
	MARK("Mark", new Maps[]
	{ Maps.HOWLING_ABYSS }),
	SMITE("SMITE", new Maps[]
	{ Maps.SUMMONERS_RIFT }),
	TELEPORT("Teleport", new Maps[]
	{ Maps.SUMMONERS_RIFT });

	/**
	 * The base path of all the summoner spells' images' path
	 */
	private static final String PATH = "image\\summoner spells\\";

	/**
	 * The name of the summoner spell
	 */
	private String name;

	/**
	 * The list of maps in which you can take the summoner spell
	 */
	private Maps[] usableInMaps;

	/**
	 * The name of the image of the summoner spell
	 */
	private String imgName;

	/**
	 * The complete path of the image of the summoner spell
	 */
	private String imgPath;

	/**
	 * Creates a new summoner spell
	 * 
	 * @param name : name of the summoner spell
	 * @param usableInMaps : a list of maps in which you can take the summoner
	 *            spell
	 */
	private SummonerSpells(String name, Maps[] usableInMaps)
	{
		this.name = name;
		this.usableInMaps = usableInMaps;

		this.imgName = getName() + ".png";
		this.imgPath = PATH + imgName;
	}

	/**
	 * Returns the name of the summoner spell
	 * 
	 * @return the name of the summoner spell
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Returns the maps in which you can take the summoner spell
	 * 
	 * @return the maps in which you can take the summoner spell
	 */
	public Maps[] usableInMaps()
	{
		return usableInMaps;
	}

	/**
	 * Returns the path of the image of the summoner spell
	 * 
	 * @return the path of the image of the summoner spell
	 */
	public String getImgPath()
	{
		return imgPath;
	}

	/**
	 * Returns the name of the summoner spell
	 * 
	 * @return the name of the summoner spell
	 */
	@Override
	public String toString()
	{
		return getName();
	}

}
