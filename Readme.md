# Proyecto de desarrollo del Software: Práctica 4
##Autores:
- Amelia
- Antonio
- Eric
- Guillem Arrom Oliver (Commitea como: Soteck o garromoliver)
- Tono

##Datos
- Autenticación:
  - La autenticación esta manejada por el contenedor wilfdly, transparente al programador. 
  - Igualmente, se han programado las páginas de login para mimicar los requisitos del proyecto
  - Los usuarios disponibles son:
    - superadmin/superadmin (Rol `SUPERADMIN` + `ADMIN`)
    - admin/admin (Rol `ADMIN`)
    - user/user (Rol `<ninguno>`)

##Configuración servidor wildfly 16.0.0.Final ("{wildfly.home}\standalone\configuration\standalone.xml")
###BDD config (alojada en un servidor publico)
- Dentro del XML, buscar el tag `<subsystem xmlns="urn:jboss:domain:datasources:5.0">`
- Dentro del objeto `<datasources>`, añadir el siguiente hijo:
```
                <datasource jta="false" jndi-name="java:jboss/postgresDS" pool-name="postgresDS" enabled="true" use-java-context="true" use-ccm="false">
                    <connection-url>jdbc:postgresql://vps.soteck.es:5432/uoc</connection-url>
                    <driver-class>org.postgresql.Driver</driver-class>
                    <driver>postgresql</driver>
                    <security>
                        <user-name>uocadmin</user-name>
                        <password>uocadmin</password>
                    </security>
                </datasource>
  ```
- Dentro del objeto `<drivers>`, añadir el siguiente hijo:
```
                    <driver name="postgresql" module="org.postgresql">
                        <xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
                    </driver>
```
###Configuración de elytron security 
- Dentro del XML, buscar el tag `<subsystem xmlns="urn:wildfly:elytron:6.0" final-providers="combined-providers" disallowed-providers="OracleUcrypto">`
- Buscar el tag `<security-domains>` y agregar el siguiente:
```
                <security-domain name="uoc-security-domain" default-realm="uoc-security-realm" permission-mapper="default-permission-mapper">
                    <realm name="uoc-security-realm" role-decoder="from-roles-attribute"/>
                </security-domain>
```
- Buscar el tag `<security-realms>` y agregar el siguiente hijo:
```
                <jdbc-realm name="uoc-security-realm">
                    <principal-query sql="SELECT password FROM pra2.profile WHERE email = ?" data-source="postgresDS">
                        <clear-password-mapper password-index="1"/>
                    </principal-query>
                    <principal-query sql="select ROLE from ( (select 'ADMIN' as ROLE, email from pra2.profile where admin = true)  union all  (select 'SUPERADMIN' as ROLE, email from pra2.profile where superadmin = true)  ) as ROLE where email = ?" data-source="postgresDS">
                        <attribute-mapping>
                            <attribute to="roles" index="1"/>
                        </attribute-mapping>
                    </principal-query>
                </jdbc-realm>
```
- Buscar el tag `<mappers>` y agregar el siguiente hijo:
```
                <simple-role-decoder name="from-roles-attribute" attribute="roles"/>
```
- Buscar el tag `<http>` y agregar el siguiente hijo:
```
                <http-authentication-factory name="uoc-security-http-auth" security-domain="uoc-security-domain" http-server-mechanism-factory="global">
                    <mechanism-configuration>
                        <mechanism mechanism-name="BASIC">
                            <mechanism-realm realm-name="RealmUsersRoles"/>
                        </mechanism>
                    </mechanism-configuration>
                </http-authentication-factory>
```
- Dentro del XML, buscar el tag  `<subsystem xmlns="urn:jboss:domain:undertow:8.0" default-server="default-server" default-virtual-host="default-host" default-servlet-container="default" default-security-domain="other" statistics-enabled="${wildfly.undertow.statistics-enabled:${wildfly.statistics-enabled:false}}">`
- Agregar dentro del subsystem encontrado, el siguiente hijo:
```
            <application-security-domains>
                <application-security-domain name="uoc-security-domain-application" http-authentication-factory="uoc-security-http-auth"/>
            </application-security-domains>
```
###En la carpeta "ext" hay una versión configurada del propio standalone.xml. Hacer backup del original antes de sustituir. Sustituir puede romper el funcionamiento de otras aplicaciones y del propio servidor

##Bibliografia
- Security config: https://github.com/wildfly/quickstart/tree/main/servlet-security