package school.report;

import java.util.ArrayList;

import grade.BasicEvaluation;
import grade.GradeEvaluation;
import grade.MajorEvaluation;
import grade.PassFailEvaluation;
import school.School;
import school.Score;
import school.Student;
import school.Subject;
import utils.Define;

public class GenerateGradeReport {
	
	School school = School.getInstance();
	public static final String TITLE = " 수강생 학점 \t\t\n";
	public static final String HEADER = " 이름 | 학번 |중점과목|점수  \n";
	public static final String LINE = "--------------------------------\n";
	private StringBuffer buffer = new StringBuffer();
	
	public String getReport() {
		ArrayList<Subject> subjectList = school.getSubjectList();
		
		for(Subject subject : subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}
		
		return buffer.toString(); // String으로 반환
	}
	
	public void makeHeader(Subject subject) { 
		
		buffer.append(GenerateGradeReport.LINE);
		buffer.append("\t" + subject.getSubjectName());
		buffer.append(GenerateGradeReport.TITLE);
		buffer.append(GenerateGradeReport.HEADER);
		buffer.append(GenerateGradeReport.LINE);
	}
	
	public void makeBody(Subject subject) {
		
		ArrayList<Student> studentList = subject.getStudentList(); // 각 과목학생
		
		for(int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			buffer.append(student.getStudentName());
			buffer.append(" | ");
			buffer.append(student.getStudentId());
			buffer.append(" | ");
			buffer.append(student.getMajorSubject().getSubjectName() + "\t");
			buffer.append(" | ");
			
			getScoreGrade(student, subject); // 학생별 해당과목 학점 계산
			buffer.append("\n");
			buffer.append(LINE);
			
		}
	}
	
	public void getScoreGrade(Student student, Subject subject) {
		
		ArrayList<Score> scoreList = student.getScoreList();
		int majorId = student.getMajorSubject().getSubjectId();
		
		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvaluation(), new PassFailEvaluation()}; // 같은 인터페이스를 구현하였기 때문에 배열로 가능
		
		for( int i = 0 ; i< scoreList.size(); i++) {
			Score score = scoreList.get(i);
			
			if (score.getSubject().getSubjectId() == subject.getSubjectId()) { // 현재 학점을 산출할 과목
				String grade;
				
				if( score.getSubject().getGradeType() == Define.PF_TYPE) {
					grade = gradeEvaluation[Define.PF_TYPE].getGrade(score.getPoint());
				
				}else if(score.getSubject().getSubjectId() == majorId) { // 전공인경우
					grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint()); // 전공 과목 학점 평가로 선택
					
				}else {
					grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint()); // 일반 과목 학점평가 
				}
				
				buffer.append(score.getPoint());
				buffer.append(":");
				buffer.append(grade);
				buffer.append(" | ");
					
			}
		}
	}
	
	public void makeFooter() {
		buffer.append("\n");
	}
	
	
}
