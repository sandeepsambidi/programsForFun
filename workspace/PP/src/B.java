import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class B {
	
	static String buildDownloadURL(String columnName, HashMap<String, Object> primaryKeys) {
        String objectServiceEndPointUrl = "https://abc.com:8003";

        StringBuilder urlBuilder = new StringBuilder(objectServiceEndPointUrl);
        urlBuilder.append("/binary/");
        urlBuilder.append("emp");
        urlBuilder.append("?");

        for (Map.Entry<String, Object> pkPair: primaryKeys.entrySet()) {
            urlBuilder.append(pkPair);
            urlBuilder.append("&");
        }

        urlBuilder.append("fieldname="+columnName);
        urlBuilder.append("&");
        urlBuilder.append("type=bytes");

        return urlBuilder.toString();
    }

	static ArrayList<Integer> performOps(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
                B.set(i, A.get(i));
                B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
}
	
	public static void main(String[] args) {
		Object value = 2.00012;

        if (value instanceof Double) {
            DecimalFormat decimalFormat = new DecimalFormat("0.##");
            //decimalFormat.setMinimumFractionDigits(340);
            value = decimalFormat.format(value);
            Double d = Double.parseDouble(value.toString());
            System.out.println(d);

        }
        System.out.println(value);
	}
}
