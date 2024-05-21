package gamelogic.entity;

import gamelogic.nations.Team;
import ui.graphics.Animation;
import ui.graphics.SpriteGraphic;

public class EntityGraphic implements SpriteGraphic {
    protected final Animation[] animations;
    protected int selectedAnimation;
    protected GameEntity host;

    public EntityGraphic(Team team, Animation[] animations) {
        this.animations = animations;
        selectedAnimation = 0;
        for(Animation a : this.animations)
            a.setTeam(team);
        host = null;
    }

    public EntityGraphic(Team team, Animation animation) {
        this.animations = new Animation[]{ animation };
        selectedAnimation = 0;
        this.animations[0].setTeam(team);
        host = null;
    }

    @Override
    public final void update() {
        selectedAnimation = host.getHealth() -1;
    }

    public final void setHost(GameEntity host) {
        this.host = host;
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