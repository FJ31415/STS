package gamelogic.buildings;

import gamelogic.GameHandler;
import gamelogic.entity.EntityGraphic;
import gamelogic.entity.GameEntity;
import gamelogic.Position;
import gamelogic.nations.NotEnoughResourcesException;
import gamelogic.nations.Team;

public abstract class Building extends GameEntity {
    private final int maxGenerationFood, maxGenerationMaterial, populationCapacity;

    public Building(String name, Team team, int baseHealth, int costFood, int costMaterial, int generationFood, int generationMaterial, int populationCapacity, Position position, EntityGraphic graphic) {
        super(name, team, baseHealth, costFood, costMaterial, position, graphic);
        this.maxGenerationFood = generationFood;
        this.maxGenerationMaterial = generationMaterial;
        this.populationCapacity = populationCapacity;
    }

    @Override
    public void update() {
        // generate resources
        try {
            GameHandler.getInstance().getNation(team).addFood(getGenerationFood());
            GameHandler.getInstance().getNation(team).addMaterial(getGenerationMaterial());
        } catch (NotEnoughResourcesException ignored){}
    }

    // getter

    public final int getGenerationFood() {
        return maxGenerationFood * Math.round((float) health / baseHealth);
    }

    public final int getGenerationMaterial() {
        return maxGenerationMaterial * Math.round((float) health / baseHealth);
    }

    public final int getPopulationCapacity() {
        return populationCapacity;
    }
}