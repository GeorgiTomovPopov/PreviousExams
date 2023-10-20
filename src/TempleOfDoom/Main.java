package TempleOfDoom;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> toolsQueue = new ArrayDeque<>();
        Deque<Integer> substancesStack = new ArrayDeque<>();

        String[] firstLine = scanner.nextLine().split("\\s+");
        Arrays.stream(firstLine).mapToInt(Integer::parseInt).forEach(toolsQueue::offer);

        String[] secondLine = scanner.nextLine().split("\\s+");
        Arrays.stream(secondLine).mapToInt(Integer::parseInt).forEach(substancesStack::push);

        List<Integer> challenges = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());


        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty()) {
            int currentTool = toolsQueue.poll();
            int currentSubstance = substancesStack.pop();
            int multiplied = currentTool * currentSubstance;
            int challengesCount = challenges.size();

            for (int i = 0; i < challenges.size(); i++) {
                if (challenges.get(i) == multiplied) {
                    challenges.remove(i);
                    break;
//                } else {
//                    currentTool += 1;
//                    toolsQueue.offer(currentTool);
//                    currentSubstance -= 1;
//                    if (currentSubstance != 0) {
//                        substancesStack.push(currentSubstance);
//                    }
                }
            }

            if (challengesCount == challenges.size()) {
                currentTool += 1;
                toolsQueue.offer(currentTool);
                currentSubstance -= 1;
                if (currentSubstance != 0) {
                    substancesStack.push(currentSubstance);
                }
            }

            if ((toolsQueue.isEmpty() || substancesStack.isEmpty()) && !challenges.isEmpty()) {
                System.out.println("Harry is lost in the temple. Oblivion awaits him.");

                break;
            } else if (challenges.isEmpty()) {
                System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
                break;
            }

        }

        if (!toolsQueue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tools:");

            for (int tool :
                    toolsQueue) {
                sb.append(" " + tool);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }

        if (!substancesStack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Substances:");

            for (int substance :
                    substancesStack) {
                sb.append(" " + substance);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }

        if (!challenges.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Challenges:");

            for (int challenge :
                    challenges) {
                sb.append(" " + challenge);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }

    }
}
