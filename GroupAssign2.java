import java.util.*;
import java.io.*;

//Jack Eyre, Jeffery Saladio, Johnny McSwiney
//November 13th 2021
//Asks user for employee, and emplist file paths, as well as last and first name.
//Uses first and last name to search employee.csv to aquire employee ID#
//Uses employee ID# to get salary information
//Prints out a year of salary information gross net salary at the end

public class GroupAssign2 {
    //Main method gathers inputs and calls lookUpEmployeeID
    
    public static void main (String[] args) throws IOException{
        
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter employee filename (full path): ");
        String file1 = input.nextLine();
        System.out.print("Enter employee salary filename (full path): ");
        String file2 = input.nextLine();
        System.out.print("Enter employee last name: ");
        String Lasname = input.next();
        System.out.print("Enter employee first name: ");
        String Firname = input.next();
        System.out.printf("\n");
        
        String empID = lookUpEmployeeID(file1,Lasname,Firname);

        //Gives you this if you enter a name not in the employee list
        if (empID == null)
            System.out.println("No Employee information found for: "+Firname+" "+Lasname);
        
        else {
            System.out.println("Salary schedule for "+Firname.toUpperCase()+" "+Lasname.toUpperCase()+" ("+empID+")");
            printPaySchedule(empID,file2);
        }
    }

    //Searches file for employee ID# 
    public static String lookUpEmployeeID (String fileName, String lastName, String firstName) throws IOException{
        Scanner in = new Scanner(new File(fileName));
        in.useDelimiter(",|\n");
        
        String lines;
        
        in.nextLine();      

        
        while (in.hasNextLine())
        {
            
            lines = in.nextLine();

            
            String fileFirName = lines.split(",")[0];
            String fileLasName = lines.split(",")[1];

            if (lastName.equalsIgnoreCase(fileLasName) && firstName.equalsIgnoreCase(fileFirName))
                return lines.split(",")[3];
        }

        in.close();    

        return null;    
    }
    
    //Calculates and prints pay
    public static void printPaySchedule (String empID,String fileName) throws IOException{
        
        
        Scanner in = new Scanner(new File(fileName));
        
        in.useDelimiter(",|\n");
        
        String line;
        
        in.nextLine();

        while (in.hasNextLine()){
            line = in.nextLine();
            
            String fileEmpID = line.split(",")[0];

            
            if (fileEmpID.equals(empID)){
                
                double grosss = Double.parseDouble(line.split(",")[1]);
                
                double fedTaxx = Double.parseDouble(line.split(",")[2]);
                
                
                double AlBerTax = Double.parseDouble(line.split(",")[3]);
                
                double CPPi = Double.parseDouble(line.split(",")[4]);
                double EII = Double.parseDouble(line.split(",")[5]);

                
                double totalTaxx = fedTaxx+AlBerTax;
                double totalGrosss = 0.0, finalTotalTax = 0.0, totalCPP = 0.0, totalEI = 0.0, totalSalary = 0.0;

                
                System.out.printf("%14s %50s\n","Gross","Net"); 
                System.out.printf("%s %8s %12s %12s %12s %11s\n","Month","Salary","Tax","CPP","EI","Salary");
                System.out.println("-----------------------------------------------------------------");
                for (int i=1; i<=12; i++){
                    totalGrosss += grosss;
                    finalTotalTax += totalTaxx;
                    totalCPP += CPPi;
                    totalEI += EII;

                    if (totalCPP >= 3166.45) {
                        CPPi = Math.abs(CPPi - (totalCPP - 3166.45));
                        
                        totalCPP = 3166.45;
                    }
                    if (totalEI >= 889.54) {
                        EII = Math.abs(EII - (totalEI - 889.54));
                        totalEI = 889.54;
                    }

                    double Salary = grosss - (totalTaxx+CPPi+EII);
                    totalSalary += Salary;
                    
                    System.out.printf("%5d %8.2f %12.2f %12.2f %12.2f %11.2f\n",i,grosss,totalTaxx,CPPi,EII,Salary);
    
                } 
                System.out.println("-----------------------------------------------------------------");
                System.out.printf("Total %8.2f %12.2f %12.2f %12.2f %11.2f\n",totalGrosss,finalTotalTax,totalCPP,totalEI,totalSalary);
                break;
            }
        }
        in.close();    
        System.out.printf("\n");
        System.out.printf("\n");
    
    }
}