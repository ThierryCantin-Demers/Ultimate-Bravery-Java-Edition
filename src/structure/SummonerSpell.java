package structure;

public class SummonerSpell
{
	/**
	 * The base path of all the summoner spells' images' path
	 */
	private static final String PATH = "images\\summoner spells\\";

	/**
	 * The name of the summoner spell
	 */
	private String name;

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
	public SummonerSpell(String name)
	{
		this.name = name;

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
	 * Returns the path of the image of the summoner spell
	 * 
	 * @return the path of the image of the summoner spell
	 */
	public String getImgPath()
	{
		return imgPath;
	}

	
	@Override
	public boolean equals(Object o)
	{
		boolean equal = false;
		
		if(o instanceof SummonerSpell)
		{
			SummonerSpell summSpell = (SummonerSpell) o;
			
			if(this.getName().equals(summSpell.getName()))
			{
				equal = true;
			}
		}

		return equal;
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
