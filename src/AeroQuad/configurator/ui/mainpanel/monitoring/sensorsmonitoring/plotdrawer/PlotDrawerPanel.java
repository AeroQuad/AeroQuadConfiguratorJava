package AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring.plotdrawer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class PlotDrawerPanel extends JPanel
{
    public PlotDrawerPanel()
    {

        setLayout(new BorderLayout());
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        add(chartPanel,BorderLayout.CENTER);
    }

    /**
     * Creates a sample dataset.
     *
     * @return The dataset.
     */
    private CategoryDataset createDataset() {

        // row keys...
        final String series1 = "First";
        final String series2 = "Second";
        final String series3 = "Third";

        // column keys...
        final String type1 = "Type 1";
        final String type2 = "Type 2";
        final String type3 = "Type 3";
        final String type4 = "Type 4";
        final String type5 = "Type 5";
        final String type6 = "Type 6";
        final String type7 = "Type 7";
        final String type8 = "Type 8";

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, series1, type1);
        dataset.addValue(4.0, series1, type2);
        dataset.addValue(3.0, series1, type3);
        dataset.addValue(5.0, series1, type4);
        dataset.addValue(5.0, series1, type5);
        dataset.addValue(7.0, series1, type6);
        dataset.addValue(7.0, series1, type7);
        dataset.addValue(8.0, series1, type8);

        dataset.addValue(5.0, series2, type1);
        dataset.addValue(7.0, series2, type2);
        dataset.addValue(6.0, series2, type3);
        dataset.addValue(8.0, series2, type4);
        dataset.addValue(4.0, series2, type5);
        dataset.addValue(4.0, series2, type6);
        dataset.addValue(2.0, series2, type7);
        dataset.addValue(1.0, series2, type8);

        dataset.addValue(4.0, series3, type1);
        dataset.addValue(3.0, series3, type2);
        dataset.addValue(2.0, series3, type3);
        dataset.addValue(3.0, series3, type4);
        dataset.addValue(6.0, series3, type5);
        dataset.addValue(3.0, series3, type6);
        dataset.addValue(4.0, series3, type7);
        dataset.addValue(3.0, series3, type8);

        return dataset;
    }

    private JFreeChart createChart(final CategoryDataset dataset) {

        // create the chart...
        final JFreeChart chart = ChartFactory.createLineChart(
                "Line Chart Demo 1",       // chart title
                "Type",                    // domain axis label
                "Value",                   // range axis label
                dataset,                   // data
                PlotOrientation.VERTICAL,  // orientation
                true,                      // include legend
                true,                      // tooltips
                false                      // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
//        final StandardLegend legend = (StandardLegend) chart.getLegend();
        //      legend.setDisplaySeriesShapes(true);
        //    legend.setShapeScaleX(1.5);
        //  legend.setShapeScaleY(1.5);
        //legend.setDisplaySeriesLines(true);

        chart.setBackgroundPaint(Color.white);

        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.white);

        // customise the range axis...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);

        // ****************************************************************************
        // * JFREECHART DEVELOPER GUIDE                                               *
        // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
        // * to purchase from Object Refinery Limited:                                *
        // *                                                                          *
        // * http://www.object-refinery.com/jfreechart/guide.html                     *
        // *                                                                          *
        // * Sales are used to provide funding for the JFreeChart project - please    *
        // * support us so that we can continue developing free software.             *
        // ****************************************************************************

        // customise the renderer...
        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
//        renderer.setDrawShapes(true);

        renderer.setSeriesStroke(
                0, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {10.0f, 6.0f}, 0.0f
        )
        );
        renderer.setSeriesStroke(
                1, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {6.0f, 6.0f}, 0.0f
        )
        );
        renderer.setSeriesStroke(
                2, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {2.0f, 6.0f}, 0.0f
        )
        );
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;
    }
}
