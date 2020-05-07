import java.util.Comparator;

class StudentComparator implements Comparator<Student> {

    private ParametersOfSort type;

    StudentComparator(ParametersOfSort type) {

        this.type = type;
    }


    public int compare(Student one, Student two) {

        switch (type) {

            case BYNAME:
                return one.getName().compareTo(two.getName());
            case BYITEM:
                return one.getItem().compareTo(two.getItem());
            case BYDATE:
                return compareDate(one.getDate(), two.getDate());
            case BYDEGREE:
                return one.getDegree().compareTo(two.getDegree());
        }

        return 0;
    }

    private int compareDate(String date1, String date2) {

        String[] arr1 = date1.split("/");
        String[] arr2 = date2.split("/");
        int checkYear = 2;

        for (int i = 0; i < arr1.length; i++) {

            int tempDate1 = Integer.parseInt(arr1[checkYear]);
            int tempDate2 = Integer.parseInt(arr2[checkYear]);

            if (tempDate1 == tempDate2) {

                checkYear = i;
                continue;
            }

            if (tempDate1 > tempDate2) {

                return 1;
            }

            else if (tempDate1 < tempDate2) {

                return -1;
            }
        }

        return 0;
    }
}