package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import exceptions.ParsingException;
import structure.Champion;
import structure.Map;

@SuppressWarnings("serial")
public class Launcher extends JFrame
{
	private ArrayList<Champion> champions;
	private ArrayList<Map> maps;
	private JToggleButton[] championsButtons;
	private ArrayList<JRadioButton> mapsButtons;
	private ArrayList<String> champsNames;
	private ArrayList<JToggleButton> championsButtonsToShow;

	private JFrame championSelect;
	private JFrame buildDisplay;
	private JSplitPane championSelectSplitPane;
	private JScrollPane championsButtonsArea;
	private JPanel championsButtonsPanel;
	private ButtonGroup mapsButtonsGroup;
	private JPanel thingToInclude;

	private JFrame currentFrame;

	Font font = new Font("Dialog", Font.PLAIN, 20);

	public static void main(String[] args) throws ParsingException, IOException
	{
		new Launcher();
	}

	public Launcher() throws ParsingException, IOException
	{
		// JFrame.setDefaultLookAndFeelDecorated(true);

		// Preparation
		champions = InitializeStructure.createChampionsArrayList();
		maps = InitializeStructure.createMapsArrayList();
		champsNames = new ArrayList<>();
		for (Champion champ : champions)
		{
			champsNames.add(champ.getName());
		}

		championsButtons = new JToggleButton[champions.size()];
		championsButtonsToShow = new ArrayList<>();
		mapsButtons = new ArrayList<>();

		thingToInclude = new JPanel(new GridLayout(3, 0, 0, 0));
		
		JLabel thingToInclude1 = new JLabel("Ultimate Bravery - Java Edition isn't endorsed by Riot Games and doesn't reflect the views or opinions of");
		JLabel thingToInclude2 = new JLabel("Riot Games or anyone officially involved in producing or managing League of Legends. League of Legends and");
		JLabel thingToInclude3 = new JLabel("Riot Games are trademarks or registered trademarks of Riot Games, Inc. League of Legends © Riot Games, Inc.");

		
		thingToInclude.add(thingToInclude1);
		thingToInclude.add(thingToInclude2);
		thingToInclude.add(thingToInclude3);
				
		championSelect = new JFrame("Ultimate Bravery");

		championSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		JLabel label = new JLabel("Bonjour");

		panel.add(label);

		ImageIcon icon = new ImageIcon("images\\Ultimate Bravery Logo.png");
		championSelect.setIconImage(icon.getImage());

		championsButtonsArea = championButtonsPanel();

		championSelectSplitPane = championSelectDivider(championsButtonsArea,
				mapsAreaPanel());
		championSelect.getContentPane().add(championSelectSplitPane);

		currentFrame = championSelect;

		currentFrame.setSize(920, 720);

		currentFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		championSelectSplitPane
				.setDividerLocation(championSelect.getWidth() / 2);

		currentFrame.setVisible(true);
	}

	public JScrollPane championButtonsPanel() throws IOException
	{
		JPanel champsArea = new JPanel();

		champsArea.setLayout(new GridLayout(0, 20, 2, 2));

		int i = 0;

		for (Champion champion : champions)
		{
			ImageIcon img = new ImageIcon(champion.getImagePaths().get("icon"));
			BufferedImage grayScale = ImageIO
					.read(new File(champion.getImagePaths().get("icon")));

			ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
			ColorConvertOp op = new ColorConvertOp(cs, null);
			BufferedImage image = op.filter(grayScale, null);

			ImageIcon imgGrayScale = new ImageIcon(image);

			JToggleButton button = new JToggleButton(img, true);

			button.setIcon(imgGrayScale);
			button.setSelectedIcon(img);
			button.setBorder(BorderFactory.createEmptyBorder());

			button.setToolTipText("<html><p><font size=\"15\">"
					+ champion.getName() + "</font></p></html>");

			button.setName(champion.getName());

			championsButtons[i++] = button;
			championsButtonsToShow.add(button);
		}

		for (Component button : championsButtons)
		{
			champsArea.add(button);
		}

		championsButtonsPanel = champsArea;

		JScrollPane scrollChampsArea = new JScrollPane(champsArea);

		return scrollChampsArea;
	}

