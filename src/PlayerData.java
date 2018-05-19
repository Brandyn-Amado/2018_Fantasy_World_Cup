import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PlayerData {
	Player[] players = new Player[23 * 32];
	

	public PlayerData() {
		Team[] teams = null;
		try {
			teams = inputPlayers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < teams.length; i++) {
			for(int j = 0; j < teams[i].team.length; j++) {
				players[(i * 23) + j]= teams[i].team[j];
			}
		}
	}
	
	private Team[] inputPlayers() throws IOException {
		String team = null;
		Team[] teams = new Team[32];
		int teamNumbers = 0;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader((new URL("https://en.wikipedia.org/wiki/2018_FIFA_World_Cup_squads")).openConnection().getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		if(reader != null) {
			line = reader.readLine();
		}
		
		while (line != null && line.contains("\"The 29-man preliminary squad was announced on 13 May 2018.\"")) {
			line = reader.readLine();
		}
		
		while (line != null && !line.equals("</body>")) {
			if(line.contains("<span class=\"mw-headline\" id=\"") && !line.contains("Group") && !line.contains("Statistics") && !line.contains("Coaches") && !line.contains("References") && !line.contains("External")) {
				team = line.substring(line.indexOf("\">") + 2, line.indexOf("</span>"));
				teams[teamNumbers] = new Team(23, team);
				teamNumbers++;
			}
			if(line.contains("Goalkeeper")) {
				line = reader.readLine();
				teams[teamNumbers - 1].addPlayer(line.substring(21, line.indexOf("\" scope")), "GK");
			}
			if(line.contains("Defender")) {
				line = reader.readLine();
				teams[teamNumbers - 1].addPlayer(line.substring(21, line.indexOf("\" scope")), "DF");
			}
			if(line.contains("Midfielder")) {
				line = reader.readLine();
				teams[teamNumbers - 1].addPlayer(line.substring(21, line.indexOf("\" scope")), "MD");
			}
			if(line.contains("Forward")) {
				line = reader.readLine();
				teams[teamNumbers - 1].addPlayer(line.substring(21, line.indexOf("\" scope")), "FW");
			}
			if(line != null)
				line = reader.readLine();
		}
		return teams;
	}
	
	private class Team {
		private Player[] team;
		private int track = 0;
		private String nationality = null;
		
		public Team(int size, String nationality) {
			team = new Player[size];
			this.nationality = nationality;
		}
		
		public void addPlayer(String name, String position) {
			if(track < 23) {
				this.team[track] = new Player(name, position, nationality);
				track++;
			}
		}
	}
	
	public String toString() {
		String to = "Name,team,position,points,cost";
		for(Player player : players) {
			to += player + "\n";
		}
		return to;
	}
}
