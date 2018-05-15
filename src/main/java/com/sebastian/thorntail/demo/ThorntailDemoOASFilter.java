package com.sebastian.thorntail.demo;

import io.thorntail.openapi.impl.api.models.responses.APIResponsesImpl;
import java.util.Arrays;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.OASFilter;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.Operation;
import org.eclipse.microprofile.openapi.models.PathItem;
import org.eclipse.microprofile.openapi.models.info.Contact;
import org.eclipse.microprofile.openapi.models.info.License;
import org.eclipse.microprofile.openapi.models.info.Info;
import org.eclipse.microprofile.openapi.models.parameters.Parameter;
import org.eclipse.microprofile.openapi.models.responses.APIResponse;
import org.eclipse.microprofile.openapi.models.servers.Server;
import org.eclipse.microprofile.openapi.models.servers.ServerVariable;
import org.eclipse.microprofile.openapi.models.servers.ServerVariables;

public class ThorntailDemoOASFilter implements OASFilter {

    @Override
    public APIResponse filterAPIResponse(APIResponse apiResponse) {
        if ("Missing description".equals(apiResponse.getDescription())) {
            apiResponse.setDescription("Request invalido.");
        }
        return apiResponse;
    }

    @Override
    public void filterOpenAPI(OpenAPI openAPI) {
        openAPI.setInfo(OASFactory.createObject(Info.class)
                .title("Thorntail Demo")
                .version("1.0")
                .description("Demo utilizando thorntail.")
                .contact(OASFactory.createObject(Contact.class)
                        .name("Sebastian Avila A.")
                        .email("sebastian4j@gmail.com"))
                .license(OASFactory.createObject(License.class)
                        .name("Eclipse Public License - v 1.0")
                        .url("https://www.eclipse.org/legal/epl-v10.html")));

        openAPI.setServers(Arrays.asList(OASFactory.createObject(Server.class)
                .url("http://localhost:8080")
                .description("Servidor Demo")
                .variables(OASFactory.createObject(ServerVariables.class)
                        .addServerVariable("port", OASFactory.createObject(ServerVariable.class)
                                .description("Server HTTP port.")
                                .defaultValue("8080")))));
        openAPI.path("/bienvenido/{cliente}",
                OASFactory.createObject(PathItem.class)
                        .GET(OASFactory.createObject(Operation.class).summary("genera un saludo")
                                .responses(new APIResponsesImpl()
                                        .addApiResponse("saludo",
                                                OASFactory.createObject(APIResponse.class).ref("Mensaje"))
                                ))
                        .addParameter(OASFactory.createObject(Parameter.class)
                                .allowEmptyValue(false).required(true).name("cliente")
                                .example("elias"))
        );
    }
}
