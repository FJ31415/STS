package gamelogic;

import java.util.HashSet;

public abstract class Unit extends GameEntity {

    private final int movementRange, attackRange, damage;
    private final HashSet<Position>  accessiblePositions, targetPositions;

    public Unit(String name, Team team, int baseHealth, int  movementRange, int attackRange, int damage, Position position) {
        super(name, team, baseHealth, position);
        this.movementRange = movementRange;
        this.attackRange = attackRange;
        this.damage = damage;
        accessiblePositions = new HashSet<>();
        targetPositions = new HashSet<>();
    }

    @Override
    public void update() {
        accessiblePositions.clear();
        targetPositions.clear();
    }

    public final void calculateAccessiblePositions(GameMap map) {
        calculateSurroundingAccessiblePositions(this.position, map);

        for(int i = 0, len = movementRange - 1; i < len; i++)
            for (Position p : accessiblePositions)
                calculateSurroundingAccessiblePositions(p, map);
    }

    private void calculateSurroundingAccessiblePositions(Position position, GameMap map) {
        for (int x = position.getX() - 1, lenX = position.getX() + 1; x <= lenX; x++)
            for (int y = position.getY() - 1, lenY = position.getY() + 1; y <= lenY; y++)
                if(!(x == 0 && y == 0) && !map.isOutOfBounds(x, y) && map.getEntityAt(x, y) == null)
                    accessiblePositions.add(new Position(x, y));
    }

    private boolean isAccessiblePosition(Position position, GameMap map) {
        return !map.isOutOfBounds(position) && map.getEntityAt(position) == null;
    }

    public final void calculateTargetPositions(GameMap map) {
        // calculate left & right rim
        for(int y = position.getY() - attackRange, len = position.getY() + attackRange,
            x1 = position.getX() + attackRange, x2 = position.getX() - attackRange; y <= len; y++) {
            if(isTarget(x1, y, map))
                targetPositions.add(new Position(x1, y));
            if(isTarget(x2, y, map))
                targetPositions.add(new Position(x2, y));
        }

        // calculate top & bottom rim
        for (int x = position.getX() - (attackRange - 1), len = position.getX() + (attackRange - 1),
             y1 = position.getY() + attackRange, y2 = position.getY() - attackRange; x < len; x++) {
            if(isTarget(x, y1, map))
                targetPositions.add(new Position(x, y1));
            if(isTarget(x, y2, map))
                targetPositions.add(new Position(x, y2));
        }
    }

    private boolean isTarget(int x, int y, GameMap map) {
        return !map.isOutOfBounds(x, y)
                && map.getEntityAt(x, y) != null
                && !map.getEntityAt(x,y).getTeam().equals(team);
    }

    public boolean moveTo(Position destination, GameMap  map) {
        for (Position p : accessiblePositions)
            if(!isAccessiblePosition(p, map))
                accessiblePositions.remove(p);
            else if(p.equals(destination)) {
                position.set(destination);
                accessiblePositions.clear();
                return true;
            }

        return false;
    }

    // TODO add attack()

    // getter

    public final int getMovementRange() {
        return movementRange;
    }

    public final int getAttackRange() {
        return attackRange;
    }

    public final int getDamage() {
        return damage;
    }
}