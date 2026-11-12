public class Assignment01Q01 {
    public static void main(String[] args) {
        int lenArgs = args.length;
        for (int i = 0; i < lenArgs; i++) {
            if(args[i].charAt(0)%5==0){
                System.out.println(args[i].charAt(0));
            }
        }
    }
}
