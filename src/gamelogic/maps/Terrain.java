package gamelogic.maps;

import ui.graphics.Animation;
import ui.graphics.Sprite;

import static ui.graphics.Sprite.*;

public enum Terrain {
    MEADOW("Meadow", MEADOW_1, MEADOW_2),
    FOREST("Forest", FOREST_1, FOREST_2);

    private final String name;
    private final Animation animation;

    Terrain(String name, Sprite keyframe1, Sprite keyframe2) {
        this.name = name;
        this.animation = new Animation(keyframe1, keyframe2);
    }

    // getter

    public String getName() {
        return name;
    }

    public Animation getGraphic() {
        return animation;
    }
}