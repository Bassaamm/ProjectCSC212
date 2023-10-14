import java.util.Date;

public class Event implements Comparable<Event>{
  private String  title;
    private Date data;
    private int time ;
    private String location;
   

    public Event(String title, String date, String time, String location){
        this.title=title;
        this.data=date;
        this.time=time;
        this.location=location;
        
    }



   public void setTitle(String title){
        this.title=title;
   }

    public void setData(Date data) {
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

    public Date getData() {
        return data;
    }
  public int compareTo(Event event) {
        //x.compareto(y), = 0 (equal), <0 (x before), >0 (y before)
        return this.title.compareTo(event.title);
    }

}
