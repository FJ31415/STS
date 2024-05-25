package lutz.franz.jakob.gamelogic.units;

import lutz.franz.jakob.gamelogic.Position;
import lutz.franz.jakob.gamelogic.entity.EntityGraphic;
import lutz.franz.jakob.gamelogic.nations.Team;
import lutz.franz.jakob.ui.graphics.Animation;
import lutz.franz.jakob.ui.graphics.Sprite;

public final class Horsemen extends Unit {
    public Horsemen(Team team, Position position) {
        super("horsemen", team, 2, 1, 1, 1, 0,
                2, 1, 1, 1, position, new EntityGraphic(team, new Animation[] {
                        new Animation(Sprite.HORSEMEN_ONE_HEALTH_1, Sprite.HORSEMEN_ONE_HEALTH_2),
                        new Animation(Sprite.HORSEMEN_TWO_HEALTH_1, Sprite.HORSEMEN_TWO_HEALTH_2)
                }));
    }
}