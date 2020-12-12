import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Ch12 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("in.txt"));
    ArrayList<String> input = new ArrayList<>();
    while (br.ready()) {
      input.add(br.readLine());
    }

    int r = 0;
    int u = 0;
    int dirR = 1;
    int dirU = 0;
    int tempR = 0;
    int tempU = 0;
    int dist;
    int deg;

    for (int i = 0; i < input.size(); i++) {
      Character ch = input.get(i).charAt(0);
      dist = Integer.parseInt(input.get(i).substring(1));
      deg = dist/90;

      switch (ch) {
        case 'R':
          for (int j = 0; j < deg; j++) {

            tempR = dirR;
            tempU = dirU;

            dirR = tempU;
            dirU = -tempR;
          }
          break;

        case 'L':
          for (int j = 0; j < deg; j++) {
          tempR = dirR;
          tempU = dirU;

          dirR = -tempU;
          dirU = tempR;
          }
          break;

        case 'F':
          u += dirU * dist;
          r += dirR * dist;
          break;

        case 'N':
          u += dist;
          break;

        case 'S':
          u -= dist;
          break;

        case 'E':
          r += dist;
          break;

        case 'W':
          r -= dist;
          break;

      }
    }

    System.out.println(Math.abs(u) + Math.abs(r) + "\n");
    part2();
  }

  public static void part2() throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("in.txt"));
    ArrayList<String> input = new ArrayList<>();
    while (br.ready()) {
      input.add(br.readLine());
    }

    int r = 0;
    int u = 0;
    int wpR = 10;
    int wpU = 1;
    int tempR = 0;
    int tempU = 0;
    int dist;
    int deg;

    for (int i = 0; i < input.size(); i++) {
      Character ch = input.get(i).charAt(0);
      dist = Integer.parseInt(input.get(i).substring(1));
      deg = dist/90;

      switch (ch) {
        case 'R':
          for (int j = 0; j < deg; j++) {

            tempR = wpR;
            tempU = wpU;

            wpR = tempU;
            wpU = -tempR;
          }
          break;

        case 'L':
          for (int j = 0; j < deg; j++) {
            tempR = wpR;
            tempU = wpU;

            wpR = -tempU;
            wpU = tempR;
          }
          break;

        case 'F':
          u += wpU * dist;
          r += wpR * dist;
          break;

        case 'N':
          wpU += dist;
          break;

        case 'S':
          wpU -= dist;
          break;

        case 'E':
          wpR += dist;
          break;

        case 'W':
          wpR -= dist;
          break;

      }
    }

    System.out.println(Math.abs(u) + Math.abs(r));
  }
}
