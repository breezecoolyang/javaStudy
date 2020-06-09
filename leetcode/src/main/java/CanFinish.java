import java.util.*;

public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        List<ArrayList<Integer>> adjacency = new ArrayList<>();
        for(int i=0;i < numCourses;i++)
        {
          adjacency.add(new ArrayList<Integer>());
        }


        for(int[] temp: prerequisites)
        {
            indegree[temp[0]]++;
            adjacency.get(temp[1]).add(temp[0]);
        }

        for(int i=0;i < numCourses;i++)
        {
            if(indegree[i] == 0) {
                ((LinkedList<Integer>) queue).add(i);
            }
        }

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            numCourses--;
            for(int value: adjacency.get(temp))
            {
                if(--indegree[value] == 0) {
                    ((LinkedList<Integer>) queue).add(value);
                }
            }
        }

        return numCourses == 0;

    }

    public boolean dfs(List<ArrayList<Integer>> adjacency, int[] flags, int index)
    {
        if(flags[index] == -1) return true;
        if(flags[index] == 1) return false;
        flags[index] = 1;
        for(int value:adjacency.get(index)) {
            if(!dfs(adjacency, flags, value))  return false;
        }
        flags[index] = -1;
        return true;
    }
    public boolean canFinishTwo(int numCourses, int[][] prerequisites) {

        int[] flags = new int[numCourses];
        List<ArrayList<Integer>> adjacency = new ArrayList<>();
        for(int i=0;i < numCourses;i++)
        {
            adjacency.add(new ArrayList<Integer>());
        }

        for(int[] cp: prerequisites)
        {
            adjacency.get(cp[1]).add(cp[0]);
        }

        for(int i=0; i< numCourses;i++)
        {
            if(!dfs(adjacency, flags, i)) return false;
        }

        return true;

    }

    public static void main(String[] args) {

    }
}
