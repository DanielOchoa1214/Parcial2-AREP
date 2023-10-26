package org.example.proxyservice;

import spark.Request;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static spark.Spark.*;

public class ProxyService {
    public static void main(String... args){
        port(getPort());
        get("/", (req,res) -> Files.readAllBytes(Path.of("./src/main/resources/public/index.html")));
        get("/lucasseq", (req, res) -> getLucasSequence(req.queryParams("value")));
    }

    private static String getLucasSequence(String value) throws IOException {
        return RoundRobinPetition.makePetition(value);
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
