package sud.webservices;

import java.util.ArrayList;

import javax.jws.WebService;

import sud.domain.Product;
import sud.domain.Products;
import sud.exceptions.NoSuchProductException;

@WebService(serviceName = "ProductService")
public class ProductsManagerImpl implements ProductsManager {
	
	private static Products products = new Products(new ArrayList<>());

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		products.add(product);
	}

	@Override
	public Product getProduct(long id) throws NoSuchProductException {
		Product product = products.get(id);
		
		if(product != null) {
			return product;
		} else {
			throw new NoSuchProductException("No such product");
		}
		
	}

	@Override
	public double getProductPrice(long id) throws NoSuchProductException {
		Product product = products.get(id);
		
		if(product.getId() == id) {
			return product.getPrice();
		} else {
			throw new NoSuchProductException("No such product");
		}
		
	}

	@Override
	public Products getProducts() {
		return products;
	}

	@Override
	public Product updateProduct(Product product) {
		Product newProduct = products.get(product.getId());
		newProduct.setLabel(product.getLabel());
		newProduct.setPrice(product.getPrice());
		return newProduct;
	}

	@Override
	public boolean deleteProduct(long id) {
		// TODO Auto-generated method stub
		return products.remove(id);
	}

	@Override
	public boolean deleteAllProducts() {
		// TODO Auto-generated method stub
		return products.removeAll();
	}
	
}
