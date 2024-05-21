package gamelogic.units;

import gamelogic.Position;
import gamelogic.entity.EntityGraphic;
import gamelogic.nations.Team;
import ui.graphics.Animation;
import ui.graphics.Sprite;

public final class Pikemen extends Unit {
    public Pikemen(Team team, Position position) {
        super("pikemen", team, 2, 1, 1, 1, 0,
                1, 1, 1, 1, position, new EntityGraphic(team, new Animation[] {
                        new Animation(Sprite.PIKEMEN_ONE_HEALTH_1, Sprite.PIKEMEN_ONE_HEALTH_2),
                        new Animation(Sprite.PIKEMEN_TWO_HEALTH_1, Sprite.PIKEMEN_TWO_HEALTH_2)
                }));
    }

    public void counterAttack(Unit enemy) {
        if(isAttackablePosition(enemy.getPosition()))
            enemy.addHealth(-1 * damage);
    }
}