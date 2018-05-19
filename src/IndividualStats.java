
public class IndividualStats {
	
	private final String name;
	private final String position;
	private final String team;
	private int cost;
	private int games;
	private int goals;
	private int assists;
	private int minutes;
	private int cleanSheets;
	private int goalsConceded;
	private int ownGoals;
	private int yellowCards;
	private int redCards;
	private int points;
	
	public IndividualStats(String name, String position, String team) {
		this.name = name;
		this.position= position;
		this.team = team;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public void setCleanSheets(int cleanSheets) {
		this.cleanSheets = cleanSheets;
	}

	public void setGoalsConceded(int goalsConceded) {
		this.goalsConceded = goalsConceded;
	}

	public void setOwnGoals(int ownGoals) {
		this.ownGoals = ownGoals;
	}

	public void setYellowCards(int yellowCards) {
		this.yellowCards = yellowCards;
	}

	public void setRedCards(int redCards) {
		this.redCards = redCards;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public String toString() {
		return name + "," + team + "," + position + "," + points + "," + cost;
	}

}
