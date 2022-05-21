package game.roles.Enemies;

public class PiranhaPlant extends Enemy{
    /**
     * Constructor
     * the general Enemy constructor with set default behaviours
     *
     * @param name         for this current Enemy name
     * @param displayChar  the display of character on map this enemy carry
     * @param hitPoints    the hit point of this enemy
     * @param attackDamage the damage this enemy carries
     * @param verb         the verb that will display for the enemy when the attack occur
     */
    public PiranhaPlant(String name, char displayChar, int hitPoints, int attackDamage, String verb) {
        super("Piranha Plant", 'Y', 150, 90, "chomps");

    }
}
