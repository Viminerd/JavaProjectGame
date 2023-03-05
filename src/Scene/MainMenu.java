/**
 * 
 */
package Scene;

import GamePackage.GameProgram;
import GamePackage.ProjectMain;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author Viktor
 *
 */
public class MainMenu extends Canvas {

	/**
	 * 
	 */ 
	
	private GraphicsContext gc =  this.getGraphicsContext2D();
	private GameProgram g;
	private Pane pane = new Pane(); 
	public MainMenu() {
		pane.setPrefSize(ProjectMain.mainlayout.getWidth(),ProjectMain.mainlayout.getHeight());
		ProjectMain.mainlayout.setStyle("-fx-background-color: black;");
		ProjectMain.mainlayout.setCenter(pane);
		mainMenu();
		gameText(); 
		highScoreTable();
	}
	public MainMenu(String s) { // String constructor for gameOver menu
		pane.setPrefSize(ProjectMain.mainlayout.getWidth(),ProjectMain.mainlayout.getHeight());
		ProjectMain.mainlayout.setStyle("-fx-background-color: black;");
		ProjectMain.mainlayout.setCenter(pane);
		gameOverMenu(); 
	}
	
	private void gameText() {
		double startX = 300; 
		newLetter("G", Color.ORANGE,Color.BROWN, startX, 100);
		newLetter("e", Color.RED,Color.DARKRED, startX+40, 100);
		newLetter("o", Color.YELLOW,Color.DARKGOLDENROD, startX+80, 100);
		newLetter("p", Color.GREEN,Color.DARKGREEN, startX+120, 100);
		newLetter("o", Color.BLUE,Color.DARKBLUE, startX+160, 100);
		newLetter("c", Color.MAGENTA,Color.PURPLE, startX+200, 100);
		newLetter("a", Color.TURQUOISE ,Color.BLUE, startX+240, 100);
		newLetter("l", Color.CRIMSON,Color.RED, startX+280, 100);
		newLetter("y", Color.OLIVE,Color.GREEN, startX+320, 100);
		newLetter("p", Color.WHEAT,Color.DARKGOLDENROD, startX+360, 100);
		newLetter("s", Color.AZURE,Color.LIGHTBLUE, startX+400, 100);
		newLetter("e", Color.ORANGE,Color.CORAL, startX+440, 100);
	}
	
	private void highScoreTable() {
		double posX = 900;
		double posY = 50;
		Rectangle table = new Rectangle(posX, posY, 250, 430);
		table.setFill(Color.GREY);
		table.setStroke(Color.LIGHTGRAY);
		pane.getChildren().add(table); 
		Text highscore = newLetter("Highscores",Color.BLACK, Color.GREY, posX-2, posY+50);
		Line line = new Line(posX,posY+70,posX+250,posY+70);		
		pane.getChildren().add(line);
		
		//Structure of table
		Text easymap = newLetter("Easy Map:", Color.BLACK,null, posX, posY+90); 		
		easymap.setFont(Font.font("Verdana", FontWeight.LIGHT, 15));
		
		//1
		Text eone = newLetter("1-", Color.BLACK,null,15, posX, posY+110); 		
		Text easyone = newLetter("No entry", Color.BLACK,null,15,posX+20, posY+110);
		
		//2
		Text etwo = newLetter("2-", Color.BLACK,null, 15,posX, posY+142.5); 		
		Text easytwo = newLetter("No entry", Color.BLACK,null,15,posX+20, posY+142.5);
		//3 
		Text ethree = newLetter("3-", Color.BLACK,null, 15,posX, posY+175); 		
		Text easythree = newLetter("No entry", Color.BLACK,null,15,posX+20, posY+175);
		
		//4
		Text efour = newLetter("4-", Color.BLACK,null,15, posX, posY+207.5); 		
		Text easyfour = newLetter("No entry", Color.BLACK,null,15,posX+20, posY+207.5);
		
		//5 
		Text efive = newLetter("5-", Color.BLACK,null,15, posX, posY+240); 		
		Text easyfive = newLetter("No entry", Color.BLACK,null,15,posX+20, posY+240);
		
		Line line2 = new Line(posX,posY+250, posX+250, posY+250); 
		pane.getChildren().add(line2);
		//HARDMAP
		
		
		Text hardmap = newLetter("Hard Map:",Color.BLACK,null, posX,posY+270); 
		hardmap.setFont(Font.font("Verdana", FontWeight.LIGHT, 15));
		
		posY = posY +270-90;
		
		//1
		Text hone = newLetter("1-", Color.BLACK,null, 15,posX, posY+110); 		
		Text hardone = newLetter("No entry", Color.BLACK,null,15,posX+20, posY+110);
		//2
		Text htwo = newLetter("2-", Color.BLACK,null,15, posX, posY+142.5); 		
		Text hardtwo = newLetter("No entry", Color.BLACK,null,15,posX+20, posY+142.5);
		//3
		Text hthree = newLetter("3-", Color.BLACK,null,15, posX, posY+175); 		
		Text hardthree = newLetter("No entry", Color.BLACK,null,15,posX+20, posY+175);
		//4
		Text hfour = newLetter("4-", Color.BLACK,null,15, posX, posY+207.5); 		
		Text hardfour = newLetter("No entry", Color.BLACK,null,15,posX+20, posY+207.5);
		//5
		Text hfive = newLetter("5-", Color.BLACK,null,15, posX, posY+240); 		
		Text hardfive = newLetter("No entry", Color.BLACK,null,15,posX+20, posY+240);		
	}
	private Text newLetter(String texttext, Color f, Color s, double x, double y) {
		Text t = newLetter(texttext, f, s, 46, x, y);
		return t; 
	}
	private Text newLetter(String texttext, Color f, Color s, double fontsize, double x, double y) {
		Text text = new Text(texttext); 
		text.setLayoutX(x);
		text.setLayoutY(y);
		text.setFill(f);
		text.setStroke(s);
		text.setStrokeWidth(3);
		text.setFont(Font.font("Verdana", FontWeight.MEDIUM, fontsize));
		pane.getChildren().add(text);
		return text; 
	}
	
	
	private void mainMenu() {
		pane.getChildren().clear(); 
		gameText();
		highScoreTable();
		Button newgame = new Button("New Game"); 
		setPos(newgame,500,200); 
		pane.getChildren().add(newgame); 

		newgame.setOnMouseClicked(event -> {
			chooseDifficulty(); 
		});
	}
	
