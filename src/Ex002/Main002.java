package Ex002;

import sun.security.util.ArrayUtil;

import java.util.*;

public class Main002 {
    public static void main(String[] args) {
        // Link: https://codelearn.io/training/detail/44200
//        mBuild("1,1,2,4,3,5,6,5,2,10");
//        mBuild("5,10,11,20,21,12,13,100,1,2,3");
//        mBuild("0,4,5,6,9,lakdjfl,10,500");
        mBuild("5,53,4,49,31,8,9,8,7,3,31,53");

    }

    public static void mBuild(String str){
        String result = "";
        int[] arr = MyUtilities.strToIntArray(str);
        if(arr == null) {
            System.out.println("undefined");
            return;
        }
        List<Integer> list = new ArrayList<>();




        int[] arrFinal = MyUtilities.removeItemDuplicate(arr);
        Arrays.sort(arrFinal);
        for(int n : arrFinal) System.out.print(n + " ");
        // 1,2,3,5,10,11,12,13,20,21,100


        for(int i = 0 ; i < arrFinal.length ; i++){
            list.add(arrFinal[i]);
            // {10,11,12}
            if(i+1 >= arrFinal.length){ // Khi tới phần tử cuối cùng thì lấy kết quả
                if(list.size()>2) {
                    result += list.get(0) +"-"+ list.get(list.size() - 1) + ",";
                }else{
                    result += list.get(0) +",";
                }
                break;
            }
            if(arrFinal[i] != arrFinal[i+1] - 1){
                if(list.size() > 1) {
                    result += list.get(0) +"-"+ list.get(list.size() - 1) +",";
                }else{
                    result += list.get(0) +",";
                }

                list.clear();
            }
        }

        System.out.println("\n" +result.substring(0, result.length()-1));
    }


}
