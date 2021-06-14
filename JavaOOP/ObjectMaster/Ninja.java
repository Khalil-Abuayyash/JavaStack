public class Ninja extends Human {
    
    public Ninja {
        this.stealth = 10;
    }

    public void steal(Human h) {
        h.health -= this.stealth;
    }

    public void runaway() {
        this.health -= 10;
    }
}