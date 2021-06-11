public class Project {
	private String name;
	private String desc;
	public Project() {}
	public Project(String name) {
		this.name = name;
	}
	public Project(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return this.desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String elevatorPitch() {
		return String.format("%s : %s", this.name, this.desc);
	}

}
