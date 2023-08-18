package accenture;

import java.util.Arrays;
import java.util.List;

public class ShortestTastFirst {

    public static void main(String[] args) {

        Integer actual0 = getTaskIndexAtCycle(Arrays.asList(2, 6, 7, 1, 4), 5);
        Integer actual1 = getTaskIndexAtCycle(Arrays.asList(3), 3);
        Integer actual2 = getTaskIndexAtCycle(Arrays.asList(9, 3, 3, 3), 5);
        Integer actual3 = getTaskIndexAtCycle(Arrays.asList(9, 3, 3, 3), 6);
        Integer actual4 = getTaskIndexAtCycle(Arrays.asList(9, 3, 3, 3), 9);

        System.out.println("actual0: " + actual0);
        System.out.println("actual1: " + actual1);
        System.out.println("actual2: " + actual2);
        System.out.println("actual4: " + actual3);
        System.out.println("actual4: " + actual4);
    }

    private static Integer getTaskIndexAtCycle(List<Integer> jobs, Integer cycle) {

        Integer[][] fullJobs = new Integer[jobs.size()][2];

        for (int i = 0; i < jobs.size(); i++) {
            fullJobs[i][0] = i;
            fullJobs[i][1] = jobs.get(i);
        }

        simurgHSort(fullJobs);

        for (int i = 0; i < jobs.size(); i++) {
            if(jobs.size() == 1){
                return fullJobs[i][0];
            }
            if (fullJobs[i][1] > cycle) {
                return fullJobs[i-1][0];
            }
            cycle -= fullJobs[i][1];
        }

        return null;
    }

    private static void simurgHSort(Integer[][] fullJobs) {
        Arrays.sort(fullJobs, (o1, o2) -> (o1[1] >= o2[1]) ? 1 : -1);
    }

}
