import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentTestTable {

    private List<Student> list;
    private List<Student> newlist;

    StudentTestTable(Stream<String> streamFromFiles) {

            list = streamFromFiles.map(x -> x.split(" "))
                    .filter(x -> x.length == 4)
                    .map(x -> new Student(x[0], x[1], x[2], x[3]))
                    .collect(Collectors.toList());
    }

    List<Student> searchByKey(Consumer<StudentComparator> c, ParametersOfSort parameter, int numberOfString, String... line) {

        if (numberOfString == 0) numberOfString = list.size();

        StudentComparator studentComparator = new StudentComparator(parameter);

        newlist = list.stream()
                .filter((s1) -> checkStudentFields(line, s1))
                .sorted(studentComparator)
                .limit(numberOfString)
                .collect(Collectors.toList());

        c.accept(studentComparator);

        return newlist;
    }

    private boolean checkStudentFields(String[] string, Student student) {

        String[] arrForCheck = {student.getName(), student.getItem(),
                student.getDate(), student.getDegree()};

        for (int i = 0; i < string.length; i++) {

           if (string[i].equals(",")) {
               continue;
           }

           if (!string[i].equals(arrForCheck[i])) {
               return false;
           }
        }

        return true;
    }

      void byDescending(StudentComparator comparator) {

        newlist.sort(comparator);
        Collections.reverse(newlist);
    }

     void byAscending(StudentComparator comparator) {

        newlist.sort(comparator);
    }
}

