package ua.lviv.iot.dwellingrest.model;

public class Mansion extends AbstractDwelling {

    private double areaOfLandInSquareMeters;
    private int entranceDoorCount;
    private boolean otherBuildingsInArea;
    private Integer id;
   
    public Mansion() {

    }

    public Mansion(double areaInSquareMeters, double priceInUSD, Location location, String district, int balconyCount) {
        super(areaInSquareMeters, priceInUSD, location, district, balconyCount);
    }

    public String toCSV() {
        return super.toCSV() + ";;;" + getAreaOfLandInSquareMeters() + ";" + getEntranceDoorCount() + ";"
                + isOtherBuildingsInArea();
    }

    public double getAreaOfLandInSquareMeters() {
        return areaOfLandInSquareMeters;
    }

    public void setAreaOfLandInSquareMeters(double areaOfLandInSquareMeters) {
        this.areaOfLandInSquareMeters = areaOfLandInSquareMeters;
    }

    public int getEntranceDoorCount() {
        return entranceDoorCount;
    }

    public void setEntranceDoorCount(int entranceDoorCount) {
        this.entranceDoorCount = entranceDoorCount;
    }

    public boolean isOtherBuildingsInArea() {
        return otherBuildingsInArea;
    }

    public void setOtherBuildingsInArea(boolean otherBuildingsInArea) {
        this.otherBuildingsInArea = otherBuildingsInArea;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
