import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        try {
            Stream<String> streamFromFiles = Files.lines(Paths.get("StudentsTestsBase.txt"));

            StudentTestTable sorter = new StudentTestTable(streamFromFiles);

            List<Student> list = sorter.searchByKey(sorter::byDescending, ParametersOfSort.BYITEM, 0, "Andrew_Smith", ",", ",", ",");
            list.stream().forEach(System.out::println);

        } catch (NullPointerException ex) {
            System.out.println("Input keys do not be null!");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}

