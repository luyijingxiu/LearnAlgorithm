package basic_class_08;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String str="HG[3|B[2|CA]]F";
        System.out.println(new Main().decode(str,0,str.length()-1));
    }

    public String decode(String compressed,int start,int end) {
        if(compressed==null||compressed.length()==0||start>end) return "";

        int l=compressed.indexOf("[",start);
        int r=end;
        while(compressed.charAt(r)!=']'){
            r--;
        }
        System.out.println(l+"  "+r);
        if(l<r){
            int lineIndex=compressed.indexOf("|",l+1);
            int time=Integer.valueOf(compressed.substring(l+1,lineIndex));
            String str=decode(compressed,lineIndex+1,r-1);
            String before=compressed.substring(start,l);
            String after=compressed.substring(r+1,end+1);
            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append(before);
            for(int i=0;i<time;i++){
                stringBuilder.append(str);
            }
            stringBuilder.append(after);
            return  stringBuilder.toString();
        }
        System.out.println("lalallala");
        return compressed.substring(start,end+1);
    }
}
