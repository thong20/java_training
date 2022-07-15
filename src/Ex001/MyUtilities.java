package Ex001;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MyUtilities {

    // EX001 ========================================================================
    public static int[][] toNestedIntArray(List intList){
        int[][] result = new int[intList.size()][4];
        for(int i = 0 ; i < intList.size() ; i++){
            result[i] = (int[]) intList.get(i);
        }
        return result;
    }

}
