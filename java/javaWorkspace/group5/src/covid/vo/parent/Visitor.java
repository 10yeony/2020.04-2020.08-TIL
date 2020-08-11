package covid.vo.parent;

import covid.util.Fever;

public class Visitor {
	private String name;
	private boolean mask;
	private Fever fever = new Fever();
	private String symptom;
	
	public Visitor() {}
	public Visitor(String name, boolean mask, Fever fever) {
		this.name = name;
		this.mask = mask;
		this.fever = fever;
	}
	public Visitor(String name, boolean mask, Fever fever, String symptom) {
		this.name = name;
		this.mask = mask;
		this.fever = fever;
		this.symptom = symptom;
	} 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isMask() {
		return mask;
	}
	public void setMask(boolean mask) {
		this.mask = mask;
	}
	public Fever getFever() {
		return fever;
	}
	public void setFever(Fever fever) {
		this.fever = fever;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	@Override
	public String toString() {
		return "Visitor [name=" + name + ", mask=" + mask + ", fever=" + fever + ", symptom=" + symptom + "]";
	}
}
