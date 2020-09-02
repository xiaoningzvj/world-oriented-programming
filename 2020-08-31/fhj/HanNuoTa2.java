import java.util.Stack;

public class HanNuoTa2 {
    private Stack<Integer> ls;
    private Stack<Integer> ms;
    private Stack<Integer> rs;
    private String type;

    public HanNuoTa2() {
        ls = new Stack<>();
        ms = new Stack<>();
        rs = new Stack<>();
    }

    public static void main(String[] args) {
        HanNuoTa2 hanNuoTa2 = new HanNuoTa2();
        hanNuoTa2.sort(2);
    }

    public void sort(int n) {
        ls.clear();
        ms.clear();
        rs.clear();
        for (int i = n; i > 0; i--) {
            ls.push(i);
        }
        int result = 0;
        while (rs.size() != n) {
            result += execute("ml", "lm", "left", "mid", ls, ms);
            result += execute("lm", "ml", "mid", "left", ms, ls);
            result += execute("rm", "mr", "mid", "right", ms, rs);
            result += execute("mr", "rm", "right", "mid", rs, ms);
        }

    }

    private int execute(String reverAction, String currentAction, String from, String to, Stack<Integer> f, Stack<Integer> t) {
        if (type == reverAction) {
            return 0;
        }
        if (f.size() == 0 && t.size() == 0) {
            return 0;
        }
        if (f.size() == 0) {
            return 0;
        }
        if (t.size() == 0) {
            t.push(f.pop());
            type = currentAction;
            System.out.println("move " + t.peek() + " from " + from + " to " + to);
            return 1;
        }
        if (f.peek() < t.peek()) {
            t.push(f.pop());
            type = currentAction;
            System.out.println("move " + t.peek() + " from " + from + " to " + to);
            return 1;
        }
        return 0;
    }

}
