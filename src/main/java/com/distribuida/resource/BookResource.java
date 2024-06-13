package com.distribuida.resource;

/*import com.distribuida.db.Book;
import com.distribuida.service.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/books")*/
public class BookResource {

    /*@Inject
    private BookService bookService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book createBook(Book book, @Suspended ServerResponse response) {
        return bookService.createBook(book);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book findBookById(@PathParam("id") Integer id, @Suspended ServerResponse response) {
        return bookService.findBookById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> findAllBooks(@Suspended ServerRequest request, @Suspended ServerResponse response) {
        return bookService.findAllBooks();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book updateBook(Book book, @Suspended ServerResponse response) {
        return bookService.updateBook(book);
    }

    @DELETE
    @Path("/{id}")
    public void deleteBook(@PathParam("id") Integer id, @Suspended ServerResponse response) {
        bookService.deleteBook(id);
        response.status(204).send();
    }*/
}
