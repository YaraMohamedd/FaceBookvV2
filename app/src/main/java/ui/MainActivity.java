package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facebookvv2.R;

import java.util.List;

import pojo.Moviemodel;

public class MainActivity extends AppCompatActivity {
    Postviewmodel postviewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postviewmodel= ViewModelProviders.of(this).get(Postviewmodel.class);
        postviewmodel.getpost();
        RecyclerView recyclerView=findViewById(R.id.post_recycler);
        final MovieListAdapter adapter=new MovieListAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
     postviewmodel.postMutableLivedata.observe(this, new Observer<List<Moviemodel>>() {
         @Override
         public void onChanged(List<Moviemodel> moviemodels) {
             adapter.setList(moviemodels);
         }
     });
    }
}