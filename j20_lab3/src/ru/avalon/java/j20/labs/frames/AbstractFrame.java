package ru.avalon.java.j20.labs.frames;

import java.awt.event.*;
import javax.swing.*;

public abstract class AbstractFrame extends JFrame {

    private class EventListener extends WindowAdapter {

        @Override
        public void windowOpened(WindowEvent e) {
            onCreate();
        }
    }

    public AbstractFrame() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);

        WindowAdapter listener = new EventListener();
        addWindowListener(listener);
    }

    protected void onCreate() {
    }
}
