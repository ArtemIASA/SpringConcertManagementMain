package entities;



public class Ticket {
    private Visitor visitor;
    private Concert concert;
    private int price;

    public int getPrice() {
        return price;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
