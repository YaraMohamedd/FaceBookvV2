package ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import pojo.Moviemodel;
import pojo.PostClients;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Postviewmodel extends ViewModel {
    MutableLiveData<List<Moviemodel>> postMutableLivedata=new MutableLiveData<>();

    public  void getpost(){
        PostClients.getINSTANCE().getposts().enqueue(new Callback<List<Moviemodel>>() {
            @Override
            public void onResponse(Call<List<Moviemodel>> call, Response<List<Moviemodel>> response) {
                postMutableLivedata.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Moviemodel>> call, Throwable t) {

            }
        });
    }
}
