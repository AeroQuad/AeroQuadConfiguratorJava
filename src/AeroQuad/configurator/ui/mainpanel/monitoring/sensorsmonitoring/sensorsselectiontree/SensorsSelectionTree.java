package AeroQuad.configurator.ui.mainpanel.monitoring.sensorsmonitoring.sensorsselectiontree;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorsSelectionTree extends JTree implements ISensorsSelectionTree
{
    private final String ROOT_STRING_NAME = "Aeroquad";
    final DefaultMutableTreeNode _root = new DefaultMutableTreeNode(ROOT_STRING_NAME);
    final DefaultTreeModel _treeModel = new DefaultTreeModel(_root);

    final Map<String, Boolean> _selectionMap = new HashMap<>(1);
    final List<TreeSelectionChangeListener> _selectionListenerList = new ArrayList<>(1);

    public SensorsSelectionTree()
    {
        init();
    }

    private void init()
    {
        final DefaultMutableTreeNode gyro = new DefaultMutableTreeNode("Gyro");
        gyro.add(new DefaultMutableTreeNode("X"));
        gyro.add(new DefaultMutableTreeNode("Y"));
        gyro.add(new DefaultMutableTreeNode("Z"));
        _root.add(gyro);

        final DefaultMutableTreeNode accel = new DefaultMutableTreeNode("Accel");
        accel.add(new DefaultMutableTreeNode("X"));
        accel.add(new DefaultMutableTreeNode("Y"));
        accel.add(new DefaultMutableTreeNode("Z"));
        _root.add(accel);


        setModel(_treeModel);

        getSelectionModel().setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);

        expandAllNode();

        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(final MouseEvent e)
            {
                final TreePath selPath = getPathForLocation(e.getX(), e.getY());
                if (selPath != null)
                {
                    switchSelection(selPath.toString());
                    repaint();
                }
            }
        });
    }

    @Override
    public TreeCellRenderer getCellRenderer()
    {
        return new CellRenderer();
    }

    public void setHaveMagnetometer(final boolean value)
    {
        if (value)
        {
            final DefaultMutableTreeNode mag = new DefaultMutableTreeNode("Magnetometer");
            mag.add(new DefaultMutableTreeNode("X"));
            mag.add(new DefaultMutableTreeNode("Y"));
            mag.add(new DefaultMutableTreeNode("Z"));
            _treeModel.insertNodeInto(mag,_root,_root.getChildCount());
            expandAllNode();
        }
    }

    private void expandAllNode()
    {
        for (int i = 0; i < getRowCount(); i++)
        {
            expandRow(i);
        }
    }

    private class CellRenderer implements TreeCellRenderer
    {

        @Override
        public Component getTreeCellRendererComponent(final JTree tree,
                                                      final Object value,
                                                      final boolean selected,
                                                      final boolean expanded,
                                                      final boolean leaf,
                                                      final int row,
                                                      final boolean hasFocus)
        {

            if (value.equals(ROOT_STRING_NAME))
            {
                return new JLabel(value.toString());
            }


            if (tree.getPathForRow(row) != null &&
                    tree.getPathForRow(row).toString().contains(ROOT_STRING_NAME))
            {
                if (!_selectionMap.containsKey(tree.getPathForRow(row).toString()))
                {
                    _selectionMap.put(tree.getPathForRow(row).toString(), true);
                }
            }

            final JCheckBox renderer = new JCheckBox(value.toString());
            renderer.setSelected(selected);

            boolean isSelected = selected;
            if (tree.getPathForRow(row) != null &&
                    _selectionMap != null &&
                    _selectionMap.containsKey(tree.getPathForRow(row).toString()))
            {
                isSelected = _selectionMap.get(tree.getPathForRow(row).toString());
            }
            renderer.setSelected(isSelected);
            return renderer;
        }
    }

    private void switchSelection(final String key)
    {
        if (_selectionMap.containsKey(key))
        {
            boolean selected = _selectionMap.get(key);
            _selectionMap.put(key, !selected);
            notifySelectionChanged(key, !selected);

            final String searchKey = key.replace(']', ',');
            for (final String tempKey : _selectionMap.keySet())
            {
                if (tempKey.contains(searchKey))
                {
                    _selectionMap.put(tempKey, !selected);
                    notifySelectionChanged(key, !selected);
                }
            }
        }
    }

    private void notifySelectionChanged(final String key, final boolean selected)
    {
        for (final TreeSelectionChangeListener listener : _selectionListenerList)
        {
            listener.selectionChanged(key, selected);
        }
    }

    public void addSelectionChangeListener(final TreeSelectionChangeListener listener)
    {
        _selectionListenerList.add(listener);
    }
}
