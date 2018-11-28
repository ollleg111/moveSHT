package movesht.com.movesht.model.cargo;

import java.util.List;

/**
 * Created by user on 11.04.2017.
 */

public class PodTypeCargoContainer {
    List<PodTypeCargo> podTypeCargos;

    public void setCargoTypes(List<PodTypeCargo> podTypeCargos) {
        this.podTypeCargos = podTypeCargos;
    }

    public List<PodTypeCargo> getPodTypeCargos() {
        return podTypeCargos;
    }

}
