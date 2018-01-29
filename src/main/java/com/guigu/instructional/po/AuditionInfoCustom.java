package com.guigu.instructional.po;

public class AuditionInfoCustom extends AuditionInfo{

	private String disciplineName;

	private String studentName;
	
	public AuditionInfoCustom() {
		super();
	}

	public String getDisciplineName() {
		return disciplineName;
	}

	public void setDisciplineName(String disciplineName) {
		this.disciplineName = disciplineName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
