import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.CompetitionClassificationHelper;
import model.Competition;
import model.CompetitionClassification;
import model.MarchingBand;

/**
 * @author Austin Donald - ajdonald
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */
public class CompetitionTester {
	public static void main(String [] args) {
		Competition linmar = new Competition("Linmar",3, 5);
		
		MarchingBand norwalk = new MarchingBand (3, 150, "Sweet Dreamz");
		MarchingBand  indianola = new MarchingBand (4, 200, "Phantom");
		MarchingBand johnston = new MarchingBand (3, 250, "007");
		MarchingBand urbandale = new MarchingBand (5, 275, "Juxtaposition");
		MarchingBand valley = new MarchingBand (6, 300, "Wind, Earth, and Firebird");
		List<MarchingBand> bandsInCompetition = new ArrayList<MarchingBand>();
		bandsInCompetition.add(norwalk);
		bandsInCompetition.add(indianola);
		bandsInCompetition.add(johnston);
		bandsInCompetition.add(urbandale);
		bandsInCompetition.add(valley);
		CompetitionClassificationHelper ldh = new CompetitionClassificationHelper();
		CompetitionClassification competitionBands = new CompetitionClassification("4a", linmar, bandsInCompetition);
		competitionBands.setListOfBands(bandsInCompetition);
		ldh.insertNewCompetitionClassification(competitionBands);
		List<CompetitionClassification> allLists = ldh.getCompetitions();
		for(CompetitionClassification a: allLists) {
			System.out.println(a.toString());
		
	}
}
}
