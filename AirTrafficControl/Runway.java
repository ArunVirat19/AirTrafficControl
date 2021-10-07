class Runway extends Thread{
    String name;
    boolean status;
    int time;
    Runway(String name,int time,boolean status) {
        this.name=name;
        this.time=time;
        this.status=status;
    }
    public boolean status() {
        return status;
    }
}