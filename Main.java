import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    CustomSort sortingInterface = new CustomSort();
    ArrayList<Double> x = new ArrayList<Double>();

    x.add(9.00);
    x.add(8.00);
    x.add(7.00);
    x.add(6.00);
    x.add(5.00);
    x.add(4.00);
    x.add(3.00);
    x.add(2.00);
    x.add(1.00);
    sortingInterface.setValues(x);
  }
}

interface SortingInterface{
  public void setValues(ArrayList<Double> values);
  public ArrayList<Integer> getGaps();
  public void add(Double value);
  public void remove(int index);
  public void sort();
}

class CustomSort implements SortingInterface {
  
    
  ArrayList<Double> Values = new ArrayList<Double>();
 
  
  
  public void setValues(ArrayList<Double> values){
    
    Values = values;

    int n = Values.size();
    ArrayList<Integer> gaps = new ArrayList<Integer>();
    gaps = calculateGaps(Values);

    for (int gap: gaps){

      for(int i = gap; i <= (n-1); i++ ){
        double temp = Values.get(i); 
        int j = 0;

        for(j = i; j >= gap; j = j - gap ){
          if ((Values.get(j - gap)) <= temp){
            break;
          }
         
          Values.set(j,Values.get(j-gap));
          
        }
        Values.set(j,temp);
      }
      
    }
    for (int i = 0; i < Values.size(); i++) {
      System.out.println(Values.get(i));
    }
  }

  public ArrayList<Integer> calculateGaps(ArrayList<Double> values){

    ArrayList<Integer> gaps = new ArrayList<Integer>();
    int n = values.size();
    ArrayList<Double> temp = new ArrayList<Double>();
    double gap = 1;
    int i = 2;
    

    while (gap < n){
      temp.add (gap);
      gap = (Math.pow(2,i)) - 1.00;
      i++;
    }

  

    for (int j = (temp.size())-1; j >= 0; j--){
      int x = (int) Math.round(temp.get(j));
      gaps.add(x);
    }

    
    return gaps;
  }

  public ArrayList<Integer> getGaps(){
    ArrayList<Integer> gaps = new ArrayList<Integer>();
    gaps = calculateGaps(Values);

    return gaps;
    
  }
  public void add(Double value){
    Values.add(value);
    sort();
  }
  
  public void remove(int index){
    Values.remove(index);
    sort();
  }

  public void sort(){
    int n = Values.size();
    ArrayList<Integer> gaps = new ArrayList<Integer>();
    gaps = calculateGaps(Values);

    for (int gap: gaps){

      for(int i = gap; i <= (n-1); i++ ){
        double temp = Values.get(i); 
        int j = 0;

        for(j = i; i >= gap; j = j - gap ){
          if (Values.get(j) - gap <= temp){
            break;
          }
          Values.set(j,temp);
        }
      }
      
    }
  }

  
}