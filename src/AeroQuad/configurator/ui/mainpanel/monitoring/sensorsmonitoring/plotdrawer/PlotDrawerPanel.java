package AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring.plotdrawer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DefaultXYItemRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class PlotDrawerPanel extends JPanel
{
    private TimeSeries xSeries = new TimeSeries("X");
    private TimeSeries ySeries = new TimeSeries("Y");
    private TimeSeries zSeries = new TimeSeries("Z");

    public PlotDrawerPanel(final String sensorName)
    {
        init(sensorName);
    }

    private void init(final String sensorName)
    {
        setLayout(new BorderLayout());

        final TimeSeriesCollection xTimeSeriesCollection = new TimeSeriesCollection(xSeries);
        final TimeSeriesCollection yTimeSeriesCollection = new TimeSeriesCollection(ySeries);
        final TimeSeriesCollection zTimeSeriesCollection = new TimeSeriesCollection(zSeries);

        final JFreeChart chart = ChartFactory.createTimeSeriesChart(sensorName, "Time", "Value", xTimeSeriesCollection, true, true, false);

        final XYPlot xyplot = (XYPlot) chart.getPlot();
        final ValueAxis valueaxis = xyplot.getDomainAxis();
        valueaxis.setFixedAutoRange(15000);
        valueaxis.setAxisLineStroke(new BasicStroke(3));
        xyplot.setDataset(1, yTimeSeriesCollection);
        final DefaultXYItemRenderer yItemRenderer = new DefaultXYItemRenderer();
        yItemRenderer.setBaseShapesVisible(false);
        xyplot.setRenderer(1, yItemRenderer);

        xyplot.setDataset(2, zTimeSeriesCollection);
        final DefaultXYItemRenderer zItemRenderer = new DefaultXYItemRenderer();
        zItemRenderer.setBaseShapesVisible(false);
        xyplot.setRenderer(2, zItemRenderer);

        final ChartPanel chartpanel = new ChartPanel(chart);
        chartpanel.setPreferredSize(new Dimension(0, 250));
        add(chartpanel);
    }

    public void addXValue(final float xValue)
    {
        xSeries.addOrUpdate(new Millisecond(), xValue);
    }

    public void addYValue(final float yValue)
    {
        ySeries.addOrUpdate(new Millisecond(), yValue);
    }

    public void addZValue(final float zValue)
    {
        zSeries.addOrUpdate(new Millisecond(), zValue);
    }
}
