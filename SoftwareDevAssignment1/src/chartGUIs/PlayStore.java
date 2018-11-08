package chartGUIs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class PlayStore {


	static ChartPanel piePanel;
	static ChartPanel barPanel;
	static boolean validated = false;
	
	public static void main(String[] args) throws IOException {

		DefaultPieDataset pie = getPaid();
		JFreeChart pieChart = ChartFactory.createPieChart("Free Apps", pie, true, true, true);
		PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0}: {1}%", new DecimalFormat("0"), new DecimalFormat("0"));
		PiePlot plot1 = (PiePlot) pieChart.getPlot();
		plot1.setLabelGenerator(labelGenerator);
		System.out.println("Test");
		try {
			piePanel = new ChartPanel(pieChart);
			System.out.println("Pie Chart Created");
		} catch (Exception e) {
			System.out.println("Problemo");
		}
		
		DefaultCategoryDataset bar = getContentRating();

		JFreeChart barChart = ChartFactory.createBarChart3D("Content Ratings", "Rating", "Number", 
				bar, PlotOrientation.VERTICAL, true, true, false);
		try {
			barPanel = new ChartPanel(barChart);
			System.out.println("Bar Chart Created");
		} catch (Exception e) {
			System.out.println("Problemo");
		}
		
		new MainFrame();
	} // End of main

	// This needs to be redone from scratch
	public static DefaultPieDataset getPaid() {
		int free = 0;
		int paid = 0;
		int total = 0;
		BufferedReader br;
		DefaultPieDataset pie = null;

		try {
			br = new BufferedReader(new FileReader("data\\googleplaystore.csv"));
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				if(i == 0) {
					i++;
				} else {
					total++;
					String[] linearray = line.split(",");
					if (linearray[6].equals("Free")) {
						free++;
					} else if (linearray[6].equals("Paid")) {
						paid++;
					} else {
						throw new RuntimeException("Unexpected Value in Type List");
					}
					pie = new DefaultPieDataset();
					pie.setValue("Free", (double)free/total*(100/1));
					pie.setValue("Paid", (double)paid/total*(100/1));
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return pie;
	} // End of getPaid
	
	public static DefaultCategoryDataset getContentRating() {
		int adultsOnly18 = 0;
		int everyone = 0;
		int everyone10 = 0;
		int mature17 = 0;
		int teen = 0;
		int unrated = 0;
		
		BufferedReader br;
		DefaultCategoryDataset barData = null;
		
		try {
			br = new BufferedReader(new FileReader("data\\googleplaystore.csv"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] linearray = line.split(",");
				if (linearray[8].equals("Adults only 18")) {
					adultsOnly18++;
				} else if (linearray[8].equals("Everyone 10")) {
					everyone10++;
				} else if (linearray[8].equals("Everyone")) {
					everyone++;
				} else if (linearray[8].equals("Mature 17")) {
					mature17++;
				} else if (linearray[8].equals("Teen")) {
					teen++;
				} else if (linearray[8].equals("Unrated")) {
					unrated++;
				}
			}
			barData = new DefaultCategoryDataset();
			barData.setValue(adultsOnly18, "Content Rating", "Adults Only");
			barData.setValue(everyone10, "Content Rating", "Everyone 10");
			barData.setValue(everyone, "Content Rating", "Everyone");
			barData.setValue(mature17, "Content Rating", "Mature 17");
			barData.setValue(teen, "Content Rating", "Teen");
			barData.setValue(unrated, "Content Rating", "Unrated");
			
		} catch (Exception e) {
			System.out.println("Problemo2");
		}
		return barData;
	} // End of getContentRating
	
	public static class MainFrame extends JFrame implements ActionListener {
		JFrame background = new JFrame("Charting Assignment");
		
		JPanel display = new JPanel();
		JPanel navbar = new JPanel();
		
		JRadioButton fvp = new JRadioButton("Free vs Paid Apps");
		JRadioButton types = new JRadioButton("App Content Types");
		JLabel pic = new JLabel();
		
		public MainFrame() throws IOException {
			super();
			background.setLayout(new BorderLayout());
			background.add(navbar, BorderLayout.NORTH);
			
			navbar.setLayout(new FlowLayout());
			navbar.add(fvp);
			navbar.add(types);
			fvp.setSelected(true);
			
			background.add(piePanel, BorderLayout.CENTER);
			display.add(pic);
			
			background.setSize(800,600);
			background.setVisible(true);
			
			fvp.addActionListener(this);
			types.addActionListener(this);
		} // End of MainFrame method
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(fvp)) {
				if(validated != true) {
					background.invalidate();
					background.remove(barPanel);
					background.add(barPanel, BorderLayout.CENTER);
					background.revalidate();
					types.setSelected(false);
					validated = true;
				} else {
					background.invalidate();
					background.remove(barPanel);
					background.add(piePanel, BorderLayout.CENTER);
					background.repaint();
					types.setSelected(false);
				}
			} else if(e.getSource().equals(types)) {
				if(validated != true) {
					background.invalidate();
					background.remove(piePanel);
					background.add(barPanel, BorderLayout.CENTER);
					background.revalidate();
					fvp.setSelected(false);
					validated = true;
				} else {
					background.invalidate();
					background.remove(piePanel);
					background.add(barPanel, BorderLayout.CENTER);
					background.repaint();
					fvp.setSelected(false);
				}
			}
		}
	}
}
