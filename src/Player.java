import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    public String name;
    public int value;

    public Player(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public boolean equals(Object obj) {
        Player other = (Player) obj;

        if (name.equals(other.name) && value == other.value)
            return true;

        return false;
    }

    /*
    public int hashCode() {
        return name.hashCode();
    }
    */

    public static void main(String[] args) {
        Player player1 = new Player("Kobe Braynt", 24);
        Player player2 = new Player("Michael Jordan", 23);

        HashMap<Player, Integer> playerMap = new HashMap<>();
        playerMap.put(player1, 33643);
        playerMap.put(player2, 32292);

        Player player3 = new Player("Kobe Braynt", 24);

        System.out.println(playerMap.get(player3));

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        System.out.println(players.contains(player3));
    }
}
