import java.util.Scanner;

public class StudentGrade {
    public static void calculate(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        int avg = sum / len;
        int maxMarks = len * 100; // Assuming each subject is out of 100
        double percentage = (sum / (double) maxMarks) * 100;
        System.out.println("Total: " + sum);
        
        System.out.println("Percentage: " + percentage +"%");
        if(percentage>=90){
            System.out.println("A+");
        } else if(percentage>=80){
            System.out.println("A");
        }
        else if(percentage>=70){
            System.out.println("B");
        }
        else if(percentage>=60){
            System.out.println("C");
        }
        else if(percentage>=50){
            System.out.println("D");
        }
        else if(percentage>=40){
            System.out.println("E");
        }
        else{
            System.out.println("F");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of subjects:");
        n = sc.nextInt();
        int[] Subject = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter your subject " + (i + 1) + " marks:");
            Subject[i] = sc.nextInt();
        }
        calculate(Subject);
        sc.close();
    }
}
