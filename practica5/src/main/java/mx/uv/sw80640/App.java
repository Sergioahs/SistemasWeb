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
        get("/", (reg, res) -> "Hola desde spark" );
        get("/hola", (reg, res) -> "Hola desde spark" );
        get("/adios", (reg, res) -> "adios desde spark" );
    }
}
