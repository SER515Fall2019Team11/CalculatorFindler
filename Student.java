package hacs;



public class Student  {

	public Student() {
		type = 0; 
	}

	public CourseMenu createCourseMenu(Course theCourse, int theLevel) {

		return theCourseMenu;
	}
	
	public boolean isOverDue() {
		return true;
	}

	public Solution addSolution() {
		Solution mySolution = new Solution();
		return mySolution;
	}

	public void addSolution(Solution theSolution) {
		thesolutionlist.add(theSolution);
	}


	public void submitSolution() {
	}


	public boolean showMenu() {
		super.showMenu();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
	}
}
