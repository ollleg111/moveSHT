package movesht.com.movesht.model.cargo;

/**
 * Created by PC on 07-Apr-17.
 */

public class PodTypeCargo {
    private String id;
    private String podType;

    public  PodTypeCargo(){

    }

    public PodTypeCargo(String id, String podType) {
        this.id = id;
        this.podType = podType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPodType(String podType) {
        this.podType = podType;
    }

    public String getId() {
        return id;
    }

    public String getPodType() {
        return podType;
    }
}
