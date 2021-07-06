package com.myretail.rest.controllers;

import java.util.Map;
import java.util.List;
import org.json.JSONObject;

//import com.myretail.rest.classes.PriceRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.rest.classes.Product;
import com.myretail.rest.classes.PriceData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class MyRetailInteraction implements CommandLineRunner {
    
    // @Autowired
	// private PriceRepository repository;
    DatabaseConnection dbc = new DatabaseConnection();
    String globalURL;

    private Product getSingleProductData()
    {
        Product product = new Product();
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate rest = new RestTemplate();

        Map<String, Map> map;
        ResponseEntity<String> response = rest.getForEntity(globalURL, String.class);
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

    @GetMapping(value="products/{id}")
    private Product combineData(@PathVariable("id") String tcin_id)
    {
        //String tcin_id = "13860424";
        globalURL = "https://redsky.target.com/v3/pdp/tcin/" + tcin_id + "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics&key=candidate#_blank";

        List<PriceData> priceDataList = dbc.getPriceData();
        Product product = getSingleProductData();
        for (PriceData priceData : priceDataList)
        {
            if (priceData.getId().equals(tcin_id))
            {
                //product.setId(Integer.parseInt(tcin_id);
                // product.setValue(priceData.getPrice());
                // product.setCurrency_code(priceData.getCurrencyCode());
                product.setCurrent_price(priceData);
            }
        }
        System.out.println(product);
        
        return product;
    }


    //BONUS
    // @PutMapping(value="product/{id}")
    // private @ResponseBody String updateDataPost(@PathVariable("id") String tcin_id)
    // {
    //     String result="";
    //     PriceData priceData = new PriceData();
    //     JSONObject myObject = new JSONObject();
    //     //priceData = repository.findById(tcin_id); ?Optional<PriceData>
        
    //     result = myObject.toString();
    //     System.out.println(result);
    //     return result;
    // }

    @Override
    public void run(String...args) throws Exception {
        //System.out.println("hi");
        //getSingleProductData();
        //combineData();
    }
    
}
