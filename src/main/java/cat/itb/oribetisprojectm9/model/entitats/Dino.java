package cat.itb.oribetisprojectm9.model.entitats;

import java.util.Objects;

public class Dino {
    private int id;
    private String name;
    private String speed;
    private String weight;

    public String getFeeding() {
        return feeding;
    }

    public void setFeeding(String feeding) {
        this.feeding = feeding;
    }

    private String feeding;


    public Dino(int id, String name, String speed, String weight, String feeding) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.weight = weight;
        this.feeding = feeding;

    }

    public Dino() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dino dino = (Dino) o;
        return id == dino.id &&
                Objects.equals(name, dino.name) &&
                Objects.equals(speed, dino.speed) &&
                Objects.equals(weight, dino.weight)&&
                Objects.equals(feeding, dino.feeding);
    }

    @Override
    public String toString() {
        return "Dino{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speed='" + speed + '\'' +
                ", weight='" + weight + '\'' +
                ", feeding='" + feeding + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, speed, weight, feeding);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
