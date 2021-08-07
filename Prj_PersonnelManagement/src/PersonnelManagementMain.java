

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonnelManagementMain {

	static ArrayList<Employee> empList = new ArrayList<Employee>();
	
	static Scanner scan = new Scanner(System.in);
	static PersonnelManagementService pms = new PersonnelManagementService();
	
	
	public static void main(String[] args) {
		
		 pms.loadEmployeeData();
		
		while(true) {
			System.out.println("원하시는 작업을 선택하세요.");
			System.out.println("(I)nsert (L)ist (C)urrent (U)pdate (D)elete (S)ave (Q)uit");
			System.out.print("작업 선택: ");
			String menu = scan.next();
			menu = menu.toLowerCase();
			switch(menu.charAt(0)) {

			case 'i':
				System.out.println("직원정보 입력을 시작합니다.");
				pms.insertEmployeeData();
				System.out.println("직원정보 입력을 완료했습니다.");
				
				break;

			case 'c':
				System.out.println("현재 데이터를 출력합니다.");
				pms.printEmployeeData();
				break;
				
			case 'u':
				System.out.println("직원정보를 수정합니다.");
				pms.updateEmployeeData();
				break;

			case 'd':
				System.out.println("직원정보를 삭제합니다.");
				pms.deleteEmployeeData();
				break;
			
			case 'l':
				System.out.println("직원 목록을 출력합니다.");
				pms.printEmployeeList();
				break;
				
			case 's':
				System.out.println("직원정보를 저장합니다.");
				pms.saveEmployeeData();
				break;
				
			case 'q':
				System.out.println("프로그램을 종료합니다.");
				scan.close();
				System.exit(0);
				break;
				
			default :
				System.out.println("선택한 작업이 올바르지 않습니다. 다시 선택해주십시오.");
			}
		}
	}
}
