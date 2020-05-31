package structure;

public enum Machete
{
	SKIRMISHER_S_SABRE_WITH_BLOODRAZER("Skirmisher's Sabre with Bloodrazer"),
	SKIRMISHER_S_SABRE_WITH_CINDERHULK("Skirmisher's Sabre with Cinderhulk"),
	SKIRMISHER_S_SABRE_WITH_RUNIC_ECHOES(
			"Skirmisher's Sabre with Runic Echoes"),
	SKIRMISHER_S_SABRE_WITH_WARRIOR("Skirmisher's Sabre with Warrior"),
	STALKER_S_BLADE_WITH_BLOODRAZER("Stalker's Blade with Bloodrazer"),
	STALKER_S_BLADE_WITH_CINDERHULK("Stalker's Blade with Cinderhulk"),
	STALKER_S_BLADE_WITH_RUNIC_ECHOES("Stalker's Blade with Runic Echoes"),
	STALKER_S_BLADE_WITH_WARRIOR("Stalker's Blade with Warrior");

	/**
	 * The base path of all the machete' images' path
	 */
	private static final String PATH = "image\\items\\machete\\";

	/**
	 * The name of the machete
	 */
	private String name;

	/**
	 * The name of the image of the machete
	 */
	private String imgName;

	/**
	 * The complete path of the image of the machete
	 */
	private String imgPath;

	/**
	 * Creates a new machete item
	 * 
	 * @param name : name of the machete
	 */
	private Machete(String name)
	{
		this.name = name;

		this.imgName = getName() + ".png";
		this.imgPath = PATH + imgName;
	}

	/**
	 * Returns the name of the machete
	 * 
	 * @return the name of the machete
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Returns the path of the image of the machete
	 * 
	 * @return the path of the image of the machete
	 */
	public String getImgPath()
	{
		return imgPath;
	}

	/**
	 * Returns the name of the machete
	 * 
	 * @return the name of the machete
	 */
	@Override
	public String toString()
	{
		return getName();
	}

}
