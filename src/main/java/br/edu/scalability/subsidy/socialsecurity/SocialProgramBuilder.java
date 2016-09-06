package br.edu.scalability.subsidy.socialsecurity;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Wither;

@AllArgsConstructor
@RequiredArgsConstructor
@Wither
public class SocialProgramBuilder {
	public String state;
	public String cityCode;
	public String cityName;
	public String beneficiaryName;
	public String value;
	public String yearMonth;
}
