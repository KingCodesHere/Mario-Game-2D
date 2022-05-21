package game.roles;

/**
 * Use this enum class to give `buff` or `debuff`.
 * It is also useful to give a `state` to abilities or actions that can be attached-detached.
 */
public enum Status {
    HOSTILE_TO_ENEMY,// use this status to be considered hostile towards enemy (e.g., to be attacked by enemy).
    HOSTILE_TO_PLAYER,// use this status to be considered hostile towards player (e.g., to be attacked by player).
    TALL, // use this status to tell that current instance has "grown".
    FERTILE, // use this status for ground that grow on.
    INVINCIBLE, // use this status when player consumes PowerStar as upgrade.
    NPC, // use this status for Actors that are non playable characters, likely to be friendly.
    WRENCH, // use this status for Player when the item Wrench is able for this player when the Item Wrench is usable.
    COIN, //use this status for Wallet to identify the Item type.
    KOOPA,//use this status to identify Koopa when it is alive so it can be removed and changed to Dormant
    DORMANT, // use this status for the Dormant State of Koopa, when it is Hiding in its shell.
    PowerWater, // use this status for the Player after consuming PowerWater.
    FIRE, // use this status for the player after consuming Fire Flower.
    KEY// use this status on the ground that Bowser is killed for Key to unlock PrincessPeach's handcuffs
}
