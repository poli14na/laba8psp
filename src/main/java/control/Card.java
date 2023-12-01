package control;

public class Card {
    private int card_id;
    private String firstname;
    private String lastname;
    private String born_date;
    private String num_visit;
    private String discount;

    public Card() {
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBorn_date() {
        return born_date;
    }

    public void setBorn_date(String born_date) {
        this.born_date = born_date;
    }

    public String getNum_visit() {
        return num_visit;
    }

    public void setNum_visit(String num_visit) {
        this.num_visit = num_visit;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
