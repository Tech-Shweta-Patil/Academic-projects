package com.company;
import java.util.*;
class Flight{
    Scanner sc=new Scanner (System.in);
    boolean [] reserveSeats;
    String source,destination,ticketclass;
    int count;
    int countB;
    int countE;
    String name;
    String seatNo;
    Flight [] arr;
    public  Flight(String src,String des)
    {
        reserveSeats=new boolean[30];
        this.source=src;
        this.destination=des;
        this.count=0;
        this.countB=0;
        this.countE=0;
        seatNo=null;
        this.name=null;
        arr=new Flight[30];
    }

    public void bookTicket( String src,String des,int i){

        if (count< 30) {
            System.out.println("1.Book a ticket for Business Class\n2.Book a ticket for Economic class");
            int cls=sc.nextInt();
            if(cls==1){
                ticketclass="Business";
                System.out.println("Passenger Name : ");

                name=sc.next()+ sc.nextLine();
                while(countB<15) {

                    System.out.println();
                    reserveSeats[countB] =  true;
                    seatNo="ARS1705200"+i;
                    count++;
                    countB++ ;
                    break;
                }
            }
            else if(cls==2){
                ticketclass="Economic";
                System.out.println("Passenger Name : ");

                name=sc.next()+ sc.nextLine();
                while(countE<15){
                    reserveSeats[countE] = true;
                    seatNo="ARS1705200"+i;

                    count++;
                    countE++ ;
                    break;
                }

            }

            System.out.println("Your ticket has been booked successfully for journey "+src+" to "+des+
                    " of "+ticketclass +" class....." );
            System.out.println("Thank You for using Online Airline Reservation System");

        }
        else if(count > 30) {
            System.out.println("sorry Reservations are full can not book your ticket now");
        }
    }

    public int ticketPrice(String src,String des){
        int price=0;
        if ( this.source.equals("Mumbai") && this.destination.equals("Chennai") &&
                this.ticketclass.equals("Business")) {
            price=price+4000 ;
        }
        else if( this.source.equals("Mumbai") && this.destination.equals("Chennai") &&
                this.ticketclass.equals("Economic")){
            price=price+3000;
        }

        else if( this.source.equals("Mumbai") && this.destination.equals(" Delhi") &&
                this.ticketclass.equals("Economic")) {
            price = price + 4000;
        }

        else if( this.source.equals("Mumbai") && this.destination.equals(" Delhi") &&
                this.ticketclass.equals("Business")) {
            price = price + 5000;
        }

        else if( this.source.equals("Mumbai") && this.destination.equals("Goa") &&
                this.ticketclass.equals("Business")) {
            price = price + 5500;
        }

        else if( this.source.equals("Mumbai") && this.destination.equals("Goa") &&
                this.ticketclass.equals("Economic")) {
            price = price + 4500;
        }

        return price;
    }

    public static void displayTicket( Flight f,int i){



        System.out.println();
        System.out.println("Your Booking Details are as follow:");
        System.out.println("_________________________________________________________________");
        System.out.println();
        System.out.println("*****************************************************************");
        System.out.println();
        System.out.println("...AIR INDIA...                                                      ");
        System.out.println("               Flight : " + f.source + " ---> " + f.destination +  "         ");
        System.out.println("               Name : " + f.name       );
        System.out.println("               Seat Number :  ARS1705200" + i + "                     ");
        System.out.println("               Class : " + f.ticketclass + "                          ");
        System.out.println("               Expense : " + f.ticketPrice(f.source, f.destination)+ "   ");
        System.out.println("                                           HAPPY JOURNEY.......  ");
        System.out.println();
        System.out.println("*****************************************************************");
        System.out.println("_________________________________________________________________");
        System.out.println();



    }




    public  void checkTicketAvailability(Flight f){
        int ch;
        System.out.println("1.Check Business Class ticket availability\n" +"2.Check Economic class ticket availability");
        System.out.println();

        System.out.println("Enter your choice..");
        ch=sc.nextInt();
        if(ch==1){
            System.out.println((15-f.countB)+" tickets available");
        }
        else if(ch==2){
            System.out.println((15-f.countE)+" tickets available");
        }
    }

    public void cancelTicket(Flight f,String sitnum) {

        for(int i=0;i<count;i++) {
            if(sitnum.equals(("ARS1705200" + i))){
                f.reserveSeats[i]=false;
            }
            System.out.println("Your booking has been cancelled....");
        }

    }


}

public class AirLineReservation {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int choice,ans;
        int i=0,j=5,k=10;
        Flight flight1 = new Flight("Mumbai", "Chennai");
        Flight flight2 = new Flight("Mumbai", " Delhi");
        Flight flight3 = new Flight("Mumbai", "Goa");

        ArrayList <Flight> MTC = new ArrayList<>();
        ArrayList <Flight> MTD = new ArrayList<>();
        ArrayList <Flight> MTG = new ArrayList<>();


