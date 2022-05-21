package game.roles.Enemies;

import game.roles.Status;

public class FlyingKoopa extends Enemy {

    public FlyingKoopa() {
        super("FlyingKoopa", 'F', 150, 30 ,"punches");
        this.addCapability(Status.KOOPA);
    }

    //FlyCapable
    //Be aware of LSP violation

}
