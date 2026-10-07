import java.util.Scanner;

abstract class EnergySource {
    String id, name;
    double energy; 
    EnergySource(String id, String name, double energy) {
        this.id = id;
        this.name = name;
        this.energy = energy;
    }

    abstract double calculateEfficiency();

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Energy: " + energy + " kWh");
        System.out.println("Efficiency: " + calculateEfficiency() + "%");
    }
}

class SolarEnergy extends EnergySource {
    SolarEnergy(String id, String name, double energy) {
        super(id, name, energy);
    }

    double calculateEfficiency() {
        return (energy / 5000) * 100;
    }
}

class WindEnergy extends EnergySource {
    WindEnergy(String id, String name, double energy) {
        super(id, name, energy);
    }

    double calculateEfficiency() {
        return (energy / 8000) * 100;
    }
}

public class SimpleDem {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
        EnergySource ref; 
        
        System.out.println("Select Source Type (1 for Solar, 2 for Wind): ");
        int choice = input.nextInt();
        input.nextLine(); 
        
        System.out.print("Enter ID: ");
        String id = input.nextLine();

        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Enter Energy Generated (kWh): ");
        double energy = input.nextDouble();

        
        if (choice == 1) {
            ref = new SolarEnergy(id, name, energy);
        } else {
            ref = new WindEnergy(id, name, energy);
        }

        ref.display();

        input.close();        
        
         
        }
}
