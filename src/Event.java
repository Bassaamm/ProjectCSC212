public class Event {
  private String  title;
    private int data;
    private int time ;
    private String location;
   

    public Event(String title, int date, int time,String location){
        this.title=title;
        this.data=date;
        this.time=time;
        this.location=location;
        
    }



   public void setTitle(String title){
        this.title=title;
   }

    public void setData(int data) {
        this.data = data;
    }

    public void setTime(int time) {
        this.time = time;
    }


    public void setLocation(String location) {
        this.location = location;
    }
    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public int getTime() {
        return time;
    }

    public int getData() {
        return data;
    }
}
