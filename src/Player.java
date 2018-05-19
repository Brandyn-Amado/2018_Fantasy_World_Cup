
public class Player {
	
	private IndividualStats recentGame;
	private IndividualStats allGames;
	
	public Player(String name, String position, String team) {
		recentGame = new IndividualStats(name, position, team);
		allGames = new IndividualStats(name, position, team);
	}
	
	public IndividualStats recentGames() {
		return recentGame;
	}
	
	public IndividualStats allGames() {
		return allGames;
	}
	
	public String toString() {
		return allGames.toString();
	}
}
