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
public class Follow {

    void calculateFollow(ArrayList<String> left, ArrayList<String> right, ArrayList<Integer> count_right, String[] first) {

        WriteFile followfile=new WriteFile();
        String[] follow=new String[left.size()];
        
        for(int i=0;i<left.size();i++)
            follow[i]="";
        
        int leftcount=0;
        int rightcount=0;
        int totalcount=0;
        int line_check_left=0;
        int check_right=0;
        
        for(leftcount=0;leftcount<left.size();leftcount++){
        
            //System.out.println("calculate follow of left ="+left.get(leftcount));
            
            totalcount=0;
            for(line_check_left=0;line_check_left<left.size();line_check_left++){
                
               // System.out.println("check in each line where Alpha-B-Bite or Alpha-B is present");
                int lastIndex=totalcount+count_right.get(line_check_left);

                for(rightcount=totalcount;rightcount<lastIndex;rightcount++){
                    totalcount++;
                    //System.out.println("\tright ="+right.get(rightcount));
                    
                    if(right.get(rightcount).length()>1){
                        //System.out.println("\tlength of "+right.get(rightcount)+" is = "+right.get(rightcount).length());
                        String tempstr=new String();
                        tempstr=""+right.get(rightcount).charAt(1);
                        String templeft=new String();
                        if(leftcount==0)
                            templeft=""+left.get(leftcount).charAt(1);
                        else
                            templeft=""+left.get(leftcount).charAt(0);
                        //System.out.println("follow of left = '"+templeft+"'");
                        //System.out.println("tempstr = '"+tempstr+"'");
                        
                       // A= Alpha-B-bite else A=Alpha-B
                        
                        // if the 2nd letter matches --or-- Alpha-B is present then check if there is 
                        //bita after B or not 
                      
                        if(tempstr.equals(templeft)){
                            // B exists after Alpha 
                            //System.out.println("tempstr= "+tempstr+" and templeft= "+templeft);
                            //System.out.println("length of right.get(rigthcount) ="+right.get(rightcount).length());
//                            for(int i=0;i<right.get(rightcount).length();i++)
//                                System.out.println("char is = '"+right.get(rightcount).charAt(i)+"'");
                            if(right.get(rightcount).length()>=3){
                                // bita is present after Alpha-B
                                //System.out.println("its Alpha-B-Bita and bita="+(right.get(rightcount).charAt(2)));
                                //its Alpha-B-Bita
                                    //follow(B)=first(Bita)
                                    //check where the Bita is in left
                                    int temp=0;
                                    for(temp=0;temp<left.size();temp++){
                                        // if bita found then the first of that index will b saved as follow
                                        String tempstr2=new String();
                                        tempstr2=""+right.get(rightcount).charAt(2);
                                        String templeft2=new String();
                                        if(temp==0)
                                            templeft2=""+left.get(temp).charAt(1);
                                        else
                                            templeft2=""+left.get(temp).charAt(0);
                                        if(tempstr2.equals(templeft2)){
                                            follow[leftcount]=first[temp];
                                            // if the follow counted in the previous loop contains epsilon then replace it 
                                            //with follow(temp) if it is not null

                                            if(follow[leftcount].contains("ε")){
                                                //if follow(temp) not null
                                                if(!follow[temp].equals("")){
                                                   // replace ε  with follow(temp)
                                                    follow[leftcount]=follow[leftcount].replace("ε", follow[temp]);
                                                }

                                            }
                                            break;
                                        }
                                    }
                                    //if the  for loop works till end and no foun d match in the left part then calculate follow
                                    if(follow[leftcount].equals("")){
                                        //calculte follow
                                        follow[leftcount]="$,"+right.get(rightcount).charAt(2);
                                    }
                            
                            }
                            
                            else{
                               // System.out.println("Its Alpha-B");
                                follow[leftcount]=follow[line_check_left];
                            }
                            
                        }
                        
                        
                    }
                    
                }
            }
            
            
            //if any follow is null calculate again
            if(leftcount==left.size()-1){
                        for(int x=0;x<left.size();x++){
                        
                            if(follow[x].equals("")){
                                leftcount=-1;
                                totalcount=0;
                                check_right=0;
                                break;
                            }
                        
                        }
                    }
            
        }
    
        
        for(int i=0;i<left.size();i++){
            String result=left.get(i)+"="+follow[i];
            followfile.write_file(result,"Follow.txt");
            //System.out.println("Follow ("+left.get(i)+") = {"+follow[i]+"}");
        }
    
    }
    
}
