package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Austin Donald - ajdonald
 * CIS175 - Fall 2021
 * Sep 14, 2021
 */
@Entity
@Table(name="bands")
public class MarchingBand {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
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
	@Column(name="MovementNum")
	private int numOfMovements;
	@Column(name ="MarcherNum")
	private int numOfMarchers;
	@Column(name="showName")
	private String showName;
	public MarchingBand () {
		
	}
	public MarchingBand (int numOfMovements, int numOfMarchers, String showName) {
		this.numOfMovements = numOfMovements;
		this.numOfMarchers = numOfMarchers;
		this.showName = showName;
	}
	/**
	 * @return the numOfMovements
	 */
	public int getNumOfMovements() {
		return numOfMovements;
	}
	/**
	 * @param numOfMovements the numOfMovements to set
	 */
	public void setNumOfMovements(int numOfMovements) {
		this.numOfMovements = numOfMovements;
	}
	/**
	 * @return the numOfMarchers
	 */
	public int getNumOfMarchers() {
		return numOfMarchers;
	}
	/**
	 * @param numOfMarchers the numOfMarchers to set
	 */
	public void setNumOfMarchers(int numOfMarchers) {
		this.numOfMarchers = numOfMarchers;
	}
	/**
	 * @return the numOfInstruments
	 */
	public String getShowName() {
		return showName;
	}
	/**
	 * @param numOfInstruments the numOfInstruments to set
	 */
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public String marchingBandDetails() {
		return "The number of movements is: "+this.numOfMovements+", the show name is: "+this.showName+", the number of marchers is: "+this.numOfMarchers;
	}
}
