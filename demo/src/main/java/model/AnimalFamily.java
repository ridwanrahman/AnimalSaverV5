package model;

public class AnimalFamily {

    private int animalFamilyID;
    private String animalFamilyName;
    private String animalFamilyDesc;

    public AnimalFamily() {

    }

    public AnimalFamily(int animalFamilyID, String animalFamilyName, String animalFamilyDesc) {
        this.animalFamilyID = animalFamilyID;
        this.animalFamilyName = animalFamilyName;
        this.animalFamilyDesc = animalFamilyDesc;
    }

    public int getAnimalFamilyID() {
        return animalFamilyID;
    }

    public void setAnimalFamilyID(int animalFamilyID) {
        this.animalFamilyID = animalFamilyID;
    }

    public String getAnimalFamilyName() {
        return animalFamilyName;
    }

    public void setAnimalFamilyName(String animalFamilyName) {
        this.animalFamilyName = animalFamilyName;
    }

    public String getAnimalFamilyDesc() {
        return animalFamilyDesc;
    }

    public void setAnimalFamilyDesc(String animalFamilyDesc) {
        this.animalFamilyDesc = animalFamilyDesc;
    }
}
