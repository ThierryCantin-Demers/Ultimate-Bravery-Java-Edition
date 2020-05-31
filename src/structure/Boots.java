package structure;

public enum Boots
{
	BERSERKER_S_GREAVES("Berserker's Greaves"),
	BOOTS_OF_MOBILITY("Boots of Mobility"),
	BOOTS_OF_SWIFTNESS("Boots of Swiftness"),
	IONIAN_S_BOOTS_OF_LUCIDITY("Ionian's Boots of Lucidity"),
	MERCURY_S_TREADS("Mercury's Treads"),
	NINJA_TABI("Ninja Tabi"),
	SORCERER_S_SHOES("Sorcerer's Shoes");

	/**
	 * The base path of all the boots' images' path
	 */
	private static final String PATH = "image\\items\\boots\\";

	/**
	 * The name of the boots
	 */
	private String name;

	/**
	 * The name of the image of the boots
	 */
	private String imgName;

	/**
	 * The complete path of the image of the boots
	 */
	private String imgPath;

	/**
	 * Creates a new boot item
	 * 
	 * @param name : name of the boots
	 */
	private Boots(String name)
	{
		this.name = name;

		this.imgName = getName() + ".png";
		this.imgPath = PATH + imgName;
	}

	/**
	 * Returns the name of the boots
	 * 
	 * @return the name of the boots
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Returns the path of the image of the boots
	 * 
	 * @return the path of the image of the boots
	 */
	public String getImgPath()
	{
		return imgPath;
	}

	/**
	 * Returns the name of the boots
	 * 
	 * @return the name of the boots
	 */
	@Override
	public String toString()
	{
		return getName();
	}

}
