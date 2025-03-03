abstract class Spell {
    protected String name;
    protected int intensity;
    protected String kind;

    public Spell(String name, int intensity, String kind) {
        this.name = name;
        this.intensity = intensity;
        this.kind = kind;
    }

    public abstract boolean beats(Spell other);

    public int getIntensity() {
        return intensity;
    }
}

class Water extends Spell {
    public Water(String name, int intensity) {
        super(name, intensity, "water");
    }

    @Override
    public boolean beats(Spell other) {
        return other.kind.equals("fire") || this.intensity > other.intensity;
    }
}

class Fire extends Spell {
    public Fire(String name, int intensity) {
        super(name, intensity, "fire");
    }

    @Override
    public boolean beats(Spell other) {
        return this.intensity > other.intensity;
    }
}

class Earth extends Spell {
    public Earth(String name, int intensity) {
        super(name, intensity, "earth");
    }

    @Override
    public boolean beats(Spell other) {
        return this.intensity > other.intensity;
    }
}

public class SpellBattle {
    public static int castSpells(Spell spell1, Spell spell2) {
        if (spell1.beats(spell2)) {
            return 1;
        } else if (spell2.beats(spell1)) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Spell splash = new Water("splash", 50);
        Spell fireball = new Fire("fireball", 100);
        Spell ignite = new Fire("ignite", 15);
        Spell terraform = new Earth("terraform", 20);

        System.out.println(castSpells(splash, fireball));  // 1 (Water beats Fire)
        System.out.println(castSpells(fireball, ignite));  // 1 (Fireball is stronger)
        System.out.println(castSpells(ignite, terraform)); // -1 (Earth wins)
        System.out.println(castSpells(terraform, splash)); // -1 (Water wins by intensity)
    }
}
