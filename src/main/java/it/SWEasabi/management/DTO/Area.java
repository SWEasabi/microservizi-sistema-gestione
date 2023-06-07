package it.SWEasabi.management.DTO;

public class Area {
	private int id;
	private String nome;
	private boolean auto;
	private int inf;
	private int sup;
	
	public Area() {
		this.id=0;
		this.nome="";
		this.auto=false;
		this.inf=0;
		this.sup=0;
	}
	
	public Area(int id, String nome, boolean auto, int inf, int sup) {
		super();
		this.id = id;
		this.nome = nome;
		this.auto = auto;
		this.inf = inf;
		this.sup = sup;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAuto() {
		return auto;
	}

	public void setAuto(boolean auto) {
		this.auto = auto;
	}

	public int getInf() {
		return inf;
	}

	public void setInf(int inf) {
		this.inf = inf;
	}

	public int getSup() {
		return sup;
	}

	public void setSup(int sup) {
		this.sup = sup;
	}
	
	
}
