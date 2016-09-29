package site.lovecode.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.lovecode.boot.entity.Country;

/**
 * Created by yang peng on 2016/9/29.
 */
@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
}
