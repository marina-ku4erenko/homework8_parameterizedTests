package mari.ku.tests;

public enum DeliveryRegion {

    KRASNOYARSK("Красноярск"),
    NOVOSIBIRSK("Новосибирск"),
    VORONEZH("Воронеж");

    private String title;

    DeliveryRegion(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
