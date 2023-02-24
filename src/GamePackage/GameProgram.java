package GamePackage;

public class GameProgram {
	public GameProgram(String difficulty) {
<<<<<<< HEAD
		Scene.EasyMap map = new Scene.EasyMap(ProjectMain.gameCanvas);
	}
	
	public void EasyMap() {
		
=======
		if (difficulty.equals("easy")) {
			easyMap();
		}
		else if (difficulty.equals("hard")) {
			hardMap();
		}
>>>>>>> a10f97638e3d321e52655129d5fb74b99762d595
	}

	public void easyMap() {
		Scene.EasyMap map = new Scene.EasyMap();
	}

	public void hardMap() {
		Scene.HardMap map = new Scene.HardMap();
	}
}
