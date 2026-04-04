package Rasheed.backend.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import Rasheed.backend.Entity.BookCheckOut;

public interface BookCheckOutRepository extends JpaRepository<BookCheckOut, Integer>{
    public BookCheckOut findByBookId(Integer book);

    public boolean existsByBookId(Integer book);
    

}
