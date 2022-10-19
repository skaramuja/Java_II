package event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import event.beans.Concert;

@Repository
public interface EventRepository extends JpaRepository<Concert, Long> {

}
