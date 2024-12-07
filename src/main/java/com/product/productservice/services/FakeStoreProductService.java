package com.product.productservice.services;//package com.product.productservice.services;
//
//import com.product.productservice.dtos.FakeStoreProductDto;
//import com.product.productservice.exceptions.ProductNotFoundException;
//import com.product.productservice.models.FakeStoreCategory;
//import com.product.productservice.models.FakeStoreProduct;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RequestCallback;
//import org.springframework.web.client.ResponseExtractor;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class FakeStoreProductService implements ProductService{
//
//    RestTemplate restTemplate;
//
//    public FakeStoreProductService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @Override
//    public FakeStoreProduct getFakeStoreProductById(Long id) throws ProductNotFoundException {
//
//        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
//        if(fakeStoreProductDto == null)
//            throw new ProductNotFoundException(404L, "Product not found for " + id);
//        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
//    }
//
//    @Override
//    public List<FakeStoreProduct> getFakeStoreProducts() {
//        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class).getBody();
//        List<FakeStoreProduct> fakeStoreProducts = new ArrayList<>();
//        if(fakeStoreProductDtos != null) {
//            for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
//                fakeStoreProducts.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
//            }
//        }
//        return fakeStoreProducts;
//    }
//
//    @Override
//    public FakeStoreProduct replaceFakeStoreProduct(Long id, FakeStoreProduct product) {
//        FakeStoreProductDto fakeStoreProductDto1 = new FakeStoreProductDto();
//        fakeStoreProductDto1.setId(id);
//        fakeStoreProductDto1.setDescription(product.getDescription());
//        fakeStoreProductDto1.setPrice(product.getPrice());
//        fakeStoreProductDto1.setTitle(product.getTitle());
//        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto1);
//        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
//        FakeStoreProductDto fakeStoreProductDto2 = restTemplate.
//                execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor).
//                getBody();
//        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto2);
//    }
//
//    @Override
//    public FakeStoreProduct createFakeStoreProduct(FakeStoreProduct product) {
//        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
//        fakeStoreProductDto.setDescription(product.getDescription());
//        fakeStoreProductDto.setPrice(product.getPrice());
//        fakeStoreProductDto.setTitle(product.getTitle());
//        fakeStoreProductDto.setId(product.getId());
//        fakeStoreProductDto.setCategory(product.getCategory().getTitle());
//        FakeStoreProductDto fakeStoreProductDto1 = restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class);
//        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto1);
//    }
//
//    @Override
//    public FakeStoreProduct updateFakeStoreProduct(Long id, FakeStoreProduct product) {
//        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
//        fakeStoreProductDto.setId(product.getId());
//        fakeStoreProductDto.setDescription(product.getDescription());
//        fakeStoreProductDto.setPrice(product.getPrice());
//        fakeStoreProductDto.setTitle(product.getTitle());
//        if(product.getCategory() != null) {
//            fakeStoreProductDto.setCategory(product.getCategory().getTitle());
//        }
//        FakeStoreProductDto fakeStoreProduct1 = restTemplate.patchForObject("https://fakestoreapi.com/products/" + id, fakeStoreProductDto, FakeStoreProductDto.class);
//        return convertFakeStoreProductDtoToProduct(fakeStoreProduct1);
//    }
//
//    private FakeStoreProduct convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
//        if (fakeStoreProductDto == null) {
//            return null; // Handle null gracefully
//        }
//
//        FakeStoreProduct product = new FakeStoreProduct();
//        product.setId(fakeStoreProductDto.getId());
//        product.setTitle(fakeStoreProductDto.getTitle());
//        product.setDescription(fakeStoreProductDto.getDescription());
//        product.setPrice(fakeStoreProductDto.getPrice());
//        FakeStoreCategory category = new FakeStoreCategory();
//        category.setTitle(fakeStoreProductDto.getCategory());
//        product.setCategory(category);
//
//        return product;
//    }
//}
