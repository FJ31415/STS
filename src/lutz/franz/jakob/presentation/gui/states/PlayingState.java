package lutz.franz.jakob.presentation.gui.states;

import lutz.franz.jakob.gamelogic.GameHandler;
import lutz.franz.jakob.gamelogic.entity.GameEntity;
import lutz.franz.jakob.gamelogic.maps.Terrain;
import lutz.franz.jakob.presentation.graphics.Sprite;
import lutz.franz.jakob.presentation.gui.GUI;
import lutz.franz.jakob.presentation.gui.SpriteSet;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public final class PlayingState extends GUIState {
    @Override
    public void render(Graphics g, SpriteSet sprites) {
        // render map
        for(int y = 0, fY = -1 * GUI.MAP_RADIUS; y < GUI.MAP_SIZE; y++, fY++)
            for (int x = 0, fX = -1 * GUI.MAP_RADIUS; x < GUI.MAP_SIZE; x++, fX++) {
                int lX = (GUI.getInstance().getCamera().getX() + fX),
                        lY = (GUI.getInstance().getCamera().getY() + fY),
                        rX = x * Sprite.SIZE, rY = y * Sprite.SIZE;

                // render terrain
                Terrain t = GameHandler.getInstance().getMap().getTerrain(lX, lY);
                if (t != null)
                    g.drawImage(sprites.getSprite(t.getGraphic().getSpriteIdx()), rX, rY, null);
                else
                    g.drawImage(sprites.getSprite(Sprite.BLACK), rX, rY,null);

                // render entity
                GameEntity e = GameHandler.getInstance().getEntityAt(lX, lY);
                if(e != null)
                    g.drawImage(sprites.getSprite(e.getGraphic().getSpriteIdx()), rX, rY,null);
            }
    }

    @Override
    public void onKeyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w': // TODO rework (debug)
            case 'W':moveCamera(0, -1);
            break;
            case 's': // TODO rework (debug)
            case 'S':
                moveCamera(0, 1);
                break;
            case 'd': // TODO rework (debug)
            case 'D':
                moveCamera(1, 0);
                break;
            case 'a': // TODO rework (debug)
            case 'A':
                moveCamera(-1, 0);
                break;
            case 'q': // TODO remove (debug)S
            case 'Q':
                GameHandler.getInstance().updateGraphics();
                break;
        }
    }

    private void moveCamera(int iX, int iY) {
        GUI.getInstance().getCamera().add(iX, iY);
        GUI.getInstance().updateGraphics();
    }

    @Override
    public void onMouseClicked(MouseEvent e) {
        // TODO implement
    }
}