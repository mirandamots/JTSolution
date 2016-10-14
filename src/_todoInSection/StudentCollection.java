package _todoInSection;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import model.Student;

/**
 * StudentCollection is a collection class that keeps track of all our students.
 * 
 * @author Jorge Vergara, Rick Mercer, and Jeremy Mowery (jermowery@email.arizona.edu)
 *    
 */
// TODO 1: Adapt this class to a TableModel with the methods JTable needs.
// You can Google the methods or let Eclipse write the method stubs for you
// (after adding implements ListModel to the class heading).
//
// Note: Some ListModel need not be implemented.
public class StudentCollection implements TableModel {

  private List<Student> theStudents;
  private final int COLUMN_COUNT = 4;

  /**
   * The constructor for a StudentCollection. Initializes the list of
   * students.
   */
  public StudentCollection() {
    theStudents = new ArrayList<Student>();
    setUpDefaultList();
  }

  /**
   * Initializes the list with a few hard-coded students
   */
  private void setUpDefaultList() {
    theStudents.add(new Student("Kim", "Computer Science", 4.0, 23));
    theStudents.add(new Student("Chris", "Computer Science", 4.0, 23));
    theStudents.add(new Student("Devon", "Math", 2.7, 21));
    theStudents.add(new Student("Ashley", "Biology", 3.29, 27));
    theStudents.add(new Student("Taylor", "Economics", 3.9, 25));
    theStudents.add(new Student("Chris", "Economics", 3.8, 19));
    theStudents.add(new Student("Dakota", "Psychology", 1.99, 22));
  }
 
  public int size() {
    return theStudents.size();
  }

  public void add(Student newStudent) {
    theStudents.add(newStudent);
  }

  public Student get(int index) {
    return theStudents.get(index);
  }

  public Student getFirstStudentWithName(String name) {
    for (int index = 0; index < size(); index++) {
      if (name.equals(theStudents.get(index).getName()))
        return theStudents.get(index);
    }
    return null; // not found
  }

@Override
public int getRowCount() {	// number of rows	
	return this.size();
}

@Override
public int getColumnCount() {	// number of columns
	return COLUMN_COUNT;
}

@Override
// The name of each column, used to create the headers
public String getColumnName(int columnIndex) {
	if(columnIndex == 0)
		return "Name";
	else if(columnIndex == 1) 
		return "Major";
	else if(columnIndex == 2)
		return "GPA";
	else
		return "Age";
}

@Override
public Class<?> getColumnClass(int columnIndex) {	
	if(columnIndex == 0 || columnIndex == 1)
		return String.class;	// name/major
	else if(columnIndex == 2) 
		return double.class;	// GPA
	else
		return int.class;		// age
}

@Override
public boolean isCellEditable(int rowIndex, int columnIndex) {
	return false;	// we don't want the user to be able to edit this
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
	Student student = theStudents.get(rowIndex);
	
	if(columnIndex == 0)
		return student.getName();
	else if(columnIndex == 1) 
		return student.getMajor();
	else if(columnIndex == 2)
		return student.getGPA();
	else
		return student.getAge();
}

@Override
public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	// unnecessary
	
}

@Override
public void addTableModelListener(TableModelListener l) {
	// unnecessary
	
}

@Override
public void removeTableModelListener(TableModelListener l) {
	// unnecessary
	
}

}
