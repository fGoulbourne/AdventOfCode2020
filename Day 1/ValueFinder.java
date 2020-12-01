import java.util.ArrayList;

public class ValueFinder {
  ArrayList values;
  Integer target;

  public ValueFinder(ArrayList list, int val) {
    values = list;
    target = val;
  }

  private int findVal2(ArrayList<Integer> expenses, int val) {

    ArrayList<Integer> temp = new ArrayList<>();

    for(Integer i : expenses) {
      temp.add(i);
    }

    int low;
    int high;

    do {
      if(temp.size() <=1) {
        break;
      }
      low = temp.get(0);
      high = temp.get(temp.size()-1);

      if((low + high) > val) {
        temp.remove(temp.size()-1);
      } else if((low + high) < val) {
        temp.remove(0);
      }

      if(low +  high == val) {
        System.out.println(low * high + ": " + low + " * " + high);
        return low * high;
      }

    } while((low + high) != val);

    return 0;

  }

  private int findVal3(ArrayList<Integer> expenses, int val) {


    ArrayList<Integer> temp = new ArrayList<>();

    for(Integer i : expenses) {
      temp.add(i);
    }

    int low;
    int multi_2;

    do {
      low = temp.get(0);
      temp.remove(0);

      multi_2 = this.findVal2(temp, val - low);

      if (multi_2 != 0) {
        System.out.println(low * multi_2 + ": " + low + " * " + multi_2);
        return low * multi_2;
      }

    } while (low * multi_2 != val);

    return 0;

  }

  public int findVal_3() {
    return findVal3(values, target);
  }
  public int findVal_2() {
    return findVal2(values, target);
  }
}
