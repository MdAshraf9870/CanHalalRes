package com.e.canhalalres.Activity.Dashboard.HomePage;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.e.canhalalres.Models.AllCategorys;
import com.e.canhalalres.R;
import com.e.canhalalres.Url.Url;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;


public class DeliveryPageFragment extends Fragment {

    private RecyclerView categories_rv, restaurants_nearby_rv, restaurants_nearby_rv1;
    private SwipeRefreshLayout swipeRefreshLayout;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivery_page, container, false);
        swipeRefreshLayout = view.findViewById(R.id.SwipeRefreshLayout);

        categories_rv = view.findViewById(R.id.categories_rv);
        restaurants_nearby_rv = view.findViewById(R.id.restaurants_nearby_rv);

        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
        ArrayList<SlideModel> imageList = new ArrayList<SlideModel>();
        imageList.add(new SlideModel("https://static.toiimg.com/photo/51089680.cms"));
        imageList.add(new SlideModel("https://mir-s3-cdn-cf.behance.net/projects/404/554821100357951.5f071a8cad62a.png"));
        imageList.add(new SlideModel("https://burgerking-image.s3.amazonaws.com/16176882881x1119x540jpg"));
        imageList.add(new SlideModel("https://content3.jdmagicbox.com/comp/bulandshahr/a1/9999p5732.5732.170609205358.b9a1/catalogue/agarwal-king-barger-fastfood-bulandshahr-fast-food-kcikv.jpg"));
        imageSlider.setImageList(imageList, true);

        categories_rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        swipeRefreshLayout.setOnRefreshListener(this::CreateAccount);
        CreateAccount();
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void CreateAccount() {
        swipeRefreshLayout.setRefreshing(true);
        try {
            StringRequest request = new StringRequest(Request.Method.GET, Url.Category_GetAll,
                    response -> {
                        if (response != null) {

                            GsonBuilder gsonBuilder = new GsonBuilder();
                            Gson gson = gsonBuilder.create();
                            AllCategorys[] allCategorys = gson.fromJson(response, AllCategorys[].class);
                            categories_rv.setAdapter(new CategoriesAdeptor(allCategorys));
                            restaurants_nearby_rv.setAdapter(new RestaurantsAdaptor(allCategorys));
                            swipeRefreshLayout.setRefreshing(false);
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