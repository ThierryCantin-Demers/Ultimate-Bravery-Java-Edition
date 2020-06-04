package structure;

public class Rune
{
	
	/**
	 * Path of the runes' images
	 */
	private String PATH = "images\\runes\\";

	/**
	 * Name of the rune
	 */
	private String name;

	/**
	 * Name of the image of the rune
	 */
	private String imgName;

	/**
	 * Path of the image of the rune
	 */
	private String imgPath;
	

	/**
	 * Creates a new rune
	 * 
	 * @param name : name of the rune
	 * @param rangeType : range type of the rune
	 */
	public Rune(String name)
	{
		
		this.name = name;
		this.imgName = name + ".png";
		setPath(PATH);
	}

	/**
	 * Sets the path of the rune's image
	 */
	protected void setPath(String path)
	{
		this.imgPath = path + imgName;
	}

	/**
	 * Returns the path of the rune's image
	 * 
	 * @return the path of the rune's image
	 */
	public String getImgPath()
	{
		return this.imgPath;
	}

	/**
	 * Returns the name of the rune
	 * 
	 * @return the name of the rune
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Returns the name of the image of the rune
	 * 
	 * @return the name of the image of the rune
	 */
	public String getImgName()
	{
		return this.imgName;
	}

	/**
	 * Returns the name of the rune
	 * 
	 * @return the name of the rune
	 */
	@Override
	public String toString()
	{
		return getName();
	}
	
	
}
