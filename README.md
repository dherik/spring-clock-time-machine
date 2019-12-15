# spring-clock-time-machine

Project example showing how manipulate the time of your Java application using clock. Very useful for manual testing.

# Build & Run

Just build and start the application as any Spring application.

# How it works

I create some endpoints to illustrate the working code. All endpoints are using `GET` just to be easier to run the application and call the endpoints on your browser.

 - GET /clock/ -> show the current time
 - GET /clock?date=2019-01-05T10:50:12 -> change the date for any date you want
 - GET /clock/release -> rollback the time changes and use the system default

 # Code implementation details

 This was just a fast example on how you can manipulate the time of your Java application. I create a `DeloreanComponent` what is responsable to offer a `Clock` implementation. You can pass the time that you want to the Delorean travel and ask for the Delorean what time it in right now :).