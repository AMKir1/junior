package ru.job4j.profession;
/**
 * Class Teacher.
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Teacher extends Profession {
	/**
	* Params.
	*/
	private String academicSubject;
	/**
	* Constructor.
	* @param academicSubject - second args.
	*/
	public Teacher(String academicSubject) {
		this.academicSubject = academicSubject;
	}
	/**
	* Get Academic Subject.
	* @return this.academicSubject.
	*/
	public String getAcademicSubject() {
		return this.academicSubject;
	}
		/**
	* Duplicate.
	* @param student - first args.
	* @return task.
	*/
	public String toGiveTest(Student student) {
		String task = "1 + 1 = ";
		return task;
	}
		/**
	* Duplicate.
	* @param work - first args.
	* @return estimate.
	*/
	public int toChekTheWork(String work) {
		int estimate = 2;
		if (work == "2") {
			estimate = 5;
		}
		return estimate;
	}
}