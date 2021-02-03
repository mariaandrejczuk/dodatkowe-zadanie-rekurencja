
public class DirectoriesTree {

    private Directory root; // = d1, został wyodrębniony, bo chcemy go używać w innej metodzie, nie muszę definiowac pozostałych katalogów i plików jako pola, bo d1 ma referencje do nich, i po nich się dostanę do kolejnych poziomów drzewa


    public DirectoriesTree() {  //konstruktor, który tworzy całą strukturę drzewa; aby mieć dostęp do drzewa w metodzie n. displayAllFiles, to po piewrsze musze zacząc wyświetlanie od d1, a po drugie nie mam do niego dostęu(jeżeli cały d1 jest schowany w kontruktorze), więc d1 trzeba utworzyc jako pole, nad konstruktorem, żeby mieć dostęp do d1.

        File f00 = new File("f00");
        File f28 = new File("f28");
        File[] d8Files = {f00, f28};
        Directory d8 = new Directory("d8", d8Files, null);

        Directory d7 = new Directory("d7", null, null);

        File f54 = new File("f54");
        File[] d6Files = {f54};
        Directory[] d6Directories = {d8};
        Directory d6 = new Directory("d6", d6Files, d6Directories);

        File f20 = new File("f20");
        File f21 = new File("f21");
        File[] d5Files = {f20, f21};
        Directory d5 = new Directory("d5", d5Files, null);

        Directory[] d4Directories = {d7};  //zanim przypiszemy d4, musimy stworzyć tablicę katalogów należących do katalogu d4 (w tym przypadku bedzie to jeden katalog o nazwie d7; dlatego zaczęliśmy od końca, żey móc przypisywać).
        Directory d4 = new Directory("d4", null, d4Directories); //przypisanie tablicy d4Directory, która zawiera w sobie info o kolejnym zawartym w sobie katalogu

        Directory d3 = new Directory("d3", null, null);

        File f10 = new File("f10");
        File[] d2Files = {f10};
        Directory[] d2Directories = {d5, d6};
        Directory d2 = new Directory("d2", d2Files, d2Directories); //d2 ma w sobie plik f10, więc trzeba stworzyć tablicę plików, oraz ma dwa podkatalogi d5 i d6, więc stworzymy tablicę folderów.

        File f1 = new File("f1");
        File f2 = new File("f2");
        File f3 = new File("f3");
        File[] d1Files = {f1, f2, f3};
        Directory[] d1Directories = {d2, d3, d4};
        root = new Directory("d1", d1Files, d1Directories);
        //Directory d1 = new Directory();  //tworzymy root (d1)- element, który nie ma przodków. Żeby stworzyć d1, trzeba mieć napierw d2, d3, d4. Żeby mieć d2, trzeba mieć d5, i d6.; definiowanie trzeba zacząc od końca.
    }

    public void displayAllFilesFromRoot() {  //żeby nie musieć przekazywac parametru do Directories.java do metody directoriesTree.displayAll
        displayAllFiles(root);   //wyświetl wszystkie pliki rozpoczynając od roota,  do roota mam dostęp przez private Directory root; na górze
    }                            //a jednoczesnie mam barzo elastyczną metodę, której mogę wskaać dowolny katalog, od którego chcę zacząć szukanie

    private void displayAllFiles(Directory directory) {
        File[] files = directory.getFiles();
        for (int i = 0; files != null && i < files.length; i++) { //przechodzę przez wszystkie pliki i wyświetlam je po kolei od root(d1) metodą getFiles
            System.out.println(files[i].getName());
        }
        Directory[] directories = directory.getDirectories();
        for (int i = 0; directories != null && i < directories.length; i++) {
            displayAllFiles(directories[i]);
        }
    }

    public boolean exists(String name) {  //ukrycie tego, że będe startowac od roota, a użytkownik podaje tylko nazwę.
        return exists(root, name);
    }

    private boolean exists(Directory directory, String name) {
        File[] files = directory.getFiles();
        for (int i = 0; files != null && i < files.length; i++) {
            if (files[i].getName().equals(name)) {
                return true;
            }
        }
        boolean exists = false;
        Directory[] directories = directory.getDirectories();
        for (int i = 0; directories != null && i < directories.length; i++) {
            exists |= exists(directories[i], name);
        }
        return exists;
    }
}
