package DanielaAbellan_Examen;

import java.io.*;
import java.util.Scanner;

public class FicheroReparacion {
    private static Scanner sc = new Scanner(System.in);
    private static Taller miTaller;

    public FicheroReparacion( Taller taller) {
        this.miTaller = taller;
    }

    public void guardarOrdenes() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("repara.txt"));
        for (OrdenReparacion ordenReparacion: miTaller.misOrdenesReparacion){
            for (Vehiculo vehiculo : miTaller.misVehiculos){
                if (vehiculo instanceof Industrial){
                    bw.write("INDUSTRIAL," + ordenReparacion.getVehiculo() + "," + ordenReparacion.getHorasEstimadas() + "," + ordenReparacion.getCosteTotal() + "," + ((Industrial) vehiculo).getCapacidadToneladas());
                    bw.newLine();
                }else if(vehiculo instanceof Turismo){
                    bw.write("TURISMO," + ordenReparacion.getVehiculo() + "," + ordenReparacion.getHorasEstimadas() + "," + ordenReparacion.getCosteTotal() + "," + ((Turismo) vehiculo).getPuertas());
                    bw.newLine();
                }
            }

        }
        bw.close();
    }

    public void cargarOrdenes() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("repara.txt"));
        String linea;
        while  ((linea = br.readLine()) != null){
            String[] datos = linea.split(",");
            boolean enReparacion =datos[4].equals("true");

            if (datos[2].equalsIgnoreCase("INDUSTRIAL")){
                OrdenReparacion industrial= new OrdenReparacion(new Cliente(datos[1], datos[2]), (new Industrial(datos[1],datos[2],Double.parseDouble(datos[3]),enReparacion,Double.parseDouble(datos[5]))), Integer.parseInt(datos[3]));
                miTaller.misOrdenesReparacion.add(industrial);
            }else if (datos[2].equalsIgnoreCase("TURISMO")){
                OrdenReparacion turismo= new OrdenReparacion(new Cliente(datos[1], datos[2]), (new Turismo(datos[1],datos[2],Double.parseDouble(datos[3]),enReparacion,Integer.parseInt(datos[5]))), Integer.parseInt(datos[3]));
                miTaller.misOrdenesReparacion.add(turismo);
            }
        }
        br.close();
    }
}
