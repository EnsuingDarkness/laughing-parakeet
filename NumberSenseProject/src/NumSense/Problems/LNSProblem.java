package NumSense.Problems;

public class LNSProblem implements Problem{
    private int left;
    private int right;
    private int answer;

    public LNSProblem(){
        resetProblem();
    }


    @Override
    public String getName() {
        return "Large Number Subtraction";
    }

    @Override
    public int getTime() {
        return 10;
    }

    @Override
    public void resetProblem() {
        left = (int) (((int) (Math.random() * 10) * 1000) + (Math.random() * 10));
        right = (int) (((int) (Math.random() * 10) * 1000) + (Math.random() * 10));
        answer = left - right;
    }

    @Override
    public String getAnswer() {
        return Integer.toString(answer);
    }

    @Override
    public boolean checkAnswer(String input) {
        return input != null && !(input.equals("") || input.equals("-")) && Integer.parseInt(input) == answer;
    }

    public String toString(){
        return left + " - " + right + " = " + " ____ ";
    }
}
