package gamelogic.entity;

import gamelogic.entity.Team;
import ui.graphics.Animation;
import ui.graphics.SpriteGraphic;

public class EntityGraphic implements SpriteGraphic {
    public final Animation[] animations;
    public int selectedAnimation;

    public EntityGraphic(Animation[] animations, Team team) {
        this.animations = animations;
        selectedAnimation = 0;
        for(Animation a : this.animations)
            a.setTeam(team);
    }

    public EntityGraphic(Animation animation, Team team) {
        this.animations = new Animation[]{ animation };
        selectedAnimation = 0;
        this.animations[0].setTeam(team);
    }

    // methods

    @Override
    public void update() {
    }

    @Override
    public int getSpriteIdx() {
        return animations[selectedAnimation].getSpriteIdx();
    }

    @Override
    public int getUpdatedSpriteIdx() {
        animations[selectedAnimation].update();
        return getSpriteIdx();
    }
}