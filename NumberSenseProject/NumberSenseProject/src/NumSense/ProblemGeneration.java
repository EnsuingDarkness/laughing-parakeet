package NumSense;

public class ProblemGeneration {

    private static String problemText;
    private static double answer;

    private static void setText(String s){ problemText = s;}
    private static void setAnswer(int i ){answer = i;}
    public static String getProblemText(){return problemText;}
    public static double getAnswer(){return answer;}

    public static void generateAddLargeNums(){
        int num1 = (int) ((Math.random() * 9) + 1) * 1000;
        num1 += (int) ((Math.random() * 9) + 1) * (int) Math.pow(10, Math.random() * 2);
        int num2 = (int) ((Math.random() * 9) + 1) * 1000;
        num2 += (int) ((Math.random() * 9) + 1) * (int) Math.pow(10, Math.random() * 2);
        setText(num1 + " + " + num2 + " = ");
        setAnswer(num1 + num2);
    }
    public static void generateSubLargeNums(){
        int num1 = ((int)(Math.random() * 9) + 1) * 1000;
        num1 +=  ((int) (Math.random() * 9) + 1) * (int) Math.pow(10, Math.random() * 2);
        int num2 =  ((int) (Math.random() * 5) + 1) * 1000;
        num2 +=  ((int) (Math.random() * 7) + 1) * (int) Math.pow(10, Math.random() * 2);
        setText(num1 + " - " + num2 + " = ");
        setAnswer(num1 - num2);
    }

    public static void generateAddPropFrac(){
        int num1 = (int)(Math.random() * 9) + 1;
        int dem1 = num1 + (int) ((Math.random() * 9) + 1);
    }

}
