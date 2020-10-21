package com.mycompany.app;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */

public class App 
{   
    private static Gson gson = new Gson();
    private static Map<String, Usuarios> usuarios = new HashMap<>();

    public static void main( String[] args )
    {
        options("/*", (req, res) -> {

            String accessControlRequestHeaders = req.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                res.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = req.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                res.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });
        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));


        before((req, res) -> res.type("application/json"));
        get("/usuarios", (req, res) -> gson.toJson(usuarios.values()));

        post("/usuarios", (req, res)-> {
            String query = req.body();
            System.out.println( "peticion: " + query );
            Usuarios u = gson.fromJson(query, Usuarios.class);
            String id = UUID.randomUUID().toString();
            u.setId(id);
            usuarios.put(id, u);
            return "Se creo el usuario con id:" + id;
        });

        
    }
}
