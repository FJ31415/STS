package gamelogic.buildings;

import gamelogic.GameHandler;
import gamelogic.entity.EntityGraphic;
import gamelogic.entity.GameEntity;
import gamelogic.Position;
import gamelogic.nations.NotEnoughResourcesException;
import gamelogic.nations.Team;

public abstract class Building extends GameEntity {
    private final int generationFood, generationMaterial, populationCapacity;

    public Building(String name, Team team, int baseHealth, int costFood, int costMaterial, int generationFood, int generationMaterial, int populationCapacity, Position position, EntityGraphic graphic) {
        super(name, team, baseHealth, costFood, costMaterial, position, graphic);
        this.generationFood = generationFood;
        this.generationMaterial = generationMaterial;
        this.populationCapacity = populationCapacity;
    }

    @Override
    public void update() {
        // generate resources
        try {
            GameHandler.getInstance().getNation(team).addFood(generationFood);
            GameHandler.getInstance().getNation(team).addMaterial(generationMaterial);
        } catch (NotEnoughResourcesException ignored){}
    }

    // getter

    public final int getGenerationFood() {
        return generationFood;
    }

    public final int getGenerationMaterial() {
        return generationMaterial;
    }

    public final int getPopulationCapacity() {
        return populationCapacity;
    }
}