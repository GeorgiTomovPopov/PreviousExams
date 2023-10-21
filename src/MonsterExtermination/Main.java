package MonsterExtermination;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> mosterArmourQueue = new ArrayDeque<>();
        Deque<Integer> soldierStrikeStack = new ArrayDeque<>();

        int[] monsterLine = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(monsterLine).forEach(mosterArmourQueue::offer);

        int[] soldierLine = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(soldierLine).forEach(soldierStrikeStack::push);

        int monstersKilled = 0;

        while (!mosterArmourQueue.isEmpty() && !soldierStrikeStack.isEmpty()) {
            int currentMonsterArmour = mosterArmourQueue.poll();
            int currentStrike = soldierStrikeStack.pop();

            if (currentStrike >= currentMonsterArmour) {
                if (!soldierStrikeStack.isEmpty()) {
                    currentStrike = soldierStrikeStack.pop() + currentStrike - currentMonsterArmour;
                    soldierStrikeStack.push(currentStrike);
                } else {
                    currentStrike = currentStrike - currentMonsterArmour;
                    if (currentStrike > 0) {
                        soldierStrikeStack.push(currentStrike);
                    }
                }
                monstersKilled++;
            } else {
                currentMonsterArmour = currentMonsterArmour - currentStrike;
                mosterArmourQueue.offer(currentMonsterArmour);
            }

        }

        if (mosterArmourQueue.isEmpty() && soldierStrikeStack.isEmpty()) {
            System.out.println("All monsters have been killed!");
            System.out.println("The soldier has been defeated.");
        } else if (mosterArmourQueue.isEmpty()) {
            System.out.println("All monsters have been killed!");
        } else {
            System.out.println("The soldier has been defeated.");
        }


        System.out.printf("Total monsters killed: %d", monstersKilled);
    }
}
