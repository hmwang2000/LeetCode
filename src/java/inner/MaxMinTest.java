package java.inner;


public class  MaxMinTest
{
    public static void main(String[] args) 
    {
        double[] d=new double[10];
        System.out.println("The Content of Array: ");
        for(int i=0;i<d.length;i++)
        {
            d[i]=100*Math.random();
            System.out.println("num "+i+":  "+d[i]);
        }
        ArrayMaxMin.Pair p=ArrayMaxMin.maxMin(d);
        System.out.println("min= "+p.getFirst());
        System.out.println("max= "+p.getSecond());

    }
    
}

class ArrayMaxMin
{
    public static class Pair
    {
        public Pair(double f,double s)
        {
            first=f;
            second=s;
        }

        public double getFirst()
        {
            return first;
        }
        public double getSecond()
        {
            return second;
        }
        
        private double first;
        private double second;
    }
    /**
        computes both the minimum and the maximum of an array
        @param values an array of double type numbers
        @return a pair whose first element is the minimum and whose second element is the maximum
    */
    public static Pair maxMin(double[] values)
    {
        double min=Double.MAX_VALUE;
        double max=Double.MIN_VALUE;
        for(double v : values)
        {
            if(min>v)
                min=v;
            if(max<v)
                max=v;
        }
        return new Pair(min,max);

    }
    
}    
