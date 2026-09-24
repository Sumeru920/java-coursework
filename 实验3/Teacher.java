public class Teacher {
    private String name;
    private String title;
    public Teacher(String n,String t){
        this.name = n;
        this.title = t;
    }
    //getter
    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }
    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
