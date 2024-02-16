package com.example.recyclevapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecycleViewInterface {


    private ArrayList<DataModel> dataSet;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CustomeAdapter adapter;
    private SearchView searchView;
    private CardView cardView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSet = new ArrayList<>();
        searchView=findViewById(R.id.searchView);
        recyclerView =  findViewById(R.id.resView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        searchView.clearFocus();
        cardView= findViewById(R.id.characterCard);



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filteredList(newText);
                return true;
            }
        });

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for ( int i =0 ; i < myData.nameArray.length ; i++){
            dataSet.add(new DataModel(
                    myData.nameArray[i],
                    myData.descriptionArray[i],
                    myData.drawableArray[i],
                    myData.id_[i]
            ));
        }


        adapter = new CustomeAdapter(this, dataSet);
        recyclerView.setAdapter(adapter);

    }

    public void clickOnCharacter(View view){
        String name;

        Toast.makeText(this,"No Data found", Toast.LENGTH_SHORT).show();

    }

    private void filteredList(String text) {
        List<DataModel> filteredList= new ArrayList<>();
        for( DataModel item: dataSet ){
            if (item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }

        }
        if (filteredList.isEmpty()){
            Toast.makeText(this,"No Data found", Toast.LENGTH_SHORT).show();
        }else{
            adapter.setFilteredList(filteredList);
        }
    }

    @Override
    public void onItemClick(int position) {
       String name= dataSet.get(position).getName();
        Toast.makeText(this,name, Toast.LENGTH_SHORT).show();



    }
}








