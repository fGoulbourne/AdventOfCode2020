import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Ch11 {
  public ArrayList<ArrayList<Integer>> seats = new ArrayList();
  public ArrayList<ArrayList<Integer>> temp = new ArrayList();
  int filled = 0;


  public static void main(String[] args) throws Exception {
    Ch11 calc = new Ch11();

    BufferedReader br = new BufferedReader(new FileReader("in1.txt"));
    ArrayList<Integer> seatRow;
    ArrayList<Integer> tempRow;
    Character ch;
    String in;

    while (br.ready()) {
       in = br.readLine();
      seatRow = new ArrayList<>();
      tempRow = new ArrayList<>();
      for (int i = 0; i < in.length(); i++) {
        ch = in.charAt(i);

        switch (ch) {
          case '.' -> {
            seatRow.add(0);
            tempRow.add(0);
          }
          case 'L' -> {
            seatRow.add(1);
            tempRow.add(1);
          }
          case '#' -> {
            seatRow.add(2);
            tempRow.add(2);
          }

        }
      }
      calc.addSeats(seatRow, tempRow);

    }

    boolean hasSwap = true;
    while(hasSwap) {
      hasSwap = false;
      for (int i = 0; i < calc.seats.size(); i++) {
        for (int j = 0; j < calc.seats.get(i).size(); j++) {
          hasSwap = calc.calcSwap(i, j) || hasSwap;

        }

      }
      for (int i = 0; i < calc.seats.size(); i++) {
        for (int j = 0; j < calc.seats.get(i).size(); j++) {
          int val = calc.temp.get(i).get(j);
          calc.seats.get(i).set(j, val);

        }

      }

    }
    System.out.println(calc.filled);

  }

  public void addSeats (ArrayList<Integer> seatRow, ArrayList<Integer> tempRow) {
    seats.add(seatRow);
    temp.add(tempRow);
  }

  public boolean calcSwap(int row, int column) {
    int seat = seats.get(row).get(column);

    if (seat == 0) {
      return false;
    }

    int count = 0;
    int width = seats.get(0).size();
    int length = seats.size();

    int[] neighbours = new int[8];




    if (row != 0) {
      if (column != 0) {
        neighbours[0] = seats.get(row - 1).get(column - 1);
      }
      neighbours[1] = seats.get(row - 1).get(column);
      if (column != width - 1) {
        neighbours[2] = seats.get(row - 1).get(column + 1);
      }
    }
    if (column != 0) {
      neighbours[3] = seats.get(row).get(column - 1);
    }
    if (column != width - 1) {
      neighbours[4] = seats.get(row).get(column + 1);
    }
    if (row != length - 1) {
      if (column != 0) {
        neighbours[5] = seats.get(row + 1).get(column - 1);
      }
      neighbours[6] = seats.get(row + 1).get(column);
      if (column != width - 1) {
        neighbours[7] = seats.get(row + 1).get(column + 1);
      }
    }

    for (int i : neighbours) {
      if (i == 2) {
        count++;
      }
    }

    if (count == 0 && seat != 2) {
      temp.get(row).set(column, 2);
      filled++;
      return true;
    } else if (count >= 4 && seat != 1) {
      temp.get(row).set(column, 1);
      filled--;
      return true;
    }
    return false;
  }


}
