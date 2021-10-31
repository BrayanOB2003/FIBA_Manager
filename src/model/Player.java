package model;

public class Player {
	
	String name;
	String lastName;
	String age;
	String team;
	int pointsPerGame;
	int reboundsPerGame;
	int assistsPerGame;
	int robberiesPerGame;
	int blocksPerGame;
	
	public Player(String n,String l,String a,String t, int points,int rebounds,int assists,int robberies, int blocks) {
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

	public int getPointsPerGame() {
		return pointsPerGame;
	}

	public void setPointsPerGame(int pointsPerGame) {
		this.pointsPerGame = pointsPerGame;
	}

	public int getReboundsPerGame() {
		return reboundsPerGame;
	}

	public void setReboundsPerGame(int reboundsPerGame) {
		this.reboundsPerGame = reboundsPerGame;
	}

	public int getAssistsPerGame() {
		return assistsPerGame;
	}

	public void setAssistsPerGame(int assistsPerGame) {
		this.assistsPerGame = assistsPerGame;
	}

	public int getRobberiesPerGame() {
		return robberiesPerGame;
	}

	public void setRobberiesPerGame(int robberiesPerGame) {
		this.robberiesPerGame = robberiesPerGame;
	}

	public int getBlocksPerGame() {
		return blocksPerGame;
	}

	public void setBlocksPerGame(int blocksPerGame) {
		this.blocksPerGame = blocksPerGame;
	}
	
	

}
