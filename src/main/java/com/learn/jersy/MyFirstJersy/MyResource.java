package com.learn.jersy.MyFirstJersy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang3.StringUtils;

import com.BillDeskdeploy.BilDesk;
import com.Retrunpdf.Applicantdata;
import com.Retrunpdf.Applocationdata;
import com.Retrunpdf.MyPojo;
import com.ValuefirstToGenie.Body;
import com.ValuefirstToGenie.Item;
import com.ValuefirstToGenie.Query;
import com.ValuefirstToGenie.Url;
import com.google.gson.Gson;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.learn.SalarySlip.MultipleSalarySlip;
import com.learn.SalarySlip.SalaryData;
import com.learn.SalarySlip.Salary_Slip;
import com.learn.iText.PdfData;
import com.learn.jersey.Entity_validation.Customer;
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
import com.learn.jersey.ParamValidator.QueryParamValidator;
import com.learn.jersy.DaoImpl.MessageDaoImpl;
import com.learn.jersy.Exception.ErrorMessage;
import com.learn.jersy.beans.Message;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/secured/")
public class MyResource {

	MessageDaoImpl messageDaoImpl = new MessageDaoImpl();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hellofiroz1	";
	}

	@GET
	@Path("/your")
	@Produces(MediaType.TEXT_PLAIN)
	public String quary(@QueryParam("name") String name) {

		System.out.println(name);

		return "Hello " + name;
	}

	@GET
	@Path("/message")
//@Produces("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage() {
		System.out.println(messageDaoImpl.getMessage());
		return messageDaoImpl.getMessage();

	}

	@GET
	@Path("/getXmlData")
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getXmlData() { // from path
		List<Message> data = messageDaoImpl.getMessage();
		return data;
	}

	@GET
	@Path("/getjsonData")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg() {
		List<Message> data = messageDaoImpl.getAllMessage();
		System.out.println(Response.status(200).entity(data).build());
		return Response.status(200).entity(data).build();
	}

	@GET
//@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParamdata(@PathParam("id") String id) {
		List<Message> data = messageDaoImpl.getMessage();
		System.out.println(Response.status(200).entity(data).build());
		return Response.status(200).entity(data).build();
	}

// http://localhost:8080/MyFirstJersy/webapi/myresource/id=1
	@POST
	@Path("/id={id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(@PathParam("id") int id, @Context UriInfo info) throws URISyntaxException {
		URI url;

		System.out.println(" inside id " + info.getPath());
		if (id < 0 | id == 0) {
			url = info.getAbsolutePathBuilder().path(String.valueOf(id)).build();
			return Response.created(url).entity("Id Can't should be Greater then Zero").build();
		} else if (id > 0) {
			url = info.getAbsolutePathBuilder().path(String.valueOf(id)).build();
			List<Message> data = messageDaoImpl.getMessage();
			System.out.println(" id " + id);

			System.out.println(Response.status(200).entity(data).build());
			return Response.created(url).entity(data).build();
		}
		return Response.status(404).entity("Bad Request").build();
	}

//----------------------Exception ---------
//http://localhost:8080/MyFirstJersy/webapi/myresource/Exception=-1
	@POST
	@Path("/Exception={id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response exceptionhand(@PathParam("id") int id, @Context UriInfo info) {
		System.out.println(" inside Service ");
		URI url = info.getAbsolutePathBuilder().path(String.valueOf(id)).build();

		System.out.println(info.getPath());
		if (id < 0 | id == 0) {
			// throw new DataNotFoundException(" does not existing on this server !!");
			throw new WebApplicationException(Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity("does not existing on this server !!").build());
		} else if (id > 0) {
			List<Message> data = messageDaoImpl.getAllMessage();
			System.out.println(" id " + id);
			System.out.println(Response.status(200).entity(data).build());
			return Response.created(url).entity(data).build();
		}
		return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity("ID Can't be Null").build();
	}

//http://localhost:8080/MyFirstJersy/webapi/myresource/test?p=

	@GET
	@QueryParamValidator
	// @Path("test")
	// @Path("{p : [a-zA-Z][a-zA-Z_0-9]}")
	@Path("/test")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response test(@QueryParam("p") String p) {

		System.out.println(StringUtils.isBlank(p));
		System.out.println(StringUtils.isEmpty(p));
		System.out.println(StringUtils.isNumeric(p));

		if (StringUtils.isBlank(p) || StringUtils.isEmpty(p) || StringUtils.isNumeric(p)) {
			throw new WebApplicationException(Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity("BAD_REQUEST parameter Not Allowd").build());
		}
		return Response.status(HttpURLConnection.HTTP_OK).entity("Good Content").build();

	}

