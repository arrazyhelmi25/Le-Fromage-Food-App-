package com.hci.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FoodDetails extends AppCompatActivity {

    ImageView imageView;
    TextView itemName, itemPrice, itemRating, itemDescription;
    RatingBar ratingBar;
    Button buttonCart;

    String name, price, rating, description, imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        rating = intent.getStringExtra("rating");
        description = intent.getStringExtra("description");
        imageUrl = intent.getStringExtra("image");

        buttonCart = findViewById(R.id.button_cart);
        imageView = findViewById(R.id.imageView4);
        itemName = findViewById(R.id.name);
        itemPrice = findViewById(R.id.price);
        itemDescription = findViewById(R.id.description);
        itemRating = findViewById(R.id.rating);
        ratingBar = findViewById(R.id.ratingBar);

        Glide.with(getApplicationContext()).load(imageUrl).into(imageView);
        itemName.setText(name);
        itemPrice.setText("Rp "+price+".000");
        itemDescription.setText(description);
        itemRating.setText(rating);
        ratingBar.setRating(Float.parseFloat(rating));

        buttonCart.setOnClickListener((v -> {
            Intent intent1 = new Intent(FoodDetails.this,CartActivity.class);
            startActivity(intent1);
        }));

        ImageButton cart = findViewById(R.id.cartDetail);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCartActivity();
            }
        });
    }

    private void openCartActivity() {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }
}