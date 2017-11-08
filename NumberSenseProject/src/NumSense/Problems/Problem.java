package NumSense.Problems;

public interface Problem {


    public String getName();
    public int getTime();
    public void resetProblem();
    public String getAnswer();
    public boolean checkAnswer(String input);

    public String toString();



}
