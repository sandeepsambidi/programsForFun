import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class TestObjectServiceResponse {
	
	
	public static void main(String[] args) {
//		Gson gson = new Gson();
//		String json = "{\r\n  \"Objects\": [\r\n    {\r\n      \"records\": [\r\n        {\r\n          \"LastUpdatedTime\": \"2017-05-25 18:24:40.0\",\r\n          \"Id\": \"Facebook\",\r\n          \"_metadata\": {\r\n            \"checksum\": \"ddfc3410dd18cfd0fc7ce41f6425655ef3cbb8c28504691913f490685699d944\",\r\n            \"action\": \"partialupdate\"\r\n          },\r\n          \"Url\": \"1234\"\r\n        }\r\n      ],\r\n      \"_metadata\": {\r\n        \"recordCount\": 1,\r\n        \"updatedRecords\": 1,\r\n        \"deletedRecords\": 0\r\n      },\r\n      \"opstatus\": 0,\r\n      \"httpStatusCode\": 0,\r\n      \"name\": \"socialnetwork\"\r\n    },\r\n    {\r\n      \"records\": [\r\n        {\r\n          \"Description\": \"Update and delete\",\r\n          \"LastUpdatedTime\": \"2017-05-25 19:47:11.0\",\r\n          \"SoftDeleteFlag\": false,\r\n          \"_metadata\": {\r\n            \"checksum\": \"11cc20f0aa51de3c8f6141b73ca43afa6bb3be05558356d568425cfafe87863c\",\r\n            \"action\": \"partialupdate\"\r\n          },\r\n          \"AddressId\": 1855\r\n        }\r\n      ],\r\n      \"_metadata\": {\r\n        \"recordCount\": 1,\r\n        \"updatedRecords\": 1,\r\n        \"deletedRecords\": 0\r\n      },\r\n      \"opstatus\": 0,\r\n      \"httpStatusCode\": 0,\r\n      \"name\": \"address\"\r\n    },\r\n    {\r\n      \"records\": [\r\n        {\r\n          \"ProfileId\": 12,\r\n          \"SocialNetworkId\": \"Facebook\",\r\n          \"Description\": \"Inte\",\r\n          \"UserId\": 1853,\r\n          \"LastUpdatedTime\": \"2017-05-25 18:35:10.0\",\r\n          \"SoftDeleteFlag\": true,\r\n          \"_metadata\": {\r\n            \"checksum\": \"8f62556a9f60a0110af465253f6ae260d21754abf38c4c08fcfe69785defd4e5\",\r\n            \"action\": \"delete\"\r\n          }\r\n        }\r\n      ],\r\n      \"_metadata\": {\r\n        \"recordCount\": 1,\r\n        \"updatedRecords\": 0,\r\n        \"deletedRecords\": 1\r\n      },\r\n      \"opstatus\": 0,\r\n      \"httpStatusCode\": 0,\r\n      \"name\": \"profile\"\r\n    },\r\n    {\r\n      \"records\": [\r\n        {\r\n          \"UserId\": 1853,\r\n          \"LastUpdatedTime\": \"2017-05-25 17:50:40.0\",\r\n          \"_metadata\": {\r\n            \"checksum\": \"ec717ced40ae5dc47603ddaca3ebdca6bc7303310783f1078c2968d1b876805f\",\r\n            \"action\": \"partialupdate\"\r\n          },\r\n          \"Age\": 12\r\n        },\r\n        {\r\n          \"UserId\": 1854,\r\n          \"LastUpdatedTime\": \"2017-05-25 18:55:22.0\",\r\n          \"_metadata\": {\r\n            \"checksum\": \"4e190c6303cecc2a02a7d08786f98ba4c96856f930b3a34d115925c3616abe1e\",\r\n            \"action\": \"partialupdate\"\r\n          },\r\n          \"Age\": 31\r\n        }\r\n      ],\r\n      \"_metadata\": {\r\n        \"recordCount\": 2,\r\n        \"updatedRecords\": 2,\r\n        \"deletedRecords\": 0\r\n      },\r\n      \"opstatus\": 0,\r\n      \"httpStatusCode\": 0,\r\n      \"name\": \"user\"\r\n    }\r\n  ],\r\n  \"delta_context\": {\r\n    \"objs\": {\r\n      \"socialnetwork\": {\r\n        \"delta\": \"2017-05-25T18:24:40+05:30\"\r\n      },\r\n      \"address\": {\r\n        \"delta\": \"2017-05-25T19:47:41+05:30\"\r\n      },\r\n      \"profile\": {\r\n        \"delta\": \"2017-05-25T18:35:10+05:30\"\r\n      },\r\n      \"user\": {\r\n        \"delta\": \"2017-05-25T19:29:28+05:30\"\r\n      }\r\n    }\r\n  },\r\n  \"opstatus\": 0,\r\n  \"httpStatusCode\": 200\r\n}";
//		DownloadResponseOfObjectService resultObj = gson.fromJson(json, DownloadResponseOfObjectService.class);
//		List<ObjectsInOSDownloadResponse> objects = resultObj.getObjects();
//		System.out.println(resultObj.getDeltaContext().toString());
		
		HashMap<String, Integer> hm1 = null;
		HashMap<String,Integer> hmcopy = new HashMap<>(hm1);
		System.out.println(hmcopy.size());
	}
	
}
