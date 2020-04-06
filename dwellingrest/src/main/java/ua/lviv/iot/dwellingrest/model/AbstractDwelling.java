package ua.lviv.iot.dwellingrest.model;


import java.util.List;

public abstract class AbstractDwelling {

    private double areaInSquareMeters;
    private double priceInUSD;
    private Location location;
    private String district;
    private int allRoomsCount;
    private int balconyCount;
    private int kitchenCount;
    private int restroomCount;
    private int floorCount;
    private int windowsCount;
    private boolean poolAvability;
    private boolean garageAvability;

    public AbstractDwelling() {
        
    }
    
    public AbstractDwelling(double areaInSquareMeters, double priceInUSD, Location location, String district,
            int balconyCount) {
        this.areaInSquareMeters = areaInSquareMeters;
        this.priceInUSD = priceInUSD;
        this.location = location;
        this.district = district;
        this.balconyCount = balconyCount;
    }

    public String getHeaders() {
        return "areaInSquareMeters;priceInUSD;location;SoundInsulationOfWalls;district;allRoomsCount;balconyCount;"
                + "kitchenCount;restroomCount;floorCount;windowsCount;poolAvability;garageAvability;numberOfFloor;"
                + "neighboringApartmentsOnFloorCount;areaOfLandInSquareMeters;entranceDoorCount;otherBuildingsInArea";
    }

    public String toCSV() {
        return getAreaInSquareMeters() + ";" + getPriceInUSD() + ";" + location.getXInDecimalDegrees() + ", "
                + location.getYInDecimalDegrees() + ";" + getDistrict() + ";"
                + getAllRoomsCount() + ";" + getBalconyCount() + ";" + getKitchenCount() + ";" + getRestroomCount()
                + ";" + getFloorCount() + ";" + getWindowsCount() + ";" + isPoolAvability() + ";"
                + isGarageAvability();
    }

    public double calculateDistanceToCloserSchoolInMeters(List<Location> locationsOfSchools) {
        double distance;
        double smallestDistance = Math.sqrt(
                Math.pow(locationsOfSchools.get(0).getXInDecimalDegrees() - location.getXInDecimalDegrees(), 2) + Math
                        .pow(locationsOfSchools.get(0).getYInDecimalDegrees() - location.getYInDecimalDegrees(), 2));

        for (Location locationOfSchool : locationsOfSchools) {
            distance = Math.sqrt(Math.pow(locationOfSchool.getXInDecimalDegrees() - location.getXInDecimalDegrees(), 2)
                    + Math.pow(locationOfSchool.getYInDecimalDegrees() - location.getYInDecimalDegrees(), 2));
            if (distance < smallestDistance) {
                smallestDistance = distance;
            }

        }
        return smallestDistance * 111000;
    }

    public double calculateDistanceToCloserKindergardenInMeters(List<Location> locationsOfKindergardens) {
        double distance;
        double smallestDistance = Math.sqrt(Math
                .pow(locationsOfKindergardens.get(0).getXInDecimalDegrees() - location.getXInDecimalDegrees(), 2)
                + Math.pow(locationsOfKindergardens.get(0).getYInDecimalDegrees() - location.getYInDecimalDegrees(),
                        2));

        for (Location locationOfKindergarden : locationsOfKindergardens) {
            distance = Math.sqrt(
                    Math.pow(locationOfKindergarden.getXInDecimalDegrees() - location.getXInDecimalDegrees(), 2) + Math
                            .pow(locationOfKindergarden.getYInDecimalDegrees() - location.getYInDecimalDegrees(), 2));
            if (distance < smallestDistance) {
                smallestDistance = distance;
            }

        }
        return smallestDistance * 111000;
    }

    public double calculateDistanceToCloserPlaygroundInMeters(List<Location> locationsOfPlaygrounds) {
        double distance;
        double smallestDistance = Math.sqrt(Math
                .pow(locationsOfPlaygrounds.get(0).getXInDecimalDegrees() - location.getXInDecimalDegrees(), 2)
                + Math.pow(locationsOfPlaygrounds.get(0).getYInDecimalDegrees() - location.getYInDecimalDegrees(), 2));

        for (Location locationOfPlayground : locationsOfPlaygrounds) {
            distance = Math.sqrt(Math.pow(locationOfPlayground.getXInDecimalDegrees() - location.getXInDecimalDegrees(),
                    2) + Math.pow(locationOfPlayground.getYInDecimalDegrees() - location.getYInDecimalDegrees(), 2));
            if (distance < smallestDistance) {
                smallestDistance = distance;
            }

        }
        return smallestDistance * 111000;
    }

    public double getPriceInUSD() {
        return priceInUSD;
    }

    public void setPriceInUSD(double priceInUSD) {
        this.priceInUSD = priceInUSD;
    }

    public double getAreaInSquareMeters() {
        return areaInSquareMeters;
    }

    public void setAreaInSquareMeters(double areaInSquareMeters) {
        this.areaInSquareMeters = areaInSquareMeters;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getAllRoomsCount() {
        return allRoomsCount;
    }

    public void setAllRoomsCount(int allRoomsCount) {
        this.allRoomsCount = allRoomsCount;
    }

    public int getBalconyCount() {
        return balconyCount;
    }

    public void setBalconyCount(int balconyCount) {
        this.balconyCount = balconyCount;
    }

    public int getKitchenCount() {
        return kitchenCount;
    }

    public void setKitchenCount(int kitchenCount) {
        this.kitchenCount = kitchenCount;
    }

    public int getRestroomCount() {
        return restroomCount;
    }

    public void setRestroomCount(int restroomCount) {
        this.restroomCount = restroomCount;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public int getWindowsCount() {
        return windowsCount;
    }

    public void setWindowsCount(int windowsCount) {
        this.windowsCount = windowsCount;
    }

    public boolean isPoolAvability() {
        return poolAvability;
    }

    public void setPoolAvability(boolean poolAvability) {
        this.poolAvability = poolAvability;
    }

    public boolean isGarageAvability() {
        return garageAvability;
    }

    public void setGarageAvability(boolean garageAvability) {
        this.garageAvability = garageAvability;
    }

}
