package lutz.franz.jakob.ui.states;

import lutz.franz.jakob.ui.graphics.SpriteSet;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class GameState {
    public abstract void render(Graphics g, SpriteSet sprites);

    public abstract void onKeyPressed(KeyEvent e);

    public abstract void onMouseClicked(MouseEvent  e);
}