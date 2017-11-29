package fr.emse.majeureinfo.springbootintro.dao;

public class BuildingWithRoomsCountersDTO {
    private Long id;
    private Long nb;
    private Long nbWithLightsOn;

    public BuildingWithRoomsCountersDTO(Long id, Long nb, Long nbWithLightsOn) {
        this.id = id;
        this.nb = nb;
        this.nbWithLightsOn = nbWithLightsOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNb() {
        return nb;
    }

    public void setNb(Long nb) {
        this.nb = nb;
    }

    public Long getNbWithLightsOn() {
        return nbWithLightsOn;
    }

    public void setNbWithLightsOn(Long nbWithLightsOn) {
        this.nbWithLightsOn = nbWithLightsOn;
    }
}
