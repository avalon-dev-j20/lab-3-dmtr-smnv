package ru.avalon.java.j20.labs.frames;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Calculator extends AbstractFrame {

    private final JPanel screen = new JPanel();
    private JLabel screenLabel = new JLabel("0");

    private final JPanel numpadLine1 = new JPanel();
    private final JPanel numpadLine2 = new JPanel();
    private final JPanel numpadLine3 = new JPanel();
    private final JPanel numpadLine4 = new JPanel();
    private final JButton numZero = new JButton("0");
    private final JButton numOne = new JButton("1");
    private final JButton numTwo = new JButton("2");
    private final JButton numThree = new JButton("3");
    private final JButton numFour = new JButton("4");
    private final JButton numFive = new JButton("5");
    private final JButton numSix = new JButton("6");
    private final JButton numSeven = new JButton("7");
    private final JButton numEight = new JButton("8");
    private final JButton numNine = new JButton("9");
    private final JButton numPoint = new JButton(".");
    private final JButton numCE = new JButton("CE");
    private final JButton numPlus = new JButton("+");
    private final JButton numMinus = new JButton("-");
    private final JButton numMultiply = new JButton("*");
    private final JButton numDivide = new JButton("/");

    private final JPanel equal = new JPanel();
    private final JButton numEqual = new JButton("=");

    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    private StringBuilder buffer = new StringBuilder(); // хранит вводимые цифры

    @Override
    protected void onCreate() {
        setTitle("Calculator");
        setSize(new Dimension(300, 400));
        setLayout(new GridLayout(6, 1, 5, 5));

        add(createScreen());
        add(createNumpadLine1());
        add(createNumpadLine2());
        add(createNumpadLine3());
        add(createNumpadLine4());
        add(createEqual());

        numZero.addActionListener(this::onNumPressed);
        numOne.addActionListener(this::onNumPressed);
        numTwo.addActionListener(this::onNumPressed);
        numThree.addActionListener(this::onNumPressed);
        numFour.addActionListener(this::onNumPressed);
        numFive.addActionListener(this::onNumPressed);
        numSix.addActionListener(this::onNumPressed);
        numSeven.addActionListener(this::onNumPressed);
        numEight.addActionListener(this::onNumPressed);
        numNine.addActionListener(this::onNumPressed);
        numPoint.addActionListener(this::onPointPressed);
        numCE.addActionListener(this::onCEPressed);
        numPlus.addActionListener(this::onPlusPressed);
        numMinus.addActionListener(this::onMinusPressed);
        numMultiply.addActionListener(this::onMultiplyPressed);
        numDivide.addActionListener(this::onDividePressed);

        updateScreen();
    }

    private JPanel createScreen() {
        screen.setLayout(new BorderLayout());
        screen.add(screenLabel, BorderLayout.LINE_END);

        return screen;
    }

    private JPanel createNumpadLine1() {
        numpadLine1.setLayout(new GridLayout(1, 4, 5, 5));
        numpadLine1.add(numSeven);
        numpadLine1.add(numEight);
        numpadLine1.add(numNine);
        numpadLine1.add(numPlus);

        return numpadLine1;
    }

    private JPanel createNumpadLine2() {
        numpadLine2.setLayout(new GridLayout(1, 4, 5, 5));
        numpadLine2.add(numFour);
        numpadLine2.add(numFive);
        numpadLine2.add(numSix);
        numpadLine2.add(numMinus);

        return numpadLine2;
    }

    private JPanel createNumpadLine3() {
        numpadLine3.setLayout(new GridLayout(1, 4, 5, 5));
        numpadLine3.add(numOne);
        numpadLine3.add(numTwo);
        numpadLine3.add(numThree);
        numpadLine3.add(numMultiply);

        return numpadLine3;
    }

    private JPanel createNumpadLine4() {
        numpadLine4.setLayout(new GridLayout(1, 4, 5, 5));
        numpadLine4.add(numCE);
        numpadLine4.add(numZero);
        numpadLine4.add(numPoint);
        numpadLine4.add(numDivide);

        return numpadLine4;
    }

    private JPanel createEqual() {
        equal.setLayout(new GridLayout(1, 1, 5, 5));
        equal.add(numEqual);

        return equal;
    }

    private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, selection);
    }

    private void updateScreen(int number) {
        screenLabel.setText(buffer.toString());
    }

    private void onNumPressed(ActionEvent e) {
        int num = Integer.valueOf(e.getActionCommand());
        buffer.append(String.valueOf(num));
        updateScreen(num);
    }

    public void onCEPressed(ActionEvent e) {
        buffer = null;
    }

}
