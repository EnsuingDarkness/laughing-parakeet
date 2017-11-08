package NumSense.Problems;


public class LNAProblem implements Problem{
    private int left;
    private int right;
    private int answer;

    public LNAProblem(){
        resetProblem();
    }

    @Override
    public String getName() {
        return "Large Number Addition";
    }

    @Override
    public int getTime() {
        return 10;
    }

    @Override
    public void resetProblem() {
        left = ((int) (Math.random()*10000));
        right = ((int) (Math.random()*10000));
        answer = left + right;
    }

    @Override
    public String getAnswer() {
        return Integer.toString(answer);
    }

    @Override
    public boolean checkAnswer(String input) {
        if(input == null || input.equals("")) return false;
        return Integer.parseInt(input) == answer;
    }

    public String toString(){
        return left + " + " + right + " = " + " ____ ";
    }
}
