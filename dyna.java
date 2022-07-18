import java.util.ArrayList;
import java.util.List;

public class dyna {
    //A = [3,1,7,9,5]
    private int[] D;
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    private int[] listPointer;

    public dyna(int[] A, int i) {
        int[] D = new int[i];
        D[0] = A[0];
        D[1] = A[1];
        list1.add(D[0]);
        list2.add(D[1]);
        listPointer = new int[i];
        listPointer[0] = 1;
        listPointer[1] = 2;

        for (int k = 2; k < i; k++) {
            int with = D[k - 2] + A[k];
            int without = D[k - 1];

            if (with > without) {
                D[k] = with;
                listPointer[k] = listPointer[k-2];
                getListFromPointer(listPointer[k]).add(A[k]);
            }
            else{
                D[k] = without;
                listPointer[k] = listPointer[k-1];
            }

        }
        printList(listPointer[i-1]); // Forgot to write this part.
    }

    private List<Integer> getListFromPointer(int listpointer){
        switch (listpointer)
        {
            case 1:
                return list1;
            case 2:
                return list2;
        }
        return null;
    }

    private void printList(int listpointer)
    {
        switch (listpointer)
    {
        case 1:
            for (int i = 0; i < list1.size(); i++)
            {
                System.out.println(list1.get(i));
            }
            break;
        case 2:
            for (int i = 0; i < list2.size(); i++)
            {
                System.out.println(list2.get(i));
            }
            break;
    }
    }

}
