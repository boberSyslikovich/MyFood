package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private UserRecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public ArrayList<UserRecyclerViewItem> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Shopping-cart");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        arrayList = new ArrayList<>();

        arrayList.add(new UserRecyclerViewItem(R.drawable.soup, "First course", 15+" UAH", ""+0));
        arrayList.add(new UserRecyclerViewItem(R.drawable.pasta,"Second course", 15+" UAH", ""+0));
        arrayList.add(new UserRecyclerViewItem(R.drawable.croissant,"Сroissant", 20+" UAH", ""+0));
        arrayList.add(new UserRecyclerViewItem(R.drawable.hot_drink,"Hot drink", 5+" UAH", ""+0 ));
        arrayList.add(new UserRecyclerViewItem(R.drawable.soda,"Soda", 10+" UAH", ""+0));


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerViewAdapter = new UserRecyclerViewAdapter(arrayList);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(layoutManager);

        recyclerViewAdapter.setOnItemClickListener(new UserRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }

            @Override
            public void onQuantityPlus(int position) {
                arrayList.get(position).plusCount();
                recyclerViewAdapter.notifyItemChanged(position);
            }

            @Override
            public void onQuantityMinus(int position) {
                arrayList.get(position).minusCount();
                recyclerViewAdapter.notifyItemChanged(position);
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
        case R.id.add:
            ArrayList<String> name = new ArrayList();
            for (int i =0; i<arrayList.size();i++)
            {
                name.add(arrayList.get(i).getText1());
            }

            ArrayList<String> quantity = new ArrayList();
            for (int i =0; i<arrayList.size();i++)
            {
                quantity.add(arrayList.get(i).getCount());
            }

            Intent intent = new Intent(this,CartActivity.class);

            intent.putExtra("name", name);
            intent.putExtra("quantity", quantity);

            startActivity(intent);


        case R.id.about:

            return(true);
        case R.id.exit:

            finish();
            return(true);

    }
        return(super.onOptionsItemSelected(item));
    }


}
