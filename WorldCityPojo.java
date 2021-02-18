package jbcbExamples;

public class WorldCityPojo {
	
	private Integer cityId;
	@Override
	public String toString() {
		return "WorldCityPojo [cityId=" + cityId + ", cityName=" + cityName + ", cityCountryCode=" + cityCountryCode
				+ ", cityDistrict=" + cityDistrict + ", cityPopulation=" + cityPopulation + "]";
	}
	private String cityName;
	private String cityCountryCode;
	private String cityDistrict;
	private Long cityPopulation;
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCountryCode() {
		return cityCountryCode;
	}
	public void setCityCountryCode(String cityCountryCode) {
		this.cityCountryCode = cityCountryCode;
	}
	public String getCityDistrict() {
		return cityDistrict;
	}
	public void setCityDistrict(String cityDistrict) {
		this.cityDistrict = cityDistrict;
	}
	public Long getCityPopulation() {
		return cityPopulation;
	}
	public void setCityPopulation(Long cityPopulation) {
		this.cityPopulation = cityPopulation;
	}
}
