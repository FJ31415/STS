package gamelogic.units;

import gamelogic.Position;
import gamelogic.entity.EntityGraphic;
import gamelogic.nations.Team;
import ui.graphics.Animation;
import ui.graphics.Sprite;

public final class Archer extends Unit {
    public Archer(Team team, Position position) {
        super("archer", team, 2, 1, 1, 1, 0,
                1, 2, 1, 1, position, new EntityGraphic(team, new Animation[] {
                        new Animation(Sprite.ARCHER_ONE_HEALTH_1, Sprite.ARCHER_ONE_HEALTH_2),
                        new Animation(Sprite.ARCHER_TWO_HEALTH_1, Sprite.ARCHER_TWO_HEALTH_2)
                }));
    }
}