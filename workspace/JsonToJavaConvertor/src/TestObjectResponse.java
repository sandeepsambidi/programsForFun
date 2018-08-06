import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.Gson;

public class TestObjectResponse {
	public static void main(String[] args) {
		Gson gson = new Gson();
		String json = "{\r\n  \"records\": [{\r\n      \"Description\": \"Integration test\",\r\n      \"LastUpdatedTime\": \"2017-05-25 19:47:41.0\",\r\n      \"SoftDeleteFlag\": true,\r\n      \"_metadata\": {\r\n        \"checksum\": \"d79f9140ba68b1dc74356f298dff7bb6912e22acd7ba2e679a8b0bd0b0c74004\",\r\n        \"action\": \"delete\"\r\n      },\r\n      \"AddressId\": 1853\r\n    },\r\n    {\r\n      \"Description\": \"New address\",\r\n      \"LastUpdatedTime\": \"2017-05-25 19:30:15.0\",\r\n      \"SoftDeleteFlag\": true,\r\n      \"_metadata\": {\r\n        \"checksum\": \"dc537d2e956dd10ed974dc03550b850ace2b8ed8091c0d30d0cfea37343cbce9\",\r\n        \"action\": \"delete\"\r\n      },\r\n      \"AddressId\": 1854\r\n    },\r\n    {\r\n      \"Description\": \"Update and delete\",\r\n      \"LastUpdatedTime\": \"2017-05-25 19:47:11.0\",\r\n      \"SoftDeleteFlag\": false,\r\n      \"_metadata\": {\r\n        \"checksum\": \"11cc20f0aa51de3c8f6141b73ca43afa6bb3be05558356d568425cfafe87863c\",\r\n        \"action\": \"partialupdate\"\r\n      },\r\n      \"AddressId\": 1855\r\n    }\r\n  ],\r\n  \"_metadata\": {\r\n    \"recordCount\": 3,\r\n    \"updatedRecords\": 1,\r\n    \"deletedRecords\": 2\r\n  },\r\n  \"delta_context\": {\r\n    \"objs\": {\r\n      \"address\": {\r\n        \"delta\": \"2017-05-25T19:47:41+05:30\",\r\n        \"field1\": \"fsg\",\r\n        \"filed2\": \"gfdd\"\r\n      },\r\n      \"user\": {\r\n        \"delta\": \"2017-05-25T19:47:41+05:30\",\r\n        \"field1\": \"fsg\",\r\n        \"filed2\": \"gfdd\"\r\n      }\r\n    }\r\n  },\r\n  \"opstatus\": 0,\r\n  \"httpStatusCode\": 0\r\n}";
		DownloadResponseOfObject resultObj = gson.fromJson(json, DownloadResponseOfObject.class);
		Map record = ((Map)resultObj.getRecords().get(0));
		System.out.println("metadata instance pf = "+(record.get("_metadata") instanceof Map));
		Map recordMetadata = (Map)record.get("_metadata");//jsonObject.optJSONObject(Constants._METADATA);
        if(recordMetadata != null)
        {
            String actionString = recordMetadata.get("action").toString();
            System.out.println(actionString);
        }
        System.out.println(record.get("Description"));
        Iterator<String> iterator = record.keySet().iterator();//jsonObject.keys();
        HashMap<String, Object> hm = new HashMap<String,Object>();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = record.get(key);
            hm.put(key, value);
        }
        System.out.println("hm = "+hm.toString() +" instance of :"+(hm instanceof Map));
	}
}
