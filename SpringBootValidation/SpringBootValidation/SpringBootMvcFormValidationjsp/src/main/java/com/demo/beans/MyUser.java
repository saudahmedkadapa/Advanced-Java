package com.demo.beans;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="userdata")
public class MyUser {
	@Size(min=3,max=50)
	@Id
	private String name;
	
	@NotBlank
	@Email(message="pls enter valid email address")
	private String email;
	
	@NotBlank
	private String gender;
	
	@NotBlank
	private String profession;
	
	@Size(max=100)
	private String note;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date birthday;
	
	@AssertTrue
	private boolean married;
	
	@Min(value=20_000)
	@Max(value=300_000)
	private long income;

	public MyUser() {
		super();
		System.out.println("in default myuser constructor");
	}

	public MyUser(@Size(min = 3, max = 50) String name,
			@NotBlank @Email(message = "pls enter valid email address") String email, @NotBlank String gender,
			@NotBlank String profession, @Size(max = 100) String note, Date birthday, @AssertTrue boolean married,
			@Min(20000) @Max(300000) long income) {
		super();
		System.out.println("in paramterised  myuser constructor");
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.profession = profession;
		this.note = note;
		this.birthday = birthday;
		this.married = married;
		this.income = income;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("in name setter method");
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("in email setter method");
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		System.out.println("in gender setter method");
		this.gender = gender;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		System.out.println("in profession setter method");
		this.profession = profession;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		System.out.println("in note setter method");
		this.note = note;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		System.out.println("in birthday setter method");
		this.birthday = birthday;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		System.out.println("in married setter method");
		this.married = married;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		System.out.println("in income setter method");
		this.income = income;
	}

	@Override
	public String toString() {
		return "MyUser [name=" + name + ", email=" + email + ", gender=" + gender + ", profession=" + profession
				+ ", note=" + note + ", birthday=" + birthday + ", married=" + married + ", income=" + income + "]";
	}
	
	
	

}
