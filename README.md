# spring-clock-time-machine

Project example showing how manipulate the time of your Java application using clock. Very useful for manual testing that needs to change the time of the application to produce some past/future scenarios.

# Build & Run

Just build and start the application as any Spring Boot application.

# How it works

I create some endpoints to illustrate the working code. All endpoints are using `GET` just to be easier to run the application and call the endpoints on your browser.

 - GET `/clock/` -> show the current time
 - GET `/clock?date=2019-01-05T10:50:12` -> change the date for any date you want
 - GET `/clock/release` -> rollback the time changes and use the system default
 
 All endpoints will return the current time of the application as response.

 # Code implementation details

 This was just a fast example on how you can manipulate the time of your Java application. I create a `DeloreanComponent`, which is responsable to offer a `Clock` implementation. You can pass the time that you want for the Delorean travel to it and ask Delorean what time it is in at the moment. :).
 
 To your code work using the Delorean time machine, all java.time classes that uses `now()` method (LocalDate, LocalDateTime, etc) will depends of the clock from the `DeloreanComponent`, like:
 
 ```java
 @Service
 class RandomService {
 
   private DeloreanComponent delorean;
   
   //constructor
   
   public boolean isBefore(LocalDate event) {
       return event.isBefore(LocalDate.now(delorean.getClock()));
   }
 
 }
```

The actual implementation depends on the `DeloreanComponent`, but ideally we could use just the `Clock` bean, but I could not think on a short time on how replace the `Clock` bean at runtime without a bean proxying that.
