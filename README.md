## ABOUT
 
VRaptor plugin for JSON serialization and deserialization using jackson library (http://jackson.codehaus.org)

## CONFIGURATION

1. Add the dependency to your project:

    - **groupId**: com.github.francofabio
    - **artifactId**: vraptor-jackson-serializer
    - **version**: _last release_
    
    
2. Add this to your web.xml:

        <context-param>
            <param-name>br.com.caelum.vraptor.packages</param-name>
            <param-value>com.github.francofabio.vraptor.jackson.serialization,com.github.francofabio.vraptor.jackson.deserialization</param-value>
        </context-param>
