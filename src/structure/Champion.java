package structure;

public class Champion
{
	private Champions champion;
	private boolean selected;
	
	
	public Champion(Champions champion)
	{
		setChampion(champion);
		setSelected(true);
	}
	
	public Champions getChampion()
	{
		return this.champion;
	}
	
	private void setChampion(Champions champion)
	{
		this.champion = champion;
	}
	
	public boolean getSelected()
	{
		return this.selected;
	}
	
	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}
	
}
