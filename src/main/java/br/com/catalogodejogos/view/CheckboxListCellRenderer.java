package br.com.catalogodejogos.view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CheckboxListCellRenderer extends JCheckBox implements ListCellRenderer{
    private final Map<Integer, Boolean> checkboxStates;

    public CheckboxListCellRenderer(Map<Integer, Boolean> checkboxStates) {
        this.checkboxStates = checkboxStates;
    }


    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        setComponentOrientation(list.getComponentOrientation());
        setFont(list.getFont());
        setBackground(list.getBackground());
        setForeground(list.getForeground());
        setSelected(isSelected);
        setEnabled(list.isEnabled());
        setText(value == null ? "" : ((JCheckBox)value).getText());
        return this;
    }
}
