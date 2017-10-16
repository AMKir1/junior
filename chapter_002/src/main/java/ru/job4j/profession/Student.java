package ru.job4j.profession;
/**
 * Class Teacher.
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Student extends Profession {
	/**
	* Params.
	*/
	private int course;
	/**
	* Params.
	*/
	private String educationalprogram;
	/**
	* Params.
	*/
	private int studentcardnumber;
	/**
	* Constructor.
	* @param course - first args.
	* @param educationalprogram - second args.
	* @param studentcardnumber - third args.
	*/
	public Student(int course, String educationalprogram, int studentcardnumber) {
		this.course = course;
		this.educationalprogram = educationalprogram;
		this.studentcardnumber = studentcardnumber;
	}
	/**
	* Get Course.
	* @return this.course.
	*/
	public int getCourse() {
		return this.course;
	}
	/**
	* Get Educational Program.
	* @return this.educationalprogram.
	*/
	public String getEducationalProgram() {
		return this.educationalprogram;
	}
	/**
	* Get Student Card Number.
	* @return this.studentcardnumber.
	*/
	public int getStudentCardNumber() {
		return this.studentcardnumber;
	}
		/**
	* Duplicate.
	* @param task - first args.
	* @return answer.
	*/
	public int toWriteWork(String task) {
		int answer = 42;
		return answer;
	}
}