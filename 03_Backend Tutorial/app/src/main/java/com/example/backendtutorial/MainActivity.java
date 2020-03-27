package com.example.backendtutorial;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        /*
        TextView textView = findViewById(R.id.textView);
        textView.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                if(action == MotionEvent.ACTION_DOWN){
                    Log.d("kusitms", "onTouch: action down");
                }
                else if(action==MotionEvent.ACTION_UP){
                    Log.d("kusitms", "onTouch: action up");
                }
                else if(action==MotionEvent.ACTION_MOVE){
                    Log.d("kusitms", "onTouch: action move");
                }

                return true;
            }
        }); */

        /*
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "토스트 테스팅입니다.", Toast.LENGTH_SHORT);
                toast.show();
            }
        }); */

        //Snack바 실습
//        Button button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar.make(v, "스낵바 테스트", Snackbar.LENGTH_LONG).show();
//            }
//        });


//        Button button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//
//                builder.setTitle("안내창 실험");
//                builder.setMessage("버튼을 누루셨습니까?");
//                builder.setIcon(android.R.drawable.ic_dialog_alert);
//
//                builder.setPositiveButton("네",new DialogInterface.OnClickListener(){
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Log.d("alertDialog", "onClick: 네!");
//                    }
//                });
//                AlertDialog dialog = builder.create();
//                dialog.show();
//            }
//        });

        //Inflation 실습
        //mainActivity에서는 context변수를 따로 안만들어도 된다.
//        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        LinearLayout linearLayout = findViewById(R.id.linearLayout);
//
//        inflater.inflate(R.layout.image_view, linearLayout, true);

        //ListView
        ArrayList<BoardItemData> items = new ArrayList<>();

        BoardItemAdapter boardItemAdapter = new BoardItemAdapter(this,items);
        ListView boardView = findViewById(R.id.boardView);
        boardView.setAdapter(boardItemAdapter);

        items.add(new BoardItemData("테스트 제목1", "테스트 콘텐츠1"));
        items.add(new BoardItemData("테스트 제목2", "테스트 콘텐츠2"));
        items.add(new BoardItemData("테스트 제목3", "테스트 콘텐츠3"));
        items.add(new BoardItemData("테스트 제목4", "테스트 콘텐츠4"));

        boardItemAdapter.notifyDataSetChanged();

    }
}
