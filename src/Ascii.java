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

    // Setters (optional if you want to modify these attributes)
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
