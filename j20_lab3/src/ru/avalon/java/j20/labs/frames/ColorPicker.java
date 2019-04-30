package ru.avalon.java.j20.labs.frames;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class ColorPicker extends AbstractFrame {

    private final JPanel colorPanel = new JPanel(); // панель отображения цвета
    private final JPanel sliderPanel = new JPanel(); // панель ползунков и подписей

    private final JLabel redLabel = new JLabel("Red:");
    private final JSlider redSlider = new JSlider(0, 255, 125);

    private final JLabel greenLabel = new JLabel("Green:");
    private final JSlider greenSlider = new JSlider(0, 255, 125);

    private final JLabel blueLabel = new JLabel("Blue:");
    private final JSlider blueSlider = new JSlider(0, 255, 125);

    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    @Override
    protected void onCreate() {
        setTitle("Color Picker");
        setSize(500, 250);
        setLayout(new GridLayout(1, 2));

        add(createColorPanel());
        add(createSliderPanel());

        redSlider.addChangeListener(this::onSliderChange);
        greenSlider.addChangeListener(this::onSliderChange);
        blueSlider.addChangeListener(this::onSliderChange);

        updateColor();
    }

    private JPanel createColorPanel() {
        colorPanel.setLayout(new BorderLayout());
        colorPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        colorPanel.setBackground(new Color(redSlider.getX(), greenSlider.getX(), blueSlider.getX()));

        return colorPanel;
    }

    private JPanel createSliderPanel() {
        sliderPanel.setLayout(new GridLayout(3, 1));
        sliderPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        sliderPanel.setBackground(Color.WHITE);

        JPanel redPanel = new JPanel(new GridLayout(1, 1));
        redPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        redPanel.setBackground(Color.WHITE);
        redPanel.add(redLabel);
        redPanel.add(redSlider);
        redSlider.setBackground(Color.WHITE);
        redSlider.setPaintLabels(true);
        redSlider.setMajorTickSpacing(255);
        sliderPanel.add(redPanel);

        JPanel greenPanel = new JPanel(new GridLayout(1, 1));
        greenPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        greenPanel.setBackground(Color.WHITE);
        greenPanel.add(greenLabel);
        greenPanel.add(greenSlider);
        greenSlider.setBackground(Color.WHITE);
        greenSlider.setPaintLabels(true);
        greenSlider.setMajorTickSpacing(255);
        sliderPanel.add(greenPanel);

        JPanel bluePanel = new JPanel(new GridLayout(1, 1));
        bluePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        bluePanel.setBackground(Color.WHITE);
        bluePanel.add(blueLabel);
        bluePanel.add(blueSlider);
        blueSlider.setBackground(Color.WHITE);
        blueSlider.setPaintLabels(true);
        blueSlider.setMajorTickSpacing(255);
        sliderPanel.add(bluePanel);

        return sliderPanel;
    }

    private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, selection);
    }

    private void updateColor() {
        colorPanel.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
        String hex = "#" + Integer.toHexString(colorPanel.getBackground().getRGB()).substring(2).toUpperCase();
        colorPanel.setToolTipText(hex);
        copyToClipboard(hex);
    }

    private void onSliderChange(ChangeEvent e) {
        updateColor();
    }

}
