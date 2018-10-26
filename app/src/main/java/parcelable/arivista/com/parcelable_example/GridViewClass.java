package parcelable.arivista.com.parcelable_example;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import parcelable.arivista.com.parcelable_example.adapter.Adapter_Grid;
import parcelable.arivista.com.parcelable_example.holder.List_Holder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Suresh on 28/06/2018
 */

public class GridViewClass extends Fragment {


    private static final String LIST_SET ="LIST_SET" ;
    protected GridView mGridView;
    Adapter_Grid Grid_adapter;
    ArrayList<List_Holder> list_holders;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.tab2, container, false);

        list_holders=new ArrayList<>();

        mGridView = (GridView)view.findViewById(R.id.gridView);
        Grid_adapter = new Adapter_Grid(getContext(),list_holders);
        mGridView.setAdapter(Grid_adapter);

        if(savedInstanceState!=null){
            list_holders=savedInstanceState.getParcelableArrayList(LIST_SET);
            Grid_adapter = new Adapter_Grid(getContext(),list_holders);
            mGridView.setAdapter(Grid_adapter);
        }else {
            getGetLists();
        }



        return view;
    }

    private void getGetLists() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<List_Holder>> call = api.getGetLists();

        call.enqueue(new Callback<List<List_Holder>>() {
            @Override
            public void onResponse(Call<List<List_Holder>> call, Response<List<List_Holder>> response) {
                List<List_Holder> heroList = response.body();

                String[] heroes = new String[heroList.size()];

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < heroList.size(); i++) {
                    heroes[i] = heroList.get(i).getTitle();
                    list_holders.add(new List_Holder(heroList.get(i).getAlbumId(),heroList.get(i).getId(),heroList.get(i).getUrl(),heroList.get(i).getTitle(),heroList.get(i).getThumbnailUrl()));
                }
                // Toast.makeText(getContext(),heroList.get(0).getTitle(),Toast.LENGTH_LONG).show();


                Grid_adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<List_Holder>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(LIST_SET, list_holders);
    }
}

