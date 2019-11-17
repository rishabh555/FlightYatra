package com.mytechtra.spring.FlightYatra;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.mytechtra.spring.FlightYatra.HibernateEx.o2m.Car;
import com.mytechtra.spring.FlightYatra.HibernateEx.o2m.Engine;
import com.mytechtra.spring.FlightYatra.core.booking.BookFlightimpl;
import com.mytechtra.spring.FlightYatra.core.booking.BookFlights;
import com.mytechtra.spring.FlightYatra.core.flightservice.FlightService;
import com.mytechtra.spring.FlightYatra.core.flightservice.FlightServiceInMemoryImpl;
import com.mytechtra.spring.FlightYatra.core.flightservice.FlightServiceWithDao;
import com.mytechtra.spring.FlightYatra.core.inventory.Inventory;
import com.mytechtra.spring.FlightYatra.core.inventory.InventoryImplementation;
import com.mytechtra.spring.FlightYatra.model.Booking;
import com.mytechtra.spring.FlightYatra.model.Flight;
import com.mytechtra.spring.FlightYatra.model.Flight.AirLine;
import com.mytechtra.spring.FlightYatra.model.Ticket.TicketType;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EntityScan(basePackages = {"com.mytechtra.spring.FlightYatra.model","com.mytechtra.spring.FlightYatra.security"})
public class FlightYatraApplication {

	public static void main(String[] args) throws Exception {
		
		
		ConfigurableApplicationContext ctx = SpringApplication.run(FlightYatraApplication.class, args);	
		
		/*System.out.println("====Adding Flight------");
		Flight flight1 =new Flight();
		flight1.setAirLine(AirLine.INDIGO);
		flight1.setCapacity(9);
		flight1.setFlightId(101);
		flight1.setFligtName("Indigo101");
		
		Flight flight2 =new Flight();
		flight2.setAirLine(AirLine.SPICEJET);
		flight2.setCapacity(11);
		flight2.setFlightId(102);
		flight2.setFligtName("SpiceJet102");	
		FlightService flightService =ctx.getBean(FlightServiceWithDao.class);
		
		
		
		flightService.register(flight1);
		flightService.register(flight2);
		
		System.out.println("====Load Tickets------");	
          Inventory inventoryTickets = ctx.getBean(InventoryImplementation.class);	
          inventoryTickets.loadTickets(101, TicketType.ECONOMY, new Date(), 4412, 60);
          inventoryTickets.loadTickets(102, TicketType.BUSNISS, new Date(), 5402, 40);
		
		System.out.println("====Flight Booking------");		
		BookFlights bookingFlight = ctx.getBean(BookFlightimpl.class);			
		Booking b1  =bookingFlight.book(101,TicketType.ECONOMY, new Date(), 1);
		System.out.println("Your booking is confirmed ,Yours ticket Price is = "+b1.getPrice().getTotalAmount()
				+"Booking date is "+b1.getBookingDate()+"Date of booking is "+b1.getDateOfBooking());
		
		 System.out.println("Deleting filght");  
		flightService.unregister(flight2.getFlightId());
		 System.out.println("filght deletion successfullwith flight id= "+flight2.getFlightId());  
		*/
		
		// JPA start
		/*EntityManager manager = ctx.getBean(EntityManagerFactory .class).createEntityManager();
		
		
		Car car = new Car(3, "martuti", new Date());
		
		
		Engine engine1 =new Engine(3, "BS7");
		Engine engine2 =new Engine(5, "BS8");
		
		car.getEngines().add(engine1);
		car.getEngines().add(engine2);
		
		engine1.setCar(car);
		engine2.setCar(car);
		
		
		
		


		
		//Tx
		manager.getTransaction().begin();
		
		manager.persist(engine1);
		manager.persist(engine2);

		manager.persist(car);
		
		manager.persist(engine1);
		manager.persist(engine2);

		
		manager.getTransaction().commit(); */
		// JPA END
		
		/*Car car_rs= manager.find(Car.class, 2);
		System.out.println(manager.find(Car.class, 2).toString());
		
		System.out.println("-----------------------");
		
		System.out.println(car_rs.getEngines());*/
		
		
	}

}
