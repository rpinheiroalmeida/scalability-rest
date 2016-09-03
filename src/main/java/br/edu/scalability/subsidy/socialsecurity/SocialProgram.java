package br.edu.scalability.subsidy.socialsecurity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//@Table
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class SocialProgram {
	public String state;
	public String cityCode;
	public String cityName;
	public String beneficiaryName;
	public String value;
	public String yearMonth;

}
