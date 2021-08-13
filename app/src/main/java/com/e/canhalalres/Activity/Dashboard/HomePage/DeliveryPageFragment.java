package com.e.canhalalres.Activity.Dashboard.HomePage;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.e.canhalalres.Apdapters.CategoriesAdeptor;
import com.e.canhalalres.Apdapters.RestaurantsAdaptor;
import com.e.canhalalres.Models.ModelGetRestaurantsNearby;
import com.e.canhalalres.Models.modelGetCategories;
import com.e.canhalalres.R;
import com.e.canhalalres.Url.Url;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;


public class DeliveryPageFragment extends Fragment {

    private RecyclerView categories_rv, restaurants_nearby_rv, restaurants_nearby_rv1;
    private SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayout RvLayout;
    private TextView showAllCatogiry;
    private Boolean seeAll_lessAll=false;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivery_page, container, false);


        categories_rv = view.findViewById(R.id.categories_rv);
        restaurants_nearby_rv = view.findViewById(R.id.restaurants_nearby_rv);
        RvLayout = view.findViewById(R.id.RvLayout);
        showAllCatogiry = view.findViewById(R.id.showAllCatogiry);
        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
        ArrayList<SlideModel> imageList = new ArrayList<SlideModel>();
        imageList.add(new SlideModel("https://static.toiimg.com/photo/51089680.cms"));
        imageList.add(new SlideModel("https://mir-s3-cdn-cf.behance.net/projects/404/554821100357951.5f071a8cad62a.png"));
        imageList.add(new SlideModel("https://burgerking-image.s3.amazonaws.com/16176882881x1119x540jpg"));
        imageList.add(new SlideModel("https://content3.jdmagicbox.com/comp/bulandshahr/a1/9999p5732.5732.170609205358.b9a1/catalogue/agarwal-king-barger-fastfood-bulandshahr-fast-food-kcikv.jpg"));
        imageSlider.setImageList(imageList, true);
        categories_rv.setNestedScrollingEnabled(true);
       categories_rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        Animation slideUp = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        Animation slideDown = AnimationUtils.loadAnimation(getContext(), R.anim.slide_bown);
        getCategories();
        getRestaurantsNearby();



        showAllCatogiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!seeAll_lessAll){
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) RvLayout.getLayoutParams();
                    params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    RvLayout.setLayoutParams(params);
                    categories_rv.setLayoutManager(new GridLayoutManager(getContext(), 3));
                    categories_rv.setNestedScrollingEnabled(false);
                  //  RvLayout.startAnimation(slideDown);
                    seeAll_lessAll=true;
                    showAllCatogiry.setText("See Less");


                }else {
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) RvLayout.getLayoutParams();
                    params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    RvLayout.setLayoutParams(params);
                    categories_rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                    categories_rv.setNestedScrollingEnabled(true);
                    //   RvLayout.startAnimation(slideUp);
                    showAllCatogiry.setText("See All");
                    seeAll_lessAll=false;
                }

            }
        });
        return view;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void getRestaurantsNearby() {
        try {
            StringRequest request = new StringRequest(Request.Method.GET, Url.Restaurant_GetAll,
                    response -> {
                        if (response != null) {
                            try {
                                int i=0;
                                JSONObject jsonObject=new JSONObject(response);
                                GsonBuilder gsonBuilder = new GsonBuilder();
                                Gson gson = gsonBuilder.create();
                                ModelGetRestaurantsNearby[] modelGetRestaurantsNearbies = gson.fromJson(jsonObject.getString("data"), ModelGetRestaurantsNearby[].class);

                                restaurants_nearby_rv.setAdapter(new RestaurantsAdaptor(modelGetRestaurantsNearbies));


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                    }, (VolleyError volleyError) -> {
                Toast.makeText(getContext(), volleyError.toString(), Toast.LENGTH_SHORT).show();

            }

            ) {

            };
            @SuppressLint("UseRequireInsteadOfGet")
            RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            requestQueue.add(request);
        } catch (Exception e) {
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void getCategories() {

        try {
            StringRequest request = new StringRequest(Request.Method.GET, Url.Category_GetAll,
                    response -> {
                        if (response != null) {
                            try {
                                JSONObject jsonObject=new JSONObject(response);
                                GsonBuilder gsonBuilder = new GsonBuilder();
                                Gson gson = gsonBuilder.create();
                                modelGetCategories[] allCategories = gson.fromJson(jsonObject.getString("data"),
                                        modelGetCategories[].class);
                                categories_rv.setAdapter(new CategoriesAdeptor(allCategories));
//                                restaurants_nearby_rv.setAdapter(new RestaurantsAdaptor(allCategories));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                    }, (VolleyError volleyError) -> {
                Toast.makeText(getContext(), volleyError.toString(), Toast.LENGTH_SHORT).show();

            }

            ) {

            };
            @SuppressLint("UseRequireInsteadOfGet")
            RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            requestQueue.add(request);
        } catch (Exception e) {
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();

        }
    }
}