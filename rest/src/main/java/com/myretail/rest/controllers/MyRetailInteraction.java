package com.myretail.rest.controllers;

import java.util.Map;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.rest.classes.Product;
import com.myretail.rest.classes.PriceData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class MyRetailInteraction implements CommandLineRunner {
    
    DatabaseConnection dbc = new DatabaseConnection();
    String tcin_id = "13860424";
    String url = "https://redsky.target.com/v3/pdp/tcin/" + tcin_id + "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics&key=candidate#_blank";

    @GetMapping(value="product/{id}")
    private Product combineData()
    {

        List<PriceData> priceDataList = dbc.getPriceData();
        Product product = getSingleProductData();
        for (PriceData priceData : priceDataList)
        {
            if (priceData.getId().equals(tcin_id))
            {
                //product.setId(Integer.parseInt(tcin_id);
                product.setValue(priceData.getPrice());
                product.setCurrency_code(priceData.getCurrencyCode());
            }
        }
        System.out.println(product);
        
        return product;
    }
     // @GetMapping(value="product/{id}")
    // public Product getMethodName(@RequestParam String param) {
    //     return new SomeData();
    // }


    private Product getSingleProductData()
    {
        Product product = new Product();
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate rest = new RestTemplate();

        Map<String, Map> map;
        ResponseEntity<String> response = rest.getForEntity(url, String.class);
		HttpStatus responseCode = response.getStatusCode();
		try {
			map = objectMapper.readValue(response.getBody(), Map.class);
			Map<String, Map> productMap = map.get("product");
			Map<String, Map> itemMap = productMap.get("item");
			Map<String, String> itemMapString = productMap.get("item");
			Map<String, String> productDescription = itemMap.get("product_description");

			if (responseCode == HttpStatus.OK) {
				product.setId(Integer.parseInt(itemMapString.get("tcin")));
				product.setName(productDescription.get("title"));
			}
		} catch (Exception e) {
			System.out.println(responseCode);
		}
        //System.out.println(product);
        return product;
    }

    @Override
    public void run(String...args) throws Exception {
        System.out.println("hi");
        //getSingleProductData();
        combineData();
    }
    
}
