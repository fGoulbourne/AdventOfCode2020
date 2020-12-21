import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
  private String eq;

  public Calculator(String eq) {
    this.eq = eq;
  }

  public Long calculate(String subEq, int type) {

    while (subEq.contains("(")) {
      Pattern pattern = Pattern.compile("[(][^(]*?[)]");
      Matcher matcher = pattern.matcher(subEq);

      if (matcher.find()) {
        String concatStr = matcher.group(0).replaceAll("^[(]|[)]$", "");
        subEq = subEq.replaceFirst("[(][^(]*?[)]", calculate(concatStr, type).toString());
      }
    }

    while (subEq.contains("+") && type == 2) {
      Pattern pattern = Pattern.compile("\\d+.[+].\\d+");
      Matcher matcher = pattern.matcher(subEq);

      if (matcher.find()) {
        String[] terms = matcher.group(0).split(" ");
        subEq = subEq.replaceFirst("\\d+.[+].\\d+", operate(Long.parseLong(terms[0]), terms[1], Long.parseLong(terms[2])).toString());

      }
    }

      String[] terms = subEq.split(" ");

    int i = 1;
    long calc = Long.parseLong(terms[0]);



    while (i <= terms.length - 2) {
      calc = operate(calc, terms[i], Long.parseLong(terms[i+1]));
      i += 2;
    }
    return calc;
  }

  public Long calculate(int type) {
    return calculate(this.eq, type);
  }

  private Long operate(long v1, String op, long v2) {
    if (op.equals("+")) {
      return v1 + v2;
    } else {
      return v1 * v2;
    }
  }
}
