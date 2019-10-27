package com.example.demo;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.rowset.CachedRowSetImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.apache.derby.client.*;
import  model.*;


@SpringBootApplication
@RestController
public class DemoApplication {

    private ArrayList<Animal> animals;
    private ArrayList<AnimalFamily> animalFamilies;

    public DemoApplication() {
        animals = new ArrayList<Animal>();
        animalFamilies = new ArrayList<AnimalFamily>();
    }

    public ArrayList<Animal> getAnimals() {
        this.index();
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public ArrayList<AnimalFamily> getAnimalFamilies() {
        return animalFamilies;
    }

    public void setAnimalFamilies(ArrayList<AnimalFamily> animalFamilies) {
        this.animalFamilies = animalFamilies;
    }

    public void insertIntoDatabase(Animal newAnimal) {
        this.index();
        String databaseURL = "jdbc:derby://localhost:1527/AnimalSaverV5DB;create=false";
        String user = "ridwan";
        String pass = "ridwan";
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection conn = DriverManager.getConnection(databaseURL, user, pass);
            int lastId = animals.get(animals.size()-1).getAnimalId()+1;
            String sql = "INSERT INTO RIDWAN.ANIMAL(ANIMAL_ID,ANIMAL_NAME,ANIMAL_DESC,ANIMALCOLOR,ANIMALIMAGE,WIKILINK) " +
                    "VALUES("+lastId+",'"+newAnimal.getAnimalName()+"','"+newAnimal.getAnimalDesc()+"','"+newAnimal.getAnimalColor()+"','"+newAnimal.getAnimalImage()+"','"+newAnimal.getWikiLink()+"')";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @CrossOrigin
    @PostMapping("/api/addAnimal")
    public Animal addAnimal(@RequestBody Animal newAnimal) {
        this.insertIntoDatabase(newAnimal);
        return newAnimal;
    }

    @CrossOrigin
    @PostMapping("/api/addAnimalFamily")
    public AnimalFamily addAnimalFamily(@RequestBody AnimalFamily newAnimalFamily) {
        System.out.println(newAnimalFamily);
        return newAnimalFamily;
    }

    @CrossOrigin
    @GetMapping("/api/animalFamily")
    public ArrayList<AnimalFamily> fam() {
        this.index();
        return this.getAnimalFamilies();
    }

    @CrossOrigin
    @GetMapping("/api/animal")
    public ArrayList<Animal> animal() {
        this.index();
        return this.getAnimals();
    }

    public void index() {
        String databaseURL = "jdbc:derby://localhost:1527/AnimalSaverV5DB;create=false";
        String user = "ridwan";
        String pass = "ridwan";
        System.out.println("getting into db");
        ArrayList<Animal> animalList = new ArrayList<Animal>();
        ArrayList<AnimalLocation> location = new ArrayList<AnimalLocation>();
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection conn = DriverManager.getConnection(databaseURL, user, pass);
            Statement statement = conn.createStatement();

            //Retrieveing all animal family from database
            String sql_animal_family = "SELECT * FROM RIDWAN.ANIMAL_FAMILY";
            ArrayList<AnimalFamily> familyArrayList = new ArrayList<AnimalFamily>();
            ResultSet result_animal_family = statement.executeQuery(sql_animal_family);
            while(result_animal_family.next())
            {
                int columns_fam = result_animal_family.getMetaData().getColumnCount();
                AnimalFamily fam = new AnimalFamily();
                for(int i=1;i<=columns_fam;i++)
                {
                    if(result_animal_family.getMetaData().getColumnLabel(i).equals("ANIMAL_FAMILY_ID")) {
                        fam.setAnimalFamilyID((Integer) result_animal_family.getObject(1));
                    }
                    if(result_animal_family.getMetaData().getColumnLabel(i).equals("ANIMAL_FAMILY_DESC")) {
                        fam.setAnimalFamilyDesc((String)result_animal_family.getObject((2)));
                    }
                    if(result_animal_family.getMetaData().getColumnLabel(i).equals("ANIMAL_FAMILY_NAME")) {
                        fam.setAnimalFamilyName((String)result_animal_family.getObject(3));
                    }
                }
                familyArrayList.add(fam);
            }
            setAnimalFamilies(familyArrayList);

            String sql_animal = "SELECT * FROM RIDWAN.ANIMAL";
            ResultSet result = statement.executeQuery(sql_animal);
            while(result.next())
            {
                int columns = result.getMetaData().getColumnCount();
                Animal ani = new Animal();
                for (int i = 1; i <= columns; i++)
                {
                    if(result.getMetaData().getColumnLabel(i).equals("ANIMAL_ID")) {
                        ani.setAnimalId((Integer) result.getObject(i));
                    }
                    if(result.getMetaData().getColumnLabel(i).equals("ANIMALCOLOR")) {
                        ani.setAnimalColor((String) result.getObject(i));
                    }
                    if(result.getMetaData().getColumnLabel(i).equals("ANIMAL_DESC")) {
                        ani.setAnimalDesc((String) result.getObject(i));
                    }
                    if(result.getMetaData().getColumnLabel(i).equals("ANIMALIMAGE")) {
                        ani.setAnimalImage((String) result.getObject(i));
                    }
                    if(result.getMetaData().getColumnLabel(i).equals("ANIMAL_NAME")) {
                        ani.setAnimalName((String) result.getObject(i));
                    }
                    if(result.getMetaData().getColumnLabel(i).equals("WIKILINK")) {
                        ani.setWikiLink((String) result.getObject(i));
                    }
                    if(result.getMetaData().getColumnLabel(i).equals("ANIMALFAMILY_ANIMAL_FAMILY_ID")) {
                        if(result.getObject(i) == null) {
                            ani.setAnimalFamily(null);
                        }
                        else {
                            for(AnimalFamily f:animalFamilies){
                                if(f.getAnimalFamilyID() == (Integer) result.getObject(i))
                                {
                                    ani.setAnimalFamily(f);
                                }
                            }
                        }
                    }
                }
                animalList.add(ani);
                setAnimals(animalList);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
