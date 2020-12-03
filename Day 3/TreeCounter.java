import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Set;

public class TreeCounter {
  private BufferedReader br;
  private String file;

  public TreeCounter(String file) throws Exception{

    this.file = file;
  }

  public int calculateTrees(int right, int down) throws Exception{
    br = new BufferedReader(new FileReader(file));

    ArrayList<Character> charString = new ArrayList<>();
    String line = br.readLine();
    int trees = 0;
    int x = 0;
    int y = 0;

    while(line  != null && line.length() != 0) {
      if (y % down == 0) {
        for (int i = 0; i < line.length(); i++) {
          charString.add(line.charAt(i));
        }
      }


        if(charString.get(x % charString.size()) == '#') {
          trees++;
        }


      charString = new ArrayList<>();
      for(int i = 0; i < down; i++) {
        line = br.readLine();
      }
      x += right;
      y += down;
    }
    return trees;
  }

}
