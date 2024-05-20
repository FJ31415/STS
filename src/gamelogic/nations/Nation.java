package gamelogic.nations;

import java.util.ArrayList;

public final class Nation {
    private final Team team;
    private int food, material;

    public Nation(Team team) {
        this.team = team;
        food = 0;
        material = 0;
    }

    public void addFood(int i) throws MissingResourceException {
        int f = food + i;
        if(f < 0)
            throw new MissingResourceException(f, "food");
        else
            food = f;
    }

    public void addMaterial(int i) throws MissingResourceException {
        int m = material + i;
        if(m < 0)
            throw new MissingResourceException(m, "material");
        else
            material= m;
    }

    // getter

    public Team getTeam() {
        return team;
    }

    public int getFood() {
        return food;
    }

    public int getMaterial() {
        return material;
    }
}
