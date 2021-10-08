package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Austin Donald - ajdonald
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */
@Entity
@Table(name="competitionclassification")
public class CompetitionClassification {
	@Id
	@GeneratedValue
	private int id;
	private String classification;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Competition competition;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<MarchingBand> listOfBands;
	/**
	 * 
	 */
	public CompetitionClassification() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param classification
	 * @param competition
	 * @param listOfBands
	 */
	public CompetitionClassification(String classification, Competition competition, List<MarchingBand> listOfBands) {
		super();
		this.classification = classification;
		this.competition = competition;
		this.listOfBands = listOfBands;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the classification
	 */
	public String getClassification() {
		return classification;
	}
	/**
	 * @param classification the classification to set
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}
	/**
	 * @return the competition
	 */
	public Competition getCompetition() {
		return competition;
	}
	/**
	 * @param competition the competition to set
	 */
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	/**
	 * @return the listOfBands
	 */
	public List<MarchingBand> getListOfBands() {
		return listOfBands;
	}
	/**
	 * @param listOfBands the listOfBands to set
	 */
	public void setListOfBands(List<MarchingBand> listOfBands) {
		this.listOfBands = listOfBands;
	}
	@Override
	public String toString() {
		return "CompetitionClassification [id=" + id + ", classification=" + classification + ", competition="
				+ competition + ", listOfBands=" + listOfBands + "]";
	}
}
