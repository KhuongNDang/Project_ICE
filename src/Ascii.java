public class Ascii {

    private int id;
    private String name;
    private String picture;



    public Ascii(String picture) {
        this.picture = picture;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }


    @Override
    public String toString() {
        return "Ascii{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picture=\n" + picture +
                '}';
    }
}
