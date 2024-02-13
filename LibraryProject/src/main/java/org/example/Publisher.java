package org.example;

import jakarta.persistence.*;
import org.example.Book;

import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id", columnDefinition = "serial")
    private long id;
    @Column(name = "publisher_name")
    private String name;
    @Column(name = "establishment_year")
    private int establishment_year;
    @Column(name = "publisher_address")
    private String address;
    @OneToMany(mappedBy = "publisher",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Book> bookList;
    public Publisher() {
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstablishment_year() {
        return establishment_year;
    }

    public void setEstablishment_year(int establishment_year) {
        this.establishment_year = establishment_year;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", establishment_year=" + establishment_year +
                ", address='" + address + '\'' +
                '}';
    }
}
