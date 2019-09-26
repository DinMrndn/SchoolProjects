package pokemongame;

public class pokemons {

    private String name;
    public int health;
    private String skill1;
    private String skill2;
    private String skill3;

    public void setPokemon(String pn, int ph, String ps1, String ps2, String ps3) {
        this.name = pn;
        this.health = ph;
        this.skill1 = ps1;
        this.skill2 = ps2;
        this.skill3 = ps3;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        if (this.health < 0) {
            return 0;
        } else {
            return this.health;
        }
    }

    public String getSkill1() {
        return this.skill1;
    }

    public String getSkill2() {
        return this.skill2;
    }

    public String getSkill3() {
        return this.skill3;
    }
}
