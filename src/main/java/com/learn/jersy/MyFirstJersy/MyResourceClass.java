package com.learn.jersy.MyFirstJersy;

import java.net.HttpURLConnection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.internal.Errors.ErrorMessage;

import com.google.gson.Gson;
import com.learn.jersey.Masters.CasteDataAr;
import com.learn.jersey.Masters.GenderDataAr;
import com.learn.jersey.Masters.HrmsvotrationDataAr;
import com.learn.jersey.Masters.LdGridAr;
import com.learn.jersey.Masters.LoanDataAr;
import com.learn.jersey.Masters.MaritalDataAr;
import com.learn.jersey.Masters.McmodeDataAr;
import com.learn.jersey.Masters.MlMasterDaoImpl;
import com.learn.jersey.Masters.MotherTongueDataAr;
import com.learn.jersey.Masters.ReligionDataAr;
import com.learn.jersey.Masters.StateKycDataAr;
import com.learn.jersey.Masters.TradeDataAr;
import com.learn.jersy.DaoImpl.MessageDaoImpl;

@Path("/Ml_Master")
public class MyResourceClass {
	private MlMasterDaoImpl ml = new MlMasterDaoImpl();


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response genderData(@QueryParam("master") String master) {
		MlMasterDaoImpl ml = new MlMasterDaoImpl();
		ErrorMessage errorMessage;

		if (StringUtils.isBlank(master) || StringUtils.isEmpty(master) || StringUtils.isNumeric(master)
				|| StringUtils.contains(master, "[$&+,:;=?@#|'<>.^*()%!-]")) {
			throw new WebApplicationException(Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity("BAD_REQUEST parameter not allowed").build());
		} else if (StringUtils.isNotBlank(master) || StringUtils.isNotEmpty(master)) {
			System.out.println(" Inside API");
			String response = "";
			Gson gson = new Gson();
			try {

				if (master.equalsIgnoreCase("genderMstr")) {
					System.out.println(" inside genderMstr");
					GenderDataAr genderDataAr = new GenderDataAr();
					genderDataAr = ml.takeData();
					//takeData
					response = gson.toJson(genderDataAr);
					return Response.status(HttpURLConnection.HTTP_OK).entity(response).build();
				} else if (master != null && master.equalsIgnoreCase("loanDetailGrid")) {
					System.out.println(" inside loanDetailGrid");
					LdGridAr gd = new LdGridAr();
					gd = ml.loanDetailGrid();
					response = gson.toJson(gd);
					return Response.status(HttpURLConnection.HTTP_OK).entity(response).build();

				} else if (master != null && master.equalsIgnoreCase("maritalMstr")) {

					System.out.println("inside maritalMstr");
					MaritalDataAr gd = new MaritalDataAr();
					gd = ml.getMaritalData();

					response = gson.toJson(gd);
					return Response.status(HttpURLConnection.HTTP_OK).entity(response).build();

				} else if (master != null && master.equalsIgnoreCase("religionMstr")) {

					System.out.println(" inside religionMstr");
					ReligionDataAr gd = new ReligionDataAr();
					gd = ml.religionData();
					response = gson.toJson(gd);
					return Response.status(HttpURLConnection.HTTP_OK).entity(response).build();

				} else if (master != null && master.equalsIgnoreCase("stateEkyc")) {

					System.out.println(" inside stateEkyc");
					StateKycDataAr gd = new StateKycDataAr();
					gd = ml.stateKycData();
					response = gson.toJson(gd);
					return Response.status(HttpURLConnection.HTTP_OK).entity(response).build();

				} else if (master != null && master.equalsIgnoreCase("tradeMstr")) {
					System.out.println(" inside stateEkyc");
					TradeDataAr gd = new TradeDataAr();
					gd = ml.tradeData();
					response = gson.toJson(gd);
					return Response.status(HttpURLConnection.HTTP_OK).entity(response).build();

				} else if (master != null && master.equalsIgnoreCase("motherTongueMstr")) {

					System.out.println(" inside motherTongueMstr");
					MotherTongueDataAr gd = new MotherTongueDataAr();
					gd = ml.motherTongueDataAr();

					response = gson.toJson(gd);
					return Response.status(HttpURLConnection.HTTP_OK).entity(response).build();

				} else if (master != null && master.equalsIgnoreCase("loanMstr")) {

					System.out.println(" inside loanMstr");
					LoanDataAr gd = new LoanDataAr();
					gd = ml.loanDataAr();

					response = gson.toJson(gd);
					return Response.status(HttpURLConnection.HTTP_OK).entity(response).build();

				} else if (master != null && master.equalsIgnoreCase("casteMstr")) {

					System.out.println(" inside CasteData");
					CasteDataAr gd = new CasteDataAr();
					gd = ml.casteData();
					response = gson.toJson(gd);
					return Response.status(HttpURLConnection.HTTP_OK).entity(response).build();

				}

				else if (master != null && master.equalsIgnoreCase("hrmsVoterRationMstr")) {

					System.out.println(" inside hrmsvotrationData");
					HrmsvotrationDataAr gd = new HrmsvotrationDataAr();
					gd = ml.hrmsvotrationData();
					response = gson.toJson(gd);
					return Response.status(HttpURLConnection.HTTP_OK).entity(response).build();

				} else if (master != null && master.equalsIgnoreCase("hrmsmcModeMstr")) {
					System.out.println(" inside hrmsvotrationData");
					McmodeDataAr mcmodeDataAr = new McmodeDataAr();
					mcmodeDataAr = ml.mcmodeData();
					response = gson.toJson(mcmodeDataAr);
					System.out.println("Getting Respoonse" + response);
					return Response.status(HttpURLConnection.HTTP_OK).entity(response).build();
				}

			} catch (Exception e) {
				
				return Response.status(404).entity("SOMETHING WENT WRONG").build();
			}

		}

		//errorMessage = new ErrorMessage("Data Not Found BAD REQUEST!!", 404, "www.google.com");
		return Response.status(HttpURLConnection.HTTP_NOT_FOUND).entity("BAD REQUEST").build();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		MyResourceClass masterService = new MyResourceClass();

		try {
			System.out.println(masterService.genderData("hrmsVoterRationMstr"));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
		}
	}

}