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
	static ChartPanel installPanel;
	static ChartPanel pricePanel;
	static boolean validated = false;

	public static void main(String[] args) throws IOException {

		DefaultPieDataset pie = getPaid();
		JFreeChart pieChart = ChartFactory.createPieChart("Free vs Paid Apps", pie, true, true, true);
		PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0}: {1}%",
				new DecimalFormat("0"), new DecimalFormat("0"));
		PiePlot plot1 = (PiePlot) pieChart.getPlot();
		plot1.setLabelGenerator(labelGenerator);
		System.out.println("Test");
		try {
			piePanel = new ChartPanel(pieChart);
			System.out.println("Pie Chart Created");
		} catch (Exception e) {
			System.out.println("Problemo");
		}

		DefaultCategoryDataset installBar = getInstallInfo();

		JFreeChart installChart = ChartFactory.createBarChart3D("Installs Comparisons", "Rating", "Number", installBar,
				PlotOrientation.VERTICAL, true, true, false);
		try {
			installPanel = new ChartPanel(installChart);
			System.out.println("Install Chart Created");
		} catch (Exception e) {
			System.out.println(e);
		}

		DefaultCategoryDataset priceBar = getPriceInfo();

		JFreeChart priceChart = ChartFactory.createBarChart3D("Price Comparisons", "Rating", "Number", priceBar,
				PlotOrientation.VERTICAL, true, true, false);
		try {
			pricePanel = new ChartPanel(priceChart);
			System.out.println("Price Chart Created");
		} catch (Exception e) {
			System.out.println(e);
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
				if (i == 0) {
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
					pie.setValue("Free", (double) free / total * (100 / 1));
					pie.setValue("Paid", (double) paid / total * (100 / 1));
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return pie;
	} // End of getPaid

	public static DefaultCategoryDataset getInstallInfo() {

		int maxReviews = 0;
		int minReviews = 5000;
		int avgReviews = 0;
		int count = 0;

		String maxReviewsName = "";
		String minReviewsName = "";

		BufferedReader br;
		DefaultCategoryDataset barData = null;

		try {
			br = new BufferedReader(new FileReader("data\\googleplaystore.csv"));
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] linearray = line.split(",");

				if (i == 0) {
					i++;
				} else {
					if (Integer.parseInt(linearray[3]) > maxReviews) {
						maxReviews = Integer.parseInt(linearray[3]);
						maxReviewsName = linearray[0];
						avgReviews += Integer.parseInt(linearray[3]);
						count++;
					} else if (Integer.parseInt(linearray[3]) < minReviews) {
						minReviews = Integer.parseInt(linearray[3]);
						minReviewsName = linearray[0];
						avgReviews += Integer.parseInt(linearray[3]);
						count++;
					} else {
						avgReviews += Integer.parseInt(linearray[3]);
						count++;
					}
				}
			}

			avgReviews = avgReviews / count;

			barData = new DefaultCategoryDataset();
			barData.setValue(minReviews, "Installs", "Minimum: " + minReviewsName);
			barData.setValue(maxReviews, "Installs", "Maximum: " + maxReviewsName);
			barData.setValue(avgReviews, "Installs", "Average");

		} catch (Exception e) {
			System.out.println(e);
		}
		return barData;
	} // End of getInstallInfo

	public static DefaultCategoryDataset getPriceInfo() {

		double maxPrice = 0;
		double minPrice = 10;
		double avgPrice = 0;

		int count = 0;

		String maxPriceName = "";
		String minPriceName = "";

		BufferedReader br;
		DefaultCategoryDataset barData = null;

		try {
			br = new BufferedReader(new FileReader("data\\googleplaystore.csv"));
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] linearray = line.split(",");

				if (i == 0) {
					i++;
				} else {
					if (Double.parseDouble(linearray[7]) > maxPrice) {
						maxPrice = Double.parseDouble(linearray[7]);
						maxPriceName = linearray[0];
						avgPrice += Double.parseDouble(linearray[7]);
						count++;
					} else if (Double.parseDouble(linearray[7]) < minPrice) {
						minPrice = Double.parseDouble(linearray[7]);
						minPriceName = linearray[0];
						avgPrice += Double.parseDouble(linearray[7]);
						count++;
					} else {
						avgPrice += Double.parseDouble(linearray[7]);
						count++;
					}
				}
			}

			avgPrice = avgPrice / count;

			barData = new DefaultCategoryDataset();
			barData.setValue(minPrice, "Price", "Minimum: " + minPriceName);
			barData.setValue(maxPrice, "Price", "Maximum: " + maxPriceName);
			barData.setValue(avgPrice, "Price", "Average");

		} catch (Exception e) {
			System.out.println(e);
		}
		return barData;

	} // End of getPriceInfo

	public static class MainFrame extends JFrame implements ActionListener {
		JFrame background = new JFrame("Charting Assignment");

		JPanel display = new JPanel();
		JPanel navbar = new JPanel();

		JRadioButton fvp = new JRadioButton("Free vs Paid Apps");
		JRadioButton install = new JRadioButton("App Install Info");
		JRadioButton price = new JRadioButton("App Price Info");

		public MainFrame() throws IOException {
			super();
			background.setLayout(new BorderLayout());
			background.add(navbar, BorderLayout.NORTH);

			navbar.setLayout(new FlowLayout());
			navbar.add(fvp);
			navbar.add(install);
			navbar.add(price);
			fvp.setSelected(true);

			background.add(piePanel, BorderLayout.CENTER);

			background.setSize(800, 600);
			background.setVisible(true);

			fvp.addActionListener(this);
			install.addActionListener(this);
			price.addActionListener(this);
		} // End of MainFrame method

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(fvp)) {
				if (validated != true) {
					background.invalidate();
					background.remove(installPanel);
					background.remove(pricePanel);
					background.add(installPanel, BorderLayout.CENTER);
					background.revalidate();
					install.setSelected(false);
					price.setSelected(false);
					validated = true;
				} else {
					background.invalidate();
					background.remove(installPanel);
					background.remove(pricePanel);
					background.add(piePanel, BorderLayout.CENTER);
					background.revalidate();
					background.repaint();
					install.setSelected(false);
					price.setSelected(false);
				}
			} else if (e.getSource().equals(install)) {
				if (validated != true) {
					background.invalidate();
					background.remove(piePanel);
					background.remove(pricePanel);
					background.add(installPanel, BorderLayout.CENTER);
					background.revalidate();
					fvp.setSelected(false);
					price.setSelected(false);
					validated = true;
				} else {
					background.invalidate();
					background.remove(piePanel);
					background.remove(pricePanel);
					background.add(installPanel, BorderLayout.CENTER);
					background.revalidate();
					background.repaint();
					fvp.setSelected(false);
					price.setSelected(false);
				}
			} else if (e.getSource().equals(price)) {
				if (validated != true) {
					background.invalidate();
					background.remove(piePanel);
					background.remove(installPanel);
					background.add(pricePanel, BorderLayout.CENTER);
					background.revalidate();
					fvp.setSelected(false);
					install.setSelected(false);
					validated = true;
				} else {
					background.invalidate();
					background.remove(piePanel);
					background.remove(installPanel);
					background.add(pricePanel, BorderLayout.CENTER);
					background.revalidate();
					background.repaint();
					fvp.setSelected(false);
					install.setSelected(false);
				}
			}
		}
	}
}
