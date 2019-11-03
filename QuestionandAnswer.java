
package hacs;

import java.util.*;
import java.text.DateFormat;

public class Assignment {

	protected String assignmentname;
	protected String strassignmentfilename;
	protected Date duedate = new Date();
	protected String assspec;
	protected SolutionList thesolutionlist = new SolutionList();
	protected Solution suggestsolution = new Solution();


	public Assignment() {
	}


	public void setDueDate(Date theDueDate) {
		this.duedate = theDueDate;
	}

	public void setAssSpec(String theSpec) {
		this.assspec = theSpec;
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

	public SolutionList getSolutionList() {
		return thesolutionlist;
	}

	public Solution getSolution(String studentname) {
		Iterator<Solution> Iterator = thesolutionlist.iterator();
		return (Solution) Iterator.next();
	}

	public Solution getSugSolution() {
		return suggestsolution;
	}

	public SolutionIterator getSolutionIterator() {
		SolutionIterator theSolutionIterator = new SolutionIterator(thesolutionlist);
		return theSolutionIterator;
	}

	public String toString() {
		return assignmentname;
	}

	public String getDueDateString() {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		return dateFormat.format(duedate);
	}


	public void accept(NodeVisitor visitor) {
		visitor.visitAssignment(this);
	}

	public Object getAssSpec() {
		// TODO Auto-generated method stub
		return assspec;
	}

	public void setAssignmentName(String string) {
		assignmentname = string;

	}
}