        do {
            System.out.println();
            System.out.println("********************AIR INDIA********************");
            System.out.println();
            System.out.println("1.Book a Ticket\n2.View Ticket Availability\n3.Cancel Booking" + "\n4.Check all bookings of a flight");
            System.out.println();
            System.out.println("Please select one..");
            choice=scan.nextInt();
            switch(choice){
                case 1 :
                {
                    int sol;
                    do {
                        System.out.println("Welcome to our online reservation System...");
                        System.out.println();
                        System.out.println("Booking  is going on for these flights: ");
                        System.out.println();
                        System.out.println("1.Mumbai to Chennai\n2.Mumbai to Delhi\n3.Mumbai to Goa");
                        System.out.println();
                        System.out.println("Enter your choice");
                        int ch = scan.nextInt();
                        if (ch == 1) {
                            flight1.bookTicket(flight1.source, flight1.destination,i);
                            Flight.displayTicket(flight1,i);
                            MTC.add(flight1);
                            i++;
                        } else if (ch == 2) {
                            flight2.bookTicket(flight2.source, flight2.destination,j);
                            Flight.displayTicket(flight2,j);
                            MTD.add(flight2);
                            j++;
                        } else if (ch == 3) {
                            flight3.bookTicket(flight3.source, flight3.destination,k);
                            Flight.displayTicket(flight3,k);
                            MTG.add(flight3);
                            k++;
                        }
                        System.out.println();
                        System.out.println("Do you want to book more ticket ??");
                        System.out.println("Press 1 to book another one");
                        sol=scan.nextInt();

                    }while(sol==1);
                    break;
                }

                case 2 :{
                    int cont,ch;
                    do {
                        System.out.println("Check ticket availability for flights...........");
                        System.out.println("1.Mumbai to Chennai\n2.Mumbai to Delhi\n3.Mumbai to Goa");
                        System.out.println("Enter your choice...");
                        ch = scan.nextInt();
                        switch (ch) {
                            case 1: {
                                flight1.checkTicketAvailability(flight1);
                                break;
                            }
                            case 2: {
                                flight2.checkTicketAvailability(flight2);
                                break;
                            }
                            case 3: {
                                flight3.checkTicketAvailability(flight3);
                                break;
                            }
                        }System.out.println(" press 1 to Check available tickets for " +
                                " other flights");
                        cont=scan.nextInt();
                    }while(cont==1);
                    break;
                }

                case 3 :{
                    int contd;
                    do{
                        System.out.println("Cancel Booking for");
                        System.out.println();
                        System.out.println("1.Mumbai to Chennai\n2.Mumbai to Delhi\n3.Mumbai to Goa\n");
                        System.out.println();
                        System.out.println("Please choose the flight for cancellation  : ");
                        int choose=scan.nextInt();
                        switch(choose){
                            case 1:{
                                System.out.println("Enter Seat Number:");
                                String sitnum=scan.next();
                                for(int f=0;f< MTC.size();f++) {
                                    if (sitnum.equals((MTC.get(f).seatNo))) {
                                        MTC.remove(f);
                                    }
                                }
                                flight1.cancelTicket(flight1,sitnum);
                                break;
                            }

                            case 2:{
                                System.out.println("Enter Seat Number:");
                                String sitnum=scan.next();
                                for(int f=0;f<MTD.size();f++) {
                                    if (sitnum.equals((MTD.get(f).seatNo))) {
                                        MTD.remove(f);
                                    }
                                }
                                flight2.cancelTicket(flight2,sitnum);
                                break;
                            }

                            case 3:{
                                System.out.println("Enter Seat Number:");
                                String sitnum=scan.next();
                                for(int f=0;f<MTG.size();f++) {
                                    if (sitnum.equals((MTG.get(f).seatNo))) {
                                        MTG.remove(f);
                                    }
                                }
                                flight3.cancelTicket(flight3,sitnum);
                                break;
                            }
                        }
                        System.out.println("Press 1 to Continue the cancellation........");

                        contd=scan.nextInt();
                    }while(contd==1);
                    break;

                }


                case 4 :{
                    int ans1;
                    do{
                        System.out.println("Check bookings of flight");
                        System.out.println("1.Mumbai to Chennai\n2.Mumbai to Delhi\n3.Mumbai to Goa");
                        System.out.println();
                        System.out.println("Your Choice please:");
                        int ch= scan.nextInt();
                        switch(ch) {
                            case 1: {
                                for (Flight f : MTC) {
                                    System.out.println("Departure : " + f.source);
                                    System.out.println("Destination : " + f.destination);
                                    System.out.println("Class : " + f.ticketclass);
                                    System.out.println("Passanger Name : " + f.name);
                                    System.out.println("Seat Number : " + f.seatNo);
                                    System.out.println();
                                    System.out.println();

                                }
                                break;
                            }

                            case 2: {
                                for (Flight f : MTD) {
                                    System.out.println("Departure : " + f.source);
                                    System.out.println("Destination : " + f.destination);
                                    System.out.println("Class : " + f.ticketclass);
                                    System.out.println("Passanger Name : " + f.name);
                                    System.out.println("Seat Number : " + f.seatNo);
                                    System.out.println();
                                    System.out.println();

                                }
                                break;
                            }
                            case 3: {
                                for (Flight f : MTG) {
                                    System.out.println("Departure : " + f.source);
                                    System.out.println("Destination : " + f.destination);
                                    System.out.println("Class : " + f.ticketclass);
                                    System.out.println("Passanger Name : " + f.name);
                                    System.out.println("Seat Number : " + f.seatNo);
                                    System.out.println();
                                    System.out.println();

                                }
                                break;
                            }


                        }
                        System.out.println("Do you want to continue??");
                        ans1=scan.nextInt();
                    }while(ans1==1);

                }

            }

            System.out.println("Press 1 to continue..");
            ans=scan.nextInt();
        }while(ans==1);
    }
}

