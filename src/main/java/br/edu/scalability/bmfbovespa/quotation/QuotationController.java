package br.edu.scalability.bmfbovespa.quotation;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @RequestMapping("/{code}/mostRecent")
    public Quotation mostRecent(@PathVariable String code) {
        return new QuotationBuilder()
                .withAveragePrice("12")
                .withCode(code)
                .withCompany("Petrobras")
                .withId(UUID.randomUUID())
                .withLastPrice("10")
                .withMaxPrice("34")
                .withMinPrice("5")
                .withOpenPrice("11")
                .withTotalTrading("1234")
                .withTotalVolume("1000000")
                .withTradingDate(new Date())
                .build();
    }

    @RequestMapping("/list/{code}")
    public List<Quotation> listQuotation(@PathVariable String code, @RequestParam("data") String date) throws ParseException {
        Date dateParameter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date);

        return Arrays.asList(new QuotationBuilder()
                .withAveragePrice("12")
                .withCode(code)
                .withCompany("Petrobras")
                .withId(UUID.randomUUID())
                .withLastPrice("10")
                .withMaxPrice("34")
                .withMinPrice("5")
                .withOpenPrice("11")
                .withTotalTrading("1234")
                .withTotalVolume("1000000")
                .withTradingDate(dateParameter)
                .build());
    }




}
