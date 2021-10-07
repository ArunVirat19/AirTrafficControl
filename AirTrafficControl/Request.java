class Request extends Thread{
    String aname,type;
    Runway rw;
    int compTime,weightA;
    Request(String aname,int weightA,String cho,int compTime,Runway rw) {
        this.aname=aname;
        this.weightA=weightA;
        this.type=cho;
        this.compTime=compTime;
        this.rw=rw;
    }
    public void setRunway(Runway rw) {
        this.rw=rw;
    }
    public void run() {
        rw.status=false;
        try {
            System.out.println("---------------------------------------------------------------------------------");
				System.out.println(type+" approved for "+aname+" with "+weightA+" tons of weight in "+rw.name);
				System.out.println("Touch down will happen in 15 sec");
				System.out.println("the plane will stop after "+compTime+" sec of touch down");
				System.out.println(rw.name+" will be ready for next request in "+compTime+" sec");
				System.out.println("---------------------------------------------------------------------------------");
                Thread.sleep(1000*compTime);
                rw.status=true;
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}