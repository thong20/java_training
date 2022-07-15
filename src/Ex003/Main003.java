package Ex003;

public class Main003 {
    public static void main(String[] args) {
        // Rút gọn phân số

        simplifyComplexFractions(1080, 1920);
    }

    private static void simplifyComplexFractions(int x, int y) {
        int primeNumber = biggestPrimeNumber(x, y);
        x = x/primeNumber;
        y = y/primeNumber;

        if(y == 1){
            System.out.println("result: " + x);
        }else{
            if(y < 0){
                y *= -1;
                x *= -1;
            }
            System.out.println("result: " +x +":" +y);
        }

    }

    // Tìm USCLN
    // Thuật toán:
    // - Nếu a chia hết cho b thì b là USCLN
    // - Ngược lại, ta tìm số dư của tử/mẫu, sau đó
    // ta lấy cả tử và mẫu chia cho số dư này, ví dụ:
    // ta có phân số: 16/12
    // => Số dư là: 16/12 = 4
    // => phân số rút gọn là:
    // 16/4 = 4
    // 12/4 = 3
    // => kết quả là: 4/3
    private static int biggestPrimeNumber(int a, int b){
        if(a%b == 0) return b;
        else return biggestPrimeNumber(b, a%b);
    }

    // Kiểm tra số Nguyên tố
    // Thuật toán: cho i chạy từ 2 đến n-1
    // Nếu n chia hết cho i thì n không phải là số Nguyên tố
    private static boolean isPrimmeNumber(int n){

        for(int i = 2 ; i <= n - 1 ; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

}
