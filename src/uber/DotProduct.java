package uber;

import java.util.HashMap;

/*
 * ����sparse vector, ��dot product. sparse vector�ǳ��� ���ܶ���ram,
 * 1. find a data structure to store them
 * 2. find the dot product
 * link :  http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=193428&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
 * 
 * ���� ̫��� value,�Ǿ�external sorting��һ��һ���� 
 */
public class DotProduct {
	HashMap<Integer, Double> vector1 = new HashMap<Integer, Double>();
	HashMap<Integer, Double> vector2 = new HashMap<Integer, Double>();
	
	public double dotProduct(HashMap<Integer, Double> vector1, HashMap<Integer,Double> vector2) {
		double sum =0;
		if (vector1.size()>vector2.size()) {
			HashMap<Integer, Double> temp =  vector1;
			vector1 = vector2;
			vector2 = temp;
 		}
		
		for (int i:vector1.keySet()) {
			if (vector2.containsKey(i)) {
				sum+=vector1.get(i)*vector2.get(i);
			}
		}
		
		return sum;
	}
	
	
	public static void main(String[] args) {
		DotProduct q = new DotProduct();
		HashMap<Integer, Double> vector1= new HashMap<Integer, Double>();
		HashMap<Integer, Double> vector2 = new HashMap<Integer,Double>();
		vector1.put(3, 0.5);
		vector1.put(9, 0.75);
		vector1.put(6, 0.11);
		vector2.put(3, 0.60);
		vector2.put(4, 0.90);
		System.out.println(q.dotProduct(vector1, vector2));
	}
}
