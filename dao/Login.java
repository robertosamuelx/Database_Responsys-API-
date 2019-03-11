package dao;

public class Login {

	private LoginOracle oracle;
	private LoginResponsys responsys;
	
	public LoginResponsys getResponsys() {
		return responsys;
	}
	public void setResponsys(LoginResponsys responsys) {
		this.responsys = responsys;
	}
	public LoginOracle getOracle() {
		return oracle;
	}
	public void setOracle(LoginOracle oracle) {
		this.oracle = oracle;
	}
}
