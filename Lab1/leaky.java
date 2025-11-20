/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package com.smvitm.cnlab;
import java.util.Scanner;
/**
 *
 * @author Lab6
 */
public class Leaky {
    public static void main(String[] args){
        int i;
        int a[]=new int[20];
        int bucket_rem=0,sent,recv;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter no of Packets:");
        int n=in.nextInt();
        System.out.println("Enter the bucket capacity");
        int bucket_cap=in.nextInt();
        System.out.println("Enter the output rate");
        int rate=in.nextInt();
        System.out.println("Enter the size of packet:");
        for(i=1;i<=n;i++){
            a[i]=in.nextInt();
        }
       System.out.println("CLOCK \t PACKET SIZE \t ACCEPT \t SENT \t REMEMAINING");
       for(i=1;i<=n;i++){
               if(a[i]!=0){
                   if(bucket_rem+a[i]>bucket_cap)
                     recv=-1;
                   else{
                      recv=a[i];
                       bucket_rem+=a[i];
                     
                   }
               }else 
                            recv=0;
                  if(bucket_rem!=0){
                        if(bucket_rem<rate){
                               sent=bucket_rem;
                               bucket_rem=0;
                                           } 
                        else{
                               sent=rate;
                               bucket_rem-=rate;
               
       
       
                         }
                  }
                           else 
                              sent=0;
       
           if(recv==-1)
               System.out.println(i+"\t\t"+a[i]+"\t dropped \t"+sent+"\t"+bucket_rem);
           else
               System.out.println(i+"\t\t"+a[i]+"\t\t"+recv+"\t"+sent+"\t"+bucket_rem);
       }
    }
}
