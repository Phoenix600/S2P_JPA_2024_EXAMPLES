package com.pranay.JpaExamples.repository;

import com.pranay.JpaExamples.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    /// Custom Query Methods

    /// Returns the found product entry by using its name as search
    /// criteria. If no product entry is found, this method returns
    /// null.
    /// select * from products where name=?;
    public abstract Product findByName(String name);

    /// Returns an Optional which contains the found product entry
    /// by using its id as search criteria. If no product entry is
    /// found, it returns an empty optional.
    /// select * from product where id=?
    public abstract Optional<Product> findById(Long id);

    /// Returns the found list of product entries whose name and description is given as a method
    /// parameter. If no product is found this method returns an empty list.
    /// SELECT * FROM product WHERE name=? AND description=?;
    public abstract List<Product> findByNameAndDescription(String name, String description);

    /// Returns the found list of product entries whose name and description is given as a method
    /// parameter. If no product is found this method returns an empty list.
    /// SELECT * FROM product WHERE name=? OR description=?;
    public abstract List<Product> findByNameOrDescription(String name, String description);


    /// Returns the found unique product entity by using its name as search criteria.
    /// If no product is entry is found this method returns the null.
    ///  SELECT distinct  *  FROM product where id=?
    public abstract Product findDistinctByName(String name);

    /// Returns the found list of product entities whose price is greater than the price
    /// given as the method parameter. If no product is found, this method returns the empty list
    /// SELECT * FROM product WHERE price > ?;
    public abstract List<Product> findByPriceGreaterThan(BigDecimal price);

    /// Returns the found list of product entities whose price is less than the price
    /// given as the method parameter. If no product is found, this method returns the empty list
    /// SELECT * FROM product WHERE price < ?;
    public abstract List<Product> findByPriceLessThan(BigDecimal price);

    /// SELECT * FROM product where name LIKE '%product%'
    public abstract List<Product> findByNameContaining(String name);

    /// Returns the found list of product entities whose names matches with pattern given as the
    /// method parameter. If no product is found, this method returns the empty list.
    /// SELECT * FROM product WHERE name LIKE '%product%'
    public abstract List<Product> findByNameLike(String name);

    /// Returns the found list of product entities whose price is between startPrice and EndPrice
    /// given as the method parameter. If no product is found, this method returns the empty list
    /// SELECT * FROM product WHERE price BETWEEN ? AND ?
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    /// Returns the found list of product entities whose DateCreated is between startDate and EndDate
    /// Given as the method parameter. If no product is found this method returns the empty list
    /// SELECT * FROM product WHERE date_created BETWEEN ? AND ?
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);


    /**
     * Returns the found list of product entities whose name matches with list of values given
     * values as method parameter. If no product is found this returns the empty list
     * @return List<Product>
     * @Query  SELECT * FROM product WHERE name IN (?,?,?,.....)
     */
    List<Product> findByNameIn(List<String> names);

    /**
     * Returns the found list of first two product entities from database table in Ascending Order of names. if product is not found this
     * method returns the empty list
     * @return List<Product>
     * @Query
     */
    List<Product> findFirst2ByOrderByNameAsc();

    /**
     * Returns the found list of top three product entities in descending order of their price. if no product is found this returns
     * the empty list.
     * @return List<Product>
     */
    List<Product> findTop3ByOrderByPriceDesc();
}
