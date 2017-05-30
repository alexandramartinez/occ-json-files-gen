package mx.uerre;

public enum Location {

    AGUASCALIENTES("Aguascalientes", "aguascalientes"),
    BAJA_CALIFORNIA("Baja California", "baja-california"),
    BAJA_CALIFORNIA_SUR("Baja California Sur", "baja-california-sur"),
    CAMPECHE("Campeche", "campeche"),
    CHIAPAS("Chiapas", "chiapas"),
    CHIHUAHUA("Chihuahua", "chihuahua"),
    COAHUILA("Coahuila", "coahuila"),
    COLIMA("Colima", "colima"),
    CDMX("Ciudad de Mexico", "ciudad-de-mexico"),
    DURANGO("Durango", "durango"),
    EDO_MEXICO("Estado de Mexico", "edo-mexico"),
    GUANAJUATO("Guanajuato", "guanajuato"),
    GUERRERO("Guerrero", "guerrero"),
    HIDALGO("Hidalgo", "hidalgo"),
    JALISCO("Jalisco", "jalisco"),
    MICHOACAN("Michoacan", "michoacan"),
    MORELOS("Morelos", "morelos"),
    NAYARIT("Nayarit", "nayarit"),
    NUEVO_LEON("Nuevo Leon", "nuevo-leon"),
    OAXACA("Oaxaca", "oaxaca"),
    PUEBLA("Puebla", "puebla"),
    QUERETARO("Queretaro", "queretaro"),
    QUINTANA_ROO("Quintana Roo", "quintana-roo"),
    SAN_LUIS_POTOSI("San Luis Potosi", "san-luis-potosi"),
    SINALOA("Sinaloa", "sinaloa"),
    SONORA("Sonora", "sonora"),
    TABASCO("Tabasco", "tabasco"),
    TAMAULIPAS("Tamaulipas", "tamaulipas"),
    TLAXCALA("Tlaxcala", "tlaxcala"),
    VERACRUZ("Veracruz", "veracruz"),
    YUCATAN("Yucatan", "yucatan"),
    ZACATECAS("Zacatecas", "zacatecas"),
    RESTO_DEL_MUNDO("Resto del mundo", "resto-del-mundo");

    private final String name;
    private final String url;

    Location(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
