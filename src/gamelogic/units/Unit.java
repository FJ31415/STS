package gamelogic.units;
import gamelogic.GameHandler;
import gamelogic.entity.EntityGraphic;
import gamelogic.entity.GameEntity;
import gamelogic.Position;
import gamelogic.nations.NotEnoughResourcesException;
import gamelogic.nations.Team;

public abstract class Unit extends GameEntity {

    private final int maintenanceFood, maintenanceMaterial, movementRange, attackRange, damage, regeneration;
    private boolean moved, attacked;

    public Unit(String name, Team team, int baseHealth, int costFood, int costMaterial, int maintenanceFood, int maintenanceMaterial,  int  movementRange, int attackRange, int damage, int healing, Position position, EntityGraphic graphic) {
        super(name, team, baseHealth, costFood, costMaterial, position,  graphic);
        this.maintenanceFood = maintenanceFood;
        this.maintenanceMaterial = maintenanceMaterial;
        this.movementRange = movementRange;
        this.attackRange = attackRange;
        this.damage = damage;
        this.regeneration = healing;
        moved = false;
        attacked = false;
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
        if(!(moved && attacked))
            addHealth(regeneration);

        moved = false;
        attacked = false;
    }

    public final boolean isAccessiblePosition(Position destination) {
        return  Math.abs(destination.getX() - position.getX()) <= movementRange && Math.abs(destination.getY() - position.getY()) <= movementRange;
        // TODO upgrade with A*
    }

    public final boolean isAttackablePosition (Position target) {
       return Math.abs(target.getX() - position.getX()) == attackRange && Math.abs(target.getY() - position.getY()) == attackRange;
    }


    public boolean moveTo(Position destination) {
        if(!moved && isAccessiblePosition(destination)) {
            position.set(destination);
            moved = true;
            return true;
        }

        return false;
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