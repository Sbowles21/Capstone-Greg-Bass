package com.example.Capstone;
import javax.persistence.*;

@Entity
@Table(name = "Pokemon")
public class pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String Name;

    @Column(nullable = false, unique = true, length = 45)
    private int DexNum;

    @Column(nullable = false, unique = true, length = 45)
    private  String Entry;

    @Column(nullable = false, unique = true, length = 45)
    private int Height;

    @Column(nullable = false, unique = true, length = 45)
    private float Weight;

    @Column(nullable = false, unique = true, length = 45)
    private String Gender;

    @Column(nullable = false, unique = true, length = 45)
    private String Category;

    @Column(nullable = false, unique = true, length = 45)
    private  String Types;

    @Column(nullable = false, unique = true, length = 45)
    private int Ability;

    @Column(nullable = false, unique = true, length = 45)
    private String Weaknessess;

    @Column(nullable = false, unique = true, length = 45)
    private String Evolutions;

    @Column(nullable = false, unique = true, length = 45)
    private int Evo_Lvl;

    @Column(nullable = false, unique = true, length = 45)
    private String Dexs_in;

    @Column(nullable = false, unique = true, length = 45)
    private int Votes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getDexNum() {
        return DexNum;
    }

    public void setDexNum(int dexNum) {
        DexNum = dexNum;
    }

    public String getEntry() {
        return Entry;
    }

    public void setEntry(String entry) {
        Entry = entry;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float weight) {
        Weight = weight;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getTypes() {
        return Types;
    }

    public void setTypes(String types) {
        Types = types;
    }

    public int getAbility() {
        return Ability;
    }

    public void setAbility(int ability) {
        Ability = ability;
    }

    public String getWeaknessess() {
        return Weaknessess;
    }

    public void setWeaknessess(String weaknessess) {
        Weaknessess = weaknessess;
    }

    public String getEvolutions() {
        return Evolutions;
    }

    public void setEvolutions(String evolutions) {
        Evolutions = evolutions;
    }

    public int getEvo_Lvl() {
        return Evo_Lvl;
    }

    public void setEvo_Lvl(int evo_Lvl) {
        Evo_Lvl = evo_Lvl;
    }

    public String getDexs_in() {
        return Dexs_in;
    }

    public void setDexs_in(String dexs_in) {
        Dexs_in = dexs_in;
    }

    public int getVotes() {
        return Votes;
    }

    public void setVotes(int votes) {
        Votes = votes;
    }
}
