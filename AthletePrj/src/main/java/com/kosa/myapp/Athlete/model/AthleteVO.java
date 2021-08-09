package com.kosa.myapp.Athlete.model;

import java.sql.Date;

public class AthleteVO {
	private int id;
	private String name;
	private java.sql.Date birthDate;
	private String gender;
	private String sports;
	private int goldSolo;
	private int silverSolo;
	private int bronzeSolo;
	private int goldTeam;
	private int silverTeam;
	private int bronzeTeam;
	private int prize;
	
	
	public AthleteVO() {
		super();
	}
	public AthleteVO(int id, String name, Date birthDate, String gender, String sports, 
				int goldSolo, int silverSolo, int bronzeSolo, int goldTeam, int silverTeam, 
				int bronzeTeam, int prize) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.sports = sports;
		this.goldSolo = goldSolo;
		this.silverSolo = silverSolo;
		this.bronzeSolo = bronzeSolo;
		this.goldTeam = goldTeam;
		this.silverTeam = silverTeam;
		this.bronzeTeam = bronzeTeam;
		this.prize = prize;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public java.sql.Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(java.sql.Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSports() {
		return sports;
	}
	public void setSports(String sports) {
		this.sports = sports;
	}
	public int getGoldSolo() {
		return goldSolo;
	}
	public void setGoldSolo(int goldSolo) {
		this.goldSolo = goldSolo;
	}
	public int getSilverSolo() {
		return silverSolo;
	}
	public void setSilverSolo(int silverSolo) {
		this.silverSolo = silverSolo;
	}
	public int getBronzeSolo() {
		return bronzeSolo;
	}
	public void setBronzeSolo(int bronzeSolo) {
		this.bronzeSolo = bronzeSolo;
	}
	public int getGoldTeam() {
		return goldTeam;
	}
	public void setGoldTeam(int goldTeam) {
		this.goldTeam = goldTeam;
	}
	public int getSilverTeam() {
		return silverTeam;
	}
	public void setSilverTeam(int silverTeam) {
		this.silverTeam = silverTeam;
	}
	public int getBronzeTeam() {
		return bronzeTeam;
	}
	public void setBronzeTeam(int bronzeTeam) {
		this.bronzeTeam = bronzeTeam;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	@Override
	public String toString() {
		return "AthleteVO [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", gender=" + gender
				+ ", sports=" + sports + ", goldSolo=" + goldSolo + ", silverSolo=" + silverSolo + ", bronzeSolo="
				+ bronzeSolo + ", goldTeam=" + goldTeam + ", silverTeam=" + silverTeam + ", bronzeTeam=" + bronzeTeam
				+ ", prize=" + prize + "]";
	}
	
	
	
}
