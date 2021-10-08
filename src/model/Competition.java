package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Austin Donald - ajdonald
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */
@Entity
@Table(name="Competition")
public class Competition {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="name")
	private String competitionName;
	@Column(name="numOfJudges")
	private int numOfJudges;
	@Column(name="numOfBands")
	private int numOfBands;
	/**
	 * 
	 */
	public Competition() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param competitionName
	 * @param numOfJudges
	 * @param numOfBands
	 */
	public Competition(String competitionName, int numOfJudges, int numOfBands) {
		super();
		this.competitionName = competitionName;
		this.numOfJudges = numOfJudges;
		this.numOfBands = numOfBands;
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
	 * @return the competitionName
	 */
	public String getCompetitionName() {
		return competitionName;
	}
	/**
	 * @param competitionName the competitionName to set
	 */
	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}
	/**
	 * @return the numOfJudges
	 */
	public int getNumOfJudges() {
		return numOfJudges;
	}
	/**
	 * @param numOfJudges the numOfJudges to set
	 */
	public void setNumOfJudges(int numOfJudges) {
		this.numOfJudges = numOfJudges;
	}
	/**
	 * @return the numOfBands
	 */
	public int getNumOfBands() {
		return numOfBands;
	}
	/**
	 * @param numOfBands the numOfBands to set
	 */
	public void setNumOfBands(int numOfBands) {
		this.numOfBands = numOfBands;
	}
	@Override
	public String toString() {
		return "Competition [id=" + id + ", competitionName=" + competitionName + ", numOfJudges=" + numOfJudges
				+ ", numOfBands=" + numOfBands + "]";
	}
}
