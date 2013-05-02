## ABOUT
 
VRaptor plugin for JSON serialization and deserialization using jackson library (http://jackson.codehaus.org)

## CONFIGURATION


1. Add this dependency in your project:

    **groupId**: com.github.francofabio<br/>
    **artifactId**: vraptor-jackson-serializer<br/>
    **version**: 1.0.7 or (last release)
    
    
3. Add this parameter in your web.xml:

        <context-param>
            <param-name>br.com.caelum.vraptor.packages</param-name>
            <param-value>com.github.francofabio.vraptor.jackson.serialization,com.github.francofabio.vraptor.jackson.deserialization</param-value>
        </context-param>
