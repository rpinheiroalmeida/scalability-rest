package br.edu.scalability.bmfbovespa.company;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Wither;

/**
 * Created by rodrigopinheiro on 8/27/16.
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Wither
public class CompanyBuilder {

    private String code;
    private String name;

    public Company build() {
        return new Company(code, name);
    }
}
