package me.nielcho.jdk8.api;

import java.time.*;

/**
 * Created by daniel on 16/8/12.
 */
public class DateAndTime {


    public static void main(String[] args) {
        final Clock utcClock = Clock.systemUTC();
        System.out.println(utcClock.instant());
        System.out.println(utcClock.millis());

        final Clock systemClock = Clock.systemDefaultZone();
        System.out.println(systemClock.instant());
        System.out.println(systemClock.millis());

        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(utcClock);
        System.out.println(date);
        System.out.println(dateFromClock);

        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now(utcClock);
        System.out.println(time);
        System.out.println(timeFromClock);

        final LocalDateTime dateTime = LocalDateTime.now();
        final LocalDateTime dateTimeFromClock = LocalDateTime.now(utcClock);
        System.out.println(dateTime);
        System.out.println(dateTimeFromClock);


        // Get the zoned date/time
        final ZonedDateTime zonedDatetime = ZonedDateTime.now();
        final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now(utcClock);
        final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(zonedDatetime);
        System.out.println(zonedDatetimeFromClock);
        System.out.println(zonedDatetimeFromZone);

        // Duration
        final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
        final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );
        final Duration duration = Duration.between( from, to );
        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );



    }
}