//http://localhost:8080/MyFirstJersy/webapi/myresource/Ml_Master?master=genderMstr

	@Path("/Ml_Master")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response genderData(@QueryParam("master") String master) {
		MlMasterDaoImpl ml = new MlMasterDaoImpl();
		ErrorMessage errorMessage;

		System.out.println(" Inside API");
		String response = "";
		Gson gson = new Gson();
		try {

			if (master.equalsIgnoreCase("genderMstr")) {
				System.out.println(" inside genderMstr");
				GenderDataAr genderDataAr = new GenderDataAr();
				genderDataAr = ml.takeData();
				// takeData
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
				// return Response.status(HttpURLConnection.HTTP_OK).entity(response).build();
				Response.ok().entity(response).cookie(new NewCookie("cookieResponse", response)).build();
			}

		} catch (Exception e) {
			errorMessage = new ErrorMessage("Connection Error !!", 404, "www.google.com");
			return Response.status(404).entity(errorMessage).build();
		}

		return Response.status(HttpURLConnection.HTTP_NOT_FOUND).entity("error").build();
	}

	@GET
	@Path("/getCookie")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCookie(@CookieParam("cookieResponse") String userAgent) {

		Map<String, Object> cookieMap = new HashMap<String, Object>();
		cookieMap.put("cookieResponse", userAgent);

		return Response.status(200).entity(cookieMap).build();

	}

	@Path("/customers")
	@POST
	public String createCustomer(@Valid Customer customer) {
		System.out.println("-- in createCustomer() method --");
		return String.format("Customer created : %s%n", customer);
	}

	/*
	 * 
	 * @Path("/getPDF")
	 * 
	 * @POST
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON) public OutputStream getPdf(JSONObject
	 * mp) throws IOException, JSONException, DocumentException {
	 * 
	 * System.out.println("inside api"); Document document = new Document();
	 * OutputStream outputStream = new FileOutputStream(new
	 * File("E:\\iText\\TestFile10.pdf"));
	 * 
	 * jsonTopdf(mp);
	 * 
	 * try { PdfWriter.getInstance(document, outputStream); document.open();
	 * Paragraph p = new Paragraph(); p.add((Element) mp); //no alignment
	 * 
	 * document.close(); System.out.println("Done");
	 * 
	 * 
	 * } catch (Exception e) { // TODO: handle exception } return outputStream;
	 * 
	 * }
	 * 
	 * 
	 * public static File jsonTopdf(JSONObject json) throws IOException,
	 * JSONException, DocumentException { Document document = new Document();
	 * 
	 * File file = File.createTempFile("consulta", ".pdf"); FileOutputStream output
	 * = new FileOutputStream(file);
	 * 
	 * PdfWriter writer = PdfWriter.getInstance(document, output);
	 * writer.setEncryption("a".getBytes(), "b".getBytes(),
	 * PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128);
	 * writer.createXmpMetadata(); writer.setBoxSize("art", new Rectangle(36, 54,
	 * 559, 788));
	 * 
	 * 
	 * document.open(); document.addCreationDate(); document.addTitle("documento");
	 * document.newPage();
	 * 
	 * process(document, json);
	 * 
	 * document.close();
	 * 
	 * return file; }
	 * 
	 * public static void process(Document document, JSONObject json) throws
	 * JSONException, DocumentException { for (String k : json.keySet()) { Object
	 * object = json.get(k); if (object instanceof JSONArray) { JSONArray list =
	 * json.getJSONArray(k); process(document, list); } else if (object instanceof
	 * JSONObject) { process(document, json.getJSONObject(k)); } else {
	 * document.add(new Paragraph(k + " " + json.get(k))); }
	 * 
	 * } } public static void process(Document document, JSONArray json) throws
	 * JSONException, DocumentException { for (int x = 0; x < json.length(); x++) {
	 * Object object = json.get(x); if (object instanceof JSONArray) { JSONArray
	 * list = json.getJSONArray(x); process(document, list); } else if (object
	 * instanceof JSONObject) { process(document, json.getJSONObject(x)); } else {
	 * document.add(new Paragraph(json.get(x).toString())); }
	 * 
	 * } }
	 * 
	 * 
	 * 
	 * @Path("/getPDF1")
	 * 
	 * @GET //@Produces("application/pdf")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON) public OutputStream getPdf1() throws
	 * FileNotFoundException { String mp="asd"; System.out.println(mp.toString());
	 * 
	 * System.out.println("inside api"); Document document = new Document();
	 * OutputStream outputStream = new FileOutputStream(new
	 * File("E:\\iText\\TestFile10.pdf"));
	 * 
	 * try { PdfWriter.getInstance(document, outputStream); document.open();
	 * Paragraph p = new Paragraph(); p.add(mp); //no alignment
	 * 
	 * document.close(); System.out.println("Done");
	 * 
	 * 
	 * } catch (Exception e) { // TODO: handle exception }
	 * 
	 * return outputStream;
	 * 
	 * }
	 * 
	 * 
	 */

	@Path("/getPDF1")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getPdf1(String input) throws DocumentException {

		String response = "";

		String FILE_NAME = "E://iText//TestFile15.pdf";

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

			// open
			document.open();

			System.out.println(input);
			Gson gson = new Gson();
			MyPojo physicalSigns = new MyPojo();
			physicalSigns = (MyPojo) gson.fromJson(input, physicalSigns.getClass());

			System.out.println("physicalsgin" + gson.toJson(physicalSigns));
			// System.out.println("physicalsgin" + physicalSigns.getApplicantdata());
			// System.out.println("physicalsgin" + physicalSigns.getApplocationdata());
			System.out.println("physocal" + physicalSigns.getPhysicalSigns().get(0).getApplocationdata().getCaste());
			System.out
					.println("physocal " + physicalSigns.getPhysicalSigns().get(0).getApplocationdata().getBankName());

			Paragraph p2 = new Paragraph();

			// p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().getAdress());
			p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().getBankName());
			p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().getBranch());

			// p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().getBankName());

			/*
			 * p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().getBranch
			 * ());
			 * p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().getCaste(
			 * )); p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().
			 * getCustomerCycle());
			 * p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().
			 * getCustomerCycle());
			 * p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().
			 * getDistrict());
			 * p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().
			 * getEmployeeCode());
			 * p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().
			 * getDistrict());
			 * p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().getFlname
			 * ()); p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().
			 * getFlsCode());
			 * p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().
			 * getIncomeDetails());
			 * p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().
			 * getLoanApplied());
			 * p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().
			 * getMaritalStatus());
			 * p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().
			 * getMobileNo());
			 * p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().
			 * getReligion());
			 * 
			 * /*
			 * 
			 */
			// document.add(p2);

			PdfPTable pdfPTable = new PdfPTable(2);

			// Create cells
			PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("Bank Name"));
			PdfPCell pdfPCell2 = new PdfPCell(new Paragraph("Name:- "));
			PdfPCell pdfPCell3 = new PdfPCell(new Paragraph("ID"));
			PdfPCell pdfPCell4 = new PdfPCell(new Paragraph("salary"));

			pdfPCell1.addElement(p2);

			pdfPCell1.setPadding(10);

			// Add cells to table
			pdfPTable.addCell(pdfPCell1);
			pdfPTable.addCell(pdfPCell2);
			pdfPTable.addCell(pdfPCell3);
			pdfPTable.addCell(pdfPCell4);

			// Add content to the document using Table objects.
			document.add(pdfPTable);

			// Close document and outputStream.
			document.close();

			Applicantdata applicantdata = new Applicantdata();
			System.out.println("physocal" + physicalSigns.getPhysicalSigns().get(0).getApplicantdata().size());

			physicalSigns = (MyPojo) gson.fromJson(input, physicalSigns.getClass());

			/*
			 * Paragraph p2 = new Paragraph(); Applocationdata
			 * applocationdata=physicalSigns[0].getApplocationdata();
			 * 
			 * p2.add(applocationdata.getAdress()); p2.add(applocationdata.getAccountNo());
			 * p2.add(applocationdata.getAdress());
			 * p2.add(applocationdata.getAccountHolder());
			 * p2.add(applocationdata.getAnnualIncome());
			 * p2.add(applocationdata.getBankName()); p2.add(applocationdata.getBranch());
			 * p2.add(applocationdata.getCaste());
			 * p2.add(applocationdata.getCustomerCycle());
			 * p2.add(applocationdata.getCustomerCycle());
			 * p2.add(applocationdata.getDistrict());
			 * p2.add(applocationdata.getEmployeeCode());
			 * p2.add(applocationdata.getDistrict()); p2.add(applocationdata.getFlname());
			 * p2.add(applocationdata.getFlsCode());
			 * p2.add(applocationdata.getIncomeDetails());
			 * p2.add(applocationdata.getLoanApplied());
			 * p2.add(applocationdata.getMaritalStatus());
			 * p2.add(applocationdata.getMobileNo()); p2.add(applocationdata.getReligion());
			 * document.add(p2);
			 * 
			 * System.out.println(document);
			 * 
			 * 
			 * /*
			 * 
			 * Paragraph p1 = new Paragraph();
			 * 
			 * 
			 * 
			 * Applicantdata applicantdata =new Applicantdata();
			 * 
			 * p1.add(applicantdata.getGender()); p1.add(applicantdata.getDateOfBirth());
			 * p1.add(applicantdata.getIsPrimaryApplicant());
			 * p1.add(applicantdata.getKYC1()); p1.add(applicantdata.getKYC2());
			 * 
			 * 
			 * /* document.add(p);
			 * 
			 * Applocationdata applocationdata =new Applocationdata(); Paragraph p2 = new
			 * Paragraph(); p2.add(applocationdata.getAccountNo());
			 * p2.add(applocationdata.getAdress());
			 * p2.add(applocationdata.getAccountHolder());
			 * p2.add(applocationdata.getAnnualIncome());
			 * p2.add(applocationdata.getBankName()); p2.add(applocationdata.getBranch());
			 * p2.add(applocationdata.getCaste());
			 * p2.add(applocationdata.getCustomerCycle());
			 * p2.add(applocationdata.getCustomerCycle());
			 * p2.add(applocationdata.getDistrict());
			 * p2.add(applocationdata.getEmployeeCode());
			 * p2.add(applocationdata.getDistrict()); p2.add(applocationdata.getFlname());
			 * p2.add(applocationdata.getFlsCode());
			 * p2.add(applocationdata.getIncomeDetails());
			 * p2.add(applocationdata.getLoanApplied());
			 * p2.add(applocationdata.getMaritalStatus());
			 * p2.add(applocationdata.getMobileNo()); p2.add(applocationdata.getReligion());
			 */

			// MyPojo
			// PhysicalSigns

			// close
			document.close();

			System.out.println("Done");

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

