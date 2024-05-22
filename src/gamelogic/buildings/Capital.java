package gamelogic.buildings;

import gamelogic.Position;
import gamelogic.entity.EntityGraphic;
import gamelogic.nations.Team;
import ui.graphics.Animation;
import ui.graphics.Sprite;

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