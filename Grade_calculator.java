import java.util.*;

class Grade_calculator {
    protected Map<String, Double> marks = new HashMap<>();
    protected double totalMarks = 0.0;
    protected int subCount = 0;

    void getMarks() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Subjects: ");
        try{
            subCount = sc.nextInt();
        }catch(Exception e){
            System.out.println("Invalid Number");
            System.exit(1);;
        }
        
        for(int i=0; i<subCount;i++){
            System.out.print("Enter the name of subject " + (i+1) + ": ");
            sc.nextLine();
            String sub = sc.nextLine();
            System.out.print("Enter the marks for subject "+(i+1) + ": ");
            try{
                double mark = sc.nextDouble();
                totalMarks += mark;
                marks.put(sub, mark);
            }catch(Exception e){
                System.out.println("Input is not a number!");
                System.exit(1);
            }
        }
        sc.close();
    }
    double getTotal(){
        return totalMarks;
    }
    int getSubCount(){
        return subCount;
    }

    public static void main(String[] args) {
        System.out.println("***************** Welcome to Grade Calculator *****************");

        Grade_calculator s1 = new Grade_calculator();
        s1.getMarks();

        double totalMarks = s1.getTotal();
        int subCount = s1.getSubCount();

        double avgPercentage = Double.parseDouble(String.format("%.2f", totalMarks/subCount));
        double grade = Double.parseDouble(String.format("%.1f", avgPercentage/10));

        System.out.println("Total Marks: "+totalMarks + "/"+100*subCount);
        System.out.println("Average Percentage: "+avgPercentage);
        System.out.println("Student Grade: "+grade);
        
    }
}