package model;

import javafx.beans.property.SimpleStringProperty;

public class Player {
	
		private SimpleStringProperty name, age, team, totalRebounds, offensiveRebounds, blocks, trueShooting, freeThrow;

		public String getName() {
			return name.get();
		}

		public String getAge() {
			return age.get();
		}

		public String getTeam() {
			return team.get();
		}

		public String getTotalRebounds() {
			return totalRebounds.get();
		}

		public String getOffensiveRebounds() {
			return offensiveRebounds.get();
		}

		public String getBlocks() {
			return blocks.get();
		}

		public String getTrueShooting() {
			return trueShooting.get();
		}

		public String getFreeThrow() {
			return freeThrow.get();
		}

		public Player(String name, String age, String team,
				String totalRebounds, String offensiveRebounds, String blocks,
				String trueShooting, String freeThrow) {
			
			this.name = new SimpleStringProperty(name);
			this.age = new SimpleStringProperty(age);
			this.team = new SimpleStringProperty(team);
			this.totalRebounds = new SimpleStringProperty(totalRebounds);
			this.offensiveRebounds = new SimpleStringProperty(offensiveRebounds);
			this.blocks = new SimpleStringProperty(blocks);
			this.trueShooting = new SimpleStringProperty(trueShooting);
			this.freeThrow = new SimpleStringProperty(freeThrow);
		}

}