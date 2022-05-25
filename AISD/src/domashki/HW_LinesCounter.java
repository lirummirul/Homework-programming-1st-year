package domashki;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;

public class HW_LinesCounter {
    public static void main(String[] args) throws FileNotFoundException {
        String dir = "C:\\Users\\kivi2\\IdeaProjects\\test\\src";
        String ext = ".java";
        findFiles(new File(dir), ext);
    }

    private static void findFiles(File dir, String ext) throws FileNotFoundException {
        if(dir.isDirectory()){
            File file = new File(String.valueOf(dir));
            File[] listFiles = dir.listFiles(new MyFileNameFilter(ext));
            if(listFiles.length == 0){
                System.out.println(dir + " не содержит файлов с расширением " + ext);
            }else{
                int sum = 0;
                for(File f : dir.listFiles()){
                    String wayToFile = dir + File.separator + f.getName();
                    System.out.println("Файл: " + wayToFile + " Количество строк: " + getLineCount(wayToFile));
                    sum += getLineCount(wayToFile);
                }
                System.out.println("Общее количество строк: " + sum);
            }

        }
        else{
            System.out.println(dir + " каталог не существует");
        }
    }
    public static class MyFileNameFilter implements FilenameFilter {

        private String ext;

        public MyFileNameFilter(String ext){
            this.ext = ext.toLowerCase();
        }
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(ext);
        }
    }
    public static int getLineCount(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        int lines = 0;

        while (scanner.hasNextLine()) {
            lines++;
            String[] array = scanner.nextLine().split(" ");
        }
        scanner.close();
        return lines;
    }
}