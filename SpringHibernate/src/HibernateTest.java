import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import entity.Product;
import repo.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class HibernateTest {
	@Autowired
	private ProductRepository productRepository;

	@Test
	public void testHibernate() {
		Product p = new Product();
		p.setName("Acer");
		p.setPrice(28000.0);
		productRepository.add(p);
	}
	
	@Test
	public void testCase2() {
		Product p = new Product();
		p = productRepository.get(261);
		System.out.println(p.getName());
	}
	
	@Test
	public void testCase3() {
		List<Product> products = new ArrayList<>();
		products = productRepository.getAll();
		for (Product p : products) {
			System.out.println(p.getName() +" : " + p.getPrice());
		}
		
	}
	
}

