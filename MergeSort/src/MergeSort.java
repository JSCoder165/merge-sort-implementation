// https://www.youtube.com/watch?v=3j0SWDX4AtU - assissted in creation and understanding of the algorithm

import java.util.*;

public abstract class MergeSort {
    /*
     * Sorts array using merge sort
     * @precondition - no null objects
     * @param String[] arr - the array that will be sorted
     * @return String[] arr - sorted array
     */
    public static String[] mergeSortArray(String[] arr){
        if(arr.length == 1){ return arr; } //base case
        String[] arr1 = Arrays.copyOfRange(arr, 0, arr.length/2); //1st half of arr
        String[] arr2 = Arrays.copyOfRange(arr, arr.length/2, arr.length); //2nd half of arr
        String[] finalArr1 = mergeSortArray(arr1); //obtain split arr1 to merge with arr2
        String[] finalArr2 = mergeSortArray(arr2); //obtain split arr2 to merge with arr1
        return mergeArray(finalArr1, finalArr2);
    }
    /*
     * Sorts arraylist using merge sort
     * @precondition - no null objects
     * @param ArrayList<String> arr - the arraylist that will be sorted
     * @param int start - inclusive, beginning index of range of values to be sorted
     * @param int end - noninclusive, ending index of range of values to be sorted
     * @return ArrayList<String> - sorted arraylist
     */
    public static ArrayList<String> mergeSortArrayList(ArrayList<String> arr, int start, int end){
        if(end - start == 1){ return arr; } //base case
        mergeSortArrayList(arr, start, (start+end)/2); //split indices
        mergeSortArrayList(arr, (start+end)/2, end); //split indices
        return mergeArrayList(arr, start, (start+end)/2, (start+end)/2, end);
    }
    /*
     * Merges and sorts two seperate arrays
     * @param String[] arr 1- 1 of 2 arrays to be merged
     * @param String[] arr 2- 2 of 2 arrays to be merged
     * @return String[] arr - sorted and combined array
     */
    private static String[] mergeArray(String[] arr1, String[] arr2){
        String[] arr = new String [arr1.length + arr2.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while(k < arr.length){
            if(i == arr1.length){ // if ran out of strings in arr1
                for(int m = j; m < arr2.length; m++){
                    arr[k] = arr2[m];
                    k++;
                }
                break;
            } else if(j == arr2.length){ //if ran out of strings in arr2
                for(int m = i; m < arr1.length; m++){
                    arr[k] = arr1[m];
                    k++;
                }
                break;
            }
            if(arr1[i].compareTo(arr2[j]) < 0){ //if 1st in arr1 is less than 1st in arr2
                arr[k] = arr1[i];
                i++;
                k++;
            } else if (arr1[i].compareTo(arr2[j]) > 0){ //1st in arr1 is greater than 1st in arr2
                arr[k] = arr2[j];
                j++;
                k++;
            } else { //if both are equal
                arr[k] = arr1[i];
                arr[k+1] = arr2[j];
                j++;
                i++;
                k+=2;
            }
        }
        return arr;
    } 
    /*
     * merges and sorts 2 ranges within the same arraylist
     * @param ArrayList<String> arr - arraylist to be sorted
     * @param int start1 - start index of range 1 
     * @param int end1 - end index of range 1
     * @param int start2 - start index of range 2
     * @param int end2 - end index of range 2
     * @return String[] arr - sorted and combined array
     */
    private static ArrayList<String> mergeArrayList(ArrayList<String> arr, int start1, int end1, int start2, int end2){
        int i = start1;
        int j = start2;
        while(i != end1 && j != end2){
            if(arr.get(i).compareTo(arr.get(j)) < 0){ //1st in range1 is less than 1st in range2
                i++;
            } else if (arr.get(i).compareTo(arr.get(j)) > 0){ //1st in range1 is greater than 1st in range2
                String temp = arr.get(j); //add element in front
                arr.remove(j);
                arr.add(i, temp) ;
                j++;
            } else { //if both are equal
                String temp = arr.get(j); //swap elements
                arr.remove(j);
                arr.add(i+1, temp);
                j++;
                i++;
            }
        }
        return arr;
    } 
}
