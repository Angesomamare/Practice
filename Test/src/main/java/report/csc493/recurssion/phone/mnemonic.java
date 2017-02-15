package report.csc493.recurssion.phone;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mezgeboa on 2/15/2017.
 */
public class mnemonic {
    public String letters [][]={{" "},{" "},{"A", "B", "C"},{"D", "E", "F"},{"G", "H", "I"},{"J", "K", "L"},{"M", "N", "O"}
            , {"P", "Q", "R","S"},{"T", "U", "V"},{"W", "X", "Y","Z"}
    };


    public void mnemonic(List<String> words, String pre, String phone){

        int first = Integer.parseInt(phone.substring(0,1));
        String rest = phone.substring(1);


        if (phone.length()==1){
            for (int i=0; i<letters[first].length;i++){
                words.add(pre+letters[first][i]);
            }
        }
        else{
            for (int i=0; i<letters[first].length;i++){
                mnemonic(words, pre + letters[first][i], rest);
            }
        }

    }
    public List<String> provide_words(String number){
        List<String> all = new LinkedList<String>();
        mnemonic cell = new mnemonic();
        cell.mnemonic(all, "", number);
        return all;
    }
}
