package model;

public class Animal {

    private int animalId;
    private String animalName;
    private String animalDesc;
    private String animalColor;
    private String animalImage;
    private String wikiLink;
    private AnimalLocation location;
    private AnimalFamily animalFamily;

    public Animal() {

    }

    public Animal(int animalId, String animalName, String animalDesc, String animalColor,
                  String animalImage, String wikiLink, AnimalLocation location,
                  AnimalFamily animalFamily) {
        this.animalId = animalId;
        this.animalName = animalName;
        this.animalDesc = animalDesc;
        this.animalColor = animalColor;
        this.animalImage = animalImage;
        this.wikiLink = wikiLink;
        this.location = location;
        this.animalFamily = animalFamily;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalDesc() {
        return animalDesc;
    }

    public void setAnimalDesc(String animalDesc) {
        this.animalDesc = animalDesc;
    }

    public String getAnimalColor() {
        return animalColor;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    public String getAnimalImage() {
        return animalImage;
    }

    public void setAnimalImage(String animalImage) {
        this.animalImage = animalImage;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

    public AnimalLocation getLocation() {
        return location;
    }

    public void setLocation(AnimalLocation location) {
        this.location = location;
    }

    public AnimalFamily getAnimalFamily() {
        return animalFamily;
    }

    public void setAnimalFamily(AnimalFamily animalFamily) {
        this.animalFamily = animalFamily;
    }
}
