import java.util.List;

public class CodingInterview08_06 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        movePlant(A.size(), A, B, C);
    }

    public void movePlant(int size, List<Integer> start, List<Integer> auxiliary, List<Integer> target) {
        if (size == 1) {
            target.add(start.remove(start.size() - 1));
            return;
        }
        movePlant(size - 1, start, target, auxiliary);
        target.add(start.remove(start.size() - 1));
        movePlant(size - 1, auxiliary, start, target);
    }
}
