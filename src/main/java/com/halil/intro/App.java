package com.halil.intro;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(City.class)
				.buildSessionFactory();

		Session mySession = myFactory.getCurrentSession();
		try {
			mySession.beginTransaction();
			// select * from city where TUR
			// from City c where c.countryCode='TUR' OR c.countryCode='USA'
			// from City c where c.name LIKE '%kar'
			/*
			 * List<City> cities =
			 * mySession.createQuery("from City c ORDER BY c.name DESC").getResultList();
			 * for (City city : cities) { System.out.println(city.getName()); }
			 * System.out.println(cities.size());
			 */
			//
//			City myCity = new City();
//			myCity.setName("Aydin");
//			myCity.setCountryCode("TUR");
//			myCity.setDistrict("Ege");
//			myCity.setPopulation(1000000);

			// mySession.save(myCity);
			/*
			 * City myCity =mySession.get(City.class, 4084); myCity.setPopulation(100);
			 * mySession.save(myCity); System.out.println(myCity.getName());
			 */
			City myCity =mySession.get(City.class, 4084);
			mySession.delete(myCity);

			mySession.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			myFactory.close();
		}
	}
}
