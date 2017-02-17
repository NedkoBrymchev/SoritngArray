
public class SortingArrayOfBooleans {
	
	public static void main(String[] args) {
		boolean[] array = {true,false,false,true,false,true,false,true,true,false,true};
		int counterTrue = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i]){
				counterTrue++;
			}
		}
		for (int i = 0; i < array.length; i++) {
			if(i < array.length - counterTrue){
				array[i] = false;
			}
			else{
				array[i] = true;
			}
			System.out.print(array[i] + ",");
		}
	}
}
