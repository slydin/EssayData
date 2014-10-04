package slydin.personal;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class WordCounter {
	private int wordDef = 3;
	private char[] sentEnd = {'.','\n'};
	private int totalNumWords = 0;
	private int totalNumSent = 0;
	private double avgNumWords = 0;
	private File f;
	public WordCounter(String fileName){
		this.f = new File(fileName);
	}
	
	public WordCounter(String fileName, int wordDef, char[] sentEnd){
		this.f = new File(fileName);
		this.wordDef = wordDef;
		this.sentEnd = sentEnd;
	}
	
	private boolean fileCheck(String fileName){
		return false;
	}
	
	
	
	public double averageWordsPerSentence(){
		Charset charset = Charset.forName("US-ASCII");
		try(BufferedReader reader = Files.newBufferedReader(this.f.toPath(), charset)) {
			String line = null;
			char[] chars = null;
			int counter = 0;
			while((line = reader.readLine()) != null) {
				chars = line.toCharArray();
				counter = 0;
				for(char c:chars){
					if(Character.isLetter(c))
						counter++; // keep counting
					else if(c == ' ' && counter >= this.wordDef){
						counter = 0;
						this.totalNumWords++; // when we have reached a space
					}
					else{
						for(char d: this.sentEnd){
							if(counter >= this.wordDef)
								this.totalNumWords++;
							if(c == d){
								this.totalNumSent++;
								break;
							}
						}
					}
				}
			}
		} catch (IOException e){
			System.err.format("IOException: %s%n", e);
		}
		
		this.avgNumWords = (this.totalNumWords*1.0)/(this.totalNumSent*1.0);
		return this.avgNumWords;
	}
	
	public double totalNumberOfWords(){
		return this.totalNumWords;
	}
	
	public double totalNumberOfSentences(){
		return this.totalNumSent;
	}
}