//response=encodeFileToBase64Binary(filename);

		return response;
	}

	// encode-PDF-File-To-Base64Binary

	private String encodeFileToBase64Binary(File file) {
		String encodedfile = null;
		try {
			FileInputStream fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fileInputStreamReader.read(bytes);
			encodedfile = Base64.getEncoder().encodeToString(bytes);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return encodedfile;
	}

	/*
	 * { physicalSigns: [ { applicantdata: [ { name: "", gender: "", dateOfBirth:
	 * "", KYC1: "", KYC2: "", isPrimaryApplicant: "" } ], applocationdata: {
	 * viddocid: "", applicationRefNo: "", customerCycle: "", flsCode: "",
	 * territory: "", mc: "", maritalStatus: "", mobileNo: "", religion: "", caste:
	 * "", adress: "", district: "", pincode: "", state: "", bankName: "", branch:
	 * "", ifsc: "", accountNo: "", accountHolder: "", incomeDetails: "",
	 * annualIncome: "", loanpurpose: "", processingfee: "", ROI: "", tenure: "",
	 * loanApplied: "", mcmName: "", employeeCode: "", flname: "" } } ] }
	 * 
	 */

	@Path("/getPDF2")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getPdf2(String input) throws DocumentException, IOException {

		Gson gson = new Gson();
		MyPojo physicalSigns = new MyPojo();
		physicalSigns = (com.Retrunpdf.MyPojo) gson.fromJson(input, physicalSigns.getClass());

		physicalSigns = (MyPojo) gson.fromJson(input, physicalSigns.getClass());

		System.out.println("physicalSigns Data" + physicalSigns.getPhysicalSigns().get(0).getApplocationdata());

		ArrayList<Applicantdata> applicantdata = applicantdata = physicalSigns.getPhysicalSigns().get(0)
				.getApplicantdata();
		;
		for (int i = 1; i < applicantdata.size(); i++) {
			System.out.println(" applicantdata " + applicantdata.get(i));
		}

		Applocationdata applocationdata = physicalSigns.getPhysicalSigns().get(0).getApplocationdata();
		;

		Paragraph p2 = new Paragraph();

		// p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().getAdress());
		p2.add(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().getBankName());

		Rectangle pageSize = new Rectangle(780, 525);
		String FILE_NAME = "E://iText//TestFile19.pdf";
		Document document = new Document(pageSize);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

		// PdfWriter writer=PdfWriter.getInstance(document, response.getOutputStream());
		// PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		// document.addHeader("jinu","jawad");
		float[] colsWidth1 = { 1f, 1f, 1f, 1f, 1f }; // Code 1
		// Image image = Image.getInstance(path+"employee/payslip/view/fly-hind.jpg");
		PdfPTable table = new PdfPTable(colsWidth1);
		table.getDefaultCell().setBorder(0);
		table.setWidthPercentage(100); // Code 2
		table.setHorizontalAlignment(Element.ALIGN_LEFT);// Code 3
		float[] colsWidth_main = { 1f, 1f, 1f }; // Code 1
		table = new PdfPTable(colsWidth_main);
		table.getDefaultCell().setBorder(0);
		table.setWidthPercentage(100); // Code 2
		table.setHorizontalAlignment(Element.ALIGN_LEFT);// Code 3
		table.addCell("");
		table.addCell(Image.getInstance("E:\\iText\\chillyfacts.png"));
		table.addCell("");
		document.add(table);
		float[] colsWidth = { 1f, 1f, 1f, 1f }; // Code 1
		table = new PdfPTable(colsWidth);
		table.getDefaultCell().setBorder(0);
		table.setWidthPercentage(100); // Code 2
		table.setHorizontalAlignment(Element.ALIGN_LEFT);// Code 3
		table.addCell(" Bank Name ");
		table.addCell(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().getBankName());
		table.addCell("Branch");

		table.addCell(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().getBranch());
		table.addCell("Address");
		table.addCell(physicalSigns.getPhysicalSigns().get(0).getApplocationdata().getAdress());
		table.addCell(" ");
		table.addCell(" ");
		document.add(table);
		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);

		document.close();
		String ecodedFile = encodeFileToBase64Binary(new File(FILE_NAME));

		return ecodedFile;
	}

	// ------------------Json Salary Slip--------------------

	// Url:- http://localhost:8080/MyFirstJersy/webapi/myresource/getSalarySlip

	/*
	 * { "SalaryData": { "Name": "Firoz P", "Department": "Java Developer",
	 * "Designation": "Software Developer", "Date_Of_Joining": "28-05-2018",
	 * "PF_Account_No": "ASD1231313ASD", "Days_Worked": "30", "ESI_Account_Number":
	 * "234567890987", "Casual_Leave": "1", "Adhar_Number": "234567890987",
	 * "PAN_Number": "ADT4567890", "PF": "500", "HRA": "200", "ESI": "0",
	 * "Festival_Allowance": "500", "Professional_Taxes": "2", "Amount": "500000",
	 * "Deductions": "500", "Earnings": "500000", "Total_Earning": "500000",
	 * "Total_Deductions": "500" } }
	 */

//	http://localhost:8080/MyFirstJersy/webapi/myresource/getSalarySlip	

	@Path("/getSalarySlip")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String salarySlip(String input) throws DocumentException, IOException {
		Gson gson = new Gson();
		Salary_Slip salary_Slip = new Salary_Slip();
		salary_Slip = (Salary_Slip) gson.fromJson(input, salary_Slip.getClass());

		String name = salary_Slip.getSalaryData().getName() + "_SalarySlip";
		Rectangle pageSize = new Rectangle(780, 525);
		String FILE_NAME = "E://iText//" + name + ".pdf";
		Document document = new Document(pageSize);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

		// ---------------------Apply PassWord to PDF-------------------------------
		String userPassword = "firoz";
		String ownerPassword = "firoz123";
		// Add password protection.
		writer.setEncryption(userPassword.getBytes(), ownerPassword.getBytes(), PdfWriter.ALLOW_PRINTING,
				PdfWriter.ENCRYPTION_AES_128);
		// ----------------------------------------------------------------

		document.open();
		float[] colsWidth1 = { 1f, 1f, 1f, 1f, 1f }; // Code 1
		// Image image = Image.getInstance(path+"employee/payslip/view/fly-hind.jpg");
		PdfPTable table = new PdfPTable(colsWidth1);
		table.getDefaultCell().setBorder(0);
		table.setWidthPercentage(100); // Code 2
		table.setHorizontalAlignment(Element.ALIGN_LEFT);// Code 3
		table.addCell("");
		table.addCell("");
		table.addCell("Pay Slip For The Month December");
		table.addCell("");
		table.addCell("");
		document.add(table);
		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);
		float[] colsWidth_main = { 1f, 1f, 1f }; // Code 1
		table = new PdfPTable(colsWidth_main);
		table.getDefaultCell().setBorder(0);
		table.setWidthPercentage(100); // Code 2
		table.setHorizontalAlignment(Element.ALIGN_LEFT);// Code 3
		table.addCell("");
		table.addCell(Image.getInstance("E:\\iText\\chillyfacts.png"));
		table.addCell("");
		document.add(table);
		float[] colsWidth = { 1f, 1f, 1f, 1f }; // Code 1
		table = new PdfPTable(colsWidth);
		table.getDefaultCell().setBorder(0);
		table.setWidthPercentage(100); // Code 2
		table.setHorizontalAlignment(Element.ALIGN_LEFT);// Code 3
		table.addCell("Employee ID");
		table.addCell(salary_Slip.getSalaryData().getESI_Account_Number());
		table.addCell("Name");
		table.addCell(salary_Slip.getSalaryData().getName());
		table.addCell("Department");
		table.addCell(salary_Slip.getSalaryData().getDepartment());
		table.addCell("Designation");
		table.addCell(salary_Slip.getSalaryData().getDesignation());
		table.addCell("Date Of Joining");
		table.addCell(salary_Slip.getSalaryData().getDate_Of_Joining());
		table.addCell("PF Account No");
		table.addCell(salary_Slip.getSalaryData().getPF_Account_No());
		table.addCell("Days Worked");
		table.addCell(salary_Slip.getSalaryData().getDays_Worked());
		table.addCell("ESI Account Number");
		table.addCell(salary_Slip.getSalaryData().getESI_Account_Number());
		table.addCell("Casual Leave");
		table.addCell(salary_Slip.getSalaryData().getCasual_Leave());
		table.addCell("Adhar Number");
		table.addCell(salary_Slip.getSalaryData().getAdhar_Number());
		table.addCell("PAN Number");
		table.addCell(salary_Slip.getSalaryData().getPAN_Number());
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		table.addCell(" ");
		document.add(table);
		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);
		Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		PdfPTable table1 = new PdfPTable(colsWidth);
		table1.setWidthPercentage(100); // Code 2
		table1.setHorizontalAlignment(Element.ALIGN_LEFT);// Code 3
		Phrase Earnings = new Phrase("Earnings", boldFont);
		Phrase Amount = new Phrase("Amount", boldFont);
		Phrase Deductions = new Phrase("Deductions", boldFont);
		Phrase Amount1 = new Phrase("Amount1", boldFont);
		Phrase total_earnings = new Phrase("Total Earning", boldFont);
		Phrase total_deductions = new Phrase("Total Deductions", boldFont);
		table1.addCell(Earnings);
		table1.addCell(Amount);
		table1.addCell(Deductions);
		table1.addCell(Amount1);
		table1.addCell("Basic Pay");
		table1.addCell(salary_Slip.getSalaryData().getFestival_Allowance());
		table1.addCell("PF");
		table1.addCell(salary_Slip.getSalaryData().getPF());
		table1.addCell("HRA");
		table1.addCell(salary_Slip.getSalaryData().getESI());
		table1.addCell("ESI");
		table1.addCell(salary_Slip.getSalaryData().getHRA());
		table1.addCell("Festival Allowance");
		table1.addCell(salary_Slip.getSalaryData().getFestival_Allowance());
		table1.addCell("Professional Taxes");
		table1.addCell(salary_Slip.getSalaryData().getProfessional_Taxes());
		table1.addCell("Others");
		table1.addCell("Other");
		table1.addCell("Others");
		table1.addCell("Others");
		table1.addCell(total_earnings);
		table1.addCell("Others");
		table1.addCell(total_deductions);
		table1.addCell(salary_Slip.getSalaryData().getDeductions());
		document.add(table1);
		PdfPTable table2 = new PdfPTable(colsWidth);
		table2.setWidthPercentage(100); // Code 2
		table2.getDefaultCell().setBorder(0);
		table2.setHorizontalAlignment(Element.ALIGN_MIDDLE);// Code 3
		Phrase employers_signature = new Phrase("Employer's Signature", boldFont);
		Phrase employees_signature = new Phrase("Employee's Signature", boldFont);
		document.add(Chunk.NEWLINE);
		table2.addCell(" ");
		table2.addCell(" ");
		table2.addCell(" ");
		table2.addCell(" ");
		table2.addCell(employers_signature);
		table2.addCell("");
		table2.addCell(employees_signature);
		table2.addCell("");
		document.add(Chunk.NEWLINE);
		document.add(table2);
		PdfContentByte cb = writer.getDirectContent();
		cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, false), 24);
		cb.setLineWidth(3);
		cb.moveTo(10, 515);
		cb.lineTo(770, 515);
		cb.moveTo(10, 10);
		cb.lineTo(770, 10);
		cb.moveTo(770, 515);
		cb.lineTo(770, 10);
		cb.moveTo(10, 515);
		cb.lineTo(10, 10);
		cb.stroke();

		document.close();
		String ecodedFile = encodeFileToBase64Binary(new File(FILE_NAME));// Encode method call
		return ecodedFile;
	}

	/*
	 * { "SalaryData":[ { "Name": "Firoz P", "Department": "Java Developer",
	 * "Designation": "Software Developer", "Date_Of_Joining": "28-05-2018",
	 * "PF_Account_No": "ASD1231313ASD", "Days_Worked": "30", "ESI_Account_Number":
	 * "234567890987", "Casual_Leave": "1", "Adhar_Number": "234567890987",
	 * "PAN_Number": "ADT4567890", "PF": "500", "HRA": "200", "ESI": "0",
	 * "Festival_Allowance": "500", "Professional_Taxes": "2", "Amount": "500000",
	 * "Deductions": "500", "Earnings": "500000", "Total_Earning": "500000",
	 * "Total_Deductions": "500" }, { "Name": "Aman P", "Department":
	 * ".Net Developer", "Designation": "Software Developer", "Date_Of_Joining":
	 * "28-05-2018", "PF_Account_No": "ASD1231313ASD", "Days_Worked": "30",
	 * "ESI_Account_Number": "234567890987", "Casual_Leave": "1", "Adhar_Number":
	 * "234567890987", "PAN_Number": "ADT4567890", "PF": "500", "HRA": "200", "ESI":
	 * "0", "Festival_Allowance": "500", "Professional_Taxes": "2", "Amount":
	 * "500000", "Deductions": "500", "Earnings": "500000", "Total_Earning":
	 * "500000", "Total_Deductions": "500" },{ "Name": "Vikas P", "Department":
	 * "BDA Developer", "Designation": "Software Developer", "Date_Of_Joining":
	 * "28-05-2018", "PF_Account_No": "ASD1231313ASD", "Days_Worked": "30",
	 * "ESI_Account_Number": "234567890987", "Casual_Leave": "1", "Adhar_Number":
	 * "234567890987", "PAN_Number": "ADT4567890", "PF": "500", "HRA": "200", "ESI":
	 * "0", "Festival_Allowance": "500", "Professional_Taxes": "2", "Amount":
	 * "500000", "Deductions": "500", "Earnings": "500000", "Total_Earning":
	 * "500000", "Total_Deductions": "500" },{ "Name": "Samad P", "Department":
	 * ".freelance Developer", "Designation": "Software Developer",
	 * "Date_Of_Joining": "28-05-2018", "PF_Account_No": "ASD1231313ASD",
	 * "Days_Worked": "30", "ESI_Account_Number": "234567890987", "Casual_Leave":
	 * "1", "Adhar_Number": "234567890987", "PAN_Number": "ADT4567890", "PF": "500",
	 * "HRA": "200", "ESI": "0", "Festival_Allowance": "500", "Professional_Taxes":
	 * "2", "Amount": "500000", "Deductions": "500", "Earnings": "500000",
	 * "Total_Earning": "500000", "Total_Deductions": "500" },{ "Name": "Ahad P",
	 * "Department": "SalesForce Developer", "Designation": "Software Developer",
	 * "Date_Of_Joining": "28-05-2018", "PF_Account_No": "ASD1231313ASD",
	 * "Days_Worked": "30", "ESI_Account_Number": "234567890987", "Casual_Leave":
	 * "1", "Adhar_Number": "234567890987", "PAN_Number": "ADT4567890", "PF": "500",
	 * "HRA": "200", "ESI": "0", "Festival_Allowance": "500", "Professional_Taxes":
	 * "2", "Amount": "500000", "Deductions": "500", "Earnings": "500000",
	 * "Total_Earning": "500000", "Total_Deductions": "500" }] }
	 */

