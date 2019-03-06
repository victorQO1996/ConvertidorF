
package Convertidor;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONObject.*;
import org.json.XML;

//import org.junit.TEST;

public class Convertidor {
    //metodo para convertir calse a json

   /* public String convertidorClase(String clase){
        JSONObject xmlJson = XML.toJSONObject(clase);
        String json = xmlJson.toString();

        return json;
    }*/

    public String Objecttojson(Object m) {
        Gson gson = new Gson();
        String resultado = gson.toJson(m);
        return resultado;
    }

    public String convertirXml(String sml)
    {
        JSONObject xml = new JSONObject();
        try {
            xml = XML.toJSONObject(sml);
        } catch (JSONException je) {
            System.out.println(je.toString());
        }

        return xml+"";
    }
}
