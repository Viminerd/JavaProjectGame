/**
 * 
 */
package Scene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

import GamePackage.GameProgram;
import GamePackage.ProjectMain;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author Viktor
 * Main meny class. Defines behavior of main meny screen. 
 */
public class MainMenu extends Canvas {

	/**
	 * 
	 */ 
	
	private GraphicsContext gc =  this.getGraphicsContext2D();
	private GameProgram g;
	private Pane pane = new Pane(); 
	private String name = ""; 
	
	private ArrayList<String> highscores = new ArrayList<>();
	
	
	public MainMenu() {
		pane.setPrefSize(ProjectMain.mainlayout.getWidth(),ProjectMain.mainlayout.getHeight());
		ProjectMain.mainlayout.setStyle("-fx-background-color: black;");
		ProjectMain.mainlayout.setCenter(pane);
		mainMenu();
		
	}
	public MainMenu(String s) { // String in constructor for gameOver menu
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
		newLetter("Highscores",Color.BLACK, Color.GREY, posX-2, posY+50);
		Line line = new Line(posX,posY+70,posX+250,posY+70);		
		pane.getChildren().add(line);
		
		Text easymap = newLetter("Easy Map:", Color.BLACK,null, posX, posY+90); 		
		easymap.setFont(Font.font("Verdana", FontWeight.LIGHT, 15));
		
		//load from file
		highscores.clear();
		try {
			 BufferedReader reader = new BufferedReader(new FileReader("src/Scene/highscores.txt"));

		    String aline;
			while((aline = reader.readLine()) != null) {
				if (aline.equals("Easy Map")||aline.equals("Hard Map")) {
					//Do nothing on this line
				}
				else {
					highscores.add(aline);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
			
		double extraspace = 0; 
		int num = 1;
		
		for (int i = 1; i<=10; i++) {
			newLetter(num+"-",Color.BLACK,null,15, posX, posY+77.5+i*32.5+extraspace);
			newLetter(highscores.get(i-1),Color.BLACK,null,15, posX+20, posY+77.5+i*32.5+extraspace);
			num++;
			if (num>5) {
				extraspace = 17.5;
				num = 1; 
			}
		}
		Line line2 = new Line(posX,posY+250, posX+250, posY+250); 
		pane.getChildren().add(line2);
		//HARDMAP
		Text hardmap = newLetter("Hard Map:",Color.BLACK,null, posX,posY+270); 
		hardmap.setFont(Font.font("Verdana", FontWeight.LIGHT, 15));
		
		
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
		c.setLayoutX(450);
		c.setLayoutY(100);
		GraphicsContext g = c.getGraphicsContext2D();
		g.setFill(null);	
		g.fillRect(0, 0, c.getWidth(), c.getHeight());
		g.setFill(Color.ORANGERED);
		g.setFont(Font.font("Verdana", FontWeight.MEDIUM, 35));
		g.fillText("You Died", 0, 25, 250);
		
		
		Button savescore = new Button("Save score");
		setPos(savescore, 500, 200); 
		
		savescore.setOnMouseClicked(event->{
			pane.getChildren().remove(savescore); 
			Rectangle entername = new Rectangle(savescore.getLayoutX(), savescore.getLayoutY(),90,20);
			entername.setFill(Color.GRAY);
			pane.getChildren().add(entername); 
			Text enternametext = newLetter("Enter name", Color.BLACK, null, 12, savescore.getLayoutX()+10,savescore.getLayoutY()+14);
			Button enter = new Button("Enter"); 
			setPos(enter, 610,200);
			pane.getChildren().add(enter);
			
			entername.setOnKeyPressed(ee->{
				if (ee.getCode() == KeyCode.BACK_SPACE && name.length()>0) {
					name = name.substring(0, name.length() - 1);
				}
				if (name.length()<10) {
					if(ee.isShiftDown()) {
						name = name + ee.getText().toUpperCase();
						enternametext.setText(name);
					
					}
					else {						
						name = name + ee.getText();
						enternametext.setText(name);
					}
				}
				
			});
			entername.requestFocus();

			enter.setOnMouseClicked(e->{
				updateHighscores(name, GameProgram.getScore()); 
				mainMenu(); 
				
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
	
	private void updateHighscores(String name, int score) {
		File highscorefile = new File("src/Scene/highscores.txt"); 
		ArrayList<String> listToSaveAsTxt = new ArrayList<>();
		
		boolean startComparison = false; 
		
		String test = name + " - " + GameProgram.getScore();
		try {
			Scanner sc = new Scanner(highscorefile);
			while(sc.hasNextLine()) {
				String aline = sc.nextLine();
				if (GameProgram.getDiff().equals("easy")&&aline.equals("Easy Map")) {
					startComparison = true; 
				}
				else if (GameProgram.getDiff().equals("hard")&& aline.equals("Hard Map")) {
					startComparison = true; 
				}
				else if (aline.equals("Hard Map") && GameProgram.getDiff().equals("easy")) {
					startComparison = false; 
				}
				if (startComparison && aline.indexOf('-') != -1) {
					int linescore = Integer.valueOf(aline.substring(aline.indexOf('-')+2,aline.length())); 
					if (Integer.valueOf(test.substring(test.indexOf('-')+2,test.length())) > linescore) {
						listToSaveAsTxt.add(test);
						test = aline;
					}
					else {
						listToSaveAsTxt.add(aline);
					}
				}
				else {
					listToSaveAsTxt.add(aline); 
				}
				
			}
	        try {
	            FileWriter writer = new FileWriter("src/Scene/highscores.txt");
	            writer.write("");
	            for (String s : listToSaveAsTxt) {
	            	writer.write(s+System.lineSeparator()); 
	            }
	            writer.flush();
	            writer.close(); 
	        } catch (IOException e) {
	            System.out.println("An error occurred while clearing and writing the file: " + e.getMessage());
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		highscorefile = null; 
	}

}