//http://localhost:8080/MyFirstJersy/webapi/myresource/getMultipleSalarySlip

	@Path("/getMultipleSalarySlipInSingleFile")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String salarySlipMulti(String input) throws DocumentException, IOException {
		Gson gson = new Gson();
		MultipleSalarySlip salary_Slip = new MultipleSalarySlip();

		salary_Slip = gson.fromJson(input, salary_Slip.getClass());
		SalaryData salaryData[] = salary_Slip.getSalaryData();
		;

		Rectangle pageSize = new Rectangle(780, 525);
		String FILE_NAME = "E://iText//multi2.pdf";
		Document document = new Document(pageSize);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

		// ---------------------Apply PassWord to PDF-------------------------------
		String userPassword = "firoz";
		String ownerPassword = "firoz123";
		// Add password protection.
		writer.setEncryption(userPassword.getBytes(), ownerPassword.getBytes(), PdfWriter.ALLOW_PRINTING,
				PdfWriter.ENCRYPTION_AES_128);
//----------------------------------------------------------------

		document.open();

		for (int i = 0; i < salaryData.length; i++) {

			float[] colsWidth1 = { 1f, 1f, 1f, 1f, 1f }; // Code 1
			// Image image = Image.getInstance(path+"employee/payslip/view/fly-hind.jpg");
			PdfPTable table = new PdfPTable(colsWidth1);
			table.getDefaultCell().setBorder(0);
			table.setWidthPercentage(100); // Code 2
			table.setHorizontalAlignment(Element.ALIGN_LEFT);// Code 3
			table.addCell("");
			table.addCell("");

			Date date = new Date();
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Month month = localDate.getMonth();

			table.addCell("Pay Slip For The Month " + month + "");
			table.addCell("");
			table.addCell("");
			document.add(table);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			float[] colsWidth_main = { 1f, 1f, 1f }; // Code 1
			table = new PdfPTable(colsWidth_main);
			table.getDefaultCell().setBorder(0);
			table.setWidthPercentage(100); // Code 2
			table.setHorizontalAlignment(Element.ALIGN_LEFT);// Code 3
			table.addCell("");
			table.addCell(Image.getInstance("E:\\iText\\chillyfacts.png"));
			table.addCell("");
			document.add(table);
			float[] colsWidth = { 1f, 1f, 1f, 1f }; // Code 1
			table = new PdfPTable(colsWidth);
			table.getDefaultCell().setBorder(0);
			table.setWidthPercentage(100); // Code 2
			table.setHorizontalAlignment(Element.ALIGN_LEFT);// Code 3
			table.addCell("Employee ID");
			table.addCell(salaryData[i].getESI_Account_Number());
			table.addCell("Name");
			table.addCell(salaryData[i].getName());
			table.addCell("Department");
			table.addCell(salaryData[i].getDepartment());
			table.addCell("Designation");
			table.addCell(salaryData[i].getDesignation());
			table.addCell("Date Of Joining");
			table.addCell(salaryData[i].getDate_Of_Joining());
			table.addCell("PF Account No");
			table.addCell(salaryData[i].getPF_Account_No());
			table.addCell("Days Worked");
			table.addCell(salaryData[i].getDays_Worked());
			table.addCell("ESI Account Number");
			table.addCell(salaryData[i].getESI_Account_Number());
			table.addCell("Casual Leave");
			table.addCell(salaryData[i].getCasual_Leave());
			table.addCell("Adhar Number");
			table.addCell(salaryData[i].getAdhar_Number());
			table.addCell("PAN Number");
			table.addCell(salaryData[i].getPAN_Number());
			table.addCell(" ");
			table.addCell(" ");
			table.addCell(" ");
			table.addCell(" ");
			document.add(table);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
			PdfPTable table1 = new PdfPTable(colsWidth);
			table1.setWidthPercentage(100); // Code 2
			table1.setHorizontalAlignment(Element.ALIGN_LEFT);// Code 3
			Phrase Earnings = new Phrase("Earnings", boldFont);
			Phrase Amount = new Phrase("Amount", boldFont);
			Phrase Deductions = new Phrase("Deductions", boldFont);
			Phrase Amount1 = new Phrase("Amount1", boldFont);
			Phrase total_earnings = new Phrase("Total Earning", boldFont);
			Phrase total_deductions = new Phrase("Total Deductions", boldFont);
			table1.addCell(Earnings);
			table1.addCell(Amount);
			table1.addCell(Deductions);
			table1.addCell(Amount1);
			table1.addCell("Basic Pay");
			table1.addCell(salaryData[i].getFestival_Allowance());
			table1.addCell("PF");
			table1.addCell(salaryData[i].getPF());
			table1.addCell("HRA");
			table1.addCell(salaryData[i].getESI());
			table1.addCell("ESI");
			table1.addCell(salaryData[i].getHRA());
			table1.addCell("Festival Allowance");
			table1.addCell(salaryData[i].getFestival_Allowance());
			table1.addCell("Professional Taxes");
			table1.addCell(salaryData[i].getProfessional_Taxes());
			table1.addCell("Others");
			table1.addCell("Other");
			table1.addCell("Others");
			table1.addCell("Others");
			table1.addCell(total_earnings);
			table1.addCell("Others");
			table1.addCell(total_deductions);
			table1.addCell(salaryData[i].getDeductions());
			document.add(table1);
			PdfPTable table2 = new PdfPTable(colsWidth);
			table2.setWidthPercentage(100); // Code 2
			table2.getDefaultCell().setBorder(0);
			table2.setHorizontalAlignment(Element.ALIGN_MIDDLE);// Code 3
			Phrase employers_signature = new Phrase("Employer's Signature", boldFont);
			Phrase employees_signature = new Phrase("Employee's Signature", boldFont);
			document.add(Chunk.NEWLINE);
			table2.addCell(" ");
			table2.addCell(" ");
			table2.addCell(" ");
			table2.addCell(" ");
			table2.addCell(employers_signature);
			table2.addCell("");
			table2.addCell(employees_signature);
			table2.addCell("");
			document.add(Chunk.NEWLINE);
			document.add(table2);
			PdfContentByte cb = writer.getDirectContent();
			cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, false), 24);
			cb.setLineWidth(3);
			cb.moveTo(10, 515);
			cb.lineTo(770, 515);
			cb.moveTo(10, 10);
			cb.lineTo(770, 10);
			cb.moveTo(770, 515);
			cb.lineTo(770, 10);
			cb.moveTo(10, 515);
			cb.lineTo(10, 10);
			cb.stroke();

			document.newPage();
		}
		document.close();
		String ecodedFile = encodeFileToBase64Binary(new File(FILE_NAME));// Encode method call

		return ecodedFile;
	}

	/*
	 * { "SalaryData":[ { "Name": "Firoz P", "Department": "Java Developer",
	 * "Designation": "Software Developer", "Date_Of_Joining": "28-05-2018",
	 * "PF_Account_No": "ASD1231313ASD", "Days_Worked": "30", "ESI_Account_Number":
	 * "234567890987", "Casual_Leave": "1", "Adhar_Number": "234567890987",
	 * "PAN_Number": "ADT4567890", "PF": "500", "HRA": "200", "ESI": "0",
	 * "Festival_Allowance": "500", "Professional_Taxes": "2", "Amount": "500000",
	 * "Deductions": "500", "Earnings": "500000", "Total_Earning": "500000",
	 * "Total_Deductions": "500" }, { "Name": "Aman P", "Department":
	 * ".Net Developer", "Designation": "Software Developer", "Date_Of_Joining":
	 * "28-05-2018", "PF_Account_No": "ASD1231313ASD", "Days_Worked": "30",
	 * "ESI_Account_Number": "234567890987", "Casual_Leave": "1", "Adhar_Number":
	 * "234567890987", "PAN_Number": "ADT4567890", "PF": "500", "HRA": "200", "ESI":
	 * "0", "Festival_Allowance": "500", "Professional_Taxes": "2", "Amount":
	 * "500000", "Deductions": "500", "Earnings": "500000", "Total_Earning":
	 * "500000", "Total_Deductions": "500" },{ "Name": "Vikas P", "Department":
	 * "BDA Developer", "Designation": "Software Developer", "Date_Of_Joining":
	 * "28-05-2018", "PF_Account_No": "ASD1231313ASD", "Days_Worked": "30",
	 * "ESI_Account_Number": "234567890987", "Casual_Leave": "1", "Adhar_Number":
	 * "234567890987", "PAN_Number": "ADT4567890", "PF": "500", "HRA": "200", "ESI":
	 * "0", "Festival_Allowance": "500", "Professional_Taxes": "2", "Amount":
	 * "500000", "Deductions": "500", "Earnings": "500000", "Total_Earning":
	 * "500000", "Total_Deductions": "500" },{ "Name": "Samad P", "Department":
	 * ".freelance Developer", "Designation": "Software Developer",
	 * "Date_Of_Joining": "28-05-2018", "PF_Account_No": "ASD1231313ASD",
	 * "Days_Worked": "30", "ESI_Account_Number": "234567890987", "Casual_Leave":
	 * "1", "Adhar_Number": "234567890987", "PAN_Number": "ADT4567890", "PF": "500",
	 * "HRA": "200", "ESI": "0", "Festival_Allowance": "500", "Professional_Taxes":
	 * "2", "Amount": "500000", "Deductions": "500", "Earnings": "500000",
	 * "Total_Earning": "500000", "Total_Deductions": "500" },{ "Name": "Ahad P",
	 * "Department": "SalesForce Developer", "Designation": "Software Developer",
	 * "Date_Of_Joining": "28-05-2018", "PF_Account_No": "ASD1231313ASD",
	 * "Days_Worked": "30", "ESI_Account_Number": "234567890987", "Casual_Leave":
	 * "1", "Adhar_Number": "234567890987", "PAN_Number": "ADT4567890", "PF": "500",
	 * "HRA": "200", "ESI": "0", "Festival_Allowance": "500", "Professional_Taxes":
	 * "2", "Amount": "500000", "Deductions": "500", "Earnings": "500000",
	 * "Total_Earning": "500000", "Total_Deductions": "500" }] }
	 */

