package flight;

class Passenger {
    String name;
    Passenger next;

    public Passenger(String name) {
        this.name = name;
        this.next = null;
    }
}

public class Flight {
    private Passenger head;

    public Flight() {
        this.head = null;
    }

    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);

        if (head == null) {
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger;
        }
    }

    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            System.out.println(name + " telah dihapus dari daftar.");
            return;
        }

        Passenger current = head;
        Passenger previous = null;

        while (current != null && !current.name.equals(name)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
            System.out.println(name + " telah dihapus dari daftar.");
        } else {
            System.out.println(name + " tidak ditemukan dalam daftar.");
        }
    }

    public void displayPassengers() {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        Passenger current = head;
        System.out.println("Daftar Penumpang:");
        while (current != null) {
            System.out.println(current.name);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Flight flight = new Flight();

        flight.addPassenger("Isan");
        flight.addPassenger("Surya");
        flight.addPassenger("Ari");

        flight.displayPassengers();

        flight.removePassenger("Ari");

        flight.displayPassengers();
    }
}


