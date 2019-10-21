package com.lx.spring.cloud.weather;

import com.lx.spring.cloud.weather.util.JsonUtils;
import com.lx.spring.cloud.weather.vo.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void getCityS(){

		try {
			List<City> cities = JsonUtils.readArray("最新_city.json", City.class);
			System.out.println(cities.size());
			City city = cities.get(2531);
			for (City city1:cities){
				System.out.println(city1.toString());
				Thread.sleep(1000);
			}
			System.out.println(city.toString());


		} catch (IOException e) {
			e.printStackTrace();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
