package net.mzouabi.ng2.server.model;

import net.mzouabi.ng2.server.dto.PersonDTO;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Person extends AbstractEntity {

	private static final long serialVersionUID = -6321180910534044216L;

	String firstname;

	String lastname;

	Date dateOfBirth = new Date();

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Person(String firstname, String lastname, Date dateOfBirth) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
	}

	public Person() {
	}


	public int getAge() {

		Calendar today = Calendar.getInstance();
		Calendar birthDate = Calendar.getInstance();

		int age = 0;

		birthDate.setTime(getDateOfBirth());
		if (birthDate.after(today)) {
			throw new IllegalArgumentException("Can't be born in the future");
		}

		age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

		// If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year
		if ( (birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) ||
				(birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){
			age--;

			// If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
		}else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH )) &&
				(birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){
			age--;
		}

		return age;
	}
}
