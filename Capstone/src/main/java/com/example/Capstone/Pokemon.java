package com.example.Capstone;
import javax.persistence.*;

@Entity
@Table(name = "Pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Name;

    @Column( nullable = true)
    private int DexNum;

    @Column(nullable = false, columnDefinition = "TEXT")
    private  String Entry;

    @Column(nullable = false)
    private int Height;

    @Column(nullable = false)
    private int Weight;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String Category;

    @Column(nullable = false)
    private  String Types;

    @Column(nullable = false)
    private int Ability;

    @Column(nullable = true)
    private String Weaknesses;

    @Column(nullable = true)
    private String Evolutions;

    @Column(nullable = true)
    private int Evo_Lvl;

    @Column(nullable = true)
    private String Dexs_in;

    @Column(nullable = true)
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

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getWeaknesses() {
        return Weaknesses;
    }

    public void setWeaknesses(String weaknesses) {
        Weaknesses = weaknesses;
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
