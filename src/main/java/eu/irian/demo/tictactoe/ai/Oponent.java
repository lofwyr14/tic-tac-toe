package eu.irian.demo.tictactoe.ai;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class Oponent implements MoveService {

//  public static void main(String[] args) {
//    char[]field = {'X', ' ', ' ' , 'O' , ' ' , 'X', 'O', 'X'};
//    Oponent oponent = new Oponent();
//    System.out.println(oponent.move(field));
//  }


  @Override
  public int move(char[] field){

    List<Integer> freeFields = new ArrayList<>();
    for(int i = 0; i < field.length; i++){
        if( ' ' == field[i]){
          freeFields.add(i);
        }
    }
    if( freeFields.size() == 0){
      return -1;
    } else {
      return freeFields.get((int)(Math.random() * freeFields.size()));
    }
  }


}
