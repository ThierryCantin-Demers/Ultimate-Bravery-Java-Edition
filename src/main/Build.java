package main;

import java.util.ArrayList;
import java.util.List;

import structure.Boots;
import structure.Champion;
import structure.Item;
import structure.Machete;
import structure.Map;
import structure.RangeType;
import structure.SummonerSpell;

public class Build
{
	private List<Item> build;
	private List<SummonerSpell> summsToPick;
	private String spellToMax;

	private List<Item> items;
	private Item hexCore;
	private List<Boots> boots;
	private List<Machete> machetes;
	private List<SummonerSpell> summSpells;
	private Champion champion;
	private Map map;

	public Build(Champion champion, Map map)
	{
		this.hexCore = new Item("Perfect Hex Core");

		this.champion = champion;
		this.map = map;

		this.items = InitializeStructure.createItemsArrayList();
		removeItems();

		this.boots = InitializeStructure.createBootsArrayList();
		this.machetes = InitializeStructure.createMacheteArrayList();

		this.summSpells = InitializeStructure.createSummonerSpellArrayList();
		removeSummonerSpells();

		chooseSumms();
		chooseSpell();
		generateBuild();
		// chooseRunes();

	}

	private void removeSummonerSpells()
	{
		List<String> summsToRemove = new ArrayList<>();

		if (this.map.getName().equals("Summoner's Rift"))
		{
			summsToRemove.add("Mark");
			summsToRemove.add("Clarity");
		}
		else
			if (this.map.getName().equals("Howling Abyss"))
			{
				summsToRemove.add("Smite");
				summsToRemove.add("Teleport");
			}
			else
				if (this.map.getName().equals("URF"))
				{
					summsToRemove.add("Smite");
					summsToRemove.add("Teleport");
					summsToRemove.add("Mark");
					summsToRemove.add("Clarity");
				}
	}
	
	private void chooseSumms()
	{
		summsToPick.add(randSumSpell());
		summsToPick.add(randSumSpell());
	}
	
	private void chooseSpell()
	{
		int spellNum = randIndex(0, 3);
		
		switch(spellNum)
		{
			case 0:
				this.spellToMax = "qSpell";
				break;
			case 1: 
				this.spellToMax = "wSpell";
				break;
			case 2:
				this.spellToMax = "eSpell";
		}
	}
	
	
	/**
	 * Removes the items from the possible items for the build from the champion
	 * and the map
	 */
	private void removeItems()
	{
		List<String> itemsToRemove = new ArrayList<>();
		itemsToRemove.addAll(removeItemsFromChampionRangeType());
		itemsToRemove.addAll(removeItemsFromMap());

		this.items.removeIf(item -> (itemsToRemove.contains(item.getName())));
	}

	/**
	 * Returns the items to remove from the items for the build based on the
	 * range type of the champion
	 * 
	 * @return the items to remove from the items for the build based on the
	 *         range type of the champion
	 */
	private ArrayList<String> removeItemsFromChampionRangeType()
	{
		List<String> itemsToRemove = new ArrayList<>();

		if (champion.getRangeType().equals(RangeType.RANGED))
		{
			itemsToRemove.add("Titanic Hydra");
			itemsToRemove.add("Ravenous Hydra");
		}
		else
			if (champion.getRangeType().equals(RangeType.MELEE))
			{
				itemsToRemove.add("Runaan's Hurricane");
			}

		return (ArrayList<String>) itemsToRemove;
	}

	/**
	 * Returns the items to remove from the items for the build based on the map
	 * selected map
	 * 
	 * @return the items to remove from the items for the build based on the map
	 *         selected map
	 */
	private ArrayList<String> removeItemsFromMap()
	{
		List<String> itemsToRemove = new ArrayList<>();

		if (map.getName().equals("Summoner's Rift"))
		{
			itemsToRemove.add("");
		}
		else
			if (map.getName().equals("Howling Abyss"))
			{
				itemsToRemove.add("");
			}
			else
				if (map.getName().equals("URF"))
				{
					itemsToRemove.add("");
				}

		return (ArrayList<String>) itemsToRemove;
	}

	/**
	 * Generates a build of 6 random items (first item is boots if champion has
	 * boots or machete if a summoner spell is smite or a random item if the
	 * champion doesn't have boots or smite, second is hex core if champion has
	 * hex core or machete if champion doesn't have hex core and has smite or a
	 * random item if champion doesn't have hex core or smite, the rest of the
	 * items are all random
	 * 
	 * @return a list of the 6 randomly chosen items
	 */
	public List<Item> generateBuild()
	{
		List<Item> build = new ArrayList<>();

		if (champion.getHasBoots())
		{
			build.add(randBoots());

			if (champion.getHasHexCore())
			{
				build.add(this.hexCore);
				if (summSpells.contains(new SummonerSpell("Smite")))
				{
					build.add(randMachete());
					build.addAll(xRandItem(3));
				}
				else
				{
					build.addAll(xRandItem(4));
				}
			}
			else
				if (summSpells.contains(new SummonerSpell("Smite")))
				{
					build.add(randMachete());
					build.addAll(xRandItem(4));
				}
				else
				{
					build.addAll(xRandItem(5));
				}
		}
		else
			if (summSpells.contains(new SummonerSpell("Smite")))
			{
				build.add(randMachete());
				build.addAll(xRandItem(5));
			}
			else
			{
				build.addAll(xRandItem(6));
			}

		return build;

	}

	private int randIndex(int min, int max)
	{
		return (int) (Math.random() * (max - min) + 1) + min;
	}

	private Item randItem()
	{
		int index = randIndex(0, this.items.size());
		Item item = this.items.remove(index);

		return item;
	}

	private ArrayList<Item> xRandItem(int xItems)
	{
		List<Item> itemsToAdd = new ArrayList<>();

		for (int i = 0; i < xItems; i++)
		{
			itemsToAdd.add(randItem());
		}

		return (ArrayList<Item>) itemsToAdd;
	}

	private Item randBoots()
	{
		int index = randIndex(0, this.boots.size());
		Item boot = this.boots.remove(index);

		return boot;
	}

	private Item randMachete()
	{
		int index = randIndex(0, this.machetes.size());
		Item machete = this.machetes.remove(index);

		return machete;
	}

	private SummonerSpell randSumSpell()
	{
		int index = randIndex(0, this.summSpells.size());

		SummonerSpell summ = this.summSpells.remove(index);

		return summ;
	}
}
