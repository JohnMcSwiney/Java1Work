
import java.util.*;
public class GroupAssign1 {
    public static void main (String [] args) {
        Scanner in = new Scanner (System.in);
        
        String line1 = "-------------------------------------------------------------";
        String line2 = "-----------";
        String space = " ";
        
        double zero = 0;
        double tHun = 200;
        double eHun = 800;
        double thHun = 300;
        String moni = "$";
        
        String yes = "Yes";
        String no = "No" ;
        
        
        //System.out.println("What is traveler name? [Last First Initial]");
        String name = in.nextLine();
        Scanner fromStr = new Scanner(name);
        
        String lName = fromStr.next();
        String fName = fromStr.next();
        String mName = fromStr.next();
        
        //System.out.println("What was the length of your trip? " );
        double tripL = in.nextDouble();
        
        //System.out.println("What is the value of imported goods? ");
        double goodP = in.nextDouble();
        
        System.out.println("Traveller's name (last, first, initials): " + lName + ", " + fName + ", " + mName + ".");
        System.out.printf("Length of absence (# of days): %.1f \n" , tripL);
        System.out.printf("Total amount of imported goods ($ CAD): %.0f " , goodP);
        
        System.out.println( space );
        
        System.out.println("Import Exemption Report for " + fName + " " + mName + ". " + lName );
        
        System.out.println( line1 );
        
        String l1 = "Absence Period (days)";
        String l2 = "...Maximum Personal exemption";
        String l3 = "...Include Limited Alcohol & Tobacco?";
        String l4 = "Usable Personal Exeption";
        String l5 = "Amount Subject to Special Duty & Taxes";
        String l6 = "Amount Subject to Regular Duty & Taxes";
        String l7 = "Total Amount of Imported Goods";
    
        if( tripL <= 1){
            System.out.printf("%s" + "%30.1f\n", l1, tripL);
            System.out.printf("%s" + "%18s" + "%.2f\n", l2, moni, zero);
            System.out.printf("%s" + "%14s\n", l3, no);
            //first bit of output
            System.out.printf("%s" + "%33s" + "%.2f\n",l4, moni, zero );
            System.out.printf("%s" + "%19s" + "%.2f\n",l5, moni, zero );
            System.out.printf("%s" + "%18s" + "%.2f\n",l6, moni, goodP );
            //second bit of output
            System.out.printf("%61s\n", line2);
            //total
            System.out.printf("%s" + "%26s" + "%.2f\n", l7, moni, goodP);
            
            System.out.println( line1 );
            System.out.println( space );
            
        }else if (tripL > 1.01 && tripL <= 1.9 ){
            System.out.printf("%s" + "%30.1f\n", l1, tripL);
            System.out.printf("%s" + "%16s" + "%.2f\n", l2, moni, tHun);
            System.out.printf("%s" + "%14s\n", l3, no);
            //first bit of output
            if (goodP > 200 ) {
                //if it's greater than 200 and been less than or two days then this runs
                System.out.printf("%s" + "%33s" + "%.2f\n",l4, moni, zero );
                
                System.out.printf("%s" + "%19s" + "%.2f\n",l5, moni, zero );
                
                System.out.printf("%s" + "%17s" + "%.2f\n",l6, moni, goodP );
                
                System.out.printf("%61s\n", line2);
                //total
                System.out.printf("%s" + "%25s" + "%.2f\n", l7, moni, goodP);
            
                System.out.println( line1 );
                System.out.println( space );
            }
            if (goodP <= 200) {
                //if it's less than 200 and less than 2 days this runs
                
                
                System.out.printf("%s" + "%31s" + "%.2f\n",l4, moni, goodP );
                
                System.out.printf("%s" + "%19s" + "%.2f\n",l5, moni, zero );
                
                System.out.printf("%s" + "%19s" + "%.2f\n",l6, moni, zero ); 
                
                System.out.printf("%61s\n", line2);
                //total
                System.out.printf("%s" + "%25s" + "%.2f\n", l7, moni, goodP);
            
                System.out.println( line1 );
                System.out.println( space );
            }
            
            
        }else if (tripL >= 2 ) {
            System.out.printf("%s" + "%30.1f\n", l1, tripL);
            System.out.printf("%s" + "%16s" + "%.2f\n", l2, moni, eHun);
            System.out.printf("%s" + "%14s\n", l3, yes);
            //first bit of output
            if (goodP <= 800 ){
                System.out.printf("%s" + "%31s" + "%.2f\n",l4, moni, goodP );
                
                System.out.printf("%s" + "%19s" + "%.2f\n",l5, moni, zero );
                
                System.out.printf("%s" + "%19s" + "%.2f\n",l6, moni, zero );
                
                System.out.printf("%61s\n", line2);
                //total
                System.out.printf("%s" + "%25s" + "%.2f\n", l7, moni, goodP);
            
                System.out.println( line1 );
                System.out.println( space );
            }
            if (goodP > 800)
            {
                double temp2 = goodP - 800;
                if( temp2 > 300){
                    double temp3 = temp2 - 300;
                    
                    System.out.println( "temp3" + temp3 ); //get rid of later
                    //change temps and other variables to meaningful names later as well
                    
                    //print l4 + eHun, l5 + thHun, l6 + temp3
                    System.out.printf("%s" + "%30s" + "%.2f\n",l4, moni, goodP );
                
                    System.out.printf("%s" + "%19s" + "%.2f\n",l5, moni, zero );
                
                    System.out.printf("%s" + "%19s" + "%.2f\n",l6, moni, zero );
                    
                    System.out.printf("%61s\n", line2);
                    //total
                    System.out.printf("%s" + "%24s" + "%.2f\n", l7, moni, goodP);
            
                    System.out.println( line1 );
                    System.out.println( space );
                }
            }    
        }
        }   
    }

