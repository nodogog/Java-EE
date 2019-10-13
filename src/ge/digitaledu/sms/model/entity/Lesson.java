package ge.digitaledu.sms.model.entity;


public class Lesson {

    protected int id;
    private String lessonName;
    private double price;
    private String lectureName;
    private int lessonCredit;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }
    public String getLessonName() {
        return lessonName;
    }

    public void setLessonCredit(int lessonCredit) {
        this.lessonCredit = lessonCredit;
    }
    public int getLessonCredit() {
        return lessonCredit;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
