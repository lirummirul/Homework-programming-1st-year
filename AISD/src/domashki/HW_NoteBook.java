package domashki;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class HW_NoteBook {

    @Override
    public void removeByIndex() throws DbException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите индекс элемента, который хотите удалить: ");
        int index = sc.nextInt();
        Object[] data = findAll();
        data[index] = "";
        try (FileOutputStream stream = new FileOutputStream(this.path)){
            Object[] newData = new Object[data.length-1];
            for (int i = 0, j = 0; i < data.length; i++){
                if (i != index){
                    newData[j++] = data[i];
                }
            }
            stream.write(convertToBytes(newData));
        } catch (IOException ex) {
            throw new DbExeption ("DB error: + " + ex.getMessage());
        }
    }
}
