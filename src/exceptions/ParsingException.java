package exceptions;

public class ParsingException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8616923615911681164L;

	public ParsingException()
	{
		super();
	}
	
	public ParsingException(String message)
	{
		super(message);
	}
}