//http://localhost:8080/MyFirstJersy/webapi/myresource/getMultipleSalarySlip

	@Path("/getMultipleSalarySlipInMultipleFiles")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getMultipleSalarySlipInMultipleFiles(String input) throws DocumentException, IOException {
		Gson gson = new Gson();
		MultipleSalarySlip salary_Slip = new MultipleSalarySlip();

		salary_Slip = gson.fromJson(input, salary_Slip.getClass());
		SalaryData salaryData[] = salary_Slip.getSalaryData();
		
		Rectangle pageSize = new Rectangle(780, 525);
		Document document = new Document(pageSize);

		for (int i = 0; i < salaryData.length; i++) {

			String FILE_NAME = "E://iText//" + salaryData[i].getName() + ".pdf";
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

			document.open();

			float[] colsWidth1 = { 1f, 1f, 1f, 1f, 1f }; // Code 1
			// Image image = Image.getInstance(path+"employee/payslip/view/fly-hind.jpg");
			PdfPTable table = new PdfPTable(colsWidth1);
			table.getDefaultCell().setBorder(0);
			table.setWidthPercentage(100); // Code 2
			table.setHorizontalAlignment(Element.ALIGN_LEFT);// Code 3
			table.addCell("");
			table.addCell("");

			Date date = new Date();
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Month month = localDate.getMonth();

			table.addCell("Pay Slip For The Month " + month + "");
			table.addCell("");
			table.addCell("");
			document.add(table);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			float[] colsWidth_main = { 1f, 1f, 1f }; // Code 1
			table = new PdfPTable(colsWidth_main);
			table.getDefaultCell().setBorder(0);
			table.setWidthPercentage(100); // Code 2
			table.setHorizontalAlignment(Element.ALIGN_LEFT);// Code 3
			table.addCell("");
			table.addCell(Image.getInstance("E:\\iText\\chillyfacts.png"));
			table.addCell("");
			document.add(table);
			float[] colsWidth = { 1f, 1f, 1f, 1f }; // Code 1
			table = new PdfPTable(colsWidth);
			table.getDefaultCell().setBorder(0);
			table.setWidthPercentage(100); // Code 2
			table.setHorizontalAlignment(Element.ALIGN_LEFT);// Code 3
			table.addCell("Employee ID");
			table.addCell(salaryData[i].getESI_Account_Number());
			table.addCell("Name");
			table.addCell(salaryData[i].getName());
			table.addCell("Department");
			table.addCell(salaryData[i].getDepartment());
			table.addCell("Designation");
			table.addCell(salaryData[i].getDesignation());
			table.addCell("Date Of Joining");
			table.addCell(salaryData[i].getDate_Of_Joining());
			table.addCell("PF Account No");
			table.addCell(salaryData[i].getPF_Account_No());
			table.addCell("Days Worked");
			table.addCell(salaryData[i].getDays_Worked());
			table.addCell("ESI Account Number");
			table.addCell(salaryData[i].getESI_Account_Number());
			table.addCell("Casual Leave");
			table.addCell(salaryData[i].getCasual_Leave());
			table.addCell("Adhar Number");
			table.addCell(salaryData[i].getAdhar_Number());
			table.addCell("PAN Number");
			table.addCell(salaryData[i].getPAN_Number());
			table.addCell(" ");
			table.addCell(" ");
			table.addCell(" ");
			table.addCell(" ");
			document.add(table);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
			PdfPTable table1 = new PdfPTable(colsWidth);
			table1.setWidthPercentage(100); // Code 2
			table1.setHorizontalAlignment(Element.ALIGN_LEFT);// Code 3
			Phrase Earnings = new Phrase("Earnings", boldFont);
			Phrase Amount = new Phrase("Amount", boldFont);
			Phrase Deductions = new Phrase("Deductions", boldFont);
			Phrase Amount1 = new Phrase("Amount1", boldFont);
			Phrase total_earnings = new Phrase("Total Earning", boldFont);
			Phrase total_deductions = new Phrase("Total Deductions", boldFont);
			table1.addCell(Earnings);
			table1.addCell(Amount);
			table1.addCell(Deductions);
			table1.addCell(Amount1);
			table1.addCell("Basic Pay");
			table1.addCell(salaryData[i].getFestival_Allowance());
			table1.addCell("PF");
			table1.addCell(salaryData[i].getPF());
			table1.addCell("HRA");
			table1.addCell(salaryData[i].getESI());
			table1.addCell("ESI");
			table1.addCell(salaryData[i].getHRA());
			table1.addCell("Festival Allowance");
			table1.addCell(salaryData[i].getFestival_Allowance());
			table1.addCell("Professional Taxes");
			table1.addCell(salaryData[i].getProfessional_Taxes());
			table1.addCell("Others");
			table1.addCell("Other");
			table1.addCell("Others");
			table1.addCell("Others");
			table1.addCell(total_earnings);
			table1.addCell("Others");
			table1.addCell(total_deductions);
			table1.addCell(salaryData[i].getDeductions());
			document.add(table1);
			PdfPTable table2 = new PdfPTable(colsWidth);
			table2.setWidthPercentage(100); // Code 2
			table2.getDefaultCell().setBorder(0);
			table2.setHorizontalAlignment(Element.ALIGN_MIDDLE);// Code 3
			Phrase employers_signature = new Phrase("Employer's Signature", boldFont);
			Phrase employees_signature = new Phrase("Employee's Signature", boldFont);
			document.add(Chunk.NEWLINE);
			table2.addCell(" ");
			table2.addCell(" ");
			table2.addCell(" ");
			table2.addCell(" ");
			table2.addCell(employers_signature);
			table2.addCell("");
			table2.addCell(employees_signature);
			table2.addCell("");
			document.add(Chunk.NEWLINE);
			document.add(table2);
			PdfContentByte cb = writer.getDirectContent();
			cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, false), 24);
			cb.setLineWidth(3);
			cb.moveTo(10, 515);
			cb.lineTo(770, 515);
			cb.moveTo(10, 10);
			cb.lineTo(770, 10);
			cb.moveTo(770, 515);
			cb.lineTo(770, 10);
			cb.moveTo(10, 515);
			cb.lineTo(10, 10);
			cb.stroke();

			document.newPage();
		}
		document.close();
		// String ecodedFile = encodeFileToBase64Binary(new File(FILE_NAME));// Encode
		// method call
		String ecodedFile = "Done";

		return ecodedFile;
	}

	// Base64-pdf-merge-base64(encode)

