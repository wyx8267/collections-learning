package sort;

public class Student implements Comparable<Student>  {
    private int id;
    private String name;
    private int score;


    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name + "'\'" +
                ", score=" + score +
                "}";
    }

    @Override
    public int compareTo(Student o) {
        // 按分数排序
        return o.score - this.score;
    }

    public int getScore() {
        return score;
    }
}
