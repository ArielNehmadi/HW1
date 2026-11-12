public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;
        int lenArgs = Integer.parseInt(args[0]);
        double pran = 0;

        for(int i = 0; i<lenArgs; i++){
            pran += Math.pow(-1, i)*1/(1+2*i);
        }   
        approxPi = 4*pran;

        System.out.println(approxPi + " " + actualPi);
    }
}
