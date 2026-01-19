package Q2;

import java.util.Scanner;

public class Date {
    private int day;
    private int month;
    private int year;
    
    public Date() {
    	 this.day=1;
    	 this.month=1;
    	 this.year=2000;
    }
    
    public Date(int day,int month,int year) {
    	this.day=day;
    	this.month=month;
    	this.year=year;
    }
    
    public Date(Date date) {
    	   this(date.day,date.month,date.year);
    }
    
    public void input() {
    	 Scanner sc=new Scanner(System.in);
    	 System.out.println("Enter day: ");
    	 this.day=sc.nextInt();
    	 System.out.println("Enter month: ");
    	 this.month=sc.nextInt();
    	 System.out.println("Enter year: ");
    	 this.year=sc.nextInt();
    	 sc.close();
    }
    
    public void print() {
    	 System.out.println("Day: "+day);
    	 System.out.println("Month: "+month);
    	 System.out.println("Year: "+year);
    }
    
    @Override
    public String toString() {
    	return this.day+"-"+this.month+"-"+this.year;
    }
}
