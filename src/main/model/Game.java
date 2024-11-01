package model;

import org.json.JSONObject;
import persistence.Writable;

public class Game implements Writable {
    private String name;
    private String description;
    private int price;
    private String category;
    private DifficultyType difficulty;

    public Game(String name, String des, int price, String ca) {
        this.name = name;
        this.description = des;
        this.price = price;
        this.category = ca;
    }

    // EFFECTS: get the name of the game
    public String getName() {
        return name;
    }

    // EFFECTS: get the description of the game
    public String getDescription() {
        return description;
    }

    // EffectS: get the price of the game
    public int getPrice() {
        return price;
    }

    // EFFECTS: get the category of the game
    public String getCategory() {
        return category;
    }

    // EFFECTS: get the difficulty of the game
    public DifficultyType getDifficulty() {
        return difficulty;
    }

    // MODIFIES: this
    // EFFECTS: change the name of the game
    public void setName(String name) {
        this.name = name;
    }

    // MODIFIES: this
    // EFFECTS: change the description of the game
    public void setDescription(String des) {
        this.description = des;
    }

    // MODIFIES: this
    // EFFECTS: change the category of the game
    public void setCategory(String cate) {
        this.category = cate;
    }

    // MODIFIES: this
    // EFFECTS: change the price of the game
    public void setPrice(int price) {
        this.price = price;
    }

    // MODIFIES: this
    // EFFECTS: change the difficulty of the game
    public void setDifficulty(DifficultyType diff) {
        this.difficulty = diff;
    }

    // EFFECTS: return true if the name of the game is the given string
    public boolean isName(String nm) {
        boolean result = false;
        if (nm.equals(this.getName())) {
            result = true;
        }
        return result;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("Description", description);
        json.put("Price", price);
        json.put("Category", category);
        json.put("Difficulty", difficulty);
        return json;
    }
}
