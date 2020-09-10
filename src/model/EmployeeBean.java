package model;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class EmployeeBean implements Serializable {

	// 引数のないコントストラクタ
	public EmployeeBean() {}

	// 格納するデータ変数
	// employee_infoテーブル
	private int employee_id;			//社員ID
	private String name;				//氏名
	private String name_hiragana;		//氏名(ふりがな)
	private String birthday;			//誕生日
	private String sex;					//性別
	private String mail_address;		//メールアドレス
	private String telephone_number;	//電話番号
	private int company_info_id;		//所属会社ID
	private String business_manager;	//担当管理営業
	private String department;			//事業部
	private String commissioning_status;	//稼働状況
	private String created_id;			//作成者ID
	private String modified_id;			//更新者ID
	// employee_stateテーブル
	private int employee_info_id;	//社員ID
	private String enter_date;			//入社日
	private String retire_date;			//退職日
	private String status;				//ステータス


	// 変数に対するgetter setter
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_hiragana() {
		return name_hiragana;
	}

	public void setName_hiragana(String name_hiragana) {
		this.name_hiragana = name_hiragana;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMail_address() {
		return mail_address;
	}

	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}

	public String getTelephone_number() {
		return telephone_number;
	}

	public void setTelephone_number(String telephone_number) {
		this.telephone_number = telephone_number;
	}

	public int getCompany_info_id() {
		return company_info_id;
	}

	public void setCompany_info_id(int company_info_id) {
		this.company_info_id = company_info_id;
	}

	public String getBusiness_manager() {
		return business_manager;
	}

	public void setBusiness_manager(String business_manager) {
		this.business_manager = business_manager;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCommissioning_status() {
		return commissioning_status;
	}

	public void setCommissioning_status(String commissioning_status) {
		this.commissioning_status = commissioning_status;
	}

	public String getCreated_id() {
		return created_id;
	}

	public void setCreated_id(String created_id) {
		this.created_id = created_id;
	}

	public String getModified_id() {
		return modified_id;
	}

	public void setModified_id(String modified_id) {
		this.modified_id = modified_id;
	}

	public int getEmployee_info_id() {
		return employee_info_id;
	}

	public void setEmployee_info_id(int employee_info_id) {
		this.employee_info_id = employee_info_id;
	}

	public String getEnter_date() {
		return enter_date;
	}

	public void setEnter_date(String enter_date) {
		this.enter_date = enter_date;
	}

	public String getRetire_date() {
		return retire_date;
	}

	public void setRetire_date(String retire_date) {
		this.retire_date = retire_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// コンストラクタ "request"で受けたパラメータを各セットする
	public EmployeeBean(HttpServletRequest request) {
		// employee_infoテーブル
		setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
		setName(request.getParameter("name"));
		setName_hiragana(request.getParameter("name_hiragana"));
		setBirthday(request.getParameter("birthday"));
		setSex(request.getParameter("sex"));
		setMail_address(request.getParameter("mail_address"));
		setTelephone_number(request.getParameter("telephone_number"));
		setCompany_info_id(Integer.parseInt(request.getParameter("company_info_id")));
		setBusiness_manager(request.getParameter("business_manager"));
		setDepartment(request.getParameter("department"));
		setCommissioning_status(request.getParameter("commissioning_status"));
		setCreated_id(request.getParameter("created_id"));
		setModified_id(request.getParameter("modified_id"));
		// employee_stateテーブル
		setEmployee_info_id(Integer.parseInt(request.getParameter("employee_info_id")));
		setEnter_date(request.getParameter("enter_date"));
		setRetire_date(request.getParameter("retire_date"));
		setStatus(request.getParameter("status"));
	}

}
