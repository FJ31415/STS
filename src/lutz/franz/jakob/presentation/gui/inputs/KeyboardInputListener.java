package lutz.franz.jakob.presentation.gui.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import lutz.franz.jakob.presentation.gui.GUI;

public final class KeyboardInputListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        GUI.getInstance().getGUIState().onKeyPressed(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override

    public void keyReleased(KeyEvent e) {}
}