	public JPanel mapsAreaPanel()
	{
		JPanel mapsArea = new JPanel(new BorderLayout());

		JTextField searchBar = new JTextField();

		mapsButtonsGroup = new ButtonGroup();
		JPanel mapsPanel = new JPanel(new GridLayout(0, 1, 1, 1));

		JPanel selectDeselectButtons = new JPanel(new GridLayout(0, 1, 1, 1));

		JButton selectButton = new JButton("Select All");
		JButton deselectButton = new JButton("Deselect All");

		selectButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				for (JToggleButton button : championsButtons)
				{
					button.setSelected(true);
				}

			}
		});

		deselectButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				for (JToggleButton button : championsButtons)
				{
					button.setSelected(false);
				}

			}
		});

		selectDeselectButtons.add(selectButton);
		selectDeselectButtons.add(deselectButton);

		JButton generateBuildButton = new JButton("Create Build");

		generateBuildButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					generateBuild();

					currentFrame.dispose();

					currentFrame = buildDisplay;

					currentFrame.setSize(920, 720);

					currentFrame.setVisible(true);
				}
				catch (ParsingException e1)
				{
					System.exit(0);
				}

			}
		});

		int i = 0;

		for (Map map : maps)
		{
			JRadioButton button = new JRadioButton(map.getName());
			if (i++ == 0)
			{
				button.setSelected(true);
			}
			else
			{
				button.setSelected(false);
			}

			button.setVisible(true);
			button.setSize(10, 10);
			button.setFont(new Font("Dialog", Font.PLAIN, 20));

			button.setActionCommand(map.getName());

			mapsButtons.add(button);
			mapsButtonsGroup.add(button);
			mapsPanel.add(button);
		}

		searchBar.setText("Search champion name");
		searchBar.setFont(font);

		searchBar.addKeyListener(new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
			}

			@Override
			public void keyTyped(KeyEvent e)
			{

			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				for (Component button : championsButtons)
				{
					if (button.getName().toLowerCase()
							.startsWith(searchBar.getText().toLowerCase()))
					{
						championsButtonsPanel.add(button);
					}
					else
					{
						championsButtonsPanel.remove(button);
					}
				}

				championsButtonsArea.revalidate();
				championsButtonsArea.repaint();

			}
		});

		mapsArea.add(searchBar, BorderLayout.NORTH);

		mapsArea.add(mapsPanel, BorderLayout.EAST);

		mapsArea.add(selectDeselectButtons, BorderLayout.WEST);
		mapsArea.add(generateBuildButton, BorderLayout.CENTER);
		mapsArea.add(thingToInclude, BorderLayout.SOUTH);

		return mapsArea;

	}

	public JSplitPane championSelectDivider(Component champsArea,
			JPanel mapsArea)
	{

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				champsArea, mapsArea);
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);

		// splitPane.setDividerLocation(championSelect.getWidth() / 2);
		splitPane.setDividerSize(1);

		setDividerLocation(splitPane, 0.5);
		splitPane.setResizeWeight(0.5);

		return splitPane;
	}

	private void generateChampionSelectFrame()
	{
		currentFrame.dispose();

		currentFrame = championSelect;

		currentFrame.setSize(920, 720);

		championSelectSplitPane
				.setDividerLocation(championSelect.getWidth() / 2);

		currentFrame.setVisible(true);
	}

	private void generateBuild() throws ParsingException
	{
		ArrayList<Champion> championsForRandomBuild = InitializeStructure
				.createChampionsArrayList();

		JPanel buildPanel = new JPanel(new GridLayout(5, 10, 5, 5));

		ArrayList<String> champsStringForRandom = new ArrayList<>();

		for (JToggleButton button : championsButtons)
		{
			if (!button.isSelected())
			{
				champsStringForRandom.add(button.getName());
			}
		}

		championsForRandomBuild.removeIf(champion -> (champsStringForRandom
				.contains(champion.getName())));

		Champion champion = null;

		if (!championsForRandomBuild.isEmpty())
		{
			champion = championsForRandomBuild
					.get(Build.randIndex(0, championsForRandomBuild.size()));
		}
		else
		{
			championsForRandomBuild = InitializeStructure
					.createChampionsArrayList();

			champion = championsForRandomBuild
					.get(Build.randIndex(0, championsForRandomBuild.size()));
		}

		Map map = new Map(mapsButtonsGroup.getSelection().getActionCommand());

		Build build = new Build(champion, map);

		buildDisplay = new JFrame("Build");

		buildDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel itemsPanel = new JPanel();

		ImageIcon itemIcon1 = new ImageIcon(
				build.getBuild().get(0).getImgPath());
		JLabel item1 = new JLabel(itemIcon1);

		ImageIcon itemIcon2 = new ImageIcon(
				build.getBuild().get(1).getImgPath());
		JLabel item2 = new JLabel(itemIcon2);

		ImageIcon itemIcon3 = new ImageIcon(
				build.getBuild().get(2).getImgPath());
		JLabel item3 = new JLabel(itemIcon3);

		ImageIcon itemIcon4 = new ImageIcon(
				build.getBuild().get(3).getImgPath());
		JLabel item4 = new JLabel(itemIcon4);

		ImageIcon itemIcon5 = new ImageIcon(
				build.getBuild().get(4).getImgPath());
		JLabel item5 = new JLabel(itemIcon5);

		ImageIcon itemIcon6 = new ImageIcon(
				build.getBuild().get(5).getImgPath());
		JLabel item6 = new JLabel(itemIcon6);

		JPanel champAndSpellPanel = new JPanel();

		ImageIcon championImage = new ImageIcon(
				champion.getImagePaths().get("icon"));
		JLabel championLabel = new JLabel(championImage);

		ImageIcon spellImage = new ImageIcon(
				champion.getImagePaths().get(build.getSpellToMax()));
		JLabel spell = new JLabel(spellImage);

		item1.setToolTipText("<html><p><font size=\"15\">" + build.getBuild().get(0).getName() + "</font></p></html>");
		item2.setToolTipText("<html><p><font size=\"15\">" + build.getBuild().get(1).getName() + "</font></p></html>");
		item3.setToolTipText("<html><p><font size=\"15\">" + build.getBuild().get(2).getName() + "</font></p></html>");
		item4.setToolTipText("<html><p><font size=\"15\">" + build.getBuild().get(3).getName() + "</font></p></html>");
		item5.setToolTipText("<html><p><font size=\"15\">" + build.getBuild().get(4).getName() + "</font></p></html>");
		item6.setToolTipText("<html><p><font size=\"15\">" + build.getBuild().get(5).getName() + "</font></p></html>");

		spell.setToolTipText(
				String.valueOf(build.getSpellToMax().charAt(0)).toUpperCase());
		
		championLabel.setToolTipText("<html><p><font size=\"15\">" + champion.getName() + "</font></p></html>");
		spell.setToolTipText("<html><p><font size=\"15\">" + String.valueOf(build.getSpellToMax().charAt(0)).toUpperCase() + "</font></p></html>");
		
		champAndSpellPanel.add(championLabel);
		champAndSpellPanel.add(spell);

		ImageIcon summonerSpellImage1 = new ImageIcon(
				build.getSummonerSpellsToPick().get(0).getImgPath());
		JLabel summonerSpell1 = new JLabel(summonerSpellImage1);

		ImageIcon summonerSpellImage2 = new ImageIcon(
				build.getSummonerSpellsToPick().get(1).getImgPath());
		JLabel summonerSpell2 = new JLabel(summonerSpellImage2);

		JPanel summonerSpells = new JPanel();
		
		summonerSpell1.setToolTipText("<html><p><font size=\"15\">" + 
				build.getSummonerSpellsToPick().get(0).getName() + "</font></p></html>");
		summonerSpell2.setToolTipText("<html><p><font size=\"15\">" + 
				build.getSummonerSpellsToPick().get(1).getName() + "</font></p></html>");
		
		summonerSpells.add(summonerSpell1);
		summonerSpells.add(summonerSpell2);

		JPanel runesPanel = new JPanel();

		JPanel mainRunes = new JPanel();

		ImageIcon keystoneImage = new ImageIcon(
				build.getRunePage().getKeystone().getImgPath());
		JLabel keystone = new JLabel(new ImageIcon(keystoneImage.getImage()
				.getScaledInstance(128, 128, Image.SCALE_SMOOTH)));

		ImageIcon mainRuneImage1 = new ImageIcon(
				build.getRunePage().getMainMinorRunes().get(0).getImgPath());
		JLabel mainRune1 = new JLabel(new ImageIcon(mainRuneImage1.getImage()
				.getScaledInstance(64, 64, Image.SCALE_SMOOTH)));

		ImageIcon mainRuneImage2 = new ImageIcon(
				build.getRunePage().getMainMinorRunes().get(1).getImgPath());
		JLabel mainRune2 = new JLabel(new ImageIcon(mainRuneImage2.getImage()
				.getScaledInstance(64, 64, Image.SCALE_SMOOTH)));

		ImageIcon mainRuneImage3 = new ImageIcon(
				build.getRunePage().getMainMinorRunes().get(2).getImgPath());
		JLabel mainRune3 = new JLabel(new ImageIcon(mainRuneImage3.getImage()
				.getScaledInstance(64, 64, Image.SCALE_SMOOTH)));

		keystone.setToolTipText("<html><p><font size=\"15\">" + build.getRunePage().getKeystone().getName() + "</font></p></html>");
		mainRune1.setToolTipText("<html><p><font size=\"15\">" + 
				build.getRunePage().getMainMinorRunes().get(0).getName() + "</font></p></html>");
		mainRune2.setToolTipText("<html><p><font size=\"15\">" + 
				build.getRunePage().getMainMinorRunes().get(1).getName() + "</font></p></html>");
		mainRune3.setToolTipText("<html><p><font size=\"15\">" + 
				build.getRunePage().getMainMinorRunes().get(2).getName() + "</font></p></html>");

		mainRunes.add(keystone);
		mainRunes.add(mainRune1);
		mainRunes.add(mainRune2);
		mainRunes.add(mainRune3);

		runesPanel.add(mainRunes);
		// runesPanel.add(mainRune1);
		// runesPanel.add(mainRune2);
		// runesPanel.add(mainRune3);

		JPanel secondaryRunes = new JPanel();

		ImageIcon secondaryRuneImage1 = new ImageIcon(build.getRunePage()
				.getSecondaryMinorRunes().get(0).getImgPath());
		JLabel secondaryRune1 = new JLabel(new ImageIcon(secondaryRuneImage1
				.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));

		ImageIcon secondaryRuneImage2 = new ImageIcon(build.getRunePage()
				.getSecondaryMinorRunes().get(1).getImgPath());
		JLabel secondaryRune2 = new JLabel(new ImageIcon(secondaryRuneImage2
				.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));

		secondaryRune1.setToolTipText("<html><p><font size=\"15\">" + 
				build.getRunePage().getSecondaryMinorRunes().get(0).getName() + "</font></p></html>");
		secondaryRune2.setToolTipText("<html><p><font size=\"15\">" + 
				build.getRunePage().getSecondaryMinorRunes().get(1).getName() + "</font></p></html>");

		secondaryRunes.add(secondaryRune1);
		secondaryRunes.add(secondaryRune2);

		runesPanel.add(secondaryRunes);
		// runesPanel.add(secondaryRune2);

		JPanel statRunes = new JPanel();

		ImageIcon statRuneImage1 = new ImageIcon(
				build.getRunePage().getStatRunes().get(0).getImgPath());
		JLabel statRune1 = new JLabel(statRuneImage1);

		ImageIcon statRuneImage2 = new ImageIcon(
				build.getRunePage().getStatRunes().get(1).getImgPath());
		JLabel statRune2 = new JLabel(statRuneImage2);

		ImageIcon statRuneImage3 = new ImageIcon(
				build.getRunePage().getStatRunes().get(2).getImgPath());
		JLabel statRune3 = new JLabel(statRuneImage3);

		statRune1.setToolTipText("<html><p><font size=\"15\">" + 
				build.getRunePage().getStatRunes().get(0).getName() + "</font></p></html>");
		statRune2.setToolTipText("<html><p><font size=\"15\">" + 
				build.getRunePage().getStatRunes().get(1).getName() + "</font></p></html>");
		statRune3.setToolTipText("<html><p><font size=\"15\">" + 
				build.getRunePage().getStatRunes().get(2).getName() + "</font></p></html>");

		statRunes.add(statRune1);
		statRunes.add(statRune2);
		statRunes.add(statRune3);

		runesPanel.add(statRunes);
		// runesPanel.add(statRune2);
		// runesPanel.add(statRune3);

		itemsPanel.add(item1);
		itemsPanel.add(item2);
		itemsPanel.add(item3);
		itemsPanel.add(item4);
		itemsPanel.add(item5);
		itemsPanel.add(item6);

		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				generateChampionSelectFrame();

			}
		});

		// 1
		buildPanel.add(champAndSpellPanel);

		// 2
		buildPanel.add(itemsPanel);

		// 3
		buildPanel.add(summonerSpells);

		// 4
		buildPanel.add(runesPanel);

		// //5
		// buildPanel.add(new JPanel());
		//
		// //6
		// buildPanel.add(new JPanel());

		// 7
		buildPanel.add(backButton);

		buildDisplay.getContentPane().add(buildPanel);
		buildDisplay.setExtendedState(JFrame.MAXIMIZED_BOTH);

		System.out.println(build);
	}

	public static void setDividerLocation(final JSplitPane splitter,
			final double proportion)
	{
		if (splitter.isShowing())
		{
			if ((splitter.getWidth() > 0) && (splitter.getHeight() > 0))
			{
				splitter.setDividerLocation(proportion);
			}
			else
			{
				splitter.addComponentListener(new ComponentAdapter()
				{
					@Override
					public void componentResized(ComponentEvent ce)
					{
						splitter.removeComponentListener(this);
						setDividerLocation(splitter, proportion);
					}
				});
			}
		}
		else
		{
			splitter.addHierarchyListener(new HierarchyListener()
			{
				@Override
				public void hierarchyChanged(HierarchyEvent e)
				{
					if (((e.getChangeFlags()
							& HierarchyEvent.SHOWING_CHANGED) != 0)
							&& splitter.isShowing())
					{
						splitter.removeHierarchyListener(this);
						setDividerLocation(splitter, proportion);
					}
				}
			});
		}
	}

}