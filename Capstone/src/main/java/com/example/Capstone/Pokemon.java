package com.example.Capstone;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "Pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "A pokemon needs a name.")
    String Name;

    @Column( nullable = true)
    int DexNum;

    @Column(nullable = false, columnDefinition = "TEXT")
    @NotBlank(message = "What is a Pokémon without an entry?")
    String Entry;

    @Column(nullable = false)
    @NotBlank(message = "Please enter the height.")
    String Height;

    @Column(nullable = false)
    @NotBlank(message = "Please enter the weight.")
    String Weight;

    @Column(nullable = false)
    String gender;

    @Column(nullable = false)
    String Category;

    @Column(nullable = false)
    String Types;

    @ManyToOne
    @JoinColumn(name = "ability")
    Abilities Ability;

    @Column(nullable = true)
    String Weaknesses;

    @Column(nullable = true)
    String Evolutions;

    @Column(nullable = true)
    int Evo_Lvl;

    @ManyToOne
    @JoinColumn(name="dexes", nullable = true)
    Pokedex dexes;

    @ManyToMany(mappedBy = "likedPokemon", cascade = CascadeType.ALL)
    Set<User> upVotes;

    @Column(nullable = false)
    Long creator;

    @Column(nullable = false)
    String Access;

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

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
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

    public Abilities getAbility() {
        return Ability;
    }

    public void setAbility(Abilities ability) {
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

    public Pokedex getDexes() {
        return dexes;
    }

    public void setDexes(Pokedex dexes) {
        this.dexes = dexes;
    }

    public Set<User> getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(Set<User> upVotes) {
        this.upVotes = upVotes;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public String getAccess() {
        return Access;
    }

    public void setAccess(String access) {
        Access = access;
    }
}
