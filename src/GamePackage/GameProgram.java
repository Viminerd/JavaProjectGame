package GamePackage;

public class GameProgram {
	private String difficulty; 
	public GameProgram(String difficulty) {
		this.difficulty = difficulty; 
		//Scene.EasyMap map = new Scene.EasyMap();
		Map();

	}
	
	public void Map() {
		

		if (difficulty.equals("easy")) {
			easyMap();
		}
		else if (difficulty.equals("hard")) {
			hardMap();
		}
		

	}

	public void easyMap() {
		Scene.EasyMap map = new Scene.EasyMap();
	}

	public void hardMap() {
		Scene.HardMap map = new Scene.HardMap();
	}
}
