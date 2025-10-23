public class Premio {
    private String nombre;
    private int costoTickets;

    public Premio(String nombre, int costoTickets) {
        this.nombre = nombre;
        this.costoTickets = costoTickets;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCostoTickets() {
        return costoTickets;
    }

    public int getCostoFinal(boolean festivo) {
        return festivo ? costoTickets / 2 : costoTickets;
    }

    @Override
    public String toString() {
        return nombre + " (" + costoTickets + " tickets)";
}
}