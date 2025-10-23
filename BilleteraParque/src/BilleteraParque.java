public class BilleteraParque {
    private int tickets;
    private static boolean festivo = false;

    public BilleteraParque() {
        this.tickets = 0;
    }

    public BilleteraParque(int tickets) {
        this.tickets = tickets;
    }

    public int getTickets() {
        return tickets;
    }

    public static boolean getFestivo() {
        return festivo;
    }

    public void setTickets(int tickets) {
        if (tickets >= 0) {
            this.tickets = tickets;    
        }
        
    }

    public static void setFEstivo() {
        festivo = !festivo;
    }

    public void agregarTickets(int tickets) {
       if (tickets >= 0) {
        
       this.tickets += tickets; }
    }

    public boolean removerTickets(int entradaTickets) {
        if (entradaTickets >= 0 && this.tickets >= entradaTickets) {
            this.tickets -= entradaTickets;
            return true;
        } else {
            return false;
        } }
    }



