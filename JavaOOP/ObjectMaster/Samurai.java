public class Samurai extends Human {
    
    static int numOfSamurai = 0;

    public Samurai() {
        numOfSamurai += 1;
        this.health = 200;
    }

    public void deathBlow(Human h) {
        h.health = 0;
        this.health *= 0.5;
    }

    public void mediate() {
        this.health = 200;
    }

    public static int howMany() {
        return numOfSamurai;
    }
}