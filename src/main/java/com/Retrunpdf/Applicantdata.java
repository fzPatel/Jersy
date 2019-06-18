package com.Retrunpdf;
              
public class Applicantdata
{
    private String gender;

    private String isPrimaryApplicant;

    private String name;

    private String dateOfBirth;

    private String KYC2;

    private String KYC1;
    
    private String photoid;
    
    

    public String getGender ()
    {
        return gender;
    }

    public void setGender (String gender)
    {
        this.gender = gender;
    }

    public String getIsPrimaryApplicant ()
    {
        return isPrimaryApplicant;
    }

    public void setIsPrimaryApplicant (String isPrimaryApplicant)
    {
        this.isPrimaryApplicant = isPrimaryApplicant;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDateOfBirth ()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth (String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getKYC2 ()
    {
        return KYC2;
    }

    public void setKYC2 (String KYC2)
    {
        this.KYC2 = KYC2;
    }

    public String getKYC1 ()
    {
        return KYC1;
    }

    public void setKYC1 (String KYC1)
    {
        this.KYC1 = KYC1;
    }

    
    public String getPhotoid() {
		return photoid;
	}

	public void setPhotoid(String photoid) {
		this.photoid = photoid;
	}

	@Override
	public String toString() {
		return "Applicantdata [gender=" + gender + ", isPrimaryApplicant=" + isPrimaryApplicant + ", name=" + name
				+ ", dateOfBirth=" + dateOfBirth + ", KYC2=" + KYC2 + ", KYC1=" + KYC1 + ", photoid=" + photoid + "]";
	}


	
	
	
}
			