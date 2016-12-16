package com.bridgelabz.webapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;


public class MainActivity extends AppCompatActivity {
    public FeatureCoverFlow mCoverflow;
    public ArrayList<GameEntity> mData = new ArrayList<>();
    String imagearray[] = {"http://www.freedigitalphotos.net/images/img/homepage/87357.jpg",
            "http://m1.appystore.in/i/8/78448_1280.jpg",
            "http://m1.appystore.in/i/8/78446_1280.jpg",
            "http://m1.appystore.in/i/8/78442_1280.jpg",
            "http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg",
            "http://www.gettyimages.pt/gi-resources/images/Homepage/Hero/PT/PT_hero_42_153645159.jpg",
            "http://im.rediff.com/news/2015/dec/24tpoty20.jpg",
    };
    CoverFlowAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mCoverflow = (FeatureCoverFlow) findViewById(R.id.coverflow);
        mData.add(new GameEntity(imagearray[0], "image1"));
        mData.add(new GameEntity(imagearray[1], "image2"));
        mData.add(new GameEntity(imagearray[3], "image3"));
        mData.add(new GameEntity(imagearray[2], "image4"));
        mData.add(new GameEntity(imagearray[2], "image5"));
        mData.add(new GameEntity(imagearray[3], "image5"));
        mData.add(new GameEntity(imagearray[4],"image"));
        mData.add(new GameEntity(imagearray[4], "image5"));
        mData.add(new GameEntity(imagearray[5], "image6"));
        mData.add(new GameEntity(imagearray[6], "image7"));

       /* CoverFlowAdapter adapter = new CoverFlowAdapter(MainActivity.this,mData);
        mCoverflow.setAdapter(adapter);*/
        String url = "http://beta.appystore.in/appy_app/appyApi_handler.php?method=getCategoryList&content_type=videos&limit_start=0&age=1.5&incl_age=5";
        //Mytask obj = new Mytask();
        //obj.execute(url);
    }


    public class Mytask extends AsyncTask<String, String, ArrayList<GameEntity>> {


        @Override
        public ArrayList<GameEntity> doInBackground(String... strings) {
            String data = Utility.readDataFromServer(strings[0]);
            Log.i("laxman", "data is" + data);
            JSONObject jsonobject = null;
            try {
                jsonobject = new JSONObject(data);

                // creating the subjson array in jsonobject
                JSONObject subjsonobject = jsonobject.getJSONObject("Responsedetails");

                // reading json array which is in responce details
                JSONArray jsonArray = subjsonobject.getJSONArray("category_id_array");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject arrayobject = jsonArray.getJSONObject(i);
                    String name = arrayobject.getString("category_name");
                    //JSONArray contentJson = arrayobject.getJSONArray("image_path");
                    JSONObject urlobject = arrayobject.getJSONObject("image_path");
                    String url = urlobject.getString("50x50");
                    mData.add(new GameEntity(url, name));

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return mData;
        }

        @Override
        protected void onPostExecute(ArrayList<GameEntity> gameEntities) {


            Log.i("fdfd", "onPostExecute: ................................................." + gameEntities.size());
            //madapter= new CoverFlowAdapter(getApplicationContext(), data);
            //mCoverflow.setAdapter(madapter);

        }
    }
}
