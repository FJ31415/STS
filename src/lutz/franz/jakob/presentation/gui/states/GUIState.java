package lutz.franz.jakob.presentation.gui.states;

import lutz.franz.jakob.presentation.gui.SpriteSet;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class GUIState {
    public abstract void render(Graphics g, SpriteSet sprites);

    public abstract void onKeyPressed(KeyEvent e);

    public abstract void onMouseClicked(MouseEvent  e);
}