import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MinimumNumberOfDevelopers {
    static ArrayList<Integer> sol = new ArrayList<>();

    static void solve(int[] people, int numOfSkills, int currPerson, ArrayList<Integer> possibleSol, int acqSkills) {
        if (currPerson == people.length) {
            if (acqSkills == ((1 << numOfSkills) - 1)) {
                if (sol.size() == 0 || sol.size() > possibleSol.size())
                    sol = new ArrayList<>(possibleSol);
            }
            return;
        }

        solve(people, numOfSkills, currPerson + 1, possibleSol, acqSkills);
        possibleSol.add(currPerson);
        // acqSkills | people -> provide us potential skill set with us
        solve(people, numOfSkills, currPerson + 1, possibleSol, (acqSkills | people[currPerson]));
        possibleSol.remove(possibleSol.size() - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /*
         * Skill map example
         * java -> 0
         * nodejs -> 1
         * reactjs -> 2
         */

        /*
         * People array
         * A -> 0 0 1
         * B -> 0 1 0
         * C -> 1 1 0
         */

        HashMap<String, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < n; i++)
            skillMap.put(sc.next(), i);

        int np = sc.nextInt();
        int people[] = new int[np];

        for (int i = 0; i < np; i++) {
            int personsTotalSkills = sc.nextInt();

            for (int j = 0; j < personsTotalSkills; j++) {
                String skill = sc.next();
                int skillNumber = skillMap.get(skill);
                people[i] = people[i] | (1 << skillNumber);
            }
        }
        solve(people, n, 0, new ArrayList<>(), 0);
        for (Integer ele : sol)
            System.out.print(ele + " ");
        sc.close();
    }
}