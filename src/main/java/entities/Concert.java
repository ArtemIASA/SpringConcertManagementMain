package entities;

import java.util.Date;


public class Concert {
    private String name;
    private String type;
    private Arena arena;
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public Date getDate() {
        return date;
    }
}
