public class Wizard extends Human {
    // this.strength = 3;
	// this.stealth = 3;
	public Wizard() {
        this.intelligence = 8;
        this.health = 50;
    }

    public void heals(Human h) {
        h.health += this.intelligence;
    }

    public void fireball(Human h) {
        h.health -= 3 * this.intelligence;
    }
}
