package sentimentAnalysis;

import java.io.FileInputStream;
import java.util.List;

import parseCorpus.Parse;

public class Analyze {
	SentimentAnalyzer analyzer;
	Parse parser;
	
	public Analyze() {
		parser = new Parse();
		analyzer = new SentimentAnalyzer();
	}
	public static void main(String[] args) throws Exception {
		
		Analyze a = new Analyze(); 
		a.parser.parse();
		a.analyzer.read(new FileInputStream("Stanford depTrees.txt"), a.parser.getWords().getWordBucket());
		List<SentimentScore> scores = a.analyzer.getScores();
		for (int i = 0; i < scores.size(); i++) {
			SentimentScore score = scores.get(i);
			System.out.println(score.getScore());
		}
	}

}
