package game.roles;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.AttackAction;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import java.util.HashMap;
import java.util.Map;

public class Koopa extends Enemy{
    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour

    public Koopa() {
        super("Koopa", 'K',100,30,"punches");
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions=super.allowableActions(otherActor,direction,map);
        if(!super.isConscious()){
            actions.clear();
            if
        }
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if(super.getMaxHp()<=0){
            map.removeActor(this);
        }
        else{
            return super.playTurn(actions,lastAction,map,display);
        }
        return new DoNothingAction();
    }

    @Override
    public char getDisplayChar() {
        if(this.hasCapability(Status.TALL)){
            return 'D';
        }
        return super.getDisplayChar();
    }
}
