package ui.states;

import ui.graphics.gui.Rendering;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class GameState {
    public abstract void render(Rendering r);

    public abstract void onKeyPressed(KeyEvent e);

    public abstract void onMouseClicked(MouseEvent  e);
}