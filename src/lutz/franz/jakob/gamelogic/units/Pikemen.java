package lutz.franz.jakob.gamelogic.units;

import lutz.franz.jakob.gamelogic.Position;
import lutz.franz.jakob.gamelogic.entity.EntityGraphic;
import lutz.franz.jakob.gamelogic.nations.Team;
import lutz.franz.jakob.presentation.graphics.Animation;
import lutz.franz.jakob.presentation.graphics.Sprite;

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