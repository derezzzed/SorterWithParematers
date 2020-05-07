class Student {

    private String name;
    private String item;
    private String date;
    private String degree;

    Student(String name, String item, String date, String degree) {

        this.name = name;
        this.item = item;
        this.date = date;
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public String getItem() {
        return item;
    }

    public String getDate() {
        return date;
    }

    public String getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return name + " " + item + " " + date + " " + degree;
    }
}