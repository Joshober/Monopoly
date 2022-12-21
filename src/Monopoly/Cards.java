//Class to create cards for the game such as properties or chanceandcommunity cards
package Monopoly;





class Cards{
    private String name;
    private String text;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private  int price;
    public Players getOwner() {
        return owner;
    }

    public void setOwner(Players owner) {
        this.owner = owner;
    }

    private Players owner;

    Cards(String name, String text){
        this.name = name;
        this.text = text;
    }

    public Cards(String name,int price) {
        this.name = name;
        this.price = price;
    }
    public Cards(String name) {
        this.name = name;
    }
    //Probably need a picture later

protected String getName(){//Takes information from the cards.txt file and stores them into an object

    return this.name;
}

    public void setName(String name) {//Getters and setters for object information
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText(){

        return this.text;
    }


}








