package structure;

public class Item
{
	/**
	 * Path of the items' images
	 */
	private static String PATH = "images\\items\\";

	/**
	 * Name of the item
	 */
	private String name;

	/**
	 * Name of the image of the item
	 */
	private String imgName;

	/**
	 * Path of the image of the item
	 */
	private String imgPath;

	/**
	 * Creates a new item
	 * 
	 * @param name : name of the item
	 * @param rangeType : range type of the item
	 */
	private Item(String name)
	{
		this.name = name;
		this.imgName = name = ".png";
		setPath();
	}

	/**
	 * Sets the path of the item's image
	 */
	private void setPath()
	{
		this.imgPath = PATH + imgName;
	}

	/**
	 * Returns the path of the item's image
	 * 
	 * @return the path of the item's image
	 */
	public String getImgPath()
	{
		return this.imgPath;
	}

	/**
	 * Returns the name of the item
	 * 
	 * @return the name of the item
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Returns the name of the item
	 * 
	 * @return the name of the item
	 */
	@Override
	public String toString()
	{
		return getName();
	}
}
