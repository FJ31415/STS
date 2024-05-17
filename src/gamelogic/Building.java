package gamelogic;

public abstract class Building extends GameEntity {
    private final int generationFood, generationMaterial;


    public Building(String name, Team team, int baseHealth, int generationFood, int generationMaterial, Position position) {
        super(name, team, baseHealth, position);
        this.generationFood = generationFood;
        this.generationMaterial = generationMaterial;
    }

    @Override
    public void update() {
        team.addFood(generationFood);
        team.addMaterial(generationMaterial);
    }

    // getter

    public final int getGenerationFood() {
        return generationFood;
    }

    public final int getGenerationMaterial() {
        return generationMaterial;
    }
}