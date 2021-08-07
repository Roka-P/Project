import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = -4205785232581803172L;
	
	private String empNo,part, rank, name, gender, PersonalNo, adress, email; 
	// 부서, 직급, 성명, 성별, 주민번호, 주소, 이메일
	private int age, normal, extrapay; //나이, 기본급, 수당
	private double tax, salary; // 세금, 월급

	
	
	public String getEmpNo() {
		return empNo;
	}

	
	
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	
	
	public String getPart() {
		return part;
	}

	
	
	public void setPart(String part) {
		this.part = part;
	}



	public String getRank() {
		return rank;
	}



	public void setRank(String rank) {
		this.rank = rank;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getPersonalNo() {
		return PersonalNo;
	}



	public void setPersonalNo(String personalNo) {
		PersonalNo = personalNo;
	}



	public String getAdress() {
		return adress;
	}



	public void setAdress(String adress) {
		this.adress = adress;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public int getNormal() {
		return normal;
	}



	public void setNormal(int normal) {
		this.normal = normal;
	}



	public int getExtrapay() {
		return extrapay;
	}



	public void setExtrapay(int extrapay) {
		this.extrapay = extrapay;
	}



	public double getTax() {
		return tax;
	}



	public void setTax(double tax) {
		this.tax = tax;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	@Override
	public String toString() { //출력 확인용 메서드
		return "Employee\n 부서 : " + part + ", 직급 : " + rank + ", 사번 : " + empNo 
				+ ", 성명 : " + name + ", 성별 : " + gender + ", 연령 : " + age
				+ ", 주민등록번호 : " + PersonalNo + ", 주소 : " + adress 
				+ ", 이메일 : " + email + ", 기본급 : " + normal
				+ "만원, 추가수당 : " + extrapay + "만원, 세율 : " + tax 
				+ "만원, 월급 : " + salary + "만원";
		}



	public String toCSV() { // CSV파일로 내보내기 위한 메서드
		return part + ", " + rank + ", " + empNo + ", " + name + ", " + gender 
				+ ", " + age + ", " + PersonalNo + ", " + adress 
				+ ", " + email + ", " + normal+ ", " + extrapay 
				+ ", " + tax + ", " + salary;
	}
}
