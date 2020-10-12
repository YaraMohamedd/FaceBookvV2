package pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClients {
    private  static  final String BASE_URL="https://jsonplaceholder.typicode.com/";
    private    MovieInterface movieInterface;
    private  static  PostClients INSTANCE;


    public PostClients() {
        Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
           movieInterface=retrofit.create(MovieInterface.class);


    }
    public static PostClients getINSTANCE() {
        if (null==INSTANCE){
            INSTANCE=new PostClients();
        }
        return INSTANCE;
    }
    public Call<List<Moviemodel>> getposts(){
        return  movieInterface.getpost();
    }
}
