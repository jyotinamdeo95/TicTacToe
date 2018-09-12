package com.example.manu.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MainActivity extends AppCompatActivity {
    int myActivePlayer = 0;
    //0 for cross and 1 for circle

    //my game state
    int[] myGameState={2,2,2,2,2,2,2,2,2};

    public void imageTapped(View view){
        ImageView myTapped=(ImageView) view;
        Log.i("msg","icon tapped");
        Log.i("tag is ","image number is "+myTapped.getTag().toString());

       int tappedimagetag=Integer.parseInt(myTapped.getTag().toString());

        if(myGameState[tappedimagetag] == 2) {
            myGameState[tappedimagetag]=myActivePlayer;
            if(myActivePlayer == 0) {
                myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer = 1;
            }else{
                myTapped.setImageResource(R.drawable.zero);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer = 0;
            }
        }else
        {
            Log.i("msg","This place is already filled");
        }


    }

    public void playAgain(View view){
        Log.i("msg","play again tapped");
        //change game back to state 2
        for(int i=0; i< myGameState.length; i++)
        {
            myGameState[i]=2;
        }
        //make  active player 0 again
        myActivePlayer = 0;

        //chnage all images to ic_launcher
        //for lineOne
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lineOne);
        for(int i=0;i < linearLayout.getChildCount();i++)
        {
            ((ImageView) linearLayout.getChildAt(i)).setImageResource(R.mipmap.ic_launcher_round);
        }
        //for lineTwo
        LinearLayout linearLayoutOne = (LinearLayout) findViewById(R.id.lineTwo);
        for(int i=0;i < linearLayoutOne.getChildCount();i++)
        {
            ((ImageView) linearLayoutOne.getChildAt(i)).setImageResource(R.mipmap.ic_launcher_round);
        }
        //for lineThree
        LinearLayout linearLayoutTwo = (LinearLayout) findViewById(R.id.lineThree);
        for(int i=0;i < linearLayoutTwo.getChildCount();i++)
        {
            ((ImageView) linearLayoutTwo.getChildAt(i)).setImageResource(R.mipmap.ic_launcher_round);
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
