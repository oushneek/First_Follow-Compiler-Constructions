/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package First_and_follow;

import java.util.ArrayList;

/**
 *
 * @author Tazbeea Tazakka
 */
public class First {
    
    
    
    
    public void calculateFirst(ArrayList<String> left,ArrayList<String> right,ArrayList<Integer> count_right){
        
        WriteFile filefirst=new WriteFile();
        
        
        String[] first= new String[left.size()];
        
        for(int i=0;i<left.size();i++)
            first[i]="";
        int leftcount=0;
        int totalcount=0;
           for(leftcount=0;leftcount<left.size();leftcount++){
            
               int lastIndex=totalcount+count_right.get(leftcount);
              // if(first[leftcount].equals("")){
                    for(int rightcount=totalcount;rightcount<lastIndex;rightcount++){
                        totalcount++;
                        int j=0;
                        for(j=0;j<left.size();j++){
                            
                            // if at the first of the right part there is an item of left part 
                            if(right.get(rightcount).startsWith(left.get(j))){
                                
                                // if the fist of that compared  leftpart is not empty 
                                
                                
                                if(!first[j].equals("")){
                                    if(!first[leftcount].contains(first[j])){
                                        first[leftcount]+=first[j];
                                        break;
                                    }
                                }
                                else{
                                    break;
                                }
                                

                            }
                            //else does not starts with any left part, calculate first
                            
                            else if((j==left.size()-1) && !(right.get(rightcount).startsWith(left.get(j)))){
                               
                                
                                //String temp=first[leftcount];
                                
                                String temp=right.get(rightcount).charAt(0)+",";
                                if(!first[leftcount].contains(temp)){
                                    first[leftcount]+=right.get(rightcount).charAt(0)+",";}
                        
                            }
                            
                            
                        }
                    
                        
                    
                    }
            
               // }
                    
                    
                    if(leftcount==left.size()-1){
                        for(int x=0;x<left.size();x++){
                        
                            if(first[x].equals("")){
                                leftcount=-1;
                                totalcount=0;
                                break;
                            }
                        
                        }
                    }
                   
           }
           
             for(int i=0;i<first.length;i++){
                 
                 if(first[i].endsWith(",")){
                    
                    char[] charArray = first[i].toCharArray();
                    String x = new String(charArray,0,(charArray.length-1));
                    first[i]=x;
                 
                 }
                 String result=left.get(i)+"="+first[i];
                 //filefirst.write_file("First("+left.get(i)+")= {"+first[i]+"}");
                 filefirst.write_file(result,"First.txt");
                 //System.out.println("First("+left.get(i)+")= {"+first[i]+"}");
             }
             
             Follow grammer=new Follow();
             grammer.calculateFollow(left, right, count_right, first);
           
       //}
        
        
        
        
        
    }
    
    
    
    
    
}
