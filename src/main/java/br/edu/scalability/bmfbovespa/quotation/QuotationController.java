package br.edu.scalability.bmfbovespa.quotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by rodrigopinheiro on 8/27/16.
 */
@RestController
@RequestMapping("/quotation")
public class QuotationController {

    //    @RequestMapping("/list")
    public  Quotation getQuotation() {
        return new QuotationBuilder()
                .withAveragePrice("12")
                .withCode("PETR4")
                .withCompany("Petrobras")
//                .withId(UUID.fromString("1"))
                .withLastPrice("10")
                .withMaxPrice("34")
                .withMinPrice("5")
                .withOpenPrice("11")
                .withTotalTrading("1234")
                .withTotalVolume("1000000")
                .withTradingDate(new Date())
                .build();
    }

    @RequestMapping("/list")
    public List<Quotation> listQuotation() {
        return Arrays.asList(new QuotationBuilder()
                .withAveragePrice("12")
                .withCode("PETR4")
                .withCompany("Petrobras")
                .withId(UUID.randomUUID())
                .withLastPrice("10")
                .withMaxPrice("34")
                .withMinPrice("5")
                .withOpenPrice("11")
                .withTotalTrading("1234")
                .withTotalVolume("1000000")
                .withTradingDate(new Date())
                .build());
    }
}
