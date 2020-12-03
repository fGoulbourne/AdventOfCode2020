public class Ch3 {

  public static void main(String[] args) throws Exception{
    TreeCounter count = new TreeCounter("logs.txt");
    int[] total = new int[5];
    total[0] = count.calculateTrees(1, 1);
    total[1] = count.calculateTrees(3, 1);
    total[2] = count.calculateTrees(5, 1);
    total[3] = count.calculateTrees(7, 1);
    total[4] = count.calculateTrees(1, 2);
    long multi = 1;
    for(int i : total) {
      multi = multi*i;
    }
    System.out.println(multi);
  }
}
