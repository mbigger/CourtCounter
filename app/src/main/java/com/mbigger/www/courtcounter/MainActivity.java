package com.mbigger.www.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private int team_a_score = 0;
    private int team_b_score = 0;
    private Stack<Operation> stack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(team_a_score);
        displayForTeamB(team_b_score);
        stack = new Stack<>();
    }



    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void add_one_point_to_a(View view){
        team_a_score = team_a_score + 1;
        displayForTeamA(team_a_score);
        stack.push(new Operation(Role.TEAM_A,1));
    }

    public void add_two_point_to_a(View view){
        team_a_score = team_a_score + 2;
        displayForTeamA(team_a_score);
        stack.push(new Operation(Role.TEAM_A,2));
    }

    public void add_three_point_to_a(View view){
        team_a_score = team_a_score + 3;
        displayForTeamA(team_a_score);
        stack.push(new Operation(Role.TEAM_A,3));
    }

    public void add_one_point_to_b(View view){
        team_b_score = team_b_score + 1;
        displayForTeamB(team_b_score);
        stack.push(new Operation(Role.TEAM_B,1));
    }

    public void add_two_point_to_b(View view){
        team_b_score = team_b_score + 2;
        displayForTeamB(team_b_score);
        stack.push(new Operation(Role.TEAM_B,2));
    }

    public void add_three_point_to_b(View view){
        team_b_score = team_b_score + 3;
        displayForTeamB(team_b_score);
        stack.push(new Operation(Role.TEAM_B,3));
    }

    public void reset(View view){
        team_a_score = 0;
        team_b_score = 0;
        displayForTeamA(team_a_score);
        displayForTeamB(team_b_score);
        stack.clear();
    }

    public void back(View view){
        if(!stack.empty()){
            Operation lastOperation = stack.pop();
            int lastScore = lastOperation.getScore();
            switch (lastOperation.getRole()){
                case TEAM_A:
                    team_a_score = team_a_score - lastScore;
                    displayForTeamA(team_a_score);
                    break;
                case TEAM_B:
                    team_b_score = team_b_score - lastScore;
                    displayForTeamB(team_b_score);
                    break;
                default:
                    break;
            }
        }
    }
}
