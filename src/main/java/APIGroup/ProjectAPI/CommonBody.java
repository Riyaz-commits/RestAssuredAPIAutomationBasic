package APIGroup.ProjectAPI;

public class CommonBody {

	public static String  postbody(String name,String phonenumber,String City)
	{
		
		
	
		 return "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" +
		  "    \"lng\": 33.427362\r\n" + "  },\r\n" + "  \"accuracy\": 50,\r\n" +
		  "  \"name\": \""+name+"\",\r\n" +
		  "  \"phone_number\": \""+phonenumber+"\",\r\n" +
		  "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n" +
		  "    \""+City+"\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n" +
		  "  \"website\": \"http://google.com\",\r\n" +
		  "  \"language\": \"French-IN\"\r\n" + "}";
		 
		/*
		 * return "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" +
		 * "    \"lng\": 33.427362\r\n" + "  },\r\n" + "  \"accuracy\": 50,\r\n" +
		 * "  \"name\": \"Frontline house\",\r\n" +
		 * "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" +
		 * "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n" +
		 * "    \"BLR park\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n" +
		 * "  \"website\": \"http://google.com\",\r\n" +
		 * "  \"language\": \"French-IN\"\r\n" + "}";
		 */
	}
	
	
	public static String deletebody(String placeid ) {
		
		
		return "{\r\n"
				+ "\r\n"
				+ "    \"place_id\":\""+placeid+"\"\r\n"
				+ "}";
	}
}