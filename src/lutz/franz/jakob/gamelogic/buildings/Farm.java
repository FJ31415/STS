package lutz.franz.jakob.gamelogic.buildings;

import lutz.franz.jakob.gamelogic.Position;
import lutz.franz.jakob.gamelogic.entity.EntityGraphic;
import lutz.franz.jakob.gamelogic.nations.Team;
import lutz.franz.jakob.ui.graphics.Animation;
import lutz.franz.jakob.ui.graphics.Sprite;

public final class Farm extends Building {
    public Farm(Team team, Position position) {
        super("Farm", team, 2, 0, 4, 2, 0, 0,
                position, new EntityGraphic(team, new Animation[]{
                        new Animation(Sprite.FARM_ONE_HEALTH_1, Sprite.FARM_ONE_HEALTH_2),
                        new Animation(Sprite.FARM_TWO_HEALTH_1, Sprite.FARM_TWO_HEALTH_2)
                }));
    }
}