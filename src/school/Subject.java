package school;

import java.util.ArrayList;

import utils.Define;

public class Subject {
	
	private String subjectName;   // ���� �̸�
	private int subjectId;        // ���� �ڵ�
	private int gradeType; 		  // ���� �� ��� �⺻ A, B���
	
	//������û �л�����Ʈ
	private ArrayList<Student> studentList = new ArrayList<Student>(); // register() �޼��� ȣ��� add

	public Subject(String subjectName, int subjectId) {
		this.subjectName = subjectName;
		this.subjectId = subjectId;
		this.gradeType = Define.AB_TYPE; // �⺻������ A,BŸ��
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getGradeType() {
		return gradeType;
	}

	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void register(Student student) {
		studentList.add(student);
	}
	
	
	
}
