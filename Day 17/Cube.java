import java.util.HashSet;

public class Cube {

  public static HashSet<Cube> cubes = new HashSet<>();
  public static final HashSet<Cube> relevantCubes = new HashSet<>();
  private final int x;
  private final int y;
  private final int z;
  private final int w;

  public Cube(int x, int y, int z, int w, boolean on) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.w = w;

    if (on) {
      cubes.add(this);
    }
    relevantCubes.add(this);

  }



  public static void reset() {
    cubes.clear();
    relevantCubes.clear();
  }



  public int neighbours(int part) {
    int neighbourCount = 0;
    if (part == 1) {
      for (Cube cube : cubes) {
        int deltaX = Math.abs(cube.x - this.x);
        int deltaY = Math.abs(cube.y - this.y);
        int deltaZ = Math.abs(cube.z - this.z);

        if (cube != this && deltaX <= 1 && deltaY <= 1 && deltaZ <= 1) {
          neighbourCount++;
        }
      }
    } else {
      for (Cube cube : cubes) {
        int deltaX = Math.abs(cube.x - this.x);
        int deltaY = Math.abs(cube.y - this.y);
        int deltaZ = Math.abs(cube.z - this.z);
        int deltaW = Math.abs(cube.w - this.w);

        if (cube != this && deltaX <= 1 && deltaY <= 1 && deltaZ <= 1 && deltaW <= 1) {
          neighbourCount++;
        }
      }
    }
    return neighbourCount;
  }

}
