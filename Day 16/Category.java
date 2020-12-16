public class Category {
  public int minVal1;
  public int minVal2;
  public int maxVal1;
  public int maxVal2;

  public String name;

  public Category(String name, int miv1, int mav1, int miv2, int mav2 ) {
    this.name = name;
    this.minVal1 = miv1;
    this.minVal2 = miv2;
    this.maxVal1 = mav1;
    this.maxVal2 = mav2;
  }

  public boolean contains (int val) {
    if ((val >= minVal1 && val <= maxVal1)
      || (val >= minVal2 && val <= maxVal2)) {
      return true;
    }
    return false;
  }
}
