package com.example.myfood;

public class UserRecyclerViewItem {
    private int imageResource;
    private String text1;
    private String text2;
    private String count;
    public int quantity=0;

    public UserRecyclerViewItem(int imageResource, String text1, String text2, String count) {
        this.imageResource = imageResource;
        this.text1 = text1;
        this.text2 = text2;
        this.count = count;
    }

    public void plusCount(){
        quantity ++;
    }

    public void minusCount(){
        quantity --;
        if (quantity<0)
            quantity =0;
    }

    public String getCount() {
        return ""+quantity;
    }

    public int getImageResource() {
      return imageResource;
   }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }
}
