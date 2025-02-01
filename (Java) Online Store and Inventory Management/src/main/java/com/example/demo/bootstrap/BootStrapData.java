package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        if (partRepository.count() == 0) {
            OutsourcedPart lgMonitor = new OutsourcedPart();
            lgMonitor.setCompanyName("LG");
            lgMonitor.setId(1);
            lgMonitor.setName("LG Monitor - 4k - 32 Inch");
            lgMonitor.setInv(21);
            lgMonitor.setPrice(899.99);
            lgMonitor.setMaxInv(50);
            lgMonitor.setMinInv(5);
            outsourcedPartRepository.save(lgMonitor);

            InhousePart ram32 = new InhousePart();
            ram32.setId(2);
            ram32.setName("32mb RAM");
            ram32.setInv(15);
            ram32.setPrice(499.99);
            ram32.setMaxInv(50);
            ram32.setMinInv(5);
            partRepository.save(ram32);

            InhousePart clearTower = new InhousePart();
            clearTower.setId(3);
            clearTower.setName("Clear Tower w/ RGB LED");
            clearTower.setInv(17);
            clearTower.setPrice(299.99);
            clearTower.setMaxInv(50);
            clearTower.setMinInv(5);
            partRepository.save(clearTower);

            OutsourcedPart terabytesshd = new OutsourcedPart();
            terabytesshd.setCompanyName("Seagate");
            terabytesshd.setId(4);
            terabytesshd.setName("1 Terabyte SSHD");
            terabytesshd.setInv(9);
            terabytesshd.setPrice(399.99);
            terabytesshd.setMaxInv(50);
            terabytesshd.setMinInv(5);
            outsourcedPartRepository.save(terabytesshd);

            OutsourcedPart wirelessKeyboard = new OutsourcedPart();
            wirelessKeyboard.setCompanyName("Logitech");
            wirelessKeyboard.setId(5);
            wirelessKeyboard.setName("Logitech Bluetooth Wireless Keyboard");
            wirelessKeyboard.setInv(13);
            wirelessKeyboard.setPrice(129.99);
            wirelessKeyboard.setMaxInv(50);
            wirelessKeyboard.setMinInv(5);
            outsourcedPartRepository.save(wirelessKeyboard);
        }

        if (productRepository.count() == 0) {
            Product john = new Product("John's PC", 2199.99, 2);
            productRepository.save(john);

            Product mason = new Product("Mason's PC", 1700.00, 3);
            productRepository.save(mason);

            Product jerry = new Product("Jerry's Ultimate Gaming PC", 3999.99, 7);
            productRepository.save(jerry);

            Product marcus = new Product("Marcus' PC", 2819.99, 5);
            productRepository.save(marcus);

            Product clint = new Product("Clint's PC", 1499.99, 22);
            productRepository.save(clint);
        }

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
