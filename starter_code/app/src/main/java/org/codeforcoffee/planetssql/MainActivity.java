package org.codeforcoffee.planetssql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text_view);

        DatabaseHelper db = new DatabaseHelper(this);
        db.createPlanet(1, "Mercury", 1, "pure metal core");
        db.createPlanet(2, "Venus", 2, "very strong electrical field");
        db.createPlanet(3, "Mars", 4, "1 ice cap is water, 1 ice cap is co2");
        db.createPlanet(4, "Jupiter", 5, "insane radiation; no landing on europa");
        db.createPlanet(5, "Uranus", 7, "lopsided tilt; as if it were drunk?");
        db.createPlanet(6, "Earth", 3, "our only fucking shot");
        db.createPlanet(7, "Saturn", 6, "2 moons capable of organic life");
        db.createPlanet(8, "Neptune", 8, "is a big, badass, methane, mofo");


        Planets getPlanet =db.getPlanetById(1);

         mTextView.setText(getPlanet.getName());

        }



    }




