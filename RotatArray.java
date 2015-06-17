/**
 *	逆时针旋转数组
 */
public class RotatArray{

	public static void main(String[] args) {
		
		String[][] data  = {{"1","2","3","4"},{"5","6","7","8"},{"9","10","11","12"}};

		String[][] result = RotatArray(data, 2);
		for (int i = 0; i < result.length; i++) {
			System.out.print("[\t");
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j]+"\t");
			}
			System.out.print("]");
			System.out.println();
		}
	}
	

	public static String[][] RotatArray(String[][] data,int num){
		
		String newArray[][] = {};
		
		if(num>0){
			int row = data.length-1;
			int col = data[0].length-1;
			newArray = new String[col+1][row+1];
			for (int i = 0; i <= col; i++) {
				for (int j = 0; j <= row; j++) {
					//重新编排数组
					newArray[i][j]= data[j][col-i];
				}
			}
			newArray = RotatArray(newArray, num-1);
		}else{
			return data;
		}
		
		return newArray;
	}
}