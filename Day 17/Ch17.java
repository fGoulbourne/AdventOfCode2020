import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Ch17 {

  public static void main(String[] args) throws Exception {
    partOne();
    partTwo();
  }

  private static void partOne() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("in.txt"));
    ArrayList<ArrayList<Boolean>> coords = new ArrayList<>();

    while (br.ready()) {
      ArrayList<Boolean> x = new ArrayList<>();
      String yStr = br.readLine();
      for (int i = 0; i < yStr.length(); i++) {
        if (yStr.charAt(i) == '#') {
          x.add(true);
        } else {
          x.add(false);
        }
      }
      coords.add(x);
    }

    for (int i = 0; i < coords.size(); i++) {
      for (int j = 0; j < coords.get(i).size(); j++) {
        boolean on = coords.get(i).get(j);
        new Cube(j, i, 0, 0, on);
      }
    }

    int turn = 1;
    int width = coords.size();
    int length = coords.get(0).size();

    while(turn <= 6) {
      genCubes(turn, width, length, 1);
      HashSet<Cube> tempCubes = new HashSet<>();
      for (Cube cube : Cube.relevantCubes) {

        int ngbr = cube.neighbours(1);

        if (Cube.cubes.contains(cube)) {

          if (ngbr == 2 || ngbr == 3) {
            tempCubes.add(cube);
          } else {

          }
        } else if (ngbr == 3) {
          tempCubes.add(cube);
        }
      }
      Cube.cubes = tempCubes;
      turn++;
    }

    System.out.println(Cube.cubes.size());
  }

  private static void partTwo() throws IOException {
    Cube.reset();
    BufferedReader br = new BufferedReader(new FileReader("in.txt"));
    ArrayList<ArrayList<Boolean>> coords = new ArrayList<>();

    while (br.ready()) {
      ArrayList<Boolean> x = new ArrayList<>();
      String yStr = br.readLine();
      for (int i = 0; i < yStr.length(); i++) {
        if (yStr.charAt(i) == '#') {
          x.add(true);
        } else {
          x.add(false);
        }
      }
      coords.add(x);
    }

    for (int i = 0; i < coords.size(); i++) {
      for (int j = 0; j < coords.get(i).size(); j++) {
        boolean on = coords.get(i).get(j);
        new Cube(j, i, 0, 0, on);
      }
    }

    int turn = 1;
    int width = coords.size();
    int length = coords.get(0).size();

    while(turn <= 6) {
      genCubes(turn, width, length, 2);
      HashSet<Cube> tempCubes = new HashSet<>();
      for (Cube cube : Cube.relevantCubes) {

        int ngbr = cube.neighbours(2);

        if (Cube.cubes.contains(cube)) {

          if (ngbr == 2 || ngbr == 3) {
            tempCubes.add(cube);
          } else {

          }
        } else if (ngbr == 3) {
          tempCubes.add(cube);
        }
      }
      Cube.cubes = tempCubes;
      turn++;
    }

    System.out.println(Cube.cubes.size());
  }

  public static void genCubes(int turn, int width, int length, int part) {
    if (part == 1) {
      for (int x = -turn; x < width + turn; x++) {
        for (int y = -turn; y < length + turn; y++) {
          for (int z = -turn; z < turn + 1; z++) {
            if (x == -turn || x == (width + turn - 1)
              || y == -turn || y == (length + turn - 1)
              || z == -turn || z == turn) {

              new Cube(x, y, z, 0, false);
            }
          }
        }
      }
    } else {
      for (int x = -turn; x < width + turn; x++) {
        for (int y = -turn; y < length + turn; y++) {
          for (int z = -turn; z < turn + 1; z++) {
            for (int w = -turn; w < turn + 1; w++)
            if (x == -turn || x == (width + turn - 1)
              || y == -turn || y == (length + turn - 1)
              || z == -turn || z == turn
              || w == -turn || w == turn) {

              new Cube(x, y, z, w, false);
            }
          }
        }
      }
    }


  }

}
