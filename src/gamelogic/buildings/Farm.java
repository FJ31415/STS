package gamelogic.buildings;

import gamelogic.Position;
import gamelogic.entity.EntityGraphic;
import gamelogic.nations.Team;
import ui.graphics.Animation;
import ui.graphics.Sprite;

public final class Farm extends Building {
    public Farm(Team team, Position position) {
        super("Farm", team, 2, 0, 4, 2, 0, 0,
                position, new EntityGraphic(team, new Animation[]{
                        new Animation(Sprite.FARM_ONE_HEALTH_1, Sprite.FARM_ONE_HEALTH_2),
                        new Animation(Sprite.FARM_TWO_HEALTH_1, Sprite.FARM_TWO_HEALTH_2)
                }));
    }
}