package structure;

import java.util.HashMap;

public class Champion
{
	/**
	 * The path for all champion images
	 */
	private static final String PATH = "images\\champions\\";

	/**
	 * The path for the champion's icon
	 */
	private static final String ICON_PATH = PATH + "icon\\";

	/**
	 * The path for the champion's icon
	 */
	private static final String BACKGROUND_PATH = PATH + "background\\";

	/**
	 * The path for the champion's spells
	 */
	private static final String SPELL_PATH = PATH + "spells\\";

	/**
	 * The name of the champion
	 */
	private String name;

	/**
	 * The range type of the champion (ranged, melee or mixed)
	 */
	private RangeType rangeType;

	/**
	 * The complete paths for all of the champion's images
	 */
	private HashMap<String, String> imagePaths;

	/**
	 * The name of the champion's images
	 */
	private String imgName;

	/**
	 * Boolean indicating if the champion is selected or not for the random
	 * champion selection
	 */
	private boolean selected;

	/**
	 * Indicated whether or not the champion will have boots in his build
	 */
	private boolean hasBoots;

	/**
	 * Indicates whether or not the champion will have a hex core in his build
	 */
	private boolean hasHexCore;

	/**
	 * Creates a new champion
	 * 
	 * @param name : The name of the champion
	 * @param range : The range type of the champion
	 */
	public Champion(String name, RangeType rangeType)
	{
		this.name = name;
		this.imgName = getName() + ".png";

		this.rangeType = rangeType;

		this.imagePaths = new HashMap<>();
		setImagePaths();

		this.selected = true;

		setHasBoots();
		setHasHexCore();
	}

	/**
	 * Sets the paths of all of the champion's images
	 */
	private void setImagePaths()
	{
		imagePaths.put("icon", ICON_PATH + imgName);
		imagePaths.put("background", BACKGROUND_PATH + imgName);

		this.imgName = getName() + "Q.png";
		imagePaths.put("qSpell", SPELL_PATH + imgName);

		this.imgName = getName() + "W.png";
		imagePaths.put("wSpell", SPELL_PATH + imgName);

		this.imgName = getName() + "E.png";
		imagePaths.put("eSpell", SPELL_PATH + imgName);
		
		if(getName().equals("Udyr"))
		{
			this.imgName = getName() + "R.png";
			imagePaths.put("rSpell", SPELL_PATH + imgName);
		}
	}

	/**
	 * Returns the name of the champion
	 * 
	 * @return the name of the champion
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Returns the range type of the champion (ranged, melee or mixed)
	 * 
	 * @return the range type of the champion
	 */
	public RangeType getRangeType()
	{
		return rangeType;
	}

	/**
	 * Return a hashmap containing the path of all of the champion's images
	 * 
	 * @return a hashmap containing the path of all of the champion's images
	 */
	public HashMap<String, String> getImagePaths()
	{
		return imagePaths;
	}

	/**
	 * Returns if the chmapion is selected or not for the random champion
	 * selection
	 * 
	 * @return if the chmapion is selected or not for the random champion
	 *         selection
	 */
	public boolean getSelected()
	{
		return this.selected;
	}

	/**
	 * Changes if the champion is selected or not for the random champion
	 * selection
	 * 
	 * @param selected : The new state of the champion's selection
	 */
	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}

	/**
	 * Returns whether or not the champion will have boots in his build
	 * 
	 * @return whether or not the champion will have boots in his build
	 */
	public boolean getHasBoots()
	{
		return this.hasBoots;
	}

	/**
	 * Returns whether or not the champion will have a hex core in his build
	 *
	 * @return whether or not the champion will have a hex core in his build
	 */
	public boolean getHasHexCore()
	{
		return this.hasHexCore;
	}

	/**
	 * Changes whether the champion will have boots or not in his build
	 */
	private void setHasBoots()
	{
		if (getName().equals("Cassiopeia"))
			this.hasBoots = false;
		else
			this.hasBoots = true;
	}

	/**
	 * Changes whether the champion will have a hex core or not in his build
	 */
	private void setHasHexCore()
	{
		if (getName().equals("Viktor"))
			this.hasHexCore = true;
		else
			this.hasHexCore = false;
	}

	/**
	 * Return the attributes of the champion : name, RangeType, selected
	 * 
	 * @return the name of the champion
	 */
	@Override
	public String toString()
	{
		return this.name;
	}
}
