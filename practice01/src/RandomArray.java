public class RandomArray {
    public static void main(String[] args) {
        int[] arr = new int[10];

        for(int i = 0; i < 10; i++) {
            arr[i] = (int)(Math.random()*100);
        }

        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
        int t;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    t = arr[i];
                    arr[i] = arr[j];
                    arr[j]=t;
                }
            }
        }

        for(int i: arr){
            System.out.print(i + " ");
        }
    }
}
