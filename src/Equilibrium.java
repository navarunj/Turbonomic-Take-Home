public class Equilibrium {
    public static void main(String[] args) {
        int[] myArray = {3,5,8,9,0,-1};
        System.out.println(findEquilibriumPoint(myArray));
    }

    public static int findEquilibriumPoint(int[] numberArray) {
        // The equilibrium point is an index such that the sum of
        // elements at lower indexes is equal to the sum of
        // elements at higher indexes.


        for(int i=0; i<numberArray.length; i++) {
            //Get the sum of all numbers to the left of index i.
            int leftSum = 0;
            for (int j = 0; j < i; j++)
                leftSum += numberArray[j];

            // Get the sum of all the numbers to the right of index i.
            int rightSum = 0;
            for (int j = i + 1; j<numberArray.length; j++)
                rightSum += numberArray[j];

            // If leftSum and rightSum are the same, then we found an equilibrium point.
            if (leftSum == rightSum)
                return i;
        }
        // We tried every combination and didn't find an equilibrium point, so return -1.
        return -1;
    }
}
