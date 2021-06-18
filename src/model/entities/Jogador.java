package model.entities;

public class Jogador {

	private String team;
	private String modality;
	private String name;
	private Double height;
	private Integer age;
	private String position;

//Constructors
	public Jogador () {
	}

	public Jogador(String name, Double height, Integer age, String position, String team, String modality) {
		this.name = name;
		this.height = height;
		this.age = age;
		this.position = position;
		this.team = team;
		this.modality = modality;
	}

//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

//toString
	@Override
	public String toString() {
		return "Time "+team+":\n"+"Jogador "+name+" Idade: "+age+" Altura: "+String.format("%.2f", height)+" Jogando na posição: "+position
				+" Modalidade: "+modality;
	}
	
	
}