	private void gameOverMenu() {
		pane.getChildren().clear();
		Canvas c = new Canvas(200,50);
		c.setLayoutX(500);
		c.setLayoutY(100);
		GraphicsContext g = c.getGraphicsContext2D();
		g.setFill(null);	
		g.fillRect(0, 0, c.getWidth(), c.getHeight());
		g.setFill(Color.ORANGERED);
		g.fillText("You Died", 10, 25, 300);
		
		Button savescore = new Button("Save score");
		setPos(savescore, 500, 200); 
		
		savescore.setOnMouseClicked(event->{
			System.out.println(GameProgram.getScore());
			pane.getChildren().remove(savescore); 
			Rectangle entername = new Rectangle(savescore.getLayoutX(), savescore.getLayoutY(),90,20);
			entername.setFill(Color.GRAY);
			pane.getChildren().add(entername); 
			newLetter("Enter name", Color.BLACK, null, 12, savescore.getLayoutX()+10,savescore.getLayoutY()+14);
			Button enter = new Button("Enter"); 
			setPos(enter, 610,200);
			pane.getChildren().add(enter);
			enter.setOnMouseClicked(e->{
				System.out.println("Save to txt-file");
				enter.setOnMouseClicked(null); //cant save twice
			});

			
		});
		
		Button backtomain = new Button("Back to main menu"); 
		setPos(backtomain, 500, 300); 
		
		pane.getChildren().add(c);
		pane.getChildren().add(savescore);
		pane.getChildren().add(backtomain);
		highScoreTable();
		backtomain.setOnMouseClicked(event->{
			mainMenu(); 
		});
	}
	private void chooseDifficulty() {
		pane.getChildren().clear();
		gameText();
		highScoreTable();
		Button easy = new Button("Easy"); 
		setPos(easy, 450, 300); 
		Button hard = new Button("Hard"); 
		setPos(hard, 550,300); 
		
		Button back = new Button("Back");
		setPos(back, 500, 400); 
		pane.getChildren().add(easy); 
		pane.getChildren().add(hard); 
		pane.getChildren().add(back); 
		
		
		
		easy.setOnMouseClicked(event->{
			ProjectMain.mainlayout.getChildren().remove(this); 
			g.entityList.clear(); 
			g = new GameProgram("easy"); 
			
			g.gameRunning = true; 
		});
		hard.setOnMouseClicked(event ->{
			ProjectMain.mainlayout.getChildren().remove(this); 
			g.entityList.clear(); 
			g = new GameProgram("hard"); 
			
			g.gameRunning = true; 
		});
		
		back.setOnMouseClicked(event->{
			mainMenu(); 
		});
	}
	
	public static void gameOver() {
		ProjectMain.mainlayout.getChildren().clear();
		ProjectMain.mainlayout.getChildren().add(new MainMenu("Gameover")); 
	}
	
	private void setPos(Button b, double x, double y) {
		b.setLayoutX(x);
		b.setLayoutY(y);
	}

}
