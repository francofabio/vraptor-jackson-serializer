## ABOUT
 
VRaptor plugin for JSON serialization using jackson library (http://jackson.codehaus.org)

## CONFIGURATION

1. Add the dependency to your project

    groupId: com.github.francofabio
    artifactId: vraptor-jackson-serializer
    version: 1.0.1
    
2. Add this to your web.xml:

        <context-param>
            <param-name>br.com.caelum.vraptor.packages</param-name>
            <param-value>com.github.francofabio.vraptor.serialization.jackson</param-value>
        </context-param>