@Path("/getclidoc")
@POST
@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String B64MB64(String input) throws DocumentException, IOException {
	
		Gson gson = new Gson();
		PdfData pdfData =new PdfData();
		pdfData = gson.fromJson(input, pdfData.getClass());
	
		Document document;
		String response = "";
		ArrayList<byte[]> ids = new ArrayList<byte[]>();
		for(int j=0;j<pdfData.getClidocid().length;j++)
		{
			DMSDownloadDocSrvcImpl dm =new DMSDownloadDocSrvcImpl();
			ids.add(dm.getDocBase64(pdfData.getClidocid()[j]));	
		}
		
		File file;
		List<InputStream> inputPdfList = new ArrayList<InputStream>();
		for (int i = 0; i < ids.size(); i++) {
			String encryptedData = "";// ==DMSCALL return array
			//byte[] decodedBytes = Base64.getDecoder().decode(ids[i].getBytes());

		//	System.out.println(decodedBytes);
			file = new File("E:/iText/data/" + i + ".pdf");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(ids.get(i));

			inputPdfList.add(new FileInputStream(file));
		}
		try {

			OutputStream outputStream = new FileOutputStream("E:\\iText\\data\\CLIDoc.pdf");

			for (int j = 0; j <= inputPdfList.size(); j++) {
				System.out.println(j);
				System.out.println(inputPdfList.size());
				
				document = mergePdf(inputPdfList, outputStream);				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	     byte[] input_file = Files.readAllBytes(Paths.get("E:\\iText\\data\\CLIDoc.pdf"));

	        byte[] encodedBytes = Base64.getEncoder().encode(input_file);
	        String encodedString =  new String(encodedBytes);
	        
		// String ecodedFile = encodeFileToBase64Binary(document);// Encode
		return encodedString;

	}

	private static Document mergePdf(List<InputStream> list, OutputStream outputStream)
			throws DocumentException, IOException {
		Document document = new Document();
		PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);
		document.open();
		PdfContentByte pdfContentByte = pdfWriter.getDirectContent();

		for (InputStream inputStream : list) {
			PdfReader pdfReader = new PdfReader(inputStream);
			for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
				document.newPage();
				PdfImportedPage page = pdfWriter.getImportedPage(pdfReader, i);
				pdfContentByte.addTemplate(page, 0, 0);
			}
		}
		outputStream.flush();
		document.close();
		outputStream.close();

		return document;
	}

	// get Json data from
	// Postman-----------------------------------------------------------

	/*
	 * 
	 * { "info": { "_postman_id": "55bfd7ff-1392-42ce-a63f-88dd7ed82c04", "name":
	 * "Genie DMZ", "schema":
	 * "https://schema.getpostman.com/json/collection/v2.1.0/collection.json" },
	 * "item": [ { "name": "Genie", "request": { "method": "POST", "header": [],
	 * "body": { "mode": "raw", "raw": "" }, "url": { "raw":
	 * "https://genie.ltfs.com:8443/Genie/messageApi?accId=Sangam&msgId=1234567890&phoneNo=9421519335&text=testing&password=123456&method=single",
	 * "protocol": "https", "host": [ "genie", "ltfs", "com" ], "port": "8443",
	 * "path": [ "Genie", "messageApi" ], "query": [ { "key": "accId", "value":
	 * "Sangam" }, { "key": "msgId", "value": "1234567890" }, { "key": "phoneNo",
	 * "value": "9421519335" }, { "key": "text", "value": "testing" }, { "key":
	 * "password", "value": "123456" }, { "key": "method", "value": "single" } ] }
	 * }, "response": [] } ] }
	 * 
	 */

	// http://localhost:8080/MyFirstJersy/webapi/myresource/getGennie
	@POST
	@Path("/getGennie")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGennie(String input) throws UnsupportedEncodingException {
		Gson gson = new Gson();
		com.ValuefirstToGenie.MyPojo myPojo = new com.ValuefirstToGenie.MyPojo();

		myPojo = (com.ValuefirstToGenie.MyPojo) gson.fromJson(input, myPojo.getClass());
		System.out.println("inside api Data input:: " + myPojo);
		com.ValuefirstToGenie.Info info = myPojo.getInfo();
		Item[] item = myPojo.getItem();
		System.out.println("info.get_postman_id() " + info.get_postman_id());
		System.out.println("info.getName() " + info.getName());
		System.out.println("info.getSchema() " + info.getSchema());

		System.out.println("item[0].getName() " + item[0].getName());
		System.out.println("item[0].getRequest() " + item[0].getRequest());
		System.out.println("item[0].getRequest(.getMethod) " + item[0].getRequest().getMethod());
		System.out.println("item[0].getRequest(.getBody).getMode " + item[0].getRequest().getBody().getMode());
		System.out.println("item[0].getRequest(.getBody).getRaw " + item[0].getRequest().getBody().getRaw());
		System.out.println("item[0].getRequest().getHeader " + item[0].getRequest().getHeader());
		System.out.println("item[0].getRequest().GETuRL getPort " + item[0].getRequest().getUrl().getPort());
		System.out.println("item[0].getRequest().getUrl.getProtocol " + item[0].getRequest().getUrl().getProtocol());
		System.out.println("item[0].getRequest().getUrl.getRaw " + item[0].getRequest().getUrl().getRaw());

		
		
		
		
		
		Url url = item[0].getRequest().getUrl();
		for (String hostdata : url.getHost()) {
			System.out.println(" item[0].getRequest().getUrl.getHost " + hostdata);
		}

		url = item[0].getRequest().getUrl();
		for (String pathdata : url.getPath()) {
			System.out.println("item[0].getRequest().getUrl.getPath " + pathdata);
		}

		url = item[0].getRequest().getUrl();
		for (Query getQuery : url.getQuery()) {
			System.out.println("item[0].getRequest().getUrl.getQuery  " + getQuery);
		}

		System.out.println("item[0].getResponse() " + item[0].getResponse());

		

	//	OkHttpClient client = new OkHttpClient();

		String uri=item[0].getRequest().getUrl().getProtocol()+"://"+item[0].getRequest().getUrl().getHost()[0]+"."+item[0].getRequest().getUrl().getHost()[1]+"."+item[0].getRequest().getUrl().getHost()[2]+":"+item[0].getRequest().getUrl().getPort()+"/"+item[0].getRequest().getUrl().getPath()[0]+"/"+item[0].getRequest().getUrl().getPath()[1]+"?"
				+item[0].getRequest().getUrl().getQuery()[0].getKey()+"="+item[0].getRequest().getUrl().getQuery()[0].getValue()
				+"&"+item[0].getRequest().getUrl().getQuery()[1].getKey()+"="+item[0].getRequest().getUrl().getQuery()[1].getValue()
				+"&"+item[0].getRequest().getUrl().getQuery()[2].getKey()+"="+item[0].getRequest().getUrl().getQuery()[2].getValue()
				+"&"+item[0].getRequest().getUrl().getQuery()[3].getKey()+"="+item[0].getRequest().getUrl().getQuery()[3].getValue()
				+"&"+item[0].getRequest().getUrl().getQuery()[4].getKey()+"="+item[0].getRequest().getUrl().getQuery()[4].getValue()
				+"&"+item[0].getRequest().getUrl().getQuery()[5].getKey()+"="+item[0].getRequest().getUrl().getQuery()[5].getValue();
		
		//	https://genie.ltfs.com:8443/Genie/messageApi?accId=Sangam&msgId=1234567890&phoneNo=9421519335&text=testing&password=123456&method=single",
	
		//FetchURL fetchUrl = new FetchURL();
		//String uri1=fetchUrl.getSendSmsGenieUrl();
		String uri1="https://genie.ltfs.com:8443/Genie/messageApi";
	
	String	requestUrl1 = uri1 + "?accId=" + URLEncoder.encode(item[0].getRequest().getUrl().getQuery()[0].getValue(), "UTF-8") 
		+ "&msgId="+ URLEncoder.encode(item[0].getRequest().getUrl().getQuery()[1].getValue(), "UTF-8") +
		"&phoneNo=" +URLEncoder.encode(item[0].getRequest().getUrl().getQuery()[2].getValue(), "UTF-8") +
		"&text="	+ URLEncoder.encode(item[0].getRequest().getUrl().getQuery()[3].getValue(), "UTF-8") + 
		"&password="	+ URLEncoder.encode(item[0].getRequest().getUrl().getQuery()[4].getValue(), "UTF-8") +
		"&method="	+ URLEncoder.encode(item[0].getRequest().getUrl().getQuery()[5].getValue(), "UTF-8") +"&dlr-mask=19";
		
	// requestUrl="http://www.myvaluefirst.com/smpp/sendsms?username=sangamltfs&password=ltfnce89&to=9752165945&from=LNTFIN&text=DEAR%20CUSTOMER,%20YOUR%20ONE-TIME%20PASSWORD%20FOR%20THE%20APPLICATION%20IS%20123456&dlr-mask=19&dlr-url";
	
	//	https://genie.ltfs.com:8443/Genie/messageApi?accId=Sangam&msgId=1234567890&phoneNo=9421519335&text=testing&password=123456&method=single",
	
		
	//	OkHttpClient client = new OkHttpClient();

		
		System.out.println("requestUrl"+requestUrl1);
	
/*
		Request request = new Request.Builder().url(requestUrl).get().addHeader("cache-control", "no-cache").build();

		Response response = client.newCall(request).execute();
		System.out.println(response);

		if (response.code() != 200) {
			ErrorCodeLog.saveResponseCode("perfios", to, request.url().toString(), response.code() + "");
		}

		InputStream is = response.body().byteStream();

		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		String inputLine;
		StringBuffer res = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			res.append(inputLine);
		}
		in.close();
		System.out.println(res.toString());
		return res.toString(); }
	*/

		
	return Response.status(200).entity("See the Console").build();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// get Json data from asasd
	// Postman-----------------------------------------------------------

	/*
	 * 
	 * { "info": { "_postman_id": "55bfd7ff-1392-42ce-a63f-88dd7ed82c04", "name":
	 * "Genie DMZ", "schema":
	 * "https://schema.getpostman.com/json/collection/v2.1.0/collection.json" },
	 * "item": [ { "name": "Genie", "request": { "method": "POST", "header": [],
	 * "body": { "mode": "raw", "raw": "" }, "url": { "raw":
	 * "https://genie.ltfs.com:8443/Genie/messageApi?accId=Sangam&msgId=1234567890&phoneNo=9421519335&text=testing&password=123456&method=single",
	 * "protocol": "https", "host": [ "genie", "ltfs", "com" ], "port": "8443",
	 * "path": [ "Genie", "messageApi" ], "query": [ { "key": "accId", "value":
	 * "Sangam" }, { "key": "msgId", "value": "1234567890" }, { "key": "phoneNo",
	 * "value": "9421519335" }, { "key": "text", "value": "testing" }, { "key":
	 * "password", "value": "123456" }, { "key": "method", "value": "single" } ] }
	 * }, "response": [] } ] }
	 * 
	 */

	// http://localhost:8080/MyFirstJersy/webapi/myresource/getGennie
	@POST
	@Path("/getGennieSms")
	@Produces(MediaType.APPLICATION_JSON)
	public static String getGennieSms(String input) throws IOException {
		Gson gson = new Gson();
		com.ValuefirstToGenie.MyPojo myPojo = new com.ValuefirstToGenie.MyPojo();

		myPojo = (com.ValuefirstToGenie.MyPojo) gson.fromJson(input, myPojo.getClass());
		com.ValuefirstToGenie.Info info = myPojo.getInfo();
		Item[] item = myPojo.getItem();


	//FetchURL fetchUrl = new FetchURL();
	//String uri1=fetchUrl.getSendSmsGenieUrl();
				String uri="https://genie.ltfs.com:8443/Genie/messageApi";
				String accId=item[0].getRequest().getUrl().getQuery()[0].getValue();
				String msgId=item[0].getRequest().getUrl().getQuery()[1].getValue();
				String phoneNo=item[0].getRequest().getUrl().getQuery()[2].getValue();
				String text=item[0].getRequest().getUrl().getQuery()[3].getValue();
				String password=item[0].getRequest().getUrl().getQuery()[4].getValue();
				String method=item[0].getRequest().getUrl().getQuery()[5].getValue();

			
	
				String	requestUrl = uri + "?accId=" + URLEncoder.encode(accId, "UTF-8") +
				"&msgId="+ URLEncoder.encode(msgId, "UTF-8") +
				"&phoneNo=" +URLEncoder.encode(phoneNo, "UTF-8")+
				"&text="+ URLEncoder.encode(text, "UTF-8") + 
				"&password="+ URLEncoder.encode(password, "UTF-8") +
				"&method="+ URLEncoder.encode(method, "UTF-8") +"&dlr-mask=19";
		
				
				
				
			

				
				
	//	https://genie.ltfs.com:8443/Genie/messageApi?accId=Sangam&msgId=1234567890&phoneNo=9752165945&messagetype=SMS:TEXT&text=Hi%2C+This+is+my+first+SMS+by+Genie&password=123456&method=single&dlr-mask=19
			System.out.println(URLEncoder.encode(text, "UTF-8"));
				
// requestUrl="http://www.myvaluefirst.com/smpp/sendsms?username=sangamltfs&password=ltfnce89&to=9752165945&from=LNTFIN&text=DEAR%20CUSTOMER,%20YOUR%20ONE-TIME%20PASSWORD%20FOR%20THE%20APPLICATION%20IS%20123456&dlr-mask=19&dlr-url";

	System.out.println(requestUrl);

			com.squareup.okhttp.OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(requestUrl).get().addHeader("cache-control", "no-cache").build();

			com.squareup.okhttp.Response response = client.newCall(request).execute();
			System.out.println(response);

			if (response.code() != 200) {
			//	ErrorCodeLog.saveResponseCode("perfios", to, request.url().toString(), response.code() + "");
			}

			InputStream is = response.body().byteStream();

			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				res.append(inputLine);
			}
			in.close();
			System.out.println(res.toString());
		
	
	return requestUrl;

	}	
	
	
	
	
	//--------------------------Bill Desk
	
	
	@POST
	@Path("/Bill-Desk")
	@Produces(MediaType.APPLICATION_JSON)
	public String BillDesk(String data)
	{
		Gson gson = new Gson();
		BilDesk bilDesk = new BilDesk();

		bilDesk = (BilDesk)gson.fromJson(data, bilDesk.getClass());
		
		
		
		String CustomerID = "t128";
		String uniqueTransactionNo = "t128";
		String bankId = "162";
		String amt = "12313";
		String productId = "101";
		String src = "abc";
		String messageString = "sadadad";

		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int ms = cal.get(Calendar.MILLISECOND);
		String Timestamp = Integer.toString(ms);


		Connection conndb=null;
		try {

			 Class.forName("com.mysql.jdbc.Driver");//load the driver class from jar files
			 conndb=DriverManager.getConnection("jdbc:mysql://localhost:3306/data?user=root&password=");  //create connection
	
		
		System.out.println(conndb);}
		 catch (Exception e) {
	System.out.println(e);
		}
		

		PreparedStatement prepareStatement;
		try {
	
			
	//	"insert into tbl_bildesk_logs (uniqueTransactionNo,bankID,amt,productId,src,messageString,Timestamp,CustomerID,merchantID,txnReferenceNo,bankReferenceNo,txnAmount,bankMerchantID,txnType,currencyName,itemCode,securityType,securityID,securityPassword,txnDate,authStatus,settlementType) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			prepareStatement = conndb.prepareCall(
					"insert into tbl_bildesk_logs (uniqueTransactionNo,bankID,amt,productId,src,messageString,Timestamp) values (?,?,?,?,?,?,?)");
			System.out.println(" inside "+prepareStatement);

			prepareStatement.setString(1, uniqueTransactionNo);
			prepareStatement.setString(2, bankId);
			prepareStatement.setString(3, amt);
			prepareStatement.setString(4, productId);
			prepareStatement.setString(5, src);
			prepareStatement.setString(6, messageString);
			prepareStatement.setString(7, Timestamp);
			prepareStatement.executeUpdate();
			
			String updateQuery = "UPDATE tbl_bildesk_logs SET merchantID=?,txnReferenceNo=?,bankReferenceNo=?,txnAmount=?,bankID=?,bankMerchantID=?,txnType=?,currencyName=?,itemCode=?,securityType=?,securityID=?,securityPassword=?,txnDate=?,authStatus=?,settlementType=? WHERE uniqueTransactionNo=?";

			String merchantID = "LTFSLOANDT";
			String securityID = "ltfsloandt";
			String txnReferenceNo = "2.00";
			String bankReferenceNo = "162";
			String txnAmount = amt;
			String bankID = bankId;
			String bankMerchantID = bankId;
			String currencyName = "INR";
			String securityPassword = "ltfs123";
			String authStatus = "true";
			String settlementType = "R";
			String txnDate = "F";
			String txnType = "F";
			String securityType = "F";
			String itemCode = "F";

			prepareStatement = conndb.prepareCall(updateQuery);
			prepareStatement.setString(1, merchantID);
			prepareStatement.setString(2, txnReferenceNo);
			prepareStatement.setString(3, bankReferenceNo);
			prepareStatement.setString(4, txnAmount);
			prepareStatement.setString(5, bankID);
			prepareStatement.setString(6, bankMerchantID);
			prepareStatement.setString(7, txnType);
			prepareStatement.setString(8, currencyName);
			prepareStatement.setString(9, itemCode);
			prepareStatement.setString(10, securityType);
			prepareStatement.setString(11, securityID);
			prepareStatement.setString(12, securityPassword);
			prepareStatement.setString(13, txnDate);
			prepareStatement.setString(14, authStatus);
			prepareStatement.setString(15, settlementType);
			prepareStatement.setString(16, CustomerID);
			prepareStatement.executeUpdate();

			
			
		} catch (Exception e) {
System.out.println(e.getMessage());	
}


		return "Done";

	}
	
	
	
	
	
