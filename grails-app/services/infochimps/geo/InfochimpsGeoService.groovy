package infochimps.geo

import org.springframework.beans.factory.InitializingBean
import com.aquarius.provider.external.infochimpsgeo.api.impl.InfochimpsGeoTemplate
import com.aquarius.provider.external.infochimpsgeo.api.InfochimpsGeo
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class InfochimpsGeoService implements InitializingBean {

    @Delegate
    InfochimpsGeo client

    void afterPropertiesSet() {
        def conf = CH.config.infochimps
        String apiKey = conf.key

        assert apiKey != null
        assert apiKey.length() > 0

        client = new InfochimpsGeoTemplate(
                apiKey: apiKey
        )
    }
}
