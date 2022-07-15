Link: https://codelearn.io/training/detail/44200  

You are given a string of positive numbers in no specific order, delimited by commas. Your job is to return a string of ranges extrapolated from the input, in ascending order. If the input string contains any characters other than positive integers and commas, the string "undefined" should be returned.

Example:

For str = "5,10,11,20,21,12,13,100,1,2,3",  
The output should be:  
extrapolateRanges(str) = "1-3,5,10-13,20-21,100".  

Input/Output:

- [execution time limit] 0.5 seconds
- [input] string str

    String of positive integers, delimited by commas.

    Guaranteed constraints:

    1 ≤ str.length < 105.

- [output] string

    A string of comma delimited ranges or "undefined". A range can be a single integer, or an inclusive list of integers specified in the following format: {min}-{max} (e.g. 5-9).