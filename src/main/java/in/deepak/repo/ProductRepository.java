package in.deepak.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.deepak.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
