package com.app.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GamePage extends AppCompatActivity {
    Button one_, two_, three_, four_, five_, six_, seven_, eight_, nine_,restart_,playAgain_;
    TextView turn_, player_one_, player_two_,error_;
    public static int turn = 1;
    int xstate[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int zstate[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int player_one_score=0;
    public static int player_two_score=0;
    public static boolean winstatus=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        one_ = findViewById(R.id.one);
        two_ = findViewById(R.id.two);
        three_ = findViewById(R.id.three);
        four_ = findViewById(R.id.four);
        five_ = findViewById(R.id.five);
        six_ = findViewById(R.id.six);
        seven_ = findViewById(R.id.seven);
        eight_ = findViewById(R.id.eight);
        nine_ = findViewById(R.id.nine);
        turn_ = findViewById(R.id.turn);
        restart_=findViewById(R.id.restart_game);
        playAgain_=findViewById(R.id.play_again);
        player_one_ = findViewById(R.id.player_one);
        player_two_ = findViewById(R.id.player_two);
        error_=findViewById(R.id.error);


        turn_.setText("Turn: Player 1 [X]");
        turn_.setTextColor(Color.parseColor("#FFA500"));


        one_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean mark=Mark_symbol(turn,one_,turn_,0,error_,playAgain_,player_one_,player_two_);
                if (mark){turn=1-turn;};
            }
        });
        two_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean mark=Mark_symbol(turn,two_,turn_,1,error_,playAgain_,player_one_,player_two_);
                if (mark){turn=1-turn;};
            }
        });
        three_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean mark=Mark_symbol(turn,three_,turn_,2,error_,playAgain_,player_one_,player_two_);
                if (mark){turn=1-turn;};




            }
        });
        four_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean mark=Mark_symbol(turn,four_,turn_,3,error_,playAgain_,player_one_,player_two_);
                if (mark){turn=1-turn;};
            }
        });
        five_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean mark=Mark_symbol(turn,five_,turn_,4,error_,playAgain_,player_one_,player_two_);
                if (mark){turn=1-turn;};


            }
        });
        six_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean mark=Mark_symbol(turn,six_,turn_,5,error_,playAgain_,player_one_,player_two_);
                if (mark){turn=1-turn;};

            }
        });
        seven_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean mark=Mark_symbol(turn,seven_,turn_,6,error_,playAgain_,player_one_,player_two_);
                if (mark){turn=1-turn;};


            }
        });
        eight_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean mark=Mark_symbol(turn,eight_,turn_,7,error_,playAgain_,player_one_,player_two_);
                if (mark){turn=1-turn;};


            }
        });
        nine_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean mark=Mark_symbol(turn,nine_,turn_,8,error_,playAgain_,player_one_,player_two_);
                if (mark){turn=1-turn;};
            }
        });
        restart_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame(xstate,zstate);
                turn=1;
                turn_.setText("Turn: Player 1 [X]");
                one_.setText("");
                two_.setText("");
                three_.setText("");
                four_.setText("");
                five_.setText("");
                six_.setText("");
                seven_.setText("");
                eight_.setText("");
                nine_.setText("");
                error_.setText("");
                turn_.setTextColor(Color.parseColor("#FFA500"));

                player_one_score=0;
                player_two_score=0;
                player_one_.setText("0");
                player_two_.setText("0");






            }
        });
        playAgain_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame(xstate,zstate);
                turn=1;
                turn_.setText("Turn: Player 1 [X]");
                one_.setText("");
                two_.setText("");
                three_.setText("");
                four_.setText("");
                five_.setText("");
                six_.setText("");
                seven_.setText("");
                eight_.setText("");
                nine_.setText("");
                error_.setText("");
                turn_.setTextColor(Color.parseColor("#FFA500"));

            }
        });
    }







    public void restartGame(int[] xarr, int[] zarr){
        for(int i=0; i<9; i++){
            xarr[i]=0;
            zarr[i]=0;
        }
        winstatus=false;

    }


    public boolean isDraw(){
        int invoke=0;

        if (!((one_.getText().toString()).equals(""))){invoke++;}
        if (!((two_.getText().toString()).equals(""))){invoke++;}
        if (!((three_.getText().toString()).equals(""))){invoke++;}
        if (!((four_.getText().toString()).equals(""))){invoke++;}
        if (!((five_.getText().toString()).equals(""))){invoke++;}
        if (!((six_.getText().toString()).equals(""))){invoke++;}
        if (!((seven_.getText().toString()).equals(""))){invoke++;}
        if (!((eight_.getText().toString()).equals(""))){invoke++;}
        if (!((nine_.getText().toString()).equals(""))){invoke++;}
        if (invoke==9){
            playAgain_.setVisibility(View.VISIBLE);
            turn_.setText("Match Draw");
            return true;

        }
        else{
            return false;
        }



    }
    public int sum(int a,int b,int c){
        int s=a+b+c;
        return s;
    }

    public int checkwin(TextView turn_) {
        int wins[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};


        for (int win[]:wins){
            if(sum(xstate[win[0]], xstate[win[1]], xstate[win[2]]) == 3) {
                turn_.setTextColor(Color.parseColor("#90ee90"));
                turn_.setText("Player 1 wins || X win");
                return 1;
            }
            if(sum(zstate[win[0]], zstate[win[1]], zstate[win[2]]) == 3) {
                turn_.setTextColor(Color.parseColor("#90ee90"));
                turn_.setText("Player 2 wins || 0 win");

                return 0;
            }
        }
        return -1;
    }

    public boolean Mark_symbol(int turn, Button box_, TextView turn_, int index,TextView error,Button playAgain_,TextView player_one_,TextView player_two_) {
        int winstate;
        boolean draw;
        boolean val = Areafree(xstate, zstate, index);

        if (turn == 1) {


            if (val) {
                if (winstatus==false){box_.setText("X");xstate[index] = 1;}
                winstate=checkwin(turn_);if (winstate==1 && (winstatus==false)){player_one_score++;
                    player_one_.setText(Integer.toString(player_one_score));
                    winstatus=true;} else if (winstate==0 && (winstatus==false)){player_two_score++;
                    player_two_.setText(Integer.toString(player_two_score));
                    winstatus=true;}
                draw = isDraw();
                if (!draw) {
                error.setText("");
                turn_.setText("Turn: Player 2 [0]");
                winstate = checkwin(turn_);


                if ((winstate == 1 || winstate == 0) && (winstatus==false)  ) {
                    if (winstate == 1) {
                        player_one_score++;
                        player_one_.setText(Integer.toString(player_one_score));
                        winstatus=true;
                    } else if (winstate == 0) {

                        player_two_score++;
                        player_two_.setText(Integer.toString(player_two_score));
                        winstatus=true;

                    }
                    playAgain_.setVisibility(View.VISIBLE);
                }

                }
                return true;
            }
            else {
                error.setTextColor(Color.parseColor("#FF0000"));
                error.setText("plz choose other box");
                return false;
            }

        }
        else {


                if (val) {

                    if (winstatus==false){box_.setText("0"); zstate[index] = 1;}
                    winstate=checkwin(turn_);if (winstate==1 && (winstatus==false)){player_one_score++;
                        player_one_.setText(Integer.toString(player_one_score));
                        winstatus=true;} else if (winstate==0 && (winstatus==false)){player_two_score++;
                        player_two_.setText(Integer.toString(player_two_score));
                        winstatus=true;}
                    draw = isDraw();
                    if (!draw) {
                    turn_.setText("Turn: Player 1 [X]");
                    error.setText("");
                    winstate = checkwin(turn_);

                        if ((winstate == 1 || winstate == 0)  && (winstatus==false)) {
                        if (winstate == 1) {
                        player_one_score++;
                            winstatus=true;
                        player_one_.setText(Integer.toString(player_one_score));
                    } else if (winstate == 0) {
                        player_two_score++;
                        player_two_.setText(Integer.toString(player_two_score));
                            winstatus=true;

                    }
                        playAgain_.setVisibility(View.VISIBLE);
                        }

                    }
                    return true;
                }
                else {
                    error.setTextColor(Color.parseColor("#FF0000"));
                    error.setText("plz choose other box");
                    return false;
                }
        }
    }
    public boolean Areafree(int[] xarr, int[] zarr, int index) {

        if (xarr[index] == 1 || zarr[index]==1) {return false;} else {return true;}

        }

}