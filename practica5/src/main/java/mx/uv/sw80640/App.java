package mx.uv.sw80640;

import static spark.Spark.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        port(80);
        
        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));


        get("/", (reg, res) -> "holis desde spark" );
        get("/hola", (request, response) -> {
            System.out.println("request: "+ request.queryParams());
            System.out.println("request: "+ request.queryParams("Premail"));
            System.out.println("request: "+ request.queryParams("Prpassword"));
            System.out.println("request: "+ request.contentType());
            return "hola "+ request.queryParams("Premail")+"desde spark";
        } );

        post("/adios", (request, response) -> {
            System.out.println("request: "+ request.queryParams());
            System.out.println("request: "+ request.queryParams("Premail"));
            System.out.println("request: "+ request.queryParams("Prpassword"));
            return "adios "+ request.queryParams("Premail")+"desde spark";
        });
    }
}
