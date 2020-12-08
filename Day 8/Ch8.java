import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Ch8 {
  private ArrayList<String> commands;
  private BufferedReader br;
  private HashSet<Integer> runCmd;
  private int pointer = 0;
  private int acc = 0;


  public static void main(String[] args) throws Exception {
    Ch8 console = new Ch8();
    console.partOne();
    console = new Ch8();

    int index = -1;
    while (!console.partTwo()) {
      if(index != -1) {
        console.swap(index);
      }
      do {
        index++;
      } while (!console.swap(index));
    }
    System.out.println(index);

  }

  public Ch8() throws Exception {
    commands = new ArrayList<>();
    br = new BufferedReader(new FileReader("in.txt"));
    runCmd = new HashSet<>();


    while(br.ready()) {
      commands.add(br.readLine());
    }
  }

  public void partOne() throws Exception {
    String[] command;
    while (pointer < commands.size() && !runCmd.contains(pointer)) {
      command = commands.get(pointer).split(" ");

      switch (command[0]) {
        case "acc" -> {
          acc += Integer.parseInt(command[1]);
          runCmd.add(pointer);
          pointer++;
        }
        case "nop" -> {
          runCmd.add(pointer);
          pointer++;
        }
        case "jmp" -> {
          runCmd.add(pointer);
          pointer += Integer.parseInt(command[1]);
        }
      }
    }
    System.out.println(acc);


  }

  public boolean partTwo() throws Exception {
    String[] command;

    while (pointer < commands.size()) {
      command = commands.get(pointer).split(" ");
      if(runCmd.contains(pointer)) {
        pointer = 0;
        acc = 0;
        runCmd.clear();
        return false;
      }
      if (command[0].equals("acc")) {
        acc += Integer.parseInt(command[1]);
        runCmd.add(pointer);
        pointer++;
      } else if (command[0].equals("nop")) {
        runCmd.add(pointer);
        pointer++;
      } else if (command[0].equals("jmp")) {
        runCmd.add(pointer);
        pointer += Integer.parseInt(command[1]);
      }
    }
    System.out.println(acc);
    return true;
  }

  public boolean swap(int index) {
    if (commands.get(index).contains("jmp")) {
      commands.set(index, commands.get(index).replace("jmp", "nop"));
      return true;
    } else if (commands.get(index).contains("nop")) {
      commands.set(index, commands.get(index).replace("nop", "jmp"));
      return true;
    }
    return false;
  }

}

