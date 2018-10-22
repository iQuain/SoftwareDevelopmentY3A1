package NestedGUIs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NestedGUIs {

	public static class MainFrame extends JFrame {
		
		// This is our background frame to hold the other GUIs
					JFrame BackgroundFrame = new JFrame("Nested GUI Assignment");
					
					// Area for adding buttons
					// ButtonGrid Buttons
					JButton ButtonGrid1 = new JButton("ButtonGrid 1");
					JButton ButtonGrid2 = new JButton("ButtonGrid 2");
					JButton ButtonGrid3 = new JButton("ButtonGrid 3");
					JButton ButtonGrid4 = new JButton("ButtonGrid 4");
					JButton ButtonGrid5 = new JButton("ButtonGrid 5");
					JButton ButtonGrid6 = new JButton("ButtonGrid 6");
					
					// BoxLayout Buttons
					JButton BoxLayout1 = new JButton("BoxButton 1");
					JButton BoxLayout2 = new JButton("BoxButton 2");
					JButton BoxLayout3 = new JButton("BoxButton 3");
					JButton BoxLayout4 = new JButton("BoxButton 4");
					JButton BoxLayout5 = new JButton("BoxButton 5");
					JButton BoxLayout6 = new JButton("BoxButton 6");
					
					// BorderLayout Buttons
					JButton BorderLayout1 = new JButton("BorderButton 1");
					JButton BorderLayout2 = new JButton("BorderButton 2");
					JButton BorderLayout3 = new JButton("BorderButton 3");
					JButton BorderLayout4 = new JButton("BorderButton 4");
					JButton BorderLayout5 = new JButton("BorderButton 5");
					JButton BorderLayout6 = new JButton("BorderButton 6");
					
					// FlowLayout Buttons
					JButton FlowLayout1 = new JButton("FlowButton 1");
					JButton FlowLayout2 = new JButton("FlowButton 2");
					JButton FlowLayout3 = new JButton("FlowButton 3");
					JButton FlowLayout4 = new JButton("FlowButton 4");
					JButton FlowLayout5 = new JButton("FlowButton 5");
					JButton FlowLayout6 = new JButton("FlowButton 6");
					JButton FlowLayout7 = new JButton("FlowButton 7");
					JButton FlowLayout8 = new JButton("FlowButton 8");
					JButton FlowLayout9 = new JButton("FlowButton 9");
					JButton FlowLayout10 = new JButton("FlowButton 10");
					JButton FlowLayout11 = new JButton("FlowButton 11");
					JButton FlowLayout12 = new JButton("FlowButton 12");
					
					// GridBag Buttons
					JButton GridBag1 = new JButton("GridBagButton 1");
					JButton GridBag2 = new JButton("GridBagButton 2");
					JButton GridBag3 = new JButton("GridBagButton 3");
					JButton GridBag4 = new JButton("GridBagButton 4");
					JButton GridBag5 = new JButton("GridBagButton 5");
					JButton GridBag6 = new JButton("GridBagButton 6");
					
					// TopTopSplit Buttons
					JButton TopTop1 = new JButton("These Are In");
					JButton TopTop2 = new JButton("The Top Half");
					
					// BottomTopSplit Buttons
					JButton BottomTop1 = new JButton("These Are In");
					JButton BottomTop2 = new JButton("The Bottom Half");
					
					// BottomSplitPanel Buttons
					JButton BottomSplit1 = new JButton("However, ");
					JButton BottomSplit2 = new JButton("This Is");
					JButton BottomSplit3 = new JButton("In Thirds");
					
					// GridLayout Panel
					JPanel ButtonGrid = new JPanel();
					
					// BoxLayout Panel
					JPanel BoxLayoutPanel = new JPanel();
					
					// BorderLayout Panel
					JPanel BorderLayoutPanel = new JPanel();
					
					// FlowLayout Panel
					JPanel FlowLayoutPanel = new JPanel();
					
					// GridBag Panel
					JPanel GridBagLayoutPanel = new JPanel();
					
					// Split Panel
					JPanel SplitPanel = new JPanel();
					
					// Top Split
					JPanel TopSplitPanel = new JPanel();
					
					// Bottom Split
					JPanel BottomSplitPanel = new JPanel();
					
					// Top Top Split
					JPanel TopTopSplit = new JPanel();
					
					// Bottom Top Split
					JPanel BottomTopSplit = new JPanel();
		
		public MainFrame() {
			ButtonGrid.setBackground(Color.CYAN);
			BoxLayoutPanel.setBackground(Color.GREEN);
			FlowLayoutPanel.setBackground(Color.BLACK);
			GridBagLayoutPanel.setBackground(Color.YELLOW);
			SplitPanel.setBackground(Color.WHITE);
			TopSplitPanel.setBackground(Color.PINK);
			BottomSplitPanel.setBackground(Color.ORANGE);
			TopTopSplit.setBackground(Color.CYAN);
			BottomTopSplit.setBackground(Color.RED);
			
			BackgroundFrame.setLayout(new GridLayout(3,2));
			
			ButtonGrid.add(ButtonGrid1);
			ButtonGrid.add(ButtonGrid2);
			ButtonGrid.add(ButtonGrid3);
			ButtonGrid.add(ButtonGrid4);
			ButtonGrid.add(ButtonGrid5);
			ButtonGrid.add(ButtonGrid6);
			ButtonGrid.setLayout(new GridLayout(3,3));
			
			BoxLayoutPanel.setLayout(new BoxLayout(
					BoxLayoutPanel, BoxLayout.Y_AXIS));
			BoxLayout1.setAlignmentX(Component.CENTER_ALIGNMENT);
			BoxLayoutPanel.add(BoxLayout1);
			BoxLayout2.setAlignmentX(Component.LEFT_ALIGNMENT);
			BoxLayoutPanel.add(BoxLayout2);
			BoxLayout3.setAlignmentX(Component.RIGHT_ALIGNMENT);
			BoxLayoutPanel.add(BoxLayout3);
			BoxLayout4.setAlignmentX(Component.CENTER_ALIGNMENT);
			BoxLayoutPanel.add(BoxLayout4);
			BoxLayout5.setAlignmentX(Component.BOTTOM_ALIGNMENT);
			BoxLayoutPanel.add(BoxLayout5);
			BoxLayout6.setAlignmentX(Component.TOP_ALIGNMENT);
			BoxLayoutPanel.add(BoxLayout6);
			
			BorderLayoutPanel.setLayout(new BorderLayout());
			BorderLayoutPanel.add(BorderLayout1, BorderLayout.CENTER);
			BorderLayoutPanel.add(BorderLayout2, BorderLayout.NORTH);
			BorderLayoutPanel.add(BorderLayout3, BorderLayout.SOUTH);
			BorderLayoutPanel.add(BorderLayout4, BorderLayout.EAST);
			BorderLayoutPanel.add(BorderLayout5, BorderLayout.WEST);
			
			FlowLayoutPanel.setLayout(new FlowLayout());
			FlowLayoutPanel.add(FlowLayout1);
			FlowLayoutPanel.add(FlowLayout2);
			FlowLayoutPanel.add(FlowLayout3);
			FlowLayoutPanel.add(FlowLayout4);
			FlowLayoutPanel.add(FlowLayout5);
			FlowLayoutPanel.add(FlowLayout6);
			FlowLayoutPanel.add(FlowLayout7);
			FlowLayoutPanel.add(FlowLayout8);
			FlowLayoutPanel.add(FlowLayout9);
			FlowLayoutPanel.add(FlowLayout10);
			FlowLayoutPanel.add(FlowLayout11);
			FlowLayoutPanel.add(FlowLayout12);
			
			GridBagLayout gb = new GridBagLayout();
			GridBagConstraints c = new GridBagConstraints();
			GridBagLayoutPanel.setLayout(gb);
			c.fill = GridBagConstraints.HORIZONTAL;
			
			c.gridx = 0;
			c.gridy = 0;
			gb.setConstraints(GridBag1, c);
			GridBagLayoutPanel.add(GridBag1);
			c.gridx = 0;
			c.gridy = 1;
			gb.setConstraints(GridBag2, c);
			GridBagLayoutPanel.add(GridBag2);
			c.gridx = 0;
			c.gridy = 2;
			gb.setConstraints(GridBag3, c);
			GridBagLayoutPanel.add(GridBag3);
			c.gridx = 1;
			c.gridy = 1;
			gb.setConstraints(GridBag4, c);
			GridBagLayoutPanel.add(GridBag4);
			c.gridx = 2;
			c.gridy = 0;
			gb.setConstraints(GridBag5, c);
			GridBagLayoutPanel.add(GridBag5);
			c.gridx = 2;
			c.gridy = 2;
			gb.setConstraints(GridBag6, c);
			GridBagLayoutPanel.add(GridBag6);
			
			SplitPanel.setLayout(new GridLayout(2,1));
			
			TopSplitPanel.setLayout(new GridLayout(2,1));
			TopTopSplit.setLayout(new GridLayout(1,2));
			TopTopSplit.add(TopTop1);
			TopTopSplit.add(TopTop2);
			
			TopSplitPanel.add(TopTopSplit);
			
			BottomTopSplit.setLayout(new GridLayout(1,2));
			BottomTopSplit.add(BottomTop1);
			BottomTopSplit.add(BottomTop2);
			TopSplitPanel.add(BottomTopSplit);
			SplitPanel.add(TopSplitPanel);
			
			BottomSplitPanel.setLayout(new GridLayout(1,3));
			BottomSplitPanel.add(BottomSplit1);
			BottomSplitPanel.add(BottomSplit2);
			BottomSplitPanel.add(BottomSplit3);
			SplitPanel.add(BottomSplitPanel);
			
			BackgroundFrame.add(ButtonGrid);
			BackgroundFrame.add(BoxLayoutPanel);
			BackgroundFrame.add(BorderLayoutPanel);
			BackgroundFrame.add(FlowLayoutPanel);
			BackgroundFrame.add(GridBagLayoutPanel);
			BackgroundFrame.add(SplitPanel);
			
			BackgroundFrame.setSize(1366,768);
			BackgroundFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			BackgroundFrame.setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		MainFrame myMainFrame = new MainFrame();
	}

}
