package com.distribuida;

import com.distribuida.service.IBookService;
import com.google.gson.Gson;
import io.helidon.webserver.WebServer;
import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;
import com.distribuida.db.Book;

import io.helidon.webserver.*;

import jakarta.enterprise.inject.spi.CDI;

import java.math.BigDecimal;

public class Main {

    private static ContainerLifecycle lifecycle = null;

    public static void main(String[] args) {

        //test del servicio

        lifecycle = WebBeansContext.currentInstance().getService(ContainerLifecycle.class);
        lifecycle.startApplication(null);

        IBookService servicio = CDI.current().select(IBookService.class).get();

        /*var nwbook = new Book();
        nwbook.setId(2);
        nwbook.setIsbn("algo");
        nwbook.setTitle("el barco de teseo");
        nwbook.setAuthor("Carlos");
        nwbook.setPrice(BigDecimal.valueOf(1500));
        servicio.createBook(nwbook);

        var resultBook = servicio.findBookById(nwbook.getId());

        System.out.println(resultBook);*/

        servicio.findAllBooks().forEach(b -> System.out.println(b.getTitle()));

        Gson gson = new Gson();

        WebServer server = WebServer.builder()
                .routing(it -> it
                //.get("/books/{id}", (request, response) -> response.send(gson.toJson(servicio.findBookById(4))))//test
                .get("/books/{id}", (request, response) ->{
                    Integer requestIneger = Integer.valueOf(request.path().pathParameters().get("id"));
                    response.send(gson.toJson(servicio.findBookById(requestIneger)));
                })
                .get("/books", (request, response) -> response.send(gson.toJson(servicio.findAllBooks())))
                .post("/books",(request, response)->{
                    String requestBody = request.content().as(String.class);
                    Book requestEntity = gson.fromJson(requestBody, Book.class);
                    response.send(gson.toJson(servicio.createBook(requestEntity)));
                })
                .put("/books",(request, response)->{
                    String requestBody = request.content().as(String.class);
                    Book requestEntity = gson.fromJson(requestBody, Book.class);
                    response.send(gson.toJson(servicio.updateBook(requestEntity)));
                })
                .delete("/books/{id}",(request, response)->{
                    Integer requestIneger = Integer.valueOf(request.path().pathParameters().get("id"));
                    response.send(gson.toJson(servicio.deleteBook(requestIneger)));
                })
            )
            .port(8080)
            .build()
            .start();

        System.out.println("Server is running at http://localhost:"+server.port());

    }

    public static void shutdown() {
        lifecycle.stopApplication(null);
    }

}



