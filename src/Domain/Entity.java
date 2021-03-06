package Domain;

import java.util.Objects;

public abstract class Entity {
    private int id;

    public Entity(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;
        Entity entity = (Entity) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}
