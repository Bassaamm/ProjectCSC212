public class Event {
  private String  title;
    private int data;
    private int time ;
    private String location;
    private Contact contact[];
    private int nContact;

    public Event(String title, int date, int time,String location,int size){
        this.title=title;
        this.data=date;
        this.time=time;
        this.location=location;
        contact= new Contact[size];
        nContact=0;
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
