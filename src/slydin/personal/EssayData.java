package slydin.personal;

public class EssayData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordCounter wordCount = new WordCounter("test.txt");
		System.out.println("The average number of words per sentence: " + wordCount.averageWordsPerSentence());
		System.out.println("The number of words in the text following the word definition: " + wordCount.totalNumberOfWords());
		System.out.println("The number of sentences in the text following the sentence definition: " + wordCount.totalNumberOfSentences());
	}

}
