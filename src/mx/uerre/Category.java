package mx.uerre;

public enum Category {

    ADMINISTRATIVOS("Administrativos", "administrativos"),
    BIOLOGIA("Biologia", "biologia"),
    COMUNICACIONES("Comunicaciones", "comunicaciones"),
    CONSTRUCCION("Construccion", "construccion"),
    CONTABILIDAD("Contabilidad", "contabilidad"),
    CREATIVIDAD("Creatividad, produccion y diseno comercial", "creatividad-produccion-y-diseno-comercial"),
    DERECHOA("Derecho y leyes", "derecho-y-leyes"),
    EDUCACION("Educacion", "educacion"),
    INGENIERIA("Ingenieria", "ingenieria"),
    LOGISTICA("Logistica, transportacion y distribucion", "logistica-transportacion-y-distribucion"),
    MANUFACTURA("Manufactura, produccion y operacion", "manufactura-produccion-y-operacion"),
    MERCADOTECNIA("Mercadotecnia, publicidad y relaciones publicas", "mercadotecnia-publicidad-y-relaciones-publicas"),
    RECURSOS_HUMANOS("Recursos Humanos", "recursos-humanos"),
    SALUD_Y_BELLEZA("Salud y belleza", "salud-y-belleza"),
    SECTOR_SALUD("Sector Salud", "sector-salud"),
    SEGURO("Seguro y reaseguro", "seguro-y-reaseguro"),
    TI("Tecnologias de la informacion y Sistemas", "tecnologias-de-la-informacion-sistemas"),
    TURISMO("Turismo, hospitalidad y gastronomia", "turismo-hospitalidad-y-gastronomia"),
    VENTAS("Ventas", "ventas");

    private final String name;
    private final String url;

    Category(String name, String url) {
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
