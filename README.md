# occ-json-files-gen

## Description

This is a JSON-files generator in order to import them as a sitemap on the Web Scraper chrome's extention. This, with the objective of scraping the occ.com.mx site in small pieces to avoid null registers or errors.

## Installation

1. Simply Download the project's .zip, or clone it using: `git clone https://github.com/alexandramartinez/occ-json-files-gen.git`
2. Update the `FOLDER_PATH` (located in Main.java) with the actual folder in your computer where you'd like to store the generated files.
3. The project can run directly on an IDE (Eclipse, IntelliJ, etc), or can be compiled directly on console.
4. (Optional) you can always Fork the project and implement some other cool stuff based on my code :) Let me know what you do!

## Important Notes

Please review that the information provided in the proyect is still the same that is currently on the OCC website.

Example of the base HTTP Request used: https://www.occ.com.mx/empleos-en-administrativos/en-san-luis-potosi?tm=7
    where "administrativos" would be the Category and "san-luis-potosi" would be the Location.
    The parameter "tm" at the end, using the number "7" would be the "from the last x days".

URLs provided for each category:

    * administrativos
    * biologia
    * comunicaciones
    * construccion
    * contabilidad
    * creatividad-produccion-y-diseno-comercial
    * derecho-y-leyes
    * educacion
    * ingenieria
    * logistica-transportacion-y-distribucion
    * manufactura-produccion-y-operacion
    * mercadotecnia-publicidad-y-relaciones-publicas
    * recursos-humanos
    * salud-y-belleza
    * sector-salud
    * seguro-y-reaseguro
    * tecnologias-de-la-informacion-sistemas
    * turismo-hospitalidad-y-gastronomia
    * ventas

URLs provided for each location:

    * aguascalientes
    * baja-california
    * baja-california-sur
    * campeche
    * chiapas
    * chihuahua
    * coahuila
    * colima
    * ciudad-de-mexico
    * durango
    * edo-mexico
    * guanajuato
    * guerrero
    * hidalgo
    * jalisco
    * michoacan
    * morelos
    * nayarit
    * nuevo-leon
    * oaxaca
    * puebla
    * queretaro
    * quintana-roo
    * san-luis-potosi
    * sinaloa
    * sonora
    * tabasco
    * tamaulipas
    * tlaxcala
    * veracruz
    * yucatan
    * zacatecas
    * resto-del-mundo

## Using with Web Scraper (for chrome)

1. Install it from this site: https://chrome.google.com/webstore/detail/web-scraper/jnhgnonknehpejjnehehllkliplmbmhn?hl=en
2. Open the developer tools. You can open a new tab, right-click on the page and select "Inspect"; or press `Ctrl + Shift + I`
3. Inside the developer tools, select the Web Scraper tab.
4. Click on `Create new sitemap`
5. Click on `Import sitemap`
6. There you can paste one of the JSON files you just generated and click on `Import Sitemap`
7. Once created, it will open. Click on `Sitemap (the-name-of-the-sitemap)`
8. Select `Scrape` and leave the default values as they are. Select `Start scraping`
9. A new window will open and it will start scraping the URL provided for each file (using the Category, Location, and days provided). If you close it, the scraping will stop.
10. Once it finishes, you can review the info by clicking on `Sitemap (the-name-of-the-sitemap)` and select `Browse`
11. In order to download the results as CSV, click again on `Sitemap (the-name-of-the-sitemap)` and select `Export data as CSV`