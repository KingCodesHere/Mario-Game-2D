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
        if(this.hasCapability(Status.DORMANT)) {
            actions.clear();
        }
        if(otherActor.hasCapability(Status.WRENCH) && this.hasCapability(Status.DORMANT)){
            actions.add(new DestroyShellAction(this));
        }
        return actions;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if(!super.isConscious()){
            this.setDisplayChar('D');
            this.addCapability(Status.DORMANT);
        }
        return super.playTurn(actions,lastAction,map,display);

    }


}
