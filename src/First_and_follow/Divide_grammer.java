/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package First_and_follow;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Tazbeea Tazakka
 */
public class Divide_grammer {
    public void divide(ArrayList<String> file){
        ArrayList<String> left=new ArrayList<String>();
        ArrayList<String> right=new ArrayList<String>();
        ArrayList<Integer> num_of_right_token=new ArrayList<Integer>();
        left.clear();
        right.clear();
        num_of_right_token.clear();
        for(int i=0;i<file.size();i++){
        
            StringTokenizer tokenizer=new StringTokenizer(file.get(i),"=|");
            
            left.add(tokenizer.nextToken());
            int count=0;
            while(tokenizer.hasMoreTokens()){
                count++;
                right.add(tokenizer.nextToken());
            }
            num_of_right_token.add(count);
            
            
        }
        
        First grammer=new First();
        grammer.calculateFirst(left, right, num_of_right_token);
        
            
        
    }
}
