package APIGroup.ProjectAPI;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.api.util.FileStreamerutil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.apache.logging.log4j.core.util.Assert;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TC_POSTGMAP extends FileStreamerutil{

	TC_POSTGMAP postfile;
	public static String Place_id;
	public String name = prop.getProperty("Pname");
	public String phnum = prop.getProperty("Phnumber");
	public String city = prop.getProperty("city");
	SoftAssert softassert; 

	@Test(priority=1)
	public void postmap() throws IOException
	{
		postfile = new TC_POSTGMAP();

		RestAssured.baseURI= "https://rahulshettyacademy.com";
		Map <String,String> mp = new HashMap<String,String>();
		mp.put("Content-Type", "application/json");
		mp.put("Connection", "keep-alive");
		Response res =	given().log().all().relaxedHTTPSValidation().queryParam("key", "qaclick123").headers(mp).body(CommonBody.postbody(name, phnum, city)).
				when().post("maps/api/place/add/json").
				then().extract().response().prettyPeek();


		int status=	res.statusCode();
		if (status>=200&&status<=226) {

			System.out.println("This is the response "+res.asString());

			System.out.println("The status of the code is " +status);
			JSONObject js = new JSONObject(res.asString());
			Place_id= js.getString("place_id");
			System.out.println("The newly created place id is " + Place_id);
		}
		else
		{
			System.out.println("Unfortunately the the request was throwing "+status+" Code please check from the your end or contact service adminstrator");
		}
	}

	@Test(priority =2)
	public void Getmapdetails()
	{

		Map <String,String> queryparams = new HashMap<String,String>();
		queryparams.put("key", "qaclick123");
		queryparams.put("place_id", TC_POSTGMAP.Place_id );

		RestAssured.baseURI= "https://rahulshettyacademy.com";
		Map <String,String> mp = new HashMap<String,String>();
		mp.put("Content-Type", "application/json");
		mp.put("Connection", "keep-alive");
		Response res =	given().log().all().relaxedHTTPSValidation().queryParams(queryparams).headers(mp).body(CommonBody.postbody(name, phnum, city)).
				when().get("maps/api/place/get/json").
				then().extract().response().prettyPeek();

		int getstatus=	res.statusCode();
		System.out.println("The status of get request is "+getstatus);


		if (getstatus>=200&&getstatus<=226) {

			System.out.println("This is the response "+res.asString());

			System.out.println("The status of the code is " +getstatus);
			JSONObject js = new JSONObject(res.asString());

			String getname=	js.getString("name");
			String phnum = js.getString("phone_number");

			if(getname.equalsIgnoreCase(name)&&phnum.equalsIgnoreCase(phnum))
			{

				System.out.println("Expected name "+getname+" Expected Phnumber "+phnum+" are retrieved succesfully");
			}
			else
			{
				
				System.out.println("Expected name "+getname+" Expected Phnumber "+phnum+" Unable retrieve unfortunately");
				softassert = new SoftAssert();
				softassert.assertEquals(name, getname);
			

			}

		}
		else
		{
			System.out.println("Unfortunately the the request was throwing "+getstatus+" Code please check from the your end or contact service adminstrator");
			softassert = new SoftAssert();
			softassert.assertEquals(200, getstatus);
			
		}

	}	


	@Test(priority=3)
	public void deleteMap()
	{

		Map <String,String> queryparams = new HashMap<String,String>();
		queryparams.put("key", "qaclick123");

		RestAssured.baseURI= "https://rahulshettyacademy.com";
		Map <String,String> mp = new HashMap<String,String>();
		mp.put("Content-Type", "application/json");
		mp.put("Connection", "keep-alive");
		Response res =	given().log().all().relaxedHTTPSValidation().queryParams(queryparams).headers(mp).body(CommonBody.deletebody(TC_POSTGMAP.Place_id)).
				when().delete("maps/api/place/delete/json").
				then().extract().response().prettyPeek();

		int getstatus=	res.statusCode();
		System.out.println("The status of get request is "+getstatus);


		if (getstatus>=200&&getstatus<=226) {

			System.out.println("This is the response "+res.asString());

			System.out.println("The status of the code is " +getstatus);
			JSONObject js = new JSONObject(res.asString());
			String delstatus=	js.getString("status");

			if(delstatus.equalsIgnoreCase("OK"))
			{
				System.out.println("The Place ID "+TC_POSTGMAP.Place_id+" has been deleted");

			}
			else
			{
				System.out.println("The Place ID "+TC_POSTGMAP.Place_id+" has Not been deleted");
			}
		}
		else
		{
			System.out.println("Unfortunately the the request was throwing "+getstatus+" Code please check from the your end or contact service adminstrator");
		}

	}

}




