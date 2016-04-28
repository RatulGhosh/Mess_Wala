package com.androidbegin.parselogintutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.parse.ParseUser;

import org.json.JSONException;
import org.json.JSONObject;

public class Menu extends Activity {

    ListView lv;
    String hostel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent=getIntent();
        lv=(ListView)findViewById(R.id.listView);
        hostel=intent.getStringExtra("Hostel");
        //TextView output = (TextView) findViewById(R.id.output);

        String day[]={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

        String BH1="{\"BH1\": { \"Monday\": { \"Breakfast\": \"Tea/Milk,Bread -cutlet or Bread-omlette, Jam/Butter\", \"Lunch\": \"Roti, Matar chole, Kaali massoor, Sambhar, Rice, Dahi\", \"Dinner\": \"Rice, Roti, Loki kofta, Rasam, Meethi Bundi\" }, \"Tuesday\": { \"Breakfast\": \"Tea/Milk,Dalia, Pav Bhaaji, or Bread, Jam/Butter \", \"Lunch\": \"Rice, Roti, Rajma, Mix veg, Saambhar, Raita\", \"Dinner\": \"Rice, Roti, Sada prantha, Aaloo jeera, mix daal, Rasgulla\" }, \"Wednesday\": { \"Breakfast\": \"Tea/Milk, Aloo prantha, Chutney or Bread, Jam/Butter\", \"Lunch\": \"Arhar Dal, Aloo shimla, Sambhar,Dahi\", \"Dinner\": \" Roti, Rice, Aloo matar gobhi, Anda curry, Saunpaapdi, nimbu\" }, \"Thursday\": { \"Breakfast\": \"Tea/Milk, 1 boiled egg, Dalia, Chhola samosa, or Bread, Jam/Butter\", \"Lunch\": \"Rice, Roti, Kadhi pakoda, Aloo-patta Gobhi/ Bhindi, Raita\", \"Dinner\": \"Puri, Rice, Sabji- kaddu & chola, Salad, Sonpapudi\" }, \"Friday\": { \"Breakfast\": \"Tea/Milk, 1 boiled egg, vada, Sambhar, Chutney or Bread, Jam/Butter\", \"Lunch\": \"Roti, Rice, Dal makhni, sabji -lokey & Dahi, Salad\", \"Dinner\": \"Roti, Rice, Arhar Dal, Anda curry/ aloo dum, sponj sweet/cake\" }, \"Saturday\": { \"Breakfast\": \"Tea/Milk, 1 egg, Cornflakes, Prantha (aloo/pyaz/ gobhi) mix + Chutney (Red & green) or Bread butter, Jam/Butter\", \"Lunch\": \"Noodles, Mancurian, veg briyani, finger chips, Raita (mixed) chutney\", \"Dinner\": \"Roti, Rice, Rajma, Aloo methi, Custard/ ice-cream\" }, \"Sunday\": { \"Breakfast\": \"Tea/Milk,Dalia, Dosa, Sambhar, Nariyal Chutney or Bread, Jam/Butter\", \"Lunch\": \"Aloo matar, Tamatr gravy, Chana dal, Dahi sambhar\", \"Dinner\": \"Matar -paneer, Roti, Chicken kadhai, Chana Daal, Gulab jamun, Naan, nimbu\" } } }";

        String BH2="{\"BH2\": { \"Monday\": { \"Breakfast\": \"Tea/Milk,Cornflakes, Mix prantha with chutney or Bread, Jam/Butter\", \"Lunch\": \"Roti, Chana dal (Pyaz tamatar fry), Sabzi (Soyabean) dry, Rice, Dahi\", \"Dinner\": \"Rice, Roti, Baigan chokha, Arhar dal, Moong dal halwa/ Gajar halwa\" }, \"Tuesday\": { \"Breakfast\": \"Tea/Milk,Dalia, Pyaz Kachori sabzi, or Bread, Jam/Butter, 1 boiled egg\", \"Lunch\": \"Rice, Roti, Baigan chokha, Arhar dal(Pyaz tamatar fry), Aloo Gobhi, dahi\", \"Dinner\": \"Rice, Roti, Chana dal (lauki fry), Mix Veg/ aaloo gobhi, sewai\" }, \"Wednesday\": { \"Breakfast\": \"Tea/Milk, 1 boiled egg, Idali, Sambhar, Chutney or Bread, Jam/Butter\", \"Lunch\": \"Poori, Veg. biryani, Finger chips,Dahi bada+ chutney\", \"Dinner\": \" Roti, Rice, Arhar Dal (Pyaz tamatar fry), Aloo palak, Gulab Jamun\" }, \"Thursday\": { \"Breakfast\": \"Tea/Milk, 1 boiled egg, Dalia, Chhola samosa, or Bread, Jam/Butter\", \"Lunch\": \"Rice, Roti, Kadhi pakoda, Aloo-patta Gobhi/ Bhindi, Raita\", \"Dinner\": \"Puri, Rice, Sabji- kaddu & chola, Salad, Sonpapudi\" }, \"Friday\": { \"Breakfast\": \"Tea/Milk, 1 boiled egg, vada, Sambhar, Chutney or Bread, Jam/Butter\", \"Lunch\": \"Roti, Rice, Dal makhni, sabji -lokey & Dahi, Salad\", \"Dinner\": \"Roti, Rice, Arhar Dal, Anda curry/ aloo dum, sponj sweet/cake\" }, \"Saturday\": { \"Breakfast\": \"Tea/Milk, 1 egg, Cornflakes, Prantha (aloo/pyaz/ gobhi) mix + Chutney (Red & green) or Bread butter, Jam/Butter\", \"Lunch\": \"Noodles, Mancurian, veg briyani, finger chips, Raita (mixed) chutney\", \"Dinner\": \"Roti, Rice, Rajma, Aloo methi, Custard/ ice-cream\" }, \"Sunday\": { \"Breakfast\": \"Tea/Milk,Dalia, Dosa, Sambhar, Chutney or Bread, Jam/Butter\", \"Lunch\": \"Chhola, Bhatura, Fried Rice, Raita (lauki/mix)\", \"Dinner\": \"Veg. polao, Roti, Paneer/Chicken, Gulab Jamun, Salad\" } } }";

        String BH3="{\"BH3\": { \"Monday\": { \"Breakfast\": \"Tea/Milk, Chana Masala, Halwa, Bread- cutlet, or Bread, Jam/Butter\", \"Lunch\": \"Arhar daal, Jeera -rice, Aloo tamatar, Dahi\", \"Dinner\": \"Arhar daal, Aloo matar, Gulab Jamun\" }, \"Tuesday\": { \"Breakfast\": \"Tea/Milk,Aloo prantha, Bread with Butter/ jam \", \"Lunch\": \"Aloo parwal, Kaala chana, pyaz, Raita, Dahi, Salad, Pickle\", \"Dinner\": \"Rice, Roti, Moong Dal, Masala chhola, Halwa\" }, \"Wednesday\": { \"Breakfast\": \"Tea/Milk, Bread cutlet/ Noodles, Tomato sauce, or Bread, Jam/Butter, 1 boiled egg\", \"Lunch\": \" Roti, Puri, Pulaao, Butter paneer, finger chips, Papad, Saun papdi\", \"Dinner\": \"Rice, Roti, Rajma, Jeera Aloo, Gulab-jamun\" }, \"Thursday\": { \"Breakfast\": \"Tea/Milk, 1 boiled egg, Jalebi, Poha, or Bread, Jam/Butter\", \"Lunch\": \"Arhar Daal, Rasam, Bhindi Aloo, Dahi\", \"Dinner\": \" Roti, Rice, Rajma, Aloo-gobhi, Chana daal, Rasgulla\" }, \"Friday\": { \"Breakfast\": \"Tea/Milk, 1 boiled egg, Pyaaz stuff prantha, butter or Bread, Jam/Butter\", \"Lunch\": \"Rice, Roti, Kadhi Achari, Aloo-pyaz, Raita\", \"Dinner\": \"Matar paneer, Arhar daal, Naan, fruit custard\" }, \"Saturday\": { \"Breakfast\": \"Tea/Milk, Masal Dosa, Sambhar, or Bread, Jam/Butter\", \"Lunch\": \"Roti, Rice, Rasam, Aloo jeera, Rajma, Jeera rice, Kheera-Raita (Veg)\", \"Dinner\": \"Roti, Rice, Veg briyani, Cutlet, Raita, Papad, Kheer\" }, \"Sunday\": { \"Breakfast\": \"Tea/Milk, 1 egg, Aloo pyaz prantha or Bread butter, Jam/Butter\", \"Lunch\": \"Chole-bhature, Dahi, Jeera- Rice, Salad\", \"Dinner\": \"Roti, Rice, Butter-chicken, Butter paneer masala, Raita, Arha dal, Ice cream\" } } }";

        String BH4="{\"BH4\": { \"Monday\": { \"Breakfast\": \"Tea/Milk,Dalia, Cornflakes/ dalia, Bread- omlette, Bread- cutlet, or Bread, Jam/Butter\", \"Lunch\": \"Chana daal tamatar-fry, aloo parawal, Raita (veg), Pickle, Salad\", \"Dinner\": \"Arhar daal, Bharwa Baaingan/ Rajma,Pickle, Gulab Jamun\" }, \"Tuesday\": { \"Breakfast\": \"Tea/Milk,Cornflakes/ dalia, Aloo prantha with chutney, Butter or Achaar\", \"Lunch\": \"Arhar dal tamatar fry, mix-veg, Dahi, Salad, Pickle\", \"Dinner\": \"Rice, Roti, Salad, Pickle, tamatar-bhindi, Rasgulla\" }, \"Wednesday\": { \"Breakfast\": \"Tea/Milk, Dalia, Noodles, Ketchup, or Bread, Jam/Butter, 1 boiled egg\", \"Lunch\": \"Rice, Roti, Chana-subzi, Aloo gobhi, Kaali Maoor (tamar fry),dahi\", \"Dinner\": \"Rice, Roti, Aloo matar gravy,Arhar daal(tamar fry), Gulab-jamun\" }, \"Thursday\": { \"Breakfast\": \"Tea/Milk, 1 boiled egg, Pav bhaji or Bread, Jam/Butter\", \"Lunch\": \"Matar-paneer, naan, boondi raita, french fries, gulab-jamun, Papad, Tomato Ketchup\", \"Dinner\": \" Roti, Rice, Rajma,Aloo- shimla, Custard\" }, \"Friday\": { \"Breakfast\": \"Tea/Milk, 1 boiled egg, Idli, Sambhar, Chutney, or Bread, Jam/Butter\", \"Lunch\": \"Rice, Roti, Kadhi pakoda, Aloo-beans, Papad, Dahi Vada\", \"Dinner\": \"Chhola Puri, Rice, Salad, Sevai\" }, \"Saturday\": { \"Breakfast\": \"Tea/Milk, Aloo-pyaz prantha, Butter, Achar, or Bread, Jam/Butter\", \"Lunch\": \"Roti, Rice, Kaali masoor Dal tamatr fry, Mix-veg, Raita (Veg)\", \"Dinner\": \"Roti, Rice, Prantha, Aloo tamatr, subzi, fried-rice, finger chips, Ice-cream, Achar\" }, \"Sunday\": { \"Breakfast\": \"Tea/Milk, 1 egg, Dahi-jalebi, Chana-masala or Bread butter, Jam/Butter\", \"Lunch\": \"Chole-bhature, Raita (veg), Sambhar, Rice, Salad\", \"Dinner\": \"Roti, Rice, Chicken Kadhai, Butter paneer, Naan, Gulab jamun\" } } }";

        String GH1="{\"GH1\": { \"Monday\": { \"Breakfast\": \"Tea/Milk,Dalia, Cornflakes/ dalia, Bread- omlette, Bread- cutlet, or Bread, Jam/Butter\", \"Lunch\": \"Chana daal tamatar-fry, aloo parawal, Raita (veg), Pickle, Salad\", \"Dinner\": \"Arhar daal, Bharwa Baaingan/ Rajma,Pickle, Gulab Jamun\" }, \"Tuesday\": { \"Breakfast\": \"Tea/Milk,Cornflakes/ dalia, Aloo prantha with chutney, Butter or Achaar\", \"Lunch\": \"Arhar dal tamatar fry, mix-veg, Dahi, Salad, Pickle\", \"Dinner\": \"Rice, Roti, Salad, Pickle, tamatar-bhindi, Rasgulla\" }, \"Wednesday\": { \"Breakfast\": \"Tea/Milk, Dalia, Noodles, Ketchup, or Bread, Jam/Butter, 1 boiled egg\", \"Lunch\": \"Rice, Roti, Chana-subzi, Aloo gobhi, Kaali Maoor (tamar fry),dahi\", \"Dinner\": \"Rice, Roti, Aloo matar gravy,Arhar daal(tamar fry), Gulab-jamun\" }, \"Thursday\": { \"Breakfast\": \"Tea/Milk, 1 boiled egg, Pav bhaji or Bread, Jam/Butter\", \"Lunch\": \"Matar-paneer, naan, boondi raita, french fries, gulab-jamun, Papad, Tomato Ketchup\", \"Dinner\": \" Roti, Rice, Rajma,Aloo- shimla, Custard\" }, \"Friday\": { \"Breakfast\": \"Tea/Milk, 1 boiled egg, Idli, Sambhar, Chutney, or Bread, Jam/Butter\", \"Lunch\": \"Rice, Roti, Kadhi pakoda, Aloo-beans, Papad, Dahi Vada\", \"Dinner\": \"Chhola Puri, Rice, Salad, Sevai\" }, \"Saturday\": { \"Breakfast\": \"Tea/Milk, Aloo-pyaz prantha, Butter, Achar, or Bread, Jam/Butter\", \"Lunch\": \"Roti, Rice, Kaali masoor Dal tamatr fry, Mix-veg, Raita (Veg)\", \"Dinner\": \"Roti, Rice, Prantha, Aloo tamatr, subzi, fried-rice, finger chips, Ice-cream, Achar\" }, \"Sunday\": { \"Breakfast\": \"Tea/Milk, 1 egg, Dahi-jalebi, Chana-masala or Bread butter, Jam/Butter\", \"Lunch\": \"Chole-bhature, Raita (veg), Sambhar, Rice, Salad\", \"Dinner\": \"Roti, Rice, Chicken Kadhai, Butter paneer, Naan, Gulab jamun\" } } }";

        String GH2="{\"GH2\": { \"Monday\": { \"Breakfast\": \"Tea/Milk,Dalia, Cornflakes/ dalia, Bread- omlette, Bread- cutlet, or Bread, Jam/Butter\", \"Lunch\": \"Chana daal tamatar-fry, aloo parawal, Raita (veg), Pickle, Salad\", \"Dinner\": \"Arhar daal, Bharwa Baaingan/ Rajma,Pickle, Gulab Jamun\" }, \"Tuesday\": { \"Breakfast\": \"Tea/Milk,Cornflakes/ dalia, Aloo prantha with chutney, Butter or Achaar\", \"Lunch\": \"Arhar dal tamatar fry, mix-veg, Dahi, Salad, Pickle\", \"Dinner\": \"Rice, Roti, Salad, Pickle, tamatar-bhindi, Rasgulla\" }, \"Wednesday\": { \"Breakfast\": \"Tea/Milk, Dalia, Noodles, Ketchup, or Bread, Jam/Butter, 1 boiled egg\", \"Lunch\": \"Rice, Roti, Chana-subzi, Aloo gobhi, Kaali Maoor (tamar fry),dahi\", \"Dinner\": \"Rice, Roti, Aloo matar gravy,Arhar daal(tamar fry), Gulab-jamun\" }, \"Thursday\": { \"Breakfast\": \"Tea/Milk, 1 boiled egg, Pav bhaji or Bread, Jam/Butter\", \"Lunch\": \"Matar-paneer, naan, boondi raita, french fries, gulab-jamun, Papad, Tomato Ketchup\", \"Dinner\": \" Roti, Rice, Rajma,Aloo- shimla, Custard\" }, \"Friday\": { \"Breakfast\": \"Tea/Milk, 1 boiled egg, Idli, Sambhar, Chutney, or Bread, Jam/Butter\", \"Lunch\": \"Rice, Roti, Kadhi pakoda, Aloo-beans, Papad, Dahi Vada\", \"Dinner\": \"Chhola Puri, Rice, Salad, Sevai\" }, \"Saturday\": { \"Breakfast\": \"Tea/Milk, Aloo-pyaz prantha, Butter, Achar, or Bread, Jam/Butter\", \"Lunch\": \"Roti, Rice, Kaali masoor Dal tamatr fry, Mix-veg, Raita (Veg)\", \"Dinner\": \"Roti, Rice, Prantha, Aloo tamatr, subzi, fried-rice, finger chips, Ice-cream, Achar\" }, \"Sunday\": { \"Breakfast\": \"Tea/Milk, 1 egg, Dahi-jalebi, Chana-masala or Bread butter, Jam/Butter\", \"Lunch\": \"Chole-bhature, Raita (veg), Sambhar, Rice, Salad\", \"Dinner\": \"Roti, Rice, Chicken Kadhai, Butter paneer, Naan, Gulab jamun\" } } }";

        String GH3="{\"GH3\": { \"Monday\": { \"Breakfast\": \"Tea/Milk,Dalia, Cornflakes/ dalia, Bread- omlette, Bread- cutlet, or Bread, Jam/Butter\", \"Lunch\": \"Chana daal tamatar-fry, aloo parawal, Raita (veg), Pickle, Salad\", \"Dinner\": \"Arhar daal, Bharwa Baaingan/ Rajma,Pickle, Gulab Jamun\" }, \"Tuesday\": { \"Breakfast\": \"Tea/Milk,Cornflakes/ dalia, Aloo prantha with chutney, Butter or Achaar\", \"Lunch\": \"Arhar dal tamatar fry, mix-veg, Dahi, Salad, Pickle\", \"Dinner\": \"Rice, Roti, Salad, Pickle, tamatar-bhindi, Rasgulla\" }, \"Wednesday\": { \"Breakfast\": \"Tea/Milk, Dalia, Noodles, Ketchup, or Bread, Jam/Butter, 1 boiled egg\", \"Lunch\": \"Rice, Roti, Chana-subzi, Aloo gobhi, Kaali Maoor (tamar fry),dahi\", \"Dinner\": \"Rice, Roti, Aloo matar gravy,Arhar daal(tamar fry), Gulab-jamun\" }, \"Thursday\": { \"Breakfast\": \"Tea/Milk, 1 boiled egg, Pav bhaji or Bread, Jam/Butter\", \"Lunch\": \"Matar-paneer, naan, boondi raita, french fries, gulab-jamun, Papad, Tomato Ketchup\", \"Dinner\": \" Roti, Rice, Rajma,Aloo- shimla, Custard\" }, \"Friday\": { \"Breakfast\": \"Tea/Milk, 1 boiled egg, Idli, Sambhar, Chutney, or Bread, Jam/Butter\", \"Lunch\": \"Rice, Roti, Kadhi pakoda, Aloo-beans, Papad, Dahi Vada\", \"Dinner\": \"Chhola Puri, Rice, Salad, Sevai\" }, \"Saturday\": { \"Breakfast\": \"Tea/Milk, Aloo-pyaz prantha, Butter, Achar, or Bread, Jam/Butter\", \"Lunch\": \"Roti, Rice, Kaali masoor Dal tamatr fry, Mix-veg, Raita (Veg)\", \"Dinner\": \"Roti, Rice, Prantha, Aloo tamatr, subzi, fried-rice, finger chips, Ice-cream, Achar\" }, \"Sunday\": { \"Breakfast\": \"Tea/Milk, 1 egg, Dahi-jalebi, Chana-masala or Bread butter, Jam/Butter\", \"Lunch\": \"Chole-bhature, Raita (veg), Sambhar, Rice, Salad\", \"Dinner\": \"Roti, Rice, Chicken Kadhai, Butter paneer, Naan, Gulab jamun\" } } }";

        String menu = "";
        String menu_break[]=new String[7];
        String menu_lunch[]=new String[7];
        String menu_dinner[]=new String[7];
        try {
            JSONObject jsonRootObject = null;
            if (hostel.equals("BH1")) {
                jsonRootObject = new JSONObject(BH1);
            }
            if (hostel.equals("BH2")) {
                jsonRootObject = new JSONObject(BH2);
            }
            if (hostel.equals("BH3")) {
                jsonRootObject = new JSONObject(BH3);
            }
            if (hostel.equals("BH4")) {
                jsonRootObject = new JSONObject(BH4);
            }
            if (hostel.equals("GH1")) {
                jsonRootObject = new JSONObject(GH1);
            }if (hostel.equals("GH2")) {
                jsonRootObject = new JSONObject(GH2);
            }
            if (hostel.equals("GH3")) {
                jsonRootObject = new JSONObject(GH3);
            }




            JSONObject jsonInnerObject = jsonRootObject.getJSONObject(hostel);
            for (int i = 0; i < jsonInnerObject.length(); i++) {
                menu="";
                JSONObject jsonObject = jsonInnerObject.getJSONObject(day[i]);
                String breakfast = jsonObject.optString("Breakfast").toString();
                menu_break[i]="<b>Breakfast</b> : "+breakfast;
                String lunch = jsonObject.optString("Lunch").toString();
                menu_lunch[i]="<b>Lunch</b> : "+lunch;
                String dinner = jsonObject.optString("Dinner").toString();
                menu_dinner[i]="<b>Dinner</b> : "+dinner;
                //menu += "\n" + "Breakfast : " + breakfast + "\nLunch : " + lunch + "\nDinner : " + dinner + "\n";
                //menu_name[i]=menu;
            }
          //  output.setText(menu);
        } catch (JSONException e) {e.printStackTrace();}

        lv.setAdapter(new CustomAdapter(this,day,menu_break,menu_lunch,menu_dinner));
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.complaint:
                Intent intent=new Intent(Menu.this,Complain.class);
                intent.putExtra("Hostel", hostel);
                startActivity(intent);
                return true;
            case R.id.logout:
                ParseUser.logOut();
                Intent intent1=new Intent(Menu.this,Login.class);
                startActivity(intent1);
                finish();
                return true;

            case R.id.developers:
                ParseUser.logOut();
                Intent intent2=new Intent(Menu.this,Developer.class);
                startActivity(intent2);
                finish();
                return true;

            case R.id.exit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
