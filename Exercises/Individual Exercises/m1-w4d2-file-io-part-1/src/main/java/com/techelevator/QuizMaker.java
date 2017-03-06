package com.techelevator;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {
	private List<QuizQuestion> quizQuestions;
	
	public QuizMaker() {
		quizQuestions = new ArrayList<QuizQuestion>();
	}

	public static void main(String[] args) {
		QuizMaker quizMaker = new QuizMaker();
		
		try (Scanner userInput = new Scanner(System.in)) {
			System.out.print("Enter File Path >>> ");
			String filePath = userInput.nextLine();
			
			try {
				File quizFile = quizMaker.getQuizFile(filePath);
				try (Scanner fileInput = new Scanner(quizFile)) {
					while (fileInput.hasNextLine()) {
						String quizQuestionFromFile = fileInput.nextLine();
						quizMaker.quizQuestions.add(new QuizQuestion(quizQuestionFromFile));
					}
				}
			} catch (FileNotFoundException ex) {
				System.out.println(ex.getMessage());
				System.exit(1);
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
				System.exit(1);
			}
			
			quizMaker.askQuestions(userInput);
		}
	}

	public void askQuestions(Scanner scanner) {
		int totalQuestionsAsked = 0;
		int totalCorrectAnswers = 0;
		
			for (QuizQuestion question : this.quizQuestions) {
				System.out.println(question);

				System.out.println("Your answer: ");

				int answer = Integer.parseInt(scanner.nextLine());

				if (answer == question.getCorrectAnswerIndex()) {
					System.out.println("CORRECT!");
					totalCorrectAnswers++;
				} else {
					System.out.println("WRONG!");
				}
				
				totalQuestionsAsked++;
			}
			
			System.out.println();
			System.out.println("You got " + totalCorrectAnswers + " answers correct out of a total " + totalQuestionsAsked + " questions asked.");
	}
	
	public File getQuizFile(String filePath) throws IOException {
		File quizFile = new File(filePath);
		
		if (!quizFile.exists()) {
			throw new FileNotFoundException("Search file: " + filePath + " does not exist.");
		}
		
		if (!quizFile.isFile()) {
			throw new IOException("Search file: " + filePath + " exists but is not a file.");
		}
		
		return quizFile;
	}

}
