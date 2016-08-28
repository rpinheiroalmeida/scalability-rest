package br.edu.scalability.bmfbovespa.quotation;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Wither;

import java.util.Date;
import java.util.UUID;

/**
 * Created by rodrigopinheiro on 8/27/16.
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Wither
public class QuotationBuilder {

    private UUID id;
    private String code;
    private String company;
    private Date tradingDate;
    private String openPrice;
    private String maxPrice;
    private String minPrice;
    private String averagePrice;
    private String lastPrice;
    private String totalTrading;
    private String totalVolume;

    public Quotation build() {
        Quotation quotation = new Quotation();

        quotation.setId(id);
        quotation.setCode(code);
        quotation.setCompany(company);
        quotation.setTradingDate(tradingDate);
        quotation.setOpenPrice(openPrice);
        quotation.setMaxPrice(maxPrice);
        quotation.setMinPrice(minPrice);
        quotation.setAveragePrice(averagePrice);
        quotation.setLastPrice(lastPrice);
        quotation.setTotalTrading(totalTrading);
        quotation.setTotalVolume(totalVolume);

        return quotation;
    }
}
