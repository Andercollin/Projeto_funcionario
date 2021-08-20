package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
				
		System.out.print("Digite o número de funcionários: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced? y/n ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hour = sc.nextInt();
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			
			if(ch == 'y') {
				System.out.print("Additional charge: ");
				Double additionalCharge = sc.nextDouble();
				Employee emp = new OutsourcedEmployee(name, hour, valuePerHour, additionalCharge);
				list.add(emp);
			}
			else {
				Employee emp = new Employee(name, hour, valuePerHour);
				list.add(emp);
			}			
		}
		for(Employee emp: list) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		}
		sc.close();
	}
}
