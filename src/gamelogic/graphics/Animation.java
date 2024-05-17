package gamelogic.graphics;

import gamelogic.Team;

public abstract class Animation {
    private final Team team;
    protected final Sprite[] keyframes;
    protected int selectedKeyframe;

    public Animation(Sprite[] keyframes, Team team) {
        this.keyframes = keyframes;
        this.team = team;
        selectedKeyframe = 0;
    }

    public Animation(Sprite keyframe1, Sprite keyframe2, Team team) {
        keyframes = new Sprite[] { keyframe1, keyframe2 };
        this.team = team;
        selectedKeyframe = 0;
    }

    public Animation(Sprite keyframe,Team team) {
        keyframes = new Sprite[] { keyframe };
        this.team = team;
        selectedKeyframe = 0;
    }

    public void update() {
        if(++selectedKeyframe == keyframes.length)
            selectedKeyframe = 0;
    }

    // getter

    public final int getSpriteIdx() {
        return keyframes[selectedKeyframe].ordinal() + team.getSpriteShift();
    }

    public final int getUpdatedSpriteIdx() {
        update();
        return getSpriteIdx();
    }
}