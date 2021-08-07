import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Calendar;

public class PersonnelManagementService implements ICompany{
	
	private static final int THIS_YEAR = 121;

	static Scanner scan = new Scanner(System.in);
	
	static ArrayList<Employee> empList = new ArrayList<Employee>();
	
	Employee emp = new Employee();
	
	@Override
	public void loadEmployeeData() { //외부 CSV파일 불러오기 메서드
		String fileName = "employee.csv";
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			empList = (ArrayList<Employee>) ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e){
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			if(ois != null)
				try {ois.close();} catch (IOException e) {}
		}
	}

	@Override
	public void saveEmployeeData() { //CSV파일로 저장하기 메서드
		String fileName = "employee.csv";
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(empList);
			System.out.println("고객 데이터가 저장됐습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e){
			System.out.println(e.getMessage());
		} finally {
			if(oos != null)
				try {oos.close();} catch (IOException e) {}
		}
	}

	@Override
	public void insertEmployeeData() {
		Employee emp = new Employee();
		
        try {//입력받는 타입이 다르면 예외처리를 해주기위해 try-catch문 사용
        	// Scanner로 입력받은 값을 각 setXXX 메서드를 이용해서 넣어주기
        	System.out.println("등록할 직원의 사번을 입력하세요 : ");
        	String empNo = scan.next(); emp.setEmpNo(empNo); // 사번 중복 안되게 처리해줘야 함
            System.out.print("성명을 입력하세요 : ");
            String name = scan.next(); emp.setName(name);
            System.out.print("부서를 입력하세요 : ");
            String part = scan.next(); emp.setPart(part);
            System.out.print("직급을 입력하세요 : ");
            String rank = scan.next(); emp.setRank(rank);
            System.out.print("주민등록번호를 입력하세요('-'제외): ");
    		String personalNo  = scan.next(); emp.setPersonalNo(personalNo);
            System.out.print("주소를 입력하세요 : ");
            String adress = scan.next(); emp.setAdress(adress);
    		System.out.print("이메일을 입력하세요 : ");
    		String email = scan.next(); emp.setEmail(email);
    		// 주민번호를 이용하여 나이 및 성별 확인
    		String gender = (Integer.parseInt(personalNo.substring(6,7))%2 == 1)? "남" : "여"; //3항 연산자 이용
    		emp.setGender(gender);
    		int age = THIS_YEAR- Integer.parseInt(personalNo.substring(0, 2)) + 1 ; // 올해년도 구하는 메서드 필요   		
    		emp.setAge(age);
    		//
    		System.out.print("등록할 직원의 기본급을 입력하세요(만원) : ");
            int normal = scan.nextInt(); emp.setNormal(normal);
            System.out.print("등록할 직원의 수당을 입력하세요(만원) : ");
            int extrapay = scan.nextInt(); emp.setExtrapay(extrapay);
            //Scanner로 입력받은 Normal, Extrapay값을 이용해서 Tax값 넣어주기
            double tax = 0;
            if ((emp.getNormal() + emp.getExtrapay()) <= 200) {
                emp.setTax(0.01);
                tax = 0.01;
            } else if ((emp.getNormal() + emp.getExtrapay()) <= 400) {
            	emp.setTax(0.02);
            	tax = 0.02;
            } else if ((emp.getNormal() + emp.getExtrapay()) > 400) {
            	emp.setTax(0.03);
            	tax = 0.03;
            }
            emp.setTax(tax);
            // Normal, Extrapay, Tax값을 이용해서 Salary값 넣어주기
            double salary = (emp.getNormal() + emp.getExtrapay()) - (((emp.getNormal() + emp.getExtrapay()) * emp.getTax()));
            emp.setSalary(salary);
 
            // 설정한 값들을 ArrayList에 저장
            empList.add(emp);
        }
        catch (InputMismatchException e) {
            System.out.println("문자를 입력하세요."); // 잘못입력된 값 비워주기
            scan.nextLine();
        }
	}

	@Override
	public void deleteEmployeeData() {
		try {
            if (empList.size() == 0) {
                throw new IndexOutOfBoundsException("저장되있는 직원 정보가 없습니다.");
                }
            	try {
            		System.out.print("찾으려는 직원의 사번을 입력하세요 : ");
            		 	String empNo = scan.next();
            	        for (int i = 0; i < empList.size(); i++) {
            	            // ArrayList에 저장되있는 값들의 empNo을 불러오기
            	            emp = empList.get(i);
            	            emp.getEmpNo();
            	            
            	            // ArrayList의 empNo와 입력한 empNo가 같으면
            	            // 그 empNo 열 삭제
            	            if (empNo.equals(emp.getEmpNo())) {
            	        		empList.remove(i);
            	        		}
            	            }
            	        } catch (InputMismatchException e) {
            	        	 scan.nextLine();
            	             System.out.println("문자를 입력하세요.");
            	        }
            	} catch (IndexOutOfBoundsException e) {
            		System.out.println(e.getMessage());
            		}	
		}

	@Override
	public void updateEmployeeData() {
		try {
			if (empList.size() == 0) {
				throw new IndexOutOfBoundsException("저장되있는 직원 정보가 없습니다.");
				}
			try {
				System.out.print("찾으려는 직원의 사번을 입력하세요 : ");
				String empNo = scan.next();
				for (int i = 0; i < empList.size(); i++) {
        	        // ArrayList에 저장되있는 값들의 empNo을 불러오기
					emp = empList.get(i);
					emp.getEmpNo();
					
    	            // ArrayList의 empNo와 입력한 empNo가 같으면
    	            // 그 empNo의 정보를 불러와서 분류별 수정 가능
    	            if (empNo.equals(emp.getEmpNo())) {
    	            	System.out.println(emp.getEmpNo() + " "  
    	            			+ emp.getName() +"님이 선택되었습니다.");
    	            	System.out.println("원하시는 작업을 선택해주세요 : ");
    	            	System.out.println("1.개인정보\t2.직원정보");
    	            	int key = scan.nextInt();
    	                 
    	                 // 원하는 case문을 사용하기 위해 입력받은 key값 넣어주기
    	                switch(key) {
    	                 case 1: // 개인정보
    	                	System.out.println("=-=-=-=-=UPDATE EMPLOYEE INFO=-=-=-=-=");
    	             		System.out.println("성명 (" + emp.getName() + ") : ");
    	             		emp.setName(scan.next());
    	             		System.out.println("주민등록번호 (" + emp.getPersonalNo() + ") : ");
    	             		emp.setPersonalNo(scan.next());
    	             		System.out.println("주소 (" + emp.getAdress() + ") : ");
    	             		emp.setAdress(scan.next());
    	             		System.out.println("이메일 (" + emp.getEmail() + ") : ");
    	             		emp.setEmail(scan.next());
    	            		String gender = (Integer.parseInt(emp.getPersonalNo().substring(6,7))%2 == 1)? "남" : "여"; // 여기 적용이 안됨
    	            		emp.setGender(gender);
    	            		int age = THIS_YEAR- Integer.parseInt(emp.getPersonalNo().substring(0, 2)) + 1 ; 		
    	            		emp.setAge(age);
    	             		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    	                    break;
    	                    
    	                 case 2: // 급여정보
    	                	System.out.println("=-=-=-=-=UPDATE EMPLOYEE INFO=-=-=-=-=");
     	             		System.out.println("부서 (" + emp.getPart() + ") : ");
     	             		emp.setPart(scan.next());
    	                	System.out.println("직급 (" + emp.getRank() + ") : ");
     	             		emp.setRank(scan.next());
     	             		System.out.println("기본급 (" + emp.getNormal() + ") : ");
     	             		emp.setNormal(scan.nextInt());
     	             		System.out.println("추가수당 (" + emp.getExtrapay() + ") : ");
     	             		emp.setExtrapay(scan.nextInt());
     	             		double tax = 0;
	     	             	if ((emp.getNormal() + emp.getExtrapay()) <= 200) {
	     	                     emp.setTax(0.01);
	     	                     tax = 0.01;
	     	                } else if ((emp.getNormal() + emp.getExtrapay()) <= 400) {
	     	                 	emp.setTax(0.02);
	     	                	tax = 0.02;
	     	                } else if ((emp.getNormal() + emp.getExtrapay()) > 400) {
	     	                 	emp.setTax(0.03);
	     	                  	tax = 0.03;
	     	                }
	     	                 emp.setTax(tax);
	     	                 // Normal, Extrapay, Tax값을 이용해서 Salary값 넣어주기
	     	                 double salary = (emp.getNormal() + emp.getExtrapay()) - (((emp.getNormal() + emp.getExtrapay()) * emp.getTax()));
	     	                 emp.setSalary(salary);
	     	                 }
     	             		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    	                }
					} 
			} catch (InputMismatchException e) {
    	        	scan.nextLine();
	                System.out.println("문자를 입력하세요.");
        	        }
			} catch (IndexOutOfBoundsException e) {
        		System.out.println(e.getMessage());
        		}	
		}

	@Override
	public void printEmployeeData() {
        try {
            if (empList.size() == 0) {
                throw new IndexOutOfBoundsException("저장되있는 직원 정보가 없습니다.");
                }
            	try {
            		System.out.print("찾으려는 직원의 사번을 입력하세요 : ");
    				String empNo = scan.next();
    				for (int i = 0; i < empList.size(); i++) {
            	            // ArrayList에 저장되있는 값들의 empNo을 불러오기
    					emp = empList.get(i);
    					emp.getEmpNo();
            	            
        	            // ArrayList의 empNo와 입력한 empNo가 같으면
        	            // 그 empNo의 정보를 불러와서 분류별 수정 가능
        	            if (empNo.equals(emp.getEmpNo()))  {
            	        		System.out.println("=-=-=-=-=-=-=EMPLOYEE INFO=-=-=-=-=-=-=");
            	        		System.out.printf("부서 : %s\t직급 : %s\t사번 : %s\n ", emp.getPart(), emp.getRank(), emp.getEmpNo());
            	        		System.out.printf("이름 : %s\t나이 : %d\t성별 : %s\n", emp.getName(), emp.getAge(), emp.getGender());
            	        		System.out.printf("주민등록번호 : %s\t주소 : %s\n이메일 : %s\n", emp.getPersonalNo(), emp.getAdress(), emp.getEmail());        		
            	        		System.out.printf("기본급 : %d\t수당 : %d\t월급 : %.1f만원\n", emp.getNormal(), emp.getExtrapay(), emp.getSalary());
            	        		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            	        		}
            	            }
            	        } catch (InputMismatchException e) {
            	        	 scan.nextLine();
            	        	 System.out.println("문자를 입력하세요.");
            	        }
            	} catch (IndexOutOfBoundsException e) {
            		System.out.println(e.getMessage());
            		}
        }

	@Override
	public void CheckBirthDay() {
		// 귀찮아...
		
	}

	@Override
	public void printEmployeeList() { // ArrayList에 저장된 모든 객체 출력해서 보여주기
        try {
            if (empList.size() == 0) {
                throw new IndexOutOfBoundsException("저장되있는 직원 정보가 없습니다.");
                }
            System.out.printf("\n[INFO]총 직원 수: %d\n", empList.size());
            System.out.println("사번\t부서\t직급\t성명\t성별\t");
        	System.out.println("------------------------------------");
            for (int i = 0; i < empList.size(); i++) {
            	emp = empList.get(i);
            	System.out.printf("%s\t%s\t%s\t%s\t%s\n",
            			emp.getEmpNo(),emp.getPart(),emp.getRank(),emp.getName(),emp.getGender());
            	}
        } catch (IndexOutOfBoundsException e) {
        	System.out.println(e.getMessage());
        	}
        }
}
