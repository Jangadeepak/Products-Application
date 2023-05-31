package in.deepak.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.deepak.binding.Product;
import in.deepak.entity.ProductEntity;
import in.deepak.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public boolean Savefromdata(Product pt) {
		
		ProductEntity entity  = new ProductEntity();
		
		BeanUtils.copyProperties(pt, entity);
		
		repo.save(entity);
		
		
		return true;
	}
	
	
}
