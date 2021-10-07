import java.util.*;
public class airTrafficControl extends Thread{
    String fname,cho;
    int fweight,compTime,choice;
    ArrayList<Flight> flights=new ArrayList<>();
    ArrayList<Runway> runways=new ArrayList<>();
    airTrafficControl() {
        flights.add(new Flight("atr",12,30));
        flights.add(new Flight("airbus",20,40));
        flights.add(new Flight("boeing",40,50));
        flights.add(new Flight("cargo",100,60));
        runways.add(new Runway("runway one",40,true));
        runways.add(new Runway("runway two",60,true));
        runways.add(new Runway("runway three",80,true));
        runways.add(new Runway("runway four",90,true));
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int ans=1;
        airTrafficControl atc=new airTrafficControl();
        while(ans==1) {
            atc.getChoice();
            System.out.println("Do you want to continue? (yes-1/no-0)");
            ans=s.nextInt();
        }
        s.close();
    }
    Scanner sc=new Scanner(System.in);
    public void getChoice() {
        System.out.println("1.Take off");
        System.out.println("2.Landing");
        System.out.println("3.Emergency Landing");
        System.out.println("4.Show runways");
        System.out.println("5.Exit");
        System.out.println("Enter your choice :");
        choice=sc.nextInt();
        switch(choice) {
            case 1: {
                sc.nextLine();
                getDetails(choice);
                for(Flight f:flights) {
                    if(f.Name.equalsIgnoreCase(fname)) {
                        compTime=f.computeTime(fweight);
                        runwayAssign();
                    }
                }
                break;
            }
            case 2: {
                sc.nextLine();
                getDetails(choice);
                for(Flight f:flights) {
                    if(f.Name.equalsIgnoreCase(fname)) {
                        compTime=f.computeTime(fweight);
                        runwayAssign();
                    }
                }
                break;
            }
            case 3: {
                sc.nextLine();
                getDetails(choice);
                for(Flight f:flights) {
                    if(f.Name.equalsIgnoreCase(fname)) {
                        compTime=f.computeTime(fweight);
                        runwayAssign();
                    }
                }
                break;
            }
            case 4: {
                for(Runway rw:runways) {
                    if(rw.status())
                        System.out.println(rw.name+" is free");
                    else 
                        System.out.println(rw.name+" is busy");
                }
                break;
            }
            case 5:
                return;
        }
    }
    public void getDetails(int choice) {
        System.out.println("Enter name of the flight");
        fname=sc.nextLine();
        System.out.println("Enter weight of the flight(int tons)");
        fweight=sc.nextInt();
        if(choice==1) cho="Take off";
        else if(choice==2) cho="Landing";
        else cho="Emergency Landing";
    }
    public void runwayAssign() {
        int all=0;
        for(int i=0;i<runways.size();i++) {
            if(compTime<=runways.get(i).time && runways.get(i).status()) {
                all=1;
                Request r=new Request(fname,fweight,cho,compTime,runways.get(i));
                r.start();
                try {
                    Thread.sleep(1000);
                }
                catch(Exception e) {}
                break;
            }
        }
        if(all==0) {
            System.out.println("You have to wait");
        } 
    }
}