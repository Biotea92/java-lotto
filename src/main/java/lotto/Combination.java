package lotto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Combination {

    public List<List<Integer>> solve(List<Integer> numbers, int r) {
        List<List<Integer>> result = new ArrayList<>();
        bfs(numbers, r, new ArrayList<>(), 0, result);
        return result;

    }

    public void bfs(List<Integer> numbers, int r, List<Integer> combination, int start, List<List<Integer>> result) {
        if (combination.size() == r) {
            result.add(new ArrayList<>(combination));
            return;
        }

        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(combination, start));

        while (!queue.isEmpty()) {
            State current = queue.poll();
            List<Integer> currentCombination = current.combination;
            int currentStart = current.start;

            for (int i = currentStart; i < numbers.size(); i++) {
                List<Integer> newCombination = new ArrayList<>(currentCombination);
                newCombination.add(numbers.get(i));

                if (newCombination.size() == r) {
                    result.add(newCombination);
                } else {
                    queue.offer(new State(newCombination, i + 1));
                }
            }
        }
    }

    private class State {
        List<Integer> combination;
        int start;

        State(List<Integer> combination, int start) {
            this.combination = combination;
            this.start = start;
        }
    }

    public static void main(String[] args) {
        Combination combination = new Combination();
        List<Integer> numbers = List.of(2, 6, 8, 11, 14, 16, 17);
        List<List<Integer>> result = combination.solve(numbers, 6);
        System.out.println("result = " + result);
    }
}
