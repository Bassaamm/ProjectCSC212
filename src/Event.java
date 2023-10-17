
import java.time.LocalDate;
import java.time.LocalTime;

public class Event implements Comparable<Event>{

    private String  title;
    private LocalDate date;
    private LocalTime time ;
    private String location;
    private Contact contact;

    public Event() {
        this.title = "";
        this.date = null;
        this.time =null;
        this.location = "";
        this.contact = null;
    }

    public Event(String title, LocalDate date, LocalTime time, String location , Contact contact){
        this.title=title;
        this.date=date ;
        this.time= time ;
        this.location=location;
        this.contact = contact;
    }
   public void setTitle(String title){
        this.title=title;
   }

    public void setContact(Contact contact) {
        this.contact = contact;
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
        return contact;

    }

    // The Big O of compareTo function is O(n)
    public int compareTo(Event event) {
        //x.compareto(y), = 0 (equal), <0 (x before), >0 (y before)
        return this.title.compareTo(event.title);
    }
    // The Big O of toString function is O(1)
    public String toString() {
        return  "Event title:" + title + "\n" +
                "Contact name" + date + "\n" +
                "Event date and time (MM/DD/YYYY HH:MM):" + date + " " + time + "\n" +
                "Event location: " + location + "\n";
    }
}
