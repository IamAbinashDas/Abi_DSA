public class Q2 {//Binary to Decimal & Decimal to Binary
    public static void bintodec(int bin){
        int pow=0;
        int dec=0;
        int originalBin = bin;
    
        for(;bin>0;){
            int ld=bin%10;
            dec=dec+(ld*(int)Math.pow(2,pow));
            pow++;
            bin=bin/10;
        }
        System.out.println("decimal of "+originalBin+"="+dec);
    }
    
    public static void dectobin(int dec){
        int pow=0;
        int bin=0;
        int originaldec=dec;
        for(;dec>0;){
            int rem=dec%2;
            bin=bin+(rem*(int)Math.pow(10,pow));
            pow++;
            dec=dec/2;
        }
        System.out.println("binary of "+originaldec+"="+bin);
    }
    public static void main(){
        bintodec(111);
        dectobin(7);
    }
}