/*output :


        ********************AIR INDIA********************

        1.Book a Ticket
        2.View Ticket Availability
        3.Cancel Booking
        4.Check all bookings of a flight

        Please select one..
        1
        Welcome to our online reservation System...

        Booking  is going on for these flights:

        1.Mumbai to Chennai
        2.Mumbai to Delhi
        3.Mumbai to Goa

        Enter your choice
        1
        1.Book a ticket for Business Class
        2.Book a ticket for Economic class
1
        Passenger Name :
        shreya

        Your ticket has been booked successfully for journey Mumbai to Chennai of Business class.....
        Thank You for using Online Airline Reservation System

        Your Booking Details are as follow:
        _________________________________________________________________

        *****************************************************************

        ...AIR INDIA...
			Flight : Mumbai ---> Chennai
			Name : shreya
			Seat Number :  ARS17052000
			Class : Business
			Expense : 4000
        					     HAPPY JOURNEY.......

        *****************************************************************
        _________________________________________________________________


        Do you want to book more ticket ??
        Press 1 to book another one
        1
        Welcome to our online reservation System...

        Booking  is going on for these flights:

        1.Mumbai to Chennai
        2.Mumbai to Delhi
        3.Mumbai to Goa

        Enter your choice
        2
        1.Book a ticket for Business Class
        2.Book a ticket for Economic class
2
        Passenger Name :
        aparna
        Your ticket has been booked successfully for journey Mumbai to  Delhi of Economic class.....
        Thank You for using Online Airline Reservation System

        Your Booking Details are as follow:
        _________________________________________________________________

        *****************************************************************

        ...AIR INDIA...
			Flight : Mumbai --->  Delhi
			Name : aparna
			Seat Number :  ARS17052005
			Class : Economic
			Expense : 4000 
       						     HAPPY JOURNEY.......

        *****************************************************************
        _________________________________________________________________


        Do you want to book more ticket ??
        Press 1 to book another one
        1
        Welcome to our online reservation System...

        Booking  is going on for these flights:

        1.Mumbai to Chennai
        2.Mumbai to Delhi
        3.Mumbai to Goa

        Enter your choice
        3
        1.Book a ticket for Business Class
        2.Book a ticket for Economic class
1
        Passenger Name :
        shweta

        Your ticket has been booked successfully for journey Mumbai to Goa of Business class.....
        Thank You for using Online Airline Reservation System

        Your Booking Details are as follow:
        _________________________________________________________________

        *****************************************************************

        ...AIR INDIA...
			Flight : Mumbai ---> Goa
			Name : shweta
			Seat Number :  ARS170520010
			Class : Business
			Expense : 5500
						     HAPPY JOURNEY.......

        *****************************************************************
        _________________________________________________________________


        Do you want to book more ticket ??
        Press 1 to book another one
        0
        Press 1 to continue..
        1

        ********************AIR INDIA********************

        1.Book a Ticket
        2.View Ticket Availability
        3.Cancel Booking
        4.Check all bookings of a flight

        Please select one..
        2
        Check ticket availability for flights...........
        1.Mumbai to Chennai
        2.Mumbai to Delhi
        3.Mumbai to Goa
        Enter your choice...
        1
        1.Check Business Class ticket availability
        2.Check Economic class ticket availability

        Enter your choice..
        1
        14 tickets available
        press 1 to Check available tickets for  other flights
        0
        Press 1 to continue..
        1

        ********************AIR INDIA********************

        1.Book a Ticket
        2.View Ticket Availability
        3.Cancel Booking
        4.Check all bookings of a flight

        Please select one..
        3
        Cancel Booking for

        1.Mumbai to Chennai
        2.Mumbai to Delhi
        3.Mumbai to Goa


        Please choose the flight for cancellation  :
        2
        Enter Seat Number:
        ARS17052005
        Your booking has been cancelled....
        Press 1 to Continue the cancellation........
        0
        Press 1 to continue..
        1

        ********************AIR INDIA********************

        1.Book a Ticket
        2.View Ticket Availability
        3.Cancel Booking
        4.Check all bookings of a flight

        Please select one..
        4
        Check bookings of flight
        1.Mumbai to Chennai
        2.Mumbai to Delhi
        3.Mumbai to Goa

        Your Choice please:
        1
        Departure : Mumbai
        Destination : Chennai
        Class : Business
        Passanger Name : shreya
        Seat Number : ARS17052000


        Do you want to continue??

        Attachments area*/
