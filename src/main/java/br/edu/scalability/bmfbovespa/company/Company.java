package br.edu.scalability.bmfbovespa.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by rodrigopinheiro on 8/27/16.
 */
//@Table
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Company {

    private String code;
    private String name;

}