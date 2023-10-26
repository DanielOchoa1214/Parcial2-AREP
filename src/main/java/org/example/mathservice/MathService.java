package org.example.mathservice;

import netscape.javascript.JSObject;
import spark.Request;

import java.util.List;

import static spark.Spark.*;

public class MathService {
    public static void main(String... args){
        port(getPort());
        get("/lucasseq", (req, res) -> getLucasList(req));
    }

    private static String getLucasList(Request req){
        int value = Integer.parseInt(req.queryParams("value"));
        String lucasList = LucasSequence.getFirstN(value).toString();
        return String.format("""
                {
                "operation": "Secuencia de Lucas",
                "input":  %d,
                "output":  "%s"
                }
                """, value, lucasList);
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8080;
    }
}
