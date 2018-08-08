package Chat;


/*
 * Date: 1/9/2018
 * Basic chat application between server and client. 
 * set Bool isServer to false and rerun after starting as server
 */
import javafx.application.Platform;


import java.text.DateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ChatApp extends Application {

	private boolean isServer = false; //change this to false after running and rerun to have both client and server running
	
	private TextArea messages = new TextArea();

	private NetworkConnection connection = isServer ? createServer() : createClient();
		
	private Parent createContent() {

		messages.setPrefHeight(550);

		TextField input = new TextField();
		input.setStyle("-fx-background-color : #78CCDF"); //medium blue

		input.setOnAction(event -> {
			
			//formatted time
			Date now = new Date();
			DateFormat time = DateFormat.getTimeInstance();	
			String timeStamp = time.format(now);
			
			
			String message = isServer ? timeStamp + ": Server: " : timeStamp + ": Client: "; //If person is server uses Server prefix otherwise Client prefix
			message += input.getText();
			input.clear();
			
			messages.appendText(message + "\n");

			
			try {
				connection.send(message);
			}
			catch (Exception e) {
				messages.appendText("Failed to send message. \n");
			}
		});
		
		VBox root = new VBox(20, messages, input);
		root.setPrefSize(600, 600);
		root.setStyle("-fx-background-color : #B9F2FF"); //light blue
		return root;
	}
	
	public void init() throws Exception{
		connection.startConnection();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ChatApp"); //Title at the top of the application		
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.show();
	}

	public void stop() throws Exception{
		connection.closeConnection();
	}

	private Server createServer() {
		return new Server(55555, data -> {
			Platform.runLater(() -> {
				
				//for time
				Date now = new Date();
				DateFormat time = DateFormat.getTimeInstance();			
				
				messages.appendText(data.toString() + "\n");
			});
		});
	}

	private Client createClient() {
		return new Client("127.0.0.1", 55555, data -> { // for internal network use internal ip, if over internet use external ip for the server
			Platform.runLater(() -> {

				
				messages.appendText(data.toString() + "\n");
			});
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
