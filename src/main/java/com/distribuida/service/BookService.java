package com.distribuida.service;

import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
//import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped
//@Transactional
public class BookService implements IBookService {

    @Inject
    private EntityManager em;


    @Override
    public Book createBook(Book book) {
        em.persist(book);
        return book;
    }

    @Override
    public Book findBookById(Integer id) {
        return em.find(Book.class, id);
    }

    @Override
    public List<Book> findAllBooks() {
        return em.createQuery("select b from Book b")
                .getResultList();
    }

    @Override
    public Book updateBook(Book book) {
        return em.merge(book);
    }

    @Override
    public Integer deleteBook(Integer id) {
        Book book = em.find(Book.class, id);
        if (book != null) {
            em.remove(book);
            return 1;
        }
        else{
            return 0;
        }
    }










}