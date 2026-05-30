
public class AnimalPark {

    // ===== Animal ЭЦЭГ КЛАСС =====
    static class Animal {

        String name;
        int age;
        double weight;
        boolean isHealthy;

        Animal(String name, int age, double weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.isHealthy = true;
        }

        void eat(String food) {
            System.out.println(name + " " + food + " идэж байна.");
        }

        void sleep() {
            System.out.println(name + " унтаж байна. 💤");
        }

        void sound() {
            System.out.println(name + ": ...");
        }

        void checkup() {
            System.out.println(name + "-ийн эрүүл мэнд: "
                    + (isHealthy ? "Эрүүл" : "Анхааруулга!"));
        }

        String getType() {
            return "Амьтан";
        }

        void showProfile() {
            System.out.println("---------------------");
            System.out.println("Нэр    : " + name);
            System.out.println("Төрөл  : " + getType());
            System.out.println("Нас    : " + age + " жил");
            System.out.printf("Жин    : %.1f кг%n", weight);
            System.out.println("Эрүүл  : " + (isHealthy ? "Тийм" : "Үгүй"));
        }
    }

    // ===== Lion =====
    static class Lion extends Animal {

        double maneLength;

        Lion(String name, int age, double weight, double maneLength) {
            super(name, age, weight);
            this.maneLength = maneLength;
        }

        @Override
        void sound() {
            System.out.println(name + ": Аарр!! 🦁");
        }

        @Override
        String getType() {
            return "Арслан";
        }

        void hunt() {
            System.out.println(name + " ан хийж байна.");
        }

        @Override
        void showProfile() {
            super.showProfile();
            System.out.printf("Дэл    : %.1f см%n", maneLength);
        }
    }

    // ===== Elephant =====
    static class Elephant extends Animal {

        double trunkLength;

        Elephant(String name, int age, double weight, double trunkLength) {
            super(name, age, weight);
            this.trunkLength = trunkLength;
        }

        @Override
        void sound() {
            System.out.println(name + ": Пүүү! 🐘");
        }

        @Override
        String getType() {
            return "Заан";
        }

        void spray() {
            System.out.println(name + " хошуугаараа ус цацаж байна.");
        }

        @Override
        void showProfile() {
            super.showProfile();
            System.out.printf("Хошуу  : %.1f см%n", trunkLength);
        }
    }

    // ===== Penguin =====
    static class Penguin extends Animal {

        boolean canFly = false;

        Penguin(String name, int age, double weight) {
            super(name, age, weight);
        }

        @Override
        void sound() {
            System.out.println(name + ": Хааа хааа! 🐧");
        }

        @Override
        String getType() {
            return "Пингвин";
        }

        void swim() {
            System.out.println(name + " усанд сэлж байна.");
        }
    }

    // ===== Giraffe =====
    static class Giraffe extends Animal {

        double neckLength;

        Giraffe(String name, int age, double weight, double neckLength) {
            super(name, age, weight);
            this.neckLength = neckLength;
        }

        @Override
        void sound() {
            System.out.println(name + " чимээгүй байна.");
        }

        @Override
        String getType() {
            return "Гирафф";
        }

        void eatLeaves() {
            System.out.println(name + " өндөр модны навч идэж байна. 🍃");
        }

        @Override
        void showProfile() {
            super.showProfile();
            System.out.printf("Хүзүү  : %.1f м%n", neckLength);
        }
    }

    // ===== НЭМЭЛТ ДААЛГАВАР: Keeper (Асрагч) КЛАСС =====
    static class Keeper {

        String name;
        Animal[] assigned;

        Keeper(String name, Animal[] assigned) {
            this.name = name;
            this.assigned = assigned;
        }

        void feedAssigned(String food) {
            System.out.println("\n=== Асрагч " + name + " хариуцсан амьтдаа хооллож байна: " + food + " ===");
            for (Animal a : assigned) {
                a.eat(food);
            }
        }

        void checkAllHealth() {
            System.out.println("\n=== Асрагч " + name + " амьтдын эрүүл мэндийг шалгаж байна ===");
            for (Animal a : assigned) {
                a.checkup();
            }
        }
    }

    // ===== AnimalPark Туслах Методууд =====
    static void feedAll(Animal[] animals, String food) {
        System.out.println("\n=== Бүх амьтдыг хооллож байна: " + food + " ===");
        for (Animal a : animals) {
            a.eat(food);
        }
    }

    static void morningRoutine(Animal[] animals) {
        System.out.println("\n=== Өглөөний дэглэм ===");
        for (Animal a : animals) {
            a.sound();
            a.checkup();
        }
    }

    static Animal heaviest(Animal[] animals) {
        Animal best = animals[0];
        for (Animal a : animals) {
            if (a.weight > best.weight) {
                best = a;
            }
        }
        return best;
    }

    static int countByType(Animal[] animals, String type) {
        int count = 0;
        for (Animal a : animals) {
            if (a.getType().equals(type)) {
                count++;
            }
        }
        return count;
    }

    static void showAllProfiles(Animal[] animals) {
        System.out.println("\n===== АМЬТНЫ ЦЭЦЭРЛЭГИЙН БҮРТГЭЛ =====");
        for (Animal a : animals) {
            a.showProfile();
        }
        System.out.println("=====================================");
    }

    // ===== MAIN =====
    public static void main(String[] args) {
        Animal[] park = {
            new Lion("Симба", 5, 180, 25),
            new Lion("Муфаса", 8, 210, 30),
            new Elephant("Думбо", 12, 4500, 180),
            new Penguin("Коваальски", 3, 4.5),
            new Penguin("Рико", 4, 5.2),
            new Giraffe("Джери", 7, 900, 1.8)
        };

        // Үндсэн кодын үйлдлүүд
        showAllProfiles(park);
        morningRoutine(park);
        feedAll(park, "мах");

        Animal big = heaviest(park);
        System.out.println("\nХамгийн хүнд: " + big.name + " (" + big.weight + " кг)");

        System.out.println("Арсланы тоо: " + countByType(park, "Арслан"));
        System.out.println("Пингвины тоо: " + countByType(park, "Пингвин"));

        // Polymorphism
        System.out.println("\n=== Дуу гаргах ===");
        for (Animal a : park) {
            a.sound();
        }

        // Тусгай үйлдлүүд
        System.out.println("\n=== Тусгай үйлдлүүд ===");
        for (Animal a : park) {
            if (a instanceof Lion l) {
                l.hunt();
            }
            if (a instanceof Elephant e) {
                e.spray();
            }
            if (a instanceof Penguin p) {
                p.swim();
            }
            if (a instanceof Giraffe g) {
                g.eatLeaves();
            }
        }

        // Нэмэлт даалгаврын хэсэг (Асрагч нарыг ажиллуулах)
        System.out.println("\n=====================================");
        System.out.println("    АСРАГЧДЫН АЖИЛ ЭХЭЛЛЭЭ");
        System.out.println("=====================================");

        Animal[] battsAnimals = {park[0], park[1], park[3], park[4]};
        Keeper bat = new Keeper("Бат", battsAnimals);

        Animal[] boldooAnimals = {park[2], park[5]};
        Keeper boldoo = new Keeper("Болдоо", boldooAnimals);

        bat.feedAssigned("мах ба загас");
        bat.checkAllHealth();

        boldoo.feedAssigned("шинэхэн өвс, навч");
        boldoo.checkAllHealth();
    }
}
