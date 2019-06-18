package com.learn.jersey.Masters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.net.ssl.SSLEngineResult.Status;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.learn.jersey.Master.Db.DBConn;
import com.learn.jersey.Masters.Exception.DataBaseExeption;
import com.learn.jersy.Exception.ErrorMessage;

public class MlMasterDaoImpl {

	DBConn dbConn;
	PreparedStatement prepareStatement;

	public GenderDataAr getGenderData() throws DataBaseExeption {
		ArrayList<GenderData> genderData = new ArrayList<GenderData>();
		GenderDataAr genderDataAr = new GenderDataAr();
		try {
			System.out.println(" inside GendderDataDaoImpl");
			String query = "select * from TBL_Gender";

			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				GenderData genderDataObj = new GenderData();

				genderDataObj.setId(result.getString("ID"));
				genderDataObj.setGender(result.getString("Gender"));
				genderData.add(genderDataObj);
			}

			genderDataAr.setGenderData(genderData);

		} catch (Exception e) {

			throw new com.learn.jersey.Masters.Exception.DataBaseExeption("Db Connection Error");
		}

		return genderDataAr;

	}

	public LdGridAr loanDetailGrid() throws DataBaseExeption {

		ArrayList<LdGrid> ldGrid = new ArrayList<LdGrid>();
		LdGridAr ldGridAr = new LdGridAr();
		try {
			String query = "select * from Loan_Detail_Grid";

			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				LdGrid ldGridObj = new LdGrid();
				ldGridObj.setDisb_amt(result.getString("Disb_Amt"));
				ldGridObj.setProc_fee(result.getString("Proc_fee"));
				ldGridObj.setCli(result.getString("CLI"));
				ldGridObj.setLoan_amt(result.getString("Loan_Amt"));
				ldGridObj.setEmi(result.getString("EMI"));
				ldGrid.add(ldGridObj);
			}
			ldGridAr.setLdGrid(ldGrid);
		} catch (Exception e) {
			throw new com.learn.jersey.Masters.Exception.DataBaseExeption("Db Connection Error");
		}
		return ldGridAr;
	}

	public MaritalDataAr getMaritalData() throws DataBaseExeption {
		ArrayList<MaritalData> maritalData = new ArrayList<MaritalData>();
		MaritalDataAr maritalDataAr = new MaritalDataAr();
		try {
			String query = "select * from TBL_Marital_Status";

			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				MaritalData maritalDataObj = new MaritalData();
				maritalDataObj.setId(result.getString("ID"));
				maritalDataObj.setMaritalstatus(result.getString("Marital_Status"));
				maritalData.add(maritalDataObj);
			}
			maritalDataAr.setMaritalDataAr(maritalData);

		} catch (Exception e) {
			throw new com.learn.jersey.Masters.Exception.DataBaseExeption("Db Connection Error");
		}

		return maritalDataAr;

	}

	public ReligionDataAr religionData() throws DataBaseExeption {
		ArrayList<ReligionData> religionData = new ArrayList<ReligionData>();
		ReligionDataAr religionDataAr = new ReligionDataAr();
		try {
			String query = "select * from TBL_RELIGION_MSTR";
			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				ReligionData religionDataObj = new ReligionData();
				religionDataObj.setId(result.getString("ID"));
				religionDataObj.setDisplayorder(result.getString("SubCodeID"));
				religionDataObj.setDescription(result.getString("Description"));
				religionDataObj.setSubcodeid(result.getString("DisplayOrder"));
				religionData.add(religionDataObj);
			}
			religionDataAr.setReligionData(religionData);

		} catch (Exception e) {
			throw new com.learn.jersey.Masters.Exception.DataBaseExeption("Db Connection Error");
		}

		return religionDataAr;

	}

	public StateKycDataAr stateKycData() throws DataBaseExeption {
		ArrayList<StateKycData> stateKycData = new ArrayList<StateKycData>();
		StateKycDataAr stateKycDataAr = new StateKycDataAr();
		try {
			String query = "select * from TBL_State_EKYC";

			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				StateKycData stateKycDataObj = new StateKycData();
				stateKycDataObj.setId(result.getString("ID"));
				stateKycDataObj.setMc_id(result.getString("MC_ID"));
				stateKycDataObj.setState_id(result.getString("State_ID"));
				stateKycData.add(stateKycDataObj);
			}
			stateKycDataAr.setStateKycData(stateKycData);

		} catch (Exception e) {
			throw new com.learn.jersey.Masters.Exception.DataBaseExeption("Db Connection Error");
		}

		return stateKycDataAr;

	}

	public TradeDataAr tradeData() throws DataBaseExeption {
		ArrayList<TradeData> tradeData = new ArrayList<TradeData>();
		TradeDataAr tradeDataAr = new TradeDataAr();
		try {
			String query = "select * from TBL_TRADE_MSTR";
			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				TradeData tradeDataObj = new TradeData();
				tradeDataObj.setId(result.getString("ID"));
				tradeDataObj.setTradename(result.getString("Trade_Name"));
				tradeData.add(tradeDataObj);
			}
			tradeDataAr.setTradeData(tradeData);

		} catch (Exception e) {
			throw new com.learn.jersey.Masters.Exception.DataBaseExeption("Db Connection Error");
		}
		return tradeDataAr;

	}

	public MotherTongueDataAr motherTongueDataAr() throws DataBaseExeption {
		ArrayList<MotherTongueData> motherTongueData = new ArrayList<MotherTongueData>();
		MotherTongueDataAr motherTongueDataAr = new MotherTongueDataAr();
		try {
			String query = "select * from TBL_MOTHERTONGUE_MSTR";
			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				MotherTongueData motherTongueDataObj = new MotherTongueData();
				motherTongueDataObj.setId(result.getString("id"));
				motherTongueDataObj.setSubCodeId(result.getString("SubCodeId"));
				motherTongueDataObj.setDisplayorder(result.getString("Description"));
				motherTongueDataObj.setDescription(result.getString("DissplayOrder"));
				motherTongueData.add(motherTongueDataObj);
			}
			motherTongueDataAr.setMotherTongueData(motherTongueData);

		} catch (Exception e) {
			throw new com.learn.jersey.Masters.Exception.DataBaseExeption("Db Connection Error");
		}

		return motherTongueDataAr;
	}

	public LoanDataAr loanDataAr() throws DataBaseExeption {
		ArrayList<LoanData> loanData = new ArrayList<LoanData>();
		LoanDataAr loanDataAr = new LoanDataAr();
		try {
			String query = "select * from TBL_LoanMaster";

			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				LoanData loanDataObj = new LoanData();
				loanDataObj.setId(result.getString("ID"));
				loanDataObj.setInterestrate(result.getString("Type of loan"));
				loanDataObj.setLoantype(result.getString("Interest rate"));
				loanDataObj.setTenuremonths(result.getString("Tenure (In months)"));
				loanData.add(loanDataObj);
			}
			loanDataAr.setLoanData(loanData);

		} catch (Exception e) {
			throw new com.learn.jersey.Masters.Exception.DataBaseExeption("Db Connection Error");
		}

		return loanDataAr;
	}

	public CasteDataAr casteData() throws DataBaseExeption {
		ArrayList<CasteData> casteData = new ArrayList<CasteData>();
		CasteDataAr casteDataAr = new CasteDataAr();
		try {
			String query = "select * from TBL_CASTE_MSTR";

			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				CasteData casteDataobj = new CasteData();
				casteDataobj.setId(result.getString("ID"));
				casteDataobj.setSubCodeId(result.getString("SubCodeID"));
				casteDataobj.setDisplayorder(result.getString("DisplayOrder"));
				casteDataobj.setDescription(result.getString("Description"));
				casteData.add(casteDataobj);
			}
			casteDataAr.setCasteData(casteData);

		} catch (Exception e) {
			throw new com.learn.jersey.Masters.Exception.DataBaseExeption("Db Connection Error");
		}

		return casteDataAr;
	}

	public HrmsvotrationDataAr hrmsvotrationData() throws Exception {
		ArrayList<HrmsvotrationData> hrmsvotrationData = new ArrayList<HrmsvotrationData>();
		HrmsvotrationDataAr hrmsvotrationDataAr = new HrmsvotrationDataAr();
		try {
			String query = "select * from TBL_HRMS_VOTER_RATION_DETAILS";
			//

			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				HrmsvotrationData hrmsvotrationDataObj = new HrmsvotrationData();
				hrmsvotrationDataObj.setMccode(result.getString("MCCODE"));
				hrmsvotrationDataObj.setRation_card(result.getString("Ration_Card"));
				hrmsvotrationDataObj.setVoter_card(result.getString("Voter_Card"));
				hrmsvotrationData.add(hrmsvotrationDataObj);
			}
			hrmsvotrationDataAr.setHrmsvotrationData(hrmsvotrationData);

		} catch (Exception e) {
			throw new com.learn.jersey.Masters.Exception.DataBaseExeption("Db Connection Error");
		}

		return hrmsvotrationDataAr;
	}

	public McmodeDataAr mcmodeData() throws DataBaseExeption {

		System.out.println("Inside mcmodeData 1 ");

		ArrayList<McmodeData> mcmodeData = new ArrayList<McmodeData>();
		McmodeDataAr mcmodeDataAr = new McmodeDataAr();
		try {
			String query = "select * from TBL_HRMS_MCMode";
			Connection con = dbConn.getDBConnectionForPro();
			prepareStatement = con.prepareStatement(query);
			// prepareStatement.setString(1, );
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				McmodeData mcmodeDataObj = new McmodeData();
				mcmodeDataObj.setMccode(result.getString("MCCODE"));
				mcmodeDataObj.setMode(result.getString("MODE"));

				mcmodeData.add(mcmodeDataObj);
			}
			mcmodeDataAr.setMcmodeData(mcmodeData);

		} catch (Exception e) {
			
			throw new com.learn.jersey.Masters.Exception.DataBaseExeption("Db Connection Error " + e.getMessage());
		}
		return mcmodeDataAr;
	}

	public GenderDataAr takeData() {
		ArrayList<GenderData> mtd = new ArrayList<GenderData>();

		GenderDataAr mtda = new GenderDataAr();

		GenderData data1 = new GenderData();
		data1.setId("ABC101");
		data1.setGender("Male");

		GenderData data2 = new GenderData();
		data2.setId("BCD102");
		data2.setGender("Female");

		mtd.add(data1);
		mtd.add(data2);
		mtda.setGenderData(mtd);

		return mtda;
	}

}