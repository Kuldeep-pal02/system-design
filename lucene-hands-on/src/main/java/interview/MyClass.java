package interview;

import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyClass {

    //Input: “ABCDEFGABEF”
    //Output: 7

//    A- 1, in - 0
//    B- 1 , in - 1
//
    //ABDCD


    @Data
    static class Employee{
        int id;
        int sal;
        Employee( int id, int sal){
            this.id = id;
            this.sal = sal;
        }
        @Override
        public int hashCode(){
            return id;
        }
        @Override
        public boolean equals( Object obj){
            Employee employee = (Employee) obj;
            return this.id == employee.id;
        }
    }
    private static int solve( String str){
        int ans = -1;
        Map<Character , Integer> map = new HashMap<>();
        int left = 0,right = 0;
        int len = str.length();
        while ( right < len ){
            char ch = str.charAt( right );
            if( !map.containsKey( ch ) ){
                map.put( ch, right );
            }else{
                left = map.get( ch ) +1 ;
                map.put( ch , right);
            }
            ans = Math.max( ans , ( right - left +1 ));
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        //String str = "ABCDEAGHT";
        //System.out.println( solve( str ) );

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add( new Employee(0, -100));
        employeeList.add( new Employee(0, 100));
        employeeList.add( new Employee(2, 200));
        employeeList.add( new Employee(3, 300));


        int totalSalWithFilter = employeeList.stream().filter( emp -> emp.getSal() > 0 ).mapToInt( Employee::getSal ).sum();
        System.out.println( "total SUM with Filter: "+ totalSalWithFilter );

        int totalSal = employeeList.stream().mapToInt( Employee::getSal ).sum();
        System.out.println( "total SUM : "+ totalSal );

        long totalCount = employeeList.stream().distinct().count();
        System.out.println( "total totalCount : "+ totalCount );

        System.out.println( "total firstTwo equal ? : "+ employeeList.get( 0).equals( employeeList.get(1)) );

        Vehicle car = VehicleFactory.getVehicleInstance( "CAR");

        List<Integer> allNumbers = List.of( 1,2,3,4,5,6,7,8,9,10 );
        List<Integer> oddNumbers = allNumbers.stream().filter( x -> x%2!=0).collect(Collectors.toList());
        System.out.println( "Odd Numbers"+ oddNumbers );

        List<String> stringList = Stream.of( "Kuldeep", "Santoshhhh").toList();
        String longestString = stringList.stream().max(Comparator.comparingInt(String::length)).get();

        System.out.println( "Longest String :"+ longestString );

        List<Integer> listOfNumeber = List.of( 1,2,3);
        int sumOfSquare = listOfNumeber.stream().map( x -> x*x).reduce( 0 , Integer::sum);
        System.out.println( "sumOfSquare : "+ sumOfSquare );

        int maxValue = allNumbers.stream().max((a,b)-> a-b).get();
        System.out.println( "maxValue : "+ maxValue );

        Map<Integer,Integer> squareMap = allNumbers.stream().collect(Collectors.toMap( x->x , x->x*x));
        System.out.println( "squareMap : "+ squareMap);

        List<String> stringList1 = List.of( "apple", "banana", "apple", "orange", "banana", "apple","apple");
        Map<String, Integer> freqMap = stringList1.stream().collect( Collectors.toMap(x->x, x->x.length()/x.length(), (a,b)->a+1));
        System.out.println( "freqMap : "+ freqMap);



    }






}
