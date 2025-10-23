import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BilleteraParque billetera = new BilleteraParque(100);

        Premio[] premios = {
            new Premio("Camiseta",150),
            new Premio("Sombrero",350),
            new Premio("Tenis",600)
        };

        int opcion;
        do {
            System.out.println("\n== Administrador de Billeteras para parques temáticos ==");
            System.out.println("1. Agregar tickets");
            System.out.println("2. Establecer tickets");
            System.out.println("3. Comprar premio");
            System.out.println("4. Establecer festivo");
            System.out.println("5. Salir");
            System.out.println("\nTu billetera tiene: " + billetera.getTickets() + " boletos");
            System.out.print("ingrese la opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.println("\n¿Cuántos boletos desea agregar? ");
                    int agregar = sc.nextInt();
                    billetera.agregarTickets(agregar);
                    break;
                }
                case 2: {
                    System.out.println("\nEstablecer saldo de tickets en: ");
                    int nuevoSaldo = sc.nextInt();
                    billetera.setTickets(nuevoSaldo); 
                    break;
                }
                case 3: {
                    comprarPremio(billetera, premios, sc);
                    break;
                }
                case 4: {
                    BilleteraParque.setFEstivo();
                    System.out.println(BilleteraParque.getFestivo() ? "\nAhora es un dia Festivo." : "\nYa no es un dia festivo.");
                    break;
                }
                case 5: {
                    System.out.println("\nSaliendo del programa...");
                    break;
                }
                default: {
                    System.out.println("\nOpción no válida.");
                    break;
                }
            }
        } while (opcion != 5);
            sc.close(); 
        
        

    }
    public static void comprarPremio(BilleteraParque billetera, Premio[] premios, Scanner sc) {
            boolean festivo = BilleteraParque.getFestivo();
            if (festivo) {
                System.out.println("\n¡Precios de vacaciones!");
            }
                System.out.println();
                for (int i = 0; i < premios.length; i++) {
                    Premio p = premios[i];
                    System.out.println((i + 1) + ". " + p.getNombre() + " (" + p.getCostoFinal(festivo) + " tickets)");
                } 

                System.out.println("¿qué premio desea comprar? ");
                int eleccion = sc.nextInt() - 1;
                if (eleccion < 0 || eleccion >= premios.length) {
                    System.out.println("\nOpción no válida.");
                    return;
                }

                Premio premioSeleccionado = premios[eleccion];
                int costo = premioSeleccionado.getCostoFinal(festivo);
    
                if (billetera.removerTickets(costo)) {
                    System.out.println("\nCompró un(a) " + premioSeleccionado.getNombre() + " por " + costo + " tickets.");
    
                } else { 
                    System.out.println("\nNo hay suficientes boletos para comprar un(a) " + premioSeleccionado.getNombre() + ".");
    
                }
    }
}

