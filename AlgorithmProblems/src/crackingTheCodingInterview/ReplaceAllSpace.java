/**
 * Created by elblonko on 1/7/15.
 */
public class ReplaceAllSpace {

    public static String ReplaceWithPecent20(String param){
        StringBuffer ret = new StringBuffer();

        char[] arrC = param.toCharArray();
        for(char c : arrC){
            if ( c == ' '){
                ret.append("%20");
            }
            else{
                ret.append(c);
            }
        }

        return ret.toString();
    }

    public static void main(String[] args) {

        String tester = " I Like Cookies do You";
        String testRet = ReplaceWithPecent20(tester);
        System.out.println(testRet);
    }
}
