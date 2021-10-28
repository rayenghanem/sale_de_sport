package entities;

public class Reclamation {

	private int id;
   private String username;
    private String object;
    private String description;

    public Reclamation(int id, String username, String object, String description){
        this.id = id;
    	this.username=username;
        this.object = object;
        this.description=description;
       
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getObject() {
        return object;
    }

    public String getDescription() {
        return description;
    }

}