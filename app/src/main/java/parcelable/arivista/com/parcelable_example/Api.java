package parcelable.arivista.com.parcelable_example;


import java.util.List;

import parcelable.arivista.com.parcelable_example.holder.List_Holder;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("photos")
    Call<List<List_Holder>> getGetLists();
}