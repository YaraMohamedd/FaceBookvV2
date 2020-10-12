package pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieInterface {
@GET("posts")
    public Call<List<Moviemodel>> getpost();
}
