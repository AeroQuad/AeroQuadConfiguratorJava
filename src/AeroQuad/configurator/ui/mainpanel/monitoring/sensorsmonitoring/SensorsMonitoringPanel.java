package AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring;

import AeroQuad.configurator.ui.ConfiguratorPanel;
import AeroQuad.configurator.ui.IConfiguratorController;
import AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring.plotdrawer.PlotDrawerPanel;
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

        _plotPanel.add(new PlotDrawerPanel());
        _plotPanel.add(new PlotDrawerPanel());
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
    }

}
