package lutz.franz.jakob.gamelogic.units;
import lutz.franz.jakob.gamelogic.GameHandler;
import lutz.franz.jakob.gamelogic.entity.EntityGraphic;
import lutz.franz.jakob.gamelogic.entity.GameEntity;
import lutz.franz.jakob.gamelogic.Position;
import lutz.franz.jakob.gamelogic.nations.NotEnoughResourcesException;
import lutz.franz.jakob.gamelogic.nations.Team;

public abstract class Unit extends GameEntity {

    protected final int maintenanceFood, maintenanceMaterial, movementRange, attackRange, damage, regeneration;
    protected boolean moved, attacked, wasAttacked;

    public Unit(String name, Team team, int baseHealth, int costFood, int costMaterial, int maintenanceFood, int maintenanceMaterial,  int  movementRange, int attackRange, int damage, int regeneration, Position position, EntityGraphic graphic) {
        super(name, team, baseHealth, costFood, costMaterial, position,  graphic);
        this.maintenanceFood = maintenanceFood;
        this.maintenanceMaterial = maintenanceMaterial;
        this.movementRange = movementRange;
        this.attackRange = attackRange;
        this.damage = damage;
        this.regeneration = regeneration;
        moved = false;
        attacked = false;
        wasAttacked = false;
    }

    @Override
    public void update() {
        // maintain
        try {
            GameHandler.getInstance().getNation(team).addFood(-1 * maintenanceFood);
            GameHandler.getInstance().getNation(team).addMaterial(-1 * maintenanceMaterial);
        } catch (NotEnoughResourcesException e) {
            addHealth(-1);
        }

        // regenerate
        if(!(wasAttacked && moved && attacked))
            addHealth(regeneration);

        moved = false;
        attacked = false;
        wasAttacked = false;
    }

    @Override
    public final void addHealth(int i) {
        super.addHealth(i);
        if(i < 0)
            wasAttacked = true;
    }

    public boolean moveTo(Position destination) {
        if(moved || GameHandler.getInstance().getMap().isOutOfBounds(destination)
                || GameHandler.getInstance().isEntityAt(destination) || !isAccessiblePosition(destination))
            return false;

        position.set(destination);
        moved = true;
        return true;
    }

    protected final boolean isAccessiblePosition(Position destination) {
        return  Math.abs(destination.getX() - position.getX()) <= movementRange && Math.abs(destination.getY() - position.getY()) <= movementRange;
        // TODO upgrade with A*
    }

    public boolean attack(GameEntity enemy) {
        if(!attacked && !enemy.getTeam().equals(team) && isAttackablePosition(enemy.getPosition())) {
            enemy.addHealth(-1 * damage);
            if(enemy instanceof Pikemen)
                ((Pikemen) enemy).counterAttack(this);
            attacked = true;
            return true;
        }

        return false;
    }

    protected final boolean isAttackablePosition (Position target) {
        return Math.abs(target.getX() - position.getX()) == attackRange && Math.abs(target.getY() - position.getY()) == attackRange;
    }

    // getter

    public final int getMaintenanceFood() {
        return maintenanceFood;
    }

    public final int getMaintenanceMaterial() {
        return maintenanceMaterial;
    }

    public final int getMovementRange() {
        return movementRange;
    }

    public final int getAttackRange() {
        return attackRange;
    }

    public final int getDamage() {
        return damage;
    }

    public final int getRegeneration() {
        return regeneration;
    }
}