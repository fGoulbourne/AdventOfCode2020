import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ch5 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("board.txt"));
    ArrayList<Integer> seats = new ArrayList<>();

    String seat;
    String rowStr;
    String columnStr;

    int row;
    int column;

    int seatID = 0;

    while ((seat  = br.readLine()) != null && seat.length() != 0) {
      seat = seat.replace('F', '0');
      seat = seat.replace('B', '1');
      seat = seat.replace('R', '1');
      seat = seat.replace('L', '0');

      rowStr = seat.substring(0, 7);
      columnStr = seat.substring(7, 10);

      row = Integer.parseInt(rowStr, 2);
      column = Integer.parseInt(columnStr, 2);

      seats.add(row*8 + column);
      if(row*8 + column > seatID) {
        seatID = row*8 + column;
      }


    }
    Collections.sort(seats);

    for(int i = 1; i < seats.size(); i++) {
      if(seats.get(i) != (seats.get(i-1) + 1)) {
        System.out.println("Given seat: " + (seats.get(i) - 1));
      }

    }
    System.out.println("Largest ID: " + seatID);
  }
}
