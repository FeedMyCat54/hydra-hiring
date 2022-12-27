package hydra_hiring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> cases;

        cases = getInput();


        for (ArrayList<ArrayList<Integer>> hydraCase : cases) {
            ArrayList<Integer> heads = hydraCase.get(0);
            ArrayList<Integer> assassins = hydraCase.get(1);
            int coins = 0;
            if (heads.size() > assassins.size()) {
                System.out.println("No can do");
                continue;
            }

            Collections.sort(heads);
            Collections.sort(assassins);
            for (Integer assassin : assassins) {
                for (Integer head : heads) {
                    if (assassin >= head) {
                        heads.remove(head);
                        coins += assassin;
                        break;
                    }
                }
            }
            if (heads.isEmpty()) {
                System.out.println(coins);
            } else {
                System.out.println("No can do!");
            }
        }
    }

    static ArrayList<ArrayList<ArrayList<Integer>>> getInput() {
        ArrayList<ArrayList<ArrayList<Integer>>> cases = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int n, m;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of heads and assassins");
            String nm = sc.nextLine();
            n = Character.getNumericValue(nm.charAt(0));
            m = Character.getNumericValue(nm.charAt(2));
            if (n == 0 && m == 0) {
                break;
            }

            ArrayList<Integer> heads = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                System.out.println("Enter the height of head #" + j);
                heads.add(sc.nextInt());
            }

            ArrayList<Integer> assassins = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                System.out.println("Enter the height of assassin #" + j);
                assassins.add(sc.nextInt());
            }
            ArrayList<ArrayList<Integer>> hydra = new ArrayList<>();
            hydra.add(heads);
            hydra.add(assassins);

            cases.add(hydra);
        }
        return cases;
    }
}
