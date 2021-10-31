package model;

public class Player {
	
	String name;
	String lastName;
	String age;
	String team;
	String pointsPerGame;
	String reboundsPerGame;
	String assistsPerGame;
	String robberiesPerGame;
	String blocksPerGame;
	
	public Player(String n,String l,String a,String t, String points,String rebounds,String assists,String robberies, String blocks) {
		name = n;
		lastName=l;
		age = a;
		team = t;
		pointsPerGame = points;
		reboundsPerGame = rebounds;
		assistsPerGame = assists;
		robberiesPerGame = robberies;
		blocksPerGame = blocks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getPointsPerGame() {
		return pointsPerGame;
	}

	public void setPointsPerGame(String pointsPerGame) {
		this.pointsPerGame = pointsPerGame;
	}

	public String getReboundsPerGame() {
		return reboundsPerGame;
	}

	public void setReboundsPerGame(String reboundsPerGame) {
		this.reboundsPerGame = reboundsPerGame;
	}

	public String getAssistsPerGame() {
		return assistsPerGame;
	}

	public void setAssistsPerGame(String assistsPerGame) {
		this.assistsPerGame = assistsPerGame;
	}

	public String getRobberiesPerGame() {
		return robberiesPerGame;
	}

	public void setRobberiesPerGame(String robberiesPerGame) {
		this.robberiesPerGame = robberiesPerGame;
	}

	public String getBlocksPerGame() {
		return blocksPerGame;
	}

	public void setBlocksPerGame(String blocksPerGame) {
		this.blocksPerGame = blocksPerGame;
	}
	
	

}
