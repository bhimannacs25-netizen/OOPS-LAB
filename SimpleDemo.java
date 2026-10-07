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

public class SimpleDemo {
    public static void main(String[] args) {
        EnergySource ref; 
        
        
        ref = new SolarEnergy("S101", "Solar Panel", 4000);
        ref.display();

        System.out.println();
        

        ref = new WindEnergy("W202", "Wind Turbine", 4000);
        ref.display();
    }
}
