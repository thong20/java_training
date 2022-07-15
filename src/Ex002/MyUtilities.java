package Ex002;

import java.util.*;

public class MyUtilities {

    // EX002 ========================================================================
    public static int[] strToIntArray(String str) {
        int[] result;
        try {
            String[] tmp = str.split(",");
            result = new int[tmp.length];
            for (int i = 0; i < tmp.length; i++) {
                // Nếu là string | char thì Integer.parseInt sẽ
                // ném rá 1 exception NumberFormatException và hàm
                // này sẽ return null;
                result[i] = Integer.parseInt(tmp[i]);
                if(result[i] < 0) // Nếu là sô âm
                    throw new NumberFormatException();

            }
        }catch (NumberFormatException e){
            return null;
        }
        return result;
    }

    // Tạo ArrayList
    public static int[] removeItemDuplicate(int[] arr){

        Set<Integer> hashSet = new HashSet(intArrayToList(arr));
        List<Integer> list = new ArrayList<>(hashSet);
        int[] result = new int[list.size()];
        int i = 0;
        for(Integer n : list) result[i++] = n;
        return result;
    }

    public static List<Integer> intArrayToList(int[] arr){
        List<Integer> result = new ArrayList<>();
        for(int n : arr) result.add(n);
        return result;
    }
}
