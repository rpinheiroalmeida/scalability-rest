package br.edu.scalability.bmfbovespa.quotation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

/**
 * Created by rodrigopinheiro on 8/27/16.
 */
@Data
@EqualsAndHashCode
@ToString
public class Quotation {

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

}
