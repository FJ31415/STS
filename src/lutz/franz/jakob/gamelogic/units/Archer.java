package lutz.franz.jakob.gamelogic.units;

import lutz.franz.jakob.gamelogic.Position;
import lutz.franz.jakob.gamelogic.entity.EntityGraphic;
import lutz.franz.jakob.gamelogic.nations.Team;
import lutz.franz.jakob.presentation.graphics.Animation;
import lutz.franz.jakob.presentation.graphics.Sprite;

public final class Archer extends Unit {
    public Archer(Team team, Position position) {
        super("archer", team, 2, 1, 1, 1, 0,
                1, 2, 1, 1, position, new EntityGraphic(team, new Animation[] {
                        new Animation(Sprite.ARCHER_ONE_HEALTH_1, Sprite.ARCHER_ONE_HEALTH_2),
                        new Animation(Sprite.ARCHER_TWO_HEALTH_1, Sprite.ARCHER_TWO_HEALTH_2)
                }));
    }
}