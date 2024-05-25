package ui.graphics.gui;

import ui.graphics.Sprite;
import ui.graphics.SpriteSet;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

public final class Rendering extends JPanel {
    private final SpriteSet sprites;

    public Rendering() {
        setPanelSize();
        sprites = new SpriteSet("res/STS_atlas.png", Sprite.values().length);
    }


    private void setPanelSize() {
        Dimension size = new Dimension(GUI.WIDTH, GUI.HEIGHT);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    @Override
    public void paintComponents(Graphics g) {
        // super.paintComponents(g);
        // TODO implement
    }

    // TODO implement

    // getter

    // renderSprite() TODO
}