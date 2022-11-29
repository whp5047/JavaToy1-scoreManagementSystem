package TestMain;

import school.School;
import school.Score;
import school.Student;
import school.Subject;
import school.report.GenerateGradeReport;
import utils.Define;

public class TestMain {

	School school = School.getInstance();
	Subject math;
	Subject korean;
	Subject dance;
	
	
	GenerateGradeReport gradeReport = new GenerateGradeReport();
	
	public static void main(String[] args) {
		
		TestMain test = new TestMain();
		
		test.createSubject();
		test.createStudent();
		
		String report = test.gradeReport.getReport(); //���� ��� ����
		System.out.println(report); // ���
		
	}
	
	public void createSubject() {
		korean = new Subject("����", Define.KOREAN);
		math = new Subject("����", Define.MATH);
		dance = new Subject("��۴�", Define.DANCE);
		dance.setGradeType(Define.PF_TYPE); // �⺻�� A,B Ÿ���̱� ������ �����ʿ�
		
		school.addSubject(korean);
		school.addSubject(math);
		school.addSubject(dance);
		
	}
	
	public void createStudent() {
		
		Student std1 = new Student(211213, "������", korean);
		Student std2 = new Student(212330, "������", math);
		Student std3 = new Student(201518, "�Ż��Ӵ�", korean);
		Student std4 = new Student(202360, "�̼���", korean);
		Student std5 = new Student(201290, "ȫ�浿", math);
		
		school.addStudent(std1);
		school.addStudent(std2);
		school.addStudent(std3);
		school.addStudent(std4);
		school.addStudent(std5);
		
		korean.register(std1);
		korean.register(std2);
		korean.register(std3);
		korean.register(std4);
		korean.register(std5);
		
		math.register(std1);
		math.register(std2);
		math.register(std3);
		math.register(std4);
		math.register(std5);
		
		dance.register(std1);
		dance.register(std2);
		dance.register(std3);
		
		addScoreForeStudent(std1, korean, 95);
		addScoreForeStudent(std1, math, 56);
		
		addScoreForeStudent(std2, korean, 95);
		addScoreForeStudent(std2, math, 95);
		
		addScoreForeStudent(std3, korean, 100);
		addScoreForeStudent(std3, math, 88);
		
		addScoreForeStudent(std4, korean, 89);
		addScoreForeStudent(std4, math, 95);
		
		addScoreForeStudent(std5, korean, 85);
		addScoreForeStudent(std5, math, 56);
	
		addScoreForeStudent(std1, dance, 95);
		addScoreForeStudent(std2, dance, 85);
		addScoreForeStudent(std3, dance, 55);
		
	}
	
	public void addScoreForeStudent(Student student, Subject subject, int point) {
		
		Score score = new Score(student.getStudentId(), subject, point);
		student.addSubjectScore(score);
	}
 
}
