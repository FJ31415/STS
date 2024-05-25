package lutz.franz.jakob.ui.graphics.gui;

import lutz.franz.jakob.control.Main;
import lutz.franz.jakob.ui.graphics.Sprite;
import lutz.franz.jakob.ui.graphics.SpriteSet;

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
        // super.paintComponents(g); TODO
        Main.getInstance().getState().render(g, sprites);
    }
}