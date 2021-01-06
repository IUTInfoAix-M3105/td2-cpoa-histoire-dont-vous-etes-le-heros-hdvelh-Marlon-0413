/**
 * File: NodeMultipleEvents.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

import java.util.Scanner;

import myUtils.ErrorNaiveHandler;

/**
 * @author prost
 *
 */
public class Event extends NodeMultiple {
	public static final String ERROR_MSG_UNEXPECTED_END = "Sorry, for some unexpected reason the story ends here...";
	public static final String PROMPT_ANSWER = "Answer: ";
	public static final String WARNING_MSG_INTEGER_EXPECTED = "Please input a integer within range!";



	/**
	 * this event's id
	 */
	private int id;

	/**
	 * the graphical user interface
	 */
	private GUIManager gui;

	//private Object data;

	/**
	 * the text version of the player's current answer
	 */
	private String playerAnswer;

	/**
	 * the daughter's index chosen for the next event
	 */
	private int chosenPath;

	/**
	 * The input reader
	 */
	private Scanner reader;

	/**
	 * the class variable to store the last id used
	 */
	static private int lastId = -1;


	/**
	 * @return the playerAnswer
	 */
	public String getPlayerAnswer() {
		/* TO BE COMPLETED */
		return playerAnswer;
	}

	/**
	 * @param playerAnswer the playerAnswer to set
	 */
	public void setPlayerAnswer(String playerAnswer) {
		/* TO BE COMPLETED */
		this.playerAnswer = playerAnswer;
	}

	/**
	 * @return the reader
	 */
	public Scanner getReader() {
		/* TO BE COMPLETED */
		return reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(Scanner reader) {
		/* TO BE COMPLETED */
		this.reader = reader;
	}

	/**
	 * @return the chosenPath
	 */
	public int getChosenPath() {
		/* TO BE COMPLETED */
		return chosenPath;
	}

	/**
	 * @param chosenPath the chosenPath to set
	 */
	public void setChosenPath(int chosenPath) {
		/* TO BE COMPLETED */
		this.chosenPath = chosenPath;
	}

	/* Methods */
	/**
	 * @see pracHDVELH.NodeMultiple#getData()
	 */
	public String getData() {
		/* TO BE COMPLETED */
		return (String) data;
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setData(Object)
	 * @param data
	 */
	public void setData(String data) {
		/* TO BE COMPLETED */
		this.data = data;
	}

	/**
	 * @see pracHDVELH.NodeMultiple#getDaughter(int)
	 */
	@Override
	public String toString() {
		/* TO BE COMPLETED */
		return "Event #"+ id + "("+getClass()+")"+":" +getData();
	}

	public Event getDaughter(int i) {
		/* TO BE COMPLETED */
		return getDaughter(i);
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setDaughter(NodeMultiple, int)
	 * @param daughter
	 * @param i
	 */
	public void setDaughter(Event daughter, int i) {
		/* TO BE COMPLETED */
		setDaughter(daughter,i);
	}

	/**
	 * @return the gui
	 */
	public GUIManager getGui() {
		/* TO BE COMPLETED */
		return gui;
	}

	/**
	 * @param gui the gui to set
	 */
	public void setGui(GUIManager gui) {
		/* TO BE COMPLETED */
		this.gui=gui;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		/* TO BE COMPLETED */
		return id;
	}

	/* Methods */
	/* TO BE COMPLETED */
	public void run(){
		/* print out the event description (i.e. this node's data) */
		gui.outputln(toString());
		/* wait for the player's answer, which must be a node index */
		gui.output(PROMPT_ANSWER);
		playerAnswer=reader.next();
		chosenPath=interpretAnswer();
		return getDaughter(chosenPath);


	}

	public boolean isFinal() {
		if (hasDaughters()){
			return false;
		}
		else {
			return true;
		}
	}

	/*public boolean isInRange(int index){

	}*/

	public int interpretAnswer(){
		System.out.println("Quel choix ?");
		Scanner clavier = new Scanner(System.in);
		/*String input = clavier.nextLine();
		System.out.println(input);*/
		int i = clavier.nextInt();
		return i;
	}

	//Constructors
	/**
	 * Default constructor.
	 */
	public Event() {
		this(new GUIManager(),"");

	}

	public Event(GUIManager gui, String data) {
		super(data);
		this.gui = gui;
		id = ++lastId;
		chosenPath = 0;
		reader = gui.getInputReader();

	}


}

// eof