package GamePackage;

public class GameProgram {
	public GameProgram(String difficulty) {
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
