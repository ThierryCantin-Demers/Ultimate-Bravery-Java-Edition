package structure;

public class SummonerSpell
{
	/**
	 * The base path of all the summoner spells' images' path
	 */
	private static final String PATH = "image\\summoner spells\\";

	/**
	 * The name of the summoner spell
	 */
	private String name;

	/**
	 * The list of Map in which you can take the summoner spell
	 */
	private Map[] usableInMaps;

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
	 * @param usableInMap : a list of Map in which you can take the summoner
	 *            spell
	 */
	public SummonerSpell(String name, Map[] usableInMap)
	{
		this.name = name;
		this.usableInMaps = usableInMap;

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
	 * Returns the Map in which you can take the summoner spell
	 * 
	 * @return the Map in which you can take the summoner spell
	 */
	public Map[] usableInMap()
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
