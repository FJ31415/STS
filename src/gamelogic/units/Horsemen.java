package gamelogic.units;

import gamelogic.Position;
import gamelogic.entity.EntityGraphic;
import gamelogic.nations.Team;
import ui.graphics.Animation;
import ui.graphics.Sprite;

public final class Horsemen extends Unit {
    public Horsemen(Team team, Position position) {
        super("horsemen", team, 2, 1, 1, 1, 0,
                2, 1, 1, 1, position, new EntityGraphic(team, new Animation[] {
                        new Animation(Sprite.HORSEMEN_ONE_HEALTH_1, Sprite.HORSEMEN_ONE_HEALTH_2),
                        new Animation(Sprite.HORSEMEN_TWO_HEALTH_1, Sprite.HORSEMEN_TWO_HEALTH_2)
                }));
    }
}