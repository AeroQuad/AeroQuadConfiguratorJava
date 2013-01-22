package AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring;

import AeroQuad.configurator.ui.ConfiguratorPanel;
import AeroQuad.configurator.ui.IConfiguratorController;
import AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring.plotdrawer.PlotDrawerPanel;
import AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring.sensorsselectiontree.ISensorsSelectionTree;
import AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring.sensorsselectiontree.SensorsSelectionTree;
import AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring.sensorsselectiontree.TreeSelectionChangeListener;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class SensorsMonitoringPanel extends ConfiguratorPanel implements ISensorsMonitoringPanel
{
    private final ISensorsMonitoringController _controller;

    private final SensorsSelectionTree _sensorsTree = new SensorsSelectionTree();

    private final GridLayout _plotPanelsLayout = new GridLayout(2, 1);
    private final JPanel _plotPanel = new JPanel(_plotPanelsLayout);

    final PlotDrawerPanel _accelPlotDrawerPanel = new PlotDrawerPanel("Accel");
    final PlotDrawerPanel _gyroPlotDrawerPanel = new PlotDrawerPanel("Gyro");
    final PlotDrawerPanel _magPlotDrawerPanel = new PlotDrawerPanel("Magnetometer");

    public SensorsMonitoringPanel(final ISensorsMonitoringController controller)
    {
        _controller = controller;

        _controller.setPanel(this);

        init();
    }

    private void init()
    {
        setLayout(new BorderLayout());

        add(_sensorsTree, BorderLayout.WEST);
        add(_plotPanel);

        _sensorsTree.addSelectionChangeListener(new TreeSelectionChangeListener()
        {
            @Override
            public void selectionChanged(final String key, final boolean selected)
            {
                _controller.selectionChanged(key, selected);
            }
        });

        _plotPanel.add(_gyroPlotDrawerPanel);
        _plotPanel.add(_accelPlotDrawerPanel);

        _sensorsTree.addSelectionChangeListener(new TreeSelectionChangeListener()
        {
            @Override
            public void selectionChanged(final String key, final boolean selected)
            {
                analyseTreeChangedEvent(key, selected);
            }
        });
    }


    @Override
    public IConfiguratorController getController()
    {
        return _controller;
    }

    @Override
    public void setHaveMagnetometer(final boolean value)
    {
        _sensorsTree.setHaveMagnetometer(value);
        if (value)
        {
            _plotPanelsLayout.setRows(3);
            _plotPanel.add(_magPlotDrawerPanel);
        }

    }

    @Override
    public void setGyroX(final String value)
    {
        _gyroPlotDrawerPanel.addXValue(Float.parseFloat(value));
    }

    @Override
    public void setGyroY(final String value)
    {
        _gyroPlotDrawerPanel.addYValue(Float.parseFloat(value));
    }

    @Override
    public void setGyroZ(final String value)
    {
        _gyroPlotDrawerPanel.addZValue(Float.parseFloat(value));
    }

    @Override
    public void setAccelX(final String value)
    {
        _accelPlotDrawerPanel.addXValue(Float.parseFloat(value));
    }

    @Override
    public void setAccelY(final String value)
    {
        _accelPlotDrawerPanel.addYValue(Float.parseFloat(value));
    }

    @Override
    public void setAccelZ(final String value)
    {
        _accelPlotDrawerPanel.addZValue(Float.parseFloat(value));
    }

    @Override
    public void setMagX(final String value)
    {
        _magPlotDrawerPanel.addXValue(Float.parseFloat(value));
    }

    @Override
    public void setMagY(final String value)
    {
        _magPlotDrawerPanel.addYValue(Float.parseFloat(value));
    }

    @Override
    public void setMagZ(final String value)
    {
        _magPlotDrawerPanel.addZValue(Float.parseFloat(value));
    }



    private void analyseTreeChangedEvent(final String key, final boolean selected)
    {
        if (key.equals(ISensorsSelectionTree.GYRO_X_KEY))
        {
            _gyroPlotDrawerPanel.setXVisible(selected);
        }
        else if (key.equals(ISensorsSelectionTree.GYRO_Y_KEY))
        {
            _gyroPlotDrawerPanel.setYVisible(selected);
        }
        else if (key.equals(ISensorsSelectionTree.GYRO_Z_KEY))
        {
            _gyroPlotDrawerPanel.setZVisible(selected);
        }
        else if (key.equals(ISensorsSelectionTree.GYRO_KEY))
        {
            _gyroPlotDrawerPanel.setXVisible(selected);
            _gyroPlotDrawerPanel.setYVisible(selected);
            _gyroPlotDrawerPanel.setZVisible(selected);
        }
        else if (key.equals(ISensorsSelectionTree.ACCEL_X_KEY))
        {
            _accelPlotDrawerPanel.setXVisible(selected);
        }
        else if (key.equals(ISensorsSelectionTree.ACCEL_Y_KEY))
        {
            _accelPlotDrawerPanel.setYVisible(selected);
        }
        else if (key.equals(ISensorsSelectionTree.ACCEL_Z_KEY))
        {
            _accelPlotDrawerPanel.setZVisible(selected);
        }
        else if (key.equals(ISensorsSelectionTree.ACCEL_KEY))
        {
            _accelPlotDrawerPanel.setXVisible(selected);
            _accelPlotDrawerPanel.setYVisible(selected);
            _accelPlotDrawerPanel.setZVisible(selected);
        }
        else if (key.equals(ISensorsSelectionTree.MAG_X_KEY))
        {
            _magPlotDrawerPanel.setXVisible(selected);
        }
        else if (key.equals(ISensorsSelectionTree.MAG_Y_KEY))
        {
            _magPlotDrawerPanel.setYVisible(selected);
        }
        else if (key.equals(ISensorsSelectionTree.MAG_Z_KEY))
        {
            _magPlotDrawerPanel.setZVisible(selected);
        }
        else if (key.equals(ISensorsSelectionTree.MAG_KEY))
        {
            _magPlotDrawerPanel.setXVisible(selected);
            _magPlotDrawerPanel.setYVisible(selected);
            _magPlotDrawerPanel.setZVisible(selected);
        }
        else
        {
            System.err.println("unsuported tree key");
        }
    }

}
