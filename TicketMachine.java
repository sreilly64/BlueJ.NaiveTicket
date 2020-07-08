/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private Integer price;
    // The amount of money entered by a customer so far.
    private Integer balance;
    // The total amount of money collected by this machine.
    private Integer total;
    // The number of tickets printed.
    private Integer ticketNumber;
    //Exercise 2.15
    private Integer status;

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    public TicketMachine() //Exercise 2.39 removed price parameter
    {
        price = 1000;
        balance = 0;
        total = 0;
        ticketNumber = 0;
    }
    
    //Exercise 2.42
    public TicketMachine(Integer ticketPrice){
        price = ticketPrice;
        balance = 0;
        total = 0;
        ticketNumber = 0;
    }

    /**
     * Return the price of a ticket.
     */
    public Integer getPrice()
    {
        return price;
    }
    
    /**
     * Return ticketNumber.
     * (Increments on each print.)
     */
    public Integer getTicketNumber()
    {
        return ticketNumber;
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public Integer getBalance()
    {
        return balance;
    }
    
    //Exercise 2.24
    public Integer getTotal(){
        return total;
    }

    /**
     * Receive an amount of money in cents from a customer.
     */
    public Integer insertMoney(Integer amount)
    {
        balance = balance + amount;
        return balance;
    }
    
    public Integer calculateTotal(){
        total = balance + total;
        return total;
    }
    
    public Integer incrementTicketNumber(){
        ticketNumber++;
        return ticketNumber;
    }
    
    //Exercise 2.30 and 2.41
    public void setPrice(Integer ticketCost){ //mutator method
        price = ticketCost;
    }
    
    //Exercise 2.32
    public void discount (Integer amount){
        price = price - amount;
        if(price < 0){
            price = 0;
        }
    }

    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public String printTicket()
    {
        //Increment the number of tickets printed
        incrementTicketNumber();
        // Update the total collected with the balance.
        total = total + balance;
        // Clear the balance.
        balance = 0;
        
        return "Ticket price: " + price + " cents. " + "Your total is " + total + ".";
    }
    
    //Exercise 2.33
    public void prompt(){
        System.out.println("Please insert the correct amount of money");
    }
    
    //Exercise 2.34
    public void showPrice(){
        System.out.println("The price of a ticket is " + price + " cents.");
    }
    
    //Exercise 2.40
    public void empty(){ //mutator method
        total = 0;
    }
}
