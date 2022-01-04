package com.hci.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class CartActivity extends AppCompatActivity {

    /*ImageView cart_image;
    TextView cart_name, cart_price, cart_rating, cart_note;

    String name, price, rating, note, imageUrl;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setTitle("Cart");

        /*Intent intent = getIntent();

        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        rating = intent.getStringExtra("rating");
        note = intent.getStringExtra("note");
        imageUrl = intent.getStringExtra("image");

        cart_image = findViewById(R.id.cartImage);
        cart_name = findViewById(R.id.cartName);
        cart_price = findViewById(R.id.cartPrice);
        cart_note = findViewById(R.id.cartNote);
        cart_rating = findViewById(R.id.cartRating);

        Glide.with(getApplicationContext()).load(imageUrl).into(cart_image);
        cart_name.setText(name);
        cart_price.setText("Rp "+price+".000");
        cart_note.setText(note);
        cart_rating.setText(rating);*/

    }
}