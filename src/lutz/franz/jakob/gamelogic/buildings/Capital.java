package lutz.franz.jakob.gamelogic.buildings;

import lutz.franz.jakob.gamelogic.Position;
import lutz.franz.jakob.gamelogic.entity.EntityGraphic;
import lutz.franz.jakob.gamelogic.nations.Team;
import lutz.franz.jakob.ui.graphics.Animation;
import lutz.franz.jakob.ui.graphics.Sprite;

public final class Capital extends Building {
    public Capital(Team team, Position position) {
        super("Capital", team, 3, 0, 0, 0, 0,
                3, position, new EntityGraphic(team, new Animation[]{
                        new Animation(Sprite.CAPITAL_ONE_HEALTH_1, Sprite.CAPITAL_ONE_HEALTH_2),
                        new Animation(Sprite.CAPITAL_TWO_HEALTH_1, Sprite.CAPITAL_TWO_HEALTH_2),
                        new Animation(Sprite.CAPITAL_THREE_HEALTH_1, Sprite.CAPITAL_THREE_HEALTH_2),
                }));
    }
}