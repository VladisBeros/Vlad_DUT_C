import java.util.ArrayList;
import java.util.List;

abstract class Item {
    private String title;
    private String uniqueID;
    private boolean isBorrowed;

    public Item(String title, String uniqueID) {
        this.title = title;
        this.uniqueID = uniqueID;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowItem() {
        isBorrowed = true;
    }

    public void returnItem() {
        isBorrowed = false;
    }

    @Override
    public String toString() {
        return "Назва: " + title + "\nУнікальний ID: " + uniqueID + "\nПозичено: " + isBorrowed;
    }
}

class Book extends Item {
    private String author;

    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

class DVD extends Item {
    private int duration;

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}

// --------------------ЧИТАЧ--------------------
class Patron {
    private String name;
    private String ID;
    private List<Item> borrowedItems;

    public Patron(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public List<Item> getBorrowedItems() {
        return borrowedItems;
    }

    public void borrow(Item item) {
        if (!item.isBorrowed()) {
            borrowedItems.add(item);
            item.borrowItem();
        }
    }

    public void returnItem(Item item) {
        if (borrowedItems.contains(item)) {
            borrowedItems.remove(item);
            item.returnItem();
        }
    }
}

interface IManageable {
    void add(Item item);
    void remove(Item item);
    void listAvailable();
    void listBorrowed();
}

// --------------------КЛАС Library РЕАЛІЗУЄ ІНТЕРФЕЙС IManageable--------------------
class Library implements IManageable {
    protected List<Item> items;
    private List<Patron> patrons;

    public Library() {
        this.items = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        if (patrons.contains(patron)) {
            patron.borrow(item);
        }
    }

    public void returnItem(Patron patron, Item item) {
        if (patrons.contains(patron)) {
            patron.returnItem(item);
        }
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public void listAvailable() {
        System.out.println("Доступні предмети:");
        for (Item item : items) {
            if (!item.isBorrowed()) {
                System.out.println(item);
                System.out.println("--------------------");
            }
        }
    }

    @Override
    public void listBorrowed() {
        System.out.println("Позичені предмети:");
        for (Patron patron : patrons) {
            List<Item> borrowedItems = patron.getBorrowedItems();
            if (!borrowedItems.isEmpty()) {
                System.out.println("Читач: " + patron.getName());
                for (Item item : borrowedItems) {
                    System.out.println(item);
                    System.out.println("--------------------");
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // --------------------ДОДАВАННЯ КНИГ ТА DVD ДО БІБЛІОТЕКИ--------------------
        library.add(new Book("Предмет 1", "123", "Автор 1"));
        library.add(new DVD("DVD 1", "456", 120));
        library.add(new Book("Предмет 2", "789", "Автор 2"));

        // --------------------РЕЄСТРАЦІЯ ЧИТАЧІВ--------------------
        Patron patron1 = new Patron("Читач 1", "P001");
        Patron patron2 = new Patron("Читач 2", "P002");
        library.registerPatron(patron1);
        library.registerPatron(patron2);

        // --------------------ВИДАЧА ПРЕДМЕТІВ ЧИТАЧАМ--------------------
        library.lendItem(patron1, library.items.get(0));
        library.lendItem(patron2, library.items.get(1));

        // --------------------ПОВЕРНЕННЯ ПРЕДМЕТІВ ДО БІБЛІОТЕКИ--------------------
        library.returnItem(patron1, library.items.get(0));
        library.returnItem(patron2, library.items.get(1));

        // --------------------ВИДИ СПИСКУ ДОСТУПНИХ ТА ВЗЯТИХ ПРЕДМЕТІВ--------------------
        library.listAvailable();
        library.listBorrowed();
    }
}


/*
 * Спочатку треба було створити клас Item, який буде містити параметри предметів, який містить в собі конструктор та методи повернення параметрів та стану заборгованності, та змінений toString.
 * Далі, був створений клас Book та DVD, які наслідуються від Item, мають свої конструктори та створюють приватні поля author та duration, які також мають повертаючі методи.
 * Далі йде клас Читача (Person), який має поля ім'я, ID, та список заборгованності, а також конструктор. Також є вилучення name, перевірка на заборгованніть, вилучення самої заборгованності.
 * Створено інтерфейс для управління предметами та читачами, а клас Library, реалізує його.
 * Сам клас Library відповідає за управління бібліотекою, її реєстрацію читачів, видачу та повернення книг та DVD, а також ведення списку доступних та взятих предметів.
 * Метод add(Item item) дозволяє додавати нові предмети до колекції предметів бібліотеки.
 * Метод lendItem(Patron patron, Item item) дозволяє видавати предмети читачам. listAvailable() виводить список доступних для позичення предметів. listBorrowed() виводить список взятих на читачів предметів разом з інформацією про читачів.
 * returnItem(Patron patron, Item item) дозволяє читачам повертати позичені предмети назад до бібліотеки.
 * public class Main є вхідною точкою програми, а також щоб демонструвати функціональність бібліотеки, створеної на основі класів Item, Book, DVD, Patron, та Library.
 */