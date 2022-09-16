package model;

import java.util.ArrayList;
import java.util.Random;

public class TruthOrDare {
	String prompt;
	
	/**
	 * Default constructor with no parameters
	 */
	public TruthOrDare() {

	}

	/**
	 * Constructor with prompt as parameter, determines if user selected truth or
	 * dare
	 * @param prompt user selection if truth or dare
	 */
	public TruthOrDare(String prompt) {
		if (prompt != null) {
			setPrompt(TruthOrDare.getRandomTruth());

		} else {
			setPrompt(TruthOrDare.getRandomDare());
		}
	}

	/**
	 * Getter for prompt
	 */
	public String getPrompt() {
		return prompt;
	}

	/**
	 * Setter for prompt
	 */
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	/**
	 * Randomly generates a truth question to be asked
	 * @return truth String 
	 */
	public static String getRandomTruth() {
		ArrayList<String> truth = new ArrayList<String>(); // Create an ArrayList truth object
		truth.add("Truth: Who is your favorate coworker?");
		truth.add("Truth: Why did you decide to become a Software Engineer?");
		truth.add("Truth: What programming languages do you prefer?");
		truth.add("Truth: Say something nice about the QA team");
		truth.add("Truth: What is your favorate design pattern");
		truth.add("Truth: What is your greatest strength as a software developer?");
		truth.add("Truth: What is your greatest weakness as a software developer?");
		truth.add("Truth: What do you like best about being a software developer?");
		truth.add("Truth: What do you like least about being a software developer? ");

		Random random = new Random();
		// random index between 0 and truth.size();
		int randomIndex = random.nextInt(truth.size());
		return truth.get(randomIndex);

	}

	/**
	 * Randomly generates a dare question to be asked
	 * @return dare String 
	 */
	public static String getRandomDare() {
		ArrayList<String> dare = new ArrayList<String>(); // Create an ArrayList truth object
		dare.add("Dare: Learn Swift programming languge.");
		dare.add("Dare: Compliment someone on their pull request.");
		dare.add("Dare: Mentor an intern or junior developer.");
		dare.add("Dare: Signup to present at the next software conference");
		dare.add("Dare: Learn about a part of the codebase that you think is too hard to understand.");
		dare.add("Dare: Go out to lunch with the QA team.");
		dare.add("Dare: Ask for a promotion.");
		dare.add("Dare: Learn about data structures in the lanuguge of your choice.");
		dare.add("Dare: Take a class at programming DMACC.");

		Random random = new Random();
		// random index between 0 and truth.size();
		int randomIndex = random.nextInt(dare.size());
		return dare.get(randomIndex);

	}

	@Override
	public String toString() {
		return "TruthOrDare [prompt=" + getPrompt() + "]";
	}

}
