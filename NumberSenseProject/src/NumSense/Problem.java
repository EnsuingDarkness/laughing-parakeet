package NumSense;

public class Problem {

    private static String name, randomProblem;
    private static double problemDuration, randomAnswer;
    public static int problemid;
    public Problem(){
        setName("Default");
        setDuration(10.0);
        setProblem("ERROR");
        setAnswer(-1);
        problemid = -1;

    }

    public Problem(int i){
        generateProblemType(i);
    }

    private static void setName(String n){
        name = n;
    }
    public static String getName(){
        return name;
    }
    private static void setDuration(double d){
        problemDuration = d;
    }
    public static double getDuration(){
        return problemDuration;
    }
    private static void setProblem(String n){
        randomProblem = n;
    }
    public static String getProblem(){
        return randomProblem;
    }
    private static void setAnswer(double d){
        randomAnswer = d;
    }
    public static double getAnswer(){
        return randomAnswer;
    }
    private static void setid(int i){problemid = i;}
    public static int getid(){return problemid;}

    private void generateProblemType(int i){
        switch (i){
            case 0:
                setName("Adding Large Numbers");
                setDuration(10.0);
                break;
            case 1:
                setName("Subtracting Large Numbers");
                setDuration(10.0);
                break;
            default: break;
        }
        setid(i);
    }

    public static void generateNewProblem(int i){
        switch (i){
            case 0: ProblemGeneration.generateAddLargeNums(); break;
            case 1: ProblemGeneration.generateSubLargeNums(); break;
            default: break;
        }
        setProblem(ProblemGeneration.getProblemText());
        setAnswer(ProblemGeneration.getAnswer());
    }


}
