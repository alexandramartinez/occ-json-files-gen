# occ-json-files-gen
This is a JSON-files generator in order to import them as a sitemap on the Web Scraper chrome's extention. This, with the objective of scraping the occ.com.mx site in small pieces to avoid null registers or errors.

**************************************************************************

The project can run directly on an IDE (Eclipse, IntelliJ, etc), or can be compiled directly on console.

***************************** IMPORTANT NOTE *****************************

Don't forget to update the FOLDER_PATH (located in Main.java) with the actual folder in your computer where you'd like to store the generated files.

**************************************************************************

Please review that the information provided in the proyect is still the same that is currently on the OCC website.

Example of the base HTTP Request used: https://www.occ.com.mx/empleos-en-administrativos/en-san-luis-potosi?tm=7
    where "administrativos" would be the Category and "san-luis-potosi" would be the Location.
    The parameter "tm" at the end, using the number "7" would be the "from the last x days".

These are the URLs provided for each category:
    \nadministrativos
    biologia
    comunicaciones
    construccion
    contabilidad
    creatividad-produccion-y-diseno-comercial
    derecho-y-leyes
    educacion
    ingenieria
    logistica-transportacion-y-distribucion
    manufactura-produccion-y-operacion
    mercadotecnia-publicidad-y-relaciones-publicas
    recursos-humanos
    salud-y-belleza
    sector-salud
    seguro-y-reaseguro
    tecnologias-de-la-informacion-sistemas
    turismo-hospitalidad-y-gastronomia
    ventas

These are the URLs provided for each location:
    aguascalientes
    baja-california
    baja-california-sur
    campeche
    chiapas
    chihuahua
    coahuila
    colima
    ciudad-de-mexico
    durango
    edo-mexico
    guanajuato
    guerrero
    hidalgo
    jalisco
    michoacan
    morelos
    nayarit
    nuevo-leon
    oaxaca
    puebla
    queretaro
    quintana-roo
    san-luis-potosi
    sinaloa
    sonora
    tabasco
    tamaulipas
    tlaxcala
    veracruz
    yucatan
    zacatecas
    resto-del-mundo