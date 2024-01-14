package farming2;

public class Farmer {
	private int id;
	private String name;

	public Farmer(int id, String name) {
		this.id = id;
		this.name = name;
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

	
	public String toString() {
		return "Farmer [id=" + id + ", name=" + name + "]";
	}

}
