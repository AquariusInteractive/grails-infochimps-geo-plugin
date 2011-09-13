Infochimps API Client for Grails
================================

Grails plugin that provides access to Infochimps Geo API

Requirements
------------

 * grails 2.0
 * <a href="https://github.com/AquariusInteractive/infochimps-geoapi-java-client">infochimps-geoapi-client</a> (will be downloaded automatically)

How to install
--------------

```
grails install-plugin infochimps-geo
```

and put your API key into Config.groovy:

```
infochimps {
    key = 'api_test-W1ci40pcda9Cbd9pvm8D4Cjc46u'
}
```

Usage
-----

It provides service for API calls.

Example:

```Groovy
class DemoController {

    InfochimpsGeoService infochimpsGeoService

    def foursquare() {
        PointLocationQuery query = new PointLocationQuery(30.273054, -104.02, 5000)
        FoursqResult result = infochimpsGeoService.executeQuery(GeoSource.Foursquare,
                query,
                null)

        render(view: 'show', model: [
                source: 'Foursquare',
                result: result,
                query: query
        ])
    }
}
```