package game.behaviours;

public interface SpeakCapable {

    default String speak(String name, String sentence) {
        return name + ": " +sentence;
    }

    String sentence = " ";


}
