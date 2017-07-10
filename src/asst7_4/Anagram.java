/*4) Write a program that finds all anagram sets from a list of words. Anagrams are those words in 
which there are same characters jumbled. */
/*Input: listen, pot, part, opt, trap, silent, top, this, hello, hits, what, shit ------- 
 * Output: { listen, silent} { part, trap } { pot, opt, top }{ this, hits, shit } */

package asst7_4;

/*Anagram Program in java using HashMap method:

1. Create one HashMap object with character as key and character occurrences as value.
2. If the character is present in first string , we increment  character  count by 1.
3. If the character is present in second string , we decrement character count by 1.
4. Iterate through HashMap,  checking the count of each character in the map, 
   if count is not equal to 0 then return false.
*/

import java.util.*;  //importing all classes from java's util library

public class Anagram
{
	public static ArrayList<ArrayList<Integer>> anagram(final List<String> a) 
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		//Constructing a map containing string as a key and character occurrences as a value
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

		for(int i = 0; i < a.size(); i++)
		{
			//Taking array element and breaking down each word to character array
			char[] c = a.get(i).toCharArray();
			Arrays.sort(c);		//Sorting all the character array alphabetically
			String t = String.valueOf(c);	//put the value in string t
			if(map.get(t) == null)
			{
				//Mapping the value to t
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(i+1);
				map.put(t, l);
			}
			else
				map.get(t).add(i + 1);
		}
		for(ArrayList<Integer> l : map.values()){
						result.add(l);
				}

		return result;
	}
	public static void main(String[] args)
	{
		//Creating an Arraylist of the given input. All inputs should be in lower case
		System.out.println("\nFollowing words has been Inputted: \nlisten, pot, part, opt, trap, silent, top, this, hello, hits, what, shit \n");
		List<String> a = new ArrayList<String>();
		a.add("listen");
		a.add("pot");
		a.add("part");
		a.add("opt");
		a.add("trap");
		a.add("silent");
		a.add("top");
		a.add("this");
		a.add("hello");
		a.add("hits");
		a.add("what");
		a.add("shit");
		
		//Putting ArrayList into anagram function and outputting
		ArrayList<ArrayList<Integer>> result = anagram(a);
		System.out.println("***** Possible Anagrams Combinations *******");
		for(int i = 0; i < result.size(); i++)
		{
			System.out.print("[");
			for(int j : result.get(i))
				System.out.print(a.get(j-1) + ",");
			System.out.println("]");
		}
	}
}