package Ex001;

// Link: https://codelearn.io/training/detail/2556950

import java.util.*;


/**
 * Công ty X đang xây dựng một công trình trong:<br>
 * "<u>n</u>" ngày và mỗi ngày cần: "<u>k</u>" công nhân.<br>
 * Có "<u>m</u>" công ty cho thuê công nhân "<u>hire</u>". Mỗi công ty được biểu diễn dưới dạng mảng:<br>
 * <u>[l,r,c,p]</u>. Công ty thứ "<u>i</u>" sẽ có chính sách cho thuê công nhân từ ngày "l" đến ngày<br>
 * "<u>r</u>", mỗi ngày sẽ cho thuê tối đa "<u>c</u>" công nhân với giá "<u>p</u>" đồng trên 1 công nhân.<br>
 * Nếu ngày thứ "<u>i</u>" không thuê đủ "<u>k</u>" công nhân thì công ty sẽ thuê hết tất cả các<br>
 * công nhân có thể thuê. Công ty muốn tìm ra tổng số tiền bỏ ra thuê công nhân là ít nhất.<br>
 * <br>
 * Ví dụ:<br>
 * Với hire = [[2,5,3,1],[1,4,5,3],[1,1,5,1],[3,4,5,6]]<br>
 * và n=5 và k=5 thì Building(hire,n,k) = 35<br>
 * - Ngày 1: 5 * 1 = 5<br>
 * - Ngày 2: 3 * 1 + 2 * 3 = 9<br>
 * - Ngày 3: 3 * 1 + 2 * 3 = 9<br>
 * - Ngày 4: 3 * 1 + 2 * 3 = 9<br>
 * - Ngày 5: 3 * 1 = 3<br>
 * - Tổng số tiền phải trả : 35<br>
 */
public class Main001 {

    // Ngày 1: 5*1 = 5
    // Ngày 2: 3*1 + 2*3 = 9
    // Ngày 3: 3*1 + 2*3 = 9
    // Ngày 4: 3*1 + 2*3 = 9
    // Ngày 5: 3*1 +

//    private static int[][] hire = {{2,5,3,1} , {1,4,5,3} , {1,1,5,1} , {3,4,5,6}};
//    private static int[][] hire = {
//        {3,3,1,10} , {7,9,8,11} , {7,8,5,25} , {2,7,7,29},
//        {2,5,8,37} , {2,3,6,45} , {2,4,7,56} , {8,8,10,63},
//        {9,10,10,68} , {5,10,1,80}
//    };

    private static int[][] hire = {{7,8,2,2},{7,8,1,4},{7,8,4,28},{1,5,1,52},{5,5,2,53},{2,9,1,67},{6,10,1,80},{5,8,5,80},{8,10,5,92},{6,7,9,99}};

    private static int iStartDay = 0, iEndDay = 1, iWorker = 2, iPrice = 3;
    private static int maxDay = 10;
    private static int maxWorker = 20;
    private static int amount = 0;



    public static void main(String[] args) {

        int day = 1;

        while(day <= maxDay ){
            System.out.println("day: " +day);
            int[][] arrCompanies = getCompaniesByDay(hire, day);

            int[][] arrSorted = sortBy_ASC(arrCompanies, iPrice);
            for(int[] arrSub : arrSorted){
                for(int n : arrSub) System.out.print(n + " ");
                System.out.println("==================== line: 55");
            }


            int countWorker = 0;
            int needWorker = 0;
            if(arrSorted.length != 0) {
                for (int i = 0; i < arrSorted.length; i++) {

                    if (arrSorted[i][iWorker] >= maxWorker && countWorker == 0) {
                        amount += maxWorker * arrSorted[i][iPrice];
                        break;
                    }
                    if (arrSorted[i][iWorker] < maxWorker && countWorker == 0) {
                        amount += arrSorted[i][iWorker] * arrSorted[i][iPrice];
                        countWorker = arrSorted[i][iWorker];
                        needWorker = maxWorker - countWorker;
                        continue;
                    }
                    if (arrSorted[i][iWorker] >= needWorker && countWorker > 0) {
                        amount += needWorker * arrSorted[i][iPrice];
                        break;
                    }
                    if (arrSorted[i][iWorker] < needWorker && countWorker > 0) {
                        amount += arrSorted[i][iWorker] * arrSorted[i][iPrice];
                        needWorker -= arrSorted[i][iWorker];
                    }
                }
            }

            System.out.println("amount: " +amount+ " ============ line: 85");

            day++;
        }

        System.out.println("\n================================");
        System.out.println("amount: " +amount+ " ============ line: 91");

    }

    /**
     * Lấy danh sách các công ty có thể cho thuê theo ngày thứ x<br>
     * ví dụ:<br>
     *  - Lấy danh danh sách các cty có thể cho thuê ngày thứ 1<br>
     *  - Lấy danh danh sách các cty có thể cho thuê ngày thứ 2<br>
     *  - v.v...
     */
    public static int[][] getCompaniesByDay(int[][] hire, int day){
        List list = new ArrayList();
        for(int i = 0 ; i < hire.length ; i++){
            if(hire[i][iStartDay] <= day && hire[i][iEndDay] >= day){
                list.add(hire[i]);
            }
        }

        return MyUtilities.toNestedIntArray(list);
    }

    private static int[][] sortBy_ASC(int[][] hire, int index){
        int[] tmp = new int[1];
        int[][] result = hire;

        for(int i = 0 ; i < result.length-1 ; i++){
            for(int j = 0; j < result.length - 1 - i; j++){
                if(result[j][index] > result[j+1][index]){
                    tmp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = tmp;
                }
            }
        }
        return result;
    }



}

































