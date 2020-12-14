import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Ch14 {
  public static final long INT_MAX = 68719476736L;
  public static ArrayList<Long> adjAddr = new ArrayList<>();
  public static HashMap<Long, Long> mem = new HashMap<>();

  public static void main(String[] args) throws Exception {
    partOne();
    partTwo();

  }

  public static void partOne() throws IOException {
    mem.clear();
    BufferedReader br = new BufferedReader(new FileReader("in.txt"));

    long andMask = 0;
    long orMask = 0;



    while (br.ready()) {
      String line = br.readLine();
      String[] terms = line.split("[\\[\\]\s]");

      if (terms[0].equals("mask")) {
        String andMaskStr = terms[2].replaceAll("X", "1");
        String orMaskStr = terms[2].replaceAll("X", "0");

        andMask = Long.parseLong(andMaskStr, 2);
        orMask = Long.parseLong(orMaskStr, 2);
      }
      else {
        long addr = Long.parseLong(terms[1]);
        long val = Long.parseLong(terms[4]);
        long adjVal = val & andMask;
        adjVal = adjVal | orMask;

        mem.put(addr, adjVal);
      }
    }
    Set<Long> set = mem.keySet();
    long sum = 0;
    for (Long i : set) {
      sum += mem.get(i);
    }

    System.out.println(sum + "\n");
  }

  public static void partTwo() throws IOException {
    mem.clear();
    BufferedReader br = new BufferedReader(new FileReader("in.txt"));

    long andMask = 0;
    long orMask = 0;
    String flt = "";


    while (br.ready()) {
      String line = br.readLine();
      String[] terms = line.split("[\\[\\]\s]");

      if (terms[0].equals("mask")) {
        String orMaskStr = terms[2].replaceAll("X", "0");

        orMask = Long.parseLong(orMaskStr, 2);
        flt = terms[2].replaceAll("[01]", "U");

      }
      else {
        long addr = Long.parseLong(terms[1]);
        long val = Long.parseLong(terms[4]);

        Long modAddr = addr | orMask;

        addrAdder(modAddr, flt, val);

      }
    }
    Set<Long> set = mem.keySet();
    long sum = 0;
    for (Long i : set) {
      sum += mem.get(i);
    }

    System.out.println(sum);
  }

  public static void addrAdder(Long addr, String mask, long val) {

    if (mask.contains("X")) {
      String mask0 = mask.replaceFirst("X", "0");
      String mask1 = mask.replaceFirst("X", "1");

      addrAdder(addr, mask0, val);
      addrAdder(addr, mask1, val);
    } else {
      String maskAndStr = mask.replaceAll("U", "1");
      String maskOrStr = mask.replaceAll("U", "0");

      long maskAnd = Long.parseLong(maskAndStr, 2);
      long maskOr = Long.parseLong(maskOrStr, 2);

      addr = addr & maskAnd;
      addr = addr | maskOr;

      mem.put(addr, val);
    }

  }

}
