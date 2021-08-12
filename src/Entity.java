import java.util.UUID;

public class Entity {

    protected UUID id;

    public void validate() {

    }

    public static Entity createId() {

        Entity entity = new Entity();
        entity.id = UUID.randomUUID();
        return entity;
    }

    public UUID getId() {
        return this.id;
    }

    public String getDatos() {

        String datos = this.getClass().getName();
        return datos;
    }

    public boolean equals(Object obj) {

        if (!(obj instanceof Entity)) {
            return false;
        }

        Entity entity = (Entity) obj;

        return this.getId().equals(entity.getId());
    }

    public int hashCode() {

        return this.getId().hashCode();
    }
}