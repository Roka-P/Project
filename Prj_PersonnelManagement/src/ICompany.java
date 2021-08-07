public interface ICompany {
	//입력
	public void loadEmployeeData(); // 직원정보 불러오기 메서드
	public void insertEmployeeData(); // 직원정보 추가 메서드
	public void deleteEmployeeData(); // 직원정보 삭제 메서드
	public void updateEmployeeData(); // 특정 직원의 직급, 기본급, 수당 외 직원정보 최신화 수정 메서드
    
    //출력
	public void CheckBirthDay(); //생일 1주일 전 확인 메서드
    public void printEmployeeData(); // 이름 값으로 해당 값을 가진 직원 찾기 & 해당 값 출력 메서드
	public void saveEmployeeData(); // 직원정보 외부저장 메서드
    public void printEmployeeList(); // 모든 직원의 간략정보 출력 메서드
}