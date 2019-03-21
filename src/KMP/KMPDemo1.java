package KMP;

/**
 * @author zjq
 * @data 2019-03-21-15:53
 */
public class KMPDemo1 {
    static String T = "abcabx";
    static String S = "abcabdabcabx";
    static int[] next = new int[T.length()];
    public static void main(String[] args){
//       getNext(T,next);
//        for(int i : next)
//            System.out.println(i);
        int result = indexKMP();
        System.out.println(result);
    }

    public static void getNext(String T, int[] next) {
        int i = 0;
        int j = -1;
        next[0] = -1;

        while (i < T.length()-1) {
            if (j == -1 || T.charAt(i) == T.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    public static int indexKMP(){
        int i = 0, j = 0;
        getNext(T,next);
        while(i<S.length() && j<T.length()){
            if(j == 0 || S.charAt(i) == T.charAt(j)){
                i++;
                j++;
            }
            else{
                j = next[j];
            }
        }
        if(j == T.length())
            return i-j+1;
        else
            return -1;
    }
}
