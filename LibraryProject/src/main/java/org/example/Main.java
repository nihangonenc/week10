package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        //Yazar ekleme
        Author author1 = new Author();
        author1.setName("Sabahattin Ali");
        author1.setBirthDate(LocalDate.of(1907,2,25));
        author1.setCountry("İstanbul");
        entityManager.persist(author1);

        //Yayınevi ekleme
        Publisher publisher1 = new Publisher();
        publisher1.setName("Yapı Kredi Yayınları");
        publisher1.setAddress("İstanbul");
        publisher1.setEstablishment_year(1945);
        entityManager.persist(publisher1);

        //Kategori ekleme
        Category category1 = new Category();
        category1.setName("Edebiyat");
        entityManager.persist(category1);

        Category category2 = new Category();
        category2.setName("Roman");
        entityManager.persist(category2);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category1);
        categoryList.add(category2);

        //Kitap ekleme
        Book book1 = new Book();
        book1.setName("Kürk Mantolu Madonna");
        book1.setStock(100);
        book1.setPublicationYear(2024);
        book1.setPublisher(publisher1);
        book1.setAuthor(author1);
        book1.setCategoryList(categoryList);
        entityManager.persist(book1);

        //Ödünç alma ekleme
        BookBorrowing borrowing1 = new BookBorrowing();
        borrowing1.setBook(book1);
        borrowing1.setBorrowerName("Nihan Nur Gönenç");
        borrowing1.setBorrowingDate(LocalDate.now());
        borrowing1.setReturnDate(null);
        entityManager.persist(borrowing1);

        transaction.commit();
    }
}