//public void resPaymentGateway(String responseData) {

	
	/*
	 * 
	 * 
	 * 
	 * Gson gson = new Gson(); BilDesk bilDesk = new BilDesk();
	 * 
	 * bilDesk = (BilDesk)gson.fromJson(responseData, bilDesk.getClass());
	 * 
	 * String merchantID = ""; String customerID = ""; String txnReferenceNo = "";
	 * String bankReferenceNo = ""; String txnAmount = ""; String bankID = "";
	 * String bankMerchantID = ""; String txnType = ""; String currencyName = "";
	 * String itemCode = ""; String securityType = ""; String securityID = "";
	 * String securityPassword = ""; String txnDate = ""; String authStatus = "";
	 * String settlementType = "";
	 * 
	 * 
	 * String[] tmp = null; tmp = responseData.split("\\|");
	 * 
	 * merchantID = bilDesk.getMerchantID(); customerID = bilDesk.getCustomerID();
	 * txnReferenceNo =bilDesk.getTxnReferenceNo(); bankReferenceNo
	 * =bilDesk.getBankReferenceNo(); txnAmount = bilDesk.getTxnAmount(); bankID
	 * =bilDesk.getBankID(); bankMerchantID =bilDesk.getBankMerchantID(); txnType
	 * =bilDesk.getTxnType(); currencyName =bilDesk.getCurrencyName(); itemCode =
	 * bilDesk.getItemCode(); securityType = bilDesk.getSecurityType(); securityID
	 * =bilDesk.getSecurityID(); securityPassword = tmp[12]; txnDate
	 * =bilDesk.getTxnDate(); authStatus = bilDesk.getAuthStatus(); settlementType =
	 * bilDesk.getSettlementType();
	 * 
	 * 
	 * String updateQuery =
	 * "UPDATE tbl_bildesk_logs SET responseData=?, WHERE CustomerID = ?";
	 * prepareStatement = conndb.prepareCall(updateQuery);
	 * prepareStatement.setString(1, merchantID); prepareStatement.setString(2,
	 * txnReferenceNo); prepareStatement.setString(3, bankReferenceNo); }
	 * 
	 * 
	 * 
	 * 
	 */	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@POST
	@Path("/geFinalGennie")
	@Consumes(MediaType.APPLICATION_JSON)
	public String geFinalGennie(String data) throws IOException
	{
		
		
		
		Gson gson = new Gson(); Body body = new Body();
		body = (Body)gson.fromJson(data, body.getClass());
		
		System.out.println(body.getMode());
		System.out.println(body.getRaw());
		
		 
		String url="http://10.3.3.72:8080/Genie/messageApi";
		String a = "PLEASE CLICK ON " +body.getRaw();
		String ul = "";
		ul = URLEncoder.encode(a, "UTF-8");
		
		
		
	String	requestUrl = url + "?accId=" + URLEncoder.encode("5765", "UTF-8")
		+ "&msgId="+ URLEncoder.encode("1234567890", "UTF-8") 
		+ "&phoneNo=" + URLEncoder.encode(body.getMode(), "UTF-8") 
		+ "&text="+ ul
		+"&password="+ URLEncoder.encode("123456", "UTF-8")
		+"&method="+ URLEncoder.encode("single", "UTF-8")
		+"&mask="+ URLEncoder.encode("LNTFIN", "UTF-8");
			
	/*
	
	requestUrl = fetchUrl.getSendSmsUrl() + "?accId=" + URLEncoder.encode("5765", "UTF-8")
	+ "&msgId="+ URLEncoder.encode("1234567890", "UTF-8") 
	+ "&phoneNo=" + URLEncoder.encode(to, "UTF-8") 
	+ "&text="+ text
	+"&password="+ URLEncoder.encode("123456", "UTF-8")
	+"&method="+ URLEncoder.encode("single", "UTF-8")
	+"&mask="+ URLEncoder.encode("LNTFIN", "UTF-8");
		
*/
	
	
	

	com.squareup.okhttp.OkHttpClient client = new OkHttpClient();
	Request request = new Request.Builder().url(requestUrl).get().addHeader("cache-control", "no-cache").build();

	com.squareup.okhttp.Response response = client.newCall(request).execute();
	System.out.println(response);

	if (response.code() != 200) {
	//	ErrorCodeLog.saveResponseCode("perfios", to, request.url().toString(), response.code() + "");
	}

	InputStream is = response.body().byteStream();

	BufferedReader in = new BufferedReader(new InputStreamReader(is));
	String inputLine;
	StringBuffer res = new StringBuffer();
	while ((inputLine = in.readLine()) != null) {
		res.append(inputLine);
	}
	in.close();


return requestUrl;

}	

	@GET
	@Path("/message1")
	@Produces(MediaType.TEXT_PLAIN)
	public String secured() {
		return "This api is Secured	";
	}

	
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Object getCheckUp(String payload, @HeaderParam("lendToken") String lendToken) {
		boolean b = false;
		try {
			Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("LTTTTTTTTTTT"))
					.parseClaimsJws(lendToken).getBody();

			b = true;
		} catch (JwtException e) {

			// PerfiosLogger.error(e.getMessage(), e);

		}
	
	}

	
	
	public static void main(String[] args) {
		MyResource mr = new MyResource();
		Response response = mr.genderData("genderMstr");
		System.out.println(response.getEntity());

	}

}
