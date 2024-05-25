package lutz.franz.jakob.gamelogic.buildings;

import lutz.franz.jakob.gamelogic.Position;
import lutz.franz.jakob.gamelogic.entity.EntityGraphic;
import lutz.franz.jakob.gamelogic.nations.Team;
import lutz.franz.jakob.ui.graphics.Animation;
import lutz.franz.jakob.ui.graphics.Sprite;

public final class Mine extends Building {
    public Mine(Team team, Position position) {
        super("Mine", team, 2, 0, 4, 0, 2, 0,
                position, new EntityGraphic(team, new Animation[]{
                        new Animation(Sprite.MINE_ONE_HEALTH_1, Sprite.MINE_ONE_HEALTH_2),
                        new Animation(Sprite.MINE_TWO_HEALTH_1, Sprite.MINE_TWO_HEALTH_2)
                }));
    }
}