import java.util.Date;
import java.time.format.DateTimeFormatter;
public class Event implements Comparable<Event>{
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private String  title;
    private Date date;
    private String time ;
    private String location;
   

    public Event(String title, Date date, String location){
        this.title=title;
        this.date= new Date();
        this.time=time;
        this.location=location;
        
    }



   public void setTitle(String title){
        this.title=title;
   }

    public void setData(Date data) {
        this.date = data;
    }

    public void setTime(String time) {
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

    public String getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }
  public int compareTo(Event event) {
        //x.compareto(y), = 0 (equal), <0 (x before), >0 (y before)
        return this.title.compareTo(event.title);
    }

}
