import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Ticket {
  ArrayList<Integer> vals;
  HashMap<Integer, HashSet<Category>> cats;
  ArrayList<Category> categories;

  public Ticket(ArrayList<Integer> vals, ArrayList<Category> categories) {
    this.vals = vals;
    cats = new HashMap<>();
    this.categories = categories;
  }

  public void validCats(int val, int index) {
    HashSet<Category> possCats = new HashSet<>();
    for(Category cat : categories) {
      if (cat.contains(val)) {
        possCats.add(cat);
      }
    }

    cats.put(index, possCats);


  }

  public void setValidCats() {
    for (int i = 0; i < vals.size(); i++) {
      validCats(vals.get(i), i);
    }

  }
}
