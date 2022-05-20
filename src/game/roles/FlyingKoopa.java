package game.roles;

public class FlyingKoopa extends Enemy{
    /**
     * Constructor
     * the general Enemy constructor with set default behaviours
     *
     * @param name
     * @param displayChar
     * @param hitPoints
     * @param attackDamage
     * @param verb
     */
    public FlyingKoopa(String name, char displayChar, int hitPoints, int attackDamage, String verb) {
        super(name, displayChar, hitPoints, attackDamage, verb);
    }
}
