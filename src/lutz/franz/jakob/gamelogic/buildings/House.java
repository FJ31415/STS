package lutz.franz.jakob.gamelogic.buildings;

import lutz.franz.jakob.gamelogic.Position;
import lutz.franz.jakob.gamelogic.entity.EntityGraphic;
import lutz.franz.jakob.gamelogic.nations.Team;
import lutz.franz.jakob.ui.graphics.Animation;
import lutz.franz.jakob.ui.graphics.Sprite;

public class House extends Building {
    public House(Team team, Position position) {
        super("House", team, 2, 0, 4, 0, 0,
                2, position, new EntityGraphic(team, new Animation[]{
                        new Animation(Sprite.HOUSE_ONE_HEALTH_1, Sprite.HOUSE_ONE_HEALTH_2),
                        new Animation(Sprite.HOUSE_TWO_HEALTH_1, Sprite.HOUSE_TWO_HEALTH_2)
                }));
    }
}