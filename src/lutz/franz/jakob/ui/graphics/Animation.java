package lutz.franz.jakob.ui.graphics;

import lutz.franz.jakob.gamelogic.nations.Team;

public class Animation implements SpriteGraphic {
    private Team team;
    protected final Sprite[] keyframes;
    protected int selectedKeyframe;

    public Animation(Sprite[] keyframes) {
        this.keyframes = keyframes;
        this.team = Team.values()[0];
        selectedKeyframe = 0;
    }

    public Animation(Sprite keyframe1, Sprite keyframe2) {
        keyframes = new Sprite[] { keyframe1, keyframe2};
        this.team = Team.values()[0];
        selectedKeyframe = 0;
    }

    public Animation(Sprite keyframe) {
        keyframes = new Sprite[] { keyframe };
        this.team = Team.values()[0];
        selectedKeyframe = 0;
    }

    // methods

    public final void update() {
        if(++selectedKeyframe == keyframes.length)
            selectedKeyframe = 0;
    }

    public final void setTeam(Team team) {
        this.team = team;
    }

    // getter

    public final int getSpriteIdx() {
        return keyframes[selectedKeyframe].ordinal() + team.getSpriteShift();
    }

    @Override
    public final int getUpdatedSpriteIdx() {
        update();
        return getSpriteIdx();
    }
}