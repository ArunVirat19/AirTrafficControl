class Flight {
    String Name;
    int maxWeight,timeHalt;
    Flight(String Name,int maxWeight,int timeHalt) {
        this.Name=Name;
        this.maxWeight=maxWeight;
        this.timeHalt=timeHalt;
    }
    public int computeTime(int fweight) {
        int percentage=(fweight/maxWeight)*100;
        int totalTime=0;
        if(percentage>=75) {
            totalTime=timeHalt;
        }
        else if(percentage>50 && percentage<75) {
            totalTime=timeHalt-((10/100)*timeHalt);
        }
        else {
            totalTime=timeHalt-((20/100)*timeHalt);
        }
        return totalTime+10;
    }
}