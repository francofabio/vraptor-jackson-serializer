## ABOUT
 
This project is a plugin for VRaptor JSON Serialization using jackson library (http://jackson.codehaus.org/)

## INSTALATION

    download and install gradle (gradle.org)
    git clone git@github.com:francofabio/vraptor-jackson-serializer.git
    cd vraptor-jackson-serializer
    gradle clean jar

## CONFIGURATION

1. Add the dependency to your project
2. Add this to your web.xml:

        <context-param>
            <param-name>br.com.caelum.vraptor.packages</param-name>
            <param-value>br.com.caelum.vraptor.serialization.jackson</param-value>
        </context-param>