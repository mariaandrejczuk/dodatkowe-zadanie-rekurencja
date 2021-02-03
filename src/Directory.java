
public class Directory {

    private String name;             //katalog ma nazwę
    private File[] files;            // drzewo zawiera pliki - inna klasa - trzeba utworzyć nową klasę w oddzielnym pliku
    private Directory[] directories; //klasa Directory uzywa Directory, czyli drzewo ma katalogi, które moga mieć w sobie inne katalogi


    public Directory(String name, File[] files, Directory[] directories) {  //ustawianie wartości przez konstruktor
        this.name = name;
        this.files = files;
        this.directories = directories;
    }

    public String getName() {  //można odczytywac wartosci przez gettery; settery nie są potrzebne, bo tylko raz ustawimy nasze drzewo
        return name;
    }

    public File[] getFiles() {
        return files;
    }

    public Directory[] getDirectories() {
        return directories;
    }
}