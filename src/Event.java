import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
public class Event implements Comparable<Event>{

    private String  title;
    private LocalDate date;
    private LocalTime time ;
    private String location;
    private Contact contect;

    public Event() {
        this.title = "";
        this.date = null;
        this.time =null;
        this.location = "";
        this.contect = null;
    }

    public Event(String title, LocalDate date, LocalTime time, String location , Contact contact){
        this.title=title;
        this.date=date ;
        this.time= time ;
        this.location=location;
        this.contect = contact;
    }
   public void setTitle(String title){
        this.title=title;
   }
    public void setContect(Contact contect) {
        this.contect = contect;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setTime(LocalTime time) {
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

    public LocalTime getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }
    public Contact getContect() {
        return contect;
    }
  public int compareTo(Event event) {
        //x.compareto(y), = 0 (equal), <0 (x before), >0 (y before)
        return this.title.compareTo(event.title);
    }
    @Override
    public String toString() {
        return "Even {